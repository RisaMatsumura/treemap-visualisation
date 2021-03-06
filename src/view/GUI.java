package view;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import TreeMap.TreeMap;
import utility.Controller;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Graphical User Interface and visual view of the application.
 * @author Jonas Pikiotas
 * @author Lai Chin Chung Louis
 * @version 1.0 
 */

public class GUI
{
	/**
	 * Creates the Graphical User Interface and displays it on the screen.
	 */
	public static void main(String[] args)
	{
		GUI a = new GUI();
	}

	private static JFrame mainFrame;
	private JButton runButton;
	private JButton openButton;
	private JButton infoButton;
	private JButton saveButton;
	private JButton deleteButton;
	private JButton upButton;
	private JButton downButton;
	private JRadioButton sliceDice;
	private JRadioButton squarified;
	private JRadioButton strip;
	private JCheckBox nested;
	private JCheckBox showNames;
	private JLabel loading;
	private JTextField rootPath;
	private JToolBar toolbar;
	private JComboBox<String> colourSchemeList;
	private JTabbedPane tabbedPane;

	private Runnable runnable;

	private File rootFile;
	private Controller controller;
	private Map<Component, Component> treeMaps;

	/**
	 * Constructor
	 */
	public GUI()
	{
		//creating components
		toolbar = new JToolBar();
		tabbedPane = new JTabbedPane();
		treeMaps = new HashMap<Component,Component>();

		infoButton = new JButton(createImageIcon("/images/info.png"));
		openButton = new JButton(createImageIcon("/images/open.png"));
		runButton = new JButton(createImageIcon("/images/run.png"));
		saveButton = new JButton(createImageIcon("/images/save.png"));
		deleteButton = new JButton(createImageIcon("/images/delete.png"));
		upButton = new JButton(createImageIcon("/images/plus.png"));
		downButton = new JButton(createImageIcon("/images/minus.png"));

		String[] colourSchemeStrings = { "Black and white", "Red", "Orange", "Green", "Blue", "Purple" };
		colourSchemeList = new JComboBox<String>(colourSchemeStrings);
		colourSchemeList.setSelectedIndex(0);
		colourSchemeList.setSize(50, toolbar.getHeight());

		loading = new JLabel(createImageIcon("/images/loading.gif"));
		rootPath = new JTextField(47);

		sliceDice = new JRadioButton("Slice and Dice");
		squarified = new JRadioButton("Squarified");
		strip = new JRadioButton("Strip");
		nested = new JCheckBox("Nested");
		showNames = new JCheckBox("Show names");

		//setting properties of the components
		runButton.setToolTipText("Traverse the root folder");
		openButton.setToolTipText("Choose the root folder");
		saveButton.setToolTipText("Save A tree map on the current tab");
		deleteButton.setToolTipText("Delete a tab");
		upButton.setToolTipText("increase one layer");
		downButton.setToolTipText("decrease one layer");

		rootPath.setText("Select Root directory...");
		rootPath.setFont(new Font("Serif", Font.BOLD, 16));
		rootPath.setEditable(false);

		sliceDice.setSelected(true);

		//grouping radio buttons
		final ButtonGroup group = new ButtonGroup();
		group.add(sliceDice);
		group.add(squarified);
		group.add(strip);
		//creating containers
		mainFrame = new JFrame("Testing");

		JPanel rootBox = new JPanel();
		JPanel algorithmBox = new JPanel();
		JPanel choiceBox = new JPanel();
		JPanel checkBox = new JPanel();

		//helper panes for a margin
		JPanel marginPane1 = new JPanel();
		JPanel marginPane2 = new JPanel();
		JPanel marginPane3 = new JPanel();

		//Specifying Layout Managers
		mainFrame.getContentPane().setLayout(new BorderLayout());
		rootBox.setLayout(new BorderLayout());
		algorithmBox.setLayout(new FlowLayout());
		checkBox.setLayout(new FlowLayout());
		choiceBox.setLayout(new BorderLayout());

		//Adding components to the containers
		toolbar.add(runButton);
		toolbar.add(deleteButton);
		toolbar.add(saveButton);
		toolbar.add(upButton);
		toolbar.add(downButton);
		toolbar.add(showNames);
		toolbar.add(colourSchemeList);
		toolbar.add(infoButton);


		algorithmBox.add(sliceDice);
		algorithmBox.add(squarified);
		algorithmBox.add(strip);

		checkBox.add(nested);

		choiceBox.add(algorithmBox, BorderLayout.WEST);
		choiceBox.add(checkBox, BorderLayout.EAST);

		rootBox.add(rootPath, BorderLayout.WEST);
		rootBox.add(openButton, BorderLayout.AFTER_LINE_ENDS);
		rootBox.add(toolbar, BorderLayout.NORTH);
		rootBox.add(choiceBox, BorderLayout.SOUTH);	

		mainFrame.getContentPane().add(rootBox, BorderLayout.NORTH);
		mainFrame.getContentPane().add(tabbedPane, BorderLayout.CENTER);
		mainFrame.getContentPane().add(marginPane1, BorderLayout.SOUTH);
		mainFrame.getContentPane().add(marginPane2, BorderLayout.EAST);
		mainFrame.getContentPane().add(marginPane3, BorderLayout.WEST);






		//Event handling
		mainFrame.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);

