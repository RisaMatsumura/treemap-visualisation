package utility;
import java.io.File;

import model.DataTree;
import model.Parent;
import TreeMap.Rectangle;
import TreeMap.TreeMap;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class TestSliceAndDice {
	private static File root;
	private DataTree dt;
	private TreeMap tm;
	private SliceAndDice sd;
	
	@Before
	public void setUp() throws Exception {
		root = new File("TestDirectory");
		dt = DataTree.getInstance(root);
		tm = new TreeMap();
		Rectangle r1 = new Rectangle(0, 0, 100, 200, "Location", "Location size",  0);
		Rectangle r2 = new Rectangle(100, 0, 100, 200, "Location", "Location size",  0);
		Rectangle r3 = new Rectangle(0, 200, 100, 200, "Location", "Location size",  0);
		Rectangle r4 = new Rectangle(100, 200, 100, 200, "Location", "Location size",  0);
		tm.addShape(0, r1);
		tm.addShape(0, r2);
		tm.addShape(0, r3);
		tm.addShape(0, r4);
		
		sd = new SliceAndDice(dt, tm, false);
	}

	@Test
	public void testRunAlgorithm() {
		assertEquals(sd.runAlgorithm().getListOfShapes(), tm.getListOfShapes());
	}

}
