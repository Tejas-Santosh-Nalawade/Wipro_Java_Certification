package Junit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class assign1Testcase {

	private static assign1 assignment;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		assignment = new assign1();
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		assignment = null;
	}
	@Test
	void testSimpleAscendingSort() {
		int[] input = {5, 3, 1, 4, 2};
		int[] expected = {1, 2, 3, 4, 5};
		assertArrayEquals(expected, assignment.sortArray(input));
	}
	@Test
	void testSimpleNullInput() {
		int[] actual = assignment.sortArray(null);
		assertEquals(0, actual.length);
	}
	@Test
	void testComplexDescendingSort() {
		int[] input = {10, -5, 20, 0};
		int[] expected = {20, 10, 0, -5};
		assertArrayEquals(expected, assignment.sortArrayDescending(input));
	}
	@Test
	void testSortArray() {
		int[] input = {3, 1, 2};
		int[] result = assignment.sortArray(input);

		assertNotNull(result);

		assertEquals(3, result.length);

		int[] expected = {1, 2, 3};
		assertArrayEquals(expected, result);

		assertTrue(result[0] < result[1]);
	}
	
	

}
