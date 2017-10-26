
grammar Wacc;
import WaccTokens;

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

expr : int-liter
     | bool-liter
     | char-liter
     | str-liter
     | pair-liter
     | ident
     | array-elem
     | unary-oper expr
     | expr binary-oper expr
     | '(' expr ')'
     ;

unary-oper : '!' | '-' | 'len' | 'ord' | 'chr'  ;

binary-oper : '*' | '/' | '%' | '+' | '-' | '>' | '>=' | '<' | '<=' | '==' | '!=' | '&&' | '||'  ;

ident: ('_'|'a'..'z'|'A'..'Z') ('_'|'a'..'z'|'A'..'Z'|'0'..'9')* ;

array-elem : ident ('[' expr ']' )+  ;

int-liter: int-sign? digit+  ;

digit : ('0'-'9)  ;

int-sign : '+' | '-'  ;

bool-liter :  'true' | 'false'  ;

char-liter : ''' character '''  ;

str-liter : '"' character* '"'  ;

character : ~('\\' | '\'' | '"')|('\\' escaped-char) ;

escaped-char : '0'|'b'|'t'|'n'|'f'|'r' |'"'|'\''|'\\' ;

array-liter: '[' ',' ']' ;

pair-liter : 'null' ;

comment : '#' ~('\n') eol ;

eol : '\\n' -> skip;
























