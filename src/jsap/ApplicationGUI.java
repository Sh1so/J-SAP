package jsap;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class ApplicationGUI extends JFrame {
	
	// Variables used in this class
	private JLabel TLO;
	private ImageIcon FAVICON;
	private FindProductGUI PANEL;
	private GridBagConstraints gbc;
	private GuiPlacer gui;

	
	public ApplicationGUI() {
			
			// Basic JFrame options 
			this.setSize(new Dimension(900, 600));
			this.setTitle("J-SAP");
			this.setPreferredSize(new Dimension(900, 600));
			this.setDefaultCloseOperation(EXIT_ON_CLOSE);
			this.setLocationRelativeTo(null);
			this.setLayout(new FlowLayout());
			
			// JFrame Favicon
			FAVICON = new ImageIcon(this.getClass().getResource("/favicon.jpg"));
			this.setIconImage(FAVICON.getImage());
			
			//TODO Adding JMenu with some options
			
			// Creating background object - similarly to LogFrameGUI class
			TLO = new BackgroundGUI();
			this.add(TLO);
			
			// GridBagConstraints things
			gbc = new GridBagConstraints();
			gui = new GuiPlacer(gbc);
			
			// Initialising the findProduct panel which is resposible for whole application
			PANEL = new FindProductGUI();
			gbc = gui.ustawKomponent(0,0,1,1,1,1,'c','b');
			TLO.add(PANEL,gbc);

			this.pack();
			this.setResizable(false);
			this.setVisible(true);
	}
	
	// Basic class method used in alghotitms
	public String toString() {
		return "AppGUI";
	}
}
