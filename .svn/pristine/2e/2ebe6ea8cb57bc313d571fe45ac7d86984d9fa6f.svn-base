package utility;
import java.io.File;

import model.DataTree;
import model.Parent;
import TreeMap.TreeMap;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestSquarified {
	private static File file;
	private DataTree dt;
	private TreeMap tm;
	private Squarified sq;
	private Parent root;
	
	@Before
	public void setUp() throws Exception {
		file = new File("TestDirectory");
		dt = DataTree.getInstance(file);
		root = dt.getTop();
		tm = new TreeMap();
		
		sq = new Squarified(dt, tm, false);
	}

	@Test
	public void testRunAlgorithm() {
		assertEquals(sq.runAlgorithm(), tm);
	}

}