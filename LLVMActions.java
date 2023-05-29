
import java.util.HashMap;
import java.util.Stack;

enum VarType {
    INT, REAL, STRING, UNKNOWN
}

class Value {
    public String name;
    public VarType type;
    public int length;

    public Value(String name, VarType type, int length) {
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
        String ID = ctx.ID().getText();
        Value v = stack.pop();
        if (!variables.containsKey(ID)) {
            variables.put(ID, v);
            if (v.type == VarType.INT) {
                LLVMGenerator.declare_i32(ID);
            }
            if (v.type == VarType.STRING) {
                LLVMGenerator.declare_string(ID);
            }
            if (v.type == VarType.REAL) {
                LLVMGenerator.declare_double(ID);
            }
        }
        if (v.type == VarType.INT) {
            LLVMGenerator.assign_i32(ID, v.name);
        }
        if (v.type == VarType.REAL) {
            LLVMGenerator.assign_double(ID, v.name);
        }
        if (v.type == VarType.STRING) {
            LLVMGenerator.assign_string(ID);
        }
    }

    @Override
    public void enterIntarray(KostLangParser.IntarrayContext ctx) {
        String ID = ctx.ID().getText();
        if (!variables.containsKey(ID)) {
            variables.put(ID, new Value(ID, VarType.INT, 0));
            LLVMGenerator.declare_intarray(ID);
        }
        stack.push(new Value(ID, VarType.INT, 0));
    }

    @Override
    public void enterRealarray(KostLangParser.RealarrayContext ctx) {
        String ID = ctx.ID().getText();
        if (!variables.containsKey(ID)) {
            variables.put(ID, new Value(ID, VarType.REAL, 0));
            LLVMGenerator.declare_doublearray(ID);
        }
        stack.push(new Value(ID, VarType.REAL, 0));
    }

    @Override
    public void enterIntarr(KostLangParser.IntarrContext ctx) {
        Value array = stack.pop();
        int length = variables.get(array.name).length;
        if (length < 32) {
            LLVMGenerator.push_intarray(array.name, ctx.INT().getText(), length);
            length++;
            variables.get(array.name).length = length;
            stack.push(new Value(array.name, VarType.INT, length));
        } else {
            error(ctx.getStart().getLine(), "array out of bounds");
        }
    }

    @Override
    public void enterRealarr(KostLangParser.RealarrContext ctx) {
        Value array = stack.pop();
        int length = variables.get(array.name).length;
        if (length < 32) {
            LLVMGenerator.push_doublearray(array.name, ctx.REAL().getText(), length);
            length++;
            variables.get(array.name).length = length;
            stack.push(new Value(array.name, VarType.REAL, length));
        } else {
            error(ctx.getStart().getLine(), "array out of bounds");
        }
    }

    @Override
    public void exitPush(KostLangParser.PushContext ctx) {
        String ID = ctx.ID().getText();
        Value v = stack.pop();
        if (variables.containsKey(ID)) {
            if (variables.get(ID).type == v.type) {
                int length = variables.get(ID).length;              
                if (length < 32) {
                    if (v.type == VarType.INT) {
                        LLVMGenerator.push_intarray(ID, v.name, length);
                    }
                    else if (v.type == VarType.REAL) {
                        LLVMGenerator.push_doublearray(ID, v.name, length);
                    }
                    else {
                        error(ctx.getStart().getLine(), "push value type error");
                    }
                        length++;
                        variables.get(ID).length = length;
                    }   
                else {
                    error(ctx.getStart().getLine(), "array out of bounds");
                }
            }
            else {
                error(ctx.getStart().getLine(), "push type mismatch");
            }
        } else {
            error(ctx.getStart().getLine(), "unknown variable");
        }
    }

