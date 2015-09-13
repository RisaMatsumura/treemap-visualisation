package utility;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;

import TreeMap.*;
import model.*;

public class Strip extends Algorithm{

	/**
	 * Strip class get the data from the DataTree and build the field listOfShapes
	 * int the TreeMap class.For more detailed commenting, take a look at the Squarified class, 
	 * because Strip is only a reverse of it.
	 * 
	 * @author Louis
	 * @version
	 */

	protected int diffLayerB=0;

	/**
	 * Create a Strip object with an DataTree, a TreeMap, 
	 * and a boolean showing whether the treeMap is nested or not
	 */

	public Strip (DataTree theDataTree, TreeMap treeMap, boolean nested)
	{
		dataTree = theDataTree;
		this.treeMap = treeMap;
		if (nested){
			diffLayerB=4;
		}
	}

	/**
	 * it modified the treeMap, adding content to the listOfShapes(field) in TreeMap
	 * @return TreeMap
	 */

	public TreeMap runAlgorithm(){
		applyRule (2, 2, width, height, Sorter.sort(dataTree.getTop()));
		return treeMap;

	}

	/**
	 * it modified the treeMap using recursion
	 * @param x, the x coordinate of the current rectangle
	 * @param y, the y coordinate of the current rectangle
	 * @param width, the width of the current rectangle
	 * @param height, the height of the current rectangle
	 * @param node, the node that current rectangle represents
	 * @return void
	 */

	private void applyRule(int x, int y, int width, int height, Node node)
	{
		List<Node> children = ((Parent) node).getContents();
		children.add(new Leaf("",0, 1));
		int currentWidth = width;
		int currentHeight = height;
		int currentX = x;
		int currentY = y;
		int nowX = x;
		int nowY = y;
		int count=0;
		int previous=0;
		int marker=0;


		double totalArea=0;
		double firstArea=0;
		double oldRatio =1;
		double fixD =0;

		boolean drawing=false;

		while (count<children.size()){
			int changedWidth=0;
			int changedHeight=0;
			//System.out.println("\ncount: "+count+" previous: "+previous+" marker: "+marker);
			Node child = children.get(count);
			double area = width*height*child.getPercentage();

			if(count==marker){
				firstArea=area;
				fixD = fix(currentHeight, currentWidth, firstArea);
			}
			if(!drawing){
				totalArea += area;
				double fixDNow = fixD*firstArea/totalArea;
				double nfixD = firstArea/fixDNow;
				double newRatio = correctedRatio(fixDNow/nfixD);
				if(newRatio<oldRatio){
					//continue looping
					oldRatio = newRatio;

				}else{
					totalArea-=area;
					drawing=true;
					previous=count;
					count = marker;
					oldRatio=1;
					continue;
					//start drawing
				}
			}else{
				if(currentHeight==fixD){
					double nowHeight = currentHeight*area/totalArea;
					changedWidth = toInt(area/nowHeight);
					int hWithBorder = toInt(nowHeight-sameLayerB*2);
					int wWithBorder = changedWidth-sameLayerB*2;
					if(hWithBorder<=height&&wWithBorder<=currentWidth&&currentX<x+width&&nowY<y+height){
						treeMap.addShape(child.getDepth(), new Rectangle(currentX+sameLayerB, nowY+sameLayerB, wWithBorder, hWithBorder, child.getName(), child.getNodeSize(), child.getDepth()));
						if(nowHeight>14){
							TitleBar title = new TitleBar(currentX+sameLayerB+diffLayerB, nowY+sameLayerB+diffLayerB+10, wWithBorder, 10, child.getName(), child.getNodeSize(), child.getDepth());
							treeMap.addShape(child.getDepth(), title);
						}
						if(child instanceof Parent){
							applyRule(currentX+diffLayerB, nowY+diffLayerB,changedWidth-diffLayerB*2, toInt(nowHeight-diffLayerB*2) , child);
						}

						nowY += nowHeight;
					}

				}else{
					double nowWidth = currentWidth*area/totalArea;
					changedHeight = toInt(area/nowWidth);
					int hWithBorder = changedHeight-sameLayerB*2;
					int wWithBorder = toInt(nowWidth-sameLayerB*2);
					if(hWithBorder<=currentHeight&&wWithBorder<=width&&nowX<x+width&&currentY<y+height){
						treeMap.addShape(child.getDepth(), new Rectangle(nowX+sameLayerB, currentY+sameLayerB, wWithBorder, hWithBorder, child.getName(), child.getNodeSize(), child.getDepth()));	
						if(changedHeight>14){
							TitleBar title = new TitleBar(nowX+sameLayerB+diffLayerB, currentY+sameLayerB+diffLayerB+10, wWithBorder, 10, child.getName(), child.getNodeSize(), child.getDepth());
							treeMap.addShape(child.getDepth(), title);
						}

						if(child instanceof Parent){
							applyRule(nowX+diffLayerB, currentY+diffLayerB, toInt(nowWidth-diffLayerB*2), changedHeight-diffLayerB*2 , child);
						}

						nowX += nowWidth;
					}
				}
			}
			//finish drawing
			if (count==previous-1){
				currentWidth -= changedWidth;
				currentHeight -= changedHeight;
				currentX += changedWidth;
				currentY += changedHeight;
				nowY=currentY;
				nowX=currentX;
				totalArea=0;
				marker=previous;
				drawing = false;
				fixD=0;
			}
			count++;
		}


	}

	private double fix(double height, double width, double area){
		double ratio1 = correctedRatio(height*height/area);
		double ratio2 = correctedRatio(width*width/area);
		if(ratio1<ratio2){
			return width;
		}else{
			return height;
		}
	}

	private double correctedRatio(double ratio){
		if(ratio>1){
			return 1/ratio;
		}else{
			return ratio;
		}
	}

	private int toInt(double doubleNum){
		return Math.round((float)doubleNum);
	}

}



