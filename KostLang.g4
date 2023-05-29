grammar KostLang;

prog: (stat? NEWLINE )*
;

stat:	 ID '=' expr0		#assign
	| PRINT ID   		#print
	| READ ID   		#read
    | WRITE ID          #write
;

expr0:  expr1			#single0
      | expr1 ADD expr1	#add 
      | expr1 SUB expr1 #sub
;

expr1:  expr2			#single1
      | expr2 MULT expr2	#mult
      | expr2 DIV expr2     #div 
;

expr2: ID          #id     
      | INT			#int
      | REAL			#real
      | '(' expr0 ')'		#par
      | TOINT expr2		    #toint
      | TOREAL expr2		#toreal
      | STRING          #string
      | TRUE            #true
      | FALSE           #false
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

STRING :  '"' ( ~('\\'|'"') )* '"'
    ;

ID:   ('a'..'z'|'A'..'Z')+
   ;

REAL: '0'..'9'+'.''0'..'9'+
    ;

INT: '0'..'9'+
    ;

TOINT: '(int)'
    ;

TOREAL: '(real)'
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

WS:   (' '|'\t')+ { skip(); }
    ;