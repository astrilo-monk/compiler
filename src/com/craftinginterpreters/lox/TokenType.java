package com.craftinginterpreters.lox;

enum TokenType{ // enum is a fixed set of possible values , so no other thing i can input out of these few words for my parser to actually understand this 
        // single character tokens 
        LEFT_PAREN, RIGHT_PAREN, LEFT_BRACE,RIGHT_BRACEM, COMMA,DOT,MINUS,PLUS,SEMICOLON,SLASH,STAR,

        // paren = parenthesis 

        //one or two word tokens 
        NOT, NOT_EQUAL , EQUAL , EQUAL_EQUAL ,GREATER , GREATER_EQUAL, LESS, LESS_EQUAL,

        //keywords 
        AND, CLASS, ELES, FALSE , FUN , FOR , IF , NIL , OR , PRINT ,RETURN ,SUPER , THIS , TRUE ,VAR , WHILE ,

        EOF
}

