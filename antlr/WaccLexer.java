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
  static {
    RuntimeMetaData.checkVersion("4.7", RuntimeMetaData.VERSION);
  }

  protected static final DFA[] _decisionToDFA;
  protected static final PredictionContextCache _sharedContextCache =
      new PredictionContextCache();
  public static final int
      BEGIN = 1, END = 2, IS = 3, IF = 4, THEN = 5, ELSE = 6, FI = 7, READ = 8, FREE = 9, RETURN = 10,
      EXIT = 11, PRINT = 12, PRINTLN = 13, SKIPTOK = 14, NEWPAIR = 15, CALL = 16, FST = 17,
      SND = 18, PAIR_STRING = 19, WHILE = 20, DO = 21, DONE = 22, SEMI_COLON = 23, MINUS = 24,
      PLUS = 25, CHR = 26, ORD = 27, LEN = 28, EXCL = 29, MULT = 30, DIV = 31, MOD = 32, GRTHAN = 33,
      GREQTO = 34, LSTHAN = 35, LSEQTO = 36, EQTO = 37, NEQTO = 38, AND = 39, OR = 40, COMMA = 41,
      EQUAL = 42, SQUARE_OPEN = 43, SQUARE_CLOSED = 44, OPEN_PAREN = 45, CLOSE_PAREN = 46,
      BOOL_LITER = 47, CHAR_LITER = 48, STR_LITER = 49, INT_LITER = 50, PAIR_LITER = 51,
      BASE_TYPE = 52, IDENT = 53, COMMENT = 54, WHITESPACE = 55;
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
      "PLUS", "CHR", "ORD", "LEN", "EXCL", "MULT", "DIV", "MOD", "GRTHAN", "GREQTO",
      "LSTHAN", "LSEQTO", "EQTO", "NEQTO", "AND", "OR", "COMMA", "EQUAL", "SQUARE_OPEN",
      "SQUARE_CLOSED", "OPEN_PAREN", "CLOSE_PAREN", "BOOL_LITER", "CHAR_LITER",
      "STR_LITER", "INT_LITER", "PAIR_LITER", "BASE_TYPE", "IDENT", "COMMENT",
      "WHITESPACE"
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


  public WaccLexer(CharStream input) {
    super(input);
    _interp = new LexerATNSimulator(this, _ATN, _decisionToDFA, _sharedContextCache);
  }

  @Override
  public String getGrammarFileName() {
    return "WaccLexer.g4";
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
  public String[] getChannelNames() {
    return channelNames;
  }

  @Override
  public String[] getModeNames() {
    return modeNames;
  }

  @Override
  public ATN getATN() {
    return _ATN;
  }

  public static final String _serializedATN =
      "\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\29\u01ac\b\1\4\2\t" +
          "\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13" +
          "\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22" +
          "\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31" +
          "\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!" +
          "\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4" +
          ",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t" +
          "\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t=" +
          "\4>\t>\4?\t?\4@\t@\4A\tA\4B\tB\4C\tC\4D\tD\4E\tE\4F\tF\3\2\3\2\3\2\3\2" +
          "\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3" +
          "\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13\3\f\3\f\3\f\5\f\u00b2" +
          "\n\f\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\17\3\17\3\17\3\17" +
          "\3\17\3\17\3\20\3\20\3\20\3\20\3\20\3\20\3\21\3\21\3\21\3\21\3\22\3\22" +
          "\3\22\3\23\3\23\3\23\3\24\3\24\3\24\3\24\3\24\3\25\3\25\3\25\3\25\3\25" +
          "\3\26\3\26\3\26\3\27\3\27\3\27\3\27\3\27\3\30\3\30\3\30\3\30\3\30\3\31" +
          "\3\31\3\31\3\31\3\31\3\31\3\31\3\32\3\32\3\32\3\32\3\32\3\33\3\33\3\33" +
          "\3\33\3\33\3\33\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\35\3\35\3\35" +
          "\3\35\3\35\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\37\3\37\3\37\3\37" +
          "\3\37\3 \3 \3 \3 \3!\3!\3!\3!\3\"\3\"\3\"\3\"\3\"\3#\3#\3#\3#\3#\3#\3" +
          "$\3$\3$\3%\3%\3%\3%\3%\3&\3&\3\'\3\'\3(\3(\3)\3)\3)\3)\3*\3*\3*\3*\3+" +
          "\3+\3+\3+\3,\3,\3-\3-\3.\3.\3/\3/\3\60\3\60\3\61\3\61\3\61\3\62\3\62\3" +
          "\63\3\63\3\63\3\64\3\64\3\64\3\65\3\65\3\65\3\66\3\66\3\66\3\67\3\67\3" +
          "\67\38\38\39\39\3:\3:\3;\3;\3<\3<\3=\3=\3>\3>\5>\u0170\n>\3?\3?\3?\3?" +
          "\3@\3@\7@\u0178\n@\f@\16@\u017b\13@\3@\3@\3A\6A\u0180\nA\rA\16A\u0181" +
          "\3B\3B\3B\3B\3B\3C\3C\3C\3C\5C\u018d\nC\3D\3D\3D\5D\u0192\nD\3D\3D\3D" +
          "\3D\7D\u0198\nD\fD\16D\u019b\13D\3E\3E\7E\u019f\nE\fE\16E\u01a2\13E\3" +
          "E\3E\3F\6F\u01a7\nF\rF\16F\u01a8\3F\3F\2\2G\3\2\5\2\7\2\t\2\13\2\r\2\17" +
          "\2\21\2\23\2\25\2\27\2\31\2\33\2\35\2\37\3!\4#\5%\6\'\7)\b+\t-\n/\13\61" +
          "\f\63\r\65\16\67\179\20;\21=\22?\23A\24C\25E\26G\27I\30K\31M\32O\33Q\34" +
          "S\35U\36W\37Y [!]\"_#a$c%e&g\'i(k)m*o+q,s-u.w/y\60{\61}\62\177\63\u0081" +
          "\64\u0083\65\u0085\66\u0087\67\u00898\u008b9\3\2\6\13\2$$))\62\62^^dd" +
          "hhppttvv\5\2$$))^^\4\2\f\f\17\17\4\2\13\f\"\"\2\u01ac\2\37\3\2\2\2\2!" +
          "\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3" +
          "\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2" +
          "\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E" +
          "\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2Q\3\2" +
          "\2\2\2S\3\2\2\2\2U\3\2\2\2\2W\3\2\2\2\2Y\3\2\2\2\2[\3\2\2\2\2]\3\2\2\2" +
          "\2_\3\2\2\2\2a\3\2\2\2\2c\3\2\2\2\2e\3\2\2\2\2g\3\2\2\2\2i\3\2\2\2\2k" +
          "\3\2\2\2\2m\3\2\2\2\2o\3\2\2\2\2q\3\2\2\2\2s\3\2\2\2\2u\3\2\2\2\2w\3\2" +
          "\2\2\2y\3\2\2\2\2{\3\2\2\2\2}\3\2\2\2\2\177\3\2\2\2\2\u0081\3\2\2\2\2" +
          "\u0083\3\2\2\2\2\u0085\3\2\2\2\2\u0087\3\2\2\2\2\u0089\3\2\2\2\2\u008b" +
          "\3\2\2\2\3\u008d\3\2\2\2\5\u0091\3\2\2\2\7\u0096\3\2\2\2\t\u009b\3\2\2" +
          "\2\13\u00a2\3\2\2\2\r\u00a4\3\2\2\2\17\u00a6\3\2\2\2\21\u00a8\3\2\2\2" +
          "\23\u00aa\3\2\2\2\25\u00ac\3\2\2\2\27\u00b1\3\2\2\2\31\u00b3\3\2\2\2\33" +
          "\u00b8\3\2\2\2\35\u00bd\3\2\2\2\37\u00c3\3\2\2\2!\u00c9\3\2\2\2#\u00cd" +
          "\3\2\2\2%\u00d0\3\2\2\2\'\u00d3\3\2\2\2)\u00d8\3\2\2\2+\u00dd\3\2\2\2" +
          "-\u00e0\3\2\2\2/\u00e5\3\2\2\2\61\u00ea\3\2\2\2\63\u00f1\3\2\2\2\65\u00f6" +
          "\3\2\2\2\67\u00fc\3\2\2\29\u0104\3\2\2\2;\u0109\3\2\2\2=\u0111\3\2\2\2" +
          "?\u0116\3\2\2\2A\u011a\3\2\2\2C\u011e\3\2\2\2E\u0123\3\2\2\2G\u0129\3" +
          "\2\2\2I\u012c\3\2\2\2K\u0131\3\2\2\2M\u0133\3\2\2\2O\u0135\3\2\2\2Q\u0137" +
          "\3\2\2\2S\u013b\3\2\2\2U\u013f\3\2\2\2W\u0143\3\2\2\2Y\u0145\3\2\2\2[" +
          "\u0147\3\2\2\2]\u0149\3\2\2\2_\u014b\3\2\2\2a\u014d\3\2\2\2c\u0150\3\2" +
          "\2\2e\u0152\3\2\2\2g\u0155\3\2\2\2i\u0158\3\2\2\2k\u015b\3\2\2\2m\u015e" +
          "\3\2\2\2o\u0161\3\2\2\2q\u0163\3\2\2\2s\u0165\3\2\2\2u\u0167\3\2\2\2w" +
          "\u0169\3\2\2\2y\u016b\3\2\2\2{\u016f\3\2\2\2}\u0171\3\2\2\2\177\u0175" +
          "\3\2\2\2\u0081\u017f\3\2\2\2\u0083\u0183\3\2\2\2\u0085\u018c\3\2\2\2\u0087" +
          "\u0191\3\2\2\2\u0089\u019c\3\2\2\2\u008b\u01a6\3\2\2\2\u008d\u008e\7k" +
          "\2\2\u008e\u008f\7p\2\2\u008f\u0090\7v\2\2\u0090\4\3\2\2\2\u0091\u0092" +
          "\7d\2\2\u0092\u0093\7q\2\2\u0093\u0094\7q\2\2\u0094\u0095\7n\2\2\u0095" +
          "\6\3\2\2\2\u0096\u0097\7e\2\2\u0097\u0098\7j\2\2\u0098\u0099\7c\2\2\u0099" +
          "\u009a\7t\2\2\u009a\b\3\2\2\2\u009b\u009c\7u\2\2\u009c\u009d\7v\2\2\u009d" +
          "\u009e\7t\2\2\u009e\u009f\7k\2\2\u009f\u00a0\7p\2\2\u00a0\u00a1\7i\2\2" +
          "\u00a1\n\3\2\2\2\u00a2\u00a3\7%\2\2\u00a3\f\3\2\2\2\u00a4\u00a5\7a\2\2" +
          "\u00a5\16\3\2\2\2\u00a6\u00a7\t\2\2\2\u00a7\20\3\2\2\2\u00a8\u00a9\4\62" +
          ";\2\u00a9\22\3\2\2\2\u00aa\u00ab\4c|\2\u00ab\24\3\2\2\2\u00ac\u00ad\4" +
          "C\\\2\u00ad\26\3\2\2\2\u00ae\u00b2\n\3\2\2\u00af\u00b0\7^\2\2\u00b0\u00b2" +
          "\5\17\b\2\u00b1\u00ae\3\2\2\2\u00b1\u00af\3\2\2\2\u00b2\30\3\2\2\2\u00b3" +
          "\u00b4\7p\2\2\u00b4\u00b5\7w\2\2\u00b5\u00b6\7n\2\2\u00b6\u00b7\7n\2\2" +
          "\u00b7\32\3\2\2\2\u00b8\u00b9\7v\2\2\u00b9\u00ba\7t\2\2\u00ba\u00bb\7" +
          "w\2\2\u00bb\u00bc\7g\2\2\u00bc\34\3\2\2\2\u00bd\u00be\7h\2\2\u00be\u00bf" +
          "\7c\2\2\u00bf\u00c0\7n\2\2\u00c0\u00c1\7u\2\2\u00c1\u00c2\7g\2\2\u00c2" +
          "\36\3\2\2\2\u00c3\u00c4\7d\2\2\u00c4\u00c5\7g\2\2\u00c5\u00c6\7i\2\2\u00c6" +
          "\u00c7\7k\2\2\u00c7\u00c8\7p\2\2\u00c8 \3\2\2\2\u00c9\u00ca\7g\2\2\u00ca" +
          "\u00cb\7p\2\2\u00cb\u00cc\7f\2\2\u00cc\"\3\2\2\2\u00cd\u00ce\7k\2\2\u00ce" +
          "\u00cf\7u\2\2\u00cf$\3\2\2\2\u00d0\u00d1\7k\2\2\u00d1\u00d2\7h\2\2\u00d2" +
          "&\3\2\2\2\u00d3\u00d4\7v\2\2\u00d4\u00d5\7j\2\2\u00d5\u00d6\7g\2\2\u00d6" +
          "\u00d7\7p\2\2\u00d7(\3\2\2\2\u00d8\u00d9\7g\2\2\u00d9\u00da\7n\2\2\u00da" +
          "\u00db\7u\2\2\u00db\u00dc\7g\2\2\u00dc*\3\2\2\2\u00dd\u00de\7h\2\2\u00de" +
          "\u00df\7k\2\2\u00df,\3\2\2\2\u00e0\u00e1\7t\2\2\u00e1\u00e2\7g\2\2\u00e2" +
          "\u00e3\7c\2\2\u00e3\u00e4\7f\2\2\u00e4.\3\2\2\2\u00e5\u00e6\7h\2\2\u00e6" +
          "\u00e7\7t\2\2\u00e7\u00e8\7g\2\2\u00e8\u00e9\7g\2\2\u00e9\60\3\2\2\2\u00ea" +
          "\u00eb\7t\2\2\u00eb\u00ec\7g\2\2\u00ec\u00ed\7v\2\2\u00ed\u00ee\7w\2\2" +
          "\u00ee\u00ef\7t\2\2\u00ef\u00f0\7p\2\2\u00f0\62\3\2\2\2\u00f1\u00f2\7" +
          "g\2\2\u00f2\u00f3\7z\2\2\u00f3\u00f4\7k\2\2\u00f4\u00f5\7v\2\2\u00f5\64" +
          "\3\2\2\2\u00f6\u00f7\7r\2\2\u00f7\u00f8\7t\2\2\u00f8\u00f9\7k\2\2\u00f9" +
          "\u00fa\7p\2\2\u00fa\u00fb\7v\2\2\u00fb\66\3\2\2\2\u00fc\u00fd\7r\2\2\u00fd" +
          "\u00fe\7t\2\2\u00fe\u00ff\7k\2\2\u00ff\u0100\7p\2\2\u0100\u0101\7v\2\2" +
          "\u0101\u0102\7n\2\2\u0102\u0103\7p\2\2\u01038\3\2\2\2\u0104\u0105\7u\2" +
          "\2\u0105\u0106\7m\2\2\u0106\u0107\7k\2\2\u0107\u0108\7r\2\2\u0108:\3\2" +
          "\2\2\u0109\u010a\7p\2\2\u010a\u010b\7g\2\2\u010b\u010c\7y\2\2\u010c\u010d" +
          "\7r\2\2\u010d\u010e\7c\2\2\u010e\u010f\7k\2\2\u010f\u0110\7t\2\2\u0110" +
          "<\3\2\2\2\u0111\u0112\7e\2\2\u0112\u0113\7c\2\2\u0113\u0114\7n\2\2\u0114" +
          "\u0115\7n\2\2\u0115>\3\2\2\2\u0116\u0117\7h\2\2\u0117\u0118\7u\2\2\u0118" +
          "\u0119\7v\2\2\u0119@\3\2\2\2\u011a\u011b\7u\2\2\u011b\u011c\7p\2\2\u011c" +
          "\u011d\7f\2\2\u011dB\3\2\2\2\u011e\u011f\7r\2\2\u011f\u0120\7c\2\2\u0120" +
          "\u0121\7k\2\2\u0121\u0122\7t\2\2\u0122D\3\2\2\2\u0123\u0124\7y\2\2\u0124" +
          "\u0125\7j\2\2\u0125\u0126\7k\2\2\u0126\u0127\7n\2\2\u0127\u0128\7g\2\2" +
          "\u0128F\3\2\2\2\u0129\u012a\7f\2\2\u012a\u012b\7q\2\2\u012bH\3\2\2\2\u012c" +
          "\u012d\7f\2\2\u012d\u012e\7q\2\2\u012e\u012f\7p\2\2\u012f\u0130\7g\2\2" +
          "\u0130J\3\2\2\2\u0131\u0132\7=\2\2\u0132L\3\2\2\2\u0133\u0134\7/\2\2\u0134" +
          "N\3\2\2\2\u0135\u0136\7-\2\2\u0136P\3\2\2\2\u0137\u0138\7e\2\2\u0138\u0139" +
          "\7j\2\2\u0139\u013a\7t\2\2\u013aR\3\2\2\2\u013b\u013c\7q\2\2\u013c\u013d" +
          "\7t\2\2\u013d\u013e\7f\2\2\u013eT\3\2\2\2\u013f\u0140\7n\2\2\u0140\u0141" +
          "\7g\2\2\u0141\u0142\7p\2\2\u0142V\3\2\2\2\u0143\u0144\7#\2\2\u0144X\3" +
          "\2\2\2\u0145\u0146\7,\2\2\u0146Z\3\2\2\2\u0147\u0148\7\61\2\2\u0148\\" +
          "\3\2\2\2\u0149\u014a\7\'\2\2\u014a^\3\2\2\2\u014b\u014c\7@\2\2\u014c`" +
          "\3\2\2\2\u014d\u014e\7@\2\2\u014e\u014f\7?\2\2\u014fb\3\2\2\2\u0150\u0151" +
          "\7>\2\2\u0151d\3\2\2\2\u0152\u0153\7>\2\2\u0153\u0154\7?\2\2\u0154f\3" +
          "\2\2\2\u0155\u0156\7?\2\2\u0156\u0157\7?\2\2\u0157h\3\2\2\2\u0158\u0159" +
          "\7#\2\2\u0159\u015a\7?\2\2\u015aj\3\2\2\2\u015b\u015c\7(\2\2\u015c\u015d" +
          "\7(\2\2\u015dl\3\2\2\2\u015e\u015f\7~\2\2\u015f\u0160\7~\2\2\u0160n\3" +
          "\2\2\2\u0161\u0162\7.\2\2\u0162p\3\2\2\2\u0163\u0164\7?\2\2\u0164r\3\2" +
          "\2\2\u0165\u0166\7]\2\2\u0166t\3\2\2\2\u0167\u0168\7_\2\2\u0168v\3\2\2" +
          "\2\u0169\u016a\7*\2\2\u016ax\3\2\2\2\u016b\u016c\7+\2\2\u016cz\3\2\2\2" +
          "\u016d\u0170\5\33\16\2\u016e\u0170\5\35\17\2\u016f\u016d\3\2\2\2\u016f" +
          "\u016e\3\2\2\2\u0170|\3\2\2\2\u0171\u0172\7)\2\2\u0172\u0173\5\27\f\2" +
          "\u0173\u0174\7)\2\2\u0174~\3\2\2\2\u0175\u0179\7$\2\2\u0176\u0178\5\27" +
          "\f\2\u0177\u0176\3\2\2\2\u0178\u017b\3\2\2\2\u0179\u0177\3\2\2\2\u0179" +
          "\u017a\3\2\2\2\u017a\u017c\3\2\2\2\u017b\u0179\3\2\2\2\u017c\u017d\7$" +
          "\2\2\u017d\u0080\3\2\2\2\u017e\u0180\5\21\t\2\u017f\u017e\3\2\2\2\u0180" +
          "\u0181\3\2\2\2\u0181\u017f\3\2\2\2\u0181\u0182\3\2\2\2\u0182\u0082\3\2" +
          "\2\2\u0183\u0184\7p\2\2\u0184\u0185\7w\2\2\u0185\u0186\7n\2\2\u0186\u0187" +
          "\7n\2\2\u0187\u0084\3\2\2\2\u0188\u018d\5\3\2\2\u0189\u018d\5\5\3\2\u018a" +
          "\u018d\5\7\4\2\u018b\u018d\5\t\5\2\u018c\u0188\3\2\2\2\u018c\u0189\3\2" +
          "\2\2\u018c\u018a\3\2\2\2\u018c\u018b\3\2\2\2\u018d\u0086\3\2\2\2\u018e" +
          "\u0192\5\r\7\2\u018f\u0192\5\23\n\2\u0190\u0192\5\25\13\2\u0191\u018e" +
          "\3\2\2\2\u0191\u018f\3\2\2\2\u0191\u0190\3\2\2\2\u0192\u0199\3\2\2\2\u0193" +
          "\u0198\5\r\7\2\u0194\u0198\5\23\n\2\u0195\u0198\5\25\13\2\u0196\u0198" +
          "\5\21\t\2\u0197\u0193\3\2\2\2\u0197\u0194\3\2\2\2\u0197\u0195\3\2\2\2" +
          "\u0197\u0196\3\2\2\2\u0198\u019b\3\2\2\2\u0199\u0197\3\2\2\2\u0199\u019a" +
          "\3\2\2\2\u019a\u0088\3\2\2\2\u019b\u0199\3\2\2\2\u019c\u01a0\7%\2\2\u019d" +
          "\u019f\n\4\2\2\u019e\u019d\3\2\2\2\u019f\u01a2\3\2\2\2\u01a0\u019e\3\2" +
          "\2\2\u01a0\u01a1\3\2\2\2\u01a1\u01a3\3\2\2\2\u01a2\u01a0\3\2\2\2\u01a3" +
          "\u01a4\bE\2\2\u01a4\u008a\3\2\2\2\u01a5\u01a7\t\5\2\2\u01a6\u01a5\3\2" +
          "\2\2\u01a7\u01a8\3\2\2\2\u01a8\u01a6\3\2\2\2\u01a8\u01a9\3\2\2\2\u01a9" +
          "\u01aa\3\2\2\2\u01aa\u01ab\bF\2\2\u01ab\u008c\3\2\2\2\r\2\u00b1\u016f" +
          "\u0179\u0181\u018c\u0191\u0197\u0199\u01a0\u01a8\3\b\2\2";
  public static final ATN _ATN =
      new ATNDeserializer().deserialize(_serializedATN.toCharArray());

  static {
    _decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
    for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
      _decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
    }
  }
}