		mainFrame.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				exitApp();
			}
		});


		openButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){

				JFileChooser chooser = new JFileChooser();
				chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
				int returnVal = chooser.showOpenDialog(mainFrame);

				rootFile = chooser.getSelectedFile();

				if(returnVal == JFileChooser.APPROVE_OPTION){
					if (rootFile.exists()){
						rootPath.setText(rootFile.getPath());
					}else{
						JOptionPane.showMessageDialog(mainFrame, "File path invalid, please choose another one.",
								"Error!", JOptionPane.ERROR_MESSAGE);
					}
				}

			}
		});

		runButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if(rootPath.getText().contains("Select Root directory...")){
					JOptionPane.showMessageDialog(mainFrame, "You need to select root folder first!", 
							"Error!", JOptionPane.ERROR_MESSAGE);
				} else {
					tabbedPane.addTab(getSelectedAlgorithm(), loading);
					tabbedPane.setSelectedIndex(tabbedPane.getTabCount() - 1);
					addTreeMap();
				}
			}
		}
				);

		infoButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				JOptionPane.showMessageDialog(mainFrame, "Visualation Tool Version 3.0\n\n" +
						"Team Members:\n\n" +
						"Luke Duffy\n" +
						"Lai Chin Chung Louis\n" +
						"Risa Matsumura\n" +
						"David Ling\n" +
						"Jonas Pikiotas", 
						"Information", JOptionPane.INFORMATION_MESSAGE);
			}
		});

		saveButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if(treeMaps.size()==0|| tabbedPane.getTabCount()==0){
					JOptionPane.showMessageDialog(mainFrame, "You need to generate a tree map first!",
							"Error!", JOptionPane.ERROR_MESSAGE);
				} else {
					saveImage(tabbedPane.getSelectedComponent());
				}
			}
		});

		deleteButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if(tabbedPane.getTabCount() == 0){
					JOptionPane.showMessageDialog(mainFrame, "No tabs to delete",
							"Error!", JOptionPane.INFORMATION_MESSAGE);
				} else {
					tabbedPane.remove(tabbedPane.getSelectedComponent());
					runnable.getClass();

				}
			}
		});

		upButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if(treeMaps.size()==0|| tabbedPane.getTabCount()==0){
					JOptionPane.showMessageDialog(mainFrame, "You need to generate a tree map first!",
							"Error!", JOptionPane.ERROR_MESSAGE);
				} else {
					((TreeMap) treeMaps.get(tabbedPane.getSelectedComponent())).setLayerNum(true);
					((TreeMap) treeMaps.get(tabbedPane.getSelectedComponent())).update();
				}
			}
		});

		downButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if(treeMaps.size()==0 || tabbedPane.getTabCount()==0){
					JOptionPane.showMessageDialog(mainFrame, "You need to generate a tree map first!",
							"Error!", JOptionPane.ERROR_MESSAGE);
				} else {
					((TreeMap) treeMaps.get(tabbedPane.getSelectedComponent())).setLayerNum(false);
					((TreeMap) treeMaps.get(tabbedPane.getSelectedComponent())).update();
				}
			}
		});

		showNames.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if(treeMaps.size()==0 || tabbedPane.getTabCount()==0){
				} else {
					if(showNames.isSelected()){
						((TreeMap) treeMaps.get(tabbedPane.getSelectedComponent())).setShowNames(true);
						((TreeMap) treeMaps.get(tabbedPane.getSelectedComponent())).update();
					}else{
						((TreeMap) treeMaps.get(tabbedPane.getSelectedComponent())).setShowNames(false);
						((TreeMap) treeMaps.get(tabbedPane.getSelectedComponent())).update();
					}
				}
			}
		});

		colourSchemeList.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if(treeMaps.size()==0 || tabbedPane.getTabCount()==0){
				} else {
					String colorSchemeTM = ((TreeMap) treeMaps.get(tabbedPane.getSelectedComponent())).getColourSchemeName();
					if(!getColourScheme().equals(colorSchemeTM)){
						((TreeMap) treeMaps.get(tabbedPane.getSelectedComponent())).setColourScheme(getColourScheme());
						((TreeMap) treeMaps.get(tabbedPane.getSelectedComponent())).update();
					}
				}
			}
		});

		tabbedPane.addChangeListener(new ChangeListener(){
			public void stateChanged(ChangeEvent e) {
				try{
					showNames.setSelected(((TreeMap) treeMaps.get(tabbedPane.getSelectedComponent())).getShowNames());
					setColourScheme(((TreeMap) treeMaps.get(tabbedPane.getSelectedComponent())).getColourSchemeName());
				}catch(Exception f){

				}
			}
		});

		//display the GUI
		mainFrame.setPreferredSize(new Dimension(830, 575));
		mainFrame.setResizable(false);
		mainFrame.pack();
		mainFrame.setVisible(true);
	}

	/**
	 * Function that shows JOptionPane Dialog before closing the program
	 */
	private void exitApp(){
		int response = JOptionPane.showConfirmDialog(mainFrame, "Do you really want to quit?", 
				"Quit?", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

		if(response == JOptionPane.YES_OPTION){
			System.exit(0);
		}

	}
	/**
	 * Checks if the image path is valid and fetches the image
	 * @param path where the image is located
	 * @return ImageIcon or null if the path was invalid
	 */
	private ImageIcon createImageIcon(String path){

		java.net.URL imgURL = GUI.class.getResource(path);
		if(imgURL != null){
			return new ImageIcon(imgURL);
		} else {
			JOptionPane.showMessageDialog(mainFrame, "Couldn't find the images, exiting the program...", 
					"Error!", JOptionPane.ERROR_MESSAGE);
			System.exit(1);
			return null;
		}
	}

	/**
	 * Checks which algorithm user chose
	 * @return the number associated with chosen algorithm
	 */
	private String getSelectedAlgorithm()
	{
		String alg;

		if(sliceDice.isSelected()){
			alg = "Slice and Dice";
		} else if(squarified.isSelected()){
			alg = "Squarified";
		} else {
			alg = "Strip";
		}

		return alg;
	}


	/**
	 * 
	 * @return ColourScheme in String
	 */
	private String getColourScheme()
	{
		if(colourSchemeList.getSelectedItem().equals("Black and white"))
		{
			return "bw";
		}
		else if(colourSchemeList.getSelectedItem().equals("Red"))
		{
			return "red";
		}
		else if(colourSchemeList.getSelectedItem().equals("Orange"))
		{
			return "orange";
		}
		else if(colourSchemeList.getSelectedItem().equals("Green"))
		{
			return "green";
		}
		else if(colourSchemeList.getSelectedItem().equals("Blue"))
		{
			return "blue";
		}
		else if(colourSchemeList.getSelectedItem().equals("Purple"))
		{
			return "purple";
		}
		return null;
	}

	/**
	 * 
	 * @param name of the color scheme
	 */
	private void setColourScheme(String name){
		if(name.equals("bw"))
		{
			colourSchemeList.setSelectedIndex(0);
		}
		else if(name.equals("red"))
		{
			colourSchemeList.setSelectedIndex(1);
		}
		else if(name.equals("orange"))
		{
			colourSchemeList.setSelectedIndex(2);
		}
		else if(name.equals("green"))
		{
			colourSchemeList.setSelectedIndex(3);
		}
		else if(name.equals("blue"))
		{
			colourSchemeList.setSelectedIndex(4);
		}
		else if(name.equals("purple"))
		{
			colourSchemeList.setSelectedIndex(5);
		}
	}


	/**
	 * includes what needs to be done after the user click the run button
	 */
	private void addTreeMap()
	{	
		runnable = new Thread()
		{
			@Override
			public void run()
			{
				JPanel tab = new JPanel();

				controller = new Controller(rootFile, getSelectedAlgorithm(), getColourScheme(), nested.isSelected());
				final TreeMap treeMap = controller.getTreeMap();
				treeMap.initShowNames(showNames.isSelected());
				treeMap.setColourScheme(getColourScheme());
				JTextArea metaData = new JTextArea(20, 10);
				JLabel folderInfo = new JLabel(rootPath.getText());

				metaData.setMargin(new Insets(5, 5, 5, 5));
				metaData.setEditable(false);
				folderInfo.setFont(new Font("Serif", Font.BOLD, 12));

				treeMaps.put(tab, treeMap);

				tab.setLayout(new BorderLayout());
				tab.add(metaData, BorderLayout.WEST);
				tab.add(treeMaps.get(tab), BorderLayout.EAST);
				tab.add(folderInfo, BorderLayout.NORTH);

				metaData.setText("Root Folder Size:\n" + controller.getDataTree().getRootFolderSize());
				metaData.append("\n\nNumber of Folders:\n" + controller.getDataTree().getNumberOfFolders());
				metaData.append("\n\nNumber of Files:\n" + controller.getDataTree().getNumberOfFiles());

				tabbedPane.remove(tabbedPane.getTabCount() - 1);
				tabbedPane.addTab(getSelectedAlgorithm(), tab);
				tabbedPane.setSelectedIndex(tabbedPane.getTabCount() - 1);


				treeMap.addMouseListener(new MouseAdapter()
				{
					@Override
					public void mouseClicked(MouseEvent e)
					{
						((TreeMap) treeMap).getShapeInfoWindow(e);
					}
				});
			}
		};
		new Thread(runnable).start();
	}

	/**
	 * save the image of a component
	 * @param component needs to be saved
	 */
	private void saveImage(Component component)
	{
		BufferedImage buffImage = new BufferedImage(component.getSize().width, component.getSize().height, BufferedImage.TYPE_INT_RGB);
		component.paint(buffImage.createGraphics());
		File image = new File(getSelectedAlgorithm() + ".png");

		JFileChooser chooser = new JFileChooser();
		chooser.setSelectedFile(image);
		int returnVal = chooser.showSaveDialog(mainFrame);
		if(returnVal == JFileChooser.APPROVE_OPTION)
		{
			image = chooser.getSelectedFile();
		}

		try
		{
			image.createNewFile();
			ImageIO.write(buffImage, "png", image);
		}
		catch (IOException e) { }
	}

	/**
	 * get the position of the GUI
	 * @return X
	 */
	public static int getGUIX(){
		return mainFrame.getX();
	}

	/**
	 * get the position of the GUI
	 * @return X
	 */
	public static int getGUIY(){
		return mainFrame.getY();
	}
}
