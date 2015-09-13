package TreeMap;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestTitleBar {
	private TitleBar tb1, tb2, tb3;

	/**
	 * Set up all the TitleBars used for this test class
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		tb1 = new TitleBar(0, 0, 100, 100, "location", "size", 0);
		tb2 = new TitleBar(0, 0, 5, 5, "location", "size", 0);
		tb3 = new TitleBar(50, 150, 1000, 5000, "location", "size", 0);
	}

	/**
	 * Check if the TitleBars gets correct widths
	 */
	@Test
	public void testGetWidth() {
		assertEquals(tb1.getWidth(), 100);
		assertEquals(tb2.getWidth(), 5);
		assertEquals(tb3.getWidth(), 1000);
	}

	/**
	 * Check if the TitleBars gets correct heights
	 */
	@Test
	public void testGetHeight() {
		assertEquals(tb1.getHeight(), 100);
		assertEquals(tb2.getHeight(), 5);
		assertEquals(tb3.getHeight(), 5000);
	}

	/**
	 * Checks if contains method is working correctly
	 */
	@Test
	public void testContains() {
		assertTrue(tb1.contains(1, 1));
		assertFalse(tb2.contains(100, 100));
		assertFalse(tb3.contains(5000, 5000));		
	}
	
	/**
	 * 
	 */
}
