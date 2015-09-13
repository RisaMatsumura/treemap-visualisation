package model;

import java.text.DecimalFormat;
import java.text.NumberFormat;

/**
 * Represents the Node of the DataTree.
 * 
 * @author Jonas Pikiotas
 * @author Lai Chin Chung Louis
 * @author Luke Duffy
 */
public abstract class Node implements Comparable<Node>
{
	protected String name;
	protected long size;
	protected double percentage;
	protected int depth;
	
	
	/**
	 * Default constructor to create instance of Node
	 * 
	 * @param name instance of String
	 * @param size type of long
	 * @param isParent whether the node is parent or not.
	 */
	protected Node(String name, long size, int depth)
	{
		this.name = name;
		this.size = size;
		this.depth = depth;
	}

	
	/**
	 * Return the name of the node
	 * 
	 * @return the name of the instance of Node
	 */
	public String getName()
	{
		return name;
	}
	
	
	/**
	 * Set the name of the node
	 * 
	 * @param name the name of the instance of Node
	 */
	public void setName(String name)
	{
		this.name = name;
	}
	
	
	/**
	 * Return the size of the file an instance of this node represents
	 * 
	 * @return size the size of the instance of Node
	 */
	public long getSize()
	{
		return size;
	}
	
	
	/**
	 * Set the size of the file an instance of this class represents
	 * 
	 * @param size
	 */
	public void setSize(long size)
	{
		this.size = size;
	}
	
	
	/**
	 * Return the percentage the file an instance of this node represents is of it's whole
	 * 
	 * @return the name of the instance of Node
	 */
	public double getPercentage()
	{
		return percentage;
	}
	
	
	/**
	 * Set the percentage the file an instance of this node represents is of it's whole
	 * 
	 * @return the name of the instance of Node
	 */
	public void setPercentage(double percentage)
	{
		this.percentage = percentage;
	}
	
	
	/**
	 * Return the depth the node is in the tree
	 * 
	 * @return depth The depth of node
	 */
	public int getDepth()
	{
		return depth;
	}
	
	
	/**
	 * Set the depth the node is at in the tree
	 * 
	 * @param depth The depth of node
	 */
	protected void setDepth(int depth)
	{
		this.depth = depth;
	}
	

	
	
	/**
	 * Returns the object as a String
	 */
	abstract public String toString();
	
	
	/**
	 * Performs a comparison to see which node is the larger
	 * 
	 * @param other The node this instance is going to be compared with
	 * @return result The result of the comparison
	 */
	public int compareTo(Node other)
	{
		int result;
		
		//bigger than is -1 to reverse the result of the Collections.sort in Java
		if (this.getSize() > other.getSize())
		{
			result = -1;
		}
		else if (this.getSize() < other.getSize())
		{
			result = 1;
		}
		else
		{
			result = 0;
		}
		
		return result;
	}


	/**
	 * Returns an understandable string representation of the size of the file this node represents.
	 * 
	 * @return String The size of the file this node represents
	 */
	public String getNodeSize()
	{
		long sizehere;
		if (this instanceof Leaf){
			sizehere = size;
		}else{
			sizehere = ((Parent)this).getSize();
		}
		NumberFormat nf = new DecimalFormat();
		nf.setMaximumFractionDigits(2);
		
		final double kb = 1024;
		final double mb = 1024 * kb;
		final double gb = 1024 * mb;
		final double tb = 1024 * gb;
		 
		if(sizehere < kb)
		{
			return nf.format(sizehere) + " Byte(s)";
		}
		else if(sizehere < mb)
		{
			return nf.format(sizehere/kb) + " KB";
		}
		else if(sizehere < gb)
		{
			return nf.format(sizehere/mb) + " MB";
		}
		else if(sizehere < tb)
		{
			return nf.format(sizehere/gb) + " GB";
		}
		else
		{
			return nf.format(sizehere/tb) + " TB";
		}
	}
}

