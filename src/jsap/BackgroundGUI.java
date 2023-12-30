package jsap;

import java.awt.FlowLayout;
import java.awt.GridBagLayout;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class BackgroundGUI extends JLabel {
	
	//Constructor used to changing panels in application
	public BackgroundGUI() {
		this.setIcon(new ImageIcon(this.getClass().getResource("/background.jpg")));
		this.setLayout(new FlowLayout());
	}
	
	//Variant with GridBagLayout (FlowLayout is basic)
	public BackgroundGUI(boolean czy_GridBagLayout) {
		this.setIcon(new ImageIcon(this.getClass().getResource("/background.jpg")));
		if (czy_GridBagLayout) {
			this.setLayout(new GridBagLayout());
		} else {
			this.setLayout(new FlowLayout());
		}
	}
}
