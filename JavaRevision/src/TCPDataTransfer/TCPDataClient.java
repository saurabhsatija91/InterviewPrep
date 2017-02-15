package TCPDataTransfer;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TCPDataClient {
	private byte[] CreateDataPacket(byte[] data) {
		byte[] packet = null;
		try {
			byte[] initialize = new byte[1];
			initialize[0] = 2;
			byte[] separator = new byte[1];
			separator[0] = 4;
			byte[] dataLength = String.valueOf(data.length).getBytes("UTF8");
			packet = new byte[initialize.length + separator.length +
			                  dataLength.length + data.length];
			
			System.arraycopy(initialize, 0, packet, 0, initialize.length);
			System.arraycopy(dataLength, 0, packet, initialize.length,
					dataLength.length);
			System.arraycopy(separator, 0, packet, initialize.length + dataLength.length,
					separator.length);
			System.arraycopy(data, 0, packet, initialize.length +
					dataLength.length + separator.length, data.length);
		} catch (UnsupportedEncodingException e) {
			Logger.getLogger(TCPDataServer.class.getName()).log(Level.SEVERE, null, e);
		}
		return packet;
	}
	
	
	public static void main(String[] args) {
		try {
			TCPDataClient obj = new TCPDataClient();
			Socket objClient = new Socket("localhost", 4444);
			DataInputStream din = new DataInputStream(objClient.getInputStream());
			DataOutputStream dout = new DataOutputStream(objClient.getOutputStream());
			
			byte[] buffer = obj.CreateDataPacket("CodeVlog".getBytes("UTF8"));
			
			dout.write(buffer);
		} catch (UnknownHostException e) {
			Logger.getLogger(TCPDataServer.class.getName()).log(Level.SEVERE, null, e);
		} catch (IOException e) {
			Logger.getLogger(TCPDataServer.class.getName()).log(Level.SEVERE, null, e);
		}
		
	}
}
