package TreeMap;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JPanel;

import view.ShapeInfoWindow;

/**
 * TreeMap contains an ArrayList {@link #listOfShapes} of {@link Shape} objects in each layer:
 * it adds an {{@link Shape} object, and paint a graphical representation of each {@link Shape} object
 * stored in {@link #listOfShapes}.
 * 
 * @author Jonas Pikiotas
 * @author Louis
 * @version
 */
public class TreeMap extends JPanel
{
	private ArrayList<ArrayList<Shape>> listOfShapes;
	private ShapeInfoWindow infoWindow;
	private int currentLayer;
	private boolean showNames;
	private ColourScheme colourScheme;

	/**
	 * Create a treemap object with an ArrayList {@link #listOfShapes},
	 * the default background colour, and the default size.
	 */
	public TreeMap()
	{
		super();
		
		listOfShapes = new ArrayList<ArrayList<Shape>>();
		listOfShapes.add(new ArrayList<Shape>());
        this.setBackground(Color.BLACK);
        this.setPreferredSize(new Dimension(670, 354));
	}
	
	
	/**
	 * add shape into an ArrayList {@link #listOfShapes}.
	 * @param layer a number representing the layer of the shape object to be added
	 * @param theShape a {@link Shape} object to be added
	 */
	public void addShape(int layer, Shape theShape)
	{
		if(layer >= listOfShapes.size())
		{
				listOfShapes.add(new ArrayList<Shape>());
		}
		listOfShapes.get(layer).add(theShape);
			this.currentLayer=listOfShapes.size();
		
	}
	
	
	/**
	 * Draw shapes based on values of each shape stored in an ArrayList {@link #listOfShapes}.
	 */
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		
		for (int i = 0 ; i<currentLayer; i++)
		{
			g.setColor(colourScheme.getColour(i%10));

			for (int j = 0; j<listOfShapes.get(i).size(); j++)
			{
				
				if (listOfShapes.get(i).get(j) instanceof Rectangle)
				{
					Rectangle current = (Rectangle) listOfShapes.get(i).get(j);
					int height = current.getHeight();
					int width = current.getWidth();
					int x = current.getX();
					int y = current.getY();
				
					g.fillRect(x, y, width, height);
				}
				else if(showNames)
				{
					TitleBar title = (TitleBar) listOfShapes.get(i).get(j);
					int titleX = title.getX();
					int titleY = title.getY();
					if(colourScheme.getColourSchemeName()=="red"||colourScheme.getColourSchemeName()=="orange"){
					g.setColor(Color.blue);
					}else{
						g.setColor(Color.red);
					}
					g.drawString(title.getBriefLoc(), titleX, titleY);
					g.setColor(colourScheme.getColour(i%10));
				}	
			}
		}
	}
	
	public void update()
	{
		this.update(getGraphics());
	}
	
	public void setLayerNum(boolean increase)
	{
		if (increase){
			if(this.currentLayer<listOfShapes.size()){
				currentLayer++;
			}
		}else{
			if(this.currentLayer>2){
				currentLayer--;
			}
		}
	}

	/**
	 * Return the treemap object
	 * @return <code>Treemap</code> this treemap object
	 */
	public TreeMap get()
	{
		return this;
	}
	
	public void setShowNames(boolean showName){
		this.showNames=showName;
	}
	
	public void initShowNames(boolean showName){
		this.showNames=showName;
	}
	
	/**
	 * Returns a list of shapes of this treemap object
	 * @return <code>ArrayList<ArrayList<Shape>></code> a nested list of shapes 
	 */
	public ArrayList<ArrayList<Shape>> getListOfShapes()
	{
		return listOfShapes;
	}
	
	public boolean getShowNames(){
		return this.showNames;
	}
	
	
	/**
	 * @author Luke
	 * @param e
	 */
	public void getShapeInfoWindow(MouseEvent e)
	{
		String string = "";
		
		for(int i =0; i<currentLayer; i++)
		{
			for(Shape shape : listOfShapes.get(i))
			{
				if(shape.contains(e.getX(), e.getY()))
				{	
					string = "Location: " + shape.getLoc() + ", Size: " + shape.getLocSize();
				}
			}
		}
		if(string==""){
			string = "this is the root folder, \nsee meta data for its details.";
		}
		infoWindow = new ShapeInfoWindow(string);
	}
	
	
	
	/**
	 * @author Luke
	 */
	public void setColourScheme(String colourSchemeChoice)
	{
		colourScheme = new ColourScheme(colourSchemeChoice);
	}
	
	/**
	 * get the name of the color scheme
	 * 
	 * @return String
	 */
	public String getColourSchemeName()
	{
		return colourScheme.getColourSchemeName();
	}
}