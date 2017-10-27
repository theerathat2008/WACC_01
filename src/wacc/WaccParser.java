// Generated from WaccParser.g4 by ANTLR 4.4

    package WaccLexer;

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
	static { RuntimeMetaData.checkVersion("4.4", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		PRINT=27, CALL=38, CHAR_STRING=43, ESCAPED_CHAR=13, FI=32, PRINTLN=28, 
		INT_STRING=41, SND=40, STR_LITER=11, PAIR_LITER=14, NEWPAIR=37, SQUARE_OPEN=45, 
		BEGIN=17, DO=34, FREE=24, COMMENT=15, PAIR_STRING=47, RETURN=25, UNARY_OPER=3, 
		SKIP=21, ELSE=31, CHARACTER=12, IF=29, BOOL_LITER=9, INTEGER=6, COMMA=20, 
		DONE=35, STRING_STRING=44, EOL=16, EQUAL=22, FST=39, BINARY_OPER=4, BOOL_STRING=42, 
		CHAR_LITER=10, IS=19, INT_LITER=7, READ=23, OPEN_PAREN=1, IDENT=5, SQUARE_CLOSED=46, 
		INT_SIGN=8, END=18, THEN=30, WHILE=33, SEMI_COLON=36, CLOSE_PAREN=2, EXIT=26;
	public static final String[] tokenNames = {
		"<INVALID>", "'('", "')'", "UNARY_OPER", "BINARY_OPER", "IDENT", "INTEGER", 
		"INT_LITER", "INT_SIGN", "BOOL_LITER", "CHAR_LITER", "STR_LITER", "CHARACTER", 
		"ESCAPED_CHAR", "'null'", "COMMENT", "'\\n'", "'begin'", "'end'", "'is'", 
		"','", "'skip'", "'='", "'read'", "'free'", "'return'", "'exit'", "'print'", 
		"'println'", "'if'", "'then'", "'else'", "'fi'", "'while'", "'do'", "'done'", 
		"';'", "'newpair'", "'call'", "'fst'", "'snd'", "'int'", "'bool'", "'char'", 
		"'string'", "'['", "']'", "'pair'"
	};
	public static final int
		RULE_program = 0, RULE_func = 1, RULE_param_list = 2, RULE_param = 3, 
		RULE_stat = 4, RULE_assign_lhs = 5, RULE_assign_rhs = 6, RULE_arg_list = 7, 
		RULE_pair_elem = 8, RULE_type = 9, RULE_type2 = 10, RULE_base_type = 11, 
		RULE_array_type = 12, RULE_pair_type = 13, RULE_pair_elem_type = 14, RULE_expr = 15, 
		RULE_array_elem = 16, RULE_array_liter = 17;
	public static final String[] ruleNames = {
		"program", "func", "param_list", "param", "stat", "assign_lhs", "assign_rhs", 
		"arg_list", "pair_elem", "type", "type2", "base_type", "array_type", "pair_type", 
		"pair_elem_type", "expr", "array_elem", "array_liter"
	};

	@Override
	public String getGrammarFileName() { return "WaccParser.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

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
		public List<FuncContext> func() {
			return getRuleContexts(FuncContext.class);
		}
		public FuncContext func(int i) {
			return getRuleContext(FuncContext.class,i);
		}
		public TerminalNode BEGIN() { return getToken(WaccParser.BEGIN, 0); }
		public TerminalNode END() { return getToken(WaccParser.END, 0); }
		public StatContext stat() {
			return getRuleContext(StatContext.class,0);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof WaccParserListener ) ((WaccParserListener)listener).enterProgram(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof WaccParserListener ) ((WaccParserListener)listener).exitProgram(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(36); match(BEGIN);
			setState(40);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(37); func();
					}
					} 
				}
				setState(42);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			}
			setState(43); stat(0);
			setState(44); match(END);
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
		public TerminalNode CLOSE_PAREN() { return getToken(WaccParser.CLOSE_PAREN, 0); }
		public TerminalNode IS() { return getToken(WaccParser.IS, 0); }
		public Param_listContext param_list() {
			return getRuleContext(Param_listContext.class,0);
		}
		public TerminalNode END() { return getToken(WaccParser.END, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public StatContext stat() {
			return getRuleContext(StatContext.class,0);
		}
		public TerminalNode IDENT() { return getToken(WaccParser.IDENT, 0); }
		public TerminalNode OPEN_PAREN() { return getToken(WaccParser.OPEN_PAREN, 0); }
		public FuncContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_func; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof WaccParserListener ) ((WaccParserListener)listener).enterFunc(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof WaccParserListener ) ((WaccParserListener)listener).exitFunc(this);
		}
	}

	public final FuncContext func() throws RecognitionException {
		FuncContext _localctx = new FuncContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_func);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(46); type();
			setState(47); match(IDENT);
			setState(48); match(OPEN_PAREN);
			setState(50);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INT_STRING) | (1L << BOOL_STRING) | (1L << CHAR_STRING) | (1L << STRING_STRING) | (1L << PAIR_STRING))) != 0)) {
				{
				setState(49); param_list();
				}
			}

			setState(52); match(CLOSE_PAREN);
			setState(53); match(IS);
			setState(54); stat(0);
			setState(55); match(END);
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
		public List<TerminalNode> COMMA() { return getTokens(WaccParser.COMMA); }
		public ParamContext param(int i) {
			return getRuleContext(ParamContext.class,i);
		}
		public TerminalNode COMMA(int i) {
			return getToken(WaccParser.COMMA, i);
		}
		public Param_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_param_list; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof WaccParserListener ) ((WaccParserListener)listener).enterParam_list(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof WaccParserListener ) ((WaccParserListener)listener).exitParam_list(this);
		}
	}

	public final Param_listContext param_list() throws RecognitionException {
		Param_listContext _localctx = new Param_listContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_param_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(57); param();
			setState(62);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(58); match(COMMA);
				setState(59); param();
				}
				}
				setState(64);
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
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof WaccParserListener ) ((WaccParserListener)listener).enterParam(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof WaccParserListener ) ((WaccParserListener)listener).exitParam(this);
		}
	}

	public final ParamContext param() throws RecognitionException {
		ParamContext _localctx = new ParamContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_param);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(65); type();
			setState(66); match(IDENT);
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
		public TerminalNode ELSE() { return getToken(WaccParser.ELSE, 0); }
		public TerminalNode IF() { return getToken(WaccParser.IF, 0); }
		public TerminalNode FREE() { return getToken(WaccParser.FREE, 0); }
		public TerminalNode READ() { return getToken(WaccParser.READ, 0); }
		public TerminalNode IDENT() { return getToken(WaccParser.IDENT, 0); }
		public TerminalNode FI() { return getToken(WaccParser.FI, 0); }
		public TerminalNode DONE() { return getToken(WaccParser.DONE, 0); }
		public TerminalNode RETURN() { return getToken(WaccParser.RETURN, 0); }
		public TerminalNode DO() { return getToken(WaccParser.DO, 0); }
		public Assign_rhsContext assign_rhs() {
			return getRuleContext(Assign_rhsContext.class,0);
		}
		public TerminalNode SKIP() { return getToken(WaccParser.SKIP, 0); }
		public StatContext stat(int i) {
			return getRuleContext(StatContext.class,i);
		}
		public TerminalNode BEGIN() { return getToken(WaccParser.BEGIN, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode PRINT() { return getToken(WaccParser.PRINT, 0); }
		public TerminalNode THEN() { return getToken(WaccParser.THEN, 0); }
		public List<StatContext> stat() {
			return getRuleContexts(StatContext.class);
		}
		public TerminalNode WHILE() { return getToken(WaccParser.WHILE, 0); }
		public TerminalNode EXIT() { return getToken(WaccParser.EXIT, 0); }
		public TerminalNode EQUAL() { return getToken(WaccParser.EQUAL, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode SEMI_COLON() { return getToken(WaccParser.SEMI_COLON, 0); }
		public TerminalNode PRINTLN() { return getToken(WaccParser.PRINTLN, 0); }
		public TerminalNode END() { return getToken(WaccParser.END, 0); }
		public Assign_lhsContext assign_lhs() {
			return getRuleContext(Assign_lhsContext.class,0);
		}
		public StatContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stat; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof WaccParserListener ) ((WaccParserListener)listener).enterStat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof WaccParserListener ) ((WaccParserListener)listener).exitStat(this);
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
			setState(109);
			switch (_input.LA(1)) {
			case SKIP:
				{
				setState(69); match(SKIP);
				}
				break;
			case INT_STRING:
			case BOOL_STRING:
			case CHAR_STRING:
			case STRING_STRING:
			case PAIR_STRING:
				{
				setState(70); type();
				setState(71); match(IDENT);
				setState(72); match(EQUAL);
				setState(73); assign_rhs();
				}
				break;
			case IDENT:
			case FST:
			case SND:
				{
				setState(75); assign_lhs();
				setState(76); match(EQUAL);
				setState(77); assign_rhs();
				}
				break;
			case READ:
				{
				setState(79); match(READ);
				setState(80); assign_lhs();
				}
				break;
			case FREE:
				{
				setState(81); match(FREE);
				setState(82); expr(0);
				}
				break;
			case RETURN:
				{
				setState(83); match(RETURN);
				setState(84); expr(0);
				}
				break;
			case EXIT:
				{
				setState(85); match(EXIT);
				setState(86); expr(0);
				}
				break;
			case PRINT:
				{
				setState(87); match(PRINT);
				setState(88); expr(0);
				}
				break;
			case PRINTLN:
				{
				setState(89); match(PRINTLN);
				setState(90); expr(0);
				}
				break;
			case IF:
				{
				setState(91); match(IF);
				setState(92); expr(0);
				setState(93); match(THEN);
				setState(94); stat(0);
				setState(95); match(ELSE);
				setState(96); stat(0);
				setState(97); match(FI);
				}
				break;
			case WHILE:
				{
				setState(99); match(WHILE);
				setState(100); expr(0);
				setState(101); match(DO);
				setState(102); stat(0);
				setState(103); match(DONE);
				}
				break;
			case BEGIN:
				{
				setState(105); match(BEGIN);
				setState(106); stat(0);
				setState(107); match(END);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(116);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new StatContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_stat);
					setState(111);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(112); match(SEMI_COLON);
					setState(113); stat(2);
					}
					} 
				}
				setState(118);
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

	public static class Assign_lhsContext extends ParserRuleContext {
		public Pair_elemContext pair_elem() {
			return getRuleContext(Pair_elemContext.class,0);
		}
		public Array_elemContext array_elem() {
			return getRuleContext(Array_elemContext.class,0);
		}
		public TerminalNode IDENT() { return getToken(WaccParser.IDENT, 0); }
		public Assign_lhsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assign_lhs; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof WaccParserListener ) ((WaccParserListener)listener).enterAssign_lhs(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof WaccParserListener ) ((WaccParserListener)listener).exitAssign_lhs(this);
		}
	}

	public final Assign_lhsContext assign_lhs() throws RecognitionException {
		Assign_lhsContext _localctx = new Assign_lhsContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_assign_lhs);
		try {
			setState(122);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(119); match(IDENT);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(120); array_elem();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(121); pair_elem();
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
		public TerminalNode NEWPAIR() { return getToken(WaccParser.NEWPAIR, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public TerminalNode CLOSE_PAREN() { return getToken(WaccParser.CLOSE_PAREN, 0); }
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode COMMA() { return getToken(WaccParser.COMMA, 0); }
		public TerminalNode CALL() { return getToken(WaccParser.CALL, 0); }
		public Pair_elemContext pair_elem() {
			return getRuleContext(Pair_elemContext.class,0);
		}
		public Array_literContext array_liter() {
			return getRuleContext(Array_literContext.class,0);
		}
		public Arg_listContext arg_list() {
			return getRuleContext(Arg_listContext.class,0);
		}
		public TerminalNode OPEN_PAREN() { return getToken(WaccParser.OPEN_PAREN, 0); }
		public TerminalNode IDENT() { return getToken(WaccParser.IDENT, 0); }
		public Assign_rhsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assign_rhs; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof WaccParserListener ) ((WaccParserListener)listener).enterAssign_rhs(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof WaccParserListener ) ((WaccParserListener)listener).exitAssign_rhs(this);
		}
	}

	public final Assign_rhsContext assign_rhs() throws RecognitionException {
		Assign_rhsContext _localctx = new Assign_rhsContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_assign_rhs);
		int _la;
		try {
			setState(141);
			switch (_input.LA(1)) {
			case OPEN_PAREN:
			case UNARY_OPER:
			case IDENT:
			case INT_LITER:
			case BOOL_LITER:
			case CHAR_LITER:
			case STR_LITER:
			case PAIR_LITER:
				enterOuterAlt(_localctx, 1);
				{
				setState(124); expr(0);
				}
				break;
			case SQUARE_OPEN:
				enterOuterAlt(_localctx, 2);
				{
				setState(125); array_liter();
				}
				break;
			case NEWPAIR:
				enterOuterAlt(_localctx, 3);
				{
				setState(126); match(NEWPAIR);
				setState(127); match(OPEN_PAREN);
				setState(128); expr(0);
				setState(129); match(COMMA);
				setState(130); expr(0);
				setState(131); match(CLOSE_PAREN);
				}
				break;
			case FST:
			case SND:
				enterOuterAlt(_localctx, 4);
				{
				setState(133); pair_elem();
				}
				break;
			case CALL:
				enterOuterAlt(_localctx, 5);
				{
				setState(134); match(CALL);
				setState(135); match(IDENT);
				setState(136); match(OPEN_PAREN);
				setState(138);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << OPEN_PAREN) | (1L << UNARY_OPER) | (1L << IDENT) | (1L << INT_LITER) | (1L << BOOL_LITER) | (1L << CHAR_LITER) | (1L << STR_LITER) | (1L << PAIR_LITER))) != 0)) {
					{
					setState(137); arg_list();
					}
				}

				setState(140); match(CLOSE_PAREN);
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

	public static class Arg_listContext extends ParserRuleContext {
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
		public Arg_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arg_list; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof WaccParserListener ) ((WaccParserListener)listener).enterArg_list(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof WaccParserListener ) ((WaccParserListener)listener).exitArg_list(this);
		}
	}

	public final Arg_listContext arg_list() throws RecognitionException {
		Arg_listContext _localctx = new Arg_listContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_arg_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(143); expr(0);
			setState(148);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(144); match(COMMA);
				setState(145); expr(0);
				}
				}
				setState(150);
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

	public static class Pair_elemContext extends ParserRuleContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode SND() { return getToken(WaccParser.SND, 0); }
		public TerminalNode FST() { return getToken(WaccParser.FST, 0); }
		public Pair_elemContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pair_elem; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof WaccParserListener ) ((WaccParserListener)listener).enterPair_elem(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof WaccParserListener ) ((WaccParserListener)listener).exitPair_elem(this);
		}
	}

	public final Pair_elemContext pair_elem() throws RecognitionException {
		Pair_elemContext _localctx = new Pair_elemContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_pair_elem);
		try {
			setState(155);
			switch (_input.LA(1)) {
			case FST:
				enterOuterAlt(_localctx, 1);
				{
				setState(151); match(FST);
				setState(152); expr(0);
				}
				break;
			case SND:
				enterOuterAlt(_localctx, 2);
				{
				setState(153); match(SND);
				setState(154); expr(0);
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
		public Pair_typeContext pair_type() {
			return getRuleContext(Pair_typeContext.class,0);
		}
		public Base_typeContext base_type() {
			return getRuleContext(Base_typeContext.class,0);
		}
		public Array_typeContext array_type() {
			return getRuleContext(Array_typeContext.class,0);
		}
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof WaccParserListener ) ((WaccParserListener)listener).enterType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof WaccParserListener ) ((WaccParserListener)listener).exitType(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_type);
		try {
			setState(160);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(157); base_type();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(158); array_type();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(159); pair_type();
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

	public static class Type2Context extends ParserRuleContext {
		public Pair_typeContext pair_type() {
			return getRuleContext(Pair_typeContext.class,0);
		}
		public Base_typeContext base_type() {
			return getRuleContext(Base_typeContext.class,0);
		}
		public Type2Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type2; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof WaccParserListener ) ((WaccParserListener)listener).enterType2(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof WaccParserListener ) ((WaccParserListener)listener).exitType2(this);
		}
	}

	public final Type2Context type2() throws RecognitionException {
		Type2Context _localctx = new Type2Context(_ctx, getState());
		enterRule(_localctx, 20, RULE_type2);
		try {
			setState(164);
			switch (_input.LA(1)) {
			case INT_STRING:
			case BOOL_STRING:
			case CHAR_STRING:
			case STRING_STRING:
				enterOuterAlt(_localctx, 1);
				{
				setState(162); base_type();
				}
				break;
			case PAIR_STRING:
				enterOuterAlt(_localctx, 2);
				{
				setState(163); pair_type();
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

	public static class Base_typeContext extends ParserRuleContext {
		public TerminalNode INT_STRING() { return getToken(WaccParser.INT_STRING, 0); }
		public TerminalNode BOOL_STRING() { return getToken(WaccParser.BOOL_STRING, 0); }
		public TerminalNode CHAR_STRING() { return getToken(WaccParser.CHAR_STRING, 0); }
		public TerminalNode STRING_STRING() { return getToken(WaccParser.STRING_STRING, 0); }
		public Base_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_base_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof WaccParserListener ) ((WaccParserListener)listener).enterBase_type(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof WaccParserListener ) ((WaccParserListener)listener).exitBase_type(this);
		}
	}

	public final Base_typeContext base_type() throws RecognitionException {
		Base_typeContext _localctx = new Base_typeContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_base_type);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(166);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INT_STRING) | (1L << BOOL_STRING) | (1L << CHAR_STRING) | (1L << STRING_STRING))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			consume();
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

	public static class Array_typeContext extends ParserRuleContext {
		public TerminalNode SQUARE_CLOSED() { return getToken(WaccParser.SQUARE_CLOSED, 0); }
		public Type2Context type2() {
			return getRuleContext(Type2Context.class,0);
		}
		public TerminalNode SQUARE_OPEN() { return getToken(WaccParser.SQUARE_OPEN, 0); }
		public Array_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_array_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof WaccParserListener ) ((WaccParserListener)listener).enterArray_type(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof WaccParserListener ) ((WaccParserListener)listener).exitArray_type(this);
		}
	}

	public final Array_typeContext array_type() throws RecognitionException {
		Array_typeContext _localctx = new Array_typeContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_array_type);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(168); type2();
			setState(169); match(SQUARE_OPEN);
			setState(170); match(SQUARE_CLOSED);
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

	public static class Pair_typeContext extends ParserRuleContext {
		public List<Pair_elem_typeContext> pair_elem_type() {
			return getRuleContexts(Pair_elem_typeContext.class);
		}
		public TerminalNode CLOSE_PAREN() { return getToken(WaccParser.CLOSE_PAREN, 0); }
		public TerminalNode COMMA() { return getToken(WaccParser.COMMA, 0); }
		public Pair_elem_typeContext pair_elem_type(int i) {
			return getRuleContext(Pair_elem_typeContext.class,i);
		}
		public TerminalNode OPEN_PAREN() { return getToken(WaccParser.OPEN_PAREN, 0); }
		public TerminalNode PAIR_STRING() { return getToken(WaccParser.PAIR_STRING, 0); }
		public Pair_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pair_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof WaccParserListener ) ((WaccParserListener)listener).enterPair_type(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof WaccParserListener ) ((WaccParserListener)listener).exitPair_type(this);
		}
	}

	public final Pair_typeContext pair_type() throws RecognitionException {
		Pair_typeContext _localctx = new Pair_typeContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_pair_type);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(172); match(PAIR_STRING);
			setState(173); match(OPEN_PAREN);
			setState(174); pair_elem_type();
			setState(175); match(COMMA);
			setState(176); pair_elem_type();
			setState(177); match(CLOSE_PAREN);
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

	public static class Pair_elem_typeContext extends ParserRuleContext {
		public Base_typeContext base_type() {
			return getRuleContext(Base_typeContext.class,0);
		}
		public Array_typeContext array_type() {
			return getRuleContext(Array_typeContext.class,0);
		}
		public TerminalNode PAIR_STRING() { return getToken(WaccParser.PAIR_STRING, 0); }
		public Pair_elem_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pair_elem_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof WaccParserListener ) ((WaccParserListener)listener).enterPair_elem_type(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof WaccParserListener ) ((WaccParserListener)listener).exitPair_elem_type(this);
		}
	}

	public final Pair_elem_typeContext pair_elem_type() throws RecognitionException {
		Pair_elem_typeContext _localctx = new Pair_elem_typeContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_pair_elem_type);
		try {
			setState(182);
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(179); base_type();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(180); array_type();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(181); match(PAIR_STRING);
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
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode INT_LITER() { return getToken(WaccParser.INT_LITER, 0); }
		public TerminalNode IDENT() { return getToken(WaccParser.IDENT, 0); }
		public TerminalNode OPEN_PAREN() { return getToken(WaccParser.OPEN_PAREN, 0); }
		public TerminalNode BOOL_LITER() { return getToken(WaccParser.BOOL_LITER, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public TerminalNode CHAR_LITER() { return getToken(WaccParser.CHAR_LITER, 0); }
		public TerminalNode CLOSE_PAREN() { return getToken(WaccParser.CLOSE_PAREN, 0); }
		public TerminalNode BINARY_OPER() { return getToken(WaccParser.BINARY_OPER, 0); }
		public TerminalNode UNARY_OPER() { return getToken(WaccParser.UNARY_OPER, 0); }
		public TerminalNode STR_LITER() { return getToken(WaccParser.STR_LITER, 0); }
		public TerminalNode PAIR_LITER() { return getToken(WaccParser.PAIR_LITER, 0); }
		public Array_elemContext array_elem() {
			return getRuleContext(Array_elemContext.class,0);
		}
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof WaccParserListener ) ((WaccParserListener)listener).enterExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof WaccParserListener ) ((WaccParserListener)listener).exitExpr(this);
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
		int _startState = 30;
		enterRecursionRule(_localctx, 30, RULE_expr, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(198);
			switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
			case 1:
				{
				setState(185); match(UNARY_OPER);
				setState(186); expr(3);
				}
				break;
			case 2:
				{
				setState(187); match(INT_LITER);
				}
				break;
			case 3:
				{
				setState(188); match(BOOL_LITER);
				}
				break;
			case 4:
				{
				setState(189); match(CHAR_LITER);
				}
				break;
			case 5:
				{
				setState(190); match(STR_LITER);
				}
				break;
			case 6:
				{
				setState(191); match(PAIR_LITER);
				}
				break;
			case 7:
				{
				setState(192); match(IDENT);
				}
				break;
			case 8:
				{
				setState(193); array_elem();
				}
				break;
			case 9:
				{
				setState(194); match(OPEN_PAREN);
				setState(195); expr(0);
				setState(196); match(CLOSE_PAREN);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(205);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new ExprContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_expr);
					setState(200);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(201); match(BINARY_OPER);
					setState(202); expr(3);
					}
					} 
				}
				setState(207);
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

	public static class Array_elemContext extends ParserRuleContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode IDENT() { return getToken(WaccParser.IDENT, 0); }
		public Array_elemContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_array_elem; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof WaccParserListener ) ((WaccParserListener)listener).enterArray_elem(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof WaccParserListener ) ((WaccParserListener)listener).exitArray_elem(this);
		}
	}

	public final Array_elemContext array_elem() throws RecognitionException {
		Array_elemContext _localctx = new Array_elemContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_array_elem);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(208); match(IDENT);
			setState(213); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(209); match(SQUARE_OPEN);
					setState(210); expr(0);
					setState(211); match(SQUARE_CLOSED);
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(215); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
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

	public static class Array_literContext extends ParserRuleContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public Array_literContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_array_liter; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof WaccParserListener ) ((WaccParserListener)listener).enterArray_liter(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof WaccParserListener ) ((WaccParserListener)listener).exitArray_liter(this);
		}
	}

	public final Array_literContext array_liter() throws RecognitionException {
		Array_literContext _localctx = new Array_literContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_array_liter);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(217); match(SQUARE_OPEN);
			setState(226);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << OPEN_PAREN) | (1L << UNARY_OPER) | (1L << IDENT) | (1L << INT_LITER) | (1L << BOOL_LITER) | (1L << CHAR_LITER) | (1L << STR_LITER) | (1L << PAIR_LITER))) != 0)) {
				{
				setState(218); expr(0);
				setState(223);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(219); match(COMMA);
					setState(220); expr(0);
					}
					}
					setState(225);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(228); match(SQUARE_CLOSED);
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
		case 4: return stat_sempred((StatContext)_localctx, predIndex);
		case 15: return expr_sempred((ExprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean stat_sempred(StatContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0: return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean expr_sempred(ExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 1: return precpred(_ctx, 2);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\61\u00e9\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\3\2\3\2\7\2)\n\2\f\2\16\2,\13\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3"+
		"\5\3\65\n\3\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\7\4?\n\4\f\4\16\4B\13\4\3"+
		"\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6"+
		"\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3"+
		"\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\5\6p\n\6\3\6\3\6\3\6\7\6u\n\6\f\6\16"+
		"\6x\13\6\3\7\3\7\3\7\5\7}\n\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b"+
		"\3\b\3\b\3\b\3\b\5\b\u008d\n\b\3\b\5\b\u0090\n\b\3\t\3\t\3\t\7\t\u0095"+
		"\n\t\f\t\16\t\u0098\13\t\3\n\3\n\3\n\3\n\5\n\u009e\n\n\3\13\3\13\3\13"+
		"\5\13\u00a3\n\13\3\f\3\f\5\f\u00a7\n\f\3\r\3\r\3\16\3\16\3\16\3\16\3\17"+
		"\3\17\3\17\3\17\3\17\3\17\3\17\3\20\3\20\3\20\5\20\u00b9\n\20\3\21\3\21"+
		"\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\5\21\u00c9"+
		"\n\21\3\21\3\21\3\21\7\21\u00ce\n\21\f\21\16\21\u00d1\13\21\3\22\3\22"+
		"\3\22\3\22\3\22\6\22\u00d8\n\22\r\22\16\22\u00d9\3\23\3\23\3\23\3\23\7"+
		"\23\u00e0\n\23\f\23\16\23\u00e3\13\23\5\23\u00e5\n\23\3\23\3\23\3\23\2"+
		"\4\n \24\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$\2\3\3\2+.\u00ff\2"+
		"&\3\2\2\2\4\60\3\2\2\2\6;\3\2\2\2\bC\3\2\2\2\no\3\2\2\2\f|\3\2\2\2\16"+
		"\u008f\3\2\2\2\20\u0091\3\2\2\2\22\u009d\3\2\2\2\24\u00a2\3\2\2\2\26\u00a6"+
		"\3\2\2\2\30\u00a8\3\2\2\2\32\u00aa\3\2\2\2\34\u00ae\3\2\2\2\36\u00b8\3"+
		"\2\2\2 \u00c8\3\2\2\2\"\u00d2\3\2\2\2$\u00db\3\2\2\2&*\7\23\2\2\')\5\4"+
		"\3\2(\'\3\2\2\2),\3\2\2\2*(\3\2\2\2*+\3\2\2\2+-\3\2\2\2,*\3\2\2\2-.\5"+
		"\n\6\2./\7\24\2\2/\3\3\2\2\2\60\61\5\24\13\2\61\62\7\7\2\2\62\64\7\3\2"+
		"\2\63\65\5\6\4\2\64\63\3\2\2\2\64\65\3\2\2\2\65\66\3\2\2\2\66\67\7\4\2"+
		"\2\678\7\25\2\289\5\n\6\29:\7\24\2\2:\5\3\2\2\2;@\5\b\5\2<=\7\26\2\2="+
		"?\5\b\5\2><\3\2\2\2?B\3\2\2\2@>\3\2\2\2@A\3\2\2\2A\7\3\2\2\2B@\3\2\2\2"+
		"CD\5\24\13\2DE\7\7\2\2E\t\3\2\2\2FG\b\6\1\2Gp\7\27\2\2HI\5\24\13\2IJ\7"+
		"\7\2\2JK\7\30\2\2KL\5\16\b\2Lp\3\2\2\2MN\5\f\7\2NO\7\30\2\2OP\5\16\b\2"+
		"Pp\3\2\2\2QR\7\31\2\2Rp\5\f\7\2ST\7\32\2\2Tp\5 \21\2UV\7\33\2\2Vp\5 \21"+
		"\2WX\7\34\2\2Xp\5 \21\2YZ\7\35\2\2Zp\5 \21\2[\\\7\36\2\2\\p\5 \21\2]^"+
		"\7\37\2\2^_\5 \21\2_`\7 \2\2`a\5\n\6\2ab\7!\2\2bc\5\n\6\2cd\7\"\2\2dp"+
		"\3\2\2\2ef\7#\2\2fg\5 \21\2gh\7$\2\2hi\5\n\6\2ij\7%\2\2jp\3\2\2\2kl\7"+
		"\23\2\2lm\5\n\6\2mn\7\24\2\2np\3\2\2\2oF\3\2\2\2oH\3\2\2\2oM\3\2\2\2o"+
		"Q\3\2\2\2oS\3\2\2\2oU\3\2\2\2oW\3\2\2\2oY\3\2\2\2o[\3\2\2\2o]\3\2\2\2"+
		"oe\3\2\2\2ok\3\2\2\2pv\3\2\2\2qr\f\3\2\2rs\7&\2\2su\5\n\6\4tq\3\2\2\2"+
		"ux\3\2\2\2vt\3\2\2\2vw\3\2\2\2w\13\3\2\2\2xv\3\2\2\2y}\7\7\2\2z}\5\"\22"+
		"\2{}\5\22\n\2|y\3\2\2\2|z\3\2\2\2|{\3\2\2\2}\r\3\2\2\2~\u0090\5 \21\2"+
		"\177\u0090\5$\23\2\u0080\u0081\7\'\2\2\u0081\u0082\7\3\2\2\u0082\u0083"+
		"\5 \21\2\u0083\u0084\7\26\2\2\u0084\u0085\5 \21\2\u0085\u0086\7\4\2\2"+
		"\u0086\u0090\3\2\2\2\u0087\u0090\5\22\n\2\u0088\u0089\7(\2\2\u0089\u008a"+
		"\7\7\2\2\u008a\u008c\7\3\2\2\u008b\u008d\5\20\t\2\u008c\u008b\3\2\2\2"+
		"\u008c\u008d\3\2\2\2\u008d\u008e\3\2\2\2\u008e\u0090\7\4\2\2\u008f~\3"+
		"\2\2\2\u008f\177\3\2\2\2\u008f\u0080\3\2\2\2\u008f\u0087\3\2\2\2\u008f"+
		"\u0088\3\2\2\2\u0090\17\3\2\2\2\u0091\u0096\5 \21\2\u0092\u0093\7\26\2"+
		"\2\u0093\u0095\5 \21\2\u0094\u0092\3\2\2\2\u0095\u0098\3\2\2\2\u0096\u0094"+
		"\3\2\2\2\u0096\u0097\3\2\2\2\u0097\21\3\2\2\2\u0098\u0096\3\2\2\2\u0099"+
		"\u009a\7)\2\2\u009a\u009e\5 \21\2\u009b\u009c\7*\2\2\u009c\u009e\5 \21"+
		"\2\u009d\u0099\3\2\2\2\u009d\u009b\3\2\2\2\u009e\23\3\2\2\2\u009f\u00a3"+
		"\5\30\r\2\u00a0\u00a3\5\32\16\2\u00a1\u00a3\5\34\17\2\u00a2\u009f\3\2"+
		"\2\2\u00a2\u00a0\3\2\2\2\u00a2\u00a1\3\2\2\2\u00a3\25\3\2\2\2\u00a4\u00a7"+
		"\5\30\r\2\u00a5\u00a7\5\34\17\2\u00a6\u00a4\3\2\2\2\u00a6\u00a5\3\2\2"+
		"\2\u00a7\27\3\2\2\2\u00a8\u00a9\t\2\2\2\u00a9\31\3\2\2\2\u00aa\u00ab\5"+
		"\26\f\2\u00ab\u00ac\7/\2\2\u00ac\u00ad\7\60\2\2\u00ad\33\3\2\2\2\u00ae"+
		"\u00af\7\61\2\2\u00af\u00b0\7\3\2\2\u00b0\u00b1\5\36\20\2\u00b1\u00b2"+
		"\7\26\2\2\u00b2\u00b3\5\36\20\2\u00b3\u00b4\7\4\2\2\u00b4\35\3\2\2\2\u00b5"+
		"\u00b9\5\30\r\2\u00b6\u00b9\5\32\16\2\u00b7\u00b9\7\61\2\2\u00b8\u00b5"+
		"\3\2\2\2\u00b8\u00b6\3\2\2\2\u00b8\u00b7\3\2\2\2\u00b9\37\3\2\2\2\u00ba"+
		"\u00bb\b\21\1\2\u00bb\u00bc\7\5\2\2\u00bc\u00c9\5 \21\5\u00bd\u00c9\7"+
		"\t\2\2\u00be\u00c9\7\13\2\2\u00bf\u00c9\7\f\2\2\u00c0\u00c9\7\r\2\2\u00c1"+
		"\u00c9\7\20\2\2\u00c2\u00c9\7\7\2\2\u00c3\u00c9\5\"\22\2\u00c4\u00c5\7"+
		"\3\2\2\u00c5\u00c6\5 \21\2\u00c6\u00c7\7\4\2\2\u00c7\u00c9\3\2\2\2\u00c8"+
		"\u00ba\3\2\2\2\u00c8\u00bd\3\2\2\2\u00c8\u00be\3\2\2\2\u00c8\u00bf\3\2"+
		"\2\2\u00c8\u00c0\3\2\2\2\u00c8\u00c1\3\2\2\2\u00c8\u00c2\3\2\2\2\u00c8"+
		"\u00c3\3\2\2\2\u00c8\u00c4\3\2\2\2\u00c9\u00cf\3\2\2\2\u00ca\u00cb\f\4"+
		"\2\2\u00cb\u00cc\7\6\2\2\u00cc\u00ce\5 \21\5\u00cd\u00ca\3\2\2\2\u00ce"+
		"\u00d1\3\2\2\2\u00cf\u00cd\3\2\2\2\u00cf\u00d0\3\2\2\2\u00d0!\3\2\2\2"+
		"\u00d1\u00cf\3\2\2\2\u00d2\u00d7\7\7\2\2\u00d3\u00d4\7/\2\2\u00d4\u00d5"+
		"\5 \21\2\u00d5\u00d6\7\60\2\2\u00d6\u00d8\3\2\2\2\u00d7\u00d3\3\2\2\2"+
		"\u00d8\u00d9\3\2\2\2\u00d9\u00d7\3\2\2\2\u00d9\u00da\3\2\2\2\u00da#\3"+
		"\2\2\2\u00db\u00e4\7/\2\2\u00dc\u00e1\5 \21\2\u00dd\u00de\7\26\2\2\u00de"+
		"\u00e0\5 \21\2\u00df\u00dd\3\2\2\2\u00e0\u00e3\3\2\2\2\u00e1\u00df\3\2"+
		"\2\2\u00e1\u00e2\3\2\2\2\u00e2\u00e5\3\2\2\2\u00e3\u00e1\3\2\2\2\u00e4"+
		"\u00dc\3\2\2\2\u00e4\u00e5\3\2\2\2\u00e5\u00e6\3\2\2\2\u00e6\u00e7\7\60"+
		"\2\2\u00e7%\3\2\2\2\24*\64@ov|\u008c\u008f\u0096\u009d\u00a2\u00a6\u00b8"+
		"\u00c8\u00cf\u00d9\u00e1\u00e4";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}