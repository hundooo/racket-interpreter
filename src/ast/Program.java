package ast;

public class Program implements Statement {
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
