package utility;

import model.DataTree;
import TreeMap.TreeMap;

/**
 * Algorithm class is an attract super class of all algorithms
 * 
 * @author Louis
 */

public abstract class Algorithm {

	//common fields of all the algorithm classes
	protected int height = 379;
	protected int width = 668;
	protected DataTree dataTree;
	protected TreeMap treeMap;
	protected boolean nested;
	
	//the border width of rectangles within the same layer
	protected int sameLayerB=1;

	/**
	 * add shapes to tree map according to the algorithm 
	 * @return tree map
	 */
	public abstract TreeMap runAlgorithm();
}
