package TreeMap;


/**
<<<<<<< .mine
 * Shape class provide a basic object which represent a title bar for a shape.
 * 
=======
 * Shape class provide a basic object which represent the name of a rectangle.
>>>>>>> .r120
 * @author Louis
<<<<<<< .mine
 * @author Luke Duffy
=======
 * @author Risa
 *
>>>>>>> .r120
 */
public class TitleBar extends Shape
{
	private int width;
	private int height;


	/**
	 * Create a TitleBar object with all it properties
	 */
	/**
	 * Default constructor for a Title Bar
	 * 
	 * @param x The location on the x axis where this shape will be drawn.
	 * @param y The location on the y axis there this shape will be drawn.
	 * @param width The width of this shape
	 * @param height The height of this shape
	 * @param loc The location in memory this shape represents
	 * @param locSize The size of the location in memory this shape represents
	 * @param depth The depth of the location in memory this shape represents is in the file system hierarchy
	 */
	public TitleBar(int x,int y,int width,int height, String loc, String locSize, int depth)
	{
		super(x, y, loc, locSize, depth);
		this.width = width;
		this.height = height;
	}

	/**
	 *  @return width
	 */
	
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
	 * @return height
	 */
	/**
	 * Returns the height of a rectangle
	 * 
	 * @return height
	 */
	public int getHeight()
	{
		return height;
	}

	/**get the String displayed on the treeMap
	 * 
	 * @return String file name
	 */
	
	/**
	 * 
	 * 
	 * @return
	 */
	public String getBriefLoc(){
		if (this.width<5){
			return " ";
		}else{
			if(this.loc.length()<(this.width-4)/7){
				return this.loc;
			}
			return this.loc.substring(0, (this.width-4)/7)+"..";
		}
	}
	
	
	/**
	 * Performs a check to see if a click on the GUI is within the boundary of this rectangle
	 * 
	 * @return boolean
	 */
	/**indicating whether this contains the two points
	 * @param eX
	 * @param eY
	 * @return boolean 
	 */
	public boolean contains(int eX, int eY)
	{
		if(((eX >= super.getX())&&(eX <= (super.getX() + width)))&&((eY >= super.getY())&&(eY <= (super.getY() + height))))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
}