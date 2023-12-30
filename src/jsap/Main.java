package jsap;



public class Main {
	
	/*
	 * Autor - Igor Lewicki, 2 grupa (elektroniczny biznes), nr albumu: 127810
	 * 
	 * Opis - Prosty program z GUI typu ERP w którym można wyszukać dane o produkcie
	 * w przykładowej firmie na podstawie jego kodu (np. podczas zeskanowania barcode)
	 * 
	 * Uwagi - Program kompilowany w nowej wersji Javy; komentarze i nazwy prócz zmiennych
	 * są po angielsku!
	 * 
	 * Easter egg - należy wpisać "111111" w pole tekstowe obok "Nr produktu:"
	 */
	
	// Technical variables used by authentication methods
	static int STATUS = 0;
	static int VAR_CZEKAM = 0;
	
	public static void main(String[] args) {
		try {
			// Thread which runs GUI of application
	        Thread GUIThread = new Thread() {
	            public void run() {
	                LogFrameGUI GUI = new LogFrameGUI();
	                GUI.setVisible(true);
	            }
	        };
	        // GUI thread starts indepedently
			GUIThread.start();
			
			// Algorithm which is used in net communication (Socket programming)
			while(STATUS != 9) {
				
				// Initializing server thread and main method of server
				Thread serverThread = new Thread() {
					public void run() {
						Server.main(args);
			        }
			    };
			    // Initializing client thread and main method of client   
			    Thread clientThread = new Thread() {
			            public void run() {
			                Client.main(args);
			            }
			    };
			    // Server thread starts
			    serverThread.start();     
			     
			    // Loop which runs until button "Zaloguj sie" is clicked - then it executes client request
			    while(true) {	
			    	try {
			        	Thread.sleep(100);
						if(STATUS == 1) {	// STATUS equal to 1 informs us, that button "Zaloguj się" was clicked
							VAR_CZEKAM = 1;		// VAR_CZEKAM equal to 1 blocks some code until client thread is done
							Thread.sleep(100);
							clientThread.start();	// Client thread starts after some necessary delay
							Thread.sleep(500);
							VAR_CZEKAM = 0;		
							Thread.sleep(500);
							// If log-in data were correct, then STATUS = 9 breaks loop
							if (LogPaneGUI.czyZalogowany == 1) { 
								STATUS = 9;
							}
							else { STATUS = 0; }	// If data were incorrect, loop would be still working
							break;
						} else {
							continue;
						}
			        } catch(Exception x) {
			        	x.printStackTrace();
			        } 		
			       }        
			}
		}
		catch (Exception x) {
			throw x;
		}
	}	
} 

