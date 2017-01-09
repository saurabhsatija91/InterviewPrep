package AggregateOperations;

import java.util.Arrays;
import java.util.*;

public class ParallelStreamEx {
	public static void main(String[] args) {
		Integer[] intArray = {1, 2, 3, 4, 5, 6, 7 ,8 };
		List<Integer> listOfInts = new ArrayList<>(Arrays.asList(intArray));
		
		System.out.println("listOfInts");
		listOfInts
		.stream()
		.forEach(e -> System.out.print(e + " "));
		
		System.out.println();
		
		System.out.println("List of Ints in reveresed order");
		
		Comparator<Integer> normal = Integer::compare;
		Comparator<Integer> reversed = normal.reversed();
		Collections.sort(listOfInts, reversed);
		listOfInts
		.stream()
		.forEach(e -> System.out.print(e + " "));
		System.out.println();
		
		System.out.println("Parallel stream");
		listOfInts
		.parallelStream()
		.forEach(e -> System.out.print(e + " "));
		System.out.println();
		
		System.out.println("Another parallel stream");
		listOfInts
		.parallelStream()
		.forEach(e -> System.out.print(e + " "));
		System.out.println();
		
		System.out.println("Parallel with for each ordered");
		listOfInts
		.parallelStream()
		.forEachOrdered(e -> System.out.print(e + " "));
		System.out.println();
	}
}
