package jsap;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class LogFrameGUI extends JFrame {
	
	// Final graphics used in application GUI
	private final BackgroundGUI TLO;
	private final ImageIcon FAVICON;
	
	
	public LogFrameGUI() {
		
		// Basic JFrame configurations
		this.setTitle("J-SAP");
		this.setSize(new Dimension(900, 600));
		this.setPreferredSize(new Dimension(900, 600));
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setLayout(new BorderLayout());
		
		// JFrame Favicon
		FAVICON = new ImageIcon(this.getClass().getResource("/favicon.jpg"));
		this.setIconImage(FAVICON.getImage());
		
		// Background - setting JLabel as backgroung panel and setting default layout
		TLO = new BackgroundGUI();
		add(TLO);
		
		// Adding Log-in panel to Background panel
		LogPaneGUI logPane = new LogPaneGUI();
		TLO.add(logPane);

		// End
		this.pack();
		this.setResizable(false);
	}
}
