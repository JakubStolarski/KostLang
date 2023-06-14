
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Stack;

enum VarType{ INT, REAL, STRING, BOOL, ID, UNKNOWN }

class Value{ 
	public String name;
	public VarType type;
   public int length;
   public boolean from_var;
	public Value( String name, VarType type , int length){
		this.name = name;
		this.type = type;
		this.length = length;
	}
}

public class LLVMActions extends KostLangBaseListener {
    
    HashMap<String, Value> variables = new HashMap<String, Value>();
    HashMap<String, Value> local_variables = new HashMap<String, Value>();
    HashMap<String, String> functions = new HashMap<String, String>();
    HashMap<String, Integer> function_param_num = new HashMap<String, Integer>();
    HashMap<String, String> parameters = new HashMap<String, String>();
    Stack<Value> stack = new Stack<Value>();
    static int BUFFER_SIZE = 16;
    static int param_num = 0;
    static int args_num = 0; 
    static int helper = 1;  // helper variables are declared and assigned to act as args for functions 
    String function;
    Boolean is_global;

    @Override
    public void enterProg(KostLangParser.ProgContext ctx){
         is_global = true;
    }

    @Override 
    public void exitProg(KostLangParser.ProgContext ctx) {
      LLVMGenerator.close_main(); 
       System.out.println( LLVMGenerator.generate() );
    }

    @Override
    public void exitInttype(KostLangParser.InttypeContext ctx){
      String ID = ctx.ID().getText();
      String type = ctx.INTTYPE().getText();
      functions.put(ID, "i32");
      function = ID;
    }

    @Override
    public void exitRealtype(KostLangParser.RealtypeContext ctx){
      String ID = ctx.ID().getText();
      String type = ctx.REALTYPE().getText();
      functions.put(ID, "double");
      function = ID;
    }

    @Override
    public void enterFblock(KostLangParser.FblockContext ctx){
      if (parameters.isEmpty()){
         LLVMGenerator.functionstart_1(function, functions.get(function));
         function_param_num.put(function, 0);
      }
      else{
         int param_num = parameters.size();
         LLVMGenerator.functionstart_2(function, functions.get(function));
         parameters.forEach((key,value) -> {
            LLVMGenerator.functionstart_params(key,value);
         });
         function_param_num.put(function, param_num);
         LLVMGenerator.buffer = (LLVMGenerator.buffer.substring(0, LLVMGenerator.buffer.length() - 2)); //remove comma after the last param
         parameters = new HashMap<String, String>();
      }
      LLVMGenerator.functionstart_end();
      is_global = false;
    }

    @Override
    public void exitCall(KostLangParser.CallContext ctx){
      String ID = ctx.ID().getText();
      if(functions.containsKey(ID)){
         int param_num = function_param_num.get(ID);
         if(!(args_num==param_num)){
            error(ctx.getStart().getLine(), "wrong number of arguments");
         }

         String[] argtypes = new String[args_num];
         for(int i=0; i < param_num; i++){
            String help_id = "helper"+helper;
            Value v = stack.pop();
            if( v.type == VarType.INT ){
               LLVMGenerator.declare_i32(help_id, false);
               LLVMGenerator.assign_i32(help_id, v.name, false);
               argtypes[i] = "i32*";
            }
            if( v.type == VarType.REAL ){
               LLVMGenerator.declare_double(help_id, false);
               LLVMGenerator.assign_double(help_id, v.name, false);
               argtypes[i] = "double*";
            }
            helper++;
         } 

         String type = functions.get(ID);
         LLVMGenerator.call(ID, type);
         // This script will read values given as arguments be they INT, REAL or ID and put them on the stack
         // Then those values will be taken from the stack, assigned to helper variables in a "backward" manner
         // and written as arguments in function call.
         for(int j = helper-1; j>helper-1-args_num; j--){  
            LLVMGenerator.call_params("helper"+j,argtypes[j-(helper-args_num)]);
         }
         if(args_num > 0){
            LLVMGenerator.buffer = (LLVMGenerator.buffer.substring(0, LLVMGenerator.buffer.length() - 2));
         }
         args_num =0; // clear args count for potential future use
         LLVMGenerator.close_call();

         if (type == "i32"){
            stack.push(new Value("%"+(LLVMGenerator.reg-1), VarType.INT, 0));
         }
         else if (type =="double"){
            stack.push(new Value("%"+(LLVMGenerator.reg-1), VarType.REAL, 0));
         }
      }
      else{
         error(ctx.getStart().getLine(), "unknown function");
      }
    }

