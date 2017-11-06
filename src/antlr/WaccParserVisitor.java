// Generated from ./WaccParser.g4 by ANTLR 4.4
package antlr;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link WaccParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface WaccParserVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by the {@code EXPR_ASSIGN}
	 * labeled alternative in {@link WaccParser#assign_rhs}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEXPR_ASSIGN(@NotNull WaccParser.EXPR_ASSIGNContext ctx);
	/**
	 * Visit a parse tree produced by the {@code VAR_DECL_STAT}
	 * labeled alternative in {@link WaccParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVAR_DECL_STAT(@NotNull WaccParser.VAR_DECL_STATContext ctx);
	/**
	 * Visit a parse tree produced by the {@code FREE_STAT}
	 * labeled alternative in {@link WaccParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFREE_STAT(@NotNull WaccParser.FREE_STATContext ctx);
	/**
	 * Visit a parse tree produced by {@link WaccParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(@NotNull WaccParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by the {@code PRINTLN_STAT}
	 * labeled alternative in {@link WaccParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPRINTLN_STAT(@NotNull WaccParser.PRINTLN_STATContext ctx);
	/**
	 * Visit a parse tree produced by the {@code BEGIN_END_STAT}
	 * labeled alternative in {@link WaccParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBEGIN_END_STAT(@NotNull WaccParser.BEGIN_END_STATContext ctx);
	/**
	 * Visit a parse tree produced by the {@code IF_STAT}
	 * labeled alternative in {@link WaccParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIF_STAT(@NotNull WaccParser.IF_STATContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ARRAY_ELEM_LHS}
	 * labeled alternative in {@link WaccParser#assign_lhs}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitARRAY_ELEM_LHS(@NotNull WaccParser.ARRAY_ELEM_LHSContext ctx);
	/**
	 * Visit a parse tree produced by the {@code PAIR_ELEM_LHS}
	 * labeled alternative in {@link WaccParser#assign_lhs}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPAIR_ELEM_LHS(@NotNull WaccParser.PAIR_ELEM_LHSContext ctx);
	/**
	 * Visit a parse tree produced by the {@code CALL_ASSIGN}
	 * labeled alternative in {@link WaccParser#assign_rhs}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCALL_ASSIGN(@NotNull WaccParser.CALL_ASSIGNContext ctx);
	/**
	 * Visit a parse tree produced by the {@code PAIR_STRING}
	 * labeled alternative in {@link WaccParser#pair_elem_type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPAIR_STRING(@NotNull WaccParser.PAIR_STRINGContext ctx);
	/**
	 * Visit a parse tree produced by the {@code PAIR_ELEM_RHS}
	 * labeled alternative in {@link WaccParser#assign_rhs}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPAIR_ELEM_RHS(@NotNull WaccParser.PAIR_ELEM_RHSContext ctx);
	/**
	 * Visit a parse tree produced by {@link WaccParser#param}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParam(@NotNull WaccParser.ParamContext ctx);
	/**
	 * Visit a parse tree produced by the {@code PAIR_FST}
	 * labeled alternative in {@link WaccParser#pair_elem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPAIR_FST(@NotNull WaccParser.PAIR_FSTContext ctx);
	/**
	 * Visit a parse tree produced by the {@code CHAR_LITER_EXPR}
	 * labeled alternative in {@link WaccParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCHAR_LITER_EXPR(@NotNull WaccParser.CHAR_LITER_EXPRContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ARRAY_TYPE_PAIR}
	 * labeled alternative in {@link WaccParser#pair_elem_type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitARRAY_TYPE_PAIR(@NotNull WaccParser.ARRAY_TYPE_PAIRContext ctx);
	/**
	 * Visit a parse tree produced by the {@code UNARY_OP_EXPR}
	 * labeled alternative in {@link WaccParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUNARY_OP_EXPR(@NotNull WaccParser.UNARY_OP_EXPRContext ctx);
	/**
	 * Visit a parse tree produced by the {@code BINARY_OP_EXPR}
	 * labeled alternative in {@link WaccParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBINARY_OP_EXPR(@NotNull WaccParser.BINARY_OP_EXPRContext ctx);
	/**
	 * Visit a parse tree produced by the {@code SKIP_STAT}
	 * labeled alternative in {@link WaccParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSKIP_STAT(@NotNull WaccParser.SKIP_STATContext ctx);
	/**
	 * Visit a parse tree produced by the {@code READ_STAT}
	 * labeled alternative in {@link WaccParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitREAD_STAT(@NotNull WaccParser.READ_STATContext ctx);
	/**
	 * Visit a parse tree produced by the {@code WHILE_STAT}
	 * labeled alternative in {@link WaccParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWHILE_STAT(@NotNull WaccParser.WHILE_STATContext ctx);
	/**
	 * Visit a parse tree produced by the {@code MULT_STAT}
	 * labeled alternative in {@link WaccParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMULT_STAT(@NotNull WaccParser.MULT_STATContext ctx);
	/**
	 * Visit a parse tree produced by the {@code NEWPAIR_RHS}
	 * labeled alternative in {@link WaccParser#assign_rhs}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNEWPAIR_RHS(@NotNull WaccParser.NEWPAIR_RHSContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ARRAY_TYPE}
	 * labeled alternative in {@link WaccParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitARRAY_TYPE(@NotNull WaccParser.ARRAY_TYPEContext ctx);
	/**
	 * Visit a parse tree produced by the {@code STR_LITER_EXPR}
	 * labeled alternative in {@link WaccParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSTR_LITER_EXPR(@NotNull WaccParser.STR_LITER_EXPRContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ARRAY_LITER_RHS}
	 * labeled alternative in {@link WaccParser#assign_rhs}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitARRAY_LITER_RHS(@NotNull WaccParser.ARRAY_LITER_RHSContext ctx);
	/**
	 * Visit a parse tree produced by the {@code EXIT_STAT}
	 * labeled alternative in {@link WaccParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEXIT_STAT(@NotNull WaccParser.EXIT_STATContext ctx);
	/**
	 * Visit a parse tree produced by the {@code IDENT_EXPR}
	 * labeled alternative in {@link WaccParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIDENT_EXPR(@NotNull WaccParser.IDENT_EXPRContext ctx);
	/**
	 * Visit a parse tree produced by {@link WaccParser#param_list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParam_list(@NotNull WaccParser.Param_listContext ctx);
	/**
	 * Visit a parse tree produced by {@link WaccParser#arg_list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArg_list(@NotNull WaccParser.Arg_listContext ctx);
	/**
	 * Visit a parse tree produced by the {@code BASE_TYPE_PAIR}
	 * labeled alternative in {@link WaccParser#pair_elem_type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBASE_TYPE_PAIR(@NotNull WaccParser.BASE_TYPE_PAIRContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ARRAY_ELEM_EXPR}
	 * labeled alternative in {@link WaccParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitARRAY_ELEM_EXPR(@NotNull WaccParser.ARRAY_ELEM_EXPRContext ctx);
	/**
	 * Visit a parse tree produced by the {@code PAIR_SND}
	 * labeled alternative in {@link WaccParser#pair_elem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPAIR_SND(@NotNull WaccParser.PAIR_SNDContext ctx);
	/**
	 * Visit a parse tree produced by the {@code BOOL_LITER_EXPR}
	 * labeled alternative in {@link WaccParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBOOL_LITER_EXPR(@NotNull WaccParser.BOOL_LITER_EXPRContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ENCLOSED_EXPR}
	 * labeled alternative in {@link WaccParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitENCLOSED_EXPR(@NotNull WaccParser.ENCLOSED_EXPRContext ctx);
	/**
	 * Visit a parse tree produced by {@link WaccParser#func}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunc(@NotNull WaccParser.FuncContext ctx);
	/**
	 * Visit a parse tree produced by the {@code PRINT_STAT}
	 * labeled alternative in {@link WaccParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPRINT_STAT(@NotNull WaccParser.PRINT_STATContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ASSIGN_STAT}
	 * labeled alternative in {@link WaccParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitASSIGN_STAT(@NotNull WaccParser.ASSIGN_STATContext ctx);
	/**
	 * Visit a parse tree produced by the {@code PAIR_TYPE}
	 * labeled alternative in {@link WaccParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPAIR_TYPE(@NotNull WaccParser.PAIR_TYPEContext ctx);
	/**
	 * Visit a parse tree produced by the {@code PAIR_LITER_EXPR}
	 * labeled alternative in {@link WaccParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPAIR_LITER_EXPR(@NotNull WaccParser.PAIR_LITER_EXPRContext ctx);
	/**
	 * Visit a parse tree produced by the {@code RETURN_STAT}
	 * labeled alternative in {@link WaccParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRETURN_STAT(@NotNull WaccParser.RETURN_STATContext ctx);
	/**
	 * Visit a parse tree produced by the {@code IDENT_ASSIGN}
	 * labeled alternative in {@link WaccParser#assign_lhs}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIDENT_ASSIGN(@NotNull WaccParser.IDENT_ASSIGNContext ctx);
	/**
	 * Visit a parse tree produced by the {@code INT_LITER_EXPR}
	 * labeled alternative in {@link WaccParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitINT_LITER_EXPR(@NotNull WaccParser.INT_LITER_EXPRContext ctx);
	/**
	 * Visit a parse tree produced by the {@code BASE_TYPE}
	 * labeled alternative in {@link WaccParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBASE_TYPE(@NotNull WaccParser.BASE_TYPEContext ctx);
}