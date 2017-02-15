package Hackerrank;

import java.util.*;

public class CoinChange {
	public static long makeChange(int[] coins, int money) {
        long[] DP = new long[money + 1]; // O(N) space.
        DP[0] = (long)1; 	// n == 0 case.
        for(int i = 0 ; i < coins.length; i++) {
            int coin = coins[i];
            for(int j = coin; j < DP.length; j++) {
            // The only tricky step.
                DP[j] += DP[j - coin];
            }   
        }       
        return DP[money];
    }
	
	public static long coinChange(int[] coin, int money) {
		return coinChange(coin, money, 0, new HashMap<String, Long>());
	}
	
	private static long coinChange(int[] coin, int money, int index,
												HashMap<String, Long> memo) {
		if (money == 0) {
			return 1;
		}
		
		if (index >= coin.length) {
			return 0;
		}
		
		String key = money + "-" +index;
		if (memo.containsKey(key)) {
			return memo.get(key);
		}
		
		int amountWithCoin = 0;
		long ways = 0;
		
		while (amountWithCoin <= money) {
			int remaining = money = amountWithCoin;
			ways += coinChange (coin, money, index + 1, memo);
			amountWithCoin += coin[index];
		}
		memo.put(key, ways);
		return ways;
	}
}
