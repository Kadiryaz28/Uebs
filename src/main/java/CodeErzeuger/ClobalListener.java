// Generated from C:/Users/Kemal/IdeaProjects/Projekt/src/main/java/CodeErzeuger\Clobal.g4 by ANTLR 4.9.2
package CodeErzeuger;


import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link ClobalParser}.
 */
public interface ClobalListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link ClobalParser#file}.
	 * @param ctx the parse tree
	 */
	void enterFile(ClobalParser.FileContext ctx);
	/**
	 * Exit a parse tree produced by {@link ClobalParser#file}.
	 * @param ctx the parse tree
	 */
	void exitFile(ClobalParser.FileContext ctx);
	/**
	 * Enter a parse tree produced by {@link ClobalParser#functionDecl}.
	 * @param ctx the parse tree
	 */
	void enterFunctionDecl(ClobalParser.FunctionDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link ClobalParser#functionDecl}.
	 * @param ctx the parse tree
	 */
	void exitFunctionDecl(ClobalParser.FunctionDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link ClobalParser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(ClobalParser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link ClobalParser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(ClobalParser.BlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link ClobalParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterStat(ClobalParser.StatContext ctx);
	/**
	 * Exit a parse tree produced by {@link ClobalParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitStat(ClobalParser.StatContext ctx);
	/**
	 * Enter a parse tree produced by {@link ClobalParser#assignStat}.
	 * @param ctx the parse tree
	 */
	void enterAssignStat(ClobalParser.AssignStatContext ctx);
	/**
	 * Exit a parse tree produced by {@link ClobalParser#assignStat}.
	 * @param ctx the parse tree
	 */
	void exitAssignStat(ClobalParser.AssignStatContext ctx);
	/**
	 * Enter a parse tree produced by {@link ClobalParser#ifStat}.
	 * @param ctx the parse tree
	 */
	void enterIfStat(ClobalParser.IfStatContext ctx);
	/**
	 * Exit a parse tree produced by {@link ClobalParser#ifStat}.
	 * @param ctx the parse tree
	 */
	void exitIfStat(ClobalParser.IfStatContext ctx);
	/**
	 * Enter a parse tree produced by {@link ClobalParser#forStat}.
	 * @param ctx the parse tree
	 */
	void enterForStat(ClobalParser.ForStatContext ctx);
	/**
	 * Exit a parse tree produced by {@link ClobalParser#forStat}.
	 * @param ctx the parse tree
	 */
	void exitForStat(ClobalParser.ForStatContext ctx);
	/**
	 * Enter a parse tree produced by {@link ClobalParser#returnStat}.
	 * @param ctx the parse tree
	 */
	void enterReturnStat(ClobalParser.ReturnStatContext ctx);
	/**
	 * Exit a parse tree produced by {@link ClobalParser#returnStat}.
	 * @param ctx the parse tree
	 */
	void exitReturnStat(ClobalParser.ReturnStatContext ctx);
	/**
	 * Enter a parse tree produced by {@link ClobalParser#printStat}.
	 * @param ctx the parse tree
	 */
	void enterPrintStat(ClobalParser.PrintStatContext ctx);
	/**
	 * Exit a parse tree produced by {@link ClobalParser#printStat}.
	 * @param ctx the parse tree
	 */
	void exitPrintStat(ClobalParser.PrintStatContext ctx);
	/**
	 * Enter a parse tree produced by {@link ClobalParser#varDecl}.
	 * @param ctx the parse tree
	 */
	void enterVarDecl(ClobalParser.VarDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link ClobalParser#varDecl}.
	 * @param ctx the parse tree
	 */
	void exitVarDecl(ClobalParser.VarDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link ClobalParser#type}.
	 * @param ctx the parse tree
	 */
	void enterType(ClobalParser.TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link ClobalParser#type}.
	 * @param ctx the parse tree
	 */
	void exitType(ClobalParser.TypeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Neg}
	 * labeled alternative in {@link ClobalParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterNOT(ClobalParser.notContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Neg}
	 * labeled alternative in {@link ClobalParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitNOT(ClobalParser.notContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Not}
	 * labeled alternative in {@link ClobalParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterNot(ClobalParser.NotContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Not}
	 * labeled alternative in {@link ClobalParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitNot(ClobalParser.NotContext ctx);
	/**
	 * Enter a parse tree produced by the {@code IdExpr}
	 * labeled alternative in {@link ClobalParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterIDEXPR(ClobalParser.IdExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code IdExpr}
	 * labeled alternative in {@link ClobalParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitIDEXPR(ClobalParser.IdExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Brackets}
	 * labeled alternative in {@link ClobalParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterBRACKS(ClobalParser.BracketsContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Brackets}
	 * labeled alternative in {@link ClobalParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitBRACKS(ClobalParser.BracketsContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Mult}
	 * labeled alternative in {@link ClobalParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterMUL(ClobalParser.MultContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Mult}
	 * labeled alternative in {@link ClobalParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitMUL(ClobalParser.MultContext ctx);
	/**
	 * Enter a parse tree produced by the {@code AddSub}
	 * labeled alternative in {@link ClobalParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterADDSUB(ClobalParser.AddSubContext ctx);
	/**
	 * Exit a parse tree produced by the {@code AddSub}
	 * labeled alternative in {@link ClobalParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitADDSUB(ClobalParser.AddSubContext ctx);
	/**
	 * Enter a parse tree produced by the {@code CondOp}
	 * labeled alternative in {@link ClobalParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterCondOp(ClobalParser.CondOpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code CondOp}
	 * labeled alternative in {@link ClobalParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitCondOp(ClobalParser.CondOpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code IntExpr}
	 * labeled alternative in {@link ClobalParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterINTEXPR(ClobalParser.IntExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code IntExpr}
	 * labeled alternative in {@link ClobalParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitINTEXPR(ClobalParser.IntExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code IdBrack}
	 * labeled alternative in {@link ClobalParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterIDBRACKS(ClobalParser.IdBrackContext ctx);
	/**
	 * Exit a parse tree produced by the {@code IdBrack}
	 * labeled alternative in {@link ClobalParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitIDBRACKS(ClobalParser.IdBrackContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Comp}
	 * labeled alternative in {@link ClobalParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterCOMPARISION(ClobalParser.CompContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Comp}
	 * labeled alternative in {@link ClobalParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitCOMPARISION(ClobalParser.CompContext ctx);
}