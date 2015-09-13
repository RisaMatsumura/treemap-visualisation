package view;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.*;


/**
 * ShapeInfoWindow class is about the pop up window
 * when the user click on the tree map
 * 
 * @author Luke
 *
 */
public class ShapeInfoWindow
{
	private String info;

	private JFrame mainFrame;
	private JPanel panel;
	private JLabel label;
	private JButton okButton;

	/**create a window containing the information
	 * 
	 * @param info
	 */
	public ShapeInfoWindow(String info)
	{
		panel = new JPanel();
		label = new JLabel(info);
		okButton = new JButton("OK");

		//panel.setPreferredSize(new Dimension(200, 150));

		mainFrame = new JFrame("Testing");
		mainFrame.getContentPane().setLayout(new BorderLayout());
		mainFrame.getContentPane().add(label, BorderLayout.CENTER);
		mainFrame.getContentPane().add(okButton, BorderLayout.SOUTH);


		mainFrame.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);

		mainFrame.addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent e)
			{
				close();
			}
		});

		okButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				close();
			}
		});


		//mainFrame.setPreferredSize(new Dimension(200, 150));
		mainFrame.setResizable(false);
		mainFrame.setLocation(GUI.getGUIX()+320, GUI.getGUIY()+250);
		mainFrame.pack();
		mainFrame.setVisible(true);
	}

	
	/**
	 * close the window
	 */
	private void close()
	{
		mainFrame.dispose();
	}
}










