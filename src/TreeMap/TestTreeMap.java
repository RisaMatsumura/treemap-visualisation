package TreeMap;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * 
 * @author Risa Matsumura
 *
 */
public class TestTreeMap {
	private ArrayList<ArrayList<Shape>> listOfShapes;
	private Rectangle r1, r2, r3, r4;
	private TreeMap tm;

	@Before
	public void setUp() throws Exception {
		tm = new TreeMap();
		r1 = new Rectangle(0, 0, 100, 100, "location", "size", 0);
		r2 = new Rectangle(0, 0, 5, 5, "location", "size", 0);
		r3 = new Rectangle(50, 150, 1000, 5000, "location", "size", 0);
		r4 = new Rectangle(50, 150, 1000, 5000, "location", "size", 0);
		
		tm.addShape(0, r1);
		tm.addShape(0, r2);
		//tm.addShape(0, r3);
		//tm.addShape(0, r4);
	}

	@Test
	public void testGetListOfShapes() {
		ArrayList<ArrayList<Shape>> listOfShapes = new ArrayList<ArrayList<Shape>>();
		ArrayList<Shape> rectangles1 = new ArrayList<Shape>();
		rectangles1.add(r1);
		rectangles1.add(r2);
		listOfShapes.add(rectangles1);
		assertEquals(tm.getListOfShapes(), listOfShapes);
	}
	
	@Test
	public void testGet() {
		assertEquals(tm.get(), tm);
	}

	@Test
	public void testGetColourSchemeName() {
		ColourScheme red = new ColourScheme("red");
		ColourScheme orange = new ColourScheme("orange");
		ColourScheme green = new ColourScheme("green");
		ColourScheme blue = new ColourScheme("blue");
		ColourScheme purple = new ColourScheme("purple");
		ColourScheme bw = new ColourScheme("bw");
		
		tm.setColourScheme("red");
		assertEquals(tm.getColourSchemeName(), red.getColourSchemeName());
		tm.setColourScheme("orange");
		assertEquals(tm.getColourSchemeName(), orange.getColourSchemeName());
		tm.setColourScheme("green");
		assertEquals(tm.getColourSchemeName(), green.getColourSchemeName());
		tm.setColourScheme("blue");
		assertEquals(tm.getColourSchemeName(), blue.getColourSchemeName());
		tm.setColourScheme("purple");
		assertEquals(tm.getColourSchemeName(), purple.getColourSchemeName());
		tm.setColourScheme("bw");
		assertEquals(tm.getColourSchemeName(), bw.getColourSchemeName());
	}

}
