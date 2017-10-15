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

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class TurtleParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		WS=1, ID=2;
	public static final int
		RULE_document = 0, RULE_sujet = 1, RULE_predicat = 2, RULE_objet = 3, 
		RULE_objetTexte = 4, RULE_objetEntite = 5, RULE_texte = 6, RULE_entite = 7, 
		RULE_ident = 8;
	public static final String[] ruleNames = {
		"document", "sujet", "predicat", "objet", "objetTexte", "objetEntite", 
		"texte", "entite", "ident"
	};

	private static final String[] _LITERAL_NAMES = {
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "WS", "ID"
	};
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
	public String getGrammarFileName() { return "TurtleParser.g"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public TurtleParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class DocumentContext extends ParserRuleContext {
		public ASD.Document out;
		public SujetContext s;
		public TerminalNode EOF() { return getToken(TurtleParser.EOF, 0); }
		public SujetContext sujet() {
			return getRuleContext(SujetContext.class,0);
		}
		public DocumentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_document; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TurtleParserListener ) ((TurtleParserListener)listener).enterDocument(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TurtleParserListener ) ((TurtleParserListener)listener).exitDocument(this);
		}
	}

	public final DocumentContext document() throws RecognitionException {
		DocumentContext _localctx = new DocumentContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_document);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(18);
			((DocumentContext)_localctx).s = sujet();
			setState(19);
			match(EOF);
			List<ASD.Document.Sujet> tl = new ArrayList<ASD.Document.Sujet>(); tl.add(((DocumentContext)_localctx).s.out); ((DocumentContext)_localctx).out =  new ASD.Document(tl);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SujetContext extends ParserRuleContext {
		public ASD.Document.Sujet out;
		public EntiteContext e;
		public PredicatContext lp;
		public EntiteContext entite() {
			return getRuleContext(EntiteContext.class,0);
		}
		public PredicatContext predicat() {
			return getRuleContext(PredicatContext.class,0);
		}
		public SujetContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sujet; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TurtleParserListener ) ((TurtleParserListener)listener).enterSujet(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TurtleParserListener ) ((TurtleParserListener)listener).exitSujet(this);
		}
	}

	public final SujetContext sujet() throws RecognitionException {
		SujetContext _localctx = new SujetContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_sujet);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(22);
			((SujetContext)_localctx).e = entite();
			setState(23);
			((SujetContext)_localctx).lp = predicat();
			List<ASD.Document.Predicat> pred = new ArrayList<ASD.Document.Predicat>(); pred.add(((SujetContext)_localctx).lp.out); ((SujetContext)_localctx).out =  new ASD.Document.Sujet(((SujetContext)_localctx).e.out, pred);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PredicatContext extends ParserRuleContext {
		public ASD.Document.Predicat out;
		public EntiteContext e;
		public ObjetContext lo;
		public EntiteContext entite() {
			return getRuleContext(EntiteContext.class,0);
		}
		public ObjetContext objet() {
			return getRuleContext(ObjetContext.class,0);
		}
		public PredicatContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_predicat; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TurtleParserListener ) ((TurtleParserListener)listener).enterPredicat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TurtleParserListener ) ((TurtleParserListener)listener).exitPredicat(this);
		}
	}

	public final PredicatContext predicat() throws RecognitionException {
		PredicatContext _localctx = new PredicatContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_predicat);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(26);
			((PredicatContext)_localctx).e = entite();
			setState(27);
			((PredicatContext)_localctx).lo = objet();
			List<ASD.Document.Objet> lobj = new ArrayList<ASD.Document.Objet>(); lobj.add(((PredicatContext)_localctx).lo.out); ((PredicatContext)_localctx).out =  new ASD.Document.Predicat(((PredicatContext)_localctx).e.out, lobj);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ObjetContext extends ParserRuleContext {
		public ASD.Document.Objet out;
		public ObjetTexteContext ot;
		public ObjetEntiteContext oe;
		public ObjetTexteContext objetTexte() {
			return getRuleContext(ObjetTexteContext.class,0);
		}
		public ObjetEntiteContext objetEntite() {
			return getRuleContext(ObjetEntiteContext.class,0);
		}
		public ObjetContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_objet; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TurtleParserListener ) ((TurtleParserListener)listener).enterObjet(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TurtleParserListener ) ((TurtleParserListener)listener).exitObjet(this);
		}
	}

	public final ObjetContext objet() throws RecognitionException {
		ObjetContext _localctx = new ObjetContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_objet);
		try {
			setState(36);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(30);
				((ObjetContext)_localctx).ot = objetTexte();
				((ObjetContext)_localctx).out =  new ASD.Document.Objet(((ObjetContext)_localctx).ot.out);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(33);
				((ObjetContext)_localctx).oe = objetEntite();
				((ObjetContext)_localctx).out =  new ASD.Document.Objet(((ObjetContext)_localctx).oe.out);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ObjetTexteContext extends ParserRuleContext {
		public ASD.Document.ObjetTexte out;
		public TexteContext t;
		public TexteContext texte() {
			return getRuleContext(TexteContext.class,0);
		}
		public ObjetTexteContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_objetTexte; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TurtleParserListener ) ((TurtleParserListener)listener).enterObjetTexte(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TurtleParserListener ) ((TurtleParserListener)listener).exitObjetTexte(this);
		}
	}

	public final ObjetTexteContext objetTexte() throws RecognitionException {
		ObjetTexteContext _localctx = new ObjetTexteContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_objetTexte);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(38);
			((ObjetTexteContext)_localctx).t = texte();
			((ObjetTexteContext)_localctx).out =  new ASD.Document.ObjetTexte(((ObjetTexteContext)_localctx).t.out);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ObjetEntiteContext extends ParserRuleContext {
		public ASD.Document.ObjetEntite out;
		public EntiteContext e;
		public EntiteContext entite() {
			return getRuleContext(EntiteContext.class,0);
		}
		public ObjetEntiteContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_objetEntite; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TurtleParserListener ) ((TurtleParserListener)listener).enterObjetEntite(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TurtleParserListener ) ((TurtleParserListener)listener).exitObjetEntite(this);
		}
	}

	public final ObjetEntiteContext objetEntite() throws RecognitionException {
		ObjetEntiteContext _localctx = new ObjetEntiteContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_objetEntite);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(41);
			((ObjetEntiteContext)_localctx).e = entite();
			((ObjetEntiteContext)_localctx).out =  new ASD.Document.ObjetEntite(((ObjetEntiteContext)_localctx).e.out);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TexteContext extends ParserRuleContext {
		public ASD.Document.Texte out;
		public IdentContext id;
		public IdentContext ident() {
			return getRuleContext(IdentContext.class,0);
		}
		public TexteContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_texte; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TurtleParserListener ) ((TurtleParserListener)listener).enterTexte(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TurtleParserListener ) ((TurtleParserListener)listener).exitTexte(this);
		}
	}

	public final TexteContext texte() throws RecognitionException {
		TexteContext _localctx = new TexteContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_texte);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(44);
			((TexteContext)_localctx).id = ident();
			((TexteContext)_localctx).out =  new ASD.Document.Texte(((TexteContext)_localctx).id.out);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class EntiteContext extends ParserRuleContext {
		public ASD.Document.Entite out;
		public IdentContext id;
		public IdentContext ident() {
			return getRuleContext(IdentContext.class,0);
		}
		public EntiteContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_entite; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TurtleParserListener ) ((TurtleParserListener)listener).enterEntite(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TurtleParserListener ) ((TurtleParserListener)listener).exitEntite(this);
		}
	}

	public final EntiteContext entite() throws RecognitionException {
		EntiteContext _localctx = new EntiteContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_entite);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(47);
			((EntiteContext)_localctx).id = ident();
			((EntiteContext)_localctx).out =  new ASD.Document.Entite(((EntiteContext)_localctx).id.out);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IdentContext extends ParserRuleContext {
		public String out;
		public Token ID;
		public TerminalNode ID() { return getToken(TurtleParser.ID, 0); }
		public IdentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ident; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TurtleParserListener ) ((TurtleParserListener)listener).enterIdent(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TurtleParserListener ) ((TurtleParserListener)listener).exitIdent(this);
		}
	}

	public final IdentContext ident() throws RecognitionException {
		IdentContext _localctx = new IdentContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_ident);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(50);
			((IdentContext)_localctx).ID = match(ID);
			((IdentContext)_localctx).out =  (((IdentContext)_localctx).ID!=null?((IdentContext)_localctx).ID.getText():null);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\48\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\3\2\3\2\3\2"+
		"\3\2\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\5\5\'\n\5"+
		"\3\6\3\6\3\6\3\7\3\7\3\7\3\b\3\b\3\b\3\t\3\t\3\t\3\n\3\n\3\n\3\n\2\2\13"+
		"\2\4\6\b\n\f\16\20\22\2\2\2/\2\24\3\2\2\2\4\30\3\2\2\2\6\34\3\2\2\2\b"+
		"&\3\2\2\2\n(\3\2\2\2\f+\3\2\2\2\16.\3\2\2\2\20\61\3\2\2\2\22\64\3\2\2"+
		"\2\24\25\5\4\3\2\25\26\7\2\2\3\26\27\b\2\1\2\27\3\3\2\2\2\30\31\5\20\t"+
		"\2\31\32\5\6\4\2\32\33\b\3\1\2\33\5\3\2\2\2\34\35\5\20\t\2\35\36\5\b\5"+
		"\2\36\37\b\4\1\2\37\7\3\2\2\2 !\5\n\6\2!\"\b\5\1\2\"\'\3\2\2\2#$\5\f\7"+
		"\2$%\b\5\1\2%\'\3\2\2\2& \3\2\2\2&#\3\2\2\2\'\t\3\2\2\2()\5\16\b\2)*\b"+
		"\6\1\2*\13\3\2\2\2+,\5\20\t\2,-\b\7\1\2-\r\3\2\2\2./\5\22\n\2/\60\b\b"+
		"\1\2\60\17\3\2\2\2\61\62\5\22\n\2\62\63\b\t\1\2\63\21\3\2\2\2\64\65\7"+
		"\4\2\2\65\66\b\n\1\2\66\23\3\2\2\2\3&";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}