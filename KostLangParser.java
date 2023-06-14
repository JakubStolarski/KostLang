// Generated from KostLang.g4 by ANTLR 4.13.0
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class KostLangParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.0", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, PRINT=12, WRITE=13, READ=14, TRUE=15, FALSE=16, AND=17, 
		OR=18, XOR=19, NEG=20, SIZEOF=21, ENDIF=22, ENDWHILE=23, ENDF=24, IF=25, 
		ELSE=26, WHILE=27, DO=28, INTTYPE=29, REALTYPE=30, STRING=31, ID=32, REAL=33, 
		INT=34, ADD=35, SUB=36, MULT=37, DIV=38, NEWLINE=39, WS=40;
	public static final int
		RULE_prog = 0, RULE_block = 1, RULE_stat = 2, RULE_call = 3, RULE_function = 4, 
		RULE_declare = 5, RULE_return = 6, RULE_params = 7, RULE_args = 8, RULE_fblock = 9, 
		RULE_blockif = 10, RULE_blockwhile = 11, RULE_condition = 12, RULE_conditionwhile = 13, 
		RULE_elsestat = 14, RULE_expr0 = 15, RULE_expr1 = 16, RULE_expr2 = 17, 
		RULE_expr3 = 18, RULE_expr4 = 19, RULE_bool = 20;
	private static String[] makeRuleNames() {
		return new String[] {
			"prog", "block", "stat", "call", "function", "declare", "return", "params", 
			"args", "fblock", "blockif", "blockwhile", "condition", "conditionwhile", 
			"elsestat", "expr0", "expr1", "expr2", "expr3", "expr4", "bool"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'='", "'('", "')'", "'return'", "':'", "','", "'=='", "'>='", 
			"'<='", "'>'", "'<'", "'print'", "'write'", "'read'", "'true'", "'false'", 
			"'and'", "'or'", "'xor'", "'!'", "'sizeof'", "'endif'", "'endwhile'", 
			"'endf'", "'if'", "'else'", "'while'", "'do'", "'int'", "'real'", null, 
			null, null, null, "'+'", "'-'", "'*'", "'/'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			"PRINT", "WRITE", "READ", "TRUE", "FALSE", "AND", "OR", "XOR", "NEG", 
			"SIZEOF", "ENDIF", "ENDWHILE", "ENDF", "IF", "ELSE", "WHILE", "DO", "INTTYPE", 
			"REALTYPE", "STRING", "ID", "REAL", "INT", "ADD", "SUB", "MULT", "DIV", 
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

	@Override
	public String getGrammarFileName() { return "KostLang.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public KostLangParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ProgContext extends ParserRuleContext {
		public List<TerminalNode> NEWLINE() { return getTokens(KostLangParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(KostLangParser.NEWLINE, i);
		}
		public List<StatContext> stat() {
			return getRuleContexts(StatContext.class);
		}
		public StatContext stat(int i) {
			return getRuleContext(StatContext.class,i);
		}
		public List<FunctionContext> function() {
			return getRuleContexts(FunctionContext.class);
		}
		public FunctionContext function(int i) {
			return getRuleContext(FunctionContext.class,i);
		}
		public ProgContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prog; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KostLangListener ) ((KostLangListener)listener).enterProg(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KostLangListener ) ((KostLangListener)listener).exitProg(this);
		}
	}

	public final ProgContext prog() throws RecognitionException {
		ProgContext _localctx = new ProgContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_prog);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(49);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 555829194752L) != 0)) {
				{
				{
				setState(44);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case PRINT:
				case WRITE:
				case READ:
				case IF:
				case WHILE:
				case ID:
					{
					setState(42);
					stat();
					}
					break;
				case INTTYPE:
				case REALTYPE:
					{
					setState(43);
					function();
					}
					break;
				case NEWLINE:
					break;
				default:
					break;
				}
				setState(46);
				match(NEWLINE);
				}
				}
				setState(51);
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

	@SuppressWarnings("CheckReturnValue")
	public static class BlockContext extends ParserRuleContext {
		public List<TerminalNode> NEWLINE() { return getTokens(KostLangParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(KostLangParser.NEWLINE, i);
		}
		public List<StatContext> stat() {
			return getRuleContexts(StatContext.class);
		}
		public StatContext stat(int i) {
			return getRuleContext(StatContext.class,i);
		}
		public BlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_block; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KostLangListener ) ((KostLangListener)listener).enterBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KostLangListener ) ((KostLangListener)listener).exitBlock(this);
		}
	}

	public final BlockContext block() throws RecognitionException {
		BlockContext _localctx = new BlockContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_block);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(58);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 554218582016L) != 0)) {
				{
				{
				setState(53);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 4462768128L) != 0)) {
					{
					setState(52);
					stat();
					}
				}

				setState(55);
				match(NEWLINE);
				}
				}
				setState(60);
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

	@SuppressWarnings("CheckReturnValue")
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
	@SuppressWarnings("CheckReturnValue")
	public static class PrintContext extends StatContext {
		public TerminalNode PRINT() { return getToken(KostLangParser.PRINT, 0); }
		public TerminalNode ID() { return getToken(KostLangParser.ID, 0); }
		public PrintContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KostLangListener ) ((KostLangListener)listener).enterPrint(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KostLangListener ) ((KostLangListener)listener).exitPrint(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class FuncallContext extends StatContext {
		public CallContext call() {
			return getRuleContext(CallContext.class,0);
		}
		public FuncallContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KostLangListener ) ((KostLangListener)listener).enterFuncall(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KostLangListener ) ((KostLangListener)listener).exitFuncall(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ReadContext extends StatContext {
		public TerminalNode READ() { return getToken(KostLangParser.READ, 0); }
		public TerminalNode ID() { return getToken(KostLangParser.ID, 0); }
		public ReadContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KostLangListener ) ((KostLangListener)listener).enterRead(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KostLangListener ) ((KostLangListener)listener).exitRead(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class WhileContext extends StatContext {
		public TerminalNode WHILE() { return getToken(KostLangParser.WHILE, 0); }
		public ConditionwhileContext conditionwhile() {
			return getRuleContext(ConditionwhileContext.class,0);
		}
		public TerminalNode DO() { return getToken(KostLangParser.DO, 0); }
		public BlockwhileContext blockwhile() {
			return getRuleContext(BlockwhileContext.class,0);
		}
		public TerminalNode ENDWHILE() { return getToken(KostLangParser.ENDWHILE, 0); }
		public WhileContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KostLangListener ) ((KostLangListener)listener).enterWhile(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KostLangListener ) ((KostLangListener)listener).exitWhile(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class WriteContext extends StatContext {
		public TerminalNode WRITE() { return getToken(KostLangParser.WRITE, 0); }
		public TerminalNode ID() { return getToken(KostLangParser.ID, 0); }
		public WriteContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KostLangListener ) ((KostLangListener)listener).enterWrite(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KostLangListener ) ((KostLangListener)listener).exitWrite(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class IfContext extends StatContext {
		public TerminalNode IF() { return getToken(KostLangParser.IF, 0); }
		public ConditionContext condition() {
			return getRuleContext(ConditionContext.class,0);
		}
		public TerminalNode DO() { return getToken(KostLangParser.DO, 0); }
		public BlockifContext blockif() {
			return getRuleContext(BlockifContext.class,0);
		}
		public TerminalNode ENDIF() { return getToken(KostLangParser.ENDIF, 0); }
		public ElsestatContext elsestat() {
			return getRuleContext(ElsestatContext.class,0);
		}
		public IfContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KostLangListener ) ((KostLangListener)listener).enterIf(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KostLangListener ) ((KostLangListener)listener).exitIf(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class AssignContext extends StatContext {
		public TerminalNode ID() { return getToken(KostLangParser.ID, 0); }
		public Expr0Context expr0() {
			return getRuleContext(Expr0Context.class,0);
		}
		public AssignContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KostLangListener ) ((KostLangListener)listener).enterAssign(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KostLangListener ) ((KostLangListener)listener).exitAssign(this);
		}
	}

	public final StatContext stat() throws RecognitionException {
		StatContext _localctx = new StatContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_stat);
		int _la;
		try {
			setState(86);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				_localctx = new AssignContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(61);
				match(ID);
				setState(62);
				match(T__0);
				setState(63);
				expr0();
				}
				break;
			case 2:
				_localctx = new PrintContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(64);
				match(PRINT);
				setState(65);
				match(ID);
				}
				break;
			case 3:
				_localctx = new ReadContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(66);
				match(READ);
				setState(67);
				match(ID);
				}
				break;
			case 4:
				_localctx = new WriteContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(68);
				match(WRITE);
				setState(69);
				match(ID);
				}
				break;
			case 5:
				_localctx = new IfContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(70);
				match(IF);
				setState(71);
				condition();
				setState(72);
				match(DO);
				setState(73);
				blockif();
				setState(75);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ELSE) {
					{
					setState(74);
					elsestat();
					}
				}

				setState(77);
				match(ENDIF);
				}
				break;
			case 6:
				_localctx = new WhileContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(79);
				match(WHILE);
				setState(80);
				conditionwhile();
				setState(81);
				match(DO);
				setState(82);
				blockwhile();
				setState(83);
				match(ENDWHILE);
				}
				break;
			case 7:
				_localctx = new FuncallContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(85);
				call();
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

	@SuppressWarnings("CheckReturnValue")
	public static class CallContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(KostLangParser.ID, 0); }
		public ArgsContext args() {
			return getRuleContext(ArgsContext.class,0);
		}
		public CallContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_call; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KostLangListener ) ((KostLangListener)listener).enterCall(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KostLangListener ) ((KostLangListener)listener).exitCall(this);
		}
	}

	public final CallContext call() throws RecognitionException {
		CallContext _localctx = new CallContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_call);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(88);
			match(ID);
			setState(89);
			match(T__1);
			setState(91);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 32212254724L) != 0)) {
				{
				setState(90);
				args();
				}
			}

			setState(93);
			match(T__2);
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

	@SuppressWarnings("CheckReturnValue")
	public static class FunctionContext extends ParserRuleContext {
		public DeclareContext declare() {
			return getRuleContext(DeclareContext.class,0);
		}
		public FblockContext fblock() {
			return getRuleContext(FblockContext.class,0);
		}
		public ReturnContext return_() {
			return getRuleContext(ReturnContext.class,0);
		}
		public TerminalNode ENDF() { return getToken(KostLangParser.ENDF, 0); }
		public ParamsContext params() {
			return getRuleContext(ParamsContext.class,0);
		}
		public FunctionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_function; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KostLangListener ) ((KostLangListener)listener).enterFunction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KostLangListener ) ((KostLangListener)listener).exitFunction(this);
		}
	}

	public final FunctionContext function() throws RecognitionException {
		FunctionContext _localctx = new FunctionContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_function);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(95);
			declare();
			setState(96);
			match(T__1);
			setState(98);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ID) {
				{
				setState(97);
				params();
				}
			}

			setState(100);
			match(T__2);
			setState(101);
			fblock();
			setState(102);
			return_();
			setState(103);
			match(ENDF);
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

	@SuppressWarnings("CheckReturnValue")
	public static class DeclareContext extends ParserRuleContext {
		public DeclareContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declare; }
	 
		public DeclareContext() { }
		public void copyFrom(DeclareContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class RealtypeContext extends DeclareContext {
		public TerminalNode REALTYPE() { return getToken(KostLangParser.REALTYPE, 0); }
		public TerminalNode ID() { return getToken(KostLangParser.ID, 0); }
		public RealtypeContext(DeclareContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KostLangListener ) ((KostLangListener)listener).enterRealtype(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KostLangListener ) ((KostLangListener)listener).exitRealtype(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class InttypeContext extends DeclareContext {
		public TerminalNode INTTYPE() { return getToken(KostLangParser.INTTYPE, 0); }
		public TerminalNode ID() { return getToken(KostLangParser.ID, 0); }
		public InttypeContext(DeclareContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KostLangListener ) ((KostLangListener)listener).enterInttype(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KostLangListener ) ((KostLangListener)listener).exitInttype(this);
		}
	}

	public final DeclareContext declare() throws RecognitionException {
		DeclareContext _localctx = new DeclareContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_declare);
		try {
			setState(109);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INTTYPE:
				_localctx = new InttypeContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(105);
				match(INTTYPE);
				setState(106);
				match(ID);
				}
				break;
			case REALTYPE:
				_localctx = new RealtypeContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(107);
				match(REALTYPE);
				setState(108);
				match(ID);
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

	@SuppressWarnings("CheckReturnValue")
	public static class ReturnContext extends ParserRuleContext {
		public Expr2Context expr2() {
			return getRuleContext(Expr2Context.class,0);
		}
		public ReturnContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_return; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KostLangListener ) ((KostLangListener)listener).enterReturn(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KostLangListener ) ((KostLangListener)listener).exitReturn(this);
		}
	}

	public final ReturnContext return_() throws RecognitionException {
		ReturnContext _localctx = new ReturnContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_return);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(111);
			match(T__3);
			setState(112);
			expr2();
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

	@SuppressWarnings("CheckReturnValue")
	public static class ParamsContext extends ParserRuleContext {
		public ParamsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_params; }
	 
		public ParamsContext() { }
		public void copyFrom(ParamsContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class IntparamContext extends ParamsContext {
		public TerminalNode ID() { return getToken(KostLangParser.ID, 0); }
		public TerminalNode INTTYPE() { return getToken(KostLangParser.INTTYPE, 0); }
		public List<ParamsContext> params() {
			return getRuleContexts(ParamsContext.class);
		}
		public ParamsContext params(int i) {
			return getRuleContext(ParamsContext.class,i);
		}
		public IntparamContext(ParamsContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KostLangListener ) ((KostLangListener)listener).enterIntparam(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KostLangListener ) ((KostLangListener)listener).exitIntparam(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class RealparamContext extends ParamsContext {
		public TerminalNode ID() { return getToken(KostLangParser.ID, 0); }
		public TerminalNode REALTYPE() { return getToken(KostLangParser.REALTYPE, 0); }
		public List<ParamsContext> params() {
			return getRuleContexts(ParamsContext.class);
		}
		public ParamsContext params(int i) {
			return getRuleContext(ParamsContext.class,i);
		}
		public RealparamContext(ParamsContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KostLangListener ) ((KostLangListener)listener).enterRealparam(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KostLangListener ) ((KostLangListener)listener).exitRealparam(this);
		}
	}

	public final ParamsContext params() throws RecognitionException {
		ParamsContext _localctx = new ParamsContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_params);
		try {
			int _alt;
			setState(134);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				_localctx = new IntparamContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(114);
				match(ID);
				setState(115);
				match(T__4);
				setState(116);
				match(INTTYPE);
				setState(121);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(117);
						match(T__5);
						setState(118);
						params();
						}
						} 
					}
					setState(123);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
				}
				}
				break;
			case 2:
				_localctx = new RealparamContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(124);
				match(ID);
				setState(125);
				match(T__4);
				setState(126);
				match(REALTYPE);
				setState(131);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(127);
						match(T__5);
						setState(128);
						params();
						}
						} 
					}
					setState(133);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
				}
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

	@SuppressWarnings("CheckReturnValue")
	public static class ArgsContext extends ParserRuleContext {
		public Expr2Context expr2() {
			return getRuleContext(Expr2Context.class,0);
		}
		public List<ArgsContext> args() {
			return getRuleContexts(ArgsContext.class);
		}
		public ArgsContext args(int i) {
			return getRuleContext(ArgsContext.class,i);
		}
		public ArgsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_args; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KostLangListener ) ((KostLangListener)listener).enterArgs(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KostLangListener ) ((KostLangListener)listener).exitArgs(this);
		}
	}

	public final ArgsContext args() throws RecognitionException {
		ArgsContext _localctx = new ArgsContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_args);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(136);
			expr2();
			setState(141);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(137);
					match(T__5);
					setState(138);
					args();
					}
					} 
				}
				setState(143);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
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

	@SuppressWarnings("CheckReturnValue")
	public static class FblockContext extends ParserRuleContext {
		public List<TerminalNode> NEWLINE() { return getTokens(KostLangParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(KostLangParser.NEWLINE, i);
		}
		public List<StatContext> stat() {
			return getRuleContexts(StatContext.class);
		}
		public StatContext stat(int i) {
			return getRuleContext(StatContext.class,i);
		}
		public FblockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fblock; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KostLangListener ) ((KostLangListener)listener).enterFblock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KostLangListener ) ((KostLangListener)listener).exitFblock(this);
		}
	}

	public final FblockContext fblock() throws RecognitionException {
		FblockContext _localctx = new FblockContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_fblock);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(150);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 554218582016L) != 0)) {
				{
				{
				setState(145);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 4462768128L) != 0)) {
					{
					setState(144);
					stat();
					}
				}

				setState(147);
				match(NEWLINE);
				}
				}
				setState(152);
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

	@SuppressWarnings("CheckReturnValue")
	public static class BlockifContext extends ParserRuleContext {
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public BlockifContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_blockif; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KostLangListener ) ((KostLangListener)listener).enterBlockif(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KostLangListener ) ((KostLangListener)listener).exitBlockif(this);
		}
	}

	public final BlockifContext blockif() throws RecognitionException {
		BlockifContext _localctx = new BlockifContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_blockif);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(153);
			block();
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

	@SuppressWarnings("CheckReturnValue")
	public static class BlockwhileContext extends ParserRuleContext {
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public BlockwhileContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_blockwhile; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KostLangListener ) ((KostLangListener)listener).enterBlockwhile(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KostLangListener ) ((KostLangListener)listener).exitBlockwhile(this);
		}
	}

	public final BlockwhileContext blockwhile() throws RecognitionException {
		BlockwhileContext _localctx = new BlockwhileContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_blockwhile);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(155);
			block();
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

	@SuppressWarnings("CheckReturnValue")
	public static class ConditionContext extends ParserRuleContext {
		public ConditionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_condition; }
	 
		public ConditionContext() { }
		public void copyFrom(ConditionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class EqualsContext extends ConditionContext {
		public List<Expr2Context> expr2() {
			return getRuleContexts(Expr2Context.class);
		}
		public Expr2Context expr2(int i) {
			return getRuleContext(Expr2Context.class,i);
		}
		public EqualsContext(ConditionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KostLangListener ) ((KostLangListener)listener).enterEquals(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KostLangListener ) ((KostLangListener)listener).exitEquals(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class LeContext extends ConditionContext {
		public List<Expr2Context> expr2() {
			return getRuleContexts(Expr2Context.class);
		}
		public Expr2Context expr2(int i) {
			return getRuleContext(Expr2Context.class,i);
		}
		public LeContext(ConditionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KostLangListener ) ((KostLangListener)listener).enterLe(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KostLangListener ) ((KostLangListener)listener).exitLe(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class LessContext extends ConditionContext {
		public List<Expr2Context> expr2() {
			return getRuleContexts(Expr2Context.class);
		}
		public Expr2Context expr2(int i) {
			return getRuleContext(Expr2Context.class,i);
		}
		public LessContext(ConditionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KostLangListener ) ((KostLangListener)listener).enterLess(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KostLangListener ) ((KostLangListener)listener).exitLess(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class GreatContext extends ConditionContext {
		public List<Expr2Context> expr2() {
			return getRuleContexts(Expr2Context.class);
		}
		public Expr2Context expr2(int i) {
			return getRuleContext(Expr2Context.class,i);
		}
		public GreatContext(ConditionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KostLangListener ) ((KostLangListener)listener).enterGreat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KostLangListener ) ((KostLangListener)listener).exitGreat(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class GeContext extends ConditionContext {
		public List<Expr2Context> expr2() {
			return getRuleContexts(Expr2Context.class);
		}
		public Expr2Context expr2(int i) {
			return getRuleContext(Expr2Context.class,i);
		}
		public GeContext(ConditionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KostLangListener ) ((KostLangListener)listener).enterGe(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KostLangListener ) ((KostLangListener)listener).exitGe(this);
		}
	}

	public final ConditionContext condition() throws RecognitionException {
		ConditionContext _localctx = new ConditionContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_condition);
		try {
			setState(177);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
			case 1:
				_localctx = new EqualsContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(157);
				expr2();
				setState(158);
				match(T__6);
				setState(159);
				expr2();
				}
				break;
			case 2:
				_localctx = new GeContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(161);
				expr2();
				setState(162);
				match(T__7);
				setState(163);
				expr2();
				}
				break;
			case 3:
				_localctx = new LeContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(165);
				expr2();
				setState(166);
				match(T__8);
				setState(167);
				expr2();
				}
				break;
			case 4:
				_localctx = new GreatContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(169);
				expr2();
				setState(170);
				match(T__9);
				setState(171);
				expr2();
				}
				break;
			case 5:
				_localctx = new LessContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(173);
				expr2();
				setState(174);
				match(T__10);
				setState(175);
				expr2();
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

	@SuppressWarnings("CheckReturnValue")
	public static class ConditionwhileContext extends ParserRuleContext {
		public ConditionContext condition() {
			return getRuleContext(ConditionContext.class,0);
		}
		public ConditionwhileContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_conditionwhile; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KostLangListener ) ((KostLangListener)listener).enterConditionwhile(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KostLangListener ) ((KostLangListener)listener).exitConditionwhile(this);
		}
	}

	public final ConditionwhileContext conditionwhile() throws RecognitionException {
		ConditionwhileContext _localctx = new ConditionwhileContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_conditionwhile);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(179);
			condition();
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

	@SuppressWarnings("CheckReturnValue")
	public static class ElsestatContext extends ParserRuleContext {
		public TerminalNode ELSE() { return getToken(KostLangParser.ELSE, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public ElsestatContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_elsestat; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KostLangListener ) ((KostLangListener)listener).enterElsestat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KostLangListener ) ((KostLangListener)listener).exitElsestat(this);
		}
	}

	public final ElsestatContext elsestat() throws RecognitionException {
		ElsestatContext _localctx = new ElsestatContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_elsestat);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(181);
			match(ELSE);
			setState(182);
			block();
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

	@SuppressWarnings("CheckReturnValue")
	public static class Expr0Context extends ParserRuleContext {
		public Expr0Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr0; }
	 
		public Expr0Context() { }
		public void copyFrom(Expr0Context ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class Single0Context extends Expr0Context {
		public Expr1Context expr1() {
			return getRuleContext(Expr1Context.class,0);
		}
		public Single0Context(Expr0Context ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KostLangListener ) ((KostLangListener)listener).enterSingle0(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KostLangListener ) ((KostLangListener)listener).exitSingle0(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class AddContext extends Expr0Context {
		public List<Expr1Context> expr1() {
			return getRuleContexts(Expr1Context.class);
		}
		public Expr1Context expr1(int i) {
			return getRuleContext(Expr1Context.class,i);
		}
		public TerminalNode ADD() { return getToken(KostLangParser.ADD, 0); }
		public AddContext(Expr0Context ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KostLangListener ) ((KostLangListener)listener).enterAdd(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KostLangListener ) ((KostLangListener)listener).exitAdd(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class SubContext extends Expr0Context {
		public List<Expr1Context> expr1() {
			return getRuleContexts(Expr1Context.class);
		}
		public Expr1Context expr1(int i) {
			return getRuleContext(Expr1Context.class,i);
		}
		public TerminalNode SUB() { return getToken(KostLangParser.SUB, 0); }
		public SubContext(Expr0Context ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KostLangListener ) ((KostLangListener)listener).enterSub(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KostLangListener ) ((KostLangListener)listener).exitSub(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class LogicalopContext extends Expr0Context {
		public Expr3Context expr3() {
			return getRuleContext(Expr3Context.class,0);
		}
		public LogicalopContext(Expr0Context ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KostLangListener ) ((KostLangListener)listener).enterLogicalop(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KostLangListener ) ((KostLangListener)listener).exitLogicalop(this);
		}
	}

	public final Expr0Context expr0() throws RecognitionException {
		Expr0Context _localctx = new Expr0Context(_ctx, getState());
		enterRule(_localctx, 30, RULE_expr0);
		try {
			setState(194);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
			case 1:
				_localctx = new Single0Context(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(184);
				expr1();
				}
				break;
			case 2:
				_localctx = new AddContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(185);
				expr1();
				setState(186);
				match(ADD);
				setState(187);
				expr1();
				}
				break;
			case 3:
				_localctx = new SubContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(189);
				expr1();
				setState(190);
				match(SUB);
				setState(191);
				expr1();
				}
				break;
			case 4:
				_localctx = new LogicalopContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(193);
				expr3();
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

	@SuppressWarnings("CheckReturnValue")
	public static class Expr1Context extends ParserRuleContext {
		public Expr1Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr1; }
	 
		public Expr1Context() { }
		public void copyFrom(Expr1Context ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class DivContext extends Expr1Context {
		public List<Expr2Context> expr2() {
			return getRuleContexts(Expr2Context.class);
		}
		public Expr2Context expr2(int i) {
			return getRuleContext(Expr2Context.class,i);
		}
		public TerminalNode DIV() { return getToken(KostLangParser.DIV, 0); }
		public DivContext(Expr1Context ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KostLangListener ) ((KostLangListener)listener).enterDiv(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KostLangListener ) ((KostLangListener)listener).exitDiv(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class Single1Context extends Expr1Context {
		public Expr2Context expr2() {
			return getRuleContext(Expr2Context.class,0);
		}
		public Single1Context(Expr1Context ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KostLangListener ) ((KostLangListener)listener).enterSingle1(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KostLangListener ) ((KostLangListener)listener).exitSingle1(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class MultContext extends Expr1Context {
		public List<Expr2Context> expr2() {
			return getRuleContexts(Expr2Context.class);
		}
		public Expr2Context expr2(int i) {
			return getRuleContext(Expr2Context.class,i);
		}
		public TerminalNode MULT() { return getToken(KostLangParser.MULT, 0); }
		public MultContext(Expr1Context ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KostLangListener ) ((KostLangListener)listener).enterMult(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KostLangListener ) ((KostLangListener)listener).exitMult(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class SizeContext extends Expr1Context {
		public TerminalNode SIZEOF() { return getToken(KostLangParser.SIZEOF, 0); }
		public Expr2Context expr2() {
			return getRuleContext(Expr2Context.class,0);
		}
		public SizeContext(Expr1Context ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KostLangListener ) ((KostLangListener)listener).enterSize(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KostLangListener ) ((KostLangListener)listener).exitSize(this);
		}
	}

	public final Expr1Context expr1() throws RecognitionException {
		Expr1Context _localctx = new Expr1Context(_ctx, getState());
		enterRule(_localctx, 32, RULE_expr1);
		try {
			setState(207);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
			case 1:
				_localctx = new Single1Context(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(196);
				expr2();
				}
				break;
			case 2:
				_localctx = new MultContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(197);
				expr2();
				setState(198);
				match(MULT);
				setState(199);
				expr2();
				}
				break;
			case 3:
				_localctx = new DivContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(201);
				expr2();
				setState(202);
				match(DIV);
				setState(203);
				expr2();
				}
				break;
			case 4:
				_localctx = new SizeContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(205);
				match(SIZEOF);
				setState(206);
				expr2();
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

	@SuppressWarnings("CheckReturnValue")
	public static class Expr2Context extends ParserRuleContext {
		public Expr2Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr2; }
	 
		public Expr2Context() { }
		public void copyFrom(Expr2Context ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ParContext extends Expr2Context {
		public Expr0Context expr0() {
			return getRuleContext(Expr0Context.class,0);
		}
		public ParContext(Expr2Context ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KostLangListener ) ((KostLangListener)listener).enterPar(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KostLangListener ) ((KostLangListener)listener).exitPar(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class FunoperatorContext extends Expr2Context {
		public CallContext call() {
			return getRuleContext(CallContext.class,0);
		}
		public FunoperatorContext(Expr2Context ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KostLangListener ) ((KostLangListener)listener).enterFunoperator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KostLangListener ) ((KostLangListener)listener).exitFunoperator(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class StringContext extends Expr2Context {
		public TerminalNode STRING() { return getToken(KostLangParser.STRING, 0); }
		public StringContext(Expr2Context ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KostLangListener ) ((KostLangListener)listener).enterString(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KostLangListener ) ((KostLangListener)listener).exitString(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class RealContext extends Expr2Context {
		public TerminalNode REAL() { return getToken(KostLangParser.REAL, 0); }
		public RealContext(Expr2Context ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KostLangListener ) ((KostLangListener)listener).enterReal(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KostLangListener ) ((KostLangListener)listener).exitReal(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class IdContext extends Expr2Context {
		public TerminalNode ID() { return getToken(KostLangParser.ID, 0); }
		public IdContext(Expr2Context ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KostLangListener ) ((KostLangListener)listener).enterId(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KostLangListener ) ((KostLangListener)listener).exitId(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class IntContext extends Expr2Context {
		public TerminalNode INT() { return getToken(KostLangParser.INT, 0); }
		public IntContext(Expr2Context ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KostLangListener ) ((KostLangListener)listener).enterInt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KostLangListener ) ((KostLangListener)listener).exitInt(this);
		}
	}

	public final Expr2Context expr2() throws RecognitionException {
		Expr2Context _localctx = new Expr2Context(_ctx, getState());
		enterRule(_localctx, 34, RULE_expr2);
		try {
			setState(218);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
			case 1:
				_localctx = new FunoperatorContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(209);
				call();
				}
				break;
			case 2:
				_localctx = new IntContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(210);
				match(INT);
				}
				break;
			case 3:
				_localctx = new RealContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(211);
				match(REAL);
				}
				break;
			case 4:
				_localctx = new ParContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(212);
				match(T__1);
				setState(213);
				expr0();
				setState(214);
				match(T__2);
				}
				break;
			case 5:
				_localctx = new StringContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(216);
				match(STRING);
				}
				break;
			case 6:
				_localctx = new IdContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(217);
				match(ID);
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

	@SuppressWarnings("CheckReturnValue")
	public static class Expr3Context extends ParserRuleContext {
		public Expr3Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr3; }
	 
		public Expr3Context() { }
		public void copyFrom(Expr3Context ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class OrContext extends Expr3Context {
		public List<Expr4Context> expr4() {
			return getRuleContexts(Expr4Context.class);
		}
		public Expr4Context expr4(int i) {
			return getRuleContext(Expr4Context.class,i);
		}
		public TerminalNode OR() { return getToken(KostLangParser.OR, 0); }
		public OrContext(Expr3Context ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KostLangListener ) ((KostLangListener)listener).enterOr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KostLangListener ) ((KostLangListener)listener).exitOr(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class AndContext extends Expr3Context {
		public List<Expr4Context> expr4() {
			return getRuleContexts(Expr4Context.class);
		}
		public Expr4Context expr4(int i) {
			return getRuleContext(Expr4Context.class,i);
		}
		public TerminalNode AND() { return getToken(KostLangParser.AND, 0); }
		public AndContext(Expr3Context ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KostLangListener ) ((KostLangListener)listener).enterAnd(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KostLangListener ) ((KostLangListener)listener).exitAnd(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class XorContext extends Expr3Context {
		public List<Expr4Context> expr4() {
			return getRuleContexts(Expr4Context.class);
		}
		public Expr4Context expr4(int i) {
			return getRuleContext(Expr4Context.class,i);
		}
		public TerminalNode XOR() { return getToken(KostLangParser.XOR, 0); }
		public XorContext(Expr3Context ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KostLangListener ) ((KostLangListener)listener).enterXor(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KostLangListener ) ((KostLangListener)listener).exitXor(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class LogicalelemContext extends Expr3Context {
		public Expr4Context expr4() {
			return getRuleContext(Expr4Context.class,0);
		}
		public LogicalelemContext(Expr3Context ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KostLangListener ) ((KostLangListener)listener).enterLogicalelem(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KostLangListener ) ((KostLangListener)listener).exitLogicalelem(this);
		}
	}

	public final Expr3Context expr3() throws RecognitionException {
		Expr3Context _localctx = new Expr3Context(_ctx, getState());
		enterRule(_localctx, 36, RULE_expr3);
		try {
			setState(233);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
			case 1:
				_localctx = new LogicalelemContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(220);
				expr4();
				}
				break;
			case 2:
				_localctx = new AndContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(221);
				expr4();
				setState(222);
				match(AND);
				setState(223);
				expr4();
				}
				break;
			case 3:
				_localctx = new OrContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(225);
				expr4();
				setState(226);
				match(OR);
				setState(227);
				expr4();
				}
				break;
			case 4:
				_localctx = new XorContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(229);
				expr4();
				setState(230);
				match(XOR);
				setState(231);
				expr4();
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

	@SuppressWarnings("CheckReturnValue")
	public static class Expr4Context extends ParserRuleContext {
		public Expr4Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr4; }
	 
		public Expr4Context() { }
		public void copyFrom(Expr4Context ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class NegContext extends Expr4Context {
		public TerminalNode NEG() { return getToken(KostLangParser.NEG, 0); }
		public BoolContext bool() {
			return getRuleContext(BoolContext.class,0);
		}
		public NegContext(Expr4Context ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KostLangListener ) ((KostLangListener)listener).enterNeg(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KostLangListener ) ((KostLangListener)listener).exitNeg(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class LogicalContext extends Expr4Context {
		public BoolContext bool() {
			return getRuleContext(BoolContext.class,0);
		}
		public LogicalContext(Expr4Context ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KostLangListener ) ((KostLangListener)listener).enterLogical(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KostLangListener ) ((KostLangListener)listener).exitLogical(this);
		}
	}

	public final Expr4Context expr4() throws RecognitionException {
		Expr4Context _localctx = new Expr4Context(_ctx, getState());
		enterRule(_localctx, 38, RULE_expr4);
		try {
			setState(238);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case TRUE:
			case FALSE:
				_localctx = new LogicalContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(235);
				bool();
				}
				break;
			case NEG:
				_localctx = new NegContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(236);
				match(NEG);
				setState(237);
				bool();
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

	@SuppressWarnings("CheckReturnValue")
	public static class BoolContext extends ParserRuleContext {
		public BoolContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bool; }
	 
		public BoolContext() { }
		public void copyFrom(BoolContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class TrueContext extends BoolContext {
		public TerminalNode TRUE() { return getToken(KostLangParser.TRUE, 0); }
		public TrueContext(BoolContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KostLangListener ) ((KostLangListener)listener).enterTrue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KostLangListener ) ((KostLangListener)listener).exitTrue(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class FalseContext extends BoolContext {
		public TerminalNode FALSE() { return getToken(KostLangParser.FALSE, 0); }
		public FalseContext(BoolContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KostLangListener ) ((KostLangListener)listener).enterFalse(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KostLangListener ) ((KostLangListener)listener).exitFalse(this);
		}
	}

	public final BoolContext bool() throws RecognitionException {
		BoolContext _localctx = new BoolContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_bool);
		try {
			setState(242);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case TRUE:
				_localctx = new TrueContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(240);
				match(TRUE);
				}
				break;
			case FALSE:
				_localctx = new FalseContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(241);
				match(FALSE);
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

	public static final String _serializedATN =
		"\u0004\u0001(\u00f5\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007\u0012"+
		"\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0001\u0000\u0001\u0000"+
		"\u0003\u0000-\b\u0000\u0001\u0000\u0005\u00000\b\u0000\n\u0000\f\u0000"+
		"3\t\u0000\u0001\u0001\u0003\u00016\b\u0001\u0001\u0001\u0005\u00019\b"+
		"\u0001\n\u0001\f\u0001<\t\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0003\u0002L\b"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0003\u0002W\b\u0002\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0003\u0003\\\b\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0003\u0004c\b\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0003\u0005n\b\u0005\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0005\u0007x\b\u0007\n\u0007\f\u0007{\t\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0005\u0007\u0082\b\u0007\n"+
		"\u0007\f\u0007\u0085\t\u0007\u0003\u0007\u0087\b\u0007\u0001\b\u0001\b"+
		"\u0001\b\u0005\b\u008c\b\b\n\b\f\b\u008f\t\b\u0001\t\u0003\t\u0092\b\t"+
		"\u0001\t\u0005\t\u0095\b\t\n\t\f\t\u0098\t\t\u0001\n\u0001\n\u0001\u000b"+
		"\u0001\u000b\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001"+
		"\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001"+
		"\f\u0001\f\u0001\f\u0001\f\u0003\f\u00b2\b\f\u0001\r\u0001\r\u0001\u000e"+
		"\u0001\u000e\u0001\u000e\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f"+
		"\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f"+
		"\u0003\u000f\u00c3\b\u000f\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010"+
		"\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010"+
		"\u0001\u0010\u0003\u0010\u00d0\b\u0010\u0001\u0011\u0001\u0011\u0001\u0011"+
		"\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011"+
		"\u0003\u0011\u00db\b\u0011\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012"+
		"\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012"+
		"\u0001\u0012\u0001\u0012\u0001\u0012\u0003\u0012\u00ea\b\u0012\u0001\u0013"+
		"\u0001\u0013\u0001\u0013\u0003\u0013\u00ef\b\u0013\u0001\u0014\u0001\u0014"+
		"\u0003\u0014\u00f3\b\u0014\u0001\u0014\u0000\u0000\u0015\u0000\u0002\u0004"+
		"\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018\u001a\u001c\u001e \""+
		"$&(\u0000\u0000\u0108\u00001\u0001\u0000\u0000\u0000\u0002:\u0001\u0000"+
		"\u0000\u0000\u0004V\u0001\u0000\u0000\u0000\u0006X\u0001\u0000\u0000\u0000"+
		"\b_\u0001\u0000\u0000\u0000\nm\u0001\u0000\u0000\u0000\fo\u0001\u0000"+
		"\u0000\u0000\u000e\u0086\u0001\u0000\u0000\u0000\u0010\u0088\u0001\u0000"+
		"\u0000\u0000\u0012\u0096\u0001\u0000\u0000\u0000\u0014\u0099\u0001\u0000"+
		"\u0000\u0000\u0016\u009b\u0001\u0000\u0000\u0000\u0018\u00b1\u0001\u0000"+
		"\u0000\u0000\u001a\u00b3\u0001\u0000\u0000\u0000\u001c\u00b5\u0001\u0000"+
		"\u0000\u0000\u001e\u00c2\u0001\u0000\u0000\u0000 \u00cf\u0001\u0000\u0000"+
		"\u0000\"\u00da\u0001\u0000\u0000\u0000$\u00e9\u0001\u0000\u0000\u0000"+
		"&\u00ee\u0001\u0000\u0000\u0000(\u00f2\u0001\u0000\u0000\u0000*-\u0003"+
		"\u0004\u0002\u0000+-\u0003\b\u0004\u0000,*\u0001\u0000\u0000\u0000,+\u0001"+
		"\u0000\u0000\u0000,-\u0001\u0000\u0000\u0000-.\u0001\u0000\u0000\u0000"+
		".0\u0005\'\u0000\u0000/,\u0001\u0000\u0000\u000003\u0001\u0000\u0000\u0000"+
		"1/\u0001\u0000\u0000\u000012\u0001\u0000\u0000\u00002\u0001\u0001\u0000"+
		"\u0000\u000031\u0001\u0000\u0000\u000046\u0003\u0004\u0002\u000054\u0001"+
		"\u0000\u0000\u000056\u0001\u0000\u0000\u000067\u0001\u0000\u0000\u0000"+
		"79\u0005\'\u0000\u000085\u0001\u0000\u0000\u00009<\u0001\u0000\u0000\u0000"+
		":8\u0001\u0000\u0000\u0000:;\u0001\u0000\u0000\u0000;\u0003\u0001\u0000"+
		"\u0000\u0000<:\u0001\u0000\u0000\u0000=>\u0005 \u0000\u0000>?\u0005\u0001"+
		"\u0000\u0000?W\u0003\u001e\u000f\u0000@A\u0005\f\u0000\u0000AW\u0005 "+
		"\u0000\u0000BC\u0005\u000e\u0000\u0000CW\u0005 \u0000\u0000DE\u0005\r"+
		"\u0000\u0000EW\u0005 \u0000\u0000FG\u0005\u0019\u0000\u0000GH\u0003\u0018"+
		"\f\u0000HI\u0005\u001c\u0000\u0000IK\u0003\u0014\n\u0000JL\u0003\u001c"+
		"\u000e\u0000KJ\u0001\u0000\u0000\u0000KL\u0001\u0000\u0000\u0000LM\u0001"+
		"\u0000\u0000\u0000MN\u0005\u0016\u0000\u0000NW\u0001\u0000\u0000\u0000"+
		"OP\u0005\u001b\u0000\u0000PQ\u0003\u001a\r\u0000QR\u0005\u001c\u0000\u0000"+
		"RS\u0003\u0016\u000b\u0000ST\u0005\u0017\u0000\u0000TW\u0001\u0000\u0000"+
		"\u0000UW\u0003\u0006\u0003\u0000V=\u0001\u0000\u0000\u0000V@\u0001\u0000"+
		"\u0000\u0000VB\u0001\u0000\u0000\u0000VD\u0001\u0000\u0000\u0000VF\u0001"+
		"\u0000\u0000\u0000VO\u0001\u0000\u0000\u0000VU\u0001\u0000\u0000\u0000"+
		"W\u0005\u0001\u0000\u0000\u0000XY\u0005 \u0000\u0000Y[\u0005\u0002\u0000"+
		"\u0000Z\\\u0003\u0010\b\u0000[Z\u0001\u0000\u0000\u0000[\\\u0001\u0000"+
		"\u0000\u0000\\]\u0001\u0000\u0000\u0000]^\u0005\u0003\u0000\u0000^\u0007"+
		"\u0001\u0000\u0000\u0000_`\u0003\n\u0005\u0000`b\u0005\u0002\u0000\u0000"+
		"ac\u0003\u000e\u0007\u0000ba\u0001\u0000\u0000\u0000bc\u0001\u0000\u0000"+
		"\u0000cd\u0001\u0000\u0000\u0000de\u0005\u0003\u0000\u0000ef\u0003\u0012"+
		"\t\u0000fg\u0003\f\u0006\u0000gh\u0005\u0018\u0000\u0000h\t\u0001\u0000"+
		"\u0000\u0000ij\u0005\u001d\u0000\u0000jn\u0005 \u0000\u0000kl\u0005\u001e"+
		"\u0000\u0000ln\u0005 \u0000\u0000mi\u0001\u0000\u0000\u0000mk\u0001\u0000"+
		"\u0000\u0000n\u000b\u0001\u0000\u0000\u0000op\u0005\u0004\u0000\u0000"+
		"pq\u0003\"\u0011\u0000q\r\u0001\u0000\u0000\u0000rs\u0005 \u0000\u0000"+
		"st\u0005\u0005\u0000\u0000ty\u0005\u001d\u0000\u0000uv\u0005\u0006\u0000"+
		"\u0000vx\u0003\u000e\u0007\u0000wu\u0001\u0000\u0000\u0000x{\u0001\u0000"+
		"\u0000\u0000yw\u0001\u0000\u0000\u0000yz\u0001\u0000\u0000\u0000z\u0087"+
		"\u0001\u0000\u0000\u0000{y\u0001\u0000\u0000\u0000|}\u0005 \u0000\u0000"+
		"}~\u0005\u0005\u0000\u0000~\u0083\u0005\u001e\u0000\u0000\u007f\u0080"+
		"\u0005\u0006\u0000\u0000\u0080\u0082\u0003\u000e\u0007\u0000\u0081\u007f"+
		"\u0001\u0000\u0000\u0000\u0082\u0085\u0001\u0000\u0000\u0000\u0083\u0081"+
		"\u0001\u0000\u0000\u0000\u0083\u0084\u0001\u0000\u0000\u0000\u0084\u0087"+
		"\u0001\u0000\u0000\u0000\u0085\u0083\u0001\u0000\u0000\u0000\u0086r\u0001"+
		"\u0000\u0000\u0000\u0086|\u0001\u0000\u0000\u0000\u0087\u000f\u0001\u0000"+
		"\u0000\u0000\u0088\u008d\u0003\"\u0011\u0000\u0089\u008a\u0005\u0006\u0000"+
		"\u0000\u008a\u008c\u0003\u0010\b\u0000\u008b\u0089\u0001\u0000\u0000\u0000"+
		"\u008c\u008f\u0001\u0000\u0000\u0000\u008d\u008b\u0001\u0000\u0000\u0000"+
		"\u008d\u008e\u0001\u0000\u0000\u0000\u008e\u0011\u0001\u0000\u0000\u0000"+
		"\u008f\u008d\u0001\u0000\u0000\u0000\u0090\u0092\u0003\u0004\u0002\u0000"+
		"\u0091\u0090\u0001\u0000\u0000\u0000\u0091\u0092\u0001\u0000\u0000\u0000"+
		"\u0092\u0093\u0001\u0000\u0000\u0000\u0093\u0095\u0005\'\u0000\u0000\u0094"+
		"\u0091\u0001\u0000\u0000\u0000\u0095\u0098\u0001\u0000\u0000\u0000\u0096"+
		"\u0094\u0001\u0000\u0000\u0000\u0096\u0097\u0001\u0000\u0000\u0000\u0097"+
		"\u0013\u0001\u0000\u0000\u0000\u0098\u0096\u0001\u0000\u0000\u0000\u0099"+
		"\u009a\u0003\u0002\u0001\u0000\u009a\u0015\u0001\u0000\u0000\u0000\u009b"+
		"\u009c\u0003\u0002\u0001\u0000\u009c\u0017\u0001\u0000\u0000\u0000\u009d"+
		"\u009e\u0003\"\u0011\u0000\u009e\u009f\u0005\u0007\u0000\u0000\u009f\u00a0"+
		"\u0003\"\u0011\u0000\u00a0\u00b2\u0001\u0000\u0000\u0000\u00a1\u00a2\u0003"+
		"\"\u0011\u0000\u00a2\u00a3\u0005\b\u0000\u0000\u00a3\u00a4\u0003\"\u0011"+
		"\u0000\u00a4\u00b2\u0001\u0000\u0000\u0000\u00a5\u00a6\u0003\"\u0011\u0000"+
		"\u00a6\u00a7\u0005\t\u0000\u0000\u00a7\u00a8\u0003\"\u0011\u0000\u00a8"+
		"\u00b2\u0001\u0000\u0000\u0000\u00a9\u00aa\u0003\"\u0011\u0000\u00aa\u00ab"+
		"\u0005\n\u0000\u0000\u00ab\u00ac\u0003\"\u0011\u0000\u00ac\u00b2\u0001"+
		"\u0000\u0000\u0000\u00ad\u00ae\u0003\"\u0011\u0000\u00ae\u00af\u0005\u000b"+
		"\u0000\u0000\u00af\u00b0\u0003\"\u0011\u0000\u00b0\u00b2\u0001\u0000\u0000"+
		"\u0000\u00b1\u009d\u0001\u0000\u0000\u0000\u00b1\u00a1\u0001\u0000\u0000"+
		"\u0000\u00b1\u00a5\u0001\u0000\u0000\u0000\u00b1\u00a9\u0001\u0000\u0000"+
		"\u0000\u00b1\u00ad\u0001\u0000\u0000\u0000\u00b2\u0019\u0001\u0000\u0000"+
		"\u0000\u00b3\u00b4\u0003\u0018\f\u0000\u00b4\u001b\u0001\u0000\u0000\u0000"+
		"\u00b5\u00b6\u0005\u001a\u0000\u0000\u00b6\u00b7\u0003\u0002\u0001\u0000"+
		"\u00b7\u001d\u0001\u0000\u0000\u0000\u00b8\u00c3\u0003 \u0010\u0000\u00b9"+
		"\u00ba\u0003 \u0010\u0000\u00ba\u00bb\u0005#\u0000\u0000\u00bb\u00bc\u0003"+
		" \u0010\u0000\u00bc\u00c3\u0001\u0000\u0000\u0000\u00bd\u00be\u0003 \u0010"+
		"\u0000\u00be\u00bf\u0005$\u0000\u0000\u00bf\u00c0\u0003 \u0010\u0000\u00c0"+
		"\u00c3\u0001\u0000\u0000\u0000\u00c1\u00c3\u0003$\u0012\u0000\u00c2\u00b8"+
		"\u0001\u0000\u0000\u0000\u00c2\u00b9\u0001\u0000\u0000\u0000\u00c2\u00bd"+
		"\u0001\u0000\u0000\u0000\u00c2\u00c1\u0001\u0000\u0000\u0000\u00c3\u001f"+
		"\u0001\u0000\u0000\u0000\u00c4\u00d0\u0003\"\u0011\u0000\u00c5\u00c6\u0003"+
		"\"\u0011\u0000\u00c6\u00c7\u0005%\u0000\u0000\u00c7\u00c8\u0003\"\u0011"+
		"\u0000\u00c8\u00d0\u0001\u0000\u0000\u0000\u00c9\u00ca\u0003\"\u0011\u0000"+
		"\u00ca\u00cb\u0005&\u0000\u0000\u00cb\u00cc\u0003\"\u0011\u0000\u00cc"+
		"\u00d0\u0001\u0000\u0000\u0000\u00cd\u00ce\u0005\u0015\u0000\u0000\u00ce"+
		"\u00d0\u0003\"\u0011\u0000\u00cf\u00c4\u0001\u0000\u0000\u0000\u00cf\u00c5"+
		"\u0001\u0000\u0000\u0000\u00cf\u00c9\u0001\u0000\u0000\u0000\u00cf\u00cd"+
		"\u0001\u0000\u0000\u0000\u00d0!\u0001\u0000\u0000\u0000\u00d1\u00db\u0003"+
		"\u0006\u0003\u0000\u00d2\u00db\u0005\"\u0000\u0000\u00d3\u00db\u0005!"+
		"\u0000\u0000\u00d4\u00d5\u0005\u0002\u0000\u0000\u00d5\u00d6\u0003\u001e"+
		"\u000f\u0000\u00d6\u00d7\u0005\u0003\u0000\u0000\u00d7\u00db\u0001\u0000"+
		"\u0000\u0000\u00d8\u00db\u0005\u001f\u0000\u0000\u00d9\u00db\u0005 \u0000"+
		"\u0000\u00da\u00d1\u0001\u0000\u0000\u0000\u00da\u00d2\u0001\u0000\u0000"+
		"\u0000\u00da\u00d3\u0001\u0000\u0000\u0000\u00da\u00d4\u0001\u0000\u0000"+
		"\u0000\u00da\u00d8\u0001\u0000\u0000\u0000\u00da\u00d9\u0001\u0000\u0000"+
		"\u0000\u00db#\u0001\u0000\u0000\u0000\u00dc\u00ea\u0003&\u0013\u0000\u00dd"+
		"\u00de\u0003&\u0013\u0000\u00de\u00df\u0005\u0011\u0000\u0000\u00df\u00e0"+
		"\u0003&\u0013\u0000\u00e0\u00ea\u0001\u0000\u0000\u0000\u00e1\u00e2\u0003"+
		"&\u0013\u0000\u00e2\u00e3\u0005\u0012\u0000\u0000\u00e3\u00e4\u0003&\u0013"+
		"\u0000\u00e4\u00ea\u0001\u0000\u0000\u0000\u00e5\u00e6\u0003&\u0013\u0000"+
		"\u00e6\u00e7\u0005\u0013\u0000\u0000\u00e7\u00e8\u0003&\u0013\u0000\u00e8"+
		"\u00ea\u0001\u0000\u0000\u0000\u00e9\u00dc\u0001\u0000\u0000\u0000\u00e9"+
		"\u00dd\u0001\u0000\u0000\u0000\u00e9\u00e1\u0001\u0000\u0000\u0000\u00e9"+
		"\u00e5\u0001\u0000\u0000\u0000\u00ea%\u0001\u0000\u0000\u0000\u00eb\u00ef"+
		"\u0003(\u0014\u0000\u00ec\u00ed\u0005\u0014\u0000\u0000\u00ed\u00ef\u0003"+
		"(\u0014\u0000\u00ee\u00eb\u0001\u0000\u0000\u0000\u00ee\u00ec\u0001\u0000"+
		"\u0000\u0000\u00ef\'\u0001\u0000\u0000\u0000\u00f0\u00f3\u0005\u000f\u0000"+
		"\u0000\u00f1\u00f3\u0005\u0010\u0000\u0000\u00f2\u00f0\u0001\u0000\u0000"+
		"\u0000\u00f2\u00f1\u0001\u0000\u0000\u0000\u00f3)\u0001\u0000\u0000\u0000"+
		"\u0016,15:KV[bmy\u0083\u0086\u008d\u0091\u0096\u00b1\u00c2\u00cf\u00da"+
		"\u00e9\u00ee\u00f2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}