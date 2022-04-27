package ast;

import token.Token;

public class Identifier implements Expression {
	public Token token;
	public String value;
	
	public String tokenLiteral() {
		return token.literal;
	}
	
	public void expressionNode() {}
}