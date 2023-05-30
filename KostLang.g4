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
      | bool            #logical
      | bool AND bool   #and
      | bool OR bool    #or
      | bool XOR bool   #xor 
      | NEG bool        #neg
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