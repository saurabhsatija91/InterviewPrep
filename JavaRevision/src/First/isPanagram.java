package First;

import java.util.Arrays;

public class isPanagram {
	private String str;
	
	public isPanagram (String str) {
		this.str = str;
	}
	
	public boolean isPanagramOf (String other) {
		String str1 = removeJunk(this.str);
		String str2 = removeJunk(other);
		str1 = sort(str1.toLowerCase());
		str2 = sort(str2.toLowerCase());
		
		return str1.equals(str2);
	}
	
	protected static String removeJunk (String string) {
		int i, len = string.length();
		StringBuffer sb = new StringBuffer(len);
		char c;
		
		for (i = 0; i < len; i++) {
			c = string.charAt(i);
			if (Character.isLetter(c))
				sb.append(c);
		}
		
		return sb.toString();
	}
	
	protected static String sort (String string) {
		char[] strArray = string.toCharArray();
		Arrays.sort(strArray);
		return new String(strArray);
	}
	
	public static void main(String[] args) {
		isPanagram app = new isPanagram("Parliament");
		System.out.println(app.isPanagramOf("Partial men"));
	}
}
