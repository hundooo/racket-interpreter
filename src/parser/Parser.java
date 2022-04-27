package parser;

import java.util.ArrayList;
import ast.DefineStatement;
import ast.Identifier;
import ast.Program;
import ast.Statement;
import lexer.Lexer;
import token.Token;

public class Parser {
	Lexer l;
	Token curToken;
	Token peekToken;
	ArrayList<String> errors;
	
	public Parser(Lexer l) {
		this.l = l;
		errors = new ArrayList<String>();
		nextToken();
		nextToken();
	}
	
	public void nextToken() {
		curToken = peekToken;
		peekToken = l.nextToken();
	}
	
	public Program parseProgram() {
		Program program = new Program();
		program.statements = new ArrayList<Statement>();
		
		while(curToken.type != Token.EOF) {
			Statement stmt = parseStatement();
			if (stmt != null) {
				program.statements.add(stmt);
			}
			nextToken();
		}
		
		return program;
	}
	
	public Statement parseStatement() { 
		switch(curToken.type) {
		case Token.DEFINE:
			return parseDefineStatement();
		default:
			return null;
		}
	}
	
	public Statement parseDefineStatement() {
		DefineStatement stmt = new DefineStatement(curToken);
		
		if (!expectPeek(Token.IDENT)) {
			return null;
		}
		
		stmt.name = new Identifier(curToken, curToken.literal);
		
		while (!curTokenIs(Token.RPAREN)) {
			nextToken();
		}
		
		return stmt;
	}
	
	public boolean curTokenIs(String t) {
		return curToken.type == t;
	}
	
	
	public boolean peekTokenIs(String t) {
		return peekToken.type == t;
	}
	
	public boolean expectPeek(String t) { 
		if (peekTokenIs(t)) {
			nextToken();
			return true;
		} else {
			return false;
		}
	}
	
	public void peekError(String t) { 
		String msg = "expected next token to be " + t + ", got " + peekToken.type + " instead";
		errors.add(msg);
	}
}
