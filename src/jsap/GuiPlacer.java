package jsap;

import java.awt.GridBagConstraints;

public class GuiPlacer {
	
	private GridBagConstraints wspolrzedne; 
	
	// CONTRUCTOR
	public GuiPlacer(GridBagConstraints constraints) {
		this.wspolrzedne = constraints;
	}
	// SETTER
	public void setConstraints(GridBagConstraints constraints) {
		this.wspolrzedne = constraints;
	}
	// GETTER
	public GridBagConstraints getConstraints() {
		return this.wspolrzedne;
	}
	
	// Method which simplify components placement and reduce redundant code
	public GridBagConstraints ustawKomponentBezWeightx(int x, int y, int h, int w, double weighty, char a, char f) {
		wspolrzedne.gridx = x;
		wspolrzedne.gridy = y;
		wspolrzedne.gridheight = h;
		wspolrzedne.gridwidth = w;
		wspolrzedne.weighty = weighty;
		
		// Simple tests which outputs some placement options
		// Setting ancgor - placement within grid
		if(a == 'c') {
			wspolrzedne.anchor = GridBagConstraints.CENTER;
		} else if (a == 'n'){
			wspolrzedne.anchor = GridBagConstraints.NORTH;
		} else if (a == 's'){
			wspolrzedne.anchor = GridBagConstraints.SOUTH;
		} else if (a == 'w'){
			wspolrzedne.anchor = GridBagConstraints.WEST;
		} else if (a == 'e'){
			wspolrzedne.anchor = GridBagConstraints.EAST;
		} else {
			wspolrzedne.anchor = GridBagConstraints.NONE;
		}
		
		// Setting fill - essential if gridwidth is greater than 1
		if(f == 'h') {
			wspolrzedne.fill = GridBagConstraints.HORIZONTAL;
		} else if (f == 'b'){
			wspolrzedne.fill = GridBagConstraints.BOTH;
		} else {
			wspolrzedne.fill = GridBagConstraints.NONE;
		}
		
		return wspolrzedne;
	}
	
	public GridBagConstraints ustawKomponent(int x, int y, int h, int w, double weightx, double weighty, char a, char f) {
		wspolrzedne.gridx = x;
		wspolrzedne.gridy = y;
		wspolrzedne.gridheight = h;
		wspolrzedne.gridwidth = w;
		wspolrzedne.weightx = weightx;
		wspolrzedne.weighty = weighty;
		
		// Simple tests which outputs some placement options
		// Setting ancgor - placement within grid
		if(a == 'c') {
			wspolrzedne.anchor = GridBagConstraints.CENTER;
		} else if (a == 'n'){
			wspolrzedne.anchor = GridBagConstraints.NORTH;
		} else if (a == 's'){
			wspolrzedne.anchor = GridBagConstraints.SOUTH;
		} else if (a == 'w'){
			wspolrzedne.anchor = GridBagConstraints.WEST;
		} else if (a == 'e'){
			wspolrzedne.anchor = GridBagConstraints.EAST;
		} else {
			wspolrzedne.anchor = GridBagConstraints.NONE;
		}
		
		// Setting fill - essential if gridwidth is greater than 1
		if(f == 'h') {
			wspolrzedne.fill = GridBagConstraints.HORIZONTAL;
		} else if (f == 'b'){
			wspolrzedne.fill = GridBagConstraints.BOTH;
		} else {
			wspolrzedne.fill = GridBagConstraints.NONE;
		}
		
		return wspolrzedne;
	}
}
