// Generated from TurtleParser.g by ANTLR 4.7

package TP1;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({ "all", "warnings", "unchecked", "unused", "cast" })
public class TurtleParser extends Parser {
	static {
		RuntimeMetaData.checkVersion("4.7", RuntimeMetaData.VERSION);
	}

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache = new PredictionContextCache();
	public static final int WS = 1, ID = 2;
	public static final int RULE_doc = 0, RULE_sujet = 1, RULE_predicat = 2, RULE_objet = 3, RULE_objetTexte = 4,
			RULE_objetEntite = 5, RULE_texte = 6, RULE_entite = 7, RULE_ident = 8;
	public static final String[] ruleNames = { "doc", "sujet", "predicat", "objet", "objetTexte", "objetEntite",
			"texte", "entite", "ident" };

	private static final String[] _LITERAL_NAMES = {};
	private static final String[] _SYMBOLIC_NAMES = { null, "WS", "ID" };
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() {
		return "TurtleParser.g";
	}

	@Override
	public String[] getRuleNames() {
		return ruleNames;
	}

	@Override
	public String getSerializedATN() {
		return _serializedATN;
	}

	@Override
	public ATN getATN() {
		return _ATN;
	}

	public TurtleParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this, _ATN, _decisionToDFA, _sharedContextCache);
	}

	public static class DocContext extends ParserRuleContext {
		public SujetContext sujet() {
			return getRuleContext(SujetContext.class, 0);
		}

		public DocContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}

		@Override
		public int getRuleIndex() {
			return RULE_doc;
		}

		@Override
		public void enterRule(ParseTreeListener listener) {
			if (listener instanceof TurtleParserListener)
				((TurtleParserListener) listener).enterDoc(this);
		}

		@Override
		public void exitRule(ParseTreeListener listener) {
			if (listener instanceof TurtleParserListener)
				((TurtleParserListener) listener).exitDoc(this);
		}
	}

	public final DocContext doc() throws RecognitionException {
		DocContext _localctx = new DocContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_doc);
		try {
			enterOuterAlt(_localctx, 1);
			{
				setState(18);
				sujet();
			}
		} catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		} finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SujetContext extends ParserRuleContext {
		public EntiteContext entite() {
			return getRuleContext(EntiteContext.class, 0);
		}

		public List<PredicatContext> predicat() {
			return getRuleContexts(PredicatContext.class);
		}

		public PredicatContext predicat(int i) {
			return getRuleContext(PredicatContext.class, i);
		}

		public SujetContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}

		@Override
		public int getRuleIndex() {
			return RULE_sujet;
		}

		@Override
		public void enterRule(ParseTreeListener listener) {
			if (listener instanceof TurtleParserListener)
				((TurtleParserListener) listener).enterSujet(this);
		}

		@Override
		public void exitRule(ParseTreeListener listener) {
			if (listener instanceof TurtleParserListener)
				((TurtleParserListener) listener).exitSujet(this);
		}
	}

	public final SujetContext sujet() throws RecognitionException {
		SujetContext _localctx = new SujetContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_sujet);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
				{
					setState(20);
					entite();
					setState(24);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la == ID) {
						{
							{
								setState(21);
								predicat();
							}
						}
						setState(26);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
				}
			}
		} catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		} finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PredicatContext extends ParserRuleContext {
		public EntiteContext entite() {
			return getRuleContext(EntiteContext.class, 0);
		}

		public List<ObjetContext> objet() {
			return getRuleContexts(ObjetContext.class);
		}

		public ObjetContext objet(int i) {
			return getRuleContext(ObjetContext.class, i);
		}

		public PredicatContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}

		@Override
		public int getRuleIndex() {
			return RULE_predicat;
		}

		@Override
		public void enterRule(ParseTreeListener listener) {
			if (listener instanceof TurtleParserListener)
				((TurtleParserListener) listener).enterPredicat(this);
		}

		@Override
		public void exitRule(ParseTreeListener listener) {
			if (listener instanceof TurtleParserListener)
				((TurtleParserListener) listener).exitPredicat(this);
		}
	}

	public final PredicatContext predicat() throws RecognitionException {
		PredicatContext _localctx = new PredicatContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_predicat);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
				{
					setState(27);
					entite();
					setState(31);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input, 1, _ctx);
					while (_alt != 2 && _alt != org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER) {
						if (_alt == 1) {
							{
								{
									setState(28);
									objet();
								}
							}
						}
						setState(33);
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input, 1, _ctx);
					}
				}
			}
		} catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		} finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ObjetContext extends ParserRuleContext {
		public ObjetTexteContext objetTexte() {
			return getRuleContext(ObjetTexteContext.class, 0);
		}

		public ObjetEntiteContext objetEntite() {
			return getRuleContext(ObjetEntiteContext.class, 0);
		}

		public ObjetContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}

		@Override
		public int getRuleIndex() {
			return RULE_objet;
		}

		@Override
		public void enterRule(ParseTreeListener listener) {
			if (listener instanceof TurtleParserListener)
				((TurtleParserListener) listener).enterObjet(this);
		}

		@Override
		public void exitRule(ParseTreeListener listener) {
			if (listener instanceof TurtleParserListener)
				((TurtleParserListener) listener).exitObjet(this);
		}
	}

	public final ObjetContext objet() throws RecognitionException {
		ObjetContext _localctx = new ObjetContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_objet);
		try {
			setState(36);
			_errHandler.sync(this);
			switch (getInterpreter().adaptivePredict(_input, 2, _ctx)) {
			case 1:
				enterOuterAlt(_localctx, 1); {
				setState(34);
				objetTexte();
			}
				break;
			case 2:
				enterOuterAlt(_localctx, 2); {
				setState(35);
				objetEntite();
			}
				break;
			}
		} catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		} finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ObjetTexteContext extends ParserRuleContext {
		public TexteContext texte() {
			return getRuleContext(TexteContext.class, 0);
		}

		public ObjetTexteContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}

		@Override
		public int getRuleIndex() {
			return RULE_objetTexte;
		}

		@Override
		public void enterRule(ParseTreeListener listener) {
			if (listener instanceof TurtleParserListener)
				((TurtleParserListener) listener).enterObjetTexte(this);
		}

		@Override
		public void exitRule(ParseTreeListener listener) {
			if (listener instanceof TurtleParserListener)
				((TurtleParserListener) listener).exitObjetTexte(this);
		}
	}

	public final ObjetTexteContext objetTexte() throws RecognitionException {
		ObjetTexteContext _localctx = new ObjetTexteContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_objetTexte);
		try {
			enterOuterAlt(_localctx, 1);
			{
				setState(38);
				texte();
			}
		} catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		} finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ObjetEntiteContext extends ParserRuleContext {
		public EntiteContext entite() {
			return getRuleContext(EntiteContext.class, 0);
		}

		public ObjetEntiteContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}

		@Override
		public int getRuleIndex() {
			return RULE_objetEntite;
		}

		@Override
		public void enterRule(ParseTreeListener listener) {
			if (listener instanceof TurtleParserListener)
				((TurtleParserListener) listener).enterObjetEntite(this);
		}

		@Override
		public void exitRule(ParseTreeListener listener) {
			if (listener instanceof TurtleParserListener)
				((TurtleParserListener) listener).exitObjetEntite(this);
		}
	}

	public final ObjetEntiteContext objetEntite() throws RecognitionException {
		ObjetEntiteContext _localctx = new ObjetEntiteContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_objetEntite);
		try {
			enterOuterAlt(_localctx, 1);
			{
				setState(40);
				entite();
			}
		} catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		} finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TexteContext extends ParserRuleContext {
		public IdentContext ident() {
			return getRuleContext(IdentContext.class, 0);
		}

		public TexteContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}

		@Override
		public int getRuleIndex() {
			return RULE_texte;
		}

		@Override
		public void enterRule(ParseTreeListener listener) {
			if (listener instanceof TurtleParserListener)
				((TurtleParserListener) listener).enterTexte(this);
		}

		@Override
		public void exitRule(ParseTreeListener listener) {
			if (listener instanceof TurtleParserListener)
				((TurtleParserListener) listener).exitTexte(this);
		}
	}

	public final TexteContext texte() throws RecognitionException {
		TexteContext _localctx = new TexteContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_texte);
		try {
			enterOuterAlt(_localctx, 1);
			{
				setState(42);
				ident();
			}
		} catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		} finally {
			exitRule();
		}
		return _localctx;
	}

	public static class EntiteContext extends ParserRuleContext {
		public IdentContext ident() {
			return getRuleContext(IdentContext.class, 0);
		}

		public EntiteContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}

		@Override
		public int getRuleIndex() {
			return RULE_entite;
		}

		@Override
		public void enterRule(ParseTreeListener listener) {
			if (listener instanceof TurtleParserListener)
				((TurtleParserListener) listener).enterEntite(this);
		}

		@Override
		public void exitRule(ParseTreeListener listener) {
			if (listener instanceof TurtleParserListener)
				((TurtleParserListener) listener).exitEntite(this);
		}
	}

	public final EntiteContext entite() throws RecognitionException {
		EntiteContext _localctx = new EntiteContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_entite);
		try {
			enterOuterAlt(_localctx, 1);
			{
				setState(44);
				ident();
			}
		} catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		} finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IdentContext extends ParserRuleContext {
		public TerminalNode ID() {
			return getToken(TurtleParser.ID, 0);
		}

		public IdentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}

		@Override
		public int getRuleIndex() {
			return RULE_ident;
		}

		@Override
		public void enterRule(ParseTreeListener listener) {
			if (listener instanceof TurtleParserListener)
				((TurtleParserListener) listener).enterIdent(this);
		}

		@Override
		public void exitRule(ParseTreeListener listener) {
			if (listener instanceof TurtleParserListener)
				((TurtleParserListener) listener).exitIdent(this);
		}
	}

	public final IdentContext ident() throws RecognitionException {
		IdentContext _localctx = new IdentContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_ident);
		try {
			enterOuterAlt(_localctx, 1);
			{
				setState(46);
				match(ID);
			}
		} catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		} finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN = "\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\4\63\4\2\t\2\4\3"
			+ "\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\3\2\3\2\3"
			+ "\3\3\3\7\3\31\n\3\f\3\16\3\34\13\3\3\4\3\4\7\4 \n\4\f\4\16\4#\13\4\3\5"
			+ "\3\5\5\5\'\n\5\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3\n\2\2\13\2\4"
			+ "\6\b\n\f\16\20\22\2\2\2,\2\24\3\2\2\2\4\26\3\2\2\2\6\35\3\2\2\2\b&\3\2"
			+ "\2\2\n(\3\2\2\2\f*\3\2\2\2\16,\3\2\2\2\20.\3\2\2\2\22\60\3\2\2\2\24\25"
			+ "\5\4\3\2\25\3\3\2\2\2\26\32\5\20\t\2\27\31\5\6\4\2\30\27\3\2\2\2\31\34"
			+ "\3\2\2\2\32\30\3\2\2\2\32\33\3\2\2\2\33\5\3\2\2\2\34\32\3\2\2\2\35!\5"
			+ "\20\t\2\36 \5\b\5\2\37\36\3\2\2\2 #\3\2\2\2!\37\3\2\2\2!\"\3\2\2\2\"\7"
			+ "\3\2\2\2#!\3\2\2\2$\'\5\n\6\2%\'\5\f\7\2&$\3\2\2\2&%\3\2\2\2\'\t\3\2\2"
			+ "\2()\5\16\b\2)\13\3\2\2\2*+\5\20\t\2+\r\3\2\2\2,-\5\22\n\2-\17\3\2\2\2"
			+ "./\5\22\n\2/\21\3\2\2\2\60\61\7\4\2\2\61\23\3\2\2\2\5\32!&";
	public static final ATN _ATN = new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}