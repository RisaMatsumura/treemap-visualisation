package model;

/**
 * Represents a child node of the Data Structure.
 * 
 * @author Jonas Pikiotas
 * @author Lai Chin Chung Louis
 * 
 */
public class Leaf extends Node
{
	/**
	 * Default Constructor to create a Child object with three parameters.
	 * 
	 * @param name instance of String
	 * @param size type of long
	 * @param depth of the child
	 */
	public Leaf(String name, long size, int depth)
	{
		super(name, size, depth);	
	}

	
	/**
	 * Returns this object as a string.
	 * 
	 * @return String containing information contained in an instance of this class
	 */
	public String toString()
	{
		return "Name: " + name + ", Size: " + size;
	}
}
