import static org.junit.Assert.*;

import org.junit.Test;

import st.Parser;

import org.junit.Before;
import static org.junit.Assert.assertEquals;


public class Task2_Coverage {
	
	private Parser parser;

	
	@Before
	public void set_up() {
		parser = new Parser();
	}
	
	// ------------------------------------------------------
	// Tests from Part 1
	// ------------------------------------------------------

	@Test
	public void example_test() {
		parser.add("output", "o", Parser.STRING);
		parser.parse("--output=output.txt");
		assertEquals(parser.getString("o"), "output.txt");
	}
	
	
	// Section 3
	
	@Test
	public void test_31() {
		parser.add("output", "o", Parser.STRING);
		parser.parse("--output=output.txt");
		assertEquals(parser.getString("o"), "output.txt");
		
		parser.add("output", "x", Parser.INTEGER);
		parser.parse("--output=1");
		assertEquals(parser.getInteger("x"), 1);
	}
	
	//Tests all types of values
	@Test
	public void test_31_types() {
		parser.add("string", "s", Parser.STRING);
		parser.add("integer", "i", Parser.INTEGER);
		parser.add("boolean", "b", Parser.BOOLEAN);
		parser.add("char", "c", Parser.CHAR);

		parser.parse("-s=output.txt -i=123 -b=false -c=o");
		
		assertEquals(parser.getString("s"), "output.txt");
		assertEquals(parser.getInteger("i"), 123);
		assertEquals(parser.getBoolean("b"), false);
		assertEquals(parser.getChar("c"), 'o');

		
	}
	
	@Test(expected = RuntimeException.class)
	public void test_32_name_numeric_start() {
		parser.add("1test", "t", Parser.STRING);
	}
	
	@Test(expected = RuntimeException.class)
	public void test_32_name_contains_asterisk() {
		parser.add("test*", "t", Parser.STRING);
	}
	
	@Test(expected = RuntimeException.class)
	public void test_32_shortcut_numeric_start() {
		parser.add("test", "1t", Parser.STRING);
	}
	
	@Test(expected = RuntimeException.class)
	public void test_32_shortcut_contains_asterisk() {
		parser.add("test", "t*", Parser.STRING);
	}
	
	@Test
	public void test_32_name() {
		// Letters
		for(char ch = 'a'; ch <= 'z'; ++ch){
			parser.add(Character.toString(ch), Character.toString(ch), Parser.STRING);
        } 
		for(char ch = 'A'; ch <= 'Z'; ++ch){
			parser.add(Character.toString(ch), Character.toString(ch), Parser.STRING);
        }
		// Numbers and underscore
		for(char ch = '0'; ch <= '9'; ++ch){
			parser.add("a_" + ch, "a_" + ch, Parser.STRING);
        } 
	}
	
	@Test
	public void test_33() {

		parser.add("output", "o", Parser.STRING);
		parser.add("Output", "O", Parser.INTEGER);

		
		parser.parse("--Output=output.txt");
		assertEquals(parser.getInteger("Output"), 0);
		
		parser.parse("--output=output.txt");
		assertEquals(parser.getString("output"), "output.txt");
		
		parser.parse("-o=output.txt");
		assertEquals(parser.getString("o"), "output.txt");
		
		parser.parse("-O=output.txt");
		assertEquals(parser.getInteger("O"), 0);

	}
	
	@Test
	public void test_34() {

		parser.add("o", "test", Parser.STRING);
		parser.add("output", "o", Parser.INTEGER);
		
		parser.parse("--output=2");
		assertEquals(parser.getInteger("output"), 2);
		
		parser.parse("-o=1");
		assertEquals(parser.getInteger("output"), 1);
		
		parser.parse("--o=output3.txt");
		assertEquals(parser.getString("o"), "output3.txt");
		
		parser.parse("-test=output4.txt");
		assertEquals(parser.getString("o"), "output4.txt");

	}
	
	@Test
	public void test_35() {
		
		parser.add("output", "o", Parser.BOOLEAN);

		
		String[] part1 = {"--output ", 
						  "-o ",
						  "--output=",
						  "-o="};
		String[] part2true = {"1",
							  "100",
							  "true",
							  "True",
							  "TRUE"};
		String[] part2false = {"0",
							   "false",
							   "False",
							   "FALSE"};
		
		// Empty case
		parser.parse("");
		assertEquals(parser.getBoolean("output"), false);
		
		// Empty definition case
		parser.parse("--output");
		assertEquals(parser.getBoolean("output"), true);
		parser.parse("-o");
		assertEquals(parser.getBoolean("output"), true);
		
		//Matrix of tests
		for (String firstpart : part1) {
			for (String secondpart : part2false) {
				parser.parse(firstpart + secondpart);
				assertEquals(parser.getBoolean("output"), false);
			}
		}
		
		for (String firstpart : part1) {
			for (String secondpart : part2true) {
				parser.parse(firstpart + secondpart);
				assertEquals(parser.getBoolean("output"), true);
			}
		}
	}
	
	
	// Section 4
	
