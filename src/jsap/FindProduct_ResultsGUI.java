package jsap;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class FindProduct_ResultsGUI extends JPanel {
	
	// GUI components from JComponent 
	private JLabel OPIS;
	private JLabel NAZWA_PR;
	private JLabel KOD_PR;
	private JLabel KATEGORIA_PR;
	private JLabel CENA_PR;
	private JLabel ILOSC_PR;
	private JTextField POLE_NAZWA_PR;
	private JTextField POLE_KOD_PR;
	private JTextField POLE_KATEGORIA_PR;
	private JTextField POLE_CENA_PR;
	private JTextField POLE_ILOSC_PR;
	private GridBagConstraints gbc;
	private GuiPlacer gui;
	
	public FindProduct_ResultsGUI() {
		
		// Basic settings for JPanel
		this.setPreferredSize(new Dimension(440, 299));
		this.setBackground(new Color(0,0,0,100));
		this.setLayout(new GridBagLayout());
		
		// GridBagConstraints things
		gbc = new GridBagConstraints();
		gui = new GuiPlacer(gbc);
		
		// Header of this panel
		OPIS = new JLabel("Informacje dotyczące wypisanego produktu");
		OPIS.setFont(new Font("Arial", Font.BOLD, 20));
		OPIS.setForeground(Color.white);
		OPIS.setHorizontalAlignment(JLabel.CENTER);
		gbc = gui.ustawKomponentBezWeightx(0,0,1,2,0.5,'n','h');
		this.add(OPIS,gbc);
		
		/*
		 *  JLABELS - TextFields description 
	     */
		
		// TextField description - product's name
		NAZWA_PR = new JLabel("Nazwa Produktu:");
		NAZWA_PR.setFont(new Font("Arial", Font.BOLD, 12));
		NAZWA_PR.setForeground(Color.white);
		NAZWA_PR.setHorizontalAlignment(JLabel.LEFT);
		gbc = gui.ustawKomponentBezWeightx(0,1,1,1,0.1,'c','h');
		this.add(NAZWA_PR,gbc);
		
		// TextField description - product's code/number
		KOD_PR = new JLabel("Kod Produktu:");
		KOD_PR.setFont(new Font("Arial", Font.BOLD, 12));
		KOD_PR.setForeground(Color.white);
		KOD_PR.setHorizontalAlignment(JLabel.LEFT);
		gbc = gui.ustawKomponentBezWeightx(0,2,1,1,0.1,'c','h');
		this.add(KOD_PR,gbc);
		
		// TextField description - product's category
		KATEGORIA_PR = new JLabel("Kategoria Produktu: ");
		KATEGORIA_PR.setFont(new Font("Arial", Font.BOLD, 12));
		KATEGORIA_PR.setForeground(Color.white);
		KATEGORIA_PR.setHorizontalAlignment(JLabel.LEFT);
		gbc = gui.ustawKomponentBezWeightx(0,3,1,1,0.1,'c','h');
		this.add(KATEGORIA_PR,gbc);
		
		// TextField description - product's price
		CENA_PR = new JLabel("Cena Produktu:");
		CENA_PR.setFont(new Font("Arial", Font.BOLD, 12));
		CENA_PR.setForeground(Color.white);
		CENA_PR.setHorizontalAlignment(JLabel.LEFT);
		gbc = gui.ustawKomponentBezWeightx(0,4,1,1,0.1,'c','h');
		this.add(CENA_PR,gbc);
		
		// TextField description - product's price
		ILOSC_PR = new JLabel("Ilosc Produktu:");
		ILOSC_PR.setFont(new Font("Arial", Font.BOLD, 12));
		ILOSC_PR.setForeground(Color.white);
		ILOSC_PR.setHorizontalAlignment(JLabel.LEFT);
		gbc = gui.ustawKomponentBezWeightx(0,5,1,1,0.1,'c','h');
		this.add(ILOSC_PR,gbc);
		
		/*
		 * TEXTFIELDS
		 */
		
		// GridBagConstraints settings common for whole TextFields	
		POLE_NAZWA_PR = new JTextField();
		gbc = gui.ustawKomponentBezWeightx(1,1,1,1,0.1,'w','h');
		this.add(POLE_NAZWA_PR,gbc);
		
		POLE_KOD_PR = new JTextField();
		gbc = gui.ustawKomponentBezWeightx(1,2,1,1,0.1,'w','h');
		this.add(POLE_KOD_PR,gbc);
		
		POLE_KATEGORIA_PR = new JTextField();
		gbc = gui.ustawKomponentBezWeightx(1,3,1,1,0.1,'w','h');
		this.add(POLE_KATEGORIA_PR,gbc);
		
		POLE_CENA_PR = new JTextField();
		gbc = gui.ustawKomponentBezWeightx(1,4,1,1,0.1,'w','h');
		this.add(POLE_CENA_PR,gbc);
		
		POLE_ILOSC_PR = new JTextField();
		gbc = gui.ustawKomponentBezWeightx(1,5,1,1,0.1,'w','h');
		this.add(POLE_ILOSC_PR,gbc);
	}
	
	// Updated constructor, used to populate JTextFields with extracted data
	public FindProduct_ResultsGUI(String nazwa, String kod, String kat, String cena, String ilosc) {
		
		// Same as before, only diffrence is JTextFields with set text 
		this.setPreferredSize(new Dimension(440, 299));
		this.setBackground(new Color(0,0,0,100));
		this.setLayout(new GridBagLayout());
		
		// GridBagConstraints things
		gbc = new GridBagConstraints();
		gui = new GuiPlacer(gbc);
		
		OPIS = new JLabel("Informacje dotyczące wypisanego produktu");
		OPIS.setFont(new Font("Arial", Font.BOLD, 20));
		OPIS.setForeground(Color.white);
		OPIS.setHorizontalAlignment(JLabel.CENTER);
		gbc = gui.ustawKomponentBezWeightx(0,0,1,2,0.5,'n','h');
		this.add(OPIS,gbc);
		
		/*
		 *  JLABELS - TextFields description 
	     */
		
		// TextField description - product's name
		NAZWA_PR = new JLabel("Nazwa Produktu:");
		NAZWA_PR.setFont(new Font("Arial", Font.BOLD, 12));
		NAZWA_PR.setForeground(Color.white);
		NAZWA_PR.setHorizontalAlignment(JLabel.LEFT);
		gbc = gui.ustawKomponentBezWeightx(0,1,1,1,0.1,'c','h');
		this.add(NAZWA_PR,gbc);
		
		// TextField description - product's code/number
		KOD_PR = new JLabel("Kod Produktu:");
		KOD_PR.setFont(new Font("Arial", Font.BOLD, 12));
		KOD_PR.setForeground(Color.white);
		KOD_PR.setHorizontalAlignment(JLabel.LEFT);
		gbc = gui.ustawKomponentBezWeightx(0,2,1,1,0.1,'c','h');
		this.add(KOD_PR,gbc);
		
		// TextField description - product's category
		KATEGORIA_PR = new JLabel("Kategoria Produktu: ");
		KATEGORIA_PR.setFont(new Font("Arial", Font.BOLD, 12));
		KATEGORIA_PR.setForeground(Color.white);
		KATEGORIA_PR.setHorizontalAlignment(JLabel.LEFT);
		gbc = gui.ustawKomponentBezWeightx(0,3,1,1,0.1,'c','h');
		this.add(KATEGORIA_PR,gbc);
		
		// TextField description - product's price
		CENA_PR = new JLabel("Cena Produktu:");
		CENA_PR.setFont(new Font("Arial", Font.BOLD, 12));
		CENA_PR.setForeground(Color.white);
		CENA_PR.setHorizontalAlignment(JLabel.LEFT);
		gbc = gui.ustawKomponentBezWeightx(0,4,1,1,0.1,'c','h');
		this.add(CENA_PR,gbc);
		
		// TextField description - product's price
		ILOSC_PR = new JLabel("Ilosc Produktu:");
		ILOSC_PR.setFont(new Font("Arial", Font.BOLD, 12));
		ILOSC_PR.setForeground(Color.white);
		ILOSC_PR.setHorizontalAlignment(JLabel.LEFT);
		gbc = gui.ustawKomponentBezWeightx(0,5,1,1,0.1,'c','h');
		this.add(ILOSC_PR,gbc);
		
		/*
		 * TEXTFIELDS
		 */
		
		// GridBagConstraints settings common for whole TextFields		
		POLE_NAZWA_PR = new JTextField(nazwa);
		gbc = gui.ustawKomponentBezWeightx(1,1,1,1,0.1,'w','h');
		this.add(POLE_NAZWA_PR,gbc);
		
		POLE_KOD_PR = new JTextField(kod);
		gbc = gui.ustawKomponentBezWeightx(1,2,1,1,0.1,'w','h');
		this.add(POLE_KOD_PR,gbc);
		
		POLE_KATEGORIA_PR = new JTextField(kat);
		gbc = gui.ustawKomponentBezWeightx(1,3,1,1,0.1,'w','h');
		this.add(POLE_KATEGORIA_PR,gbc);
		
		POLE_CENA_PR = new JTextField(cena);
		gbc = gui.ustawKomponentBezWeightx(1,4,1,1,0.1,'w','h');
		this.add(POLE_CENA_PR,gbc);
		
		POLE_ILOSC_PR = new JTextField(ilosc);
		gbc = gui.ustawKomponentBezWeightx(1,5,1,1,0.1,'w','h');
		this.add(POLE_ILOSC_PR,gbc);
	}
}
