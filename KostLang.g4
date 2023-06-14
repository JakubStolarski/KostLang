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
    	| call		#funcall
;

call: ID '(' args? ')'	
;

function: declare '(' params? ')' fblock return ENDF
;

declare: INTTYPE ID	#inttype
	| REALTYPE ID #realtype
;

return: 'return' expr2
;

params: ID ':' INTTYPE (',' params)*	#intparam
	| ID ':' REALTYPE (',' params)* #realparam
;

args: expr2 (',' args)*
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

expr2: call #funoperator   
      | INT			#int
      | REAL			#real
      | '(' expr0 ')'		#par
      | STRING          #string
      | ID          #id  
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

INTTYPE: 'int'
;

REALTYPE: 'real'
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
