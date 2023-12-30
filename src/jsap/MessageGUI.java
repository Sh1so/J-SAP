package jsap;

import javax.swing.JDialog;
import javax.swing.JOptionPane;

public class MessageGUI extends JDialog {
	
	private String WIADOMOSC;
	private String TYTUL;
	
	// Warning popping out when login or password is incorrect
	public MessageGUI(String type) {
		if(type.equals("log")) {
			WIADOMOSC = "Błąd Logowania - Spróbuj ponownie";
			TYTUL = "Błąd Uwierzytelniania";
			JOptionPane.showMessageDialog(null, WIADOMOSC, TYTUL, JOptionPane.ERROR_MESSAGE);
		} else if (type.equals("search")) {
			WIADOMOSC = "Błąd wyszukiwania - podano zły kod!";
			TYTUL = "Błąd";
			JOptionPane.showMessageDialog(null, WIADOMOSC, TYTUL, JOptionPane.ERROR_MESSAGE);
		} else {
			System.err.println("Nie wpisano poprawngo parametru");
		}
	}
}
