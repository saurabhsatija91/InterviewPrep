package Geeks4geeks;
import java.util.*;

class Interval {
	int buy;
	int sell;
}

public class MaximumDifferenceOfArray {
	public static int maxDiff (int[] arr) {
		int maxDiff = arr[1] - arr[0];
		int min = arr[0];
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] - min > maxDiff) {
				maxDiff = arr[i] - min;
			}
			if (arr[i] < min)
				min = arr[i];
		}
		
		return maxDiff;
	}
	
	public static void stockBuySell (int[] price) {
		int n = price.length;
		if (n == 1)
			return;
		int count = 0, i = 0;
		ArrayList<Interval> sol = new ArrayList<>();
		while (i < n - 1) {
			while ((i < n - 1) && (price[i+1] <= price[i]))
				i++;
			if (i == n - 1)
				break;
			Interval e = new Interval();
			e.buy = i++;
			
			while((i < n) && (price[i] >= price[i-1]))
				i++;
			e.sell = i - 1;
			
			sol.add(e);
			
			count++;
		}
		
		for (int j = 0; j < count; j++) {
			System.out.println("Buy on " + sol.get(j).buy +
					" and sell on " + sol.get(j).sell);
		}
	}
	
	public static void main(String[] args) {
		int[] arr = {17, 2, 90, 10, 110};
		System.out.println(maxDiff(arr));
		
		int[] price = {100, 180, 260, 310, 40, 535, 695};
		
		stockBuySell(price);
	}
}
