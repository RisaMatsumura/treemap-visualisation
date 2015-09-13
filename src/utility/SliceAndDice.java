package utility;

import java.util.List;

import TreeMap.*;
import model.*;

/**
 * SliceAndDice class get the data from the DataTree and build the field listOfShapes
 * int the TreeMap class. Part this method is copied from the test project "Shapes"
 * written by Risa
 * 
 * @author Louis, Luke, Risa
 *
 */
public class SliceAndDice extends Algorithm{

	protected int diffLayerB=0;

	/**
	 * Create a SliceAndDice object with an DataTree, a TreeMap, 
	 * and a boolean showing whether the treeMap is nested or not
	 */
	public SliceAndDice (DataTree theDataTree, TreeMap treeMap, boolean nested)
	{
		dataTree = theDataTree;
		this.treeMap = treeMap;
		if (nested){
			diffLayerB=4;
		}
		//result = new ArrayList<int[]>();
	}

	/**
	 * the common method in all the algorithm classes
	 * @return TreeMap
	 */
	public TreeMap runAlgorithm(){
		applyRule (2, 2, width, height, Sorter.sort(dataTree.getTop()), true);
		return treeMap;

	}

	/**
	 * a private method used to add Shapes object to the treeMap class recursively
	 * 
	 * @param x
	 * @param y
	 * @param width
	 * @param height
	 * @param node
	 * @param isOdd
	 */
	private void applyRule(int x, int y, int width, int height, Node node, boolean isOdd)
	{
		List<Node> children = ((Parent) node).getContents();
		int currentWidth = width;
		int currentHeight = height;
		int currentX = x;
		int currentY = y;


		for(Node child : children)
		{
			Rectangle main;
			TitleBar title;
			//the boolean isOdd decides how the rectangle is divided (vertically/horizontally)
			if(isOdd)
			{
				currentWidth = (int) (width * child.getPercentage());		// width x node %

				//add a rectangle only when its width is bigger than 1 pixels
				if (currentWidth>1){
					main = new Rectangle(currentX+sameLayerB, currentY+sameLayerB, currentWidth-sameLayerB-sameLayerB, currentHeight-sameLayerB-sameLayerB, child.getName(), child.getNodeSize(), child.getDepth());
					treeMap.addShape(child.getDepth(), main);

					//add the name of the folder/file only when there are enough space
					if(currentHeight>14){
						title = new TitleBar(currentX+sameLayerB+diffLayerB, currentY+sameLayerB+diffLayerB+10, currentWidth-sameLayerB-sameLayerB, 10, child.getName(), child.getNodeSize(), child.getDepth());
						treeMap.addShape(child.getDepth(), title);
					}

					//apply recursion
					if(child instanceof Parent)
					{
						applyRule(currentX+diffLayerB, currentY+diffLayerB, currentWidth-diffLayerB-diffLayerB, currentHeight-diffLayerB-diffLayerB, child, !(isOdd));
					}
					//relocate the starting point
					currentX += currentWidth;
				}
			}
			else if(!isOdd)
			{
				currentHeight = (int) (height * child.getPercentage());
				if (currentHeight>1){

					main = new Rectangle(currentX+sameLayerB, currentY+sameLayerB, currentWidth-sameLayerB-sameLayerB, currentHeight-sameLayerB-sameLayerB, child.getName(), child.getNodeSize(), child.getDepth());
					treeMap.addShape(child.getDepth(), main);
					if(currentHeight>14){
						title = new TitleBar(currentX+sameLayerB+diffLayerB, currentY+sameLayerB+diffLayerB+10, currentWidth-sameLayerB-sameLayerB, 10, child.getName(), child.getNodeSize(), child.getDepth());
						treeMap.addShape(child.getDepth(), title);
					}

					if(child instanceof Parent)
					{
						applyRule(currentX+diffLayerB, currentY+diffLayerB, currentWidth-diffLayerB*2, currentHeight-diffLayerB*2, child, !(isOdd));
					}
					currentY += currentHeight;
				}
			}



		}
	}


}



