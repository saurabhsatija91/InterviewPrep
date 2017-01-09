package Geeks4geeks;

import java.util.Arrays;
import java.util.Collections;

public class Testermain {
	public static void main(String[] args) {
		Integer[] array = {2, 5, 1, 7, 6, 0, 9};
		Arrays.sort(array, Collections.reverseOrder());
		for (Integer num : array)
			System.out.print(num.toString() + " ");
	}
}
