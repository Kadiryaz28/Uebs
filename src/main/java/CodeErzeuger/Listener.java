package CodeErzeuger;

import org.stringtemplate.v4.ST;
import org.stringtemplate.v4.STGroup;
import org.stringtemplate.v4.STGroupFile;

import java.util.Objects;
import java.util.HashMap;
import java.util.Stack;
import java.util.Map;

public class Listener extends ClobalBaseListener {
    STGroup st = new STGroupFile("C:\\Users\\Kemal\\IdeaProjects\\Projekt\\src\\main\\java\\CodeErzeuger\\StringTemplate.stg");
    public String ef = "ef";
    boolean checkElse = false;
    public String eb = "eb";
    int counter = 0;
    Map<String, Integer> globalV = new HashMap<>();
    public Stack<ST> stack = new Stack<>();

    @Override
    public void exitVarDecl(ClobalParser.VarDeclContext ctx) {
        String name = ctx.children.get(1).getText();
        globalV.put(name, globalV.size());
        if (!stack.isEmpty()) {
            stack.pop();
        }
        stack.push(st.getInstanceOf("globalVar").add("value", globalV.size()));

    }
    @Override
    public void enterFunctionDecl(ClobalParser.FunctionDeclContext ctx) {
        String name = ctx.getChild(1).getText();
        stack.push(st.getInstanceOf("function").add("fname", name));
    }
    @Override
    public void exitAssignStat(ClobalParser.AssignStatContext ctx) throws NullPointerException{
        int name = globalV.get(ctx.getChild(0).getText());
        stack.push(st.getInstanceOf("StatAssign").add("fname", name));
    }
    @Override
    public void exitPrintStat(ClobalParser.PrintStatContext ctx) {
        stack.push(st.getInstanceOf("StatPrint"));
    }
    @Override
    public void enterIfStat(ClobalParser.IfStatContext ctx) {
        if (ctx.elsestat != null) checkElse = true;
    }
    @Override
    public void exitIfStat(ClobalParser.IfStatContext ctx) {
        if (checkElse) {
            stack.push(st.getInstanceOf("elseBr")).add("contain", ef + counter);
        } else {
            stack.push(st.getInstanceOf("elseBr")).add("contain", eb + counter);
        }
        checkElse = false;
    }
    @Override
    public void exitReturnStat(ClobalParser.ReturnStatContext ctx) {
        stack.push(st.getInstanceOf("StatReturn"));
    }

    @Override
    public void enterStat(ClobalParser.StatContext ctx) {
        try {
            if (checkElse && ctx.parent.getChild(6) == ctx) {
                stack.push(st.getInstanceOf("br")).add("br", ef + counter);
                stack.push(st.getInstanceOf("elseBr")).add("contain", eb + counter);
            }
        } catch (NullPointerException ignored) {
        }
    }
    @Override
    public void exitINTEXPR(ClobalParser.IntExprContext ctx) {
        stack.push(st.getInstanceOf("Cons").add("v", ctx.getText()));
    }
    @Override
    public void exitIDEXPR(ClobalParser.IdExprContext ctx) {
        stack.push(st.getInstanceOf("global").add("v", globalV.get(ctx.getText())));
    }
    @Override
    public void exitADDSUB(ClobalParser.AddSubContext ctx) {
        if (Objects.equals(ctx.op.getText(), "-")) {
            stack.push(st.getInstanceOf("SUB"));
        } else {
            stack.push(st.getInstanceOf("ADD"));
        }
    }
    @Override
    public void exitMUL(ClobalParser.MultContext ctx) {
        stack.push(st.getInstanceOf("MUL"));
    }

    @Override
    public void exitNOT(ClobalParser.notContext ctx) {
        stack.push(st.getInstanceOf("Cons").add("v", -1));
        stack.push(st.getInstanceOf("MUL"));
    }
    @Override
    public void exitCOMPARISION(ClobalParser.CompContext ctx) {
        String branchname = eb + (++counter);
        switch (ctx.op.getText()) {
            case "!=" -> {
                stack.push(st.getInstanceOf("ieq"));
                stack.push(st.getInstanceOf("brt").add("br", branchname));
            }
            case "==" -> {
                stack.push(st.getInstanceOf("ieq"));
                stack.push(st.getInstanceOf("brf").add("br", branchname));
            }
            case ">" -> {
                stack.push(st.getInstanceOf("ilt"));
                stack.push(st.getInstanceOf("brt").add("br", branchname));
            }
            case "<" -> {
                stack.push(st.getInstanceOf("ilt"));
                stack.push(st.getInstanceOf("brf").add("br", branchname));
            }
        }
    }
    @Override
    public void enterIDBRACKS(ClobalParser.IdBrackContext ctx) {
        stack.push(st.getInstanceOf("callFunction")).add("cFunc", ctx.getChild(0).getText() + "()");
    }
}
