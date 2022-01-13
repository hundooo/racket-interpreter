package token;

public class Token {
	public final String ILLEGAL = "ILLEGAL";
	public final String EOF = "EOF";
	
	// Identifiers + literals
	public final String IDENT = "IDENT";
	public final String INT = "INT";
	
	// Operators 
	public final String PLUS = "+";
	
	public final String LPAREN = "(";
	public final String RPAREN = ")";
	
	// Keywords
	public final String LAMBDA = "LAMBDA";
	public final String DEFINE = "DEFINE";
	
	public String type;
	public String literal;
	
	public Token(String type, String literal) {
		this.type = type;
		this.literal = literal;
	}
	
	
}
