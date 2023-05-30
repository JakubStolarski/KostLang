// Generated from KostLang.g4 by ANTLR 4.13.0
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class KostLangLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.13.0", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, PRINT=4, WRITE=5, READ=6, TRUE=7, FALSE=8, AND=9, 
		OR=10, XOR=11, NEG=12, SIZEOF=13, STRING=14, ID=15, REAL=16, INT=17, ADD=18, 
		SUB=19, MULT=20, DIV=21, NEWLINE=22, WS=23;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "PRINT", "WRITE", "READ", "TRUE", "FALSE", "AND", 
			"OR", "XOR", "NEG", "SIZEOF", "STRING", "ID", "REAL", "INT", "ADD", "SUB", 
			"MULT", "DIV", "NEWLINE", "WS"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'='", "'('", "')'", "'print'", "'write'", "'read'", "'true'", 
			"'false'", "'and'", "'or'", "'xor'", "'!'", "'sizeof'", null, null, null, 
			null, "'+'", "'-'", "'*'", "'/'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, "PRINT", "WRITE", "READ", "TRUE", "FALSE", "AND", 
			"OR", "XOR", "NEG", "SIZEOF", "STRING", "ID", "REAL", "INT", "ADD", "SUB", 
			"MULT", "DIV", "NEWLINE", "WS"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
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


	public KostLangLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "KostLang.g4"; }

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
		"\u0004\u0000\u0017\u0094\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002"+
		"\u0001\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002"+
		"\u0004\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002"+
		"\u0007\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002"+
		"\u000b\u0007\u000b\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e"+
		"\u0002\u000f\u0007\u000f\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011"+
		"\u0002\u0012\u0007\u0012\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014"+
		"\u0002\u0015\u0007\u0015\u0002\u0016\u0007\u0016\u0001\u0000\u0001\u0000"+
		"\u0001\u0001\u0001\u0001\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007"+
		"\u0001\u0007\u0001\u0007\u0001\b\u0001\b\u0001\b\u0001\b\u0001\t\u0001"+
		"\t\u0001\t\u0001\n\u0001\n\u0001\n\u0001\n\u0001\u000b\u0001\u000b\u0001"+
		"\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\r\u0001\r\u0005"+
		"\rh\b\r\n\r\f\rk\t\r\u0001\r\u0001\r\u0001\u000e\u0004\u000ep\b\u000e"+
		"\u000b\u000e\f\u000eq\u0001\u000f\u0004\u000fu\b\u000f\u000b\u000f\f\u000f"+
		"v\u0001\u000f\u0001\u000f\u0004\u000f{\b\u000f\u000b\u000f\f\u000f|\u0001"+
		"\u0010\u0004\u0010\u0080\b\u0010\u000b\u0010\f\u0010\u0081\u0001\u0011"+
		"\u0001\u0011\u0001\u0012\u0001\u0012\u0001\u0013\u0001\u0013\u0001\u0014"+
		"\u0001\u0014\u0001\u0015\u0003\u0015\u008d\b\u0015\u0001\u0015\u0001\u0015"+
		"\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0000\u0000\u0017\u0001"+
		"\u0001\u0003\u0002\u0005\u0003\u0007\u0004\t\u0005\u000b\u0006\r\u0007"+
		"\u000f\b\u0011\t\u0013\n\u0015\u000b\u0017\f\u0019\r\u001b\u000e\u001d"+
		"\u000f\u001f\u0010!\u0011#\u0012%\u0013\'\u0014)\u0015+\u0016-\u0017\u0001"+
		"\u0000\u0003\u0002\u0000\"\"\\\\\u0002\u0000AZaz\u0002\u0000\t\t  \u0099"+
		"\u0000\u0001\u0001\u0000\u0000\u0000\u0000\u0003\u0001\u0000\u0000\u0000"+
		"\u0000\u0005\u0001\u0000\u0000\u0000\u0000\u0007\u0001\u0000\u0000\u0000"+
		"\u0000\t\u0001\u0000\u0000\u0000\u0000\u000b\u0001\u0000\u0000\u0000\u0000"+
		"\r\u0001\u0000\u0000\u0000\u0000\u000f\u0001\u0000\u0000\u0000\u0000\u0011"+
		"\u0001\u0000\u0000\u0000\u0000\u0013\u0001\u0000\u0000\u0000\u0000\u0015"+
		"\u0001\u0000\u0000\u0000\u0000\u0017\u0001\u0000\u0000\u0000\u0000\u0019"+
		"\u0001\u0000\u0000\u0000\u0000\u001b\u0001\u0000\u0000\u0000\u0000\u001d"+
		"\u0001\u0000\u0000\u0000\u0000\u001f\u0001\u0000\u0000\u0000\u0000!\u0001"+
		"\u0000\u0000\u0000\u0000#\u0001\u0000\u0000\u0000\u0000%\u0001\u0000\u0000"+
		"\u0000\u0000\'\u0001\u0000\u0000\u0000\u0000)\u0001\u0000\u0000\u0000"+
		"\u0000+\u0001\u0000\u0000\u0000\u0000-\u0001\u0000\u0000\u0000\u0001/"+
		"\u0001\u0000\u0000\u0000\u00031\u0001\u0000\u0000\u0000\u00053\u0001\u0000"+
		"\u0000\u0000\u00075\u0001\u0000\u0000\u0000\t;\u0001\u0000\u0000\u0000"+
		"\u000bA\u0001\u0000\u0000\u0000\rF\u0001\u0000\u0000\u0000\u000fK\u0001"+
		"\u0000\u0000\u0000\u0011Q\u0001\u0000\u0000\u0000\u0013U\u0001\u0000\u0000"+
		"\u0000\u0015X\u0001\u0000\u0000\u0000\u0017\\\u0001\u0000\u0000\u0000"+
		"\u0019^\u0001\u0000\u0000\u0000\u001be\u0001\u0000\u0000\u0000\u001do"+
		"\u0001\u0000\u0000\u0000\u001ft\u0001\u0000\u0000\u0000!\u007f\u0001\u0000"+
		"\u0000\u0000#\u0083\u0001\u0000\u0000\u0000%\u0085\u0001\u0000\u0000\u0000"+
		"\'\u0087\u0001\u0000\u0000\u0000)\u0089\u0001\u0000\u0000\u0000+\u008c"+
		"\u0001\u0000\u0000\u0000-\u0090\u0001\u0000\u0000\u0000/0\u0005=\u0000"+
		"\u00000\u0002\u0001\u0000\u0000\u000012\u0005(\u0000\u00002\u0004\u0001"+
		"\u0000\u0000\u000034\u0005)\u0000\u00004\u0006\u0001\u0000\u0000\u0000"+
		"56\u0005p\u0000\u000067\u0005r\u0000\u000078\u0005i\u0000\u000089\u0005"+
		"n\u0000\u00009:\u0005t\u0000\u0000:\b\u0001\u0000\u0000\u0000;<\u0005"+
		"w\u0000\u0000<=\u0005r\u0000\u0000=>\u0005i\u0000\u0000>?\u0005t\u0000"+
		"\u0000?@\u0005e\u0000\u0000@\n\u0001\u0000\u0000\u0000AB\u0005r\u0000"+
		"\u0000BC\u0005e\u0000\u0000CD\u0005a\u0000\u0000DE\u0005d\u0000\u0000"+
		"E\f\u0001\u0000\u0000\u0000FG\u0005t\u0000\u0000GH\u0005r\u0000\u0000"+
		"HI\u0005u\u0000\u0000IJ\u0005e\u0000\u0000J\u000e\u0001\u0000\u0000\u0000"+
		"KL\u0005f\u0000\u0000LM\u0005a\u0000\u0000MN\u0005l\u0000\u0000NO\u0005"+
		"s\u0000\u0000OP\u0005e\u0000\u0000P\u0010\u0001\u0000\u0000\u0000QR\u0005"+
		"a\u0000\u0000RS\u0005n\u0000\u0000ST\u0005d\u0000\u0000T\u0012\u0001\u0000"+
		"\u0000\u0000UV\u0005o\u0000\u0000VW\u0005r\u0000\u0000W\u0014\u0001\u0000"+
		"\u0000\u0000XY\u0005x\u0000\u0000YZ\u0005o\u0000\u0000Z[\u0005r\u0000"+
		"\u0000[\u0016\u0001\u0000\u0000\u0000\\]\u0005!\u0000\u0000]\u0018\u0001"+
		"\u0000\u0000\u0000^_\u0005s\u0000\u0000_`\u0005i\u0000\u0000`a\u0005z"+
		"\u0000\u0000ab\u0005e\u0000\u0000bc\u0005o\u0000\u0000cd\u0005f\u0000"+
		"\u0000d\u001a\u0001\u0000\u0000\u0000ei\u0005\"\u0000\u0000fh\b\u0000"+
		"\u0000\u0000gf\u0001\u0000\u0000\u0000hk\u0001\u0000\u0000\u0000ig\u0001"+
		"\u0000\u0000\u0000ij\u0001\u0000\u0000\u0000jl\u0001\u0000\u0000\u0000"+
		"ki\u0001\u0000\u0000\u0000lm\u0005\"\u0000\u0000m\u001c\u0001\u0000\u0000"+
		"\u0000np\u0007\u0001\u0000\u0000on\u0001\u0000\u0000\u0000pq\u0001\u0000"+
		"\u0000\u0000qo\u0001\u0000\u0000\u0000qr\u0001\u0000\u0000\u0000r\u001e"+
		"\u0001\u0000\u0000\u0000su\u000209\u0000ts\u0001\u0000\u0000\u0000uv\u0001"+
		"\u0000\u0000\u0000vt\u0001\u0000\u0000\u0000vw\u0001\u0000\u0000\u0000"+
		"wx\u0001\u0000\u0000\u0000xz\u0005.\u0000\u0000y{\u000209\u0000zy\u0001"+
		"\u0000\u0000\u0000{|\u0001\u0000\u0000\u0000|z\u0001\u0000\u0000\u0000"+
		"|}\u0001\u0000\u0000\u0000} \u0001\u0000\u0000\u0000~\u0080\u000209\u0000"+
		"\u007f~\u0001\u0000\u0000\u0000\u0080\u0081\u0001\u0000\u0000\u0000\u0081"+
		"\u007f\u0001\u0000\u0000\u0000\u0081\u0082\u0001\u0000\u0000\u0000\u0082"+
		"\"\u0001\u0000\u0000\u0000\u0083\u0084\u0005+\u0000\u0000\u0084$\u0001"+
		"\u0000\u0000\u0000\u0085\u0086\u0005-\u0000\u0000\u0086&\u0001\u0000\u0000"+
		"\u0000\u0087\u0088\u0005*\u0000\u0000\u0088(\u0001\u0000\u0000\u0000\u0089"+
		"\u008a\u0005/\u0000\u0000\u008a*\u0001\u0000\u0000\u0000\u008b\u008d\u0005"+
		"\r\u0000\u0000\u008c\u008b\u0001\u0000\u0000\u0000\u008c\u008d\u0001\u0000"+
		"\u0000\u0000\u008d\u008e\u0001\u0000\u0000\u0000\u008e\u008f\u0005\n\u0000"+
		"\u0000\u008f,\u0001\u0000\u0000\u0000\u0090\u0091\u0007\u0002\u0000\u0000"+
		"\u0091\u0092\u0001\u0000\u0000\u0000\u0092\u0093\u0006\u0016\u0000\u0000"+
		"\u0093.\u0001\u0000\u0000\u0000\u0007\u0000iqv|\u0081\u008c\u0001\u0006"+
		"\u0000\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}