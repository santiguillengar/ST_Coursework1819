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
		parser.add("list", "l", Parser.STRING);
		
		parser.parse("--list=1,2,3,4-7,10");
		List<Integer> l = parser.getIntegerList("list");
		List<Integer> truth_list = Arrays.asList(1,2,3,4,5,6,7,10);

		assertEquals(l, truth_list);
	}
	@Test
	public void test_part_3_negative_num() {
		parser.add("list", "l", Parser.STRING);
		
		parser.parse("--list=-1");
		List<Integer> l = parser.getIntegerList("list");
		List<Integer> truth_list = Arrays.asList(-1);

		assertEquals(l, truth_list);
	}
	
	@Test
	public void test_part_3_duplicates() {
		parser.add("list", "l", Parser.STRING);
		
		parser.parse("--list=1-02,002-3");
		List<Integer> l = parser.getIntegerList("list");
		List<Integer> truth_list = Arrays.asList(1,2,2,3);

		assertEquals(l, truth_list);
	}
	
	@Test
	public void test_71() {
		
		parser.add("output", "o", Parser.STRING);
		parser.parse("-o=1,2,3,4");
		
		List<Integer> l = parser.getIntegerList("o");
		List<Integer> truth_list = Arrays.asList(1,2,3,4);
		
		assertEquals(l, truth_list);

		parser.add("o", "test", Parser.STRING);
		parser.parse("--o=5,6,7,8");
		
		l = parser.getIntegerList("o");
		truth_list = Arrays.asList(5,6,7,8);
		
		assertEquals(l, truth_list);

	}
	
	@Test
	public void test_72() {

		parser.add("list", "l", Parser.STRING);		
		parser.parse("--list");
		List<Integer> l = parser.getIntegerList("list");
		List<Integer> truth_list = Arrays.asList();
		assertEquals(l, truth_list);	
	}
	
	@Test
	public void test_73() {
		List<Integer> truth_list = Arrays.asList(1,2,4);
		String[] list_possible = {"1,2.4", "{}1<2>4({)", "'1,2 4'", "2,1,4", "1m2m4"};

		parser.add("list", "l", Parser.STRING);	
		
		for (String item : list_possible) {
			parser.parse("--list=" + item);
			List<Integer> l = parser.getIntegerList("list");
			assertEquals(l, truth_list);
		}

	}
	
	@Test
	public void test_74() {
		List<Integer> truth_list = Arrays.asList(1,2,4,5,6,7,8);
		String[] list_possible = {"1-2,4-8", "1,2,4,5,6-8", "'8-4 2-1'", "4-8m1-2"};

		parser.add("list", "l", Parser.STRING);	
		
		for (String item : list_possible) {
			parser.parse("--list=" + item);
			List<Integer> l = parser.getIntegerList("list");
			assertEquals(l, truth_list);
		}

	}
	
	@Test
	public void test_75() {
		List<Integer> truth_list = Arrays.asList(-7, -6, -5, -2, -1, 0, 1);
		String[] list_possible = {"-7--5,-2-1", "1,0,-1--2,-5--7"};

		parser.add("list", "l", Parser.STRING);	
		
		for (String item : list_possible) {
			parser.parse("--list=" + item);
			List<Integer> l = parser.getIntegerList("list");
			assertEquals(l, truth_list);
		}

	}
	
	@Test
	public void test_76() {
		List<Integer> truth_list = Arrays.asList();
		String[] list_possible = {"3-", "1,2,3-,4", "-2-", "3--", "-1-2-3", "-7{--5"};

		parser.add("list", "l", Parser.STRING);	
		
		for (String item : list_possible) {
			parser.parse("--list=" + item);
			List<Integer> l = parser.getIntegerList("list");
			assertEquals(l, truth_list);
		}
	}
}
