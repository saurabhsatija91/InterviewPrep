package AggregateOperations;

import java.time.LocalDate;
import java.time.Period;

public class Person {
	public enum Sex {
        MALE, FEMALE
    }

    String name;
    LocalDate birthday;
    Sex gender;
    String emailAddress;
    
    public void printPerson() {
    	
    }
    
    public Sex getGender() {
    	return gender;
    }
    
    public int getAge() {
    	LocalDate now = LocalDate.now();
    	return Period.between(now, birthday).getYears();
    }

    public String getName() {
    	return name;
    }
}
