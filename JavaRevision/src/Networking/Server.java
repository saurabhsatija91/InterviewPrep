package Networking;

import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.*;

public class Server {
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		try {
			ServerSocket serverSocket = new ServerSocket(1234);
			Socket clientSocket = serverSocket.accept();
			Scanner clientIn = new Scanner(clientSocket.getInputStream());
			int number = clientIn.nextInt();
			int out = 2 * number;
			PrintStream sendCli = new PrintStream(clientSocket.getOutputStream());
			sendCli.write(out);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
