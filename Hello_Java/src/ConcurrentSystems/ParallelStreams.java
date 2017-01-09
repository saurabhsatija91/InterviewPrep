package ConcurrentSystems;

import java.util.Arrays;
import java.util.*;
import java.util.Collection;

public class ParallelStreams {
	public static void main(String[] args) {
		Integer[] intArray = {1, 2, 3, 4, 5, 6, 7, 8};
		List<Integer> listOfIntegers =
				new ArrayList<>(Arrays.asList(intArray));
		
		System.out.println("listOfIntegers: ");
		listOfIntegers
			.stream()
			.forEach(e -> System.out.print(e + " "));
		System.out.println();
		
		System.out.println("listOfinteger in reverese sorted order.");
		Comparator<Integer> normal = Integer::compare;
		Comparator<Integer> reverserd = normal.reversed();
		Collections.sort(listOfIntegers, reverserd);
		listOfIntegers
			.stream()
			.forEach(e -> System.out.print(e + " "));
		System.out.println();
		
		System.out.println("Parallel stream: ");
		listOfIntegers
			.parallelStream()
			.forEach(e -> System.out.print(e + " "));
		System.out.println();
		
		System.out.println("Another parallel stream: ");
		listOfIntegers
			.parallelStream()
			.forEach(e -> System.out.print(e + " "));
		System.out.println();
		
		System.out.println("With ordered foreach: ");
		listOfIntegers
			.parallelStream()
			.forEachOrdered(e -> System.out.print(e + " "));
		System.out.println();
		
		System.out.println("Another parallel stream: ");
		int sum = listOfIntegers
			.parallelStream()
			.reduce(0, (a, b) -> a + b);
		System.out.println("Sum = " + sum);
	}
}
