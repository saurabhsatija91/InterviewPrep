package Geeks4geeks;
import java.util.*;

public class segregateEvenOddLinkedList {
	public static List<Integer> sortList (List<Integer> inList) {
		LinkedList<Integer> sortedList = new LinkedList<Integer>();
		
		List<Integer> evenList = new ArrayList<Integer>();
		List<Integer> oddList = new ArrayList<Integer>();
		for (Integer i : inList) {
			if (i % 2 == 0) {
				evenList.add(i);
			} else {
				oddList.add(i);
			}
		}
		Collections.sort(evenList);
		Collections.sort(oddList);
		sortedList.addAll(oddList);
		sortedList.addAll(evenList);
		
		return sortedList;
	}
}
