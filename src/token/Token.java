package token;

import java.util.Map;

public class Token {
	public static final String ILLEGAL = "ILLEGAL";
	public static final String EOF = "EOF";
	
	// Identifiers + literals
	public static final String IDENT = "IDENT";
	public static final String INT = "INT";
	
	// Operators 
	public static final String EQUAL = "=";
	public static final String PLUS = "+";
	public static final String MINUS = "-";
	public static final String ASTERISK = "*";
	public static final String SLASH = "/";
	public static final String LT = "<";
	public static final String GT = ">";
	public static final String LTE = "<=";
	public static final String GTE = ">=";
	public static final String LPAREN = "(";
	public static final String RPAREN = ")";
	public static final String LSBRACK = "[";
	public static final String RSBRACK = "]";
	
	// Keywords
	public static final String TRUE = "TRUE";
	public static final String FALSE = "FALSE";
	public static final String ELSE = "ELSE";
	public static final String COND = "COND";
	public static final String LAMBDA = "LAMBDA";
	public static final String DEFINE = "DEFINE";
	public static final Map<String, String> KEYWORDS = Map.ofEntries(
			Map.entry("lambda", LAMBDA), 
			Map.entry("define", DEFINE),
			Map.entry("cond", COND),
			Map.entry("true", TRUE),
			Map.entry("false", FALSE),
			Map.entry("else", ELSE));
	
	
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
	
	@Override
	public String toString() {
		return "{Type:" + type + " Literal:" + literal + "}";
	}
}