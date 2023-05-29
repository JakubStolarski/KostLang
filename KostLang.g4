grammar KostLang;

prog: (stat? NEWLINE )*
;

stat:	 ID '=' expr0		#assign
	| PRINT ID   		#print
	| READ ID   		#read
    	| WRITE ID          	#write
    	| ID '=' '[' intarr ']'		#intarray
    	| ID '=' '[' realarr ']'	#realarray
    	| PUSH '(' ID ',' expr0 ')' 	#push
    	| POP '(' ID ')' 		#pop
;

expr0:  expr1			#single0
      | expr1 ADD expr1	#add 
      | expr1 SUB expr1 #sub
;

expr1:  expr2			#single1
      | expr2 MULT expr2	#mult
      | expr2 DIV expr2     #div 
;

expr2: ID          		#id     
      | INT			#int
      | REAL			#real
      | '(' expr0 ')'		#par
      | STRING          	#string
      | TRUE            	#true
      | FALSE           	#false
      | GET '(' ID ',' INT ')'	#get
      | LENGTH '(' ID ')'	#length
      | POP '(' ID ')' 		#popreturn
;

intarr: INT
	| INT ',' intarr
;

realarr: REAL
	| REAL ',' realarr
;

GET:  'get'
    ;
    
LENGTH:  'length'
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

ADD: '+'
    ;

SUB: '-'
    ;

MULT: '*'
    ;

DIV: '/'
    ;

PUSH: 'push!'
    ;
    
POP:  'pop!'
    ;

NEWLINE:	'\r'? '\n'
    ;

WS:   (' '|'\t') -> skip
    ;
