parser grammar WaccParser;

options {
    tokenVocab = WaccLexer;
}

//Parser Rules

program : BEGIN (func)* stat END EOF;

func : type IDENT OPEN_PAREN param_list? CLOSE_PAREN IS stat END  ;
param_list : param ( COMMA param )* ;
param : type IDENT  ;

stat : SKIPTOK                                         # SKIP_STAT
     | type IDENT EQUAL assign_rhs                     # VAR_DECL_STAT
     | assign_lhs EQUAL assign_rhs                     # ASSIGN_STAT
     | READ assign_lhs                                 # READ_STAT
     | FREE expr                                       # FREE_STAT
     | RETURN expr                                     # RETURN_STAT
     | EXIT expr                                       # EXIT_STAT
     | PRINT expr                                      # PRINT_STAT
     | PRINTLN expr                                    # PRINTLN_STAT
     | IF expr THEN thenstat ELSE elsestat FI          # IF_STAT
     | WHILE expr DO stat DONE                         # WHILE_STAT
     | BEGIN stat END                                  # BEGIN_END_STAT
     | stat SEMI_COLON stat                            # MULT_STAT
     | side_effecting_expr                             # SIDE_EFFECT
     ;



thenstat : stat ;

elsestat : stat ;

assign_lhs : IDENT                                     # IDENT_ASSIGN
     | IDENT (SQUARE_OPEN expr SQUARE_CLOSED )+        # ARRAY_ELEM_LHS
     | pair_elem                                       # PAIR_ELEM_LHS
     ;


 assign_rhs : expr                                                 # EXPR_ASSIGN
      | SQUARE_OPEN (expr (COMMA expr)*)? SQUARE_CLOSED            # ARRAY_LITER_RHS
      | NEWPAIR OPEN_PAREN expr COMMA expr CLOSE_PAREN             # NEWPAIR_RHS
      | pair_elem                                                  # PAIR_ELEM_RHS
      | CALL IDENT OPEN_PAREN (expr (COMMA expr )*)? CLOSE_PAREN   # CALL_ASSIGN
      ;

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

//CHANGED ORDERING OF UNARYOP AND +/- INT_LITER

expr : INT_LITER                                      # INT_LITER_EXPR
     | unaryOp expr                                   # UNARY_OP_EXPR
     | expr binaryOp expr                             # BINARY_OP_EXPR
     | BOOL_LITER                                     # BOOL_LITER_EXPR
     | CHAR_LITER                                     # CHAR_LITER_EXPR
     | STR_LITER                                      # STR_LITER_EXPR
     | PAIR_LITER                                     # PAIR_LITER_EXPR
     | IDENT                                          # IDENT_EXPR
     | IDENT (SQUARE_OPEN expr SQUARE_CLOSED )+       # ARRAY_ELEM_EXPR
     | OPEN_PAREN expr CLOSE_PAREN                    # ENCLOSED_EXPR
     | side_effecting_expr                            # SIDE_EFFECT_EXPR
     ;

side_effecting_expr : IDENT PLUS PLUS                  # IDENT_PLUS_PLUS
                    | PLUS PLUS IDENT                  # PLUS_PLUS_IDENT
                    | MINUS MINUS IDENT                # MINUS_MINUS_IDENT
                    | IDENT MINUS MINUS                # IDENT_MINUS_MINUS
                    | IDENT PLUS EQUAL expr            # IDENT_PLUS_EQUALS
                    | IDENT MINUS EQUAL expr           # IDENT_MINUS_EQUALS
                    | IDENT EQUAL expr                 # IDENT_EQUAL
                    | IDENT MULT EQUAL expr            # IDENT_MULT_EQUALS
                    | IDENT DIV EQUAL expr             # IDENT_DIV_EQUALS
                    ;

unaryOp : CHR | ORD | LEN | EXCL | MINUS ;

binaryOp : MULT | DIV | MOD | PLUS | MINUS | GRTHAN | GREQTO | LSTHAN | LSEQTO | EQTO | NEQTO | AND | OR ;




