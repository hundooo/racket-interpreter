package lexer;

import token.Token;

public class LexerTest {
	public static void main(String[] args) { 
		String input = "()+";
		Token[] tests = {new Token("LPAREN", "("), new Token("RPAREN", ")"), new Token("PLUS", "+")};
		Lexer l = new Lexer();
		
		for (int i = 0; i < tests.length; i++) { 
			Token tt = tests[i];
			Token tok = l.nextToken();
			
			if (tok.type != tt.type) { 
				System.out.println("tests[" + i + "]" + "- tokentype wrong. expected=" + tt.type + ", got=" + tok.type);
			}
			
			if (tok.literal != tt.literal) { 
				System.out.println("tests[" + i + "]" + "- literal wrong. expect=" + tt.literal + ", got=" + tok.literal);
			}
		}
		
	}
}
