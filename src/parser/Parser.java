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
	
	public Parser(Lexer l) {
		this.l = l;
		nextToken();
		nextToken();
	}
	
	public void nextToken() {
		curToken = peekToken;
		peekToken = l.nextToken();
	}
	
	public Program ParseProgram() {
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
		
		return stmt;
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
}
