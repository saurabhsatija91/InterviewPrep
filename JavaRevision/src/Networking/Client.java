package Networking;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		Socket socket;
		try {
			socket = new Socket("127.0.0.1", 1233);
			Scanner userInput = new Scanner(System.in);
			Scanner serverReply = new Scanner(socket.getInputStream());
			PrintStream sendServer = new PrintStream(socket.getOutputStream());
			
			int userIn; int serverIn;
			System.out.println("Enter a num.");
			userIn = userInput.nextInt();
			System.out.println("You entered: " + userIn);
			sendServer.write(userIn);
			System.out.println("Sent to server.");
			serverIn = serverReply.nextInt();
			System.out.println("Server replies back: " + serverIn);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