    @Override 
    public void exitReturn(KostLangParser.ReturnContext ctx){
      Value v1 = stack.pop();
      if( v1.type == VarType.INT ){
         LLVMGenerator.ret_i32(v1.name); 
         Value v = new Value(null, VarType.INT, 0);
         stack.push(v);
      }
      if( v1.type == VarType.REAL ){
        LLVMGenerator.ret_double(v1.name); 
        Value v = new Value(null, VarType.REAL, 0);
        stack.push(v);
     }
     LLVMGenerator.functionend();
     local_variables = new HashMap<String, Value>();
     is_global = true;
   }

    @Override
    public void exitIntparam(KostLangParser.IntparamContext ctx){
      String ID =  ctx.ID().getText();
      String type = ctx.INTTYPE().getText();
      parameters.put(ID,"i32*");
      local_variables.put(ID,new Value(null, VarType.INT, 0));
      param_num++;
    }

    @Override
    public void exitRealparam(KostLangParser.RealparamContext ctx){
      String ID =  ctx.ID().getText();
      String type = ctx.REALTYPE().getText();
      parameters.put(ID,"double*");
      local_variables.put(ID,new Value(null, VarType.REAL, 0));
      param_num++;
    }

    @Override
    public void exitArgs(KostLangParser.ArgsContext ctx){
      args_num++;
    }

    @Override
    public void exitBlock(KostLangParser.BlockContext ctx){

    }

    @Override
    public void enterBlockif(KostLangParser.BlockifContext ctx){
      LLVMGenerator.ifstart();
    }

    @Override
    public void exitBlockif(KostLangParser.BlockifContext ctx){
      LLVMGenerator.ifend();
    }

    @Override 
    public void exitElsestat(KostLangParser.ElsestatContext ctx){
      LLVMGenerator.endelse();
    }

    @Override
    public void enterBlockwhile(KostLangParser.BlockwhileContext ctx){
      LLVMGenerator.whilestart();
    }

    @Override
    public void exitBlockwhile(KostLangParser.BlockwhileContext ctx){
      LLVMGenerator.whileexit();
    }

    @Override
    public void enterConditionwhile(KostLangParser.ConditionwhileContext ctx){
      LLVMGenerator.whilelabel();
    }

    @Override
    public void exitEquals(KostLangParser.EqualsContext ctx){
      Value v2 = stack.pop();
      Value v1 = stack.pop();
      if(v1.type != v2.type){
         error(ctx.getStart().getLine(), "condition type mismatch");
      }
      if(v1.type == VarType.INT){
         LLVMGenerator.icmp(v1.name, v2.name, "eq");
      }
      if(v1.type == VarType.REAL){
         LLVMGenerator.fcmp(v1.name, v2.name, "eq");
      }
    }

    @Override
    public void exitGe(KostLangParser.GeContext ctx){
      Value v2 = stack.pop();
      Value v1 = stack.pop();
      if(v1.type != v2.type){
         error(ctx.getStart().getLine(), "condition type mismatch");
      }
      if(v1.type == VarType.INT){
         LLVMGenerator.icmp(v1.name, v2.name, "sge");
      }
      if(v1.type == VarType.REAL){
         LLVMGenerator.fcmp(v1.name, v2.name, "oge");
      }
    }

