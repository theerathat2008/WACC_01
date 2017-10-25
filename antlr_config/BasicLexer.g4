lexer grammar BasicLexer;

//binary_operators
PLUS: '+' ;
MINUS: '-' ;

//brackets
OPEN_PARENTHESES : '(' ;
CLOSE_PARENTHESES : ')' ;

//program
PROGRAM: 'begin' FUNC* STAT 'end' ;

//func
FUNC: TYPE IDENT '(' PARAM_LIST ')' 'is' STAT 'end' ;

//param-list
PARAM_LIST: PARAM (',' PARAM)* ;

//param
PARAM: TYPE IDENT ;

//stat
STAT: 'skip' | TYPE IDENT '=' ASSIGN_RHS | ASSIGN_LHS '=' ASSIGN_RHS | 'read' ASSIGN_LHS | 'free' EXPR | 'return' EXPR | 'exit' EXPR | 'print' EXPR | 'println' EXPR | 'if' EXPR 'then' STAT 'else' STAT 'fi' | 'while' EXPR 'do' STAT 'done' | 'begin' STAT 'end' | STAT2 ';' STAT ;
STAT2: 'skip' | TYPE IDENT '=' ASSIGN_RHS | ASSIGN_LHS '=' ASSIGN_RHS | 'read' ASSIGN_LHS | 'free' EXPR | 'return' EXPR | 'exit' EXPR | 'print' EXPR | 'println' EXPR | 'if' EXPR 'then' STAT 'else' STAT 'fi' | 'while' EXPR 'do' STAT 'done' | 'begin' STAT 'end';

//assign-lhs
ASSIGN_LHS: IDENT | ARRAY_ELEM | PAIR_ELEM ;

//assign-rhs
ASSIGN_RHS: EXPR | ARRAY_LITER | 'newpair' '(' EXPR ',' EXPR ')' ;

//arg-list
ARG_LIST: EXPR (',' EXPR)* ;

//pair-elem
PAIR_ELEM: 'fst' EXPR | 'snd' EXPR ;

//type
TYPE: BASE_TYPE | ARRAY_TYPE | PAIR_TYPE ;
TYPE2: BASE_TYPE | PAIR_TYPE ;

//base-type
BASE_TYPE: 'int' | 'bool' | 'char' | 'string' ;

//array-type
ARRAY_TYPE: TYPE2 '[' ']' ;

//pair-type
PAIR_TYPE: 'pair' '(' PAIR_ELEM_TYPE ',' PAIR_ELEM_TYPE ')' ;

//pair-elem-type
PAIR_ELEM_TYPE: BASE_TYPE | ARRAY_TYPE | 'pair' ;

//expr
EXPR: INT_LITER | BOOL_LITER | CHAR_LITER | STR_LITER | PAIR_LITER | IDENT | ARRAY_ELEM | UNARY_OPER EXPR | EXPR2 '+' EXPR | '(' EXPR ')' ;
EXPR2: INT_LITER | BOOL_LITER | CHAR_LITER | STR_LITER | PAIR_LITER | IDENT | ARRAY_ELEM | UNARY_OPER EXPR | '(' EXPR ')' ;

//unary_oper
UNARY_OPER: '!'|'-'|'len'|'ord'|'chr' ;

//binary_oper
BINARY_OPER: '+'|'-'|'*'|'/'|'%'|'>'|'>='|'<'|'<='|'=='|'!='|'&&'|'||' ;

//ident
IDENT: ('_'|'a'..'z'|'A'..'Z') ('_'|'a'..'z'|'A'..'Z'|'0'..'9')* ;

//array-elemTODOOOOOOOOOOOOOOOOOOOOOOOOO
ARRAY_ELEM: IDENT ('[' ']')+ ;

//numbers
fragment DIGIT : '0'..'9' ;
INTEGER: DIGIT+ ;
INT_LITER: INT_SIGN? INTEGER ;

//int-sign
INT_SIGN: '+'|'-' ;

//bool-liter
BOOL_LITER: 'true'|'false' ;

//char-liter
CHAR_LITER: '\'' CHARACTER '\''  ;

//str-liter
STR_LITER: '"' CHARACTER* '"'  ;

//character
CHARACTER: ~('\\' | '\'' | '"')|('\\' ESCAPED_CHAR) ;

//escaped-char
ESCAPED_CHAR: '0'|'b'|'t'|'n'|'f'|'r' |'"'|'\''|'\\';

//array-literTODOOOOOOOOOOOOOOOOOOOO
ARRAY_LITER: '[' ',' ']' ;

//pair-liter
PAIR_LITER: 'null' ;

//comment
COMMENT: '#' ~('\n') EOL ;

//eol
EOL: '\\n' -> skip;
