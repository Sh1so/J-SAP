package jsap;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class FindProduct_TableGUI extends JPanel {
	
	static JTable TABELA;
	private DefaultTableModel MODEL;
	private JScrollPane OSTATECZNA_TABELA;
	private GridBagConstraints gbc;
	private GuiPlacer gui;
	
	public FindProduct_TableGUI() {
		
		// Basic settings
		this.setPreferredSize(new Dimension(880, 299));
		this.setBackground(new Color(0,0,0,90));
		this.setLayout(new GridBagLayout());
		
		// GridBagConstraints things
		gbc = new GridBagConstraints();
		gui = new GuiPlacer(gbc);
		
		//Making Table
		String[] col = {"Id", "Nazwa produktu", "Kod Produktu", "Kategoria", "Cena Produktu", "Ilość Produktu"};
		Object[][] data = odczytajDane();
		try {
			MODEL = new DefaultTableModel(data,col){
				@Override
				public boolean isCellEditable(int i, int i1) {
		        return false; // this stops user from editing
				}
			};
		} catch (Exception x) {
			System.err.println("Nie odczytano danych! Prawdopodobnie podana jest zła ścieżka lub plik nie istnieje!");
		}
		TABELA = new JTable(MODEL);
		TABELA = ustawLayout(TABELA);
		TABELA = ustawCzcionke(TABELA);
		TABELA.setRowSelectionAllowed(false);
		OSTATECZNA_TABELA = new JScrollPane(TABELA, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		gbc = gui.ustawKomponent(0,0,1,1,1,1,'n','b');
		this.add(OSTATECZNA_TABELA,gbc);
	}
	
	// Method to read  data from csv file into table
	public Object[][] odczytajDane() {
		try {
			// Read file from path
			//String path = "..\\Prototyp\\src\\product_database.csv";
			InputStream path = FindProduct_TableGUI.class.getResourceAsStream("/product_database.csv");
			BufferedReader br = new BufferedReader(new InputStreamReader(path, StandardCharsets.UTF_8));
			ArrayList<String> list = new ArrayList<String>();
			String str = "";
			while((str = br.readLine())!= null) {
				list.add(str);
			}
			int n = list.get(0).split(",").length;
			Object[][] data = new Object[list.size()][];
			for (int i = 0; i < list.size(); i++) {
				data[i] = list.get(i).split(",");
			}
			br.close();
			return data;
		} catch (Exception x) {
			x.printStackTrace();
			return null;
		}
	}
	
	private JTable ustawLayout(JTable tabela) {
		tabela.getColumnModel().getColumn(0).setPreferredWidth(25);
		tabela.getColumnModel().getColumn(1).setPreferredWidth(250);
		tabela.getColumnModel().getColumn(2).setPreferredWidth(100);
		tabela.getColumnModel().getColumn(3).setPreferredWidth(150);
		tabela.getColumnModel().getColumn(4).setPreferredWidth(140);
		tabela.getColumnModel().getColumn(5).setPreferredWidth(140);
		
		return tabela;
	}
	private JTable ustawCzcionke(JTable tabela) {
		tabela.getTableHeader().setFont(new Font("SansSerif", Font.BOLD, 12));
		
		return tabela;
	}
}
