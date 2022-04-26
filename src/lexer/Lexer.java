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
			ch = 0;
		} else { 
			ch = input.charAt(readPosition);
		}
		position = readPosition;
		readPosition += 1;
	}
	
	public boolean isLetter(char ch) {
		return 'a' <= ch && ch <= 'z' || 'A' <= ch && ch <= 'Z' || ch == '-';
	}
	
	public boolean isDigit(char ch) { 
		return '0' <= ch && ch <= '9';
	}
	
	public String readIdentifier() { 
		int position = this.position;
		
		while (isLetter(ch)) {
			readChar();
		}
		return input.substring(position, this.position);
	}
	
	public String readNumber() { 
		int position = this.position;
		
		while (isDigit(ch)) {
			readChar();
		}
		return input.substring(position, this.position);
	}
	
	public void eatWhitespace() {
		while (ch == ' ' || ch == '\t' || ch == '\n' || ch == '\r') {
			readChar();
		}
	}
	
	public Token nextToken() { 
		Token tok;
		
		eatWhitespace();
		
		switch(ch) {
		case '(':
			tok = new Token(Token.LPAREN, Character.toString(ch)); 
			break;
		case ')':
			tok = new Token(Token.RPAREN, Character.toString(ch)); 
			break;
		case '[':
			tok = new Token(Token.LSBRACK, Character.toString(ch));
			break;
		case ']':
			tok = new Token(Token.RSBRACK, Character.toString(ch));
			break;
		case '+':
			tok = new Token(Token.PLUS, Character.toString(ch)); 
			break;
		case '-':
			tok = new Token(Token.MINUS, Character.toString(ch));
			break;
		case '/':
			tok = new Token(Token.SLASH, Character.toString(ch));
			break;
		case '*':
			tok = new Token(Token.ASTERISK, Character.toString(ch));
			break;
		case '<':
			tok = new Token(Token.LT, Character.toString(ch));
			break;
		case '>':
			tok = new Token(Token.GT, Character.toString(ch));
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
			} else if (isDigit(ch)) {
				tok = new Token(Token.INT, readNumber());
				return tok;
			} else { 
				tok = new Token(Token.ILLEGAL, Character.toString(ch));
			}
		}
		
		readChar();
		return tok;
	}
}
