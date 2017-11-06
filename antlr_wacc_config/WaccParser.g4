parser grammar WaccParser;

options {
    tokenVocab = WaccLexer;
}

//Parser Rules

program : BEGIN (func)* stat END EOF;

func : type IDENT OPEN_PAREN param_list? CLOSE_PAREN IS stat END  ;
param_list : param ( COMMA param )* ;
param : type IDENT  ;



stat : SKIP                                            # SKIP_STAT
     | type IDENT EQUAL assign_rhs                     # VAR_DECL_STAT
     | assign_lhs EQUAL assign_rhs                     # ASSIGN_STAT
     | READ assign_lhs                                 # READ_STAT
     | FREE expr                                       # FREE_STAT
     | RETURN expr                                     # RETURN_STAT
     | EXIT expr                                       # EXIT_STAT
     | PRINT expr                                      # PRINT_STAT
     | PRINTLN expr                                    # PRINTLN_STAT
     | IF expr THEN stat ELSE stat FI                  # IF_STAT
     | WHILE expr DO stat DONE                         # WHILE_STAT
     | BEGIN stat END                                  # BEGIN_END_STAT
     | stat SEMI_COLON stat                            # MULT_STAT
     ;


assign_lhs : IDENT                                     # IDENT_ASSIGN
     | IDENT (SQUARE_OPEN expr SQUARE_CLOSED )+        # ARRAY_ELEM_LHS
     | pair_elem                                       # PAIR_ELEM_LHS
     ;


 assign_rhs : expr                                      # EXPR_ASSIGN
      | SQUARE_OPEN (expr (COMMA expr)*)? SQUARE_CLOSED # ARRAY_LITER_RHS
      | NEWPAIR OPEN_PAREN expr COMMA expr CLOSE_PAREN  # NEWPAIR_RHS
      | pair_elem                                       # PAIR_ELEM_RHS
      | CALL IDENT OPEN_PAREN (arg_list)? CLOSE_PAREN   # CALL_ASSIGN
      ;

arg_list : expr (COMMA expr )*  ;

pair_elem : FST expr                                  # PAIR_FST
     | SND expr                                       # PAIR_SND
     ;

type : BASE_TYPE                                                                  # BASE_TYPE
     | type SQUARE_OPEN SQUARE_CLOSED                                             # ARRAY_TYPE
     | PAIR_STRING OPEN_PAREN pair_elem_type COMMA pair_elem_type CLOSE_PAREN     # PAIR_TYPE
     ;

pair_elem_type : BASE_TYPE                            # BASE_TYPE_PAIR
     | type SQUARE_OPEN SQUARE_CLOSED                 # ARRAY_TYPE_PAIR
     | PAIR_STRING                                    # PAIR_STRING
     ;

expr : INT_LITER                                      # INT_LITER_EXPR
     | BOOL_LITER                                     # BOOL_LITER_EXPR
     | CHAR_LITER                                     # CHAR_LITER_EXPR
     | STR_LITER                                      # STR_LITER_EXPR
     | PAIR_LITER                                     # PAIR_LITER_EXPR
     | IDENT                                          # IDENT_EXPR
     | IDENT (SQUARE_OPEN expr SQUARE_CLOSED )+       # ARRAY_ELEM_EXPR
     | UNARY_OPER expr                                # UNARY_OP_EXPR
     | expr BINARY_OPER expr                          # BINARY_OP_EXPR
     | OPEN_PAREN expr CLOSE_PAREN                    # ENCLOSED_EXPR
     ;





