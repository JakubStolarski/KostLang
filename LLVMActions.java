
import java.util.HashMap;
import java.util.HashSet;
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
    HashSet<String> functions = new HashSet<String>();
    Stack<Value> stack = new Stack<Value>();
    static int BUFFER_SIZE = 16;
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

   //  @Override
   //  public void exitSingleparam(KostLangParser.SingleparamContext ctx) {
   //       String ID = ctx.ID().getText();
   //       String type = ctx.type().getText();
   //  }

    @Override
    public void exitFunction(KostLangParser.FunctionContext ctx){
         String ID = ctx.ID().getText();
         functions.add(ID);
         function = ID;
         LLVMGenerator.functionstart(ID);
    }

    @Override
    public void enterFblock(KostLangParser.FblockContext ctx){
         is_global = false;
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
      if( !variables.containsKey(ID) ) {
         error(ctx.getStart().getLine(), "unknown variable");
      }
      Value v = variables.get(ID);
      if( v.type == VarType.INT ){
         LLVMGenerator.load_i32(ID);
         stack.push( new Value("%"+(LLVMGenerator.reg-1), VarType.INT, 0) ); 
      }
      if( v.type == VarType.REAL ){
         LLVMGenerator.load_double(ID);
         stack.push( new Value("%"+(LLVMGenerator.reg-1), VarType.REAL, 0) );
      }
      if( v.type == VarType.STRING ){
         LLVMGenerator.load_string(ID);
         stack.push( new Value("%"+(LLVMGenerator.reg-1), VarType.STRING, v.length) );
      }
      if( v.type == VarType.BOOL){
         LLVMGenerator.load_bool(ID);
         stack.push( new Value("%"+(LLVMGenerator.reg-1), VarType.BOOL, 0) );
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
             System.out.println( v.name );
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
       System.out.println(ID);
       Value v = stack.pop();
       System.out.println(v);
       if( !variables.containsKey(ID) ) {
           variables.put(ID, v);
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
       if( v.type == VarType.INT ){
           LLVMGenerator.assign_i32(ID, v.name);
       }
       if( v.type == VarType.REAL ){
           LLVMGenerator.assign_double(ID, v.name);
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
       if( variables.containsKey(ID) ) {
          Value v = variables.get( ID );
          if( v.type != null ) {
             if( v.type == VarType.INT ){
                LLVMGenerator.printf_i32( ID );
             }
             if( v.type == VarType.REAL ){
                LLVMGenerator.printf_double( ID );
             }
             if( v.type == VarType.STRING ){
                LLVMGenerator.printf_string( ID );
             }
             if( v.type == VarType.BOOL ){
               LLVMGenerator.printf_bool(ID);
             }
          }  
       } else {
          error(ctx.getStart().getLine(), "unknown variable");
       }       
    } 
   @Override
   public void exitRead(KostLangParser.ReadContext ctx) {
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
