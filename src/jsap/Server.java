package jsap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server extends LogPaneGUI {
	
	// Just for demo - it shouldn't be done like this without proper security like encryption ;)
	static String LOGIN = "admin";
	static String HASLO = "admin";
	
	public static void main(String[] args) {
		
		System.err.println("SERVER: Waiting for clients...");
			try {
				ServerSocket ss = new ServerSocket(6666);
				Socket soc = ss.accept();
				
				PrintWriter out = new PrintWriter(soc.getOutputStream(), true);
				BufferedReader in = new BufferedReader(new InputStreamReader(soc.getInputStream()));
				
				String loginKlienta, hasloKlienta;
			
				System.err.println("SERVER: Connection Estabilished");
				Thread.sleep(100);
				
				loginKlienta = in.readLine();
				System.err.println("SERVER: Login - received");
				Thread.sleep(100);
				
				hasloKlienta = in.readLine();
				System.err.println("SERVER: Password - received");
				System.err.println("SERVER: Authorising data...");
				
				if(loginKlienta.equals(LOGIN)&&hasloKlienta.equals(HASLO)) {
					out.println("Request accepted");
					System.err.println("SERVER: Request - ACCEPTED");
				} else {
					out.println("Request denied");
					System.err.println("SERVER: Request - DENIED");
				}
				out.flush();
				System.err.println("SERVER: Request - SENDED");
				in.close();
				out.close();
				soc.close();
				ss.close();
				
			} catch (IOException e) {
				e.printStackTrace();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
	}
	
}


