// Generated from VSLParser.g by ANTLR 4.7

  package TP2;

  import java.util.stream.Collectors;
  import java.util.Arrays;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link VSLParser}.
 */
public interface VSLParserListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link VSLParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(VSLParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link VSLParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(VSLParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link VSLParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(VSLParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link VSLParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(VSLParser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link VSLParser#factor}.
	 * @param ctx the parse tree
	 */
	void enterFactor(VSLParser.FactorContext ctx);
	/**
	 * Exit a parse tree produced by {@link VSLParser#factor}.
	 * @param ctx the parse tree
	 */
	void exitFactor(VSLParser.FactorContext ctx);
	/**
	 * Enter a parse tree produced by {@link VSLParser#primary}.
	 * @param ctx the parse tree
	 */
	void enterPrimary(VSLParser.PrimaryContext ctx);
	/**
	 * Exit a parse tree produced by {@link VSLParser#primary}.
	 * @param ctx the parse tree
	 */
	void exitPrimary(VSLParser.PrimaryContext ctx);
}