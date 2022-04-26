package ast;

import token.Token;

public class AST {

}

interface Node {
	public String tokenLiteral();
}

interface Expression extends Node {
	public void expressionNode();
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