	@Test
	public void test_41() {
		parser.add("output", Parser.STRING);
		parser.parse("--output=output.txt");
		assertEquals(parser.getString("output"), "output.txt");
		
		parser.add("output", Parser.INTEGER);
		parser.parse("--output=1");
		assertEquals(parser.getInteger("output"), 1);
	}
	
	@Test(expected = RuntimeException.class)
	public void test_42_name_numeric_start() {
		parser.add("1test", Parser.STRING);
	}
	
	@Test(expected = RuntimeException.class)
	public void test_42_name_contains_asterisk() {
		parser.add("test*", Parser.STRING);
	}
	
	@Test
	public void test_42_name() {
		// Letters
		for(char ch = 'a'; ch <= 'z'; ++ch){
			parser.add(Character.toString(ch), Parser.STRING);
        } 
		for(char ch = 'A'; ch <= 'Z'; ++ch){
			parser.add(Character.toString(ch), Parser.STRING);
        }
		// Numbers and underscore
		for(char ch = '0'; ch <= '9'; ++ch){
			parser.add("a_" + ch, Parser.STRING);
        } 
	}
	
	@Test
	public void test_43() {

		parser.add("output", Parser.STRING);
		parser.add("Output", Parser.INTEGER);

		
		parser.parse("--Output=1");
		assertEquals(parser.getInteger("Output"), 1);
		
		parser.parse("--output=output.txt");
		assertEquals(parser.getString("output"), "output.txt");

	}

	@Test
	public void test_45() {

		parser.add("output", Parser.BOOLEAN);
		
		String[] part1 = {"--output ", 
						  "-o ",
						  "--output=",
						  "-o="};
		String[] part2true = {"1",
							  "100",
							  "true",
							  "True",
							  "TRUE"};
		String[] part2false = {"0",
							   "false",
							   "False",
							   "FALSE"};
		
		// Empty case
		parser.parse("");
		assertEquals(parser.getBoolean("output"), false);
		
		// Empty definition case
		parser.parse("--output");
		assertEquals(parser.getBoolean("output"), true);
		parser.parse("-o");
		assertEquals(parser.getBoolean("output"), true);
		
		//Matrix of tests
		for (String firstpart : part1) {
			for (String secondpart : part2false) {
				parser.parse(firstpart + secondpart);
				assertEquals(parser.getBoolean("output"), false);
			}
		}
		
		for (String firstpart : part1) {
			for (String secondpart : part2true) {
				parser.parse(firstpart + secondpart);
				assertEquals(parser.getBoolean("output"), true);
			}
		}
	}

	
	// Section 5
	
	@Test
	public void test_51() {
		parser.add("output", "o", Parser.STRING);
		assertEquals(parser.parse("--output=output.txt"), 0);
		
		assertEquals(parser.getString("output"), "output.txt");
	}
	
	@Test
	public void test_52() {
		parser.add("output", "o", Parser.STRING);
		assertEquals(parser.parse("-o=output.txt"), 0);
		
		assertEquals(parser.getString("output"), "output.txt");
	}
	
	@Test
	public void test_53() {

		parser.add("output", "o", Parser.STRING);
		
		parser.parse("--output=output.txt");
		assertEquals(parser.getString("output"), "output.txt");
		
		parser.parse("--output output2.txt");
		assertEquals(parser.getString("output"), "output2.txt");
	}
	
	@Test
	public void test_54() {
		
		parser.add("output", "o", Parser.STRING);

		String[] part1 = {"--output ", 
						  "-o ",
						  "--output=",
						  "-o="};
		String[] part2 = {"value",
						  "\"value\"",
						  "'value'"};
		
		//Matrix of tests
		for (String firstpart : part1) {
			for (String secondpart : part2) {
				parser.parse(firstpart + secondpart);
				assertEquals(parser.getString("output"), "value");
			}
		}
	}
	
	@Test
	public void test_55() {

		parser.add("output", "o", Parser.STRING);
		
		parser.parse("--output=\"value='abc'\"");
		assertEquals(parser.getString("output"), "value='abc'");
		
		parser.parse("--output='value=\"abc\"'");
		assertEquals(parser.getString("output"), "value=\"abc\"");
	}
	
