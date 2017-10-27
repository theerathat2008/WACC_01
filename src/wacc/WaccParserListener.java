// Generated from WaccParser.g4 by ANTLR 4.4

    package WaccLexer;

import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link WaccParser}.
 */
public interface WaccParserListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link WaccParser#array_elem}.
	 * @param ctx the parse tree
	 */
	void enterArray_elem(@NotNull WaccParser.Array_elemContext ctx);
	/**
	 * Exit a parse tree produced by {@link WaccParser#array_elem}.
	 * @param ctx the parse tree
	 */
	void exitArray_elem(@NotNull WaccParser.Array_elemContext ctx);
	/**
	 * Enter a parse tree produced by {@link WaccParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterStat(@NotNull WaccParser.StatContext ctx);
	/**
	 * Exit a parse tree produced by {@link WaccParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitStat(@NotNull WaccParser.StatContext ctx);
	/**
	 * Enter a parse tree produced by {@link WaccParser#assign_lhs}.
	 * @param ctx the parse tree
	 */
	void enterAssign_lhs(@NotNull WaccParser.Assign_lhsContext ctx);
	/**
	 * Exit a parse tree produced by {@link WaccParser#assign_lhs}.
	 * @param ctx the parse tree
	 */
	void exitAssign_lhs(@NotNull WaccParser.Assign_lhsContext ctx);
	/**
	 * Enter a parse tree produced by {@link WaccParser#type2}.
	 * @param ctx the parse tree
	 */
	void enterType2(@NotNull WaccParser.Type2Context ctx);
	/**
	 * Exit a parse tree produced by {@link WaccParser#type2}.
	 * @param ctx the parse tree
	 */
	void exitType2(@NotNull WaccParser.Type2Context ctx);
	/**
	 * Enter a parse tree produced by {@link WaccParser#array_liter}.
	 * @param ctx the parse tree
	 */
	void enterArray_liter(@NotNull WaccParser.Array_literContext ctx);
	/**
	 * Exit a parse tree produced by {@link WaccParser#array_liter}.
	 * @param ctx the parse tree
	 */
	void exitArray_liter(@NotNull WaccParser.Array_literContext ctx);
	/**
	 * Enter a parse tree produced by {@link WaccParser#assign_rhs}.
	 * @param ctx the parse tree
	 */
	void enterAssign_rhs(@NotNull WaccParser.Assign_rhsContext ctx);
	/**
	 * Exit a parse tree produced by {@link WaccParser#assign_rhs}.
	 * @param ctx the parse tree
	 */
	void exitAssign_rhs(@NotNull WaccParser.Assign_rhsContext ctx);
	/**
	 * Enter a parse tree produced by {@link WaccParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(@NotNull WaccParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link WaccParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(@NotNull WaccParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link WaccParser#type}.
	 * @param ctx the parse tree
	 */
	void enterType(@NotNull WaccParser.TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link WaccParser#type}.
	 * @param ctx the parse tree
	 */
	void exitType(@NotNull WaccParser.TypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link WaccParser#pair_elem_type}.
	 * @param ctx the parse tree
	 */
	void enterPair_elem_type(@NotNull WaccParser.Pair_elem_typeContext ctx);
	/**
	 * Exit a parse tree produced by {@link WaccParser#pair_elem_type}.
	 * @param ctx the parse tree
	 */
	void exitPair_elem_type(@NotNull WaccParser.Pair_elem_typeContext ctx);
	/**
	 * Enter a parse tree produced by {@link WaccParser#param_list}.
	 * @param ctx the parse tree
	 */
	void enterParam_list(@NotNull WaccParser.Param_listContext ctx);
	/**
	 * Exit a parse tree produced by {@link WaccParser#param_list}.
	 * @param ctx the parse tree
	 */
	void exitParam_list(@NotNull WaccParser.Param_listContext ctx);
	/**
	 * Enter a parse tree produced by {@link WaccParser#arg_list}.
	 * @param ctx the parse tree
	 */
	void enterArg_list(@NotNull WaccParser.Arg_listContext ctx);
	/**
	 * Exit a parse tree produced by {@link WaccParser#arg_list}.
	 * @param ctx the parse tree
	 */
	void exitArg_list(@NotNull WaccParser.Arg_listContext ctx);
	/**
	 * Enter a parse tree produced by {@link WaccParser#base_type}.
	 * @param ctx the parse tree
	 */
	void enterBase_type(@NotNull WaccParser.Base_typeContext ctx);
	/**
	 * Exit a parse tree produced by {@link WaccParser#base_type}.
	 * @param ctx the parse tree
	 */
	void exitBase_type(@NotNull WaccParser.Base_typeContext ctx);
	/**
	 * Enter a parse tree produced by {@link WaccParser#func}.
	 * @param ctx the parse tree
	 */
	void enterFunc(@NotNull WaccParser.FuncContext ctx);
	/**
	 * Exit a parse tree produced by {@link WaccParser#func}.
	 * @param ctx the parse tree
	 */
	void exitFunc(@NotNull WaccParser.FuncContext ctx);
	/**
	 * Enter a parse tree produced by {@link WaccParser#param}.
	 * @param ctx the parse tree
	 */
	void enterParam(@NotNull WaccParser.ParamContext ctx);
	/**
	 * Exit a parse tree produced by {@link WaccParser#param}.
	 * @param ctx the parse tree
	 */
	void exitParam(@NotNull WaccParser.ParamContext ctx);
	/**
	 * Enter a parse tree produced by {@link WaccParser#pair_type}.
	 * @param ctx the parse tree
	 */
	void enterPair_type(@NotNull WaccParser.Pair_typeContext ctx);
	/**
	 * Exit a parse tree produced by {@link WaccParser#pair_type}.
	 * @param ctx the parse tree
	 */
	void exitPair_type(@NotNull WaccParser.Pair_typeContext ctx);
	/**
	 * Enter a parse tree produced by {@link WaccParser#pair_elem}.
	 * @param ctx the parse tree
	 */
	void enterPair_elem(@NotNull WaccParser.Pair_elemContext ctx);
	/**
	 * Exit a parse tree produced by {@link WaccParser#pair_elem}.
	 * @param ctx the parse tree
	 */
	void exitPair_elem(@NotNull WaccParser.Pair_elemContext ctx);
	/**
	 * Enter a parse tree produced by {@link WaccParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(@NotNull WaccParser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link WaccParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(@NotNull WaccParser.ExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link WaccParser#array_type}.
	 * @param ctx the parse tree
	 */
	void enterArray_type(@NotNull WaccParser.Array_typeContext ctx);
	/**
	 * Exit a parse tree produced by {@link WaccParser#array_type}.
	 * @param ctx the parse tree
	 */
	void exitArray_type(@NotNull WaccParser.Array_typeContext ctx);
}