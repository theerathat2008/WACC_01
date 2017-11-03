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
		RULE_stat = 4, RULE_assign_rhs = 5, RULE_assign_lhs = 6, RULE_arg_list = 7, 
		RULE_pair_elem = 8, RULE_type = 9, RULE_pair_type = 10, RULE_pair_elem_type = 11, 
		RULE_expr = 12, RULE_array_elem = 13, RULE_array_liter = 14, RULE_open_paren = 15, 
		RULE_close_paren = 16;
	public static final String[] ruleNames = {
		"program", "func", "param_list", "param", "stat", "assign_rhs", "assign_lhs", 
		"arg_list", "pair_elem", "type", "pair_type", "pair_elem_type", "expr", 
		"array_elem", "array_liter", "open_paren", "close_paren"
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
			setState(34); match(BEGIN);
			setState(38);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(35); func();
					}
					} 
				}
				setState(40);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			}
			setState(41); stat(0);
			setState(42); match(END);
			setState(43); match(EOF);
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
			setState(45); type(0);
			setState(46); match(IDENT);
			setState(47); open_paren();
			setState(49);
			_la = _input.LA(1);
			if (_la==PAIR_STRING || _la==BASE_TYPE) {
				{
				setState(48); param_list();
				}
			}

			setState(51); close_paren();
			setState(52); match(IS);
			setState(53); stat(0);
			setState(54); match(END);
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
			setState(56); param();
			setState(61);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(57); match(COMMA);
				setState(58); param();
				}
				}
				setState(63);
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
			setState(64); type(0);
			setState(65); match(IDENT);
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
	public static class PRINTContext extends StatContext {
		public TerminalNode PRINT() { return getToken(WaccParser.PRINT, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public PRINTContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WaccParserVisitor ) return ((WaccParserVisitor<? extends T>)visitor).visitPRINT(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class EQUALSContext extends StatContext {
		public TerminalNode EQUAL() { return getToken(WaccParser.EQUAL, 0); }
		public Assign_rhsContext assign_rhs() {
			return getRuleContext(Assign_rhsContext.class,0);
		}
		public Assign_lhsContext assign_lhs() {
			return getRuleContext(Assign_lhsContext.class,0);
		}
		public EQUALSContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WaccParserVisitor ) return ((WaccParserVisitor<? extends T>)visitor).visitEQUALS(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class PRINTLNContext extends StatContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode PRINTLN() { return getToken(WaccParser.PRINTLN, 0); }
		public PRINTLNContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WaccParserVisitor ) return ((WaccParserVisitor<? extends T>)visitor).visitPRINTLN(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class SEMIContext extends StatContext {
		public TerminalNode SEMI_COLON() { return getToken(WaccParser.SEMI_COLON, 0); }
		public StatContext stat(int i) {
			return getRuleContext(StatContext.class,i);
		}
		public List<StatContext> stat() {
			return getRuleContexts(StatContext.class);
		}
		public SEMIContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WaccParserVisitor ) return ((WaccParserVisitor<? extends T>)visitor).visitSEMI(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ASSIGNContext extends StatContext {
		public TerminalNode EQUAL() { return getToken(WaccParser.EQUAL, 0); }
		public Assign_rhsContext assign_rhs() {
			return getRuleContext(Assign_rhsContext.class,0);
		}
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode IDENT() { return getToken(WaccParser.IDENT, 0); }
		public ASSIGNContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WaccParserVisitor ) return ((WaccParserVisitor<? extends T>)visitor).visitASSIGN(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class FREEContext extends StatContext {
		public TerminalNode FREE() { return getToken(WaccParser.FREE, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public FREEContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WaccParserVisitor ) return ((WaccParserVisitor<? extends T>)visitor).visitFREE(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class READContext extends StatContext {
		public TerminalNode READ() { return getToken(WaccParser.READ, 0); }
		public Assign_lhsContext assign_lhs() {
			return getRuleContext(Assign_lhsContext.class,0);
		}
		public READContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WaccParserVisitor ) return ((WaccParserVisitor<? extends T>)visitor).visitREAD(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class RETURNContext extends StatContext {
		public TerminalNode RETURN() { return getToken(WaccParser.RETURN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public RETURNContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WaccParserVisitor ) return ((WaccParserVisitor<? extends T>)visitor).visitRETURN(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class SKIPContext extends StatContext {
		public TerminalNode SKIP() { return getToken(WaccParser.SKIP, 0); }
		public SKIPContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WaccParserVisitor ) return ((WaccParserVisitor<? extends T>)visitor).visitSKIP(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class WHILEContext extends StatContext {
		public TerminalNode DONE() { return getToken(WaccParser.DONE, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode DO() { return getToken(WaccParser.DO, 0); }
		public StatContext stat() {
			return getRuleContext(StatContext.class,0);
		}
		public TerminalNode WHILE() { return getToken(WaccParser.WHILE, 0); }
		public WHILEContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WaccParserVisitor ) return ((WaccParserVisitor<? extends T>)visitor).visitWHILE(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BEGIN_ENDContext extends StatContext {
		public TerminalNode BEGIN() { return getToken(WaccParser.BEGIN, 0); }
		public TerminalNode END() { return getToken(WaccParser.END, 0); }
		public StatContext stat() {
			return getRuleContext(StatContext.class,0);
		}
		public BEGIN_ENDContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WaccParserVisitor ) return ((WaccParserVisitor<? extends T>)visitor).visitBEGIN_END(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IFContext extends StatContext {
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
		public IFContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WaccParserVisitor ) return ((WaccParserVisitor<? extends T>)visitor).visitIF(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class EXITContext extends StatContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode EXIT() { return getToken(WaccParser.EXIT, 0); }
		public EXITContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WaccParserVisitor ) return ((WaccParserVisitor<? extends T>)visitor).visitEXIT(this);
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
			setState(108);
			switch (_input.LA(1)) {
			case SKIP:
				{
				_localctx = new SKIPContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(68); match(SKIP);
				}
				break;
			case PAIR_STRING:
			case BASE_TYPE:
				{
				_localctx = new ASSIGNContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(69); type(0);
				setState(70); match(IDENT);
				setState(71); match(EQUAL);
				setState(72); assign_rhs();
				}
				break;
			case FST:
			case SND:
			case IDENT:
				{
				_localctx = new EQUALSContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(74); assign_lhs();
				setState(75); match(EQUAL);
				setState(76); assign_rhs();
				}
				break;
			case READ:
				{
				_localctx = new READContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(78); match(READ);
				setState(79); assign_lhs();
				}
				break;
			case FREE:
				{
				_localctx = new FREEContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(80); match(FREE);
				setState(81); expr(0);
				}
				break;
			case RETURN:
				{
				_localctx = new RETURNContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(82); match(RETURN);
				setState(83); expr(0);
				}
				break;
			case EXIT:
				{
				_localctx = new EXITContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(84); match(EXIT);
				setState(85); expr(0);
				}
				break;
			case PRINT:
				{
				_localctx = new PRINTContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(86); match(PRINT);
				setState(87); expr(0);
				}
				break;
			case PRINTLN:
				{
				_localctx = new PRINTLNContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(88); match(PRINTLN);
				setState(89); expr(0);
				}
				break;
			case IF:
				{
				_localctx = new IFContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(90); match(IF);
				setState(91); expr(0);
				setState(92); match(THEN);
				setState(93); stat(0);
				setState(94); match(ELSE);
				setState(95); stat(0);
				setState(96); match(FI);
				}
				break;
			case WHILE:
				{
				_localctx = new WHILEContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(98); match(WHILE);
				setState(99); expr(0);
				setState(100); match(DO);
				setState(101); stat(0);
				setState(102); match(DONE);
				}
				break;
			case BEGIN:
				{
				_localctx = new BEGIN_ENDContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(104); match(BEGIN);
				setState(105); stat(0);
				setState(106); match(END);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(115);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new SEMIContext(new StatContext(_parentctx, _parentState));
					pushNewRecursionContext(_localctx, _startState, RULE_stat);
					setState(110);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(111); match(SEMI_COLON);
					setState(112); stat(2);
					}
					} 
				}
				setState(117);
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
	public static class CALLContext extends Assign_rhsContext {
		public TerminalNode CLOSE_PAREN() { return getToken(WaccParser.CLOSE_PAREN, 0); }
		public TerminalNode CALL() { return getToken(WaccParser.CALL, 0); }
		public Arg_listContext arg_list() {
			return getRuleContext(Arg_listContext.class,0);
		}
		public TerminalNode IDENT() { return getToken(WaccParser.IDENT, 0); }
		public TerminalNode OPEN_PAREN() { return getToken(WaccParser.OPEN_PAREN, 0); }
		public CALLContext(Assign_rhsContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WaccParserVisitor ) return ((WaccParserVisitor<? extends T>)visitor).visitCALL(this);
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
	public static class EXPRContext extends Assign_rhsContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public EXPRContext(Assign_rhsContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WaccParserVisitor ) return ((WaccParserVisitor<? extends T>)visitor).visitEXPR(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ARRAY_LITERContext extends Assign_rhsContext {
		public Array_literContext array_liter() {
			return getRuleContext(Array_literContext.class,0);
		}
		public ARRAY_LITERContext(Assign_rhsContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WaccParserVisitor ) return ((WaccParserVisitor<? extends T>)visitor).visitARRAY_LITER(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NEWPAIRContext extends Assign_rhsContext {
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
		public NEWPAIRContext(Assign_rhsContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WaccParserVisitor ) return ((WaccParserVisitor<? extends T>)visitor).visitNEWPAIR(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Assign_rhsContext assign_rhs() throws RecognitionException {
		Assign_rhsContext _localctx = new Assign_rhsContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_assign_rhs);
		int _la;
		try {
			setState(135);
			switch (_input.LA(1)) {
			case OPEN_PAREN:
			case UNARY_OPER:
			case BOOL_LITER:
			case CHAR_LITER:
			case STR_LITER:
			case INT_LITER:
			case PAIR_LITER:
			case IDENT:
				_localctx = new EXPRContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(118); expr(0);
				}
				break;
			case SQUARE_OPEN:
				_localctx = new ARRAY_LITERContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(119); array_liter();
				}
				break;
			case NEWPAIR:
				_localctx = new NEWPAIRContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(120); match(NEWPAIR);
				setState(121); match(OPEN_PAREN);
				setState(122); expr(0);
				setState(123); match(COMMA);
				setState(124); expr(0);
				setState(125); match(CLOSE_PAREN);
				}
				break;
			case FST:
			case SND:
				_localctx = new PAIR_ELEM_RHSContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(127); pair_elem();
				}
				break;
			case CALL:
				_localctx = new CALLContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(128); match(CALL);
				setState(129); match(IDENT);
				setState(130); match(OPEN_PAREN);
				setState(132);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << OPEN_PAREN) | (1L << UNARY_OPER) | (1L << BOOL_LITER) | (1L << CHAR_LITER) | (1L << STR_LITER) | (1L << INT_LITER) | (1L << PAIR_LITER) | (1L << IDENT))) != 0)) {
					{
					setState(131); arg_list();
					}
				}

				setState(134); match(CLOSE_PAREN);
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
	public static class IDENTContext extends Assign_lhsContext {
		public TerminalNode IDENT() { return getToken(WaccParser.IDENT, 0); }
		public IDENTContext(Assign_lhsContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WaccParserVisitor ) return ((WaccParserVisitor<? extends T>)visitor).visitIDENT(this);
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
		enterRule(_localctx, 12, RULE_assign_lhs);
		try {
			setState(140);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				_localctx = new IDENTContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(137); match(IDENT);
				}
				break;
			case 2:
				_localctx = new ARRAY_ELEM_LHSContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(138); array_elem();
				}
				break;
			case 3:
				_localctx = new PAIR_ELEM_LHSContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(139); pair_elem();
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
			setState(142); expr(0);
			setState(147);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(143); match(COMMA);
				setState(144); expr(0);
				}
				}
				setState(149);
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
			setState(154);
			switch (_input.LA(1)) {
			case FST:
				_localctx = new PAIR_FSTContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(150); match(FST);
				setState(151); expr(0);
				}
				break;
			case SND:
				_localctx = new PAIR_SNDContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(152); match(SND);
				setState(153); expr(0);
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
		public Pair_typeContext pair_type() {
			return getRuleContext(Pair_typeContext.class,0);
		}
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
			setState(159);
			switch (_input.LA(1)) {
			case BASE_TYPE:
				{
				_localctx = new BASE_TYPEContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(157); match(BASE_TYPE);
				}
				break;
			case PAIR_STRING:
				{
				_localctx = new PAIR_TYPEContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(158); pair_type();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(166);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new ARRAY_TYPEContext(new TypeContext(_parentctx, _parentState));
					pushNewRecursionContext(_localctx, _startState, RULE_type);
					setState(161);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(162); match(SQUARE_OPEN);
					setState(163); match(SQUARE_CLOSED);
					}
					} 
				}
				setState(168);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
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
		enterRule(_localctx, 20, RULE_pair_type);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(169); match(PAIR_STRING);
			setState(170); match(OPEN_PAREN);
			setState(171); pair_elem_type();
			setState(172); match(COMMA);
			setState(173); pair_elem_type();
			setState(174); match(CLOSE_PAREN);
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
		enterRule(_localctx, 22, RULE_pair_elem_type);
		try {
			setState(182);
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
			case 1:
				_localctx = new BASE_TYPE_PAIRContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(176); match(BASE_TYPE);
				}
				break;
			case 2:
				_localctx = new ARRAY_TYPE_PAIRContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(177); type(0);
				setState(178); match(SQUARE_OPEN);
				setState(179); match(SQUARE_CLOSED);
				}
				break;
			case 3:
				_localctx = new PAIR_STRINGContext(_localctx);
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
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
	 
		public ExprContext() { }
		public void copyFrom(ExprContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class UNARY_OPContext extends ExprContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode UNARY_OPER() { return getToken(WaccParser.UNARY_OPER, 0); }
		public UNARY_OPContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WaccParserVisitor ) return ((WaccParserVisitor<? extends T>)visitor).visitUNARY_OP(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class CLOSED_EXPRContext extends ExprContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode CLOSE_PAREN() { return getToken(WaccParser.CLOSE_PAREN, 0); }
		public TerminalNode OPEN_PAREN() { return getToken(WaccParser.OPEN_PAREN, 0); }
		public CLOSED_EXPRContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WaccParserVisitor ) return ((WaccParserVisitor<? extends T>)visitor).visitCLOSED_EXPR(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ARRAY_ELEMContext extends ExprContext {
		public Array_elemContext array_elem() {
			return getRuleContext(Array_elemContext.class,0);
		}
		public ARRAY_ELEMContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WaccParserVisitor ) return ((WaccParserVisitor<? extends T>)visitor).visitARRAY_ELEM(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BINARY_OPContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode BINARY_OPER() { return getToken(WaccParser.BINARY_OPER, 0); }
		public BINARY_OPContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WaccParserVisitor ) return ((WaccParserVisitor<? extends T>)visitor).visitBINARY_OP(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class STR_LITERContext extends ExprContext {
		public TerminalNode STR_LITER() { return getToken(WaccParser.STR_LITER, 0); }
		public STR_LITERContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WaccParserVisitor ) return ((WaccParserVisitor<? extends T>)visitor).visitSTR_LITER(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class PAIR_LITERContext extends ExprContext {
		public TerminalNode PAIR_LITER() { return getToken(WaccParser.PAIR_LITER, 0); }
		public PAIR_LITERContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WaccParserVisitor ) return ((WaccParserVisitor<? extends T>)visitor).visitPAIR_LITER(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class CHAR_LITERContext extends ExprContext {
		public TerminalNode CHAR_LITER() { return getToken(WaccParser.CHAR_LITER, 0); }
		public CHAR_LITERContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WaccParserVisitor ) return ((WaccParserVisitor<? extends T>)visitor).visitCHAR_LITER(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class INT_LITERContext extends ExprContext {
		public TerminalNode INT_LITER() { return getToken(WaccParser.INT_LITER, 0); }
		public INT_LITERContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WaccParserVisitor ) return ((WaccParserVisitor<? extends T>)visitor).visitINT_LITER(this);
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
	public static class BOOL_LITERContext extends ExprContext {
		public TerminalNode BOOL_LITER() { return getToken(WaccParser.BOOL_LITER, 0); }
		public BOOL_LITERContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WaccParserVisitor ) return ((WaccParserVisitor<? extends T>)visitor).visitBOOL_LITER(this);
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
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(198);
			switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
			case 1:
				{
				_localctx = new UNARY_OPContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(185); match(UNARY_OPER);
				setState(186); expr(3);
				}
				break;
			case 2:
				{
				_localctx = new INT_LITERContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(187); match(INT_LITER);
				}
				break;
			case 3:
				{
				_localctx = new BOOL_LITERContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(188); match(BOOL_LITER);
				}
				break;
			case 4:
				{
				_localctx = new CHAR_LITERContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(189); match(CHAR_LITER);
				}
				break;
			case 5:
				{
				_localctx = new STR_LITERContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(190); match(STR_LITER);
				}
				break;
			case 6:
				{
				_localctx = new PAIR_LITERContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(191); match(PAIR_LITER);
				}
				break;
			case 7:
				{
				_localctx = new IDENT_EXPRContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(192); match(IDENT);
				}
				break;
			case 8:
				{
				_localctx = new ARRAY_ELEMContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(193); array_elem();
				}
				break;
			case 9:
				{
				_localctx = new CLOSED_EXPRContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
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
					_localctx = new BINARY_OPContext(new ExprContext(_parentctx, _parentState));
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
		enterRule(_localctx, 26, RULE_array_elem);
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
		public List<TerminalNode> COMMA() { return getTokens(WaccParser.COMMA); }
		public TerminalNode SQUARE_CLOSED() { return getToken(WaccParser.SQUARE_CLOSED, 0); }
		public TerminalNode SQUARE_OPEN() { return getToken(WaccParser.SQUARE_OPEN, 0); }
		public TerminalNode COMMA(int i) {
			return getToken(WaccParser.COMMA, i);
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
		enterRule(_localctx, 28, RULE_array_liter);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(217); match(SQUARE_OPEN);
			setState(226);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << OPEN_PAREN) | (1L << UNARY_OPER) | (1L << BOOL_LITER) | (1L << CHAR_LITER) | (1L << STR_LITER) | (1L << INT_LITER) | (1L << PAIR_LITER) | (1L << IDENT))) != 0)) {
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
		enterRule(_localctx, 30, RULE_open_paren);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(230); match(OPEN_PAREN);
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
		enterRule(_localctx, 32, RULE_close_paren);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(232); match(CLOSE_PAREN);
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
		case 12: return expr_sempred((ExprContext)_localctx, predIndex);
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3*\u00ed\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\3\2\3\2\7\2\'\n\2\f\2\16\2*\13\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\5\3"+
		"\64\n\3\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\7\4>\n\4\f\4\16\4A\13\4\3\5\3"+
		"\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6"+
		"\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3"+
		"\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\5\6o\n\6\3\6\3\6\3\6\7\6t\n\6\f\6\16\6"+
		"w\13\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\5\7\u0087"+
		"\n\7\3\7\5\7\u008a\n\7\3\b\3\b\3\b\5\b\u008f\n\b\3\t\3\t\3\t\7\t\u0094"+
		"\n\t\f\t\16\t\u0097\13\t\3\n\3\n\3\n\3\n\5\n\u009d\n\n\3\13\3\13\3\13"+
		"\5\13\u00a2\n\13\3\13\3\13\3\13\7\13\u00a7\n\13\f\13\16\13\u00aa\13\13"+
		"\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r\5\r\u00b9\n\r\3\16"+
		"\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\5\16"+
		"\u00c9\n\16\3\16\3\16\3\16\7\16\u00ce\n\16\f\16\16\16\u00d1\13\16\3\17"+
		"\3\17\3\17\3\17\3\17\6\17\u00d8\n\17\r\17\16\17\u00d9\3\20\3\20\3\20\3"+
		"\20\7\20\u00e0\n\20\f\20\16\20\u00e3\13\20\5\20\u00e5\n\20\3\20\3\20\3"+
		"\21\3\21\3\22\3\22\3\22\2\5\n\24\32\23\2\4\6\b\n\f\16\20\22\24\26\30\32"+
		"\34\36 \"\2\2\u0103\2$\3\2\2\2\4/\3\2\2\2\6:\3\2\2\2\bB\3\2\2\2\nn\3\2"+
		"\2\2\f\u0089\3\2\2\2\16\u008e\3\2\2\2\20\u0090\3\2\2\2\22\u009c\3\2\2"+
		"\2\24\u00a1\3\2\2\2\26\u00ab\3\2\2\2\30\u00b8\3\2\2\2\32\u00c8\3\2\2\2"+
		"\34\u00d2\3\2\2\2\36\u00db\3\2\2\2 \u00e8\3\2\2\2\"\u00ea\3\2\2\2$(\7"+
		"\3\2\2%\'\5\4\3\2&%\3\2\2\2\'*\3\2\2\2(&\3\2\2\2()\3\2\2\2)+\3\2\2\2*"+
		"(\3\2\2\2+,\5\n\6\2,-\7\4\2\2-.\7\2\2\3.\3\3\2\2\2/\60\5\24\13\2\60\61"+
		"\7(\2\2\61\63\5 \21\2\62\64\5\6\4\2\63\62\3\2\2\2\63\64\3\2\2\2\64\65"+
		"\3\2\2\2\65\66\5\"\22\2\66\67\7\5\2\2\678\5\n\6\289\7\4\2\29\5\3\2\2\2"+
		":?\5\b\5\2;<\7\32\2\2<>\5\b\5\2=;\3\2\2\2>A\3\2\2\2?=\3\2\2\2?@\3\2\2"+
		"\2@\7\3\2\2\2A?\3\2\2\2BC\5\24\13\2CD\7(\2\2D\t\3\2\2\2EF\b\6\1\2Fo\7"+
		"\20\2\2GH\5\24\13\2HI\7(\2\2IJ\7\33\2\2JK\5\f\7\2Ko\3\2\2\2LM\5\16\b\2"+
		"MN\7\33\2\2NO\5\f\7\2Oo\3\2\2\2PQ\7\n\2\2Qo\5\16\b\2RS\7\13\2\2So\5\32"+
		"\16\2TU\7\f\2\2Uo\5\32\16\2VW\7\r\2\2Wo\5\32\16\2XY\7\16\2\2Yo\5\32\16"+
		"\2Z[\7\17\2\2[o\5\32\16\2\\]\7\6\2\2]^\5\32\16\2^_\7\7\2\2_`\5\n\6\2`"+
		"a\7\b\2\2ab\5\n\6\2bc\7\t\2\2co\3\2\2\2de\7\26\2\2ef\5\32\16\2fg\7\27"+
		"\2\2gh\5\n\6\2hi\7\30\2\2io\3\2\2\2jk\7\3\2\2kl\5\n\6\2lm\7\4\2\2mo\3"+
		"\2\2\2nE\3\2\2\2nG\3\2\2\2nL\3\2\2\2nP\3\2\2\2nR\3\2\2\2nT\3\2\2\2nV\3"+
		"\2\2\2nX\3\2\2\2nZ\3\2\2\2n\\\3\2\2\2nd\3\2\2\2nj\3\2\2\2ou\3\2\2\2pq"+
		"\f\3\2\2qr\7\31\2\2rt\5\n\6\4sp\3\2\2\2tw\3\2\2\2us\3\2\2\2uv\3\2\2\2"+
		"v\13\3\2\2\2wu\3\2\2\2x\u008a\5\32\16\2y\u008a\5\36\20\2z{\7\21\2\2{|"+
		"\7\36\2\2|}\5\32\16\2}~\7\32\2\2~\177\5\32\16\2\177\u0080\7\37\2\2\u0080"+
		"\u008a\3\2\2\2\u0081\u008a\5\22\n\2\u0082\u0083\7\22\2\2\u0083\u0084\7"+
		"(\2\2\u0084\u0086\7\36\2\2\u0085\u0087\5\20\t\2\u0086\u0085\3\2\2\2\u0086"+
		"\u0087\3\2\2\2\u0087\u0088\3\2\2\2\u0088\u008a\7\37\2\2\u0089x\3\2\2\2"+
		"\u0089y\3\2\2\2\u0089z\3\2\2\2\u0089\u0081\3\2\2\2\u0089\u0082\3\2\2\2"+
		"\u008a\r\3\2\2\2\u008b\u008f\7(\2\2\u008c\u008f\5\34\17\2\u008d\u008f"+
		"\5\22\n\2\u008e\u008b\3\2\2\2\u008e\u008c\3\2\2\2\u008e\u008d\3\2\2\2"+
		"\u008f\17\3\2\2\2\u0090\u0095\5\32\16\2\u0091\u0092\7\32\2\2\u0092\u0094"+
		"\5\32\16\2\u0093\u0091\3\2\2\2\u0094\u0097\3\2\2\2\u0095\u0093\3\2\2\2"+
		"\u0095\u0096\3\2\2\2\u0096\21\3\2\2\2\u0097\u0095\3\2\2\2\u0098\u0099"+
		"\7\23\2\2\u0099\u009d\5\32\16\2\u009a\u009b\7\24\2\2\u009b\u009d\5\32"+
		"\16\2\u009c\u0098\3\2\2\2\u009c\u009a\3\2\2\2\u009d\23\3\2\2\2\u009e\u009f"+
		"\b\13\1\2\u009f\u00a2\7\'\2\2\u00a0\u00a2\5\26\f\2\u00a1\u009e\3\2\2\2"+
		"\u00a1\u00a0\3\2\2\2\u00a2\u00a8\3\2\2\2\u00a3\u00a4\f\4\2\2\u00a4\u00a5"+
		"\7\34\2\2\u00a5\u00a7\7\35\2\2\u00a6\u00a3\3\2\2\2\u00a7\u00aa\3\2\2\2"+
		"\u00a8\u00a6\3\2\2\2\u00a8\u00a9\3\2\2\2\u00a9\25\3\2\2\2\u00aa\u00a8"+
		"\3\2\2\2\u00ab\u00ac\7\25\2\2\u00ac\u00ad\7\36\2\2\u00ad\u00ae\5\30\r"+
		"\2\u00ae\u00af\7\32\2\2\u00af\u00b0\5\30\r\2\u00b0\u00b1\7\37\2\2\u00b1"+
		"\27\3\2\2\2\u00b2\u00b9\7\'\2\2\u00b3\u00b4\5\24\13\2\u00b4\u00b5\7\34"+
		"\2\2\u00b5\u00b6\7\35\2\2\u00b6\u00b9\3\2\2\2\u00b7\u00b9\7\25\2\2\u00b8"+
		"\u00b2\3\2\2\2\u00b8\u00b3\3\2\2\2\u00b8\u00b7\3\2\2\2\u00b9\31\3\2\2"+
		"\2\u00ba\u00bb\b\16\1\2\u00bb\u00bc\7 \2\2\u00bc\u00c9\5\32\16\5\u00bd"+
		"\u00c9\7%\2\2\u00be\u00c9\7\"\2\2\u00bf\u00c9\7#\2\2\u00c0\u00c9\7$\2"+
		"\2\u00c1\u00c9\7&\2\2\u00c2\u00c9\7(\2\2\u00c3\u00c9\5\34\17\2\u00c4\u00c5"+
		"\7\36\2\2\u00c5\u00c6\5\32\16\2\u00c6\u00c7\7\37\2\2\u00c7\u00c9\3\2\2"+
		"\2\u00c8\u00ba\3\2\2\2\u00c8\u00bd\3\2\2\2\u00c8\u00be\3\2\2\2\u00c8\u00bf"+
		"\3\2\2\2\u00c8\u00c0\3\2\2\2\u00c8\u00c1\3\2\2\2\u00c8\u00c2\3\2\2\2\u00c8"+
		"\u00c3\3\2\2\2\u00c8\u00c4\3\2\2\2\u00c9\u00cf\3\2\2\2\u00ca\u00cb\f\4"+
		"\2\2\u00cb\u00cc\7!\2\2\u00cc\u00ce\5\32\16\5\u00cd\u00ca\3\2\2\2\u00ce"+
		"\u00d1\3\2\2\2\u00cf\u00cd\3\2\2\2\u00cf\u00d0\3\2\2\2\u00d0\33\3\2\2"+
		"\2\u00d1\u00cf\3\2\2\2\u00d2\u00d7\7(\2\2\u00d3\u00d4\7\34\2\2\u00d4\u00d5"+
		"\5\32\16\2\u00d5\u00d6\7\35\2\2\u00d6\u00d8\3\2\2\2\u00d7\u00d3\3\2\2"+
		"\2\u00d8\u00d9\3\2\2\2\u00d9\u00d7\3\2\2\2\u00d9\u00da\3\2\2\2\u00da\35"+
		"\3\2\2\2\u00db\u00e4\7\34\2\2\u00dc\u00e1\5\32\16\2\u00dd\u00de\7\32\2"+
		"\2\u00de\u00e0\5\32\16\2\u00df\u00dd\3\2\2\2\u00e0\u00e3\3\2\2\2\u00e1"+
		"\u00df\3\2\2\2\u00e1\u00e2\3\2\2\2\u00e2\u00e5\3\2\2\2\u00e3\u00e1\3\2"+
		"\2\2\u00e4\u00dc\3\2\2\2\u00e4\u00e5\3\2\2\2\u00e5\u00e6\3\2\2\2\u00e6"+
		"\u00e7\7\35\2\2\u00e7\37\3\2\2\2\u00e8\u00e9\7\36\2\2\u00e9!\3\2\2\2\u00ea"+
		"\u00eb\7\37\2\2\u00eb#\3\2\2\2\24(\63?nu\u0086\u0089\u008e\u0095\u009c"+
		"\u00a1\u00a8\u00b8\u00c8\u00cf\u00d9\u00e1\u00e4";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}