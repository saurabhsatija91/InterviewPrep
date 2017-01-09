package First;

import java.util.function.*;

public class TestPredicate {
	public void printPredicateValue (int num, 
			Predicate<Integer> p,
			Consumer<Integer> c) {
		for (int i = 0; i < num; i++) {
			if (p.test(i))
				c.accept(i);
//				System.out.println("i: " + i);
		}
	}
	
	public static void main(String[] args) {
		TestPredicate obj = new TestPredicate();
		obj.printPredicateValue(5,
				e -> (e % 2 == 0),
				c -> System.out.println(c)
				);
	}
}
