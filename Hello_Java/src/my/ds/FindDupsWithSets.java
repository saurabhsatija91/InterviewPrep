package my.ds;

import java.util.*;
import java.util.stream.*;

public class FindDupsWithSets {
/*	public static void main(String[] args) {
		Set<String> distinctWords = Arrays.asList(args).stream()
				.collect(Collectors.toSet());
		System.out.println(distinctWords.size() + " distinct words are :" + distinctWords);
		
	}
*/
	public static void main(String[] args) {
		Set<String> a = new TreeSet<>();
		for (String s : args)
			a.add(s);
		System.out.println(a.size() + " distinct words are :" + a);
	}
}
