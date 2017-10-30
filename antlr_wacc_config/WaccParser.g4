parser grammar WaccParser;

options {
    tokenVocab = WaccLexer;
}

//Parser Rules

program : BEGIN func* stat END ;

func : type IDENT OPEN_PAREN param_list? CLOSE_PAREN IS stat END  ;

param_list : param ( COMMA param )*  ;

param : type IDENT  ;

stat : SKIP
     | type IDENT EQUAL assign_rhs
     | assign_lhs EQUAL assign_rhs
     | READ assign_lhs
     | FREE expr
     | RETURN expr
     | EXIT expr
     | PRINT expr
     | PRINTLN expr
     | IF expr THEN stat ELSE stat FI
     | WHILE expr DO stat DONE
     | BEGIN stat END
     | stat SEMI_COLON stat
     ;

assign_lhs : IDENT
     | array_elem
     | pair_elem
     ;

assign_rhs : expr
     | array_liter
     | NEWPAIR OPEN_PAREN expr COMMA expr CLOSE_PAREN
     | pair_elem
     | CALL IDENT OPEN_PAREN arg_list? CLOSE_PAREN
     ;

arg_list : expr (COMMA expr )*  ;

pair_elem : FST expr
     | SND expr
     ;

type : base_type
     | array_type
     | pair_type
     ;
type2 : base_type
     |  pair_type
     ;

base_type : INT_STRING
     | BOOL_STRING
     | CHAR_STRING
     | STRING_STRING
     ;

array_type : type2 SQUARE_OPEN SQUARE_CLOSED  ;

pair_type : PAIR_STRING OPEN_PAREN pair_elem_type COMMA pair_elem_type CLOSE_PAREN ;

pair_elem_type : base_type
     | array_type
     | PAIR_STRING
     ;

expr : INT_LITER
     | BOOL_LITER
     | CHAR_LITER
     | STR_LITER
     | PAIR_LITER
     | IDENT
     | array_elem
     | UNARY_OPER expr
     | expr BINARY_OPER expr
     | OPEN_PAREN expr CLOSE_PAREN
     ;

array_elem : IDENT ('[' expr ']' )+  ;

array_liter: '[' (expr (',' expr)*)? ']' ;

