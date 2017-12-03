// Generated from ./WaccParser.g4 by ANTLR 4.7
package antlr;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class WaccParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		BEGIN=1, END=2, IS=3, IF=4, THEN=5, ELSE=6, FI=7, READ=8, FREE=9, RETURN=10, 
		EXIT=11, PRINT=12, PRINTLN=13, SKIPTOK=14, NEWPAIR=15, CALL=16, FST=17, 
		SND=18, PAIR_STRING=19, WHILE=20, DO=21, DONE=22, SEMI_COLON=23, MINUS=24, 
		PLUS=25, CHR=26, ORD=27, LEN=28, EXCL=29, MULT=30, DIV=31, MOD=32, GRTHAN=33, 
		GREQTO=34, LSTHAN=35, LSEQTO=36, EQTO=37, NEQTO=38, AND=39, OR=40, COMMA=41, 
		EQUAL=42, SQUARE_OPEN=43, SQUARE_CLOSED=44, OPEN_PAREN=45, CLOSE_PAREN=46, 
		BOOL_LITER=47, CHAR_LITER=48, STR_LITER=49, INT_LITER=50, PAIR_LITER=51, 
		BASE_TYPE=52, IDENT=53, COMMENT=54, WHITESPACE=55;
	public static final int
		RULE_program = 0, RULE_func = 1, RULE_param_list = 2, RULE_param = 3, 
		RULE_stat = 4, RULE_thenstat = 5, RULE_elsestat = 6, RULE_assign_lhs = 7, 
		RULE_assign_rhs = 8, RULE_pair_elem = 9, RULE_type = 10, RULE_pair_elem_type = 11, 
		RULE_expr = 12, RULE_side_effecting_expr = 13, RULE_unaryOp = 14, RULE_binaryOp = 15;
	public static final String[] ruleNames = {
		"program", "func", "param_list", "param", "stat", "thenstat", "elsestat", 
		"assign_lhs", "assign_rhs", "pair_elem", "type", "pair_elem_type", "expr", 
		"side_effecting_expr", "unaryOp", "binaryOp"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'begin'", "'end'", "'is'", "'if'", "'then'", "'else'", "'fi'", 
		"'read'", "'free'", "'return'", "'exit'", "'print'", "'println'", "'skip'", 
		"'newpair'", "'call'", "'fst'", "'snd'", "'pair'", "'while'", "'do'", 
		"'done'", "';'", "'-'", "'+'", "'chr'", "'ord'", "'len'", "'!'", "'*'", 
		"'/'", "'%'", "'>'", "'>='", "'<'", "'<='", "'=='", "'!='", "'&&'", "'||'", 
		"','", "'='", "'['", "']'", "'('", "')'", null, null, null, null, "'null'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "BEGIN", "END", "IS", "IF", "THEN", "ELSE", "FI", "READ", "FREE", 
		"RETURN", "EXIT", "PRINT", "PRINTLN", "SKIPTOK", "NEWPAIR", "CALL", "FST", 
		"SND", "PAIR_STRING", "WHILE", "DO", "DONE", "SEMI_COLON", "MINUS", "PLUS", 
		"CHR", "ORD", "LEN", "EXCL", "MULT", "DIV", "MOD", "GRTHAN", "GREQTO", 
		"LSTHAN", "LSEQTO", "EQTO", "NEQTO", "AND", "OR", "COMMA", "EQUAL", "SQUARE_OPEN", 
		"SQUARE_CLOSED", "OPEN_PAREN", "CLOSE_PAREN", "BOOL_LITER", "CHAR_LITER", 
		"STR_LITER", "INT_LITER", "PAIR_LITER", "BASE_TYPE", "IDENT", "COMMENT", 
		"WHITESPACE"
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
	public String getGrammarFileName() { return "WaccParser.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public WaccParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class ProgramContext extends ParserRuleContext {
		public TerminalNode BEGIN() { return getToken(WaccParser.BEGIN, 0); }
		public StatContext stat() {
			return getRuleContext(StatContext.class,0);
		}
		public TerminalNode END() { return getToken(WaccParser.END, 0); }
		public TerminalNode EOF() { return getToken(WaccParser.EOF, 0); }
		public List<FuncContext> func() {
			return getRuleContexts(FuncContext.class);
		}
		public FuncContext func(int i) {
			return getRuleContext(FuncContext.class,i);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WaccParserVisitor ) return ((WaccParserVisitor<? extends T>)visitor).visitProgram(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(32);
			match(BEGIN);
			setState(36);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(33);
					func();
					}
					} 
				}
				setState(38);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			}
			setState(39);
			stat(0);
			setState(40);
			match(END);
			setState(41);
			match(EOF);
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

	public static class FuncContext extends ParserRuleContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode IDENT() { return getToken(WaccParser.IDENT, 0); }
		public TerminalNode OPEN_PAREN() { return getToken(WaccParser.OPEN_PAREN, 0); }
		public TerminalNode CLOSE_PAREN() { return getToken(WaccParser.CLOSE_PAREN, 0); }
		public TerminalNode IS() { return getToken(WaccParser.IS, 0); }
		public StatContext stat() {
			return getRuleContext(StatContext.class,0);
		}
		public TerminalNode END() { return getToken(WaccParser.END, 0); }
		public Param_listContext param_list() {
			return getRuleContext(Param_listContext.class,0);
		}
		public FuncContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_func; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WaccParserVisitor ) return ((WaccParserVisitor<? extends T>)visitor).visitFunc(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FuncContext func() throws RecognitionException {
		FuncContext _localctx = new FuncContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_func);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(43);
			type(0);
			setState(44);
			match(IDENT);
			setState(45);
			match(OPEN_PAREN);
			setState(47);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==PAIR_STRING || _la==BASE_TYPE) {
				{
				setState(46);
				param_list();
				}
			}

			setState(49);
			match(CLOSE_PAREN);
			setState(50);
			match(IS);
			setState(51);
			stat(0);
			setState(52);
			match(END);
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

	public static class Param_listContext extends ParserRuleContext {
		public List<ParamContext> param() {
			return getRuleContexts(ParamContext.class);
		}
		public ParamContext param(int i) {
			return getRuleContext(ParamContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(WaccParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(WaccParser.COMMA, i);
		}
		public Param_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_param_list; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WaccParserVisitor ) return ((WaccParserVisitor<? extends T>)visitor).visitParam_list(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Param_listContext param_list() throws RecognitionException {
		Param_listContext _localctx = new Param_listContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_param_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(54);
			param();
			setState(59);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(55);
				match(COMMA);
				setState(56);
				param();
				}
				}
				setState(61);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
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

	public static class ParamContext extends ParserRuleContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode IDENT() { return getToken(WaccParser.IDENT, 0); }
		public ParamContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_param; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WaccParserVisitor ) return ((WaccParserVisitor<? extends T>)visitor).visitParam(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParamContext param() throws RecognitionException {
		ParamContext _localctx = new ParamContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_param);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(62);
			type(0);
			setState(63);
			match(IDENT);
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

	public static class StatContext extends ParserRuleContext {
		public StatContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stat; }
	 
		public StatContext() { }
		public void copyFrom(StatContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class SKIP_STATContext extends StatContext {
		public TerminalNode SKIPTOK() { return getToken(WaccParser.SKIPTOK, 0); }
		public SKIP_STATContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WaccParserVisitor ) return ((WaccParserVisitor<? extends T>)visitor).visitSKIP_STAT(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class READ_STATContext extends StatContext {
		public TerminalNode READ() { return getToken(WaccParser.READ, 0); }
		public Assign_lhsContext assign_lhs() {
			return getRuleContext(Assign_lhsContext.class,0);
		}
		public READ_STATContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WaccParserVisitor ) return ((WaccParserVisitor<? extends T>)visitor).visitREAD_STAT(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class VAR_DECL_STATContext extends StatContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode IDENT() { return getToken(WaccParser.IDENT, 0); }
		public TerminalNode EQUAL() { return getToken(WaccParser.EQUAL, 0); }
		public Assign_rhsContext assign_rhs() {
			return getRuleContext(Assign_rhsContext.class,0);
		}
		public VAR_DECL_STATContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WaccParserVisitor ) return ((WaccParserVisitor<? extends T>)visitor).visitVAR_DECL_STAT(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class FREE_STATContext extends StatContext {
		public TerminalNode FREE() { return getToken(WaccParser.FREE, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public FREE_STATContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WaccParserVisitor ) return ((WaccParserVisitor<? extends T>)visitor).visitFREE_STAT(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class WHILE_STATContext extends StatContext {
		public TerminalNode WHILE() { return getToken(WaccParser.WHILE, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode DO() { return getToken(WaccParser.DO, 0); }
		public StatContext stat() {
			return getRuleContext(StatContext.class,0);
		}
		public TerminalNode DONE() { return getToken(WaccParser.DONE, 0); }
		public WHILE_STATContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WaccParserVisitor ) return ((WaccParserVisitor<? extends T>)visitor).visitWHILE_STAT(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class SIDE_EFFECTContext extends StatContext {
		public Side_effecting_exprContext side_effecting_expr() {
			return getRuleContext(Side_effecting_exprContext.class,0);
		}
		public SIDE_EFFECTContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WaccParserVisitor ) return ((WaccParserVisitor<? extends T>)visitor).visitSIDE_EFFECT(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class MULT_STATContext extends StatContext {
		public List<StatContext> stat() {
			return getRuleContexts(StatContext.class);
		}
		public StatContext stat(int i) {
			return getRuleContext(StatContext.class,i);
		}
		public TerminalNode SEMI_COLON() { return getToken(WaccParser.SEMI_COLON, 0); }
		public MULT_STATContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WaccParserVisitor ) return ((WaccParserVisitor<? extends T>)visitor).visitMULT_STAT(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class EXIT_STATContext extends StatContext {
		public TerminalNode EXIT() { return getToken(WaccParser.EXIT, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public EXIT_STATContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WaccParserVisitor ) return ((WaccParserVisitor<? extends T>)visitor).visitEXIT_STAT(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class PRINTLN_STATContext extends StatContext {
		public TerminalNode PRINTLN() { return getToken(WaccParser.PRINTLN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public PRINTLN_STATContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WaccParserVisitor ) return ((WaccParserVisitor<? extends T>)visitor).visitPRINTLN_STAT(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BEGIN_END_STATContext extends StatContext {
		public TerminalNode BEGIN() { return getToken(WaccParser.BEGIN, 0); }
		public StatContext stat() {
			return getRuleContext(StatContext.class,0);
		}
		public TerminalNode END() { return getToken(WaccParser.END, 0); }
		public BEGIN_END_STATContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WaccParserVisitor ) return ((WaccParserVisitor<? extends T>)visitor).visitBEGIN_END_STAT(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IF_STATContext extends StatContext {
		public TerminalNode IF() { return getToken(WaccParser.IF, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode THEN() { return getToken(WaccParser.THEN, 0); }
		public ThenstatContext thenstat() {
			return getRuleContext(ThenstatContext.class,0);
		}
		public TerminalNode ELSE() { return getToken(WaccParser.ELSE, 0); }
		public ElsestatContext elsestat() {
			return getRuleContext(ElsestatContext.class,0);
		}
		public TerminalNode FI() { return getToken(WaccParser.FI, 0); }
		public IF_STATContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WaccParserVisitor ) return ((WaccParserVisitor<? extends T>)visitor).visitIF_STAT(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class PRINT_STATContext extends StatContext {
		public TerminalNode PRINT() { return getToken(WaccParser.PRINT, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public PRINT_STATContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WaccParserVisitor ) return ((WaccParserVisitor<? extends T>)visitor).visitPRINT_STAT(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ASSIGN_STATContext extends StatContext {
		public Assign_lhsContext assign_lhs() {
			return getRuleContext(Assign_lhsContext.class,0);
		}
		public TerminalNode EQUAL() { return getToken(WaccParser.EQUAL, 0); }
		public Assign_rhsContext assign_rhs() {
			return getRuleContext(Assign_rhsContext.class,0);
		}
		public ASSIGN_STATContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WaccParserVisitor ) return ((WaccParserVisitor<? extends T>)visitor).visitASSIGN_STAT(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class RETURN_STATContext extends StatContext {
		public TerminalNode RETURN() { return getToken(WaccParser.RETURN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public RETURN_STATContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WaccParserVisitor ) return ((WaccParserVisitor<? extends T>)visitor).visitRETURN_STAT(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatContext stat() throws RecognitionException {
		return stat(0);
	}

	private StatContext stat(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		StatContext _localctx = new StatContext(_ctx, _parentState);
		StatContext _prevctx = _localctx;
		int _startState = 8;
		enterRecursionRule(_localctx, 8, RULE_stat, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(107);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				{
				_localctx = new SKIP_STATContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(66);
				match(SKIPTOK);
				}
				break;
			case 2:
				{
				_localctx = new VAR_DECL_STATContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(67);
				type(0);
				setState(68);
				match(IDENT);
				setState(69);
				match(EQUAL);
				setState(70);
				assign_rhs();
				}
				break;
			case 3:
				{
				_localctx = new ASSIGN_STATContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(72);
				assign_lhs();
				setState(73);
				match(EQUAL);
				setState(74);
				assign_rhs();
				}
				break;
			case 4:
				{
				_localctx = new READ_STATContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(76);
				match(READ);
				setState(77);
				assign_lhs();
				}
				break;
			case 5:
				{
				_localctx = new FREE_STATContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(78);
				match(FREE);
				setState(79);
				expr(0);
				}
				break;
			case 6:
				{
				_localctx = new RETURN_STATContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(80);
				match(RETURN);
				setState(81);
				expr(0);
				}
				break;
			case 7:
				{
				_localctx = new EXIT_STATContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(82);
				match(EXIT);
				setState(83);
				expr(0);
				}
				break;
			case 8:
				{
				_localctx = new PRINT_STATContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(84);
				match(PRINT);
				setState(85);
				expr(0);
				}
				break;
			case 9:
				{
				_localctx = new PRINTLN_STATContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(86);
				match(PRINTLN);
				setState(87);
				expr(0);
				}
				break;
			case 10:
				{
				_localctx = new IF_STATContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(88);
				match(IF);
				setState(89);
				expr(0);
				setState(90);
				match(THEN);
				setState(91);
				thenstat();
				setState(92);
				match(ELSE);
				setState(93);
				elsestat();
				setState(94);
				match(FI);
				}
				break;
			case 11:
				{
				_localctx = new WHILE_STATContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(96);
				match(WHILE);
				setState(97);
				expr(0);
				setState(98);
				match(DO);
				setState(99);
				stat(0);
				setState(100);
				match(DONE);
				}
				break;
			case 12:
				{
				_localctx = new BEGIN_END_STATContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(102);
				match(BEGIN);
				setState(103);
				stat(0);
				setState(104);
				match(END);
				}
				break;
			case 13:
				{
				_localctx = new SIDE_EFFECTContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(106);
				side_effecting_expr();
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(114);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new MULT_STATContext(new StatContext(_parentctx, _parentState));
					pushNewRecursionContext(_localctx, _startState, RULE_stat);
					setState(109);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(110);
					match(SEMI_COLON);
					setState(111);
					stat(3);
					}
					} 
				}
				setState(116);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class ThenstatContext extends ParserRuleContext {
		public StatContext stat() {
			return getRuleContext(StatContext.class,0);
		}
		public ThenstatContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_thenstat; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WaccParserVisitor ) return ((WaccParserVisitor<? extends T>)visitor).visitThenstat(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ThenstatContext thenstat() throws RecognitionException {
		ThenstatContext _localctx = new ThenstatContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_thenstat);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(117);
			stat(0);
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

	public static class ElsestatContext extends ParserRuleContext {
		public StatContext stat() {
			return getRuleContext(StatContext.class,0);
		}
		public ElsestatContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_elsestat; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WaccParserVisitor ) return ((WaccParserVisitor<? extends T>)visitor).visitElsestat(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ElsestatContext elsestat() throws RecognitionException {
		ElsestatContext _localctx = new ElsestatContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_elsestat);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(119);
			stat(0);
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

	public static class Assign_lhsContext extends ParserRuleContext {
		public Assign_lhsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assign_lhs; }
	 
		public Assign_lhsContext() { }
		public void copyFrom(Assign_lhsContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class IDENT_ASSIGNContext extends Assign_lhsContext {
		public TerminalNode IDENT() { return getToken(WaccParser.IDENT, 0); }
		public IDENT_ASSIGNContext(Assign_lhsContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WaccParserVisitor ) return ((WaccParserVisitor<? extends T>)visitor).visitIDENT_ASSIGN(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ARRAY_ELEM_LHSContext extends Assign_lhsContext {
		public TerminalNode IDENT() { return getToken(WaccParser.IDENT, 0); }
		public List<TerminalNode> SQUARE_OPEN() { return getTokens(WaccParser.SQUARE_OPEN); }
		public TerminalNode SQUARE_OPEN(int i) {
			return getToken(WaccParser.SQUARE_OPEN, i);
		}
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public List<TerminalNode> SQUARE_CLOSED() { return getTokens(WaccParser.SQUARE_CLOSED); }
		public TerminalNode SQUARE_CLOSED(int i) {
			return getToken(WaccParser.SQUARE_CLOSED, i);
		}
		public ARRAY_ELEM_LHSContext(Assign_lhsContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WaccParserVisitor ) return ((WaccParserVisitor<? extends T>)visitor).visitARRAY_ELEM_LHS(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class PAIR_ELEM_LHSContext extends Assign_lhsContext {
		public Pair_elemContext pair_elem() {
			return getRuleContext(Pair_elemContext.class,0);
		}
		public PAIR_ELEM_LHSContext(Assign_lhsContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WaccParserVisitor ) return ((WaccParserVisitor<? extends T>)visitor).visitPAIR_ELEM_LHS(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Assign_lhsContext assign_lhs() throws RecognitionException {
		Assign_lhsContext _localctx = new Assign_lhsContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_assign_lhs);
		try {
			int _alt;
			setState(132);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				_localctx = new IDENT_ASSIGNContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(121);
				match(IDENT);
				}
				break;
			case 2:
				_localctx = new ARRAY_ELEM_LHSContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(122);
				match(IDENT);
				setState(127); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(123);
						match(SQUARE_OPEN);
						setState(124);
						expr(0);
						setState(125);
						match(SQUARE_CLOSED);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(129); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				}
				break;
			case 3:
				_localctx = new PAIR_ELEM_LHSContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(131);
				pair_elem();
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

	public static class Assign_rhsContext extends ParserRuleContext {
		public Assign_rhsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assign_rhs; }
	 
		public Assign_rhsContext() { }
		public void copyFrom(Assign_rhsContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class EXPR_ASSIGNContext extends Assign_rhsContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public EXPR_ASSIGNContext(Assign_rhsContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WaccParserVisitor ) return ((WaccParserVisitor<? extends T>)visitor).visitEXPR_ASSIGN(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class PAIR_ELEM_RHSContext extends Assign_rhsContext {
		public Pair_elemContext pair_elem() {
			return getRuleContext(Pair_elemContext.class,0);
		}
		public PAIR_ELEM_RHSContext(Assign_rhsContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WaccParserVisitor ) return ((WaccParserVisitor<? extends T>)visitor).visitPAIR_ELEM_RHS(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NEWPAIR_RHSContext extends Assign_rhsContext {
		public TerminalNode NEWPAIR() { return getToken(WaccParser.NEWPAIR, 0); }
		public TerminalNode OPEN_PAREN() { return getToken(WaccParser.OPEN_PAREN, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode COMMA() { return getToken(WaccParser.COMMA, 0); }
		public TerminalNode CLOSE_PAREN() { return getToken(WaccParser.CLOSE_PAREN, 0); }
		public NEWPAIR_RHSContext(Assign_rhsContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WaccParserVisitor ) return ((WaccParserVisitor<? extends T>)visitor).visitNEWPAIR_RHS(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ARRAY_LITER_RHSContext extends Assign_rhsContext {
		public TerminalNode SQUARE_OPEN() { return getToken(WaccParser.SQUARE_OPEN, 0); }
		public TerminalNode SQUARE_CLOSED() { return getToken(WaccParser.SQUARE_CLOSED, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(WaccParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(WaccParser.COMMA, i);
		}
		public ARRAY_LITER_RHSContext(Assign_rhsContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WaccParserVisitor ) return ((WaccParserVisitor<? extends T>)visitor).visitARRAY_LITER_RHS(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class CALL_ASSIGNContext extends Assign_rhsContext {
		public TerminalNode CALL() { return getToken(WaccParser.CALL, 0); }
		public TerminalNode IDENT() { return getToken(WaccParser.IDENT, 0); }
		public TerminalNode OPEN_PAREN() { return getToken(WaccParser.OPEN_PAREN, 0); }
		public TerminalNode CLOSE_PAREN() { return getToken(WaccParser.CLOSE_PAREN, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(WaccParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(WaccParser.COMMA, i);
		}
		public CALL_ASSIGNContext(Assign_rhsContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WaccParserVisitor ) return ((WaccParserVisitor<? extends T>)visitor).visitCALL_ASSIGN(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Assign_rhsContext assign_rhs() throws RecognitionException {
		Assign_rhsContext _localctx = new Assign_rhsContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_assign_rhs);
		int _la;
		try {
			setState(169);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case MINUS:
			case PLUS:
			case CHR:
			case ORD:
			case LEN:
			case EXCL:
			case OPEN_PAREN:
			case BOOL_LITER:
			case CHAR_LITER:
			case STR_LITER:
			case INT_LITER:
			case PAIR_LITER:
			case IDENT:
				_localctx = new EXPR_ASSIGNContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(134);
				expr(0);
				}
				break;
			case SQUARE_OPEN:
				_localctx = new ARRAY_LITER_RHSContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(135);
				match(SQUARE_OPEN);
				setState(144);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << MINUS) | (1L << PLUS) | (1L << CHR) | (1L << ORD) | (1L << LEN) | (1L << EXCL) | (1L << OPEN_PAREN) | (1L << BOOL_LITER) | (1L << CHAR_LITER) | (1L << STR_LITER) | (1L << INT_LITER) | (1L << PAIR_LITER) | (1L << IDENT))) != 0)) {
					{
					setState(136);
					expr(0);
					setState(141);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMMA) {
						{
						{
						setState(137);
						match(COMMA);
						setState(138);
						expr(0);
						}
						}
						setState(143);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(146);
				match(SQUARE_CLOSED);
				}
				break;
			case NEWPAIR:
				_localctx = new NEWPAIR_RHSContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(147);
				match(NEWPAIR);
				setState(148);
				match(OPEN_PAREN);
				setState(149);
				expr(0);
				setState(150);
				match(COMMA);
				setState(151);
				expr(0);
				setState(152);
				match(CLOSE_PAREN);
				}
				break;
			case FST:
			case SND:
				_localctx = new PAIR_ELEM_RHSContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(154);
				pair_elem();
				}
				break;
			case CALL:
				_localctx = new CALL_ASSIGNContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(155);
				match(CALL);
				setState(156);
				match(IDENT);
				setState(157);
				match(OPEN_PAREN);
				setState(166);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << MINUS) | (1L << PLUS) | (1L << CHR) | (1L << ORD) | (1L << LEN) | (1L << EXCL) | (1L << OPEN_PAREN) | (1L << BOOL_LITER) | (1L << CHAR_LITER) | (1L << STR_LITER) | (1L << INT_LITER) | (1L << PAIR_LITER) | (1L << IDENT))) != 0)) {
					{
					setState(158);
					expr(0);
					setState(163);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMMA) {
						{
						{
						setState(159);
						match(COMMA);
						setState(160);
						expr(0);
						}
						}
						setState(165);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(168);
				match(CLOSE_PAREN);
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	public static class Pair_elemContext extends ParserRuleContext {
		public Pair_elemContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pair_elem; }
	 
		public Pair_elemContext() { }
		public void copyFrom(Pair_elemContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class PAIR_SNDContext extends Pair_elemContext {
		public TerminalNode SND() { return getToken(WaccParser.SND, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public PAIR_SNDContext(Pair_elemContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WaccParserVisitor ) return ((WaccParserVisitor<? extends T>)visitor).visitPAIR_SND(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class PAIR_FSTContext extends Pair_elemContext {
		public TerminalNode FST() { return getToken(WaccParser.FST, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public PAIR_FSTContext(Pair_elemContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WaccParserVisitor ) return ((WaccParserVisitor<? extends T>)visitor).visitPAIR_FST(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Pair_elemContext pair_elem() throws RecognitionException {
		Pair_elemContext _localctx = new Pair_elemContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_pair_elem);
		try {
			setState(175);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case FST:
				_localctx = new PAIR_FSTContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(171);
				match(FST);
				setState(172);
				expr(0);
				}
				break;
			case SND:
				_localctx = new PAIR_SNDContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(173);
				match(SND);
				setState(174);
				expr(0);
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	public static class TypeContext extends ParserRuleContext {
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
	 
		public TypeContext() { }
		public void copyFrom(TypeContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ARRAY_TYPEContext extends TypeContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode SQUARE_OPEN() { return getToken(WaccParser.SQUARE_OPEN, 0); }
		public TerminalNode SQUARE_CLOSED() { return getToken(WaccParser.SQUARE_CLOSED, 0); }
		public ARRAY_TYPEContext(TypeContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WaccParserVisitor ) return ((WaccParserVisitor<? extends T>)visitor).visitARRAY_TYPE(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class PAIR_TYPEContext extends TypeContext {
		public TerminalNode PAIR_STRING() { return getToken(WaccParser.PAIR_STRING, 0); }
		public TerminalNode OPEN_PAREN() { return getToken(WaccParser.OPEN_PAREN, 0); }
		public List<Pair_elem_typeContext> pair_elem_type() {
			return getRuleContexts(Pair_elem_typeContext.class);
		}
		public Pair_elem_typeContext pair_elem_type(int i) {
			return getRuleContext(Pair_elem_typeContext.class,i);
		}
		public TerminalNode COMMA() { return getToken(WaccParser.COMMA, 0); }
		public TerminalNode CLOSE_PAREN() { return getToken(WaccParser.CLOSE_PAREN, 0); }
		public PAIR_TYPEContext(TypeContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WaccParserVisitor ) return ((WaccParserVisitor<? extends T>)visitor).visitPAIR_TYPE(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BASE_TYPEContext extends TypeContext {
		public TerminalNode BASE_TYPE() { return getToken(WaccParser.BASE_TYPE, 0); }
		public BASE_TYPEContext(TypeContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WaccParserVisitor ) return ((WaccParserVisitor<? extends T>)visitor).visitBASE_TYPE(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		return type(0);
	}

	private TypeContext type(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		TypeContext _localctx = new TypeContext(_ctx, _parentState);
		TypeContext _prevctx = _localctx;
		int _startState = 20;
		enterRecursionRule(_localctx, 20, RULE_type, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(186);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case BASE_TYPE:
				{
				_localctx = new BASE_TYPEContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(178);
				match(BASE_TYPE);
				}
				break;
			case PAIR_STRING:
				{
				_localctx = new PAIR_TYPEContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(179);
				match(PAIR_STRING);
				setState(180);
				match(OPEN_PAREN);
				setState(181);
				pair_elem_type();
				setState(182);
				match(COMMA);
				setState(183);
				pair_elem_type();
				setState(184);
				match(CLOSE_PAREN);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(193);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new ARRAY_TYPEContext(new TypeContext(_parentctx, _parentState));
					pushNewRecursionContext(_localctx, _startState, RULE_type);
					setState(188);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(189);
					match(SQUARE_OPEN);
					setState(190);
					match(SQUARE_CLOSED);
					}
					} 
				}
				setState(195);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class Pair_elem_typeContext extends ParserRuleContext {
		public Pair_elem_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pair_elem_type; }
	 
		public Pair_elem_typeContext() { }
		public void copyFrom(Pair_elem_typeContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ARRAY_TYPE_PAIRContext extends Pair_elem_typeContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode SQUARE_OPEN() { return getToken(WaccParser.SQUARE_OPEN, 0); }
		public TerminalNode SQUARE_CLOSED() { return getToken(WaccParser.SQUARE_CLOSED, 0); }
		public ARRAY_TYPE_PAIRContext(Pair_elem_typeContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WaccParserVisitor ) return ((WaccParserVisitor<? extends T>)visitor).visitARRAY_TYPE_PAIR(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BASE_TYPE_PAIRContext extends Pair_elem_typeContext {
		public TerminalNode BASE_TYPE() { return getToken(WaccParser.BASE_TYPE, 0); }
		public BASE_TYPE_PAIRContext(Pair_elem_typeContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WaccParserVisitor ) return ((WaccParserVisitor<? extends T>)visitor).visitBASE_TYPE_PAIR(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class PAIR_STRINGContext extends Pair_elem_typeContext {
		public TerminalNode PAIR_STRING() { return getToken(WaccParser.PAIR_STRING, 0); }
		public PAIR_STRINGContext(Pair_elem_typeContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WaccParserVisitor ) return ((WaccParserVisitor<? extends T>)visitor).visitPAIR_STRING(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Pair_elem_typeContext pair_elem_type() throws RecognitionException {
		Pair_elem_typeContext _localctx = new Pair_elem_typeContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_pair_elem_type);
		try {
			setState(202);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
			case 1:
				_localctx = new BASE_TYPE_PAIRContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(196);
				match(BASE_TYPE);
				}
				break;
			case 2:
				_localctx = new ARRAY_TYPE_PAIRContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(197);
				type(0);
				setState(198);
				match(SQUARE_OPEN);
				setState(199);
				match(SQUARE_CLOSED);
				}
				break;
			case 3:
				_localctx = new PAIR_STRINGContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(201);
				match(PAIR_STRING);
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

	public static class ExprContext extends ParserRuleContext {
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
	 
		public ExprContext() { }
		public void copyFrom(ExprContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class BOOL_LITER_EXPRContext extends ExprContext {
		public TerminalNode BOOL_LITER() { return getToken(WaccParser.BOOL_LITER, 0); }
		public BOOL_LITER_EXPRContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WaccParserVisitor ) return ((WaccParserVisitor<? extends T>)visitor).visitBOOL_LITER_EXPR(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ENCLOSED_EXPRContext extends ExprContext {
		public TerminalNode OPEN_PAREN() { return getToken(WaccParser.OPEN_PAREN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode CLOSE_PAREN() { return getToken(WaccParser.CLOSE_PAREN, 0); }
		public ENCLOSED_EXPRContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WaccParserVisitor ) return ((WaccParserVisitor<? extends T>)visitor).visitENCLOSED_EXPR(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class STR_LITER_EXPRContext extends ExprContext {
		public TerminalNode STR_LITER() { return getToken(WaccParser.STR_LITER, 0); }
		public STR_LITER_EXPRContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WaccParserVisitor ) return ((WaccParserVisitor<? extends T>)visitor).visitSTR_LITER_EXPR(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class CHAR_LITER_EXPRContext extends ExprContext {
		public TerminalNode CHAR_LITER() { return getToken(WaccParser.CHAR_LITER, 0); }
		public CHAR_LITER_EXPRContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WaccParserVisitor ) return ((WaccParserVisitor<? extends T>)visitor).visitCHAR_LITER_EXPR(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class PAIR_LITER_EXPRContext extends ExprContext {
		public TerminalNode PAIR_LITER() { return getToken(WaccParser.PAIR_LITER, 0); }
		public PAIR_LITER_EXPRContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WaccParserVisitor ) return ((WaccParserVisitor<? extends T>)visitor).visitPAIR_LITER_EXPR(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IDENT_EXPRContext extends ExprContext {
		public TerminalNode IDENT() { return getToken(WaccParser.IDENT, 0); }
		public IDENT_EXPRContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WaccParserVisitor ) return ((WaccParserVisitor<? extends T>)visitor).visitIDENT_EXPR(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class SIDE_EFFECT_EXPRContext extends ExprContext {
		public Side_effecting_exprContext side_effecting_expr() {
			return getRuleContext(Side_effecting_exprContext.class,0);
		}
		public SIDE_EFFECT_EXPRContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WaccParserVisitor ) return ((WaccParserVisitor<? extends T>)visitor).visitSIDE_EFFECT_EXPR(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class INT_LITER_EXPRContext extends ExprContext {
		public TerminalNode INT_LITER() { return getToken(WaccParser.INT_LITER, 0); }
		public TerminalNode PLUS() { return getToken(WaccParser.PLUS, 0); }
		public TerminalNode MINUS() { return getToken(WaccParser.MINUS, 0); }
		public INT_LITER_EXPRContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WaccParserVisitor ) return ((WaccParserVisitor<? extends T>)visitor).visitINT_LITER_EXPR(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class UNARY_OP_EXPRContext extends ExprContext {
		public UnaryOpContext unaryOp() {
			return getRuleContext(UnaryOpContext.class,0);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public UNARY_OP_EXPRContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WaccParserVisitor ) return ((WaccParserVisitor<? extends T>)visitor).visitUNARY_OP_EXPR(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BINARY_OP_EXPRContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public BinaryOpContext binaryOp() {
			return getRuleContext(BinaryOpContext.class,0);
		}
		public BINARY_OP_EXPRContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WaccParserVisitor ) return ((WaccParserVisitor<? extends T>)visitor).visitBINARY_OP_EXPR(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ARRAY_ELEM_EXPRContext extends ExprContext {
		public TerminalNode IDENT() { return getToken(WaccParser.IDENT, 0); }
		public List<TerminalNode> SQUARE_OPEN() { return getTokens(WaccParser.SQUARE_OPEN); }
		public TerminalNode SQUARE_OPEN(int i) {
			return getToken(WaccParser.SQUARE_OPEN, i);
		}
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public List<TerminalNode> SQUARE_CLOSED() { return getTokens(WaccParser.SQUARE_CLOSED); }
		public TerminalNode SQUARE_CLOSED(int i) {
			return getToken(WaccParser.SQUARE_CLOSED, i);
		}
		public ARRAY_ELEM_EXPRContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WaccParserVisitor ) return ((WaccParserVisitor<? extends T>)visitor).visitARRAY_ELEM_EXPR(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		return expr(0);
	}

	private ExprContext expr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExprContext _localctx = new ExprContext(_ctx, _parentState);
		ExprContext _prevctx = _localctx;
		int _startState = 24;
		enterRecursionRule(_localctx, 24, RULE_expr, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(231);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
			case 1:
				{
				_localctx = new INT_LITER_EXPRContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(206);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==MINUS || _la==PLUS) {
					{
					setState(205);
					_la = _input.LA(1);
					if ( !(_la==MINUS || _la==PLUS) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					}
				}

				setState(208);
				match(INT_LITER);
				}
				break;
			case 2:
				{
				_localctx = new UNARY_OP_EXPRContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(209);
				unaryOp();
				setState(210);
				expr(10);
				}
				break;
			case 3:
				{
				_localctx = new BOOL_LITER_EXPRContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(212);
				match(BOOL_LITER);
				}
				break;
			case 4:
				{
				_localctx = new CHAR_LITER_EXPRContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(213);
				match(CHAR_LITER);
				}
				break;
			case 5:
				{
				_localctx = new STR_LITER_EXPRContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(214);
				match(STR_LITER);
				}
				break;
			case 6:
				{
				_localctx = new PAIR_LITER_EXPRContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(215);
				match(PAIR_LITER);
				}
				break;
			case 7:
				{
				_localctx = new IDENT_EXPRContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(216);
				match(IDENT);
				}
				break;
			case 8:
				{
				_localctx = new ARRAY_ELEM_EXPRContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(217);
				match(IDENT);
				setState(222); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(218);
						match(SQUARE_OPEN);
						setState(219);
						expr(0);
						setState(220);
						match(SQUARE_CLOSED);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(224); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,17,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				}
				break;
			case 9:
				{
				_localctx = new ENCLOSED_EXPRContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(226);
				match(OPEN_PAREN);
				setState(227);
				expr(0);
				setState(228);
				match(CLOSE_PAREN);
				}
				break;
			case 10:
				{
				_localctx = new SIDE_EFFECT_EXPRContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(230);
				side_effecting_expr();
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(239);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,19,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new BINARY_OP_EXPRContext(new ExprContext(_parentctx, _parentState));
					pushNewRecursionContext(_localctx, _startState, RULE_expr);
					setState(233);
					if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
					setState(234);
					binaryOp();
					setState(235);
					expr(10);
					}
					} 
				}
				setState(241);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,19,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class Side_effecting_exprContext extends ParserRuleContext {
		public Side_effecting_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_side_effecting_expr; }
	 
		public Side_effecting_exprContext() { }
		public void copyFrom(Side_effecting_exprContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class IDENT_MULT_EQUALSContext extends Side_effecting_exprContext {
		public TerminalNode IDENT() { return getToken(WaccParser.IDENT, 0); }
		public TerminalNode MULT() { return getToken(WaccParser.MULT, 0); }
		public TerminalNode EQUAL() { return getToken(WaccParser.EQUAL, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public IDENT_MULT_EQUALSContext(Side_effecting_exprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WaccParserVisitor ) return ((WaccParserVisitor<? extends T>)visitor).visitIDENT_MULT_EQUALS(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IDENT_EQUALContext extends Side_effecting_exprContext {
		public TerminalNode IDENT() { return getToken(WaccParser.IDENT, 0); }
		public TerminalNode EQUAL() { return getToken(WaccParser.EQUAL, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public IDENT_EQUALContext(Side_effecting_exprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WaccParserVisitor ) return ((WaccParserVisitor<? extends T>)visitor).visitIDENT_EQUAL(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IDENT_PLUS_PLUSContext extends Side_effecting_exprContext {
		public TerminalNode IDENT() { return getToken(WaccParser.IDENT, 0); }
		public List<TerminalNode> PLUS() { return getTokens(WaccParser.PLUS); }
		public TerminalNode PLUS(int i) {
			return getToken(WaccParser.PLUS, i);
		}
		public IDENT_PLUS_PLUSContext(Side_effecting_exprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WaccParserVisitor ) return ((WaccParserVisitor<? extends T>)visitor).visitIDENT_PLUS_PLUS(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IDENT_MINUS_EQUALSContext extends Side_effecting_exprContext {
		public TerminalNode IDENT() { return getToken(WaccParser.IDENT, 0); }
		public TerminalNode MINUS() { return getToken(WaccParser.MINUS, 0); }
		public TerminalNode EQUAL() { return getToken(WaccParser.EQUAL, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public IDENT_MINUS_EQUALSContext(Side_effecting_exprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WaccParserVisitor ) return ((WaccParserVisitor<? extends T>)visitor).visitIDENT_MINUS_EQUALS(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IDENT_PLUS_EQUALSContext extends Side_effecting_exprContext {
		public TerminalNode IDENT() { return getToken(WaccParser.IDENT, 0); }
		public TerminalNode PLUS() { return getToken(WaccParser.PLUS, 0); }
		public TerminalNode EQUAL() { return getToken(WaccParser.EQUAL, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public IDENT_PLUS_EQUALSContext(Side_effecting_exprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WaccParserVisitor ) return ((WaccParserVisitor<? extends T>)visitor).visitIDENT_PLUS_EQUALS(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IDENT_DIV_EQUALSContext extends Side_effecting_exprContext {
		public TerminalNode IDENT() { return getToken(WaccParser.IDENT, 0); }
		public TerminalNode DIV() { return getToken(WaccParser.DIV, 0); }
		public TerminalNode EQUAL() { return getToken(WaccParser.EQUAL, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public IDENT_DIV_EQUALSContext(Side_effecting_exprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WaccParserVisitor ) return ((WaccParserVisitor<? extends T>)visitor).visitIDENT_DIV_EQUALS(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class PLUS_PLUS_IDENTContext extends Side_effecting_exprContext {
		public List<TerminalNode> PLUS() { return getTokens(WaccParser.PLUS); }
		public TerminalNode PLUS(int i) {
			return getToken(WaccParser.PLUS, i);
		}
		public TerminalNode IDENT() { return getToken(WaccParser.IDENT, 0); }
		public PLUS_PLUS_IDENTContext(Side_effecting_exprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WaccParserVisitor ) return ((WaccParserVisitor<? extends T>)visitor).visitPLUS_PLUS_IDENT(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Side_effecting_exprContext side_effecting_expr() throws RecognitionException {
		Side_effecting_exprContext _localctx = new Side_effecting_exprContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_side_effecting_expr);
		try {
			setState(267);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
			case 1:
				_localctx = new IDENT_PLUS_PLUSContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(242);
				match(IDENT);
				setState(243);
				match(PLUS);
				setState(244);
				match(PLUS);
				}
				break;
			case 2:
				_localctx = new PLUS_PLUS_IDENTContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(245);
				match(PLUS);
				setState(246);
				match(PLUS);
				setState(247);
				match(IDENT);
				}
				break;
			case 3:
				_localctx = new IDENT_PLUS_EQUALSContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(248);
				match(IDENT);
				setState(249);
				match(PLUS);
				setState(250);
				match(EQUAL);
				setState(251);
				expr(0);
				}
				break;
			case 4:
				_localctx = new IDENT_MINUS_EQUALSContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(252);
				match(IDENT);
				setState(253);
				match(MINUS);
				setState(254);
				match(EQUAL);
				setState(255);
				expr(0);
				}
				break;
			case 5:
				_localctx = new IDENT_EQUALContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(256);
				match(IDENT);
				setState(257);
				match(EQUAL);
				setState(258);
				expr(0);
				}
				break;
			case 6:
				_localctx = new IDENT_MULT_EQUALSContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(259);
				match(IDENT);
				setState(260);
				match(MULT);
				setState(261);
				match(EQUAL);
				setState(262);
				expr(0);
				}
				break;
			case 7:
				_localctx = new IDENT_DIV_EQUALSContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(263);
				match(IDENT);
				setState(264);
				match(DIV);
				setState(265);
				match(EQUAL);
				setState(266);
				expr(0);
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

	public static class UnaryOpContext extends ParserRuleContext {
		public TerminalNode CHR() { return getToken(WaccParser.CHR, 0); }
		public TerminalNode ORD() { return getToken(WaccParser.ORD, 0); }
		public TerminalNode LEN() { return getToken(WaccParser.LEN, 0); }
		public TerminalNode EXCL() { return getToken(WaccParser.EXCL, 0); }
		public TerminalNode MINUS() { return getToken(WaccParser.MINUS, 0); }
		public UnaryOpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unaryOp; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WaccParserVisitor ) return ((WaccParserVisitor<? extends T>)visitor).visitUnaryOp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final UnaryOpContext unaryOp() throws RecognitionException {
		UnaryOpContext _localctx = new UnaryOpContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_unaryOp);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(269);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << MINUS) | (1L << CHR) | (1L << ORD) | (1L << LEN) | (1L << EXCL))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
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

	public static class BinaryOpContext extends ParserRuleContext {
		public TerminalNode MULT() { return getToken(WaccParser.MULT, 0); }
		public TerminalNode DIV() { return getToken(WaccParser.DIV, 0); }
		public TerminalNode MOD() { return getToken(WaccParser.MOD, 0); }
		public TerminalNode PLUS() { return getToken(WaccParser.PLUS, 0); }
		public TerminalNode MINUS() { return getToken(WaccParser.MINUS, 0); }
		public TerminalNode GRTHAN() { return getToken(WaccParser.GRTHAN, 0); }
		public TerminalNode GREQTO() { return getToken(WaccParser.GREQTO, 0); }
		public TerminalNode LSTHAN() { return getToken(WaccParser.LSTHAN, 0); }
		public TerminalNode LSEQTO() { return getToken(WaccParser.LSEQTO, 0); }
		public TerminalNode EQTO() { return getToken(WaccParser.EQTO, 0); }
		public TerminalNode NEQTO() { return getToken(WaccParser.NEQTO, 0); }
		public TerminalNode AND() { return getToken(WaccParser.AND, 0); }
		public TerminalNode OR() { return getToken(WaccParser.OR, 0); }
		public BinaryOpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_binaryOp; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WaccParserVisitor ) return ((WaccParserVisitor<? extends T>)visitor).visitBinaryOp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BinaryOpContext binaryOp() throws RecognitionException {
		BinaryOpContext _localctx = new BinaryOpContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_binaryOp);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(271);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << MINUS) | (1L << PLUS) | (1L << MULT) | (1L << DIV) | (1L << MOD) | (1L << GRTHAN) | (1L << GREQTO) | (1L << LSTHAN) | (1L << LSEQTO) | (1L << EQTO) | (1L << NEQTO) | (1L << AND) | (1L << OR))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 4:
			return stat_sempred((StatContext)_localctx, predIndex);
		case 10:
			return type_sempred((TypeContext)_localctx, predIndex);
		case 12:
			return expr_sempred((ExprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean stat_sempred(StatContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean type_sempred(TypeContext _localctx, int predIndex) {
		switch (predIndex) {
		case 1:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean expr_sempred(ExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 2:
			return precpred(_ctx, 9);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\39\u0114\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\3\2\3\2\7"+
		"\2%\n\2\f\2\16\2(\13\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\5\3\62\n\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\4\3\4\3\4\7\4<\n\4\f\4\16\4?\13\4\3\5\3\5\3\5\3\6\3"+
		"\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6"+
		"\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3"+
		"\6\3\6\3\6\3\6\3\6\3\6\5\6n\n\6\3\6\3\6\3\6\7\6s\n\6\f\6\16\6v\13\6\3"+
		"\7\3\7\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\6\t\u0082\n\t\r\t\16\t\u0083\3"+
		"\t\5\t\u0087\n\t\3\n\3\n\3\n\3\n\3\n\7\n\u008e\n\n\f\n\16\n\u0091\13\n"+
		"\5\n\u0093\n\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n"+
		"\3\n\7\n\u00a4\n\n\f\n\16\n\u00a7\13\n\5\n\u00a9\n\n\3\n\5\n\u00ac\n\n"+
		"\3\13\3\13\3\13\3\13\5\13\u00b2\n\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3"+
		"\f\5\f\u00bd\n\f\3\f\3\f\3\f\7\f\u00c2\n\f\f\f\16\f\u00c5\13\f\3\r\3\r"+
		"\3\r\3\r\3\r\3\r\5\r\u00cd\n\r\3\16\3\16\5\16\u00d1\n\16\3\16\3\16\3\16"+
		"\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\6\16\u00e1\n\16"+
		"\r\16\16\16\u00e2\3\16\3\16\3\16\3\16\3\16\5\16\u00ea\n\16\3\16\3\16\3"+
		"\16\3\16\7\16\u00f0\n\16\f\16\16\16\u00f3\13\16\3\17\3\17\3\17\3\17\3"+
		"\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3"+
		"\17\3\17\3\17\3\17\3\17\3\17\3\17\5\17\u010e\n\17\3\20\3\20\3\21\3\21"+
		"\3\21\2\5\n\26\32\22\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \2\5\3\2\32"+
		"\33\4\2\32\32\34\37\4\2\32\33 *\2\u0135\2\"\3\2\2\2\4-\3\2\2\2\68\3\2"+
		"\2\2\b@\3\2\2\2\nm\3\2\2\2\fw\3\2\2\2\16y\3\2\2\2\20\u0086\3\2\2\2\22"+
		"\u00ab\3\2\2\2\24\u00b1\3\2\2\2\26\u00bc\3\2\2\2\30\u00cc\3\2\2\2\32\u00e9"+
		"\3\2\2\2\34\u010d\3\2\2\2\36\u010f\3\2\2\2 \u0111\3\2\2\2\"&\7\3\2\2#"+
		"%\5\4\3\2$#\3\2\2\2%(\3\2\2\2&$\3\2\2\2&\'\3\2\2\2\')\3\2\2\2(&\3\2\2"+
		"\2)*\5\n\6\2*+\7\4\2\2+,\7\2\2\3,\3\3\2\2\2-.\5\26\f\2./\7\67\2\2/\61"+
		"\7/\2\2\60\62\5\6\4\2\61\60\3\2\2\2\61\62\3\2\2\2\62\63\3\2\2\2\63\64"+
		"\7\60\2\2\64\65\7\5\2\2\65\66\5\n\6\2\66\67\7\4\2\2\67\5\3\2\2\28=\5\b"+
		"\5\29:\7+\2\2:<\5\b\5\2;9\3\2\2\2<?\3\2\2\2=;\3\2\2\2=>\3\2\2\2>\7\3\2"+
		"\2\2?=\3\2\2\2@A\5\26\f\2AB\7\67\2\2B\t\3\2\2\2CD\b\6\1\2Dn\7\20\2\2E"+
		"F\5\26\f\2FG\7\67\2\2GH\7,\2\2HI\5\22\n\2In\3\2\2\2JK\5\20\t\2KL\7,\2"+
		"\2LM\5\22\n\2Mn\3\2\2\2NO\7\n\2\2On\5\20\t\2PQ\7\13\2\2Qn\5\32\16\2RS"+
		"\7\f\2\2Sn\5\32\16\2TU\7\r\2\2Un\5\32\16\2VW\7\16\2\2Wn\5\32\16\2XY\7"+
		"\17\2\2Yn\5\32\16\2Z[\7\6\2\2[\\\5\32\16\2\\]\7\7\2\2]^\5\f\7\2^_\7\b"+
		"\2\2_`\5\16\b\2`a\7\t\2\2an\3\2\2\2bc\7\26\2\2cd\5\32\16\2de\7\27\2\2"+
		"ef\5\n\6\2fg\7\30\2\2gn\3\2\2\2hi\7\3\2\2ij\5\n\6\2jk\7\4\2\2kn\3\2\2"+
		"\2ln\5\34\17\2mC\3\2\2\2mE\3\2\2\2mJ\3\2\2\2mN\3\2\2\2mP\3\2\2\2mR\3\2"+
		"\2\2mT\3\2\2\2mV\3\2\2\2mX\3\2\2\2mZ\3\2\2\2mb\3\2\2\2mh\3\2\2\2ml\3\2"+
		"\2\2nt\3\2\2\2op\f\4\2\2pq\7\31\2\2qs\5\n\6\5ro\3\2\2\2sv\3\2\2\2tr\3"+
		"\2\2\2tu\3\2\2\2u\13\3\2\2\2vt\3\2\2\2wx\5\n\6\2x\r\3\2\2\2yz\5\n\6\2"+
		"z\17\3\2\2\2{\u0087\7\67\2\2|\u0081\7\67\2\2}~\7-\2\2~\177\5\32\16\2\177"+
		"\u0080\7.\2\2\u0080\u0082\3\2\2\2\u0081}\3\2\2\2\u0082\u0083\3\2\2\2\u0083"+
		"\u0081\3\2\2\2\u0083\u0084\3\2\2\2\u0084\u0087\3\2\2\2\u0085\u0087\5\24"+
		"\13\2\u0086{\3\2\2\2\u0086|\3\2\2\2\u0086\u0085\3\2\2\2\u0087\21\3\2\2"+
		"\2\u0088\u00ac\5\32\16\2\u0089\u0092\7-\2\2\u008a\u008f\5\32\16\2\u008b"+
		"\u008c\7+\2\2\u008c\u008e\5\32\16\2\u008d\u008b\3\2\2\2\u008e\u0091\3"+
		"\2\2\2\u008f\u008d\3\2\2\2\u008f\u0090\3\2\2\2\u0090\u0093\3\2\2\2\u0091"+
		"\u008f\3\2\2\2\u0092\u008a\3\2\2\2\u0092\u0093\3\2\2\2\u0093\u0094\3\2"+
		"\2\2\u0094\u00ac\7.\2\2\u0095\u0096\7\21\2\2\u0096\u0097\7/\2\2\u0097"+
		"\u0098\5\32\16\2\u0098\u0099\7+\2\2\u0099\u009a\5\32\16\2\u009a\u009b"+
		"\7\60\2\2\u009b\u00ac\3\2\2\2\u009c\u00ac\5\24\13\2\u009d\u009e\7\22\2"+
		"\2\u009e\u009f\7\67\2\2\u009f\u00a8\7/\2\2\u00a0\u00a5\5\32\16\2\u00a1"+
		"\u00a2\7+\2\2\u00a2\u00a4\5\32\16\2\u00a3\u00a1\3\2\2\2\u00a4\u00a7\3"+
		"\2\2\2\u00a5\u00a3\3\2\2\2\u00a5\u00a6\3\2\2\2\u00a6\u00a9\3\2\2\2\u00a7"+
		"\u00a5\3\2\2\2\u00a8\u00a0\3\2\2\2\u00a8\u00a9\3\2\2\2\u00a9\u00aa\3\2"+
		"\2\2\u00aa\u00ac\7\60\2\2\u00ab\u0088\3\2\2\2\u00ab\u0089\3\2\2\2\u00ab"+
		"\u0095\3\2\2\2\u00ab\u009c\3\2\2\2\u00ab\u009d\3\2\2\2\u00ac\23\3\2\2"+
		"\2\u00ad\u00ae\7\23\2\2\u00ae\u00b2\5\32\16\2\u00af\u00b0\7\24\2\2\u00b0"+
		"\u00b2\5\32\16\2\u00b1\u00ad\3\2\2\2\u00b1\u00af\3\2\2\2\u00b2\25\3\2"+
		"\2\2\u00b3\u00b4\b\f\1\2\u00b4\u00bd\7\66\2\2\u00b5\u00b6\7\25\2\2\u00b6"+
		"\u00b7\7/\2\2\u00b7\u00b8\5\30\r\2\u00b8\u00b9\7+\2\2\u00b9\u00ba\5\30"+
		"\r\2\u00ba\u00bb\7\60\2\2\u00bb\u00bd\3\2\2\2\u00bc\u00b3\3\2\2\2\u00bc"+
		"\u00b5\3\2\2\2\u00bd\u00c3\3\2\2\2\u00be\u00bf\f\4\2\2\u00bf\u00c0\7-"+
		"\2\2\u00c0\u00c2\7.\2\2\u00c1\u00be\3\2\2\2\u00c2\u00c5\3\2\2\2\u00c3"+
		"\u00c1\3\2\2\2\u00c3\u00c4\3\2\2\2\u00c4\27\3\2\2\2\u00c5\u00c3\3\2\2"+
		"\2\u00c6\u00cd\7\66\2\2\u00c7\u00c8\5\26\f\2\u00c8\u00c9\7-\2\2\u00c9"+
		"\u00ca\7.\2\2\u00ca\u00cd\3\2\2\2\u00cb\u00cd\7\25\2\2\u00cc\u00c6\3\2"+
		"\2\2\u00cc\u00c7\3\2\2\2\u00cc\u00cb\3\2\2\2\u00cd\31\3\2\2\2\u00ce\u00d0"+
		"\b\16\1\2\u00cf\u00d1\t\2\2\2\u00d0\u00cf\3\2\2\2\u00d0\u00d1\3\2\2\2"+
		"\u00d1\u00d2\3\2\2\2\u00d2\u00ea\7\64\2\2\u00d3\u00d4\5\36\20\2\u00d4"+
		"\u00d5\5\32\16\f\u00d5\u00ea\3\2\2\2\u00d6\u00ea\7\61\2\2\u00d7\u00ea"+
		"\7\62\2\2\u00d8\u00ea\7\63\2\2\u00d9\u00ea\7\65\2\2\u00da\u00ea\7\67\2"+
		"\2\u00db\u00e0\7\67\2\2\u00dc\u00dd\7-\2\2\u00dd\u00de\5\32\16\2\u00de"+
		"\u00df\7.\2\2\u00df\u00e1\3\2\2\2\u00e0\u00dc\3\2\2\2\u00e1\u00e2\3\2"+
		"\2\2\u00e2\u00e0\3\2\2\2\u00e2\u00e3\3\2\2\2\u00e3\u00ea\3\2\2\2\u00e4"+
		"\u00e5\7/\2\2\u00e5\u00e6\5\32\16\2\u00e6\u00e7\7\60\2\2\u00e7\u00ea\3"+
		"\2\2\2\u00e8\u00ea\5\34\17\2\u00e9\u00ce\3\2\2\2\u00e9\u00d3\3\2\2\2\u00e9"+
		"\u00d6\3\2\2\2\u00e9\u00d7\3\2\2\2\u00e9\u00d8\3\2\2\2\u00e9\u00d9\3\2"+
		"\2\2\u00e9\u00da\3\2\2\2\u00e9\u00db\3\2\2\2\u00e9\u00e4\3\2\2\2\u00e9"+
		"\u00e8\3\2\2\2\u00ea\u00f1\3\2\2\2\u00eb\u00ec\f\13\2\2\u00ec\u00ed\5"+
		" \21\2\u00ed\u00ee\5\32\16\f\u00ee\u00f0\3\2\2\2\u00ef\u00eb\3\2\2\2\u00f0"+
		"\u00f3\3\2\2\2\u00f1\u00ef\3\2\2\2\u00f1\u00f2\3\2\2\2\u00f2\33\3\2\2"+
		"\2\u00f3\u00f1\3\2\2\2\u00f4\u00f5\7\67\2\2\u00f5\u00f6\7\33\2\2\u00f6"+
		"\u010e\7\33\2\2\u00f7\u00f8\7\33\2\2\u00f8\u00f9\7\33\2\2\u00f9\u010e"+
		"\7\67\2\2\u00fa\u00fb\7\67\2\2\u00fb\u00fc\7\33\2\2\u00fc\u00fd\7,\2\2"+
		"\u00fd\u010e\5\32\16\2\u00fe\u00ff\7\67\2\2\u00ff\u0100\7\32\2\2\u0100"+
		"\u0101\7,\2\2\u0101\u010e\5\32\16\2\u0102\u0103\7\67\2\2\u0103\u0104\7"+
		",\2\2\u0104\u010e\5\32\16\2\u0105\u0106\7\67\2\2\u0106\u0107\7 \2\2\u0107"+
		"\u0108\7,\2\2\u0108\u010e\5\32\16\2\u0109\u010a\7\67\2\2\u010a\u010b\7"+
		"!\2\2\u010b\u010c\7,\2\2\u010c\u010e\5\32\16\2\u010d\u00f4\3\2\2\2\u010d"+
		"\u00f7\3\2\2\2\u010d\u00fa\3\2\2\2\u010d\u00fe\3\2\2\2\u010d\u0102\3\2"+
		"\2\2\u010d\u0105\3\2\2\2\u010d\u0109\3\2\2\2\u010e\35\3\2\2\2\u010f\u0110"+
		"\t\3\2\2\u0110\37\3\2\2\2\u0111\u0112\t\4\2\2\u0112!\3\2\2\2\27&\61=m"+
		"t\u0083\u0086\u008f\u0092\u00a5\u00a8\u00ab\u00b1\u00bc\u00c3\u00cc\u00d0"+
		"\u00e2\u00e9\u00f1\u010d";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}