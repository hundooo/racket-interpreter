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
	
	public boolean isLetter(char ch) {
		return 'a' <= ch && ch <= 'z' || 'A' <= ch && ch <= 'Z' || ch == '-';
	}
	
	public String readIdentifier() { 
		int position = this.position;
		
		while (isLetter(ch)) {
			readChar();
		}
		return input.substring(position, this.position);
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
		case 0:
			tok = new Token(Token.EOF, "");
			break;
		default:
			if (isLetter(ch)) { 
				String literal = readIdentifier();
				String type = Token.lookupIdent(literal);
				tok = new Token(type, literal);
				return tok;
			} else { 
				tok = new Token(Token.ILLEGAL, Character.toString(ch));
			}
		}
		
		readChar();
		return tok;
	}
}
