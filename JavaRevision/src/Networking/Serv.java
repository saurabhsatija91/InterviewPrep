package Networking;

import java.io.IOException;
import java.net.*;
import java.io.*;

public class Serv {
	public static void main(String[] args) {
		ServerSocket server;
		try {
			server = new ServerSocket(4445);
			Socket client = server.accept();
			InputStreamReader in = new InputStreamReader(client.getInputStream());
			BufferedReader br = new BufferedReader(in);
			
			String message = br.readLine();
			System.out.println("Server >> " + message);
			
			if (message != null) {
				PrintStream ps = new PrintStream(client.getOutputStream());
				ps.println("Message received");
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
}
