// Generated from ./WaccParser.g4 by ANTLR 4.4
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
	static { RuntimeMetaData.checkVersion("4.4", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		PRINT=15, INT_STRING=29, NEWPAIR=25, SQUARE_OPEN=33, STR_LITER=43, PAIR_LITER=46, 
		DO=22, PAIR_STRING=35, WHITESPACE=2, UNARY_OPER=38, ELSE=19, IF=17, BOOL_LITER=41, 
		INTEGER=48, DONE=23, NEWLINE=3, FST=27, BINARY_OPER=39, IS=7, READ=11, 
		OPEN_PAREN=36, SQUARE_CLOSED=34, INT_SIGN=40, END=6, THEN=18, SEMI_COLON=24, 
		CLOSE_PAREN=37, EXIT=14, CALL=26, CHAR_STRING=31, ESCAPED_CHAR=45, FI=20, 
		PRINTLN=16, SND=28, BEGIN=5, FREE=12, COMMENT=1, RETURN=13, SKIP=9, CHARACTER=44, 
		COMMA=8, STRING_STRING=32, EOL=4, EQUAL=10, BOOL_STRING=30, CHAR_LITER=42, 
		INT_LITER=49, IDENT=47, WHILE=21;
	public static final String[] tokenNames = {
		"<INVALID>", "COMMENT", "WHITESPACE", "NEWLINE", "'\\n'", "'begin'", "'end'", 
		"'is'", "','", "'skip'", "'='", "'read'", "'free'", "'return'", "'exit'", 
		"'print'", "'println'", "'if'", "'then'", "'else'", "'fi'", "'while'", 
		"'do'", "'done'", "';'", "'newpair'", "'call'", "'fst'", "'snd'", "'int'", 
		"'bool'", "'char'", "'string'", "'['", "']'", "'pair'", "'('", "')'", 
		"UNARY_OPER", "BINARY_OPER", "INT_SIGN", "BOOL_LITER", "CHAR_LITER", "STR_LITER", 
		"CHARACTER", "ESCAPED_CHAR", "'null'", "IDENT", "INTEGER", "INT_LITER"
	};
	public static final int
		RULE_func = 0, RULE_param_list = 1, RULE_param = 2, RULE_stat = 3, RULE_assign_lhs = 4, 
		RULE_assign_rhs = 5, RULE_arg_list = 6, RULE_pair_elem = 7, RULE_type = 8, 
		RULE_type2 = 9, RULE_base_type = 10, RULE_array_type = 11, RULE_pair_type = 12, 
		RULE_pair_elem_type = 13, RULE_expr = 14, RULE_array_elem = 15, RULE_array_liter = 16, 
		RULE_program = 17;
	public static final String[] ruleNames = {
		"func", "param_list", "param", "stat", "assign_lhs", "assign_rhs", "arg_list", 
		"pair_elem", "type", "type2", "base_type", "array_type", "pair_type", 
		"pair_elem_type", "expr", "array_elem", "array_liter", "program"
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
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WaccParserVisitor ) return ((WaccParserVisitor<? extends T>)visitor).visitFunc(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FuncContext func() throws RecognitionException {
		FuncContext _localctx = new FuncContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_func);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(36); type();
			setState(37); match(IDENT);
			setState(38); match(OPEN_PAREN);
			setState(40);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INT_STRING) | (1L << BOOL_STRING) | (1L << CHAR_STRING) | (1L << STRING_STRING) | (1L << PAIR_STRING))) != 0)) {
				{
				setState(39); param_list();
				}
			}

			setState(42); match(CLOSE_PAREN);
			setState(43); match(IS);
			setState(44); stat(0);
			setState(45); match(END);
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
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WaccParserVisitor ) return ((WaccParserVisitor<? extends T>)visitor).visitParam_list(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Param_listContext param_list() throws RecognitionException {
		Param_listContext _localctx = new Param_listContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_param_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(47); param();
			setState(52);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(48); match(COMMA);
				setState(49); param();
				}
				}
				setState(54);
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
		enterRule(_localctx, 4, RULE_param);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(55); type();
			setState(56); match(IDENT);
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
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WaccParserVisitor ) return ((WaccParserVisitor<? extends T>)visitor).visitStat(this);
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
		int _startState = 6;
		enterRecursionRule(_localctx, 6, RULE_stat, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(99);
			switch (_input.LA(1)) {
			case SKIP:
				{
				setState(59); match(SKIP);
				}
				break;
			case INT_STRING:
			case BOOL_STRING:
			case CHAR_STRING:
			case STRING_STRING:
			case PAIR_STRING:
				{
				setState(60); type();
				setState(61); match(IDENT);
				setState(62); match(EQUAL);
				setState(63); assign_rhs();
				}
				break;
			case FST:
			case SND:
			case IDENT:
				{
				setState(65); assign_lhs();
				setState(66); match(EQUAL);
				setState(67); assign_rhs();
				}
				break;
			case READ:
				{
				setState(69); match(READ);
				setState(70); assign_lhs();
				}
				break;
			case FREE:
				{
				setState(71); match(FREE);
				setState(72); expr(0);
				}
				break;
			case RETURN:
				{
				setState(73); match(RETURN);
				setState(74); expr(0);
				}
				break;
			case EXIT:
				{
				setState(75); match(EXIT);
				setState(76); expr(0);
				}
				break;
			case PRINT:
				{
				setState(77); match(PRINT);
				setState(78); expr(0);
				}
				break;
			case PRINTLN:
				{
				setState(79); match(PRINTLN);
				setState(80); expr(0);
				}
				break;
			case IF:
				{
				setState(81); match(IF);
				setState(82); expr(0);
				setState(83); match(THEN);
				setState(84); stat(0);
				setState(85); match(ELSE);
				setState(86); stat(0);
				setState(87); match(FI);
				}
				break;
			case WHILE:
				{
				setState(89); match(WHILE);
				setState(90); expr(0);
				setState(91); match(DO);
				setState(92); stat(0);
				setState(93); match(DONE);
				}
				break;
			case BEGIN:
				{
				setState(95); match(BEGIN);
				setState(96); stat(0);
				setState(97); match(END);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(106);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new StatContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_stat);
					setState(101);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(102); match(SEMI_COLON);
					setState(103); stat(2);
					}
					} 
				}
				setState(108);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
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
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WaccParserVisitor ) return ((WaccParserVisitor<? extends T>)visitor).visitAssign_lhs(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Assign_lhsContext assign_lhs() throws RecognitionException {
		Assign_lhsContext _localctx = new Assign_lhsContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_assign_lhs);
		try {
			setState(112);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(109); match(IDENT);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(110); array_elem();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(111); pair_elem();
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
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WaccParserVisitor ) return ((WaccParserVisitor<? extends T>)visitor).visitAssign_rhs(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Assign_rhsContext assign_rhs() throws RecognitionException {
		Assign_rhsContext _localctx = new Assign_rhsContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_assign_rhs);
		int _la;
		try {
			setState(131);
			switch (_input.LA(1)) {
			case OPEN_PAREN:
			case UNARY_OPER:
			case BOOL_LITER:
			case CHAR_LITER:
			case STR_LITER:
			case PAIR_LITER:
			case IDENT:
			case INT_LITER:
				enterOuterAlt(_localctx, 1);
				{
				setState(114); expr(0);
				}
				break;
			case SQUARE_OPEN:
				enterOuterAlt(_localctx, 2);
				{
				setState(115); array_liter();
				}
				break;
			case NEWPAIR:
				enterOuterAlt(_localctx, 3);
				{
				setState(116); match(NEWPAIR);
				setState(117); match(OPEN_PAREN);
				setState(118); expr(0);
				setState(119); match(COMMA);
				setState(120); expr(0);
				setState(121); match(CLOSE_PAREN);
				}
				break;
			case FST:
			case SND:
				enterOuterAlt(_localctx, 4);
				{
				setState(123); pair_elem();
				}
				break;
			case CALL:
				enterOuterAlt(_localctx, 5);
				{
				setState(124); match(CALL);
				setState(125); match(IDENT);
				setState(126); match(OPEN_PAREN);
				setState(128);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << OPEN_PAREN) | (1L << UNARY_OPER) | (1L << BOOL_LITER) | (1L << CHAR_LITER) | (1L << STR_LITER) | (1L << PAIR_LITER) | (1L << IDENT) | (1L << INT_LITER))) != 0)) {
					{
					setState(127); arg_list();
					}
				}

				setState(130); match(CLOSE_PAREN);
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
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WaccParserVisitor ) return ((WaccParserVisitor<? extends T>)visitor).visitArg_list(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Arg_listContext arg_list() throws RecognitionException {
		Arg_listContext _localctx = new Arg_listContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_arg_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(133); expr(0);
			setState(138);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(134); match(COMMA);
				setState(135); expr(0);
				}
				}
				setState(140);
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
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WaccParserVisitor ) return ((WaccParserVisitor<? extends T>)visitor).visitPair_elem(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Pair_elemContext pair_elem() throws RecognitionException {
		Pair_elemContext _localctx = new Pair_elemContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_pair_elem);
		try {
			setState(145);
			switch (_input.LA(1)) {
			case FST:
				enterOuterAlt(_localctx, 1);
				{
				setState(141); match(FST);
				setState(142); expr(0);
				}
				break;
			case SND:
				enterOuterAlt(_localctx, 2);
				{
				setState(143); match(SND);
				setState(144); expr(0);
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
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WaccParserVisitor ) return ((WaccParserVisitor<? extends T>)visitor).visitType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_type);
		try {
			setState(150);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(147); base_type();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(148); array_type();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(149); pair_type();
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
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WaccParserVisitor ) return ((WaccParserVisitor<? extends T>)visitor).visitType2(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Type2Context type2() throws RecognitionException {
		Type2Context _localctx = new Type2Context(_ctx, getState());
		enterRule(_localctx, 18, RULE_type2);
		try {
			setState(154);
			switch (_input.LA(1)) {
			case INT_STRING:
			case BOOL_STRING:
			case CHAR_STRING:
			case STRING_STRING:
				enterOuterAlt(_localctx, 1);
				{
				setState(152); base_type();
				}
				break;
			case PAIR_STRING:
				enterOuterAlt(_localctx, 2);
				{
				setState(153); pair_type();
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
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WaccParserVisitor ) return ((WaccParserVisitor<? extends T>)visitor).visitBase_type(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Base_typeContext base_type() throws RecognitionException {
		Base_typeContext _localctx = new Base_typeContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_base_type);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(156);
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
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WaccParserVisitor ) return ((WaccParserVisitor<? extends T>)visitor).visitArray_type(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Array_typeContext array_type() throws RecognitionException {
		Array_typeContext _localctx = new Array_typeContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_array_type);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(158); type2();
			setState(159); match(SQUARE_OPEN);
			setState(160); match(SQUARE_CLOSED);
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
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WaccParserVisitor ) return ((WaccParserVisitor<? extends T>)visitor).visitPair_type(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Pair_typeContext pair_type() throws RecognitionException {
		Pair_typeContext _localctx = new Pair_typeContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_pair_type);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(162); match(PAIR_STRING);
			setState(163); match(OPEN_PAREN);
			setState(164); pair_elem_type();
			setState(165); match(COMMA);
			setState(166); pair_elem_type();
			setState(167); match(CLOSE_PAREN);
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
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WaccParserVisitor ) return ((WaccParserVisitor<? extends T>)visitor).visitPair_elem_type(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Pair_elem_typeContext pair_elem_type() throws RecognitionException {
		Pair_elem_typeContext _localctx = new Pair_elem_typeContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_pair_elem_type);
		try {
			setState(172);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(169); base_type();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(170); array_type();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(171); match(PAIR_STRING);
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
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WaccParserVisitor ) return ((WaccParserVisitor<? extends T>)visitor).visitExpr(this);
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
		int _startState = 28;
		enterRecursionRule(_localctx, 28, RULE_expr, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(188);
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
			case 1:
				{
				setState(175); match(UNARY_OPER);
				setState(176); expr(3);
				}
				break;
			case 2:
				{
				setState(177); match(INT_LITER);
				}
				break;
			case 3:
				{
				setState(178); match(BOOL_LITER);
				}
				break;
			case 4:
				{
				setState(179); match(CHAR_LITER);
				}
				break;
			case 5:
				{
				setState(180); match(STR_LITER);
				}
				break;
			case 6:
				{
				setState(181); match(PAIR_LITER);
				}
				break;
			case 7:
				{
				setState(182); match(IDENT);
				}
				break;
			case 8:
				{
				setState(183); array_elem();
				}
				break;
			case 9:
				{
				setState(184); match(OPEN_PAREN);
				setState(185); expr(0);
				setState(186); match(CLOSE_PAREN);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(195);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new ExprContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_expr);
					setState(190);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(191); match(BINARY_OPER);
					setState(192); expr(3);
					}
					} 
				}
				setState(197);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
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
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WaccParserVisitor ) return ((WaccParserVisitor<? extends T>)visitor).visitArray_elem(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Array_elemContext array_elem() throws RecognitionException {
		Array_elemContext _localctx = new Array_elemContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_array_elem);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(198); match(IDENT);
			setState(203); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(199); match(SQUARE_OPEN);
					setState(200); expr(0);
					setState(201); match(SQUARE_CLOSED);
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(205); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
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
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WaccParserVisitor ) return ((WaccParserVisitor<? extends T>)visitor).visitArray_liter(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Array_literContext array_liter() throws RecognitionException {
		Array_literContext _localctx = new Array_literContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_array_liter);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(207); match(SQUARE_OPEN);
			setState(216);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << OPEN_PAREN) | (1L << UNARY_OPER) | (1L << BOOL_LITER) | (1L << CHAR_LITER) | (1L << STR_LITER) | (1L << PAIR_LITER) | (1L << IDENT) | (1L << INT_LITER))) != 0)) {
				{
				setState(208); expr(0);
				setState(213);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(209); match(COMMA);
					setState(210); expr(0);
					}
					}
					setState(215);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(218); match(SQUARE_CLOSED);
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

	public static class ProgramContext extends ParserRuleContext {
		public List<TerminalNode> COMMENT() { return getTokens(WaccParser.COMMENT); }
		public TerminalNode EOF() { return getToken(WaccParser.EOF, 0); }
		public List<TerminalNode> NEWLINE() { return getTokens(WaccParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(WaccParser.NEWLINE, i);
		}
		public List<FuncContext> func() {
			return getRuleContexts(FuncContext.class);
		}
		public TerminalNode COMMENT(int i) {
			return getToken(WaccParser.COMMENT, i);
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
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WaccParserVisitor ) return ((WaccParserVisitor<? extends T>)visitor).visitProgram(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_program);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(223);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NEWLINE) {
				{
				{
				setState(220); match(NEWLINE);
				}
				}
				setState(225);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(229);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMENT) {
				{
				{
				setState(226); match(COMMENT);
				}
				}
				setState(231);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(232); match(BEGIN);
			setState(236);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,19,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(233); func();
					}
					} 
				}
				setState(238);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,19,_ctx);
			}
			setState(239); stat(0);
			setState(240); match(END);
			setState(241); match(EOF);
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
		case 3: return stat_sempred((StatContext)_localctx, predIndex);
		case 14: return expr_sempred((ExprContext)_localctx, predIndex);
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\63\u00f6\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\3\2\3\2\3\2\3\2\5\2+\n\2\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3\7"+
		"\3\65\n\3\f\3\16\38\13\3\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3"+
		"\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5"+
		"\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\5\5f\n\5"+
		"\3\5\3\5\3\5\7\5k\n\5\f\5\16\5n\13\5\3\6\3\6\3\6\5\6s\n\6\3\7\3\7\3\7"+
		"\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\5\7\u0083\n\7\3\7\5\7\u0086"+
		"\n\7\3\b\3\b\3\b\7\b\u008b\n\b\f\b\16\b\u008e\13\b\3\t\3\t\3\t\3\t\5\t"+
		"\u0094\n\t\3\n\3\n\3\n\5\n\u0099\n\n\3\13\3\13\5\13\u009d\n\13\3\f\3\f"+
		"\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\17\3\17\3\17\5\17"+
		"\u00af\n\17\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20"+
		"\3\20\3\20\5\20\u00bf\n\20\3\20\3\20\3\20\7\20\u00c4\n\20\f\20\16\20\u00c7"+
		"\13\20\3\21\3\21\3\21\3\21\3\21\6\21\u00ce\n\21\r\21\16\21\u00cf\3\22"+
		"\3\22\3\22\3\22\7\22\u00d6\n\22\f\22\16\22\u00d9\13\22\5\22\u00db\n\22"+
		"\3\22\3\22\3\23\7\23\u00e0\n\23\f\23\16\23\u00e3\13\23\3\23\7\23\u00e6"+
		"\n\23\f\23\16\23\u00e9\13\23\3\23\3\23\7\23\u00ed\n\23\f\23\16\23\u00f0"+
		"\13\23\3\23\3\23\3\23\3\23\3\23\2\4\b\36\24\2\4\6\b\n\f\16\20\22\24\26"+
		"\30\32\34\36 \"$\2\3\3\2\37\"\u010e\2&\3\2\2\2\4\61\3\2\2\2\69\3\2\2\2"+
		"\be\3\2\2\2\nr\3\2\2\2\f\u0085\3\2\2\2\16\u0087\3\2\2\2\20\u0093\3\2\2"+
		"\2\22\u0098\3\2\2\2\24\u009c\3\2\2\2\26\u009e\3\2\2\2\30\u00a0\3\2\2\2"+
		"\32\u00a4\3\2\2\2\34\u00ae\3\2\2\2\36\u00be\3\2\2\2 \u00c8\3\2\2\2\"\u00d1"+
		"\3\2\2\2$\u00e1\3\2\2\2&\'\5\22\n\2\'(\7\61\2\2(*\7&\2\2)+\5\4\3\2*)\3"+
		"\2\2\2*+\3\2\2\2+,\3\2\2\2,-\7\'\2\2-.\7\t\2\2./\5\b\5\2/\60\7\b\2\2\60"+
		"\3\3\2\2\2\61\66\5\6\4\2\62\63\7\n\2\2\63\65\5\6\4\2\64\62\3\2\2\2\65"+
		"8\3\2\2\2\66\64\3\2\2\2\66\67\3\2\2\2\67\5\3\2\2\28\66\3\2\2\29:\5\22"+
		"\n\2:;\7\61\2\2;\7\3\2\2\2<=\b\5\1\2=f\7\13\2\2>?\5\22\n\2?@\7\61\2\2"+
		"@A\7\f\2\2AB\5\f\7\2Bf\3\2\2\2CD\5\n\6\2DE\7\f\2\2EF\5\f\7\2Ff\3\2\2\2"+
		"GH\7\r\2\2Hf\5\n\6\2IJ\7\16\2\2Jf\5\36\20\2KL\7\17\2\2Lf\5\36\20\2MN\7"+
		"\20\2\2Nf\5\36\20\2OP\7\21\2\2Pf\5\36\20\2QR\7\22\2\2Rf\5\36\20\2ST\7"+
		"\23\2\2TU\5\36\20\2UV\7\24\2\2VW\5\b\5\2WX\7\25\2\2XY\5\b\5\2YZ\7\26\2"+
		"\2Zf\3\2\2\2[\\\7\27\2\2\\]\5\36\20\2]^\7\30\2\2^_\5\b\5\2_`\7\31\2\2"+
		"`f\3\2\2\2ab\7\7\2\2bc\5\b\5\2cd\7\b\2\2df\3\2\2\2e<\3\2\2\2e>\3\2\2\2"+
		"eC\3\2\2\2eG\3\2\2\2eI\3\2\2\2eK\3\2\2\2eM\3\2\2\2eO\3\2\2\2eQ\3\2\2\2"+
		"eS\3\2\2\2e[\3\2\2\2ea\3\2\2\2fl\3\2\2\2gh\f\3\2\2hi\7\32\2\2ik\5\b\5"+
		"\4jg\3\2\2\2kn\3\2\2\2lj\3\2\2\2lm\3\2\2\2m\t\3\2\2\2nl\3\2\2\2os\7\61"+
		"\2\2ps\5 \21\2qs\5\20\t\2ro\3\2\2\2rp\3\2\2\2rq\3\2\2\2s\13\3\2\2\2t\u0086"+
		"\5\36\20\2u\u0086\5\"\22\2vw\7\33\2\2wx\7&\2\2xy\5\36\20\2yz\7\n\2\2z"+
		"{\5\36\20\2{|\7\'\2\2|\u0086\3\2\2\2}\u0086\5\20\t\2~\177\7\34\2\2\177"+
		"\u0080\7\61\2\2\u0080\u0082\7&\2\2\u0081\u0083\5\16\b\2\u0082\u0081\3"+
		"\2\2\2\u0082\u0083\3\2\2\2\u0083\u0084\3\2\2\2\u0084\u0086\7\'\2\2\u0085"+
		"t\3\2\2\2\u0085u\3\2\2\2\u0085v\3\2\2\2\u0085}\3\2\2\2\u0085~\3\2\2\2"+
		"\u0086\r\3\2\2\2\u0087\u008c\5\36\20\2\u0088\u0089\7\n\2\2\u0089\u008b"+
		"\5\36\20\2\u008a\u0088\3\2\2\2\u008b\u008e\3\2\2\2\u008c\u008a\3\2\2\2"+
		"\u008c\u008d\3\2\2\2\u008d\17\3\2\2\2\u008e\u008c\3\2\2\2\u008f\u0090"+
		"\7\35\2\2\u0090\u0094\5\36\20\2\u0091\u0092\7\36\2\2\u0092\u0094\5\36"+
		"\20\2\u0093\u008f\3\2\2\2\u0093\u0091\3\2\2\2\u0094\21\3\2\2\2\u0095\u0099"+
		"\5\26\f\2\u0096\u0099\5\30\r\2\u0097\u0099\5\32\16\2\u0098\u0095\3\2\2"+
		"\2\u0098\u0096\3\2\2\2\u0098\u0097\3\2\2\2\u0099\23\3\2\2\2\u009a\u009d"+
		"\5\26\f\2\u009b\u009d\5\32\16\2\u009c\u009a\3\2\2\2\u009c\u009b\3\2\2"+
		"\2\u009d\25\3\2\2\2\u009e\u009f\t\2\2\2\u009f\27\3\2\2\2\u00a0\u00a1\5"+
		"\24\13\2\u00a1\u00a2\7#\2\2\u00a2\u00a3\7$\2\2\u00a3\31\3\2\2\2\u00a4"+
		"\u00a5\7%\2\2\u00a5\u00a6\7&\2\2\u00a6\u00a7\5\34\17\2\u00a7\u00a8\7\n"+
		"\2\2\u00a8\u00a9\5\34\17\2\u00a9\u00aa\7\'\2\2\u00aa\33\3\2\2\2\u00ab"+
		"\u00af\5\26\f\2\u00ac\u00af\5\30\r\2\u00ad\u00af\7%\2\2\u00ae\u00ab\3"+
		"\2\2\2\u00ae\u00ac\3\2\2\2\u00ae\u00ad\3\2\2\2\u00af\35\3\2\2\2\u00b0"+
		"\u00b1\b\20\1\2\u00b1\u00b2\7(\2\2\u00b2\u00bf\5\36\20\5\u00b3\u00bf\7"+
		"\63\2\2\u00b4\u00bf\7+\2\2\u00b5\u00bf\7,\2\2\u00b6\u00bf\7-\2\2\u00b7"+
		"\u00bf\7\60\2\2\u00b8\u00bf\7\61\2\2\u00b9\u00bf\5 \21\2\u00ba\u00bb\7"+
		"&\2\2\u00bb\u00bc\5\36\20\2\u00bc\u00bd\7\'\2\2\u00bd\u00bf\3\2\2\2\u00be"+
		"\u00b0\3\2\2\2\u00be\u00b3\3\2\2\2\u00be\u00b4\3\2\2\2\u00be\u00b5\3\2"+
		"\2\2\u00be\u00b6\3\2\2\2\u00be\u00b7\3\2\2\2\u00be\u00b8\3\2\2\2\u00be"+
		"\u00b9\3\2\2\2\u00be\u00ba\3\2\2\2\u00bf\u00c5\3\2\2\2\u00c0\u00c1\f\4"+
		"\2\2\u00c1\u00c2\7)\2\2\u00c2\u00c4\5\36\20\5\u00c3\u00c0\3\2\2\2\u00c4"+
		"\u00c7\3\2\2\2\u00c5\u00c3\3\2\2\2\u00c5\u00c6\3\2\2\2\u00c6\37\3\2\2"+
		"\2\u00c7\u00c5\3\2\2\2\u00c8\u00cd\7\61\2\2\u00c9\u00ca\7#\2\2\u00ca\u00cb"+
		"\5\36\20\2\u00cb\u00cc\7$\2\2\u00cc\u00ce\3\2\2\2\u00cd\u00c9\3\2\2\2"+
		"\u00ce\u00cf\3\2\2\2\u00cf\u00cd\3\2\2\2\u00cf\u00d0\3\2\2\2\u00d0!\3"+
		"\2\2\2\u00d1\u00da\7#\2\2\u00d2\u00d7\5\36\20\2\u00d3\u00d4\7\n\2\2\u00d4"+
		"\u00d6\5\36\20\2\u00d5\u00d3\3\2\2\2\u00d6\u00d9\3\2\2\2\u00d7\u00d5\3"+
		"\2\2\2\u00d7\u00d8\3\2\2\2\u00d8\u00db\3\2\2\2\u00d9\u00d7\3\2\2\2\u00da"+
		"\u00d2\3\2\2\2\u00da\u00db\3\2\2\2\u00db\u00dc\3\2\2\2\u00dc\u00dd\7$"+
		"\2\2\u00dd#\3\2\2\2\u00de\u00e0\7\5\2\2\u00df\u00de\3\2\2\2\u00e0\u00e3"+
		"\3\2\2\2\u00e1\u00df\3\2\2\2\u00e1\u00e2\3\2\2\2\u00e2\u00e7\3\2\2\2\u00e3"+
		"\u00e1\3\2\2\2\u00e4\u00e6\7\3\2\2\u00e5\u00e4\3\2\2\2\u00e6\u00e9\3\2"+
		"\2\2\u00e7\u00e5\3\2\2\2\u00e7\u00e8\3\2\2\2\u00e8\u00ea\3\2\2\2\u00e9"+
		"\u00e7\3\2\2\2\u00ea\u00ee\7\7\2\2\u00eb\u00ed\5\2\2\2\u00ec\u00eb\3\2"+
		"\2\2\u00ed\u00f0\3\2\2\2\u00ee\u00ec\3\2\2\2\u00ee\u00ef\3\2\2\2\u00ef"+
		"\u00f1\3\2\2\2\u00f0\u00ee\3\2\2\2\u00f1\u00f2\5\b\5\2\u00f2\u00f3\7\b"+
		"\2\2\u00f3\u00f4\7\2\2\3\u00f4%\3\2\2\2\26*\66elr\u0082\u0085\u008c\u0093"+
		"\u0098\u009c\u00ae\u00be\u00c5\u00cf\u00d7\u00da\u00e1\u00e7\u00ee";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}