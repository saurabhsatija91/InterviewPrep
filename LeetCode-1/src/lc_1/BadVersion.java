package lc_1;

public class BadVersion {
	private static int[] versions = {2, 3, 1, 7, 5, 6, 9, 0, 12, 34};
	
	private static boolean isBadVersion (int ver) {
		return versions[ver] == 6;
	}
	
	/*public int badVersion (int n) {
		int left = 0;
		int right = n - 1;
		int mid = left + (right = left) / 2;
		
		if (isBadVersion(mid))
			right = mid;
		else
			left = mid + 1;
	}*/
}
