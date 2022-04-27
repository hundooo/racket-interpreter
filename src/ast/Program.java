package ast;

import java.util.ArrayList;

public class Program implements Statement {
	public ArrayList<Statement> statements;

	public String tokenLiteral() {
		if (statements.size() > 0) {
			return statements.get(0).tokenLiteral();
		} else {
			return "";
		}
	}

	public void statementNode() {}
}
