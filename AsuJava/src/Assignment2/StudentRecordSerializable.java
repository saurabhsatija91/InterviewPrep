package Assignment2;

import java.io.Serializable;

public final class StudentRecordSerializable implements Serializable {
	private String firstName;
	private String lastName;
	private transient int SSN;
	private String cls;
	private String grade;
	
	public StudentRecordSerializable() {
		this("", "", 0, "", "");
	}
	
	public StudentRecordSerializable(String firstName, String lastName, int SSN,
			String cls, String grade) {
		setLastName(lastName);
        setFirstName(firstName);
        setSSN(SSN);
        setCls(cls);
        setGrade(grade);
	}
	
	public void setSSN(int ssn) {
        SSN = ssn;
    }

    // get account number   
    public int getSSN() {
        return SSN;
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

    // set class 
    public void setCls(String clss) {
        cls = clss;
    }

    // get class   
    public String getCls() {
        return cls;
    }
    
 // set grade 
    public void setGrade(String grd) {
        grade = grd;
    }

    // get class   
    public String getGrade() {
        return grade;
    }
}
