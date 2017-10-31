lexer grammar WaccLexer;

COMMENT : '#' ~[\r\n]* '\r'? '\n' -> skip;

WHITESPACE : [ \t\n]+ -> channel(HIDDEN);

NEWLINE : ('\r'? '\n' | '\r')+  -> skip ;

EOL : '\\n' -> skip ;

BEGIN : 'begin' ;
END : 'end' ;
IS : 'is' ;

COMMA : ',' ;
SKIP : 'skip' ;
EQUAL : '=' ;
READ : 'read' ;
FREE : 'free' ;
RETURN : 'return' ;
EXIT : 'exit' ;
PRINT : 'print' ;
PRINTLN : 'println' ;

IF : 'if' ;
THEN : 'then' ;
ELSE : 'else' ;
FI : 'fi' ;

WHILE : 'while' ;
DO : 'do' ;
DONE : 'done' ;
SEMI_COLON : ';' ;

NEWPAIR : 'newpair' ;
CALL : 'call' ;
FST : 'fst' ;
SND : 'snd' ;

INT_STRING : 'int' ;
BOOL_STRING : 'bool' ;
CHAR_STRING : 'char' ;
STRING_STRING : 'string' ;

SQUARE_OPEN : '[' ;
SQUARE_CLOSED : ']' ;
PAIR_STRING : 'pair' ;
OPEN_PAREN : '(' ;
CLOSE_PAREN : ')' ;

UNARY_OPER : '!' | '-' | 'len' | 'ord' | 'chr'  ;
BINARY_OPER : '*' | '/' | '%' | '+' | '-' | '>' | '>=' | '<' | '<=' | '==' | '!=' | '&&' | '||'  ;

INT_SIGN : '+' | '-'  ;

BOOL_LITER :  'true' | 'false'  ;
CHAR_LITER : '\'' CHARACTER '\''  ;
STR_LITER : '"' CHARACTER* '"'  ;

CHARACTER : ~('\\' | '\'' | '"')|('\\' ESCAPED_CHAR) ;

ESCAPED_CHAR : '0'|'b'|'t'|'n'|'f'|'r' |'"'|'\''|'\\' ;

PAIR_LITER : 'null' ;

IDENT: ('_'|'a'..'z'|'A'..'Z') ('_'|'a'..'z'|'A'..'Z'|'0'..'9')* ;

fragment DIGIT : '0'..'9' ;
INTEGER: DIGIT+ ;
INT_LITER: INT_SIGN? INTEGER ;
