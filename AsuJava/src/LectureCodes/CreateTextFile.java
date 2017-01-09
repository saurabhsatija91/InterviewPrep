package LectureCodes;

import java.io.FileNotFoundException;
import java.util.Formatter;
import java.util.FormatterClosedException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class CreateTextFile {
	private Formatter output;
	
	public void openFile() {
		try {
			/**
			 * The constructor with one String argument receives the name of
			 * name of the file, including its path. If the path is not specifies,
			 * the JVM assumes that the file is in the directory from which the
			 * program was executed.
			 * 
			 * If the file does not exist, it will be created.
			 * 
			 * If an existing file is opened, its contents are truncated- All
			 * the data in the file is discarded.
			 */
			output = new Formatter("create_new_file.txt");
		} catch (SecurityException securityException) {
			/**
			 * Systems.err is a stream automatically created upon program execution,
			 * used to send error message to the console.
			 * 
			 * A securityException occurs if the user does not have permission
			 * to write data to the file.
			 */
			System.out.println("You do not have write access to this file."
					+ securityException.toString());
			System.exit(1);
		} catch (FileNotFoundException fileNotFoundException) {
			/**
			 * A FileNotFoundException occurs if a new file cannot be created.
			 */
			System.err.println("Error opening or creating file."
					+ fileNotFoundException.toString());
			
			/**
			 * Static method System.exit terminates an application.
			 * 
			 * An argument of 0 indicates successful program termination. A
			 * non-zero value, normally indicates that an error has occurred.
			 * 
			 * The argument is useful if the program is executed from a batch
			 * file on Windows or a shell script on Linux/UNIX/Mac OS X.
			 */
			System.exit(1);
		}
	}
	
	//Add records to file.
	public void addRecords() {
		AccountRecord record = new AccountRecord();
		Scanner input = new Scanner(System.in);
		
		System.out.printf("%s\n",
                "To terminate input, type a character, then press Enter");

        System.out.printf("%s\n%s",
                "Enter account number (> 0), first name, last name, and balance.",
                "? ");
        
        /**
         * Scanner method hasNextInt determines whether the end-of-file key
         * combination has been entered.
         */
        while(input.hasNext()) {
        	//Output value to file
        	try {
        		record.setAccount(input.nextInt()); //read account#
        		record.setFirstName(input.next()); //read first name
        		record.setLastName(input.next()); //read last name
        		record.setBalance(input.nextDouble()); //read ac bal
        		
        		if (record.getAccount() > 0) {
        			output.format("%d %s %s %.2f\n", record.getAccount(),
                            record.getFirstName(), record.getLastName(),
                            record.getBalance());
        		} else
                    System.out.println("Account number must be greater than 0.");
        	} catch(FormatterClosedException formatterClosedException) {
                /**
                 * A FormatterClosedException occurs if the Formatter is closed
                 * when you attempt to output.
                 */
                System.err.println("Error writing to file." + formatterClosedException.toString());

                return;
            }
        	catch(NoSuchElementException elementException) {
                /**
                 * A NoSuchElementException occurs if the data being read by a
                 * Scanner method is in the wrong format or if there is no more
                 * data to input.
                 */
                System.err.println("Invalid input. Please try again."
                        + elementException.toString());

                // discard input so user can try again
                input.nextLine();
            }
        	finally{
        		input.close();
        	}
        }
	}
	
	public void closeFile() {
		if (output != null) {
			/**
             * Formatter method close closes the file.
             *
             * If method close is not called explicitly, the operating system
             * normally will close the file when program execution terminates.
             */
            output.close();
		}
	}
}
