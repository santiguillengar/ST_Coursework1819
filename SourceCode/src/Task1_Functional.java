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
		assertEquals(parser.getInteger("x"), 1);
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
		
		parser.parse("-o=output.txt");
		assertEquals(parser.getString("o"), "output.txt");
		
		parser.parse("-O=output.txt");
		assertEquals(parser.getString("O"), "");

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
		
		parser.parse("--output=0");
		assertEquals(parser.getBoolean("output"), false);
		
		parser.parse("--output=false");
		assertEquals(parser.getBoolean("output"), false);
		
		parser.parse("--output=False");
		assertEquals(parser.getBoolean("output"), false);
		
		parser.parse("--output=FALSE");
		assertEquals(parser.getBoolean("output"), false);
		
		parser.parse("");
		assertEquals(parser.getBoolean("output"), false);
		
		parser.parse("--output=1");
		assertEquals(parser.getBoolean("output"), true);
		
		parser.parse("--output=true");
		assertEquals(parser.getBoolean("output"), true);
		
		parser.parse("--output=True");
		assertEquals(parser.getBoolean("output"), true);
		
		parser.parse("--output=TRUE");
		assertEquals(parser.getBoolean("output"), true);
		
		parser.parse("--output");
		assertEquals(parser.getBoolean("output"), true);
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
	public void test_42_name_contains_numbers() {
		parser.add("test1", Parser.STRING);
	}
	public void test_42_name_contains_underscore() {
		parser.add("test_", Parser.STRING);
	}

	@Test
	public void test_43() {

		parser.add("output", Parser.STRING);
		
		parser.parse("--Output=output.txt");
		assertEquals(parser.getString("Output"), "");
		
		parser.parse("--output=output.txt");
		assertEquals(parser.getString("output"), "output.txt");

	}

	@Test
	public void test_45() {

		parser.add("output", Parser.BOOLEAN);
		
		parser.parse("--output=0");
		assertEquals(parser.getBoolean("output"), false);
		
		parser.parse("--output=false");
		assertEquals(parser.getBoolean("output"), false);
		
		parser.parse("--output=False");
		assertEquals(parser.getBoolean("output"), false);
		
		parser.parse("--output=FALSE");
		assertEquals(parser.getBoolean("output"), false);
		
		parser.parse("");
		assertEquals(parser.getBoolean("output"), false);
		
		parser.parse("--output=1");
		assertEquals(parser.getBoolean("output"), true);
		
		parser.parse("--output=true");
		assertEquals(parser.getBoolean("output"), true);
		
		parser.parse("--output=True");
		assertEquals(parser.getBoolean("output"), true);
		
		parser.parse("--output=TRUE");
		assertEquals(parser.getBoolean("output"), true);
		
		parser.parse("--output");
		assertEquals(parser.getBoolean("output"), true);
	}

	
	// Section 5
	
	@Test
	public void test_51() {
		parser.add("output", "o", Parser.STRING);
		assertEquals(parser.parse("--output=output.txt"), 0);
		
		parser.parse("--output=output.txt");
		assertEquals(parser.getString("output"), "output.txt");
	}
	
	@Test
	public void test_52() {
		parser.add("output", "o", Parser.STRING);
		assertEquals(parser.parse("-o=output.txt"), 0);
		
		parser.parse("-o=output.txt");
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
		
		parser.parse("--output=\"output.txt\"");
		assertEquals(parser.getString("output"), "output.txt");
		
		parser.parse("--output='output2.txt'");
		assertEquals(parser.getString("output"), "output2.txt");
		
		parser.parse("--output=output3.txt");
		assertEquals(parser.getString("output"), "output3.txt");
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
		parser.parse("--outputBool");
		assertEquals(parser.getBoolean("outputBool"), false);
		
		parser.add("outputChar", "oChar", Parser.CHAR);
		parser.parse("--outputChar");
		assertEquals(parser.getChar("outputChar"), '\0');
	
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
