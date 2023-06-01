// Generated from KostLang.g4 by ANTLR 4.13.0
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link KostLangParser}.
 */
public interface KostLangListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link KostLangParser#prog}.
	 * @param ctx the parse tree
	 */
	void enterProg(KostLangParser.ProgContext ctx);
	/**
	 * Exit a parse tree produced by {@link KostLangParser#prog}.
	 * @param ctx the parse tree
	 */
	void exitProg(KostLangParser.ProgContext ctx);
	/**
	 * Enter a parse tree produced by the {@code assign}
	 * labeled alternative in {@link KostLangParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterAssign(KostLangParser.AssignContext ctx);
	/**
	 * Exit a parse tree produced by the {@code assign}
	 * labeled alternative in {@link KostLangParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitAssign(KostLangParser.AssignContext ctx);
	/**
	 * Enter a parse tree produced by the {@code print}
	 * labeled alternative in {@link KostLangParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterPrint(KostLangParser.PrintContext ctx);
	/**
	 * Exit a parse tree produced by the {@code print}
	 * labeled alternative in {@link KostLangParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitPrint(KostLangParser.PrintContext ctx);
	/**
	 * Enter a parse tree produced by the {@code read}
	 * labeled alternative in {@link KostLangParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterRead(KostLangParser.ReadContext ctx);
	/**
	 * Exit a parse tree produced by the {@code read}
	 * labeled alternative in {@link KostLangParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitRead(KostLangParser.ReadContext ctx);
	/**
	 * Enter a parse tree produced by the {@code write}
	 * labeled alternative in {@link KostLangParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterWrite(KostLangParser.WriteContext ctx);
	/**
	 * Exit a parse tree produced by the {@code write}
	 * labeled alternative in {@link KostLangParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitWrite(KostLangParser.WriteContext ctx);
	/**
	 * Enter a parse tree produced by the {@code single0}
	 * labeled alternative in {@link KostLangParser#expr0}.
	 * @param ctx the parse tree
	 */
	void enterSingle0(KostLangParser.Single0Context ctx);
	/**
	 * Exit a parse tree produced by the {@code single0}
	 * labeled alternative in {@link KostLangParser#expr0}.
	 * @param ctx the parse tree
	 */
	void exitSingle0(KostLangParser.Single0Context ctx);
	/**
	 * Enter a parse tree produced by the {@code add}
	 * labeled alternative in {@link KostLangParser#expr0}.
	 * @param ctx the parse tree
	 */
	void enterAdd(KostLangParser.AddContext ctx);
	/**
	 * Exit a parse tree produced by the {@code add}
	 * labeled alternative in {@link KostLangParser#expr0}.
	 * @param ctx the parse tree
	 */
	void exitAdd(KostLangParser.AddContext ctx);
	/**
	 * Enter a parse tree produced by the {@code sub}
	 * labeled alternative in {@link KostLangParser#expr0}.
	 * @param ctx the parse tree
	 */
	void enterSub(KostLangParser.SubContext ctx);
	/**
	 * Exit a parse tree produced by the {@code sub}
	 * labeled alternative in {@link KostLangParser#expr0}.
	 * @param ctx the parse tree
	 */
	void exitSub(KostLangParser.SubContext ctx);
	/**
	 * Enter a parse tree produced by the {@code logicalop}
	 * labeled alternative in {@link KostLangParser#expr0}.
	 * @param ctx the parse tree
	 */
	void enterLogicalop(KostLangParser.LogicalopContext ctx);
	/**
	 * Exit a parse tree produced by the {@code logicalop}
	 * labeled alternative in {@link KostLangParser#expr0}.
	 * @param ctx the parse tree
	 */
	void exitLogicalop(KostLangParser.LogicalopContext ctx);
	/**
	 * Enter a parse tree produced by the {@code single1}
	 * labeled alternative in {@link KostLangParser#expr1}.
	 * @param ctx the parse tree
	 */
	void enterSingle1(KostLangParser.Single1Context ctx);
	/**
	 * Exit a parse tree produced by the {@code single1}
	 * labeled alternative in {@link KostLangParser#expr1}.
	 * @param ctx the parse tree
	 */
	void exitSingle1(KostLangParser.Single1Context ctx);
	/**
	 * Enter a parse tree produced by the {@code mult}
	 * labeled alternative in {@link KostLangParser#expr1}.
	 * @param ctx the parse tree
	 */
	void enterMult(KostLangParser.MultContext ctx);
	/**
	 * Exit a parse tree produced by the {@code mult}
	 * labeled alternative in {@link KostLangParser#expr1}.
	 * @param ctx the parse tree
	 */
	void exitMult(KostLangParser.MultContext ctx);
	/**
	 * Enter a parse tree produced by the {@code div}
	 * labeled alternative in {@link KostLangParser#expr1}.
	 * @param ctx the parse tree
	 */
	void enterDiv(KostLangParser.DivContext ctx);
	/**
	 * Exit a parse tree produced by the {@code div}
	 * labeled alternative in {@link KostLangParser#expr1}.
	 * @param ctx the parse tree
	 */
	void exitDiv(KostLangParser.DivContext ctx);
	/**
	 * Enter a parse tree produced by the {@code size}
	 * labeled alternative in {@link KostLangParser#expr1}.
	 * @param ctx the parse tree
	 */
	void enterSize(KostLangParser.SizeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code size}
	 * labeled alternative in {@link KostLangParser#expr1}.
	 * @param ctx the parse tree
	 */
	void exitSize(KostLangParser.SizeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code id}
	 * labeled alternative in {@link KostLangParser#expr2}.
	 * @param ctx the parse tree
	 */
	void enterId(KostLangParser.IdContext ctx);
	/**
	 * Exit a parse tree produced by the {@code id}
	 * labeled alternative in {@link KostLangParser#expr2}.
	 * @param ctx the parse tree
	 */
	void exitId(KostLangParser.IdContext ctx);
	/**
	 * Enter a parse tree produced by the {@code int}
	 * labeled alternative in {@link KostLangParser#expr2}.
	 * @param ctx the parse tree
	 */
	void enterInt(KostLangParser.IntContext ctx);
	/**
	 * Exit a parse tree produced by the {@code int}
	 * labeled alternative in {@link KostLangParser#expr2}.
	 * @param ctx the parse tree
	 */
	void exitInt(KostLangParser.IntContext ctx);
	/**
	 * Enter a parse tree produced by the {@code real}
	 * labeled alternative in {@link KostLangParser#expr2}.
	 * @param ctx the parse tree
	 */
	void enterReal(KostLangParser.RealContext ctx);
	/**
	 * Exit a parse tree produced by the {@code real}
	 * labeled alternative in {@link KostLangParser#expr2}.
	 * @param ctx the parse tree
	 */
	void exitReal(KostLangParser.RealContext ctx);
	/**
	 * Enter a parse tree produced by the {@code par}
	 * labeled alternative in {@link KostLangParser#expr2}.
	 * @param ctx the parse tree
	 */
	void enterPar(KostLangParser.ParContext ctx);
	/**
	 * Exit a parse tree produced by the {@code par}
	 * labeled alternative in {@link KostLangParser#expr2}.
	 * @param ctx the parse tree
	 */
	void exitPar(KostLangParser.ParContext ctx);
	/**
	 * Enter a parse tree produced by the {@code string}
	 * labeled alternative in {@link KostLangParser#expr2}.
	 * @param ctx the parse tree
	 */
	void enterString(KostLangParser.StringContext ctx);
	/**
	 * Exit a parse tree produced by the {@code string}
	 * labeled alternative in {@link KostLangParser#expr2}.
	 * @param ctx the parse tree
	 */
	void exitString(KostLangParser.StringContext ctx);
	/**
	 * Enter a parse tree produced by the {@code logicalelem}
	 * labeled alternative in {@link KostLangParser#expr3}.
	 * @param ctx the parse tree
	 */
	void enterLogicalelem(KostLangParser.LogicalelemContext ctx);
	/**
	 * Exit a parse tree produced by the {@code logicalelem}
	 * labeled alternative in {@link KostLangParser#expr3}.
	 * @param ctx the parse tree
	 */
	void exitLogicalelem(KostLangParser.LogicalelemContext ctx);
	/**
	 * Enter a parse tree produced by the {@code and}
	 * labeled alternative in {@link KostLangParser#expr3}.
	 * @param ctx the parse tree
	 */
	void enterAnd(KostLangParser.AndContext ctx);
	/**
	 * Exit a parse tree produced by the {@code and}
	 * labeled alternative in {@link KostLangParser#expr3}.
	 * @param ctx the parse tree
	 */
	void exitAnd(KostLangParser.AndContext ctx);
	/**
	 * Enter a parse tree produced by the {@code or}
	 * labeled alternative in {@link KostLangParser#expr3}.
	 * @param ctx the parse tree
	 */
	void enterOr(KostLangParser.OrContext ctx);
	/**
	 * Exit a parse tree produced by the {@code or}
	 * labeled alternative in {@link KostLangParser#expr3}.
	 * @param ctx the parse tree
	 */
	void exitOr(KostLangParser.OrContext ctx);
	/**
	 * Enter a parse tree produced by the {@code xor}
	 * labeled alternative in {@link KostLangParser#expr3}.
	 * @param ctx the parse tree
	 */
	void enterXor(KostLangParser.XorContext ctx);
	/**
	 * Exit a parse tree produced by the {@code xor}
	 * labeled alternative in {@link KostLangParser#expr3}.
	 * @param ctx the parse tree
	 */
	void exitXor(KostLangParser.XorContext ctx);
	/**
	 * Enter a parse tree produced by the {@code logical}
	 * labeled alternative in {@link KostLangParser#expr4}.
	 * @param ctx the parse tree
	 */
	void enterLogical(KostLangParser.LogicalContext ctx);
	/**
	 * Exit a parse tree produced by the {@code logical}
	 * labeled alternative in {@link KostLangParser#expr4}.
	 * @param ctx the parse tree
	 */
	void exitLogical(KostLangParser.LogicalContext ctx);
	/**
	 * Enter a parse tree produced by the {@code neg}
	 * labeled alternative in {@link KostLangParser#expr4}.
	 * @param ctx the parse tree
	 */
	void enterNeg(KostLangParser.NegContext ctx);
	/**
	 * Exit a parse tree produced by the {@code neg}
	 * labeled alternative in {@link KostLangParser#expr4}.
	 * @param ctx the parse tree
	 */
	void exitNeg(KostLangParser.NegContext ctx);
	/**
	 * Enter a parse tree produced by the {@code true}
	 * labeled alternative in {@link KostLangParser#bool}.
	 * @param ctx the parse tree
	 */
	void enterTrue(KostLangParser.TrueContext ctx);
	/**
	 * Exit a parse tree produced by the {@code true}
	 * labeled alternative in {@link KostLangParser#bool}.
	 * @param ctx the parse tree
	 */
	void exitTrue(KostLangParser.TrueContext ctx);
	/**
	 * Enter a parse tree produced by the {@code false}
	 * labeled alternative in {@link KostLangParser#bool}.
	 * @param ctx the parse tree
	 */
	void enterFalse(KostLangParser.FalseContext ctx);
	/**
	 * Exit a parse tree produced by the {@code false}
	 * labeled alternative in {@link KostLangParser#bool}.
	 * @param ctx the parse tree
	 */
	void exitFalse(KostLangParser.FalseContext ctx);
}