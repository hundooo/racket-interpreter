package lexer;

import token.Token;

public class LexerTest {
	public static void main(String[] args) { 
		String input = "(define five 5) (define ten 10) (define add (lambda (x y) (+ x y))) (define result (add five ten)) -/*5 5 < 10 > 5 (cond [(< 5 10) true] [else false])";
		Token[] tests = new Token[59];
		Lexer l = new Lexer(input);
		
		tests[0] = new Token(Token.LPAREN, "(");
		tests[1] = new Token(Token.DEFINE, "define");
		tests[2] = new Token(Token.IDENT, "five");
		tests[3] = new Token(Token.INT, "5");
		tests[4] = new Token(Token.RPAREN, ")");
		
		tests[5] = new Token(Token.LPAREN, "(");
		tests[6] = new Token(Token.DEFINE, "define");
		tests[7] = new Token(Token.IDENT, "ten");
		tests[8] = new Token(Token.INT, "10");
		tests[9] = new Token(Token.RPAREN, ")");
		
		tests[10] = new Token(Token.LPAREN, "(");
		tests[11] = new Token(Token.DEFINE, "define");
		tests[12] = new Token(Token.IDENT, "add");
		tests[13] = new Token(Token.LPAREN, "(");
		tests[14] = new Token(Token.LAMBDA, "lambda");
		tests[15] = new Token(Token.LPAREN, "(");
		tests[16] = new Token(Token.IDENT, "x");
		tests[17] = new Token(Token.IDENT, "y");
		tests[18] = new Token(Token.RPAREN, ")");
		tests[19] = new Token(Token.LPAREN, "(");
		tests[20] = new Token(Token.PLUS, "+");
		tests[21] = new Token(Token.IDENT, "x");
		tests[22] = new Token(Token.IDENT, "y");
		tests[23] = new Token(Token.RPAREN, ")");
		tests[24] = new Token(Token.RPAREN, ")");
		tests[25] = new Token(Token.RPAREN, ")");
		
		tests[26] = new Token(Token.LPAREN, "(");
		tests[27] = new Token(Token.DEFINE, "define");
		tests[28] = new Token(Token.IDENT, "result");
		tests[29] = new Token(Token.LPAREN, "(");
		tests[30] = new Token(Token.IDENT, "add");
		tests[31] = new Token(Token.IDENT, "five");
		tests[32] = new Token(Token.IDENT, "ten");
		tests[33] = new Token(Token.RPAREN, ")");
		tests[34] = new Token(Token.RPAREN, ")");
		tests[35] = new Token(Token.MINUS, "-");
		tests[36] = new Token(Token.SLASH, "/");
		tests[37] = new Token(Token.ASTERISK, "*");
		tests[38] = new Token(Token.INT, "5");
		tests[39] = new Token(Token.INT, "5");
		tests[40] = new Token(Token.LT, "<");
		tests[41] = new Token(Token.INT, "10");
		tests[42] = new Token(Token.GT, ">");
		tests[43] = new Token(Token.INT, "5");
		tests[44] = new Token(Token.LPAREN, "(");
		tests[45] = new Token(Token.COND, "cond");
		tests[46] = new Token(Token.LSBRACK, "[");
		tests[47] = new Token(Token.LPAREN, "(");
		tests[48] = new Token(Token.LT, "<");
		tests[49] = new Token(Token.INT, "5");
		tests[50] = new Token(Token.INT, "10");
		tests[51] = new Token(Token.RPAREN, ")");
		tests[52] = new Token(Token.TRUE, "true");
		tests[53] = new Token(Token.RSBRACK, "]");
		tests[54] = new Token(Token.LSBRACK, "[");
		tests[55] = new Token(Token.ELSE, "else");
		tests[56] = new Token(Token.FALSE, "false");
		tests[57] = new Token(Token.RSBRACK, "]");
		tests[58] = new Token(Token.RPAREN, ")");
		
		boolean flag = true;
		for (int i = 0; i < tests.length; i++) { 
			Token tt = tests[i];
			Token tok = l.nextToken();
			
			if (!tok.type.equals(tt.type)) { 
				System.out.println("tests[" + i + "]" + "- tokentype wrong. expected=" + tt.type + ", got=" + tok.type);
				flag = false;
			}
			
			if (!tok.literal.equals(tt.literal)) { 
				System.out.println("tests[" + i + "]" + "- literal wrong. expect=" + tt.literal + ", got=" + tok.literal);
				flag = false;
			}
		}
		System.out.println(flag ? "ALL TESTS PASSED" : "FAIL");
	}
}