    @Override
    public void exitLe(KostLangParser.LeContext ctx){
      Value v2 = stack.pop();
      Value v1 = stack.pop();
      if(v1.type != v2.type){
         error(ctx.getStart().getLine(), "condition type mismatch");
      }
      if(v1.type == VarType.INT){
         LLVMGenerator.icmp(v1.name, v2.name, "sle");
      }
      if(v1.type == VarType.REAL){
         LLVMGenerator.fcmp(v1.name, v2.name, "ole");
      }
    }

    @Override
    public void exitGreat(KostLangParser.GreatContext ctx){
      Value v2 = stack.pop();
      Value v1 = stack.pop();

      if(v1.type != v2.type){
         error(ctx.getStart().getLine(), "condition type mismatch");
      }
      if(v1.type == VarType.INT){
         LLVMGenerator.icmp(v1.name, v2.name, "sgt");
      }
      if(v1.type == VarType.REAL){
         LLVMGenerator.fcmp(v1.name, v2.name, "ogt");
      }
    }

    @Override
    public void exitLess(KostLangParser.LessContext ctx){
      Value v2 = stack.pop();
      Value v1 = stack.pop();
      if(v1.type != v2.type){
         error(ctx.getStart().getLine(), "condition type mismatch");
      }
      if(v1.type == VarType.INT){
         LLVMGenerator.icmp(v1.name, v2.name, "slt");
      }
      if(v1.type == VarType.REAL){
         LLVMGenerator.fcmp(v1.name, v2.name, "oolt");
      }
    }

    @Override 
    public void exitInt(KostLangParser.IntContext ctx) { 
         stack.push( new Value(ctx.INT().getText(), VarType.INT, 0) );       
    }

    @Override
    public void exitTrue(KostLangParser.TrueContext ctx) { 
         stack.push( new Value("1", VarType.BOOL, 0) );       
    }

    @Override
    public void exitFalse(KostLangParser.FalseContext ctx) { 
      stack.push( new Value("0", VarType.BOOL, 0) );       
   }   

    @Override 
    public void exitReal(KostLangParser.RealContext ctx) { 
         stack.push( new Value(ctx.REAL().getText(), VarType.REAL, 0) );       
    }

    @Override 
    public void exitString(KostLangParser.StringContext ctx) { 
        String tmp = ctx.STRING().getText(); 
        String content = tmp.substring(1, tmp.length()-1);
        LLVMGenerator.constant_string(content);
        String n = "ptrstr"+(LLVMGenerator.str-1);
        stack.push( new Value(n, VarType.STRING, content.length()) );       
    } 
    
    @Override
    public void exitId(KostLangParser.IdContext ctx){
      String ID = ctx.ID().getText();
      if( !variables.containsKey(ID) && !local_variables.containsKey(ID) && !functions.containsKey(ID)) {
         error(ctx.getStart().getLine(), "unknown variable");
      }
      if( variables.containsKey(ID) || local_variables.containsKey(ID)){
         Value v=null;
         if(variables.containsKey(ID) ){
            v = variables.get(ID);
         }
         if(local_variables.containsKey(ID)){
            v = local_variables.get(ID); 
         }
         if( v.type == VarType.INT ){
            LLVMGenerator.load_i32(ID, is_global);
            stack.push( new Value("%"+(LLVMGenerator.reg-1), VarType.INT, 0) ); 
         }
         if( v.type == VarType.REAL ){
            LLVMGenerator.load_double(ID, is_global);
            stack.push( new Value("%"+(LLVMGenerator.reg-1), VarType.REAL, 0) );
         }
         if( v.type == VarType.STRING ){
            LLVMGenerator.load_string(ID, is_global);
            stack.push( new Value("%"+(LLVMGenerator.reg-1), VarType.STRING, v.length) );
         }
         if( v.type == VarType.BOOL){
            LLVMGenerator.load_bool(ID, is_global);
            stack.push( new Value("%"+(LLVMGenerator.reg-1), VarType.BOOL, 0) );
         }
   }
  }
    
