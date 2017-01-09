package LectureCodes;

import java.io.Serializable;

public class AccountRecordSerializable implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6812215838344422629L;
	/**
	 * In a serializable class, every attribute is serialized.
	 * 
	 * Non-serialized attributes must be declared transient to indicate that
	 * they should be ignored during the serialization process.
	 */
	private int account;
	private String firstName;
	private String lastName;
	private double balance;
	
	public AccountRecordSerializable() {
		this(0, "", "", 0.0);
	}
	
	public AccountRecordSerializable (int account, String firstName, String lastName,
			double balance) {
		this.account = account;
		this.firstName = firstName;
		this.lastName = lastName;
		this.balance = balance;
	}
	
	// set account number   
    public void setAccount(int acct) {
        account = acct;
    }

    // get account number   
    public int getAccount() {
        return account;
    }

    // set first name   
    public void setFirstName(String first) {
        firstName = first;
    }

    // get first name   
    public String getFirstName() {
        return firstName;
    }

    // set last name   
    public void setLastName(String last) {
        lastName = last;
    }

    // get last name   
    public String getLastName() {
        return lastName;
    }

    // set balance  
    public void setBalance(double bal) {
        balance = bal;
    }

    // get balance   
    public double getBalance() {
        return balance;
    }
}
