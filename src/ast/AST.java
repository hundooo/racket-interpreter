package ast;

import token.Token;

public class AST {

}

interface Node {
	public String tokenLiteral();
}

interface Statement extends Node {
	public void statementNode();
}

interface Expression extends Node {
	public void expressionNode();
}

class Program implements Statement {
	Statement[] statements;

	public String tokenLiteral() {
		if (statements.length > 0) {
			return statements[0].tokenLiteral();
		} else {
			return "";
		}
	}

	public void statementNode() {}
}

class DefineStatement implements Statement {
	Token token;
	Identifier name;
	Expression value;

	public String tokenLiteral() {
		return token.literal;
	}
	
	public void statementNode() {}
}

class Identifier implements Expression {
	Token token;
	String value;
	
	public String tokenLiteral() {
		return token.literal;
	}
	
	public void expressionNode() {}
}



