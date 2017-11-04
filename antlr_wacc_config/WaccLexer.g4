lexer grammar WaccLexer;

//Fragments used for Readability

fragment INT_STRING : 'int' ;
fragment BOOL_STRING : 'bool' ;
fragment CHAR_STRING : 'char' ;
fragment STRING_STRING : 'string' ;

fragment HASH        : '#';
fragment UNDERSCORE  : '_';
fragment ESCAPEDCHAR : [0btnfr"\'\\];

fragment DIGIT     : '0'..'9';
fragment LOWERCHAR : 'a'..'z';
fragment UPPERCHAR : 'A'..'Z';
fragment CHARACTER : ~[\'"] | [\\] ESCAPEDCHAR;
fragment NULL      : 'null';
fragment INTSIGN   : '+' | '-'  ;
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
SKIP : 'skip' ;
NEWPAIR : 'newpair' ;
CALL : 'call' ;
FST : 'fst' ;
SND : 'snd' ;
PAIR_STRING : 'pair' ;
WHILE : 'while' ;
DO : 'do' ;
DONE : 'done' ;
SEMI_COLON : ';' ;

//Seperators

COMMA : ',' ;
EQUAL : '=' ;
SQUARE_OPEN : '[' ;
SQUARE_CLOSED : ']' ;
OPEN_PAREN : '(' ;
CLOSE_PAREN : ')' ;

//Operators

UNARY_OPER : '!' | '-' | 'len' | 'ord' | 'chr'  ;
BINARY_OPER : '*' | '/' | '%' | '+' | '-' | '>' | '>=' | '<' | '<=' | '==' | '!=' | '&&' | '||'  ;

//Literals

BOOL_LITER :  TRUE | FALSE  ;
CHAR_LITER : '\'' CHARACTER '\''  ;
STR_LITER : '"' CHARACTER* '"'  ;
INT_LITER: INTSIGN? DIGIT+;
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
