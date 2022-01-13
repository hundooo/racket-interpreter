package lexer;

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
}
