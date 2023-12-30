package jsap;

import java.util.ArrayList;

import javax.swing.JTable;
import javax.swing.JTextField;

public class LoadDataFromTable_Find {
	
	private JTable tabela;
	private JTextField pole;
	private ArrayList<String> lista;
	
	public LoadDataFromTable_Find(JTable tabela, JTextField pole) {
		this.tabela = tabela;
		this.pole = pole;
	}
	
	public ArrayList<String> zaladujDane() {
		//
		System.out.println("Zaczynam szukac");
		lista = new ArrayList<String>();
		// Mining data from out JTable by for loop
		for (int count = 0; count < tabela.getRowCount(); count++) {
			  if(tabela.getValueAt(count,2).toString().equals(pole.getText().toUpperCase())) {
				  lista.add(tabela.getValueAt(count, 1).toString());
				  lista.add(tabela.getValueAt(count, 2).toString());
				  lista.add(tabela.getValueAt(count, 3).toString());
				  lista.add(tabela.getValueAt(count, 4).toString());
				  lista.add(tabela.getValueAt(count, 5).toString());
				  System.out.println("Okej, cos znalazlem");
			  } else {
				  System.out.println("Iteracja nr" + count);
			  }
		}
		return lista;
	}
}
