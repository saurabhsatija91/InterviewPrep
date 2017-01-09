package AggregateOperations;
import java.util.function.*;
import java.util.*;

public class Averager implements IntConsumer {
	private int total = 0;
	private int count = 0;
	
	private double average() {
		return count > 0 ? ((double)total) / count : 0;
	}

	@Override
	public void accept(int value) {
		total += value;
		count++;
	}
	
	public void combine (Averager other) {
		total += other.total;
		count += other.count;
	}
	
	public static void main(String[] args) {
		List<Person> roaster = new LinkedList<>();
		Averager avgCollect = roaster
				.stream()
				.filter(p -> p.getGender() == Person.Sex.MALE)
				.mapToInt(Person::getAge)
				.collect(Averager::new, Averager::accept, Averager::combine);
		
		System.out.println("Avg age of male members: " +
		avgCollect.average());
		
	}

}
