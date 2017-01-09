package First;

import java.util.*;
import java.util.function.Predicate;

class OddPredicate implements Predicate<Integer> {
	public boolean test(Integer i) {
		return (i % 2 == 1);
	}
}

public class GenericCounter {
	public static <T> int countOf (Collection<T> collection, Predicate<T> p) {
		int count = 0;
		for (T t : collection) {
			if (p.test(t))
				++count;
		}
		return count;
	}
	
	public static void main(String[] args) {
		Collection<Integer> list = Arrays.asList(1, 3, 5, 2, 7, 9);
		int count = GenericCounter.countOf(list, new OddPredicate());
		System.out.println("Num of odd integers " + count);
	}
}
