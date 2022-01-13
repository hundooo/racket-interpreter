package lexer;

import token.Token;

public class Lexer {
	
	public String input;
	public int position;     // current position in input (points to current char)
	public int readPosition; // current reading position in input (after current char)
	public char ch;          // current char under examination
	
	public Lexer(String input) { 
		this.input = input;
		readChar();
	}
	
	public void readChar() { 
		if (readPosition >= input.length()) { 
			readPosition = 0;
		} else { 
			ch = input.charAt(readPosition);
		}
		position = readPosition;
		readPosition += 1;
	}
	
	public Token nextToken() { 
		Token tok;
		
		switch(ch) { 
		case '(':
			tok = new Token(Token.LPAREN, Character.toString(ch)); 
			break;
		case ')':
			tok = new Token(Token.RPAREN, Character.toString(ch)); 
			break;
		case '+':
			tok = new Token(Token.PLUS, Character.toString(ch)); 
			break;
		default:
			tok = new Token(Token.EOF, "");
		}
		
		readChar();
		return tok;
	}
}
