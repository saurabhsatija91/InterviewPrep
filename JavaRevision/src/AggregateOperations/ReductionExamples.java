package AggregateOperations;
import java.util.*;

public class ReductionExamples {
	public static void main(String[] args) {
		List<Person> roaster = new LinkedList<>();
		
		System.out.println("Contents of roaster: ");
		roaster
			.stream()
			.forEach(p -> p.printPerson());
		
		System.out.println();
		
		// 1. Avg age of male members:
		
		double average = roaster
			.stream()
			.filter(p -> p.getGender() == Person.Sex.MALE)
			.mapToInt(Person::getAge)
			.average()
			.getAsDouble();
		
		System.out.println("Avg age: " + average);
		
		// 2. Sum of ages 
		int sum = roaster
				.stream()
				.mapToInt(Person::getAge)
				.sum();
		
		Integer totalAgeReduced = roaster
				.stream()
				.mapToInt(Person::getAge)
				.reduce(0,
						(a,b) -> a + b);
	}
}
