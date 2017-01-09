package Hackerrank;

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
}
