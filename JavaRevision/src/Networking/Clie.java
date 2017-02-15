package Networking;

import java.io.*;
import java.net.*;

public class Clie {
	public void run() throws UnknownHostException, IOException {
		Socket client = new Socket("localhost", 4445);
		PrintStream ps = new PrintStream(client.getOutputStream());
		ps.println("Hello this is client talking. Please ACK.");
		
		InputStreamReader ir = new InputStreamReader(client.getInputStream());
		BufferedReader br = new BufferedReader(ir);
		
		String ack = br.readLine();
		System.out.println("Client >> " + ack);
	}
	
	public static void main(String[] args) throws UnknownHostException, IOException {
		Clie client1 = new Clie();
		client1.run();
	}
}
