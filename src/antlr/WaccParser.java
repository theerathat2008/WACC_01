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
		PRINT=12, CALL=16, FI=7, PRINTLN=13, SND=18, NEWPAIR=15, SQUARE_OPEN=26, 
		STR_LITER=34, PAIR_LITER=36, BEGIN=1, DO=21, FREE=9, COMMENT=39, PAIR_STRING=19, 
		RETURN=10, WHITESPACE=40, UNARY_OPER=30, ELSE=6, SKIP=14, IF=4, BOOL_LITER=32, 
		COMMA=24, DONE=22, FST=17, EQUAL=25, BINARY_OPER=31, IS=3, CHAR_LITER=33, 
		INT_LITER=35, READ=8, OPEN_PAREN=28, SQUARE_CLOSED=27, IDENT=38, END=2, 
		THEN=5, WHILE=20, SEMI_COLON=23, CLOSE_PAREN=29, EXIT=11, BASE_TYPE=37;
	public static final String[] tokenNames = {
		"<INVALID>", "'begin'", "'end'", "'is'", "'if'", "'then'", "'else'", "'fi'", 
		"'read'", "'free'", "'return'", "'exit'", "'print'", "'println'", "'skip'", 
		"'newpair'", "'call'", "'fst'", "'snd'", "'pair'", "'while'", "'do'", 
		"'done'", "';'", "','", "'='", "'['", "']'", "'('", "')'", "UNARY_OPER", 
		"BINARY_OPER", "BOOL_LITER", "CHAR_LITER", "STR_LITER", "INT_LITER", "'null'", 
		"BASE_TYPE", "IDENT", "COMMENT", "WHITESPACE"
	};
	public static final int
		RULE_program = 0, RULE_func = 1, RULE_param_list = 2, RULE_param = 3, 
		RULE_stat = 4, RULE_assign_lhs = 5, RULE_assign_rhs = 6, RULE_arg_list = 7, 
		RULE_pair_elem = 8, RULE_type = 9, RULE_pair_elem_type = 10, RULE_expr = 11, 
		RULE_array_elem = 12, RULE_open_paren = 13, RULE_close_paren = 14;
	public static final String[] ruleNames = {
		"program", "func", "param_list", "param", "stat", "assign_lhs", "assign_rhs", 
		"arg_list", "pair_elem", "type", "pair_elem_type", "expr", "array_elem", 
		"open_paren", "close_paren"
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
		public TerminalNode EOF() { return getToken(WaccParser.EOF, 0); }
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
			setState(30); match(BEGIN);
			setState(34);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(31); func();
					}
					} 
				}
				setState(36);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			}
			setState(37); stat(0);
			setState(38); match(END);
			setState(39); match(EOF);
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
		public TerminalNode IS() { return getToken(WaccParser.IS, 0); }
		public Param_listContext param_list() {
			return getRuleContext(Param_listContext.class,0);
		}
		public Close_parenContext close_paren() {
			return getRuleContext(Close_parenContext.class,0);
		}
		public TerminalNode END() { return getToken(WaccParser.END, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public StatContext stat() {
			return getRuleContext(StatContext.class,0);
		}
		public TerminalNode IDENT() { return getToken(WaccParser.IDENT, 0); }
		public Open_parenContext open_paren() {
			return getRuleContext(Open_parenContext.class,0);
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
			setState(41); type(0);
			setState(42); match(IDENT);
			setState(43); open_paren();
			setState(45);
			_la = _input.LA(1);
			if (_la==PAIR_STRING || _la==BASE_TYPE) {
				{
				setState(44); param_list();
				}
			}

			setState(47); close_paren();
			setState(48); match(IS);
			setState(49); stat(0);
			setState(50); match(END);
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
		enterRule(_localctx, 4, RULE_param_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(52); param();
			setState(57);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(53); match(COMMA);
				setState(54); param();
				}
				}
				setState(59);
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
			setState(60); type(0);
			setState(61); match(IDENT);
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
		public TerminalNode SKIP() { return getToken(WaccParser.SKIP, 0); }
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
		public TerminalNode EQUAL() { return getToken(WaccParser.EQUAL, 0); }
		public Assign_rhsContext assign_rhs() {
			return getRuleContext(Assign_rhsContext.class,0);
		}
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode IDENT() { return getToken(WaccParser.IDENT, 0); }
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
		public TerminalNode DONE() { return getToken(WaccParser.DONE, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode DO() { return getToken(WaccParser.DO, 0); }
		public StatContext stat() {
			return getRuleContext(StatContext.class,0);
		}
		public TerminalNode WHILE() { return getToken(WaccParser.WHILE, 0); }
		public WHILE_STATContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WaccParserVisitor ) return ((WaccParserVisitor<? extends T>)visitor).visitWHILE_STAT(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class MULT_STATContext extends StatContext {
		public TerminalNode SEMI_COLON() { return getToken(WaccParser.SEMI_COLON, 0); }
		public StatContext stat(int i) {
			return getRuleContext(StatContext.class,i);
		}
		public List<StatContext> stat() {
			return getRuleContexts(StatContext.class);
		}
		public MULT_STATContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WaccParserVisitor ) return ((WaccParserVisitor<? extends T>)visitor).visitMULT_STAT(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class EXIT_STATContext extends StatContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode EXIT() { return getToken(WaccParser.EXIT, 0); }
		public EXIT_STATContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WaccParserVisitor ) return ((WaccParserVisitor<? extends T>)visitor).visitEXIT_STAT(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class PRINTLN_STATContext extends StatContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode PRINTLN() { return getToken(WaccParser.PRINTLN, 0); }
		public PRINTLN_STATContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WaccParserVisitor ) return ((WaccParserVisitor<? extends T>)visitor).visitPRINTLN_STAT(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BEGIN_END_STATContext extends StatContext {
		public TerminalNode BEGIN() { return getToken(WaccParser.BEGIN, 0); }
		public TerminalNode END() { return getToken(WaccParser.END, 0); }
		public StatContext stat() {
			return getRuleContext(StatContext.class,0);
		}
		public BEGIN_END_STATContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WaccParserVisitor ) return ((WaccParserVisitor<? extends T>)visitor).visitBEGIN_END_STAT(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IF_STATContext extends StatContext {
		public TerminalNode FI() { return getToken(WaccParser.FI, 0); }
		public TerminalNode ELSE() { return getToken(WaccParser.ELSE, 0); }
		public TerminalNode IF() { return getToken(WaccParser.IF, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode THEN() { return getToken(WaccParser.THEN, 0); }
		public StatContext stat(int i) {
			return getRuleContext(StatContext.class,i);
		}
		public List<StatContext> stat() {
			return getRuleContexts(StatContext.class);
		}
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
		public TerminalNode EQUAL() { return getToken(WaccParser.EQUAL, 0); }
		public Assign_rhsContext assign_rhs() {
			return getRuleContext(Assign_rhsContext.class,0);
		}
		public Assign_lhsContext assign_lhs() {
			return getRuleContext(Assign_lhsContext.class,0);
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
			setState(104);
			switch (_input.LA(1)) {
			case SKIP:
				{
				_localctx = new SKIP_STATContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(64); match(SKIP);
				}
				break;
			case PAIR_STRING:
			case BASE_TYPE:
				{
				_localctx = new VAR_DECL_STATContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(65); type(0);
				setState(66); match(IDENT);
				setState(67); match(EQUAL);
				setState(68); assign_rhs();
				}
				break;
			case FST:
			case SND:
			case IDENT:
				{
				_localctx = new ASSIGN_STATContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(70); assign_lhs();
				setState(71); match(EQUAL);
				setState(72); assign_rhs();
				}
				break;
			case READ:
				{
				_localctx = new READ_STATContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(74); match(READ);
				setState(75); assign_lhs();
				}
				break;
			case FREE:
				{
				_localctx = new FREE_STATContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(76); match(FREE);
				setState(77); expr(0);
				}
				break;
			case RETURN:
				{
				_localctx = new RETURN_STATContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(78); match(RETURN);
				setState(79); expr(0);
				}
				break;
			case EXIT:
				{
				_localctx = new EXIT_STATContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(80); match(EXIT);
				setState(81); expr(0);
				}
				break;
			case PRINT:
				{
				_localctx = new PRINT_STATContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(82); match(PRINT);
				setState(83); expr(0);
				}
				break;
			case PRINTLN:
				{
				_localctx = new PRINTLN_STATContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(84); match(PRINTLN);
				setState(85); expr(0);
				}
				break;
			case IF:
				{
				_localctx = new IF_STATContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(86); match(IF);
				setState(87); expr(0);
				setState(88); match(THEN);
				setState(89); stat(0);
				setState(90); match(ELSE);
				setState(91); stat(0);
				setState(92); match(FI);
				}
				break;
			case WHILE:
				{
				_localctx = new WHILE_STATContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(94); match(WHILE);
				setState(95); expr(0);
				setState(96); match(DO);
				setState(97); stat(0);
				setState(98); match(DONE);
				}
				break;
			case BEGIN:
				{
				_localctx = new BEGIN_END_STATContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(100); match(BEGIN);
				setState(101); stat(0);
				setState(102); match(END);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(111);
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
					setState(106);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(107); match(SEMI_COLON);
					setState(108); stat(2);
					}
					} 
				}
				setState(113);
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
		public Array_elemContext array_elem() {
			return getRuleContext(Array_elemContext.class,0);
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
		enterRule(_localctx, 10, RULE_assign_lhs);
		try {
			setState(117);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				_localctx = new IDENT_ASSIGNContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(114); match(IDENT);
				}
				break;
			case 2:
				_localctx = new ARRAY_ELEM_LHSContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(115); array_elem();
				}
				break;
			case 3:
				_localctx = new PAIR_ELEM_LHSContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(116); pair_elem();
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
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public TerminalNode CLOSE_PAREN() { return getToken(WaccParser.CLOSE_PAREN, 0); }
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode COMMA() { return getToken(WaccParser.COMMA, 0); }
		public TerminalNode OPEN_PAREN() { return getToken(WaccParser.OPEN_PAREN, 0); }
		public NEWPAIR_RHSContext(Assign_rhsContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WaccParserVisitor ) return ((WaccParserVisitor<? extends T>)visitor).visitNEWPAIR_RHS(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ARRAY_LITER_RHSContext extends Assign_rhsContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(WaccParser.COMMA); }
		public TerminalNode SQUARE_CLOSED() { return getToken(WaccParser.SQUARE_CLOSED, 0); }
		public TerminalNode SQUARE_OPEN() { return getToken(WaccParser.SQUARE_OPEN, 0); }
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
		public TerminalNode CLOSE_PAREN() { return getToken(WaccParser.CLOSE_PAREN, 0); }
		public TerminalNode CALL() { return getToken(WaccParser.CALL, 0); }
		public Arg_listContext arg_list() {
			return getRuleContext(Arg_listContext.class,0);
		}
		public TerminalNode IDENT() { return getToken(WaccParser.IDENT, 0); }
		public TerminalNode OPEN_PAREN() { return getToken(WaccParser.OPEN_PAREN, 0); }
		public CALL_ASSIGNContext(Assign_rhsContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WaccParserVisitor ) return ((WaccParserVisitor<? extends T>)visitor).visitCALL_ASSIGN(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Assign_rhsContext assign_rhs() throws RecognitionException {
		Assign_rhsContext _localctx = new Assign_rhsContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_assign_rhs);
		int _la;
		try {
			setState(147);
			switch (_input.LA(1)) {
			case OPEN_PAREN:
			case UNARY_OPER:
			case BOOL_LITER:
			case CHAR_LITER:
			case STR_LITER:
			case INT_LITER:
			case PAIR_LITER:
			case IDENT:
				_localctx = new EXPR_ASSIGNContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(119); expr(0);
				}
				break;
			case SQUARE_OPEN:
				_localctx = new ARRAY_LITER_RHSContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(120); match(SQUARE_OPEN);
				setState(129);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << OPEN_PAREN) | (1L << UNARY_OPER) | (1L << BOOL_LITER) | (1L << CHAR_LITER) | (1L << STR_LITER) | (1L << INT_LITER) | (1L << PAIR_LITER) | (1L << IDENT))) != 0)) {
					{
					setState(121); expr(0);
					setState(126);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMMA) {
						{
						{
						setState(122); match(COMMA);
						setState(123); expr(0);
						}
						}
						setState(128);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(131); match(SQUARE_CLOSED);
				}
				break;
			case NEWPAIR:
				_localctx = new NEWPAIR_RHSContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(132); match(NEWPAIR);
				setState(133); match(OPEN_PAREN);
				setState(134); expr(0);
				setState(135); match(COMMA);
				setState(136); expr(0);
				setState(137); match(CLOSE_PAREN);
				}
				break;
			case FST:
			case SND:
				_localctx = new PAIR_ELEM_RHSContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(139); pair_elem();
				}
				break;
			case CALL:
				_localctx = new CALL_ASSIGNContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(140); match(CALL);
				setState(141); match(IDENT);
				setState(142); match(OPEN_PAREN);
				setState(144);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << OPEN_PAREN) | (1L << UNARY_OPER) | (1L << BOOL_LITER) | (1L << CHAR_LITER) | (1L << STR_LITER) | (1L << INT_LITER) | (1L << PAIR_LITER) | (1L << IDENT))) != 0)) {
					{
					setState(143); arg_list();
					}
				}

				setState(146); match(CLOSE_PAREN);
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
		enterRule(_localctx, 14, RULE_arg_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(149); expr(0);
			setState(154);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(150); match(COMMA);
				setState(151); expr(0);
				}
				}
				setState(156);
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
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode SND() { return getToken(WaccParser.SND, 0); }
		public PAIR_SNDContext(Pair_elemContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WaccParserVisitor ) return ((WaccParserVisitor<? extends T>)visitor).visitPAIR_SND(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class PAIR_FSTContext extends Pair_elemContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode FST() { return getToken(WaccParser.FST, 0); }
		public PAIR_FSTContext(Pair_elemContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WaccParserVisitor ) return ((WaccParserVisitor<? extends T>)visitor).visitPAIR_FST(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Pair_elemContext pair_elem() throws RecognitionException {
		Pair_elemContext _localctx = new Pair_elemContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_pair_elem);
		try {
			setState(161);
			switch (_input.LA(1)) {
			case FST:
				_localctx = new PAIR_FSTContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(157); match(FST);
				setState(158); expr(0);
				}
				break;
			case SND:
				_localctx = new PAIR_SNDContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(159); match(SND);
				setState(160); expr(0);
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
		public TerminalNode SQUARE_CLOSED() { return getToken(WaccParser.SQUARE_CLOSED, 0); }
		public TerminalNode SQUARE_OPEN() { return getToken(WaccParser.SQUARE_OPEN, 0); }
		public ARRAY_TYPEContext(TypeContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WaccParserVisitor ) return ((WaccParserVisitor<? extends T>)visitor).visitARRAY_TYPE(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class PAIR_TYPEContext extends TypeContext {
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
		int _startState = 18;
		enterRecursionRule(_localctx, 18, RULE_type, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(172);
			switch (_input.LA(1)) {
			case BASE_TYPE:
				{
				_localctx = new BASE_TYPEContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(164); match(BASE_TYPE);
				}
				break;
			case PAIR_STRING:
				{
				_localctx = new PAIR_TYPEContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(165); match(PAIR_STRING);
				setState(166); match(OPEN_PAREN);
				setState(167); pair_elem_type();
				setState(168); match(COMMA);
				setState(169); pair_elem_type();
				setState(170); match(CLOSE_PAREN);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(179);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new ARRAY_TYPEContext(new TypeContext(_parentctx, _parentState));
					pushNewRecursionContext(_localctx, _startState, RULE_type);
					setState(174);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(175); match(SQUARE_OPEN);
					setState(176); match(SQUARE_CLOSED);
					}
					} 
				}
				setState(181);
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
		public TerminalNode SQUARE_CLOSED() { return getToken(WaccParser.SQUARE_CLOSED, 0); }
		public TerminalNode SQUARE_OPEN() { return getToken(WaccParser.SQUARE_OPEN, 0); }
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
		enterRule(_localctx, 20, RULE_pair_elem_type);
		try {
			setState(188);
			switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
			case 1:
				_localctx = new BASE_TYPE_PAIRContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(182); match(BASE_TYPE);
				}
				break;
			case 2:
				_localctx = new ARRAY_TYPE_PAIRContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(183); type(0);
				setState(184); match(SQUARE_OPEN);
				setState(185); match(SQUARE_CLOSED);
				}
				break;
			case 3:
				_localctx = new PAIR_STRINGContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(187); match(PAIR_STRING);
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
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode CLOSE_PAREN() { return getToken(WaccParser.CLOSE_PAREN, 0); }
		public TerminalNode OPEN_PAREN() { return getToken(WaccParser.OPEN_PAREN, 0); }
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
	public static class UNARY_OP_EXPRContext extends ExprContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode UNARY_OPER() { return getToken(WaccParser.UNARY_OPER, 0); }
		public UNARY_OP_EXPRContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WaccParserVisitor ) return ((WaccParserVisitor<? extends T>)visitor).visitUNARY_OP_EXPR(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class INT_LITER_EXPRContext extends ExprContext {
		public TerminalNode INT_LITER() { return getToken(WaccParser.INT_LITER, 0); }
		public INT_LITER_EXPRContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WaccParserVisitor ) return ((WaccParserVisitor<? extends T>)visitor).visitINT_LITER_EXPR(this);
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
		public TerminalNode BINARY_OPER() { return getToken(WaccParser.BINARY_OPER, 0); }
		public BINARY_OP_EXPRContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WaccParserVisitor ) return ((WaccParserVisitor<? extends T>)visitor).visitBINARY_OP_EXPR(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ARRAY_ELEM_EXPRContext extends ExprContext {
		public Array_elemContext array_elem() {
			return getRuleContext(Array_elemContext.class,0);
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
		int _startState = 22;
		enterRecursionRule(_localctx, 22, RULE_expr, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(204);
			switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
			case 1:
				{
				_localctx = new UNARY_OP_EXPRContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(191); match(UNARY_OPER);
				setState(192); expr(3);
				}
				break;
			case 2:
				{
				_localctx = new INT_LITER_EXPRContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(193); match(INT_LITER);
				}
				break;
			case 3:
				{
				_localctx = new BOOL_LITER_EXPRContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(194); match(BOOL_LITER);
				}
				break;
			case 4:
				{
				_localctx = new CHAR_LITER_EXPRContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(195); match(CHAR_LITER);
				}
				break;
			case 5:
				{
				_localctx = new STR_LITER_EXPRContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(196); match(STR_LITER);
				}
				break;
			case 6:
				{
				_localctx = new PAIR_LITER_EXPRContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(197); match(PAIR_LITER);
				}
				break;
			case 7:
				{
				_localctx = new IDENT_EXPRContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(198); match(IDENT);
				}
				break;
			case 8:
				{
				_localctx = new ARRAY_ELEM_EXPRContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(199); array_elem();
				}
				break;
			case 9:
				{
				_localctx = new ENCLOSED_EXPRContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(200); match(OPEN_PAREN);
				setState(201); expr(0);
				setState(202); match(CLOSE_PAREN);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(211);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new BINARY_OP_EXPRContext(new ExprContext(_parentctx, _parentState));
					pushNewRecursionContext(_localctx, _startState, RULE_expr);
					setState(206);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(207); match(BINARY_OPER);
					setState(208); expr(3);
					}
					} 
				}
				setState(213);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
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
		public TerminalNode SQUARE_CLOSED(int i) {
			return getToken(WaccParser.SQUARE_CLOSED, i);
		}
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode SQUARE_OPEN(int i) {
			return getToken(WaccParser.SQUARE_OPEN, i);
		}
		public List<TerminalNode> SQUARE_CLOSED() { return getTokens(WaccParser.SQUARE_CLOSED); }
		public TerminalNode IDENT() { return getToken(WaccParser.IDENT, 0); }
		public List<TerminalNode> SQUARE_OPEN() { return getTokens(WaccParser.SQUARE_OPEN); }
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
		enterRule(_localctx, 24, RULE_array_elem);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(214); match(IDENT);
			setState(219); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(215); match(SQUARE_OPEN);
					setState(216); expr(0);
					setState(217); match(SQUARE_CLOSED);
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(221); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,17,_ctx);
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

	public static class Open_parenContext extends ParserRuleContext {
		public TerminalNode OPEN_PAREN() { return getToken(WaccParser.OPEN_PAREN, 0); }
		public Open_parenContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_open_paren; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WaccParserVisitor ) return ((WaccParserVisitor<? extends T>)visitor).visitOpen_paren(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Open_parenContext open_paren() throws RecognitionException {
		Open_parenContext _localctx = new Open_parenContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_open_paren);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(223); match(OPEN_PAREN);
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

	public static class Close_parenContext extends ParserRuleContext {
		public TerminalNode CLOSE_PAREN() { return getToken(WaccParser.CLOSE_PAREN, 0); }
		public Close_parenContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_close_paren; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WaccParserVisitor ) return ((WaccParserVisitor<? extends T>)visitor).visitClose_paren(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Close_parenContext close_paren() throws RecognitionException {
		Close_parenContext _localctx = new Close_parenContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_close_paren);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(225); match(CLOSE_PAREN);
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
		case 9: return type_sempred((TypeContext)_localctx, predIndex);
		case 11: return expr_sempred((ExprContext)_localctx, predIndex);
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
		case 2: return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean type_sempred(TypeContext _localctx, int predIndex) {
		switch (predIndex) {
		case 1: return precpred(_ctx, 2);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3*\u00e6\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\3\2\3\2\7\2#\n\2\f\2"+
		"\16\2&\13\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\5\3\60\n\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\4\3\4\3\4\7\4:\n\4\f\4\16\4=\13\4\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3"+
		"\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6"+
		"\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3"+
		"\6\3\6\5\6k\n\6\3\6\3\6\3\6\7\6p\n\6\f\6\16\6s\13\6\3\7\3\7\3\7\5\7x\n"+
		"\7\3\b\3\b\3\b\3\b\3\b\7\b\177\n\b\f\b\16\b\u0082\13\b\5\b\u0084\n\b\3"+
		"\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\5\b\u0093\n\b\3\b\5"+
		"\b\u0096\n\b\3\t\3\t\3\t\7\t\u009b\n\t\f\t\16\t\u009e\13\t\3\n\3\n\3\n"+
		"\3\n\5\n\u00a4\n\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\5\13\u00af"+
		"\n\13\3\13\3\13\3\13\7\13\u00b4\n\13\f\13\16\13\u00b7\13\13\3\f\3\f\3"+
		"\f\3\f\3\f\3\f\5\f\u00bf\n\f\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3"+
		"\r\3\r\3\r\3\r\5\r\u00cf\n\r\3\r\3\r\3\r\7\r\u00d4\n\r\f\r\16\r\u00d7"+
		"\13\r\3\16\3\16\3\16\3\16\3\16\6\16\u00de\n\16\r\16\16\16\u00df\3\17\3"+
		"\17\3\20\3\20\3\20\2\5\n\24\30\21\2\4\6\b\n\f\16\20\22\24\26\30\32\34"+
		"\36\2\2\u00fe\2 \3\2\2\2\4+\3\2\2\2\6\66\3\2\2\2\b>\3\2\2\2\nj\3\2\2\2"+
		"\fw\3\2\2\2\16\u0095\3\2\2\2\20\u0097\3\2\2\2\22\u00a3\3\2\2\2\24\u00ae"+
		"\3\2\2\2\26\u00be\3\2\2\2\30\u00ce\3\2\2\2\32\u00d8\3\2\2\2\34\u00e1\3"+
		"\2\2\2\36\u00e3\3\2\2\2 $\7\3\2\2!#\5\4\3\2\"!\3\2\2\2#&\3\2\2\2$\"\3"+
		"\2\2\2$%\3\2\2\2%\'\3\2\2\2&$\3\2\2\2\'(\5\n\6\2()\7\4\2\2)*\7\2\2\3*"+
		"\3\3\2\2\2+,\5\24\13\2,-\7(\2\2-/\5\34\17\2.\60\5\6\4\2/.\3\2\2\2/\60"+
		"\3\2\2\2\60\61\3\2\2\2\61\62\5\36\20\2\62\63\7\5\2\2\63\64\5\n\6\2\64"+
		"\65\7\4\2\2\65\5\3\2\2\2\66;\5\b\5\2\678\7\32\2\28:\5\b\5\29\67\3\2\2"+
		"\2:=\3\2\2\2;9\3\2\2\2;<\3\2\2\2<\7\3\2\2\2=;\3\2\2\2>?\5\24\13\2?@\7"+
		"(\2\2@\t\3\2\2\2AB\b\6\1\2Bk\7\20\2\2CD\5\24\13\2DE\7(\2\2EF\7\33\2\2"+
		"FG\5\16\b\2Gk\3\2\2\2HI\5\f\7\2IJ\7\33\2\2JK\5\16\b\2Kk\3\2\2\2LM\7\n"+
		"\2\2Mk\5\f\7\2NO\7\13\2\2Ok\5\30\r\2PQ\7\f\2\2Qk\5\30\r\2RS\7\r\2\2Sk"+
		"\5\30\r\2TU\7\16\2\2Uk\5\30\r\2VW\7\17\2\2Wk\5\30\r\2XY\7\6\2\2YZ\5\30"+
		"\r\2Z[\7\7\2\2[\\\5\n\6\2\\]\7\b\2\2]^\5\n\6\2^_\7\t\2\2_k\3\2\2\2`a\7"+
		"\26\2\2ab\5\30\r\2bc\7\27\2\2cd\5\n\6\2de\7\30\2\2ek\3\2\2\2fg\7\3\2\2"+
		"gh\5\n\6\2hi\7\4\2\2ik\3\2\2\2jA\3\2\2\2jC\3\2\2\2jH\3\2\2\2jL\3\2\2\2"+
		"jN\3\2\2\2jP\3\2\2\2jR\3\2\2\2jT\3\2\2\2jV\3\2\2\2jX\3\2\2\2j`\3\2\2\2"+
		"jf\3\2\2\2kq\3\2\2\2lm\f\3\2\2mn\7\31\2\2np\5\n\6\4ol\3\2\2\2ps\3\2\2"+
		"\2qo\3\2\2\2qr\3\2\2\2r\13\3\2\2\2sq\3\2\2\2tx\7(\2\2ux\5\32\16\2vx\5"+
		"\22\n\2wt\3\2\2\2wu\3\2\2\2wv\3\2\2\2x\r\3\2\2\2y\u0096\5\30\r\2z\u0083"+
		"\7\34\2\2{\u0080\5\30\r\2|}\7\32\2\2}\177\5\30\r\2~|\3\2\2\2\177\u0082"+
		"\3\2\2\2\u0080~\3\2\2\2\u0080\u0081\3\2\2\2\u0081\u0084\3\2\2\2\u0082"+
		"\u0080\3\2\2\2\u0083{\3\2\2\2\u0083\u0084\3\2\2\2\u0084\u0085\3\2\2\2"+
		"\u0085\u0096\7\35\2\2\u0086\u0087\7\21\2\2\u0087\u0088\7\36\2\2\u0088"+
		"\u0089\5\30\r\2\u0089\u008a\7\32\2\2\u008a\u008b\5\30\r\2\u008b\u008c"+
		"\7\37\2\2\u008c\u0096\3\2\2\2\u008d\u0096\5\22\n\2\u008e\u008f\7\22\2"+
		"\2\u008f\u0090\7(\2\2\u0090\u0092\7\36\2\2\u0091\u0093\5\20\t\2\u0092"+
		"\u0091\3\2\2\2\u0092\u0093\3\2\2\2\u0093\u0094\3\2\2\2\u0094\u0096\7\37"+
		"\2\2\u0095y\3\2\2\2\u0095z\3\2\2\2\u0095\u0086\3\2\2\2\u0095\u008d\3\2"+
		"\2\2\u0095\u008e\3\2\2\2\u0096\17\3\2\2\2\u0097\u009c\5\30\r\2\u0098\u0099"+
		"\7\32\2\2\u0099\u009b\5\30\r\2\u009a\u0098\3\2\2\2\u009b\u009e\3\2\2\2"+
		"\u009c\u009a\3\2\2\2\u009c\u009d\3\2\2\2\u009d\21\3\2\2\2\u009e\u009c"+
		"\3\2\2\2\u009f\u00a0\7\23\2\2\u00a0\u00a4\5\30\r\2\u00a1\u00a2\7\24\2"+
		"\2\u00a2\u00a4\5\30\r\2\u00a3\u009f\3\2\2\2\u00a3\u00a1\3\2\2\2\u00a4"+
		"\23\3\2\2\2\u00a5\u00a6\b\13\1\2\u00a6\u00af\7\'\2\2\u00a7\u00a8\7\25"+
		"\2\2\u00a8\u00a9\7\36\2\2\u00a9\u00aa\5\26\f\2\u00aa\u00ab\7\32\2\2\u00ab"+
		"\u00ac\5\26\f\2\u00ac\u00ad\7\37\2\2\u00ad\u00af\3\2\2\2\u00ae\u00a5\3"+
		"\2\2\2\u00ae\u00a7\3\2\2\2\u00af\u00b5\3\2\2\2\u00b0\u00b1\f\4\2\2\u00b1"+
		"\u00b2\7\34\2\2\u00b2\u00b4\7\35\2\2\u00b3\u00b0\3\2\2\2\u00b4\u00b7\3"+
		"\2\2\2\u00b5\u00b3\3\2\2\2\u00b5\u00b6\3\2\2\2\u00b6\25\3\2\2\2\u00b7"+
		"\u00b5\3\2\2\2\u00b8\u00bf\7\'\2\2\u00b9\u00ba\5\24\13\2\u00ba\u00bb\7"+
		"\34\2\2\u00bb\u00bc\7\35\2\2\u00bc\u00bf\3\2\2\2\u00bd\u00bf\7\25\2\2"+
		"\u00be\u00b8\3\2\2\2\u00be\u00b9\3\2\2\2\u00be\u00bd\3\2\2\2\u00bf\27"+
		"\3\2\2\2\u00c0\u00c1\b\r\1\2\u00c1\u00c2\7 \2\2\u00c2\u00cf\5\30\r\5\u00c3"+
		"\u00cf\7%\2\2\u00c4\u00cf\7\"\2\2\u00c5\u00cf\7#\2\2\u00c6\u00cf\7$\2"+
		"\2\u00c7\u00cf\7&\2\2\u00c8\u00cf\7(\2\2\u00c9\u00cf\5\32\16\2\u00ca\u00cb"+
		"\7\36\2\2\u00cb\u00cc\5\30\r\2\u00cc\u00cd\7\37\2\2\u00cd\u00cf\3\2\2"+
		"\2\u00ce\u00c0\3\2\2\2\u00ce\u00c3\3\2\2\2\u00ce\u00c4\3\2\2\2\u00ce\u00c5"+
		"\3\2\2\2\u00ce\u00c6\3\2\2\2\u00ce\u00c7\3\2\2\2\u00ce\u00c8\3\2\2\2\u00ce"+
		"\u00c9\3\2\2\2\u00ce\u00ca\3\2\2\2\u00cf\u00d5\3\2\2\2\u00d0\u00d1\f\4"+
		"\2\2\u00d1\u00d2\7!\2\2\u00d2\u00d4\5\30\r\5\u00d3\u00d0\3\2\2\2\u00d4"+
		"\u00d7\3\2\2\2\u00d5\u00d3\3\2\2\2\u00d5\u00d6\3\2\2\2\u00d6\31\3\2\2"+
		"\2\u00d7\u00d5\3\2\2\2\u00d8\u00dd\7(\2\2\u00d9\u00da\7\34\2\2\u00da\u00db"+
		"\5\30\r\2\u00db\u00dc\7\35\2\2\u00dc\u00de\3\2\2\2\u00dd\u00d9\3\2\2\2"+
		"\u00de\u00df\3\2\2\2\u00df\u00dd\3\2\2\2\u00df\u00e0\3\2\2\2\u00e0\33"+
		"\3\2\2\2\u00e1\u00e2\7\36\2\2\u00e2\35\3\2\2\2\u00e3\u00e4\7\37\2\2\u00e4"+
		"\37\3\2\2\2\24$/;jqw\u0080\u0083\u0092\u0095\u009c\u00a3\u00ae\u00b5\u00be"+
		"\u00ce\u00d5\u00df";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}