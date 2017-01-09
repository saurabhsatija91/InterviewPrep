package Assignment2;

import java.io.*;
import java.util.*;

public class StudentGrades {
	private static ObjectOutputStream output;
	private static ObjectInputStream input;
	
	public void openSerialFile() {
		try {
			output = new ObjectOutputStream(new FileOutputStream("students.ser"));
		} catch (IOException ioException) {
			System.err.println("Error openeing file. " + ioException.toString());
		}
	}
	
	public void openInputFile() {
		try {
			input = new ObjectInputStream(new FileInputStream("students.ser"));
		} catch (IOException ioException) {
			System.err.println("Error openeing file. " + ioException.toString());
		}
	}
	
	public void addRecords() {
		StudentRecordSerializable record; // object to be written to file
		
	    String firstName;
	    String lastName;
	    int SSN;
	    String cls;
	    String grade;
	    String temp2;
	    Scanner input = new Scanner(System.in);
	    
        System.out.printf("%s\n%s",
                "Enter last name, first name, SSN, class and grade.", "? ");

        while(input.hasNext()) {
        	try {
        		firstName = input.next();
        		lastName = input.next();
        		SSN = input.nextInt();
        		cls = input.next();
        		grade = input.next();
        		
        		record = new StudentRecordSerializable(firstName, lastName, SSN,
        				cls, grade);
        		output.writeObject(record);
        	} catch (IOException ioException) {
        		System.err.println("Error writing to the file " +
        				ioException.toString());
        	} catch (NoSuchElementException e) {
        		System.err.println("Invalid input. " + e.toString());
        	}
        	System.out.println("Press 'yes' to enter more records or 'no' to display the entered records");
            temp2 = input.next();
            if(temp2.equalsIgnoreCase("yes"))
            {
            	System.out.printf("%s\n%s","Enter last name, first name, SSN, class and grade.",
                    "first name, last name and balance.", "? ");
            }
            else
            {
            	input.close();
            	break;
            }
        }
	}
	
	public void readRecords() {
		StudentRecordSerializable record;
		
		try {
			while(true) {
				record = (StudentRecordSerializable)input.readObject();
				System.out.printf("%-10s%-12s%10.2s%10s\n",
                        record.getLastName(), record.getFirstName(), record.getCls(), record.getGrade());
			}
		} catch (ClassNotFoundException e) {
			System.err.println("Unable to create object. " + e.toString());
		}
		catch (IOException e) {}
	}
	public void closeOutputFile() {
		if (output != null) {
			try {
				output.close();
			} catch(IOException e) {
				System.err.println(e.toString());
			}
		}
	}
	public void closeInputFile() {
		if (input != null) {
			try {
				input.close();
			} catch(IOException e) {
				System.err.println(e.toString());
			}
		}
	}
}
