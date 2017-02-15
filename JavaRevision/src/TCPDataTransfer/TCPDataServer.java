package TCPDataTransfer;
import java.net.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.io.*;

public class TCPDataServer {
	public static void main(String[] args) throws IOException {
		ServerSocket serverSocket = new ServerSocket(4444);
		try {
			while (true) {
				serverSocket.accept();
				new Thread(new ClientWorker(serverSocket.accept())).start();
			} 
		} catch (IOException e) {
			Logger.getLogger(TCPDataServer.class.getName()).log(Level.SEVERE, null, e);
		} finally {
			serverSocket.close();
		}
	}
}

class ClientWorker implements Runnable {
	private Socket targetSocket;
	private DataInputStream din;
	private DataOutputStream dout;
	
	public ClientWorker (Socket recvSocket) {
		try {
			targetSocket = recvSocket;
			din = new DataInputStream(targetSocket.getInputStream());
			dout = new DataOutputStream(targetSocket.getOutputStream());
		} catch (IOException e) {
			Logger.getLogger(TCPDataServer.class.getName()).log(Level.SEVERE, null, e);
		}
	}
	@Override
	public void run() {
		while (true) {
			byte[] initialize = new byte[1];
			try {
				din.read(initialize, 0, initialize.length);
				if (initialize[0] == 2) {
					System.out.println(new String(ReadStream()));
				}
			} catch (IOException e) {
					Logger.getLogger(TCPDataServer.class.getName()).log(Level.SEVERE, null, e);
			}
		}
	}
	
	private byte[] ReadStream() {
		byte[] dataBuffer = null;
		int b = 0;
		try {
			String bufferLength = "";
			while ((b = din.read()) != 4) {
				bufferLength += (char)b;
			}
			
			int dataLength = Integer.parseInt(bufferLength);
			dataBuffer = new byte[dataLength];
			
			int byteRead = 0;
			int byteOffset = 0;
			while (byteOffset < dataLength) {
				byteRead = din.read(dataBuffer, byteOffset, dataLength - byteOffset);
				byteOffset += byteRead;
			}
		} catch (IOException e) {
			Logger.getLogger(TCPDataServer.class.getName()).log(Level.SEVERE, null, e);
		}
		
		return dataBuffer;
	}
}