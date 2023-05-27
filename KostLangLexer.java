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
		T__0=1, T__1=2, T__2=3, PRINT=4, WRITE=5, READ=6, TRUE=7, FALSE=8, STRING=9, 
		ID=10, REAL=11, INT=12, TOINT=13, TOREAL=14, ADD=15, SUB=16, MULT=17, 
		DIV=18, NEWLINE=19, WS=20;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "PRINT", "WRITE", "READ", "TRUE", "FALSE", "STRING", 
			"ID", "REAL", "INT", "TOINT", "TOREAL", "ADD", "SUB", "MULT", "DIV", 
			"NEWLINE", "WS"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'='", "'('", "')'", "'print'", "'write'", "'read'", "'true'", 
			"'false'", null, null, null, null, "'(int)'", "'(real)'", "'+'", "'-'", 
			"'*'", "'/'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, "PRINT", "WRITE", "READ", "TRUE", "FALSE", "STRING", 
			"ID", "REAL", "INT", "TOINT", "TOREAL", "ADD", "SUB", "MULT", "DIV", 
			"NEWLINE", "WS"
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

	@Override
	public void action(RuleContext _localctx, int ruleIndex, int actionIndex) {
		switch (ruleIndex) {
		case 19:
			WS_action((RuleContext)_localctx, actionIndex);
			break;
		}
	}
	private void WS_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 0:
			 skip(); 
			break;
		}
	}

	public static final String _serializedATN =
		"\u0004\u0000\u0014\u008a\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002"+
		"\u0001\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002"+
		"\u0004\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002"+
		"\u0007\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002"+
		"\u000b\u0007\u000b\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e"+
		"\u0002\u000f\u0007\u000f\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011"+
		"\u0002\u0012\u0007\u0012\u0002\u0013\u0007\u0013\u0001\u0000\u0001\u0000"+
		"\u0001\u0001\u0001\u0001\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007"+
		"\u0001\u0007\u0001\u0007\u0001\b\u0001\b\u0005\bN\b\b\n\b\f\bQ\t\b\u0001"+
		"\b\u0001\b\u0001\t\u0004\tV\b\t\u000b\t\f\tW\u0001\n\u0004\n[\b\n\u000b"+
		"\n\f\n\\\u0001\n\u0001\n\u0004\na\b\n\u000b\n\f\nb\u0001\u000b\u0004\u000b"+
		"f\b\u000b\u000b\u000b\f\u000bg\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f"+
		"\u0001\f\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001"+
		"\u000e\u0001\u000e\u0001\u000f\u0001\u000f\u0001\u0010\u0001\u0010\u0001"+
		"\u0011\u0001\u0011\u0001\u0012\u0003\u0012\u0080\b\u0012\u0001\u0012\u0001"+
		"\u0012\u0001\u0013\u0004\u0013\u0085\b\u0013\u000b\u0013\f\u0013\u0086"+
		"\u0001\u0013\u0001\u0013\u0000\u0000\u0014\u0001\u0001\u0003\u0002\u0005"+
		"\u0003\u0007\u0004\t\u0005\u000b\u0006\r\u0007\u000f\b\u0011\t\u0013\n"+
		"\u0015\u000b\u0017\f\u0019\r\u001b\u000e\u001d\u000f\u001f\u0010!\u0011"+
		"#\u0012%\u0013\'\u0014\u0001\u0000\u0003\u0002\u0000\"\"\\\\\u0002\u0000"+
		"AZaz\u0002\u0000\t\t  \u0090\u0000\u0001\u0001\u0000\u0000\u0000\u0000"+
		"\u0003\u0001\u0000\u0000\u0000\u0000\u0005\u0001\u0000\u0000\u0000\u0000"+
		"\u0007\u0001\u0000\u0000\u0000\u0000\t\u0001\u0000\u0000\u0000\u0000\u000b"+
		"\u0001\u0000\u0000\u0000\u0000\r\u0001\u0000\u0000\u0000\u0000\u000f\u0001"+
		"\u0000\u0000\u0000\u0000\u0011\u0001\u0000\u0000\u0000\u0000\u0013\u0001"+
		"\u0000\u0000\u0000\u0000\u0015\u0001\u0000\u0000\u0000\u0000\u0017\u0001"+
		"\u0000\u0000\u0000\u0000\u0019\u0001\u0000\u0000\u0000\u0000\u001b\u0001"+
		"\u0000\u0000\u0000\u0000\u001d\u0001\u0000\u0000\u0000\u0000\u001f\u0001"+
		"\u0000\u0000\u0000\u0000!\u0001\u0000\u0000\u0000\u0000#\u0001\u0000\u0000"+
		"\u0000\u0000%\u0001\u0000\u0000\u0000\u0000\'\u0001\u0000\u0000\u0000"+
		"\u0001)\u0001\u0000\u0000\u0000\u0003+\u0001\u0000\u0000\u0000\u0005-"+
		"\u0001\u0000\u0000\u0000\u0007/\u0001\u0000\u0000\u0000\t5\u0001\u0000"+
		"\u0000\u0000\u000b;\u0001\u0000\u0000\u0000\r@\u0001\u0000\u0000\u0000"+
		"\u000fE\u0001\u0000\u0000\u0000\u0011K\u0001\u0000\u0000\u0000\u0013U"+
		"\u0001\u0000\u0000\u0000\u0015Z\u0001\u0000\u0000\u0000\u0017e\u0001\u0000"+
		"\u0000\u0000\u0019i\u0001\u0000\u0000\u0000\u001bo\u0001\u0000\u0000\u0000"+
		"\u001dv\u0001\u0000\u0000\u0000\u001fx\u0001\u0000\u0000\u0000!z\u0001"+
		"\u0000\u0000\u0000#|\u0001\u0000\u0000\u0000%\u007f\u0001\u0000\u0000"+
		"\u0000\'\u0084\u0001\u0000\u0000\u0000)*\u0005=\u0000\u0000*\u0002\u0001"+
		"\u0000\u0000\u0000+,\u0005(\u0000\u0000,\u0004\u0001\u0000\u0000\u0000"+
		"-.\u0005)\u0000\u0000.\u0006\u0001\u0000\u0000\u0000/0\u0005p\u0000\u0000"+
		"01\u0005r\u0000\u000012\u0005i\u0000\u000023\u0005n\u0000\u000034\u0005"+
		"t\u0000\u00004\b\u0001\u0000\u0000\u000056\u0005w\u0000\u000067\u0005"+
		"r\u0000\u000078\u0005i\u0000\u000089\u0005t\u0000\u00009:\u0005e\u0000"+
		"\u0000:\n\u0001\u0000\u0000\u0000;<\u0005r\u0000\u0000<=\u0005e\u0000"+
		"\u0000=>\u0005a\u0000\u0000>?\u0005d\u0000\u0000?\f\u0001\u0000\u0000"+
		"\u0000@A\u0005t\u0000\u0000AB\u0005r\u0000\u0000BC\u0005u\u0000\u0000"+
		"CD\u0005e\u0000\u0000D\u000e\u0001\u0000\u0000\u0000EF\u0005f\u0000\u0000"+
		"FG\u0005a\u0000\u0000GH\u0005l\u0000\u0000HI\u0005s\u0000\u0000IJ\u0005"+
		"e\u0000\u0000J\u0010\u0001\u0000\u0000\u0000KO\u0005\"\u0000\u0000LN\b"+
		"\u0000\u0000\u0000ML\u0001\u0000\u0000\u0000NQ\u0001\u0000\u0000\u0000"+
		"OM\u0001\u0000\u0000\u0000OP\u0001\u0000\u0000\u0000PR\u0001\u0000\u0000"+
		"\u0000QO\u0001\u0000\u0000\u0000RS\u0005\"\u0000\u0000S\u0012\u0001\u0000"+
		"\u0000\u0000TV\u0007\u0001\u0000\u0000UT\u0001\u0000\u0000\u0000VW\u0001"+
		"\u0000\u0000\u0000WU\u0001\u0000\u0000\u0000WX\u0001\u0000\u0000\u0000"+
		"X\u0014\u0001\u0000\u0000\u0000Y[\u000209\u0000ZY\u0001\u0000\u0000\u0000"+
		"[\\\u0001\u0000\u0000\u0000\\Z\u0001\u0000\u0000\u0000\\]\u0001\u0000"+
		"\u0000\u0000]^\u0001\u0000\u0000\u0000^`\u0005.\u0000\u0000_a\u000209"+
		"\u0000`_\u0001\u0000\u0000\u0000ab\u0001\u0000\u0000\u0000b`\u0001\u0000"+
		"\u0000\u0000bc\u0001\u0000\u0000\u0000c\u0016\u0001\u0000\u0000\u0000"+
		"df\u000209\u0000ed\u0001\u0000\u0000\u0000fg\u0001\u0000\u0000\u0000g"+
		"e\u0001\u0000\u0000\u0000gh\u0001\u0000\u0000\u0000h\u0018\u0001\u0000"+
		"\u0000\u0000ij\u0005(\u0000\u0000jk\u0005i\u0000\u0000kl\u0005n\u0000"+
		"\u0000lm\u0005t\u0000\u0000mn\u0005)\u0000\u0000n\u001a\u0001\u0000\u0000"+
		"\u0000op\u0005(\u0000\u0000pq\u0005r\u0000\u0000qr\u0005e\u0000\u0000"+
		"rs\u0005a\u0000\u0000st\u0005l\u0000\u0000tu\u0005)\u0000\u0000u\u001c"+
		"\u0001\u0000\u0000\u0000vw\u0005+\u0000\u0000w\u001e\u0001\u0000\u0000"+
		"\u0000xy\u0005-\u0000\u0000y \u0001\u0000\u0000\u0000z{\u0005*\u0000\u0000"+
		"{\"\u0001\u0000\u0000\u0000|}\u0005/\u0000\u0000}$\u0001\u0000\u0000\u0000"+
		"~\u0080\u0005\r\u0000\u0000\u007f~\u0001\u0000\u0000\u0000\u007f\u0080"+
		"\u0001\u0000\u0000\u0000\u0080\u0081\u0001\u0000\u0000\u0000\u0081\u0082"+
		"\u0005\n\u0000\u0000\u0082&\u0001\u0000\u0000\u0000\u0083\u0085\u0007"+
		"\u0002\u0000\u0000\u0084\u0083\u0001\u0000\u0000\u0000\u0085\u0086\u0001"+
		"\u0000\u0000\u0000\u0086\u0084\u0001\u0000\u0000\u0000\u0086\u0087\u0001"+
		"\u0000\u0000\u0000\u0087\u0088\u0001\u0000\u0000\u0000\u0088\u0089\u0006"+
		"\u0013\u0000\u0000\u0089(\u0001\u0000\u0000\u0000\b\u0000OW\\bg\u007f"+
		"\u0086\u0001\u0001\u0013\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}