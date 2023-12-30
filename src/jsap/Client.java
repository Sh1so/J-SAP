package jsap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client extends LogPaneGUI {
	
	static String status;
	
	public static void main(String[] args) {
		
			try {
				System.out.println("CLIENT: Client started...");
				Socket soc = new Socket("localhost",6666);
				
				PrintWriter out = new PrintWriter(soc.getOutputStream(), true);
				BufferedReader in = new BufferedReader(new InputStreamReader(soc.getInputStream()));
				
				Thread.sleep(100);
				System.out.println("CLIENT: Getting data from JTextFields...");
				String login = POLE_NAZWA.getText();
				System.out.println("CLIENT: Login - getted");
				String password = POLE_HASLO.getText();
				System.out.println("CLIENT: Password - getted");
	
				out.println(login);
				System.out.println("CLIENT: login - sended");
				Thread.sleep(100);
				out.println(password);
				out.flush();
				System.out.println("CLIENT: Password - sended");
				Thread.sleep(100);
				
				status = in.readLine();
				System.out.println(status);
				
				in.close();
				out.close();
				soc.close();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
	}
}
