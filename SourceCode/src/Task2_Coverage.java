import static org.junit.Assert.*;

import org.junit.Test;

import st.Parser;

import org.junit.Before;
import static org.junit.Assert.assertEquals;
import java.math.BigInteger;


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
	
}
