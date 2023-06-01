
import java.util.HashMap;
import java.util.Stack;

enum VarType{ INT, REAL, STRING, BOOL, UNKNOWN }

class Value{ 
	public String name;
	public VarType type;
   public int length;
	public Value( String name, VarType type , int length){
		this.name = name;
		this.type = type;
		this.length = length;
	}
}

public class LLVMActions extends KostLangBaseListener {
    
    HashMap<String, Value> variables = new HashMap<String, Value>();
    Stack<Value> stack = new Stack<Value>();
    static int BUFFER_SIZE = 16;

    @Override
    public void exitAssign(KostLangParser.AssignContext ctx) {
         System.out.println("Jestem w assign!");
        String ID = ctx.ID().getText();
        Value v = stack.pop();
        if( !variables.containsKey(ID) ) {
         System.out.println("Deklaruje zmienna!");
            variables.put(ID, v);
            if( v.type == VarType.INT ){
               System.out.println("Deklaruje INT!");
                LLVMGenerator.declare_i32(ID);
            }
            if( v.type == VarType.STRING ){
               System.out.println("Deklaruje STRING!");
                LLVMGenerator.declare_string(ID);
            }
            if( v.type == VarType.REAL ){
               System.out.println("Deklaruje REAL!");
                LLVMGenerator.declare_double(ID);
            }
            if( v.type == VarType.BOOL ){
                LLVMGenerator.declare_bool(ID);
            }
        }
        if( v.type == VarType.INT ){
         System.out.println("Wartosc INT!");
            LLVMGenerator.assign_i32(ID, v.name);
        }
        if( v.type == VarType.REAL ){
         System.out.println("Wartosc REAL!");
            LLVMGenerator.assign_double(ID, v.name);
        }
        if( v.type == VarType.STRING ){
         System.out.println("Wartosc STRING!");
            LLVMGenerator.assign_string(ID);
        }
        if( v.type == VarType.BOOL){
         System.out.println("Wartosc STRING!");
            LLVMGenerator.assign_bool(ID, v.name);
        }
    }

    @Override 
    public void exitInt(KostLangParser.IntContext ctx) { 
      System.out.println("JESTEM W INT!");
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
    public void exitProg(KostLangParser.ProgContext ctx) { 
       System.out.println( LLVMGenerator.generate() );
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
            System.out.println("TUTAJ!");
            System.out.println(v1.name);
            System.out.println(v2.name);
            LLVMGenerator.add_string(v1.name, v1.length, v2.name, v2.length);
            Value v = new Value("%"+(LLVMGenerator.reg-3), VarType.STRING, v1.length);
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
      System.out.println(v1.name);
      System.out.println(v2.name);
      if( v1.name == "1" && v1.name == v2.name ) {
         System.out.println("Pcham 1!");
         stack.push(new Value(v1.name, VarType.BOOL, 0));
      }
      else{
         System.out.println("Pcham 0!");
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
      System.out.println("JESTEM W SIZE!");
      Value v1 = stack.pop();
      System.out.println("WYJMUJE WARTOSC");
      stack.push(new Value(String.valueOf(v1.length), VarType.INT, 0));
   }
   void error(int line, String msg){
       System.err.println("Error, line "+line+", "+msg);
       System.exit(1);
   } 
       
}
