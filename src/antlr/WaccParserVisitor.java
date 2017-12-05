// Generated from ./WaccParser.g4 by ANTLR 4.7
package antlr;
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
	 * Visit a parse tree produced by {@link WaccParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(WaccParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link WaccParser#func}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunc(WaccParser.FuncContext ctx);
	/**
	 * Visit a parse tree produced by {@link WaccParser#param_list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParam_list(WaccParser.Param_listContext ctx);
	/**
	 * Visit a parse tree produced by {@link WaccParser#param}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParam(WaccParser.ParamContext ctx);
	/**
	 * Visit a parse tree produced by the {@code SKIP_STAT}
	 * labeled alternative in {@link WaccParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSKIP_STAT(WaccParser.SKIP_STATContext ctx);
	/**
	 * Visit a parse tree produced by the {@code READ_STAT}
	 * labeled alternative in {@link WaccParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitREAD_STAT(WaccParser.READ_STATContext ctx);
	/**
	 * Visit a parse tree produced by the {@code VAR_DECL_STAT}
	 * labeled alternative in {@link WaccParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVAR_DECL_STAT(WaccParser.VAR_DECL_STATContext ctx);
	/**
	 * Visit a parse tree produced by the {@code FREE_STAT}
	 * labeled alternative in {@link WaccParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFREE_STAT(WaccParser.FREE_STATContext ctx);
	/**
	 * Visit a parse tree produced by the {@code WHILE_STAT}
	 * labeled alternative in {@link WaccParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWHILE_STAT(WaccParser.WHILE_STATContext ctx);
	/**
	 * Visit a parse tree produced by the {@code SIDE_EFFECT}
	 * labeled alternative in {@link WaccParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSIDE_EFFECT(WaccParser.SIDE_EFFECTContext ctx);
	/**
	 * Visit a parse tree produced by the {@code MULT_STAT}
	 * labeled alternative in {@link WaccParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMULT_STAT(WaccParser.MULT_STATContext ctx);
	/**
	 * Visit a parse tree produced by the {@code EXIT_STAT}
	 * labeled alternative in {@link WaccParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEXIT_STAT(WaccParser.EXIT_STATContext ctx);
	/**
	 * Visit a parse tree produced by the {@code PRINTLN_STAT}
	 * labeled alternative in {@link WaccParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPRINTLN_STAT(WaccParser.PRINTLN_STATContext ctx);
	/**
	 * Visit a parse tree produced by the {@code BEGIN_END_STAT}
	 * labeled alternative in {@link WaccParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBEGIN_END_STAT(WaccParser.BEGIN_END_STATContext ctx);
	/**
	 * Visit a parse tree produced by the {@code IF_STAT}
	 * labeled alternative in {@link WaccParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIF_STAT(WaccParser.IF_STATContext ctx);
	/**
	 * Visit a parse tree produced by the {@code PRINT_STAT}
	 * labeled alternative in {@link WaccParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPRINT_STAT(WaccParser.PRINT_STATContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ASSIGN_STAT}
	 * labeled alternative in {@link WaccParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitASSIGN_STAT(WaccParser.ASSIGN_STATContext ctx);
	/**
	 * Visit a parse tree produced by the {@code RETURN_STAT}
	 * labeled alternative in {@link WaccParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRETURN_STAT(WaccParser.RETURN_STATContext ctx);
	/**
	 * Visit a parse tree produced by {@link WaccParser#thenstat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitThenstat(WaccParser.ThenstatContext ctx);
	/**
	 * Visit a parse tree produced by {@link WaccParser#elsestat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElsestat(WaccParser.ElsestatContext ctx);
	/**
	 * Visit a parse tree produced by the {@code IDENT_ASSIGN}
	 * labeled alternative in {@link WaccParser#assign_lhs}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIDENT_ASSIGN(WaccParser.IDENT_ASSIGNContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ARRAY_ELEM_LHS}
	 * labeled alternative in {@link WaccParser#assign_lhs}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitARRAY_ELEM_LHS(WaccParser.ARRAY_ELEM_LHSContext ctx);
	/**
	 * Visit a parse tree produced by the {@code PAIR_ELEM_LHS}
	 * labeled alternative in {@link WaccParser#assign_lhs}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPAIR_ELEM_LHS(WaccParser.PAIR_ELEM_LHSContext ctx);
	/**
	 * Visit a parse tree produced by the {@code EXPR_ASSIGN}
	 * labeled alternative in {@link WaccParser#assign_rhs}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEXPR_ASSIGN(WaccParser.EXPR_ASSIGNContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ARRAY_LITER_RHS}
	 * labeled alternative in {@link WaccParser#assign_rhs}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitARRAY_LITER_RHS(WaccParser.ARRAY_LITER_RHSContext ctx);
	/**
	 * Visit a parse tree produced by the {@code NEWPAIR_RHS}
	 * labeled alternative in {@link WaccParser#assign_rhs}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNEWPAIR_RHS(WaccParser.NEWPAIR_RHSContext ctx);
	/**
	 * Visit a parse tree produced by the {@code PAIR_ELEM_RHS}
	 * labeled alternative in {@link WaccParser#assign_rhs}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPAIR_ELEM_RHS(WaccParser.PAIR_ELEM_RHSContext ctx);
	/**
	 * Visit a parse tree produced by the {@code CALL_ASSIGN}
	 * labeled alternative in {@link WaccParser#assign_rhs}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCALL_ASSIGN(WaccParser.CALL_ASSIGNContext ctx);
	/**
	 * Visit a parse tree produced by the {@code PAIR_FST}
	 * labeled alternative in {@link WaccParser#pair_elem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPAIR_FST(WaccParser.PAIR_FSTContext ctx);
	/**
	 * Visit a parse tree produced by the {@code PAIR_SND}
	 * labeled alternative in {@link WaccParser#pair_elem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPAIR_SND(WaccParser.PAIR_SNDContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ARRAY_TYPE}
	 * labeled alternative in {@link WaccParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitARRAY_TYPE(WaccParser.ARRAY_TYPEContext ctx);
	/**
	 * Visit a parse tree produced by the {@code PAIR_TYPE}
	 * labeled alternative in {@link WaccParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPAIR_TYPE(WaccParser.PAIR_TYPEContext ctx);
	/**
	 * Visit a parse tree produced by the {@code BASE_TYPE}
	 * labeled alternative in {@link WaccParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBASE_TYPE(WaccParser.BASE_TYPEContext ctx);
	/**
	 * Visit a parse tree produced by the {@code BASE_TYPE_PAIR}
	 * labeled alternative in {@link WaccParser#pair_elem_type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBASE_TYPE_PAIR(WaccParser.BASE_TYPE_PAIRContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ARRAY_TYPE_PAIR}
	 * labeled alternative in {@link WaccParser#pair_elem_type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitARRAY_TYPE_PAIR(WaccParser.ARRAY_TYPE_PAIRContext ctx);
	/**
	 * Visit a parse tree produced by the {@code PAIR_STRING}
	 * labeled alternative in {@link WaccParser#pair_elem_type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPAIR_STRING(WaccParser.PAIR_STRINGContext ctx);
	/**
	 * Visit a parse tree produced by the {@code BOOL_LITER_EXPR}
	 * labeled alternative in {@link WaccParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBOOL_LITER_EXPR(WaccParser.BOOL_LITER_EXPRContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ENCLOSED_EXPR}
	 * labeled alternative in {@link WaccParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitENCLOSED_EXPR(WaccParser.ENCLOSED_EXPRContext ctx);
	/**
	 * Visit a parse tree produced by the {@code STR_LITER_EXPR}
	 * labeled alternative in {@link WaccParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSTR_LITER_EXPR(WaccParser.STR_LITER_EXPRContext ctx);
	/**
	 * Visit a parse tree produced by the {@code CHAR_LITER_EXPR}
	 * labeled alternative in {@link WaccParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCHAR_LITER_EXPR(WaccParser.CHAR_LITER_EXPRContext ctx);
	/**
	 * Visit a parse tree produced by the {@code PAIR_LITER_EXPR}
	 * labeled alternative in {@link WaccParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPAIR_LITER_EXPR(WaccParser.PAIR_LITER_EXPRContext ctx);
	/**
	 * Visit a parse tree produced by the {@code IDENT_EXPR}
	 * labeled alternative in {@link WaccParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIDENT_EXPR(WaccParser.IDENT_EXPRContext ctx);
	/**
	 * Visit a parse tree produced by the {@code SIDE_EFFECT_EXPR}
	 * labeled alternative in {@link WaccParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSIDE_EFFECT_EXPR(WaccParser.SIDE_EFFECT_EXPRContext ctx);
	/**
	 * Visit a parse tree produced by the {@code INT_LITER_EXPR}
	 * labeled alternative in {@link WaccParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitINT_LITER_EXPR(WaccParser.INT_LITER_EXPRContext ctx);
	/**
	 * Visit a parse tree produced by the {@code UNARY_OP_EXPR}
	 * labeled alternative in {@link WaccParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUNARY_OP_EXPR(WaccParser.UNARY_OP_EXPRContext ctx);
	/**
	 * Visit a parse tree produced by the {@code BINARY_OP_EXPR}
	 * labeled alternative in {@link WaccParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBINARY_OP_EXPR(WaccParser.BINARY_OP_EXPRContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ARRAY_ELEM_EXPR}
	 * labeled alternative in {@link WaccParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitARRAY_ELEM_EXPR(WaccParser.ARRAY_ELEM_EXPRContext ctx);
	/**
	 * Visit a parse tree produced by the {@code IDENT_PLUS_PLUS}
	 * labeled alternative in {@link WaccParser#side_effecting_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIDENT_PLUS_PLUS(WaccParser.IDENT_PLUS_PLUSContext ctx);
	/**
	 * Visit a parse tree produced by the {@code PLUS_PLUS_IDENT}
	 * labeled alternative in {@link WaccParser#side_effecting_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPLUS_PLUS_IDENT(WaccParser.PLUS_PLUS_IDENTContext ctx);
	/**
	 * Visit a parse tree produced by the {@code MINUS_MINUS_IDENT}
	 * labeled alternative in {@link WaccParser#side_effecting_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMINUS_MINUS_IDENT(WaccParser.MINUS_MINUS_IDENTContext ctx);
	/**
	 * Visit a parse tree produced by the {@code IDENT_MINUS_MINUS}
	 * labeled alternative in {@link WaccParser#side_effecting_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIDENT_MINUS_MINUS(WaccParser.IDENT_MINUS_MINUSContext ctx);
	/**
	 * Visit a parse tree produced by the {@code IDENT_PLUS_EQUALS}
	 * labeled alternative in {@link WaccParser#side_effecting_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIDENT_PLUS_EQUALS(WaccParser.IDENT_PLUS_EQUALSContext ctx);
	/**
	 * Visit a parse tree produced by the {@code IDENT_MINUS_EQUALS}
	 * labeled alternative in {@link WaccParser#side_effecting_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIDENT_MINUS_EQUALS(WaccParser.IDENT_MINUS_EQUALSContext ctx);
	/**
	 * Visit a parse tree produced by the {@code IDENT_EQUAL}
	 * labeled alternative in {@link WaccParser#side_effecting_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIDENT_EQUAL(WaccParser.IDENT_EQUALContext ctx);
	/**
	 * Visit a parse tree produced by the {@code IDENT_MULT_EQUALS}
	 * labeled alternative in {@link WaccParser#side_effecting_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIDENT_MULT_EQUALS(WaccParser.IDENT_MULT_EQUALSContext ctx);
	/**
	 * Visit a parse tree produced by the {@code IDENT_DIV_EQUALS}
	 * labeled alternative in {@link WaccParser#side_effecting_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIDENT_DIV_EQUALS(WaccParser.IDENT_DIV_EQUALSContext ctx);
	/**
	 * Visit a parse tree produced by {@link WaccParser#unaryOp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnaryOp(WaccParser.UnaryOpContext ctx);
	/**
	 * Visit a parse tree produced by {@link WaccParser#binaryOp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBinaryOp(WaccParser.BinaryOpContext ctx);
}