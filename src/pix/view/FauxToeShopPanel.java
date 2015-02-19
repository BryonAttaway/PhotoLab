package pix.view;

import java.awt.image.BufferedImage;
import javax.swing.*;
import pix.controller.FauxToeShopController;
import pixLab.classes.*;

public class FauxToeShopPanel extends JPanel
{
	public FauxToeShopPanel() {
	}
	private FauxToeShopController baseController;
	private JComboBox filterBox;
	private JComboBox imageBox;
	private JScrollPane imagePane;
	private SpringLayout baseLayout;
	private String [] imageArray;
	private Picture basePicture;
	
	public FauxToeShopPanel(FauxToeShopController baseController)
	{
		this.baseController = baseController;
		
		imagePane = new JScrollPane();
		basePicture = new Picture("beach.jpg");
		baseLayout = new SpringLayout();
		
		setupPicture();
		setupComboBox();
		setupPanel();
		setupLayout();
		setupListeners();
	}
	
	private void setupPanel()
	{
		this.baseController = baseController;
		
		imagePane = new JScrollPane();
		basePicture = new Picture();
		baseLayout = new SpringLayout();
		
		setupPicture();
		setupComboBox();
		setupPanel();
		setupLayout();
		setupListeners();
		
	}
	
	private void setupPicture()
	{
		BufferedImage bufferedPic = basePicture.getBufferedImage();
		ImageDisplay picDisplay = new ImageDisplay(bufferedPic);
		imagePane.setViewportView(picDisplay);
	}
	
	private void loadPicture()
	{
		basePicture = new Picture(imageArray[imageBox.getSelectedIndex()]);
		setupPicture();
	}
	
	private void setupComboBox()
	{
		
	}
	
	private void setupLayout()
	{
		filter = new JComboBox();
	}
	
	private void setupListeners()
	{
		filterBox.addItemListener(new ItemListener()
		{
			
			@Override
			public void itemStateChanged(ItemEvent currentEvent)
			{
				if(filterBox.getSelectedIndex() == 1)
				{
					basePicture.randomChange();
					setupPicture();
				}
				else if(filterBox.getSelectedIndex() == 2)
				{
					basePicture.checkerboardFilter();
					setupPicture();
				}
				else if(filterBox.getSelectedIndex() == 3)
				{
					basePicture.checkerboardFilterBig();
				}
			}
		});
	}
}