    @Override 
    public void exitAdd(KostLangParser.AddContext ctx) { 
       Value v2 = stack.pop();
       Value v1 = stack.pop();
       if( v1.type == v2.type ) {
	  if( v1.type == VarType.INT ){
             LLVMGenerator.add_i32(v1.name, v2.name); 
             Value v = new Value("%"+(LLVMGenerator.reg-1), VarType.INT, 0);
             stack.push(v);
          }
	  if( v1.type == VarType.REAL ){
            LLVMGenerator.add_double(v1.name, v2.name); 
            Value v = new Value("%"+(LLVMGenerator.reg-1), VarType.REAL, 0);
            stack.push(v);
         }
           if( v1.type == VarType.STRING ){
            LLVMGenerator.add_string(v1.name, v1.length, v2.name, v2.length);
            Value v = new Value("%"+(LLVMGenerator.reg-3), VarType.STRING, v1.length+v2.length);
            stack.push(v);
         }
       }
        else {
            error(ctx.getStart().getLine(), "add type mismatch");
        }
    }

    @Override 
    public void exitMult(KostLangParser.MultContext ctx) { 
       Value v2 = stack.pop();
       Value v1 = stack.pop();
       if( v1.type == v2.type ) {
	  if( v1.type == VarType.INT ){
             LLVMGenerator.mult_i32(v1.name, v2.name); 
             stack.push( new Value("%"+(LLVMGenerator.reg-1), VarType.INT, 0) ); 
          }
	  if( v1.type == VarType.REAL ){
             LLVMGenerator.mult_double(v1.name, v2.name); 
             stack.push( new Value("%"+(LLVMGenerator.reg-1), VarType.REAL, 0) ); 
         }
       } else {
          error(ctx.getStart().getLine(), "mult type mismatch");
       }
    }

    @Override 
    public void exitDiv(KostLangParser.DivContext ctx) { 
       Value v2 = stack.pop();
       Value v1 = stack.pop();
       if( v1.type == v2.type ) {
	  if( v1.type == VarType.INT ){
             LLVMGenerator.div_i32(v1.name, v2.name); 
             stack.push( new Value("%"+(LLVMGenerator.reg-1), VarType.INT, 0) ); 
          }
	  if( v1.type == VarType.REAL ){
             LLVMGenerator.div_double(v1.name, v2.name); 
             stack.push( new Value("%"+(LLVMGenerator.reg-1), VarType.REAL, 0) ); 
         }
       } else {
          error(ctx.getStart().getLine(), "div type mismatch");
       }
    }

    @Override 
    public void exitSub(KostLangParser.SubContext ctx) { 
       Value v2 = stack.pop();
       Value v1 = stack.pop();
       if( v1.type == v2.type ) {
	  if( v1.type == VarType.INT ){
             LLVMGenerator.sub_i32(v1.name, v2.name); 
             stack.push( new Value("%"+(LLVMGenerator.reg-1), VarType.INT, 0) ); 
          }
	  if( v1.type == VarType.REAL ){
             LLVMGenerator.sub_double(v1.name, v2.name); 
             stack.push( new Value("%"+(LLVMGenerator.reg-1), VarType.REAL, 0) ); 
         }
       } else {
          error(ctx.getStart().getLine(), "sub type mismatch");
       }
    }
    
    @Override
    public void exitAnd(KostLangParser.AndContext ctx){
      Value v2 = stack.pop();
      Value v1 = stack.pop();
      if( v1.name == "1" && v1.name == v2.name ) {
         stack.push(new Value(v1.name, VarType.BOOL, 0));
      }
      else{
         stack.push(new Value("0", VarType.BOOL, 0));
      }

    }

    @Override
    public void exitOr(KostLangParser.OrContext ctx){
      Value v2 = stack.pop();
      Value v1 = stack.pop();
      if( v1.name == v2.name ) {
         stack.push(new Value(v1.name, VarType.BOOL, 0));
      }
      else{
         stack.push(new Value("1", VarType.BOOL, 0));
      }

    }

