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
	 * Visit a parse tree produced by {@link WaccParser#array_elem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArray_elem(@NotNull WaccParser.Array_elemContext ctx);
	/**
	 * Visit a parse tree produced by {@link WaccParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStat(@NotNull WaccParser.StatContext ctx);
	/**
	 * Visit a parse tree produced by {@link WaccParser#assign_lhs}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssign_lhs(@NotNull WaccParser.Assign_lhsContext ctx);
	/**
	 * Visit a parse tree produced by {@link WaccParser#array_liter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArray_liter(@NotNull WaccParser.Array_literContext ctx);
	/**
	 * Visit a parse tree produced by {@link WaccParser#assign_rhs}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssign_rhs(@NotNull WaccParser.Assign_rhsContext ctx);
	/**
	 * Visit a parse tree produced by {@link WaccParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(@NotNull WaccParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link WaccParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType(@NotNull WaccParser.TypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link WaccParser#pair_elem_type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPair_elem_type(@NotNull WaccParser.Pair_elem_typeContext ctx);
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
	 * Visit a parse tree produced by {@link WaccParser#func}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunc(@NotNull WaccParser.FuncContext ctx);
	/**
	 * Visit a parse tree produced by {@link WaccParser#param}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParam(@NotNull WaccParser.ParamContext ctx);
	/**
	 * Visit a parse tree produced by {@link WaccParser#pair_type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPair_type(@NotNull WaccParser.Pair_typeContext ctx);
	/**
	 * Visit a parse tree produced by {@link WaccParser#pair_elem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPair_elem(@NotNull WaccParser.Pair_elemContext ctx);
	/**
	 * Visit a parse tree produced by {@link WaccParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpr(@NotNull WaccParser.ExprContext ctx);
}