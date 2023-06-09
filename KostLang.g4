grammar KostLang;

prog: ((stat|function)? NEWLINE )*
;

block: (stat? NEWLINE)*
;

stat:	 ID '=' expr0		#assign
	| PRINT ID   		#print
	| READ ID   		#read
    	| WRITE ID          #write
    	| IF condition DO blockif elsestat? ENDIF #if
    	| WHILE conditionwhile DO blockwhile ENDWHILE #while
;

function: FUNCTION ID '(' params? ')' fblock ENDF
;

params: ID '<=' type (',' ID '<=' type)*
;

type: 'int'	#inttype
	|'float'	#floattype
	|'string'	#stringtype
;

fblock: (stat? NEWLINE )*
;

blockif: block
;

blockwhile: block
;

condition: expr2 '==' expr2	#equals
	| expr2 '>=' expr2	#ge
	| expr2 '<=' expr2	#le
	| expr2 '>' expr2	#great
	| expr2 '<' expr2	#less
;

conditionwhile: condition
;

elsestat: ELSE block
;

expr0:  expr1			#single0
      | expr1 ADD expr1	#add 
      | expr1 SUB expr1 #sub
      | expr3           #logicalop
;

expr1:  expr2			#single1
      | expr2 MULT expr2	#mult
      | expr2 DIV expr2     #div
      | SIZEOF expr2        #size 
;

expr2: ID          #id     
      | INT			#int
      | REAL			#real
      | '(' expr0 ')'		#par
      | STRING          #string
;

expr3: expr4        #logicalelem
      | expr4 AND expr4   #and
      | expr4 OR expr4    #or
      | expr4 XOR expr4   #xor 
;

expr4: bool     #logical
      | NEG bool        #neg
;

bool: TRUE      #true
    |FALSE      #false
;

PRINT:	'print' 
    ;

WRITE:	'write' 
   ;

READ:	'read' 
   ;

TRUE: 'true'
;

FALSE: 'false'
;

AND: 'and'
;

OR: 'or'
;

XOR: 'xor'
;

NEG: '!'
;

SIZEOF: 'sizeof'
;

FUNCTION: 'function'
;

ENDIF: 'endif'
;

ENDWHILE: 'endwhile'
;

ENDF: 'endf'
;

IF: 'if'
;

ELSE: 'else'
;

WHILE: 'while'
;

DO: 'do'
;

STRING :  '"' ( ~('\\'|'"') )* '"'
    ;

ID:   ('a'..'z'|'A'..'Z')+
   ;

REAL: '0'..'9'+'.''0'..'9'+
    ;

INT: '0'..'9'+
    ;

ADD: '+'
    ;

SUB: '-'
    ;

MULT: '*'
    ;

DIV: '/'
    ;

NEWLINE:	'\r'? '\n'
    ;

WS:   (' '|'\t') -> skip
;
