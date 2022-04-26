package token;

import java.util.Map;

public class Token {
	public static final String ILLEGAL = "ILLEGAL";
	public static final String EOF = "EOF";
	
	// Identifiers + literals
	public static final String IDENT = "IDENT";
	public static final String INT = "INT";
	
	// Operators 
	public static final String PLUS = "+";
	public static final String MINUS = "-";
	public static final String ASTERISK = "*";
	public static final String SLASH = "/";
	public static final String LT = "<";
	public static final String GT = ">";
	public static final String LPAREN = "(";
	public static final String RPAREN = ")";
	
	// Keywords
	public static final String LAMBDA = "LAMBDA";
	public static final String DEFINE = "DEFINE";
	public static final Map<String, String> KEYWORDS = Map.ofEntries(
			Map.entry("lambda", LAMBDA), 
			Map.entry("define", DEFINE));
	
	
	public String type;
	public String literal;
	
	public Token(String type, String literal) {
		this.type = type;
		this.literal = literal;
	}
	
	public static String lookupIdent(String ident) {
		if (KEYWORDS.get(ident) != null) {
			return KEYWORDS.get(ident);
		}
		return IDENT;
	}
}