	@Test
	public void test_56() {

		parser.add("output", "o", Parser.STRING);
		
		parser.parse("--output=output.txt");
		parser.parse("--output=output2.txt");
		assertEquals(parser.getString("output"), "output2.txt");
		
		parser.parse("-o=output3.txt");
		assertEquals(parser.getString("output"), "output3.txt");
	}
	
	@Test
	public void test_57() {

		parser.add("outputStr", "oStr", Parser.STRING);		
		parser.parse("--outputStr");
		assertEquals(parser.getString("outputStr"), "");
		
		parser.add("outputInt", "oInt", Parser.INTEGER);
		parser.parse("--outputInt");
		assertEquals(parser.getInteger("outputInt"), 0);
		
		parser.add("outputBool", "oBool", Parser.BOOLEAN);
		parser.parse("");
		assertEquals(parser.getBoolean("outputBool"), false);
		parser.parse("--outputBool");
		assertEquals(parser.getBoolean("outputBool"), true);
		
		parser.add("outputChar", "oChar", Parser.CHAR);
		parser.parse("--outputChar");
		assertEquals(parser.getChar("outputChar"), '\0');
	
	}
	
	@Test
	public void test_58() {

		parser.add("output", "O", Parser.STRING);
		parser.add("input", "i",  Parser.STRING);
		
		parser.parse("--input 1.txt --output=2.txt");
		assertEquals(parser.getString("input"), "1.txt");
		assertEquals(parser.getString("output"), "2.txt");
		
		parser.parse("-O");
		assertEquals(parser.getString("-O"), "");
	}
	
	// Section 6
	
	@Test
	public void test_61() {
		
		parser.add("output", "o", Parser.STRING);

		parser.parse("-o=output.txt");
		assertEquals(parser.getString("o"), "output.txt");
		
		parser.add("o", "test", Parser.STRING);

		parser.parse("--o=output2.txt");
		assertEquals(parser.getString("o"), "output2.txt");
		

	}
	
	// ------------------------------------------------------
	// End of tests from Part 1
	// ------------------------------------------------------
	
	@Test
	public void test_getInteger_Integer() {
		parser.add("output", "o", Parser.INTEGER);
		
		parser.parse("--output=99999999999999999999");
		assertEquals(parser.getInteger("output"), 0);
		
		parser.parse("--output=a");
		assertEquals(parser.getInteger("output"), 0);
		
		assertEquals(parser.getInteger(""), 0);

	}
	
	@Test
	public void test_getInteger_String() {
		parser.add("output", "o", Parser.STRING);
		
		parser.parse("--output=output.txt");
		assertEquals(parser.getInteger("output"), 0);
		
		parser.parse("--output=123");
		assertEquals(parser.getInteger("output"), 123);
	}
	
	@Test
	public void test_getInteger_Boolean() {
		parser.add("output", "o", Parser.BOOLEAN);
		
		parser.parse("--output=false");
		assertEquals(parser.getInteger("output"), 0);
		
		parser.parse("--output=true");
		assertEquals(parser.getInteger("output"), 1);
	}
	
	@Test
	public void test_getInteger_Char() {
		parser.add("output", "o", Parser.CHAR);
		
		parser.parse("--output=a");
		assertEquals(parser.getInteger("output"), 97);
	}
	
	@Test
	public void test_empty_parse() {		
		assertEquals(parser.parse(null), -1);
	}
	
	@Test
	public void test_toString() {
		parser.add("output", "o", Parser.CHAR);
		
		assertEquals(parser.toString(),"OptionMap [options=\n" + 
				"	{name=output, shortcut=o, type=4, value=}\n" + 
				"]");
	}
	
	@Test
	public void test_parse_strings() {
		parser.add("output", "o", Parser.STRING);
		
		parser.parse("    ");
		assertEquals(parser.parse("output=output.txt"), -3);
		
		parser.parse("-_ ");
		parser.parse("-_-");
		parser.parse("-_ -");
	}
	
	@Test(expected = RuntimeException.class)
	public void test_isOptionValid_type_over() {
		parser.add("output", "o", 5);
	}
	
	@Test(expected = RuntimeException.class)
	public void test_isOptionValid_type_under() {
		parser.add("output", "o", 0);
	}
	
	@Test(expected = RuntimeException.class)
	public void test_isOptionValid_name_null() {
		parser.add(null, "o", Parser.STRING);
	}
	
	@Test(expected = RuntimeException.class)
	public void test_isOptionValid_name_empty() {
		parser.add("", "o", Parser.STRING);
	}
	
	@Test(expected = RuntimeException.class)
	public void test_isOptionValid_shortcut_null() {
		parser.add("output", null, Parser.STRING);
	}
	
	
}