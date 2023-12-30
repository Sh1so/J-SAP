package jsap;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Window;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;



public class LogPaneGUI extends JPanel implements Runnable {
	
	// Log-in status
	static int czyZalogowany = 0;

	// GUI Components 
	private JLabel TYTUL;
	private JLabel OPIS;
	private JLabel INSTRUKCJE;
	private JLabel NAZWA_UZYTKOWNIKA;
	private JLabel HASLO_UZYTKOWNIKA;
	private JLabel AUTOR;
	private JLabel PUSTKA;
	private JButton LOG_PRZYCISK;
	static JTextField POLE_NAZWA;
	static JPasswordField POLE_HASLO;
	
	// Constraints to components localisation
	private GuiPlacer gui;
	private GridBagConstraints gbc;

		public LogPaneGUI() {
			run();
		}

		@Override
		public void run() {
			// Basic pane settings
				this.setVisible(true);
				this.setBackground(new Color(0,0,0,95));
				this.setSize(new Dimension(320, 600));
				this.setPreferredSize(new Dimension(320, 600));
				this.setLayout(new GridBagLayout());
						
				// ADDING CONTENT
						
				// GridBagConstraints things
				gbc = new GridBagConstraints();
				gui = new GuiPlacer(gbc);
												
				//1. Title - name of application
				TYTUL = new JLabel("J-SAP");
				TYTUL.setFont(new Font("Arial", Font.BOLD, 40));
				TYTUL.setForeground(Color.white);
				TYTUL.setHorizontalAlignment(JLabel.CENTER);
				gbc = gui.ustawKomponentBezWeightx(0, 0, 1, 1, 0.1,'n','h');
				this.add(TYTUL,gbc);
						
				//2. Application description
				OPIS = new JLabel("Niskobudżetowy ERP");
				OPIS.setFont(new Font("Arial", Font.BOLD, 24));
				OPIS.setForeground(Color.white);
				OPIS.setHorizontalAlignment(JLabel.CENTER);
				gbc = gui.ustawKomponentBezWeightx(0, 1, 1, 1, 0.3,'n','h');
				this.add(OPIS,gbc);
						
				//3. Instruction label
				INSTRUKCJE = new JLabel("Zaloguj się do aplikacji");
				INSTRUKCJE.setFont(new Font("Arial", Font.BOLD, 20));
				INSTRUKCJE.setForeground(Color.white);
				INSTRUKCJE.setHorizontalAlignment(JLabel.CENTER);
				gbc = gui.ustawKomponentBezWeightx(0, 2, 1, 1, 0.1,'c','h');
				this.add(INSTRUKCJE,gbc);
						
				//4. Username label
				NAZWA_UZYTKOWNIKA = new JLabel("Nazwa użytkownika:");
				NAZWA_UZYTKOWNIKA.setFont(new Font("Arial", Font.PLAIN, 15));
				NAZWA_UZYTKOWNIKA.setForeground(Color.white);
				NAZWA_UZYTKOWNIKA.setHorizontalAlignment(JLabel.CENTER);
				gbc = gui.ustawKomponentBezWeightx(0, 3, 1, 1, 0.05,'s','h');
				this.add(NAZWA_UZYTKOWNIKA,gbc);
						
				//5. Text Field to enter username
				POLE_NAZWA = new JTextField();
				POLE_NAZWA.setHorizontalAlignment(JTextField.CENTER);
				gbc = gui.ustawKomponentBezWeightx(0, 4, 1, 1, 0.05,'n','h');
				this.add(POLE_NAZWA,gbc);
						
				//6. Password label
				HASLO_UZYTKOWNIKA = new JLabel("Haslo:");
				HASLO_UZYTKOWNIKA.setFont(new Font("Arial", Font.PLAIN, 15));
				HASLO_UZYTKOWNIKA.setForeground(Color.white);
				HASLO_UZYTKOWNIKA.setHorizontalAlignment(JLabel.CENTER);
				gbc = gui.ustawKomponentBezWeightx(0, 5, 1, 1, 0.05,'s','h');
				this.add(HASLO_UZYTKOWNIKA,gbc);
						
				//7. Password Field to enter some values
				POLE_HASLO = new JPasswordField();
				POLE_HASLO.setHorizontalAlignment(JPasswordField.CENTER);
				gbc = gui.ustawKomponentBezWeightx(0, 6, 1, 1, 0.1,'n','h');
				this.add(POLE_HASLO,gbc);
											
				//8. Log-in button
				LOG_PRZYCISK = new JButton("Zaloguj sie");
				LOG_PRZYCISK.setHorizontalAlignment(JButton.CENTER);
				LOG_PRZYCISK.addActionListener( (e) -> zalogujSie(e) );
				gbc = gui.ustawKomponentBezWeightx(0, 7, 1, 1, 0.1,'c','h');
				this.add(LOG_PRZYCISK,gbc);
						
				//9. Short author data + application version
				AUTOR = new JLabel("J-SAP 1.0v, Autor: Igor Lewicki");
				AUTOR.setFont(new Font("Arial", Font.BOLD, 10));
				AUTOR.setForeground(Color.WHITE);
				AUTOR.setHorizontalAlignment(JLabel.CENTER);
				gbc = gui.ustawKomponentBezWeightx(0, 8, 1, 1, 0.05,'c','h');
				this.add(AUTOR,gbc);
						
				//9. Space between title
				PUSTKA = new JLabel(" ");
				PUSTKA.setHorizontalAlignment(JLabel.CENTER);
				gbc = gui.ustawKomponentBezWeightx(0, 9, 1, 1, 0.5,'c','h');
				super.add(PUSTKA,gbc);
		}
		
		// Method that runs whole authentication process with java Sockets
		private void zalogujSie(ActionEvent e) {
			
			// STATUS equal to 1 informs Main class that button has been clicked
			Main.STATUS = 1;
			
			try {
				Thread.sleep(1000);
				while(true) {
					if (Main.VAR_CZEKAM == 0) {
						String odpowiedz = Client.status;
					
						if (odpowiedz.equals("Request accepted")) {
							System.out.println("JSAP: Zalogowano - kończę petle w main");
							czyZalogowany = 1;
							JComponent comp = (JComponent) e.getSource();
							changeFrame(comp);
						} else {
							clearTextFields();
							new MessageGUI("log");
						}
						break;
					}
					else {
						continue;
					}
				}	
			}
			catch (Exception x) {
				x.printStackTrace();	
			}
		}
		// Method to clear TextFields after unsuccessful authentication process 
		private void clearTextFields() {
			POLE_NAZWA.setText(null);
			POLE_HASLO.setText(null);
		}
		// Method that change frame to actual application after successful log-in
		private void changeFrame(JComponent comp) {
			Window win = SwingUtilities.getWindowAncestor(comp);
			win.dispose();
			new ApplicationGUI();
		}
}
