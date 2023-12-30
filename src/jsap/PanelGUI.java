package jsap;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagLayout;

import javax.swing.JPanel;

public class PanelGUI extends JPanel {
	
	// Constructor used in data extraction method
	public PanelGUI() {
		this.setSize(new Dimension(900, 500));
		this.setPreferredSize(new Dimension(880, 598));
		this.setBackground(new Color(0,0,0,100));
		this.setLayout(new GridBagLayout());
	}
}
