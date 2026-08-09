package com.craftinginterpreters.lox;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.nio.file.Paths;
import java.nio.file.Files;

import java.util.List;
import java.util.Scanner;

public class Lox {
    public static void main(String[] args) throws IOException{
        if(args.length>1){
            System.out.println("Usage: jlox [script]"); 
            System.exit(64);
        }
        else if(args.length == 1){ 
            runFile(args[0]);  //this works when the entire source code is passed 
        }
        else{
            runPrompt();  // this works when i need the repl 
        } 
        
    }

    private static void runFile(String path) throws IOException{ // the path is given to us by String path 
        byte[] bytes = Files.readAllBytes(Paths.get(path)); // this creates a path representing the file and reads the file's contents in raw bytes 
        String source = new String(bytes, Charset.defaultCharset()); // converts the bytes to normal java string 
        run(source); // runs the source code (about to build ts)
    }

    public static void runPrompt() throws IOException{
        InputStreamReader input = new InputStreamReader(System.in); // takes the keyboard input from the terminal and converts it into characters java can read 
        BufferedReader reader = new BufferedReader(input); // wraps that input so java can read it one line at a time 

        while(true){ // book wrote for(;;) it does the same infinite function but for better readability replaced it with that 
            System.out.println(">"); //beautification 
            String line = reader.readLine(); //reads and stores the terminal input 
            if(line == null) break;
            run(line); // runs the code 
        }
    }

    public static void run(String source) {
        Scanner sc = new Scanner(source);
        List<Token> tokens = sc.scanTokens();

        for(Token token : tokens)
            System.out.println(token);
    }
}