    @Override
    public void exitXor(KostLangParser.XorContext ctx){
      Value v2 = stack.pop();
      Value v1 = stack.pop();
      if( v1.name == v2.name ) {
         stack.push(new Value("0", VarType.BOOL, 0));
      }
      else{
         stack.push(new Value("1", VarType.BOOL, 0));
      }

    }

   @Override
   public void exitNeg(KostLangParser.NegContext ctx){
      Value v = stack.pop();
      if( v.name == "1" ){
         stack.push(new Value("0", v.type, 0));
      }
      else{
         stack.push(new Value("1", v.type, 0));
      }
   }

   @Override
   public void exitAssign(KostLangParser.AssignContext ctx) {
       String ID = ctx.ID().getText();
       Value v = stack.pop();
       Boolean addresing_global = false;
       if( !variables.containsKey(ID) && !local_variables.containsKey(ID)) {
         if (is_global){
            variables.put(ID, v);
         }
         else{
            local_variables.put(ID,v);
         }
          
           if( v.type == VarType.INT ){
               LLVMGenerator.declare_i32(ID, is_global);
           }
           if( v.type == VarType.STRING ){
               LLVMGenerator.declare_string(ID, is_global);
           }
           if( v.type == VarType.REAL ){
               LLVMGenerator.declare_double(ID, is_global);
           }
           if( v.type == VarType.BOOL ){
               LLVMGenerator.declare_bool(ID, is_global);
           }
       }
      if (variables.containsKey(ID)){
         addresing_global = true;
      }
       if( v.type == VarType.INT ){
            if(v.name == null){
               LLVMGenerator.assign_i32(ID, Integer.toString(LLVMGenerator.reg-1), addresing_global);
            }
           LLVMGenerator.assign_i32(ID, v.name, addresing_global);
       }
       if( v.type == VarType.REAL ){
         if(v.name == null){
            LLVMGenerator.assign_double(ID, "%"+Integer.toString(LLVMGenerator.reg-1), addresing_global);
         }
           LLVMGenerator.assign_double(ID, v.name, addresing_global);
       }
       if( v.type == VarType.STRING ){
           LLVMGenerator.assign_string(ID);
       }
       if( v.type == VarType.BOOL){
           LLVMGenerator.assign_bool(ID, v.name);
       }
   }

    @Override
    public void exitPrint(KostLangParser.PrintContext ctx) {
       String ID = ctx.ID().getText();
       if( variables.containsKey(ID) || local_variables.containsKey(ID)) {
         Boolean addresing_global = false;
         Value v = null;
         if (variables.containsKey(ID)){
            v = variables.get( ID );
            addresing_global = true;
         }
         else{
            v = local_variables.get( ID );
         }
          
          if( v.type != null) {
             if( v.type == VarType.INT ){
                LLVMGenerator.printf_i32( ID, addresing_global );
             }
             if( v.type == VarType.REAL ){
                LLVMGenerator.printf_double( ID, addresing_global );
             }
             if( v.type == VarType.STRING ){
                LLVMGenerator.printf_string( ID, addresing_global );
             }
             if( v.type == VarType.BOOL ){
               LLVMGenerator.printf_bool(ID, addresing_global);
             }
          }  
       } else {
          error(ctx.getStart().getLine(), "unknown variable");
       }       
    } 
   @Override
   public void exitRead(KostLangParser.ReadContext ctx) { //fix scanf for int and float
      String ID = ctx.ID().getText();
      Value v = new Value(ID, VarType.STRING, BUFFER_SIZE-1);
      variables.put(ID, v);
         LLVMGenerator.scanf(ID, BUFFER_SIZE);
   }

   @Override
   public void exitSize(KostLangParser.SizeContext ctx){
      Value v1 = stack.pop();
      stack.push(new Value(String.valueOf(v1.length), VarType.INT, 0));
   }

   void error(int line, String msg){
       System.err.println("Error, line "+line+", "+msg);
       System.exit(1);
   } 
       
}
