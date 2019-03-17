import static org.junit.Assert.*;

import org.junit.Test;

import st.Parser;

import org.junit.Before;
import static org.junit.Assert.assertEquals;
import java.util.List;
import java.util.Arrays;

public class Task3_TDD_1 {

	private Parser parser;

	@Before
	public void set_up() {
		parser = new Parser();
	}
	
	@Test
	public void test_part_3_example() {
		parser.add("list", "l", Parser.INTEGER);
		
		parser.parse("--list=1,2,3,4-7,10");
		List<Integer> l = parser.getIntegerList("list");
		
		Integer[] truth_array = {1,2,3,4,5,6,7,10};
		List<Integer> truth_list = Arrays.asList(truth_array);

		assertEquals(l, truth_list);
	}
	
	@Test
	public void test_71() {
		
		parser.add("output", "o", Parser.STRING);
		parser.parse("-o=1,2,3,4");
		
		List<Integer> l = parser.getIntegerList("list");
		Integer[] truth_array = {1,2,3,4};
		List<Integer> truth_list = Arrays.asList(truth_array);
		
		assertEquals(l, truth_list);

		parser.add("o", "test", Parser.STRING);
		parser.parse("--o=5,6,7,8");
		
		l = parser.getIntegerList("list");
		truth_array = new Integer[] {5,6,7,8};
		truth_list = Arrays.asList(truth_array);
		
		assertEquals(l, truth_list);

	}
	
	@Test
	public void test_72() {

		parser.add("list", "l", Parser.STRING);		
		parser.parse("--list");
		List<Integer> l = parser.getIntegerList("list");
		Integer[] truth_array = {};
		List<Integer> truth_list = Arrays.asList(truth_array);
		assertEquals(l, truth_list);	
	}
	
}
