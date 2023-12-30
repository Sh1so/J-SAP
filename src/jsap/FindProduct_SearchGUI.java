package jsap;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;

public class FindProduct_SearchGUI extends JPanel implements IBackToMenu {
	
	private JLabel OPIS;
	private JLabel OPIS_POLA;
	private JButton SZUKAJ;
	private JButton WROC;
	private JTextField POLE;
	private GridBagConstraints gbc;
	private GuiPlacer gui;
	private LoadDataFromTable_Find wczytywacz;
	
	public FindProduct_SearchGUI() {
		
		// Some basic options for JPanel and constraints for lauout manager
		this.setPreferredSize(new Dimension(440, 299));
		this.setBackground(new Color(0,0,0,100));
		this.setLayout(new GridBagLayout());
		
		// GridBagConstraints things
		gbc = new GridBagConstraints();
		gui = new GuiPlacer(gbc);
		
		// Instruction label for user
		OPIS = new JLabel("Wpisz numer produktu aby go odszukać");
		OPIS.setFont(new Font("Arial", Font.BOLD, 20));
		OPIS.setForeground(Color.white);
		OPIS.setHorizontalAlignment(JLabel.CENTER);
		gbc = gui.ustawKomponentBezWeightx(0,0,1,2,0.5,'n','h');
		this.add(OPIS,gbc);
		
		// Description of TextField
		OPIS_POLA = new JLabel("Nr Produktu: ");
		OPIS_POLA.setFont(new Font("Arial", Font.BOLD, 12));
		OPIS_POLA.setForeground(Color.white);
		OPIS_POLA.setHorizontalAlignment(JLabel.LEFT);
		gbc = gui.ustawKomponentBezWeightx(0,1,1,1,0.2,'c','h');
		this.add(OPIS_POLA,gbc);
		
		// TextField for user input - in order to find product
		POLE = new JTextField();
		gbc = gui.ustawKomponentBezWeightx(1,1,1,1,0.2,'w','h');
		this.add(POLE,gbc);
		
		SZUKAJ = new JButton("Szukaj");
		SZUKAJ.setHorizontalAlignment(JButton.CENTER);
		SZUKAJ.addActionListener( (e) -> wczytuje(e));
		gbc = gui.ustawKomponentBezWeightx(0,2,1,2,0.15,'n','h');
		this.add(SZUKAJ,gbc);
		
		//Button to back to menu
		WROC = new JButton("Wyjdz");
		WROC.setHorizontalAlignment(JButton.CENTER);
		WROC.addActionListener( (e) -> wrocDoMenu(e));
		gbc = gui.ustawKomponentBezWeightx(0,3,1,1,0.4,'n','h');
		this.add(WROC,gbc);
	}
	
	// Method to find data by given code in JTextField "POLE" and to display it
	public void wczytuje(ActionEvent e) {
		
		PanelGUI panel;					// New panel for re-lauch of JComponents
		FindProduct_ResultsGUI wynik;		// JPanel with results
		gbc = new GridBagConstraints();
		gui = new GuiPlacer(gbc);
			
		// Searching for "FindMenu" JPanel
		JComponent zrodlo = (JComponent) e.getSource();					// JButton
		JComponent rodzic = (JComponent) zrodlo.getParent();			// JPanel Search
		JComponent findmenu_past = (JComponent) rodzic.getParent();		// JPanel FindMenu
		JComponent tlo = (JComponent) findmenu_past.getParent();		// JLabel Background
		
		// Switching to new JPanel
		tlo.remove(findmenu_past);
		tlo.revalidate();
		tlo.repaint();
		panel = new PanelGUI();
		gbc = gui.ustawKomponent(0,0,1,1,1,1,'c','b');
		tlo.add(panel,gbc);
		
		// Let's find our data
		JTable tabela = FindProduct_TableGUI.TABELA;
		wczytywacz = new LoadDataFromTable_Find(tabela, POLE);
		
		// Lists used in algorithm
		String dane_nazwa = null, dane_kod = null, dane_kat = null, dane_cena = null, dane_ilosc = null;
		String[] lista_nazw = {dane_nazwa, dane_kod, dane_kat, dane_cena, dane_ilosc};
		ArrayList<String> dane = wczytywacz.zaladujDane();
		
		// If we have have data in array - we can extract it in try block
		try {
			
			for(int i=0; i<5; i++) {
				lista_nazw[i] = dane.get(i);
			}
			// New element od new Panel with updated constructor to display resulsts
			wynik = new FindProduct_ResultsGUI(lista_nazw[0], lista_nazw[1], lista_nazw[2], lista_nazw[3], lista_nazw[4]);
			gbc = gui.ustawKomponent(1,0,1,1,0.5,0.5,'c','b');
			panel.add(wynik,gbc);
			FindProduct_SearchGUI nowe_szukanie = new FindProduct_SearchGUI();
			FindProduct_TableGUI nowa_tabela = new FindProduct_TableGUI();
			
			// Changing to new Menu
			gbc = gui.ustawKomponent(0,0,1,1,0.5,0.5,'c','b');
			panel.add(nowe_szukanie,gbc);

			gbc = gui.ustawKomponent(0,1,1,2,1,0.5,'c','b');
			panel.add(nowa_tabela,gbc);
			
		} catch(Exception x) {
			// When data has not been find
			wynik = new FindProduct_ResultsGUI();
			gbc = gui.ustawKomponent(1,0,1,1,0.5,0.5,'c','b');
			panel.add(wynik,gbc);
			FindProduct_SearchGUI nowe_szukanie = new FindProduct_SearchGUI();
			FindProduct_TableGUI nowa_tabela = new FindProduct_TableGUI();
			
			// Changing to new Menu
			gbc = gui.ustawKomponent(0,0,1,1,0.5,0.5,'c','b');
			panel.add(nowe_szukanie,gbc);

			gbc = gui.ustawKomponent(0,1,1,2,1,0.5,'c','b');
			panel.add(nowa_tabela,gbc);
			new MessageGUI("search");	// Additional message
		}
	}
}