// Generated from ./WaccLexer.g4 by ANTLR 4.7
package antlr;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class WaccLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.7", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		BEGIN=1, END=2, IS=3, IF=4, THEN=5, ELSE=6, FI=7, READ=8, FREE=9, RETURN=10, 
		EXIT=11, PRINT=12, PRINTLN=13, SKIPTOK=14, NEWPAIR=15, CALL=16, FST=17, 
		SND=18, PAIR_STRING=19, WHILE=20, DO=21, DONE=22, SEMI_COLON=23, MINUS=24, 
		COMMA=25, EQUAL=26, SQUARE_OPEN=27, SQUARE_CLOSED=28, OPEN_PAREN=29, CLOSE_PAREN=30, 
		UNARY_OPER=31, BINARY_OPER=32, BOOL_LITER=33, CHAR_LITER=34, STR_LITER=35, 
		INT_LITER=36, PAIR_LITER=37, BASE_TYPE=38, IDENT=39, COMMENT=40, WHITESPACE=41;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"INT_STRING", "BOOL_STRING", "CHAR_STRING", "STRING_STRING", "HASH", "UNDERSCORE", 
		"ESCAPEDCHAR", "DIGIT", "LOWERCHAR", "UPPERCHAR", "CHARACTER", "NULL", 
		"TRUE", "FALSE", "BEGIN", "END", "IS", "IF", "THEN", "ELSE", "FI", "READ", 
		"FREE", "RETURN", "EXIT", "PRINT", "PRINTLN", "SKIPTOK", "NEWPAIR", "CALL", 
		"FST", "SND", "PAIR_STRING", "WHILE", "DO", "DONE", "SEMI_COLON", "MINUS", 
		"COMMA", "EQUAL", "SQUARE_OPEN", "SQUARE_CLOSED", "OPEN_PAREN", "CLOSE_PAREN", 
		"UNARY_OPER", "BINARY_OPER", "BOOL_LITER", "CHAR_LITER", "STR_LITER", 
		"INT_LITER", "PAIR_LITER", "BASE_TYPE", "IDENT", "COMMENT", "WHITESPACE"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'begin'", "'end'", "'is'", "'if'", "'then'", "'else'", "'fi'", 
		"'read'", "'free'", "'return'", "'exit'", "'print'", "'println'", "'skip'", 
		"'newpair'", "'call'", "'fst'", "'snd'", "'pair'", "'while'", "'do'", 
		"'done'", "';'", "'-'", "','", "'='", "'['", "']'", "'('", "')'", null, 
		null, null, null, null, null, "'null'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "BEGIN", "END", "IS", "IF", "THEN", "ELSE", "FI", "READ", "FREE", 
		"RETURN", "EXIT", "PRINT", "PRINTLN", "SKIPTOK", "NEWPAIR", "CALL", "FST", 
		"SND", "PAIR_STRING", "WHILE", "DO", "DONE", "SEMI_COLON", "MINUS", "COMMA", 
		"EQUAL", "SQUARE_OPEN", "SQUARE_CLOSED", "OPEN_PAREN", "CLOSE_PAREN", 
		"UNARY_OPER", "BINARY_OPER", "BOOL_LITER", "CHAR_LITER", "STR_LITER", 
		"INT_LITER", "PAIR_LITER", "BASE_TYPE", "IDENT", "COMMENT", "WHITESPACE"
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


	public WaccLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "WaccLexer.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2+\u0185\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3"+
		"\3\3\3\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\7\3\7"+
		"\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13\3\f\3\f\3\f\3\f\3\f\5\f\u0098\n\f\3"+
		"\r\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\17\3\17\3\17\3\17\3\17\3"+
		"\17\3\20\3\20\3\20\3\20\3\20\3\20\3\21\3\21\3\21\3\21\3\22\3\22\3\22\3"+
		"\23\3\23\3\23\3\24\3\24\3\24\3\24\3\24\3\25\3\25\3\25\3\25\3\25\3\26\3"+
		"\26\3\26\3\27\3\27\3\27\3\27\3\27\3\30\3\30\3\30\3\30\3\30\3\31\3\31\3"+
		"\31\3\31\3\31\3\31\3\31\3\32\3\32\3\32\3\32\3\32\3\33\3\33\3\33\3\33\3"+
		"\33\3\33\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\35\3\35\3\35\3\35\3"+
		"\35\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\37\3\37\3\37\3\37\3\37\3"+
		" \3 \3 \3 \3!\3!\3!\3!\3\"\3\"\3\"\3\"\3\"\3#\3#\3#\3#\3#\3#\3$\3$\3$"+
		"\3%\3%\3%\3%\3%\3&\3&\3\'\3\'\3(\3(\3)\3)\3*\3*\3+\3+\3,\3,\3-\3-\3.\3"+
		".\3.\3.\3.\3.\3.\3.\3.\3.\5.\u0132\n.\3/\3/\3/\3/\3/\3/\3/\3/\3/\3/\3"+
		"/\3/\3/\3/\5/\u0142\n/\3\60\3\60\5\60\u0146\n\60\3\61\3\61\3\61\3\61\3"+
		"\62\3\62\7\62\u014e\n\62\f\62\16\62\u0151\13\62\3\62\3\62\3\63\5\63\u0156"+
		"\n\63\3\63\6\63\u0159\n\63\r\63\16\63\u015a\3\64\3\64\3\64\3\64\3\64\3"+
		"\65\3\65\3\65\3\65\5\65\u0166\n\65\3\66\3\66\3\66\5\66\u016b\n\66\3\66"+
		"\3\66\3\66\3\66\7\66\u0171\n\66\f\66\16\66\u0174\13\66\3\67\3\67\7\67"+
		"\u0178\n\67\f\67\16\67\u017b\13\67\3\67\3\67\38\68\u0180\n8\r8\168\u0181"+
		"\38\38\2\29\3\2\5\2\7\2\t\2\13\2\r\2\17\2\21\2\23\2\25\2\27\2\31\2\33"+
		"\2\35\2\37\3!\4#\5%\6\'\7)\b+\t-\n/\13\61\f\63\r\65\16\67\179\20;\21="+
		"\22?\23A\24C\25E\26G\27I\30K\31M\32O\33Q\34S\35U\36W\37Y [!]\"_#a$c%e"+
		"&g\'i(k)m*o+\3\2\n\13\2$$))\62\62^^ddhhppttvv\3\2^^\3\2))\3\2$$\6\2\'"+
		"\',-\61\61@@\4\2--//\4\2\f\f\17\17\4\2\13\f\"\"\2\u0192\2\37\3\2\2\2\2"+
		"!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3"+
		"\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2"+
		"\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E"+
		"\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2Q\3\2"+
		"\2\2\2S\3\2\2\2\2U\3\2\2\2\2W\3\2\2\2\2Y\3\2\2\2\2[\3\2\2\2\2]\3\2\2\2"+
		"\2_\3\2\2\2\2a\3\2\2\2\2c\3\2\2\2\2e\3\2\2\2\2g\3\2\2\2\2i\3\2\2\2\2k"+
		"\3\2\2\2\2m\3\2\2\2\2o\3\2\2\2\3q\3\2\2\2\5u\3\2\2\2\7z\3\2\2\2\t\177"+
		"\3\2\2\2\13\u0086\3\2\2\2\r\u0088\3\2\2\2\17\u008a\3\2\2\2\21\u008c\3"+
		"\2\2\2\23\u008e\3\2\2\2\25\u0090\3\2\2\2\27\u0097\3\2\2\2\31\u0099\3\2"+
		"\2\2\33\u009e\3\2\2\2\35\u00a3\3\2\2\2\37\u00a9\3\2\2\2!\u00af\3\2\2\2"+
		"#\u00b3\3\2\2\2%\u00b6\3\2\2\2\'\u00b9\3\2\2\2)\u00be\3\2\2\2+\u00c3\3"+
		"\2\2\2-\u00c6\3\2\2\2/\u00cb\3\2\2\2\61\u00d0\3\2\2\2\63\u00d7\3\2\2\2"+
		"\65\u00dc\3\2\2\2\67\u00e2\3\2\2\29\u00ea\3\2\2\2;\u00ef\3\2\2\2=\u00f7"+
		"\3\2\2\2?\u00fc\3\2\2\2A\u0100\3\2\2\2C\u0104\3\2\2\2E\u0109\3\2\2\2G"+
		"\u010f\3\2\2\2I\u0112\3\2\2\2K\u0117\3\2\2\2M\u0119\3\2\2\2O\u011b\3\2"+
		"\2\2Q\u011d\3\2\2\2S\u011f\3\2\2\2U\u0121\3\2\2\2W\u0123\3\2\2\2Y\u0125"+
		"\3\2\2\2[\u0131\3\2\2\2]\u0141\3\2\2\2_\u0145\3\2\2\2a\u0147\3\2\2\2c"+
		"\u014b\3\2\2\2e\u0155\3\2\2\2g\u015c\3\2\2\2i\u0165\3\2\2\2k\u016a\3\2"+
		"\2\2m\u0175\3\2\2\2o\u017f\3\2\2\2qr\7k\2\2rs\7p\2\2st\7v\2\2t\4\3\2\2"+
		"\2uv\7d\2\2vw\7q\2\2wx\7q\2\2xy\7n\2\2y\6\3\2\2\2z{\7e\2\2{|\7j\2\2|}"+
		"\7c\2\2}~\7t\2\2~\b\3\2\2\2\177\u0080\7u\2\2\u0080\u0081\7v\2\2\u0081"+
		"\u0082\7t\2\2\u0082\u0083\7k\2\2\u0083\u0084\7p\2\2\u0084\u0085\7i\2\2"+
		"\u0085\n\3\2\2\2\u0086\u0087\7%\2\2\u0087\f\3\2\2\2\u0088\u0089\7a\2\2"+
		"\u0089\16\3\2\2\2\u008a\u008b\t\2\2\2\u008b\20\3\2\2\2\u008c\u008d\4\62"+
		";\2\u008d\22\3\2\2\2\u008e\u008f\4c|\2\u008f\24\3\2\2\2\u0090\u0091\4"+
		"C\\\2\u0091\26\3\2\2\2\u0092\u0098\n\3\2\2\u0093\u0098\n\4\2\2\u0094\u0098"+
		"\n\5\2\2\u0095\u0096\7^\2\2\u0096\u0098\5\17\b\2\u0097\u0092\3\2\2\2\u0097"+
		"\u0093\3\2\2\2\u0097\u0094\3\2\2\2\u0097\u0095\3\2\2\2\u0098\30\3\2\2"+
		"\2\u0099\u009a\7p\2\2\u009a\u009b\7w\2\2\u009b\u009c\7n\2\2\u009c\u009d"+
		"\7n\2\2\u009d\32\3\2\2\2\u009e\u009f\7v\2\2\u009f\u00a0\7t\2\2\u00a0\u00a1"+
		"\7w\2\2\u00a1\u00a2\7g\2\2\u00a2\34\3\2\2\2\u00a3\u00a4\7h\2\2\u00a4\u00a5"+
		"\7c\2\2\u00a5\u00a6\7n\2\2\u00a6\u00a7\7u\2\2\u00a7\u00a8\7g\2\2\u00a8"+
		"\36\3\2\2\2\u00a9\u00aa\7d\2\2\u00aa\u00ab\7g\2\2\u00ab\u00ac\7i\2\2\u00ac"+
		"\u00ad\7k\2\2\u00ad\u00ae\7p\2\2\u00ae \3\2\2\2\u00af\u00b0\7g\2\2\u00b0"+
		"\u00b1\7p\2\2\u00b1\u00b2\7f\2\2\u00b2\"\3\2\2\2\u00b3\u00b4\7k\2\2\u00b4"+
		"\u00b5\7u\2\2\u00b5$\3\2\2\2\u00b6\u00b7\7k\2\2\u00b7\u00b8\7h\2\2\u00b8"+
		"&\3\2\2\2\u00b9\u00ba\7v\2\2\u00ba\u00bb\7j\2\2\u00bb\u00bc\7g\2\2\u00bc"+
		"\u00bd\7p\2\2\u00bd(\3\2\2\2\u00be\u00bf\7g\2\2\u00bf\u00c0\7n\2\2\u00c0"+
		"\u00c1\7u\2\2\u00c1\u00c2\7g\2\2\u00c2*\3\2\2\2\u00c3\u00c4\7h\2\2\u00c4"+
		"\u00c5\7k\2\2\u00c5,\3\2\2\2\u00c6\u00c7\7t\2\2\u00c7\u00c8\7g\2\2\u00c8"+
		"\u00c9\7c\2\2\u00c9\u00ca\7f\2\2\u00ca.\3\2\2\2\u00cb\u00cc\7h\2\2\u00cc"+
		"\u00cd\7t\2\2\u00cd\u00ce\7g\2\2\u00ce\u00cf\7g\2\2\u00cf\60\3\2\2\2\u00d0"+
		"\u00d1\7t\2\2\u00d1\u00d2\7g\2\2\u00d2\u00d3\7v\2\2\u00d3\u00d4\7w\2\2"+
		"\u00d4\u00d5\7t\2\2\u00d5\u00d6\7p\2\2\u00d6\62\3\2\2\2\u00d7\u00d8\7"+
		"g\2\2\u00d8\u00d9\7z\2\2\u00d9\u00da\7k\2\2\u00da\u00db\7v\2\2\u00db\64"+
		"\3\2\2\2\u00dc\u00dd\7r\2\2\u00dd\u00de\7t\2\2\u00de\u00df\7k\2\2\u00df"+
		"\u00e0\7p\2\2\u00e0\u00e1\7v\2\2\u00e1\66\3\2\2\2\u00e2\u00e3\7r\2\2\u00e3"+
		"\u00e4\7t\2\2\u00e4\u00e5\7k\2\2\u00e5\u00e6\7p\2\2\u00e6\u00e7\7v\2\2"+
		"\u00e7\u00e8\7n\2\2\u00e8\u00e9\7p\2\2\u00e98\3\2\2\2\u00ea\u00eb\7u\2"+
		"\2\u00eb\u00ec\7m\2\2\u00ec\u00ed\7k\2\2\u00ed\u00ee\7r\2\2\u00ee:\3\2"+
		"\2\2\u00ef\u00f0\7p\2\2\u00f0\u00f1\7g\2\2\u00f1\u00f2\7y\2\2\u00f2\u00f3"+
		"\7r\2\2\u00f3\u00f4\7c\2\2\u00f4\u00f5\7k\2\2\u00f5\u00f6\7t\2\2\u00f6"+
		"<\3\2\2\2\u00f7\u00f8\7e\2\2\u00f8\u00f9\7c\2\2\u00f9\u00fa\7n\2\2\u00fa"+
		"\u00fb\7n\2\2\u00fb>\3\2\2\2\u00fc\u00fd\7h\2\2\u00fd\u00fe\7u\2\2\u00fe"+
		"\u00ff\7v\2\2\u00ff@\3\2\2\2\u0100\u0101\7u\2\2\u0101\u0102\7p\2\2\u0102"+
		"\u0103\7f\2\2\u0103B\3\2\2\2\u0104\u0105\7r\2\2\u0105\u0106\7c\2\2\u0106"+
		"\u0107\7k\2\2\u0107\u0108\7t\2\2\u0108D\3\2\2\2\u0109\u010a\7y\2\2\u010a"+
		"\u010b\7j\2\2\u010b\u010c\7k\2\2\u010c\u010d\7n\2\2\u010d\u010e\7g\2\2"+
		"\u010eF\3\2\2\2\u010f\u0110\7f\2\2\u0110\u0111\7q\2\2\u0111H\3\2\2\2\u0112"+
		"\u0113\7f\2\2\u0113\u0114\7q\2\2\u0114\u0115\7p\2\2\u0115\u0116\7g\2\2"+
		"\u0116J\3\2\2\2\u0117\u0118\7=\2\2\u0118L\3\2\2\2\u0119\u011a\7/\2\2\u011a"+
		"N\3\2\2\2\u011b\u011c\7.\2\2\u011cP\3\2\2\2\u011d\u011e\7?\2\2\u011eR"+
		"\3\2\2\2\u011f\u0120\7]\2\2\u0120T\3\2\2\2\u0121\u0122\7_\2\2\u0122V\3"+
		"\2\2\2\u0123\u0124\7*\2\2\u0124X\3\2\2\2\u0125\u0126\7+\2\2\u0126Z\3\2"+
		"\2\2\u0127\u0132\7#\2\2\u0128\u0129\7n\2\2\u0129\u012a\7g\2\2\u012a\u0132"+
		"\7p\2\2\u012b\u012c\7q\2\2\u012c\u012d\7t\2\2\u012d\u0132\7f\2\2\u012e"+
		"\u012f\7e\2\2\u012f\u0130\7j\2\2\u0130\u0132\7t\2\2\u0131\u0127\3\2\2"+
		"\2\u0131\u0128\3\2\2\2\u0131\u012b\3\2\2\2\u0131\u012e\3\2\2\2\u0132\\"+
		"\3\2\2\2\u0133\u0142\t\6\2\2\u0134\u0135\7@\2\2\u0135\u0142\7?\2\2\u0136"+
		"\u0142\7>\2\2\u0137\u0138\7>\2\2\u0138\u0142\7?\2\2\u0139\u013a\7?\2\2"+
		"\u013a\u0142\7?\2\2\u013b\u013c\7#\2\2\u013c\u0142\7?\2\2\u013d\u013e"+
		"\7(\2\2\u013e\u0142\7(\2\2\u013f\u0140\7~\2\2\u0140\u0142\7~\2\2\u0141"+
		"\u0133\3\2\2\2\u0141\u0134\3\2\2\2\u0141\u0136\3\2\2\2\u0141\u0137\3\2"+
		"\2\2\u0141\u0139\3\2\2\2\u0141\u013b\3\2\2\2\u0141\u013d\3\2\2\2\u0141"+
		"\u013f\3\2\2\2\u0142^\3\2\2\2\u0143\u0146\5\33\16\2\u0144\u0146\5\35\17"+
		"\2\u0145\u0143\3\2\2\2\u0145\u0144\3\2\2\2\u0146`\3\2\2\2\u0147\u0148"+
		"\7)\2\2\u0148\u0149\5\27\f\2\u0149\u014a\7)\2\2\u014ab\3\2\2\2\u014b\u014f"+
		"\7$\2\2\u014c\u014e\5\27\f\2\u014d\u014c\3\2\2\2\u014e\u0151\3\2\2\2\u014f"+
		"\u014d\3\2\2\2\u014f\u0150\3\2\2\2\u0150\u0152\3\2\2\2\u0151\u014f\3\2"+
		"\2\2\u0152\u0153\7$\2\2\u0153d\3\2\2\2\u0154\u0156\t\7\2\2\u0155\u0154"+
		"\3\2\2\2\u0155\u0156\3\2\2\2\u0156\u0158\3\2\2\2\u0157\u0159\5\21\t\2"+
		"\u0158\u0157\3\2\2\2\u0159\u015a\3\2\2\2\u015a\u0158\3\2\2\2\u015a\u015b"+
		"\3\2\2\2\u015bf\3\2\2\2\u015c\u015d\7p\2\2\u015d\u015e\7w\2\2\u015e\u015f"+
		"\7n\2\2\u015f\u0160\7n\2\2\u0160h\3\2\2\2\u0161\u0166\5\3\2\2\u0162\u0166"+
		"\5\5\3\2\u0163\u0166\5\7\4\2\u0164\u0166\5\t\5\2\u0165\u0161\3\2\2\2\u0165"+
		"\u0162\3\2\2\2\u0165\u0163\3\2\2\2\u0165\u0164\3\2\2\2\u0166j\3\2\2\2"+
		"\u0167\u016b\5\r\7\2\u0168\u016b\5\23\n\2\u0169\u016b\5\25\13\2\u016a"+
		"\u0167\3\2\2\2\u016a\u0168\3\2\2\2\u016a\u0169\3\2\2\2\u016b\u0172\3\2"+
		"\2\2\u016c\u0171\5\r\7\2\u016d\u0171\5\23\n\2\u016e\u0171\5\25\13\2\u016f"+
		"\u0171\5\21\t\2\u0170\u016c\3\2\2\2\u0170\u016d\3\2\2\2\u0170\u016e\3"+
		"\2\2\2\u0170\u016f\3\2\2\2\u0171\u0174\3\2\2\2\u0172\u0170\3\2\2\2\u0172"+
		"\u0173\3\2\2\2\u0173l\3\2\2\2\u0174\u0172\3\2\2\2\u0175\u0179\7%\2\2\u0176"+
		"\u0178\n\b\2\2\u0177\u0176\3\2\2\2\u0178\u017b\3\2\2\2\u0179\u0177\3\2"+
		"\2\2\u0179\u017a\3\2\2\2\u017a\u017c\3\2\2\2\u017b\u0179\3\2\2\2\u017c"+
		"\u017d\b\67\2\2\u017dn\3\2\2\2\u017e\u0180\t\t\2\2\u017f\u017e\3\2\2\2"+
		"\u0180\u0181\3\2\2\2\u0181\u017f\3\2\2\2\u0181\u0182\3\2\2\2\u0182\u0183"+
		"\3\2\2\2\u0183\u0184\b8\2\2\u0184p\3\2\2\2\20\2\u0097\u0131\u0141\u0145"+
		"\u014f\u0155\u015a\u0165\u016a\u0170\u0172\u0179\u0181\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}