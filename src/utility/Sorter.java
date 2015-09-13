package utility;
import java.util.ArrayList;
import java.util.Collections;

import model.*;

/**
 * Sorter class is used to sort the dataTree in descending order. 
 * All children under parents all sorted
 * 
 * @author Louis
 */
public class Sorter{

	/**
	 * takes a parent and return a sorted parent
	 * @return Parent
	 */
	public static Parent sort(Parent topParent){
		ArrayList<Node> current = topParent.getContents();
		//sort the direct children
		current = sortArrayList(current);
		
		//recursion
		for (int i=0; i<current.size(); i++){
			if (current.get(i) instanceof Parent){
				sort((Parent)current.get(i));
			}

		}
		return topParent;
	}
	//a private method for sorting an ArrayList
	private static ArrayList<Node> sortArrayList(ArrayList<Node> allChild){
		Collections.sort(allChild);
		return allChild;
	}

}