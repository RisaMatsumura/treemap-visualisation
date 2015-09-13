package utility;
import java.io.File;

import model.DataTree;
import model.Parent;
import TreeMap.TreeMap;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class TestStrip {
	private static File file;
	private DataTree dt;
	private TreeMap tm;
	private Strip st;
	private Parent root;
	
	@Before
	public void setUp() throws Exception {
		file = new File("TestDirectory");
		dt = DataTree.getInstance(file);
		root = dt.getTop();
		tm = new TreeMap();
		
		st = new Strip(dt, tm, false);
	}

	@Test
	public void testRunAlgorithm() {
		assertEquals(st.runAlgorithm(), tm);
	}

}
