package jsap;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JPanel;


public class FindProductGUI extends JPanel{
	
	private GridBagConstraints gbc;
	private GuiPlacer gui;
	
	// Whole panel which gives you some actions with finding products etc.
	public FindProductGUI() {
		
		// Basic settings
		this.setSize(new Dimension(900, 500));
		this.setPreferredSize(new Dimension(880, 598));
		this.setBackground(new Color(0,0,0,100));
		this.setLayout(new GridBagLayout());
		
		// GridBagConstraints things
		gbc = new GridBagConstraints();
		gui = new GuiPlacer(gbc);
		
		/*
		 *  Adding content to Panel
		 */
	
	    // Panel with "search engine"
		gbc = gui.ustawKomponent(0, 0, 1, 1, 1, 1,'c','b');
		this.add(new FindProduct_SearchGUI(),gbc);
		
		// Panel which displays results
		gbc = gui.ustawKomponent(1, 0, 1, 1, 1, 1,'c','b');
		this.add(new FindProduct_ResultsGUI(),gbc);
		
		// Panel with table 
		gbc = gui.ustawKomponent(0, 1, 1, 2, 1, 1,'c','b');
		this.add(new FindProduct_TableGUI(),gbc);
		
	}
}
		
		