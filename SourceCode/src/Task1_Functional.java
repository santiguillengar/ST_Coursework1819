import static org.junit.Assert.*;

import org.junit.Test;

import st.Parser;

import org.junit.Before;
import static org.junit.Assert.assertEquals;

import org.junit.Assert;

public class Task1_Functional {

private Parser parser;
	
	@Before
	public void set_up() {
		parser = new Parser();
	}
	
	
	// Example test
	
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
		assertEquals(parser.getString("x"), "1");
	}
	
	
	
	@Test(expected = RuntimeException.class)
	public void test_32_name_numeric_start() {
		parser.add("1test", "t", Parser.STRING);
	}
	@Test(expected = RuntimeException.class)
	public void test_32_name_contains_asterisk() {
		parser.add("test*", "t", Parser.STRING);
	}
	public void test_32_name_contains_numbers() {
		parser.add("test1", "t", Parser.STRING);
	}
	public void test_32_name_contains_underscore() {
		parser.add("test_", "t", Parser.STRING);
	}
	@Test(expected = RuntimeException.class)
	public void test_32_shortcut_numeric_start() {
		parser.add("test", "1t", Parser.STRING);
	}
	@Test(expected = RuntimeException.class)
	public void test_32_shortcut_contains_asterisk() {
		parser.add("test", "t*", Parser.STRING);
	}
	public void test_32_shortcut_contains_numbers() {
		parser.add("test", "t1", Parser.STRING);
	}
	public void test_32_shortcut_contains_underscore() {
		parser.add("test", "t_", Parser.STRING);
	}
	
	
	
	@Test
	public void test_33() {

		parser.add("output", "o", Parser.STRING);
		
		parser.parse("--Output=output.txt");
		assertEquals(parser.getString("Output"), "");
		
		parser.parse("--output=output.txt");
		assertEquals(parser.getString("output"), "output.txt");
		
		parser.parse("--Output=output.txt");
		assertEquals(parser.getString("o"), "");
		
		parser.parse("--output=output.txt");
		assertEquals(parser.getString("o"), "output.txt");

	}
	
	@Test
	public void test_34() {

		assertEquals(1, 1);
	}
	
	@Test
	public void test_35() {

		assertEquals(1, 1);
	}
	
	
	// Section 4
	
	@Test
	public void test_41() {

		assertEquals(1, 1);
	}
	
	// Section 5
	
	@Test
	public void test_51() {

		assertEquals(1, 1);
	}
	
	@Test
	public void test_52() {

		assertEquals(1, 1);
	}
	
	@Test
	public void test_53() {

		assertEquals(1, 1);
	}
	
	@Test
	public void test_54() {

		assertEquals(1, 1);
	}
	
	@Test
	public void test_55() {

		assertEquals(1, 1);
	}
	
	@Test
	public void test_56() {

		assertEquals(1, 1);
	}
	
	@Test
	public void test_57() {

		assertEquals(1, 1);
	}
	
	@Test
	public void test_58() {

		assertEquals(1, 1);
	}
	
	// Section 6
	
	@Test
	public void test_61() {

		assertEquals(1, 1);
	}
	
	@Test
	public void test_62() {

		assertEquals(1, 1);
	}
}
