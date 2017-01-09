package LectureCodes;

import java.util.*;
import java.io.*;

public class CreateSerializableFile {
	private ObjectOutputStream output;	//output data to file.
	
	public void openFile() {
		//open file
		try {
			/**
			 * The file is to be opened for output so the program crates a
			 * FileOutputStream.
			 * 
			 * The Stream argument that is passes to the constructor represents
			 * the name and path of the file to be opened.
			 * 
			 * Existing files that are opened for output in this manner are
			 * truncated.
			 * 
			 * The file extension .ser to indicate binary files that contain
			 * serialized objects, but this is optional.
			 * 
			 * The ObjectOutputStream uses the FileOutputStream to write objects
			 * to the file.
			 */
			output = new ObjectOutputStream(new FileOutputStream("clients.ser"));
		} catch(IOException ioException) {
			/**
			 * IOException is thrown if a problem occurs while opening the file.
			 * e.g. when a file is opened on a drive with insufficient space or 
			 * when a read-only file is opened for writing.
			 */
			System.err.println("Error opening file." + ioException.toString());
		}
	}
	
	public void addRecords() {
		AccountRecordSerializable record;
		int account;
		String firstName;
		String lastName;
		double balance;
		
		Scanner input =  new Scanner(System.in);
		
	     System.out.printf("%s\n",
	                "To terminate input, type a character, then press Enter");

	        System.out.printf("%s\n%s",
	                "Enter account number (> 0), first name, last name and balance.",
	                "? ");
	     
	     while (input.hasNext()) {
	    	 try {
	    		 account = input.nextInt(); // read account number
	             firstName = input.next(); // read first name
	             lastName = input.next(); // read last name
	             balance = input.nextDouble(); // read balance
	             
	             if (account > 0) {
	            	 record = new AccountRecordSerializable(account, firstName,
	            			 lastName, balance);
	            	 
	            	 output.writeObject(record);
	             } else
	            	 System.out.println("acc should b > 0");
	    	 } catch (IOException ioException) {
	    		 System.err.println("Error writing to file." + ioException.toString());
	             return;
	    	 }
	    	 catch(NoSuchElementException elementException) {
	                System.err.println("Invalid input. Please try again."
	                        + elementException.toString());

	                // discard input so user can try again
	                input.nextLine();
	          }
	     }
	}
	
	public void closeFile() {
		try {
			if(output != null)
				output.close();
		} catch (IOException ioException) {
			/**
             * Throw exception if the file did not close properly and notify the
             * user that the information in the file might be corrupt.
             */
            System.err.println("Error closing file." + ioException.toString());
            System.exit(1);
		}
	}
}
