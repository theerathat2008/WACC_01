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
	 * Visit a parse tree produced by the {@code PRINT}
	 * labeled alternative in {@link WaccParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPRINT(@NotNull WaccParser.PRINTContext ctx);
	/**
	 * Visit a parse tree produced by {@link WaccParser#array_elem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArray_elem(@NotNull WaccParser.Array_elemContext ctx);
	/**
	 * Visit a parse tree produced by the {@code NEWPAIR}
	 * labeled alternative in {@link WaccParser#assign_rhs}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNEWPAIR(@NotNull WaccParser.NEWPAIRContext ctx);
	/**
	 * Visit a parse tree produced by the {@code STR_LITER}
	 * labeled alternative in {@link WaccParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSTR_LITER(@NotNull WaccParser.STR_LITERContext ctx);
	/**
	 * Visit a parse tree produced by the {@code PAIR_LITER}
	 * labeled alternative in {@link WaccParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPAIR_LITER(@NotNull WaccParser.PAIR_LITERContext ctx);
	/**
	 * Visit a parse tree produced by {@link WaccParser#close_paren}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClose_paren(@NotNull WaccParser.Close_parenContext ctx);
	/**
	 * Visit a parse tree produced by {@link WaccParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(@NotNull WaccParser.ProgramContext ctx);
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
	 * Visit a parse tree produced by the {@code UNARY_OP}
	 * labeled alternative in {@link WaccParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUNARY_OP(@NotNull WaccParser.UNARY_OPContext ctx);
	/**
	 * Visit a parse tree produced by the {@code IF}
	 * labeled alternative in {@link WaccParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIF(@NotNull WaccParser.IFContext ctx);
	/**
	 * Visit a parse tree produced by the {@code BOOL_LITER}
	 * labeled alternative in {@link WaccParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBOOL_LITER(@NotNull WaccParser.BOOL_LITERContext ctx);
	/**
	 * Visit a parse tree produced by {@link WaccParser#array_liter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArray_liter(@NotNull WaccParser.Array_literContext ctx);
	/**
	 * Visit a parse tree produced by the {@code IDENT_EXPR}
	 * labeled alternative in {@link WaccParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIDENT_EXPR(@NotNull WaccParser.IDENT_EXPRContext ctx);
	/**
	 * Visit a parse tree produced by the {@code READ}
	 * labeled alternative in {@link WaccParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitREAD(@NotNull WaccParser.READContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ARRAY_ELEM}
	 * labeled alternative in {@link WaccParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitARRAY_ELEM(@NotNull WaccParser.ARRAY_ELEMContext ctx);
	/**
	 * Visit a parse tree produced by the {@code BEGIN_END}
	 * labeled alternative in {@link WaccParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBEGIN_END(@NotNull WaccParser.BEGIN_ENDContext ctx);
	/**
	 * Visit a parse tree produced by the {@code EXIT}
	 * labeled alternative in {@link WaccParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEXIT(@NotNull WaccParser.EXITContext ctx);
	/**
	 * Visit a parse tree produced by the {@code CALL}
	 * labeled alternative in {@link WaccParser#assign_rhs}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCALL(@NotNull WaccParser.CALLContext ctx);
	/**
	 * Visit a parse tree produced by the {@code PRINTLN}
	 * labeled alternative in {@link WaccParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPRINTLN(@NotNull WaccParser.PRINTLNContext ctx);
	/**
	 * Visit a parse tree produced by the {@code BINARY_OP}
	 * labeled alternative in {@link WaccParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBINARY_OP(@NotNull WaccParser.BINARY_OPContext ctx);
	/**
	 * Visit a parse tree produced by the {@code SEMI}
	 * labeled alternative in {@link WaccParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSEMI(@NotNull WaccParser.SEMIContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ASSIGN}
	 * labeled alternative in {@link WaccParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitASSIGN(@NotNull WaccParser.ASSIGNContext ctx);
	/**
	 * Visit a parse tree produced by the {@code FREE}
	 * labeled alternative in {@link WaccParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFREE(@NotNull WaccParser.FREEContext ctx);
	/**
	 * Visit a parse tree produced by the {@code RETURN}
	 * labeled alternative in {@link WaccParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRETURN(@NotNull WaccParser.RETURNContext ctx);
	/**
	 * Visit a parse tree produced by the {@code CLOSED_EXPR}
	 * labeled alternative in {@link WaccParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCLOSED_EXPR(@NotNull WaccParser.CLOSED_EXPRContext ctx);
	/**
	 * Visit a parse tree produced by {@link WaccParser#open_paren}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOpen_paren(@NotNull WaccParser.Open_parenContext ctx);
	/**
	 * Visit a parse tree produced by {@link WaccParser#param}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParam(@NotNull WaccParser.ParamContext ctx);
	/**
	 * Visit a parse tree produced by the {@code EXPR}
	 * labeled alternative in {@link WaccParser#assign_rhs}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEXPR(@NotNull WaccParser.EXPRContext ctx);
	/**
	 * Visit a parse tree produced by {@link WaccParser#pair_type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPair_type(@NotNull WaccParser.Pair_typeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code PAIR_FST}
	 * labeled alternative in {@link WaccParser#pair_elem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPAIR_FST(@NotNull WaccParser.PAIR_FSTContext ctx);
	/**
	 * Visit a parse tree produced by the {@code SKIP}
	 * labeled alternative in {@link WaccParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSKIP(@NotNull WaccParser.SKIPContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ARRAY_TYPE_PAIR}
	 * labeled alternative in {@link WaccParser#pair_elem_type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitARRAY_TYPE_PAIR(@NotNull WaccParser.ARRAY_TYPE_PAIRContext ctx);
	/**
	 * Visit a parse tree produced by the {@code EQUALS}
	 * labeled alternative in {@link WaccParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEQUALS(@NotNull WaccParser.EQUALSContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ARRAY_TYPE}
	 * labeled alternative in {@link WaccParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitARRAY_TYPE(@NotNull WaccParser.ARRAY_TYPEContext ctx);
	/**
	 * Visit a parse tree produced by the {@code CHAR_LITER}
	 * labeled alternative in {@link WaccParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCHAR_LITER(@NotNull WaccParser.CHAR_LITERContext ctx);
	/**
	 * Visit a parse tree produced by the {@code INT_LITER}
	 * labeled alternative in {@link WaccParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitINT_LITER(@NotNull WaccParser.INT_LITERContext ctx);
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
	 * Visit a parse tree produced by the {@code PAIR_SND}
	 * labeled alternative in {@link WaccParser#pair_elem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPAIR_SND(@NotNull WaccParser.PAIR_SNDContext ctx);
	/**
	 * Visit a parse tree produced by {@link WaccParser#func}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunc(@NotNull WaccParser.FuncContext ctx);
	/**
	 * Visit a parse tree produced by the {@code IDENT}
	 * labeled alternative in {@link WaccParser#assign_lhs}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIDENT(@NotNull WaccParser.IDENTContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ARRAY_LITER}
	 * labeled alternative in {@link WaccParser#assign_rhs}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitARRAY_LITER(@NotNull WaccParser.ARRAY_LITERContext ctx);
	/**
	 * Visit a parse tree produced by the {@code WHILE}
	 * labeled alternative in {@link WaccParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWHILE(@NotNull WaccParser.WHILEContext ctx);
	/**
	 * Visit a parse tree produced by the {@code PAIR_TYPE}
	 * labeled alternative in {@link WaccParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPAIR_TYPE(@NotNull WaccParser.PAIR_TYPEContext ctx);
	/**
	 * Visit a parse tree produced by the {@code BASE_TYPE}
	 * labeled alternative in {@link WaccParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBASE_TYPE(@NotNull WaccParser.BASE_TYPEContext ctx);
}