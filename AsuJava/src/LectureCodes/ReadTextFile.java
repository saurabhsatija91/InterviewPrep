package LectureCodes;
import java.util.*;
import java.io.*;

public class ReadTextFile {
	private Scanner input;
	
	//enable user to open file
	public void openFile() {
		try {
			input = new Scanner(new File("create_text_file.txt"));
		} catch (FileNotFoundException fileNotFoundException) {
			System.err.println("Error opening file " +
					fileNotFoundException.toString());
			System.exit(1);
		}
	}
	
	//read records
	public void readRecords() {
		AccountRecord record = new AccountRecord();
		System.out.printf("%-10s%-12s%-12s%10s\n", "Account",
                "First Name", "Last Name", "Balance");
		
		try {
			while(input.hasNext()) {
				record.setAccount(input.nextInt()); // read account number
                record.setFirstName(input.next()); // read first name
                record.setLastName(input.next()); // read last name
                record.setBalance(input.nextDouble()); // read balance
                
             // display record contents
                System.out.printf("%-10d%-12s%-12s%10.2f\n",
                        record.getAccount(), record.getFirstName(),
                        record.getLastName(), record.getBalance());
			}
		} catch (NoSuchElementException elementException) {
			System.err.println("File improperly formed " + elementException.toString());
			input.close();
			System.exit(1);
		}
		catch (IllegalStateException stateException) {
			System.err.println("Erroro reading from file. " + stateException.toString());
			System.exit(1);
		}
	}
	
	public void closeFile() {
		if (input != null)
			input.close();
	}
}
