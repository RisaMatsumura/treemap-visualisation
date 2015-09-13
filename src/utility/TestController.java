package utility;

import model.*;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import java.io.File;

public class TestController {
	private File file;
	private Controller c1, c2;
	
	/**
	 * Set up a controller with a test directory, slice and dice algorithm,
	 * and non-nesting.
	 * 
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		file = new File("TestDirectory"); 
		c1 = new Controller(file, "Slice and Dice", "red", false);
		c2 = new Controller(file, "Squarified", "red", false);
	}
	
	@Test
	public void testGetDataTree() {
		
	}

	@Test
	public void testGetTreeMap() {
		DataTree testDataTree = c1.getDataTree();
		Parent top = testDataTree.getTop();
		assertEquals(top.getName(), "TestDirectory");
		assertEquals(top.getDepth(), 1);
		top.getContents();
	}
}
