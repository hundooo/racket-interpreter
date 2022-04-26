package parser;

import ast.AST;
import lexer.Lexer;
import token.Token;

public class Parser {
	Lexer l;
	Token curToken;
	Token peekToken;
	
	public Parser(Lexer l) {
		this.l = l;
		nextToken();
		nextToken();
	}
	
	public void nextToken() {
		curToken = peekToken;
		peekToken = l.nextToken();
	}
	
//	public  ParseProgram() {
//		return null;
//	}
}
