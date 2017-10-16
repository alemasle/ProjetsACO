// Generated from .\TurtleParser.g by ANTLR 4.7

  package TP1;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link TurtleParser}.
 */
public interface TurtleParserListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link TurtleParser#document}.
	 * @param ctx the parse tree
	 */
	void enterDocument(TurtleParser.DocumentContext ctx);
	/**
	 * Exit a parse tree produced by {@link TurtleParser#document}.
	 * @param ctx the parse tree
	 */
	void exitDocument(TurtleParser.DocumentContext ctx);
	/**
	 * Enter a parse tree produced by {@link TurtleParser#sujet}.
	 * @param ctx the parse tree
	 */
	void enterSujet(TurtleParser.SujetContext ctx);
	/**
	 * Exit a parse tree produced by {@link TurtleParser#sujet}.
	 * @param ctx the parse tree
	 */
	void exitSujet(TurtleParser.SujetContext ctx);
	/**
	 * Enter a parse tree produced by {@link TurtleParser#predicat}.
	 * @param ctx the parse tree
	 */
	void enterPredicat(TurtleParser.PredicatContext ctx);
	/**
	 * Exit a parse tree produced by {@link TurtleParser#predicat}.
	 * @param ctx the parse tree
	 */
	void exitPredicat(TurtleParser.PredicatContext ctx);
	/**
	 * Enter a parse tree produced by {@link TurtleParser#objet}.
	 * @param ctx the parse tree
	 */
	void enterObjet(TurtleParser.ObjetContext ctx);
	/**
	 * Exit a parse tree produced by {@link TurtleParser#objet}.
	 * @param ctx the parse tree
	 */
	void exitObjet(TurtleParser.ObjetContext ctx);
	/**
	 * Enter a parse tree produced by {@link TurtleParser#objetTexte}.
	 * @param ctx the parse tree
	 */
	void enterObjetTexte(TurtleParser.ObjetTexteContext ctx);
	/**
	 * Exit a parse tree produced by {@link TurtleParser#objetTexte}.
	 * @param ctx the parse tree
	 */
	void exitObjetTexte(TurtleParser.ObjetTexteContext ctx);
	/**
	 * Enter a parse tree produced by {@link TurtleParser#objetEntite}.
	 * @param ctx the parse tree
	 */
	void enterObjetEntite(TurtleParser.ObjetEntiteContext ctx);
	/**
	 * Exit a parse tree produced by {@link TurtleParser#objetEntite}.
	 * @param ctx the parse tree
	 */
	void exitObjetEntite(TurtleParser.ObjetEntiteContext ctx);
	/**
	 * Enter a parse tree produced by {@link TurtleParser#texte}.
	 * @param ctx the parse tree
	 */
	void enterTexte(TurtleParser.TexteContext ctx);
	/**
	 * Exit a parse tree produced by {@link TurtleParser#texte}.
	 * @param ctx the parse tree
	 */
	void exitTexte(TurtleParser.TexteContext ctx);
	/**
	 * Enter a parse tree produced by {@link TurtleParser#entite}.
	 * @param ctx the parse tree
	 */
	void enterEntite(TurtleParser.EntiteContext ctx);
	/**
	 * Exit a parse tree produced by {@link TurtleParser#entite}.
	 * @param ctx the parse tree
	 */
	void exitEntite(TurtleParser.EntiteContext ctx);
	/**
	 * Enter a parse tree produced by {@link TurtleParser#ident}.
	 * @param ctx the parse tree
	 */
	void enterIdent(TurtleParser.IdentContext ctx);
	/**
	 * Exit a parse tree produced by {@link TurtleParser#ident}.
	 * @param ctx the parse tree
	 */
	void exitIdent(TurtleParser.IdentContext ctx);
}