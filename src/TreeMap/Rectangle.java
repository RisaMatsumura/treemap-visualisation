package TreeMap;


/**
 * Shape class provide a basic object which represent a rectangle.
 * 
 * @author Louis
 * @author Luke Duffy
 */
public class Rectangle extends Shape
{
	private int width;
	private int height;
	
	
	/**
	 * Default constructor for a Rectangle
	 * 
	 * @param x The location on the x axis where this shape will be drawn.
	 * @param y The location on the y axis there this shape will be drawn.
	 * @param width The width of this shape
	 * @param height The height of this shape
	 * @param loc The location in memory this shape represents
	 * @param locSize The size of the location in memory this shape represents
	 * @param depth The depth of the location in memory this shape represents is in the file system hierarchy
	 */
	public Rectangle(int x,int y,int width,int height, String loc, String locSize, int depth)
	{
		super(x, y, loc, locSize, depth);
		this.width = width;
		this.height = height;
	}
	
	
	/**
	 * Returns the width of a rectangle
	 * 
	 * @return width
	 */
	public int getWidth()
	{
		return width;
	}
	
	
	/**
	 * Returns the height of a rectangle
	 * 
	 * @return height
	 */
	public int getHeight()
	{
		return height;
	}
	

	/**
	 * Performs a check to see if a click on the GUI is within the boundary of this rectangle
	 * 
	 * @param eX X coordinate where the event occurred
	 * @param eY Y coordinate where the event occurred
	 * @return boolean
	 */
	public boolean contains(int eX, int eY)
	{
		if(((eX >= super.getX()) && (eX <= (super.getX() + width))) && ((eY >= super.getY()) && (eY <= (super.getY() + height))))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
}

	/**indicating whether this contains the two points

	 * @return boolean 
	 */
