package ast;

import token.Token;

public class DefineStatement implements Statement {
	public Token token;
	public Identifier name;
	public Expression value;

	public String tokenLiteral() {
		return token.literal;
	}
	
	public void statementNode() {}
}