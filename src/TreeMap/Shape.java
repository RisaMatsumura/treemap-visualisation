package TreeMap;

import javax.swing.JComponent;


/**
 * Shape class provide a basic object which represent a shape.
 * 
 * @author Louis
 * @author Luke
 */
public abstract class Shape extends JComponent
{
	private int x;
	private int y;
	protected String loc;
	private String locSize;
	private int depth;
	
	/**
	 * Create a {@link Shape} object, containing x coordinate and y coordinate of origin,
	 * its location, and the size.
	 * 
	 * @param x a value representing x coordinate of origin of this Shape object
	 * @param y a value representing y coordinate of origin of this Shape object
	 * @param loc {@link String} name of the node which is associated with this shape
	 * @param size {@link String} size of the node which is associated with this shape
	 * @param depth
	 */
	public Shape (int x, int y, String loc, String size, int depth)
	{
		this.x = x;
		this.y = y;
		this.loc = loc;
		this.locSize = size;
		this.depth = depth;
	}
	
	/**
	 * Return value of {@link #x}
	 * 
	 * @return <code>int</int> x coordinate of the origin
	 */
	public int getX()
	{
		return x;
	}
	
	
	/**
	 * Return value of {@link #y}
	 * 
	 * @return <code>int</code> y coordinate of the origin
	 */
	public int getY()
	{
		return y;
	}


	/**
	 * Return {@link #loc}
	 * @return <code>String</code> name of a node which is associated with this shape
	 */
	public String getLoc()
	{
		return loc;
	}

	/**
	 * Return {@link #locSize}
	 * @return <code>String</code> size of a node which this shape represents
	 */
	public String getLocSize()
	{
		return locSize;
	}
	
	
	public int getDepth()
	{
		return depth;
	}

	
	/**
	 * Return this Shape object
	 * @return <code>Shape</code> This {@link Shape} object
	 */
	public Shape get()
	{
		return this;
	}
}
