package parser;

import ast.DefineStatement;
import ast.Program;
import ast.Statement;
import lexer.Lexer;

public class ParserTest {
	
	public static void main(String[] args) { 
		testDefineStatements();
	}
	
	public static void testDefineStatements() {
		String input = "(define x 5) (define y 10) (define foobar 838383)";
		
		Lexer l = new Lexer(input);
		Parser p = new Parser(l);
		
		Program program = p.parseProgram();
		checkParserErrors(p);
		
		if (program == null) {
			System.out.println("FAIL: ParseProgram() returned null");
		}
		if (program.statements.size() != 3) {
			System.out.println("FAIL: program.statements does not contain 3 statements. got=" + program.statements.size());
		}
		
		String[] tests = new String[3];
		tests[0] = "x";
		tests[1] = "y";
		tests[2] = "foobar";
		
		for (int i = 0; i < tests.length; i++) {
			Statement s = program.statements.get(i);
			if (!testDefineStatement(s, tests[i])) {
				return;
			}
		}
	}
	
	public static boolean testDefineStatement(Statement s, String name) {
		if (!s.tokenLiteral().equals("define")) {
			System.out.println("s.tokenLiteral not 'define'. got=" + s.tokenLiteral());
			return false;
		}
		
		if (!(s instanceof DefineStatement)) {
			System.out.println("ERROR: s is not a DefineStatement. Got=" + s);
			return false;
		}
		
		DefineStatement defStmt = (DefineStatement) s;
		
		if (!defStmt.name.value.equals(name)) {
			System.out.println("ERROR: defStmt.name.value not " + name + ". got=" + defStmt.name.value);
			return false;
		}
		
		if (!defStmt.name.tokenLiteral().equals(name)) {
			System.out.println("ERROR: s.name not " + name + ". got=" + defStmt.name);
			return false;
		}
		
		return true;
	}
	
	public static void checkParserErrors(Parser p) {
		if (p.errors.size() == 0) {
			return;
		}
		
		System.out.println("ERROR: parser has " + p.errors.size() + " errors");
		for (int i = 0; i < p.errors.size(); i++) {
			System.out.println("parser error: " + p.errors.get(i));
		}
	}
}
