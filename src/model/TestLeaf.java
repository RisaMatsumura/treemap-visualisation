package model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * This class tests if leaf objects functions properly.
 * @author Risa Matsumura
 *
 */
public class TestLeaf {
	private Leaf c1, c2, c3, c4, c5;

	@Before
	public void setUp() throws Exception {
		c1 = new Leaf("Leaf 1", 10, 0);
		c2 = new Leaf("Leaf 2", 1024, 10);
		c3 = new Leaf("Leaf 3", 1048576, 1000);
		c4 = new Leaf("Leaf 3", 1073741824, 1000);
	}

	@Test
	public void testToString() {
		assertEquals(c1.toString(), "Name: Leaf 1, Size: 10");
		assertEquals(c2.toString(), "Name: Leaf 2, Size: 1024");
		assertEquals(c3.toString(), "Name: Leaf 3, Size: 1048576");
		assertEquals(c4.toString(), "Name: Leaf 3, Size: 1073741824");
	}
	
	@Test
	public void testGetNodeSize() {
		assertEquals(c1.getNodeSize(), "10 Byte(s)");
		assertEquals(c2.getNodeSize(), "1 KB");
		assertEquals(c3.getNodeSize(), "1 MB");
		assertEquals(c4.getNodeSize(), "1 GB");
	
	}

}
