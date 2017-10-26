
grammar Wacc;
import WaccTokens;

//Parser Rules

program : 'begin' func* stat 'end' ;

func : type ident '(' param-list? ')' 'is' stat 'end'  ;

param-list : param ( ',' param )*  ;

param : type ident  ;

stat : 'skip'
     | type ident '=' assign-rhs
     | assign-lhs '=' assign-rhs
     | 'read' assign-lhs
     | 'free' expr
     | 'free' expr
     | 'return' expr
     | 'exit' expr
     | 'print' expr
     | 'println' expr
     | 'if' expr 'then' stat 'else' stat 'fi'
     | 'while' expr 'do' stat 'done'
     | 'begin' stat 'end'
     | stat ';' stat
     ;

assign-lhs : ident
     | array-elem
     | pair-elem
     ;

assign-rhs : expr
     | array-liter
     | 'newpair' '(' expr ',' expr ')'
     | pair-elem
     | 'call' ident '(' arg-list? ')'
     ;

arg-list : expr (',' expr )*  ;

pair-elem : 'fst' expr
     | 'snd' expr
     ;

type : base-type
     | array-type
     | pair-type
     ;

base-type : 'int'
     | 'bool'
     | 'char'
     | 'string'
     ;

array-type : type '['']'  ;

pair-type : 'pair' '(' pair-elem-type ',' pair-elem-type ')'

pair-type-elem : base-type
     | array-type
     | 'pair'
     ;

expr : INT-LITER
     | BOOL-LITER
     | CHAR-LITER
     | STR-LITER
     | PAIR-LITER
     | IDENT
     | ARRAY-ELEM
     | UNARY-OPER expr
     | expr BINARY-OPER expr
     | '(' expr ')'
     ;

//Lexer Rules

UNARY-OPER : '!' | '-' | 'len' | 'ord' | 'chr'  ;

BINARY-OPER : '*' | '/' | '%' | '+' | '-' | '>' | '>=' | '<' | '<=' | '==' | '!=' | '&&' | '||'  ;

IDENT: ('_'|'a'..'z'|'A'..'Z') ('_'|'a'..'z'|'A'..'Z'|'0'..'9')* ;

ARRAY-ELEM : IDENT ('[' expr ']' )+  ;

INT-LITER: INT-SIGN? DIGIT+  ;

DIGIT : ('0'-'9)  ;

INT-SIGN : '+' | '-'  ;

BOOL-LITER :  'true' | 'false'  ;

CHAR-LITER : ''' CHARACTER '''  ;

STR-LITER : '"' CHARACTER* '"'  ;

CHARACTER : ~('\\' | '\'' | '"')|('\\' ESCAPED-CHAR) ;

ESCAPED-CHAR : '0'|'b'|'t'|'n'|'f'|'r' |'"'|'\''|'\\' ;

ARRAY-LITER: '[' ',' ']' ;

PAIR-LITER : 'null' ;

COMMENT : '#' ~('\n') EOL ;

EOL : '\\n' -> skip ;
























