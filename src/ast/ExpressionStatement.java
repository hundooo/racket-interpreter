package ast;

import token.Token;

public class ExpressionStatement implements Statement {
	Token token;
	Expression expression;
	
	public String tokenLiteral() {
		return token.literal;
	}

	public void statementNode() {}
}
