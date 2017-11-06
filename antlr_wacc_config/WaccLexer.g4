lexer grammar WaccLexer;

//Fragments used for Readability

fragment INT_STRING : 'int' ;
fragment BOOL_STRING : 'bool' ;
fragment CHAR_STRING : 'char' ;
fragment STRING_STRING : 'string' ;

fragment HASH        : '#';
fragment UNDERSCORE  : '_';
fragment ESCAPEDCHAR : '0' | 'b' | 't' | 'n' | 'f' | 'r' | '"' | '\'' | '\\';

fragment DIGIT     : '0'..'9';
fragment LOWERCHAR : 'a'..'z';
fragment UPPERCHAR : 'A'..'Z';
fragment CHARACTER : ~('\\' | '\'' | '"' ) | '\\' ESCAPEDCHAR ;
fragment NULL      : 'null';
fragment TRUE      : 'true';
fragment FALSE     : 'false';


//Reserved Keywords

BEGIN : 'begin' ;
END : 'end' ;
IS : 'is' ;
IF : 'if' ;
THEN : 'then' ;
ELSE : 'else' ;
FI : 'fi' ;
READ : 'read' ;
FREE : 'free' ;
RETURN : 'return' ;
EXIT : 'exit' ;
PRINT : 'print' ;
PRINTLN : 'println' ;
SKIPTOK : 'skip' ;
NEWPAIR : 'newpair' ;
CALL : 'call' ;
FST : 'fst' ;
SND : 'snd' ;
PAIR_STRING : 'pair' ;
WHILE : 'while' ;
DO : 'do' ;
DONE : 'done' ;
SEMI_COLON : ';' ;
MINUS: '-' ;
PLUS: '+' ;

//Unary Operators
CHR: 'chr' ;
ORD: 'ord' ;
LEN: 'len' ;
EXCL: '!' ;

//Binary Operators
MULT: '*' ;
DIV: '/' ;
MOD: '%' ;
GRTHAN: '>' ;
GREQTO: '>=' ;
LSTHAN: '<' ;
LSEQTO: '<=' ;
EQTO: '==' ;
NEQTO: '!=' ;
AND: '&&' ;
OR: '||' ;

//Seperators
COMMA : ',' ;
EQUAL : '=' ;
SQUARE_OPEN : '[' ;
SQUARE_CLOSED : ']' ;
OPEN_PAREN : '(' ;
CLOSE_PAREN : ')' ;


//Literals
BOOL_LITER :  TRUE | FALSE  ;
CHAR_LITER : '\'' CHARACTER '\''  ;
STR_LITER : '"' CHARACTER* '"'  ;
INT_LITER:  DIGIT+;
PAIR_LITER : 'null' ;

BASE_TYPE : INT_STRING
     | BOOL_STRING
     | CHAR_STRING
     | STRING_STRING
     ;

IDENT: (UNDERSCORE | LOWERCHAR | UPPERCHAR ) (UNDERSCORE | LOWERCHAR | UPPERCHAR | DIGIT )*;

//Skip

COMMENT : '#' ~[\r\n]* -> skip;
WHITESPACE : [ \t\n]+ -> skip;

