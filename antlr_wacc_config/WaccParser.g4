parser grammar WaccParser;

options {
    tokenVocab = WaccLexer;
}

//Parser Rules

program : BEGIN (func)* stat END EOF;

func : type IDENT OPEN_PAREN param_list? CLOSE_PAREN IS stat END  ;
param_list : param ( COMMA param )* ;
param : type IDENT  ;

stat : SKIP                                           # SKIP
     | type IDENT EQUAL assign_rhs                    # ASSIGN
     | assign_lhs EQUAL assign_rhs                    # EQUALS
     | READ assign_lhs                                # READ
     | FREE expr                                      # FREE
     | RETURN expr                                    # RETURN
     | EXIT expr                                      # EXIT
     | PRINT expr                                     # PRINT
     | PRINTLN expr                                   # PRINTLN
     | IF expr THEN stat ELSE stat FI                 # IF
     | WHILE expr DO stat DONE                        # WHILE
     | BEGIN stat END                                 # BEGIN_END
     | stat SEMI_COLON stat                           # SEMI
     ;

 assign_rhs : expr                                    # EXPR
      | array_liter                                   # ARRAY_LITER
      | NEWPAIR OPEN_PAREN expr COMMA expr CLOSE_PAREN # NEWPAIR
      | pair_elem                                      # PAIR_ELEM
      | CALL IDENT OPEN_PAREN (arg_list)? CLOSE_PAREN  # CALL
      ;

assign_lhs : IDENT                                    # IDENT
     | array_elem                                     # ARRAY_ELEM
     | pair_elem                                      # PAIR_ELEM
     ;

arg_list : expr (COMMA expr )*  ;

pair_elem : FST expr                                  # PAIR_FST
     | SND expr                                       # PAIR_SND
     ;

type : BASE_TYPE                                      # BASE_TYPE
     | type SQUARE_OPEN SQUARE_CLOSED                 # ARRAY_TYPE
     | pair_type                                      # PAIR_TYPE
     ;

pair_type : PAIR_STRING OPEN_PAREN pair_elem_type COMMA pair_elem_type CLOSE_PAREN ;

pair_elem_type : BASE_TYPE                            # BASE_TYPE
     | type SQUARE_OPEN SQUARE_CLOSED                 # ARRAY_TYPE
     | PAIR_STRING                                    # PAIR_STRING
     ;

expr : INT_LITER                                      # INT_LITER
     | BOOL_LITER                                     # BOOL_LITER
     | CHAR_LITER                                     # CHAR_LITER
     | STR_LITER                                      # STR_LITER
     | PAIR_LITER                                     # PAIR_LITER
     | IDENT                                          # IDENT
     | array_elem                                     # ARRAY_ELEM
     | UNARY_OPER expr                                # UNARY_OP
     | expr BINARY_OPER expr                          # BINARY_OP
     | OPEN_PAREN expr CLOSE_PAREN                    # CLOSED_EXPR
     ;

array_elem : IDENT (SQUARE_OPEN expr SQUARE_CLOSED )+  ;

array_liter: SQUARE_OPEN (expr (COMMA expr)*)? SQUARE_CLOSED ;
