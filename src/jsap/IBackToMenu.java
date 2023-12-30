package jsap;

import java.awt.Component;
import java.awt.Window;
import java.awt.event.ActionEvent;

import javax.swing.SwingUtilities;

public interface IBackToMenu {
	
	// Method to exit application
	default void wrocDoMenu(ActionEvent e) {
		Window win = SwingUtilities.getWindowAncestor((Component) e.getSource());
		win.dispose();
		System.exit(0);
	}
}