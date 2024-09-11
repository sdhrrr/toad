package com.craftinginterpretors.lox;


enum TokenType {
    //single charecter tokens: 
    LEFT_PAREN, RIGHT_PAREN, LEFT_BRACE, RIGHT_BRACE,
    COMMA, DOT, MINUS, PLUS, SEMICOLON, SLASH, STAR,

    //one or two charecter tokens:
    BANG, BANG_EQUAL,
    EQUAL, EQUAL_EQUAL,
    GREATER, GREATER_EQUAL,
    LESS, LESS_EQUAL,

    // Listerals:
    IDENTIFIER, STRING, NUMBER,

    // Keywords: 
    CLASS, SUPER, RETURN, THIS,
    AND, OR, TRUE, FALSE, 
    FUN, VAR, FOR, WHILE, 
    IF, ELSE, NIL, PRINT,

    EOF
}