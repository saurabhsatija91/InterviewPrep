package First;

import java.util.*;
import java.util.BitSet.*;

interface UnaryPredicate<T> {
	public boolean test(T obj);
}

class OddPredicate implements UnaryPredicate<Integer> {
	public boolean test(Integer i) {
		return (i % 2 == 1);
	}
}

public class CountAlgorithm {
	public static <T> int countOf(Collection<T> c, UnaryPredicate<T> p) {
		int count = 0;
		for(T elem : c) {
			if (p.test(elem)) {
					count++;
			}
		}
		return count;
	}
	
	public static void main(String[] args) {
		Collection<Integer> ci = Arrays.asList(1, 3, 4, 5, 6, 7);
		int count = CountAlgorithm.countOf(ci, new OddPredicate());
		System.out.println("Count = " + count);
		
		//Print Bitset
		BitSet bits1 = new BitSet(16);
		BitSet bits2 = new BitSet(16);
		
		for (int i = 0; i < 16; i++) {
			if(i % 2 == 0) bits1.set(i);
		}
		for (int i = 0; i < 16; i++) {
			if(i % 5 != 0) bits2.set(i);
		}
		System.out.println(bits1);
		System.out.println(bits2);
		
	}
}
