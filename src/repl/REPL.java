package repl;

import lexer.Lexer;
import token.Token;
import java.util.Scanner;

public class REPL {
	
	public final String PROMPT = ">>";
	
	public void start() {
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.print(PROMPT);
			
			if (!sc.hasNextLine()) {
				break;
			}
			
			String line = sc.nextLine();
			Lexer l = new Lexer(line);
			
			Token tok = l.nextToken();
			while (tok.type != Token.EOF) {
				System.out.println(tok);
				tok = l.nextToken();
			}
		}
		sc.close();
	}
}
