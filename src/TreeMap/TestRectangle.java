package TreeMap;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


/**
 * This class test if Rectangle class is working properly
 * @author Risa Matsumura
 */
public class TestRectangle {

	private Rectangle r1, r2, r3;

	/**
	 * Set up all the rectangles used for this test class
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		r1 = new Rectangle(0, 0, 100, 100, "location", "size", 0);
		r2 = new Rectangle(0, 0, 5, 5, "location", "size", 0);
		r3 = new Rectangle(50, 150, 1000, 5000, "location", "size", 0);
	}

	/**
	 * Check if the rectangles gets correct widths
	 */
	@Test
	public void testGetWidth() {
		assertEquals(r1.getWidth(), 100);
		assertEquals(r2.getWidth(), 5);
		assertEquals(r3.getWidth(), 1000);
	}

	/**
	 * Check if the rectangles gets correct heights
	 */
	@Test
	public void testGetHeight() {
		assertEquals(r1.getHeight(), 100);
		assertEquals(r2.getHeight(), 5);
		assertEquals(r3.getHeight(), 5000);
	}

	/**
	 * Checks if contains method is working correctly
	 */
	@Test
	public void testContains() {
		assertTrue(r1.contains(1, 1));
		assertFalse(r2.contains(100, 100));
		assertFalse(r3.contains(5000, 5000));
		
	}
}
