import static org.junit.Assert.*;

import org.junit.Test;

import st.Parser;

import org.junit.Before;
import static org.junit.Assert.assertEquals;

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
	
	@Test
	public void test_32() {
		//TODO
		assertEquals(1, 1);
	}
	
	@Test
	public void test_33() {
		//TODO
		assertEquals(1, 1);
	}
	
	@Test
	public void test_34() {
		//TODO
		assertEquals(1, 1);
	}
	
	@Test
	public void test_35() {
		//TODO
		assertEquals(1, 1);
	}
	
	
	// Section 4
	
	@Test
	public void test_41() {
		//TODO
		assertEquals(1, 1);
	}
	
	// Section 5
	
	@Test
	public void test_51() {
		//TODO
		assertEquals(1, 1);
	}
	
	@Test
	public void test_52() {
		//TODO
		assertEquals(1, 1);
	}
	
	@Test
	public void test_53() {
		//TODO
		assertEquals(1, 1);
	}
	
	@Test
	public void test_54() {
		//TODO
		assertEquals(1, 1);
	}
	
	@Test
	public void test_55() {
		//TODO
		assertEquals(1, 1);
	}
	
	@Test
	public void test_56() {
		//TODO
		assertEquals(1, 1);
	}
	
	@Test
	public void test_57() {
		//TODO
		assertEquals(1, 1);
	}
	
	@Test
	public void test_58() {
		//TODO
		assertEquals(1, 1);
	}
	
	// Section 6
	
	@Test
	public void test_61() {
		//TODO
		assertEquals(1, 1);
	}
	
	@Test
	public void test_62() {
		//TODO
		assertEquals(1, 1);
	}
}
