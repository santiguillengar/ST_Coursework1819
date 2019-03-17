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