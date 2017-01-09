package my.ds;

import java.util.Arrays;
import java.util.*;

public class Shuffle {
	public static <E> void replace (List<E> list, E val, E newVal) {
		for (ListIterator<E> listIte = list.listIterator(); listIte.hasNext();) {
			if (val == null ? listIte.next() == null : val.equals(listIte.next()))
				listIte.set(newVal);
		}
	}
	public static <E> void replace2 (List<E> list, E val, List<? extends E> newVal) {
		for (ListIterator<E> listIte = list.listIterator(); listIte.hasNext();) {
			if (val == null ? listIte.next() == null : val.equals(listIte.next())) {
				listIte.remove();
				for(E e : newVal)
					listIte.add(e);
				System.out.println(listIte.nextIndex());
			}
		}
	}
	
	public static void main(String[] args) {
/*//		List<String> list = Arrays.asList(args);
		List<String> list = new ArrayList<>();
		for (String a : args)
			list.add(a);
		Collections.shuffle(list);
		
		System.out.println(list);*/
		
// ListIterator
		List<Integer> listInt = new ArrayList();
		Random rnd = new Random();
		listInt.add(10);
		listInt.add(20);
		listInt.add(12);
		listInt.add(13);
		listInt.add(5);
		/*System.out.println(listInt);
		for(ListIterator<Integer> listIt = listInt.listIterator(); listIt.hasNext();) {
			System.out.print(listIt.next() + ", ");
		}
		System.out.println();
		System.out.println();
		for(ListIterator<Integer> listPIt = listInt.listIterator(listInt.size()); listPIt.hasPrevious();) {
			System.out.print(listPIt.previous() + ", ");
			if (listInt.get(listPIt.previousIndex()) == 6) {
				System.out.println();
				System.out.println("Index of 6 is: " + listPIt.previousIndex());
			}
		}
		System.out.println();*/
		System.out.println(listInt);
		replace(listInt, 12, 15);
		System.out.println(listInt);
		replace2(listInt, 15, (List<Integer>) Arrays.asList(25));
		System.out.println(listInt);
		List<Integer> subListInt = listInt.subList(3, listInt.size());
		subListInt.clear();
		System.out.println(listInt);
		
	}

}