    @Override
    public void exitPop(KostLangParser.PopContext ctx) {
        String ID = ctx.ID().getText();
        if (variables.containsKey(ID)) {
            int length = variables.get(ID).length;
            if (length > 0) {
                if (variables.get(ID).type == VarType.INT) {
                    LLVMGenerator.push_intarray(ID, "0", length-1);
                }
                else{
                    LLVMGenerator.push_doublearray(ID, "0", length-1);
                }     
                length--;
                variables.get(ID).length = length;
            } else {
                error(ctx.getStart().getLine(), "array index out of bounds");
            }

        } else {
            error(ctx.getStart().getLine(), "unknown variable");
        }
    }

    @Override
    public void exitPopreturn(KostLangParser.PopreturnContext ctx) {
        String ID = ctx.ID().getText();
        if (variables.containsKey(ID)) {
            int length = variables.get(ID).length;
            if (length > 0) {
                if (variables.get(ID).type == VarType.INT) {
                    LLVMGenerator.get_intelement(ID, Integer.toString(length-1));
                    stack.push(new Value("%" + Integer.toString(LLVMGenerator.reg - 1), VarType.INT, 0));
                    LLVMGenerator.push_intarray(ID, "0", length-1);
                }
                else{
                    LLVMGenerator.get_doubleelement(ID, Integer.toString(length-1));
                    stack.push(new Value("%" + Integer.toString(LLVMGenerator.reg - 1), VarType.REAL, 0));
                    LLVMGenerator.push_doublearray(ID, "0.0", length-1);
                }     
                length--;
                variables.get(ID).length = length;
            } else {
                error(ctx.getStart().getLine(), "array index out of bounds");
            }

        } else {
            error(ctx.getStart().getLine(), "unknown variable");
        }
    }

    @Override
    public void exitGet(KostLangParser.GetContext ctx) {
        String ID = ctx.ID().getText();
        String number = ctx.INT().getText();
        if (variables.containsKey(ID)) {
            if (Integer.parseInt(ctx.INT().getText()) < variables.get(ID).length) {
                if (variables.get(ID).type == VarType.INT) {
                    LLVMGenerator.get_intelement(ID, number);
                    stack.push(new Value("%" + Integer.toString(LLVMGenerator.reg - 1), VarType.INT, 0));
                }
                else if (variables.get(ID).type == VarType.REAL) {
                    LLVMGenerator.get_doubleelement(ID, number);
                    stack.push(new Value("%" + Integer.toString(LLVMGenerator.reg - 1), VarType.REAL, 0));
                }                
                
            } else {
                error(ctx.getStart().getLine(), "array index out of bounds");
            }
        } else {
            error(ctx.getStart().getLine(), "unknown variable");
        }
    }

    @Override
    public void exitLength(KostLangParser.LengthContext ctx) {
        String ID = ctx.ID().getText();
        if (variables.containsKey(ID)) {
            stack.push(new Value(Integer.toString(variables.get(ID).length), VarType.INT, 0));
        } else {
            error(ctx.getStart().getLine(), "unknown variable");
        }
    }

    @Override
    public void exitId(KostLangParser.IdContext ctx) {
        String ID = ctx.ID().getText();
        if (variables.containsKey(ID)) {
            stack.push(new Value(variables.get(ID).name, VarType.INT, 0));
        }
    }

    @Override
    public void exitInt(KostLangParser.IntContext ctx) {
        stack.push(new Value(ctx.INT().getText(), VarType.INT, 0));
    }

    @Override
    public void exitReal(KostLangParser.RealContext ctx) {
        stack.push(new Value(ctx.REAL().getText(), VarType.REAL, 0));
    }

    @Override
    public void exitString(KostLangParser.StringContext ctx) {
        String tmp = ctx.STRING().getText();
        String content = tmp.substring(1, tmp.length() - 1);
        LLVMGenerator.constant_string(content);
        String n = "ptrstr" + (LLVMGenerator.str - 1);
        stack.push(new Value(n, VarType.STRING, content.length()));
    }

    @Override
    public void exitProg(KostLangParser.ProgContext ctx) {
        System.out.println(LLVMGenerator.generate());
    }

    @Override
    public void exitAdd(KostLangParser.AddContext ctx) {
        Value v2 = stack.pop();
        Value v1 = stack.pop();
        if (v1.type == v2.type) {
            if (v1.type == VarType.INT) {
                LLVMGenerator.add_i32(v1.name, v2.name);
                Value v = new Value("%" + (LLVMGenerator.reg - 1), VarType.INT, 0);
                stack.push(v);
            }
            if (v1.type == VarType.REAL) {
                LLVMGenerator.add_double(v1.name, v2.name);
                Value v = new Value("%" + (LLVMGenerator.reg - 1), VarType.REAL, 0);
                stack.push(v);
            }
            if (v1.type == VarType.STRING) {
                LLVMGenerator.add_string(v1.name, v1.length, v2.name, v2.length);
                Value v = new Value("%" + (LLVMGenerator.reg - 3), VarType.STRING, v1.length);
                stack.push(v);
            }
        } else {
            error(ctx.getStart().getLine(), "add type mismatch");
        }
    }

    @Override
    public void exitMult(KostLangParser.MultContext ctx) {
        Value v2 = stack.pop();
        Value v1 = stack.pop();
        if (v1.type == v2.type) {
            if (v1.type == VarType.INT) {
                LLVMGenerator.mult_i32(v1.name, v2.name);
                stack.push(new Value("%" + (LLVMGenerator.reg - 1), VarType.INT, 0));
            }
            if (v1.type == VarType.REAL) {
                LLVMGenerator.mult_double(v1.name, v2.name);
                stack.push(new Value("%" + (LLVMGenerator.reg - 1), VarType.REAL, 0));
            }
        } else {
            error(ctx.getStart().getLine(), "mult type mismatch");
        }
    }

    @Override
    public void exitDiv(KostLangParser.DivContext ctx) {
        Value v2 = stack.pop();
        Value v1 = stack.pop();
        if (v1.type == v2.type) {
            if (v1.type == VarType.INT) {
                LLVMGenerator.div_i32(v1.name, v2.name);
                stack.push(new Value("%" + (LLVMGenerator.reg - 1), VarType.INT, 0));
            }
            if (v1.type == VarType.REAL) {
                LLVMGenerator.div_double(v1.name, v2.name);
                stack.push(new Value("%" + (LLVMGenerator.reg - 1), VarType.REAL, 0));
            }
        } else {
            error(ctx.getStart().getLine(), "div type mismatch");
        }
    }

    @Override
    public void exitSub(KostLangParser.SubContext ctx) {
        Value v2 = stack.pop();
        Value v1 = stack.pop();
        if (v1.type == v2.type) {
            if (v1.type == VarType.INT) {
                LLVMGenerator.sub_i32(v1.name, v2.name);
                stack.push(new Value("%" + (LLVMGenerator.reg - 1), VarType.INT, 0));
            }
            if (v1.type == VarType.REAL) {
                LLVMGenerator.sub_double(v1.name, v2.name);
                stack.push(new Value("%" + (LLVMGenerator.reg - 1), VarType.REAL, 0));
            }
        } else {
            error(ctx.getStart().getLine(), "sub type mismatch");
        }
    }

    @Override
    public void exitPrint(KostLangParser.PrintContext ctx) {
        String ID = ctx.ID().getText();
        if (variables.containsKey(ID)) {
            Value v = variables.get(ID);
            if (v.type != null) {
                if (v.type == VarType.INT) {
                    LLVMGenerator.printf_i32(ID);
                }
                if (v.type == VarType.REAL) {
                    LLVMGenerator.printf_double(ID);
                }
                if (v.type == VarType.STRING) {
                    LLVMGenerator.printf_string(ID);
                }
            }
        } else {
            error(ctx.getStart().getLine(), "unknown variable");
        }
    }

    @Override
    public void exitRead(KostLangParser.ReadContext ctx) {
        String ID = ctx.ID().getText();
        Value v = new Value(ID, VarType.STRING, BUFFER_SIZE - 1);
        variables.put(ID, v);
        LLVMGenerator.scanf(ID, BUFFER_SIZE);
    }

    void error(int line, String msg) {
        System.err.println("Error, line " + line + ", " + msg);
        System.exit(1);
    }

}
