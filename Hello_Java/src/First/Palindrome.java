package First;

public class Palindrome {
	public static void main(String[] args) {
/*		String palindrome = "Dot saw was Tod";
		int len = palindrome.length();
		char[] charArray = new char[len];
		char[] revCharArray = new char[len];
		
		for (int i = 0; i < len; i++) {
			charArray[i] = palindrome.charAt(i);
		}
	
		palindrome.getChars(0, len, charArray, 0);
		
		for (int i = 0; i < len; i++) {
			revCharArray[i] = palindrome.charAt(len - i - 1);
		}
		
		String revPalindrome = new String(revCharArray);
		System.out.println(revPalindrome);
		
		String tmp = palindrome.toLowerCase();
		System.out.println(tmp + tmp.hashCode() + " " + palindrome.hashCode());
		
		String str = "Saurabh Suresh Satija";
		System.out.println(str.contains("s") + " " + str.toLowerCase() + " "
				+ str.toLowerCase().indexOf("ur", 3) + " " + str.lastIndexOf("ur", 8));
		
		String str1 = "Hello. World, Fuck, You";
		String[] strArray = str1.split(",");
		for (String s : strArray)
			System.out.println(s.trim());
		
		System.out.println(str.replace("a", "*") + " " + str.replace("ur", "##") + " " +
		str1.replaceAll(",", "@"));
		
		String str2 = "Sau Suresh Satija";
		System.out.println(str.toLowerCase().compareToIgnoreCase(str2));
		System.out.println(str.startsWith("aur", 1));
		System.out.println(str.equalsIgnoreCase(str2));
		System.out.println(str.regionMatches(8, str2, 4, 6));
*/
		String str = "Saurabh Suresh Satija";
		System.out.println(str.contains("s") + " " + str.toLowerCase() + " "
				+ str.toLowerCase().indexOf("ur", 3) + " " + str.lastIndexOf("ur", 8));
		
		
		StringBuilder sb = new StringBuilder();
		System.out.println(sb.length());
		System.out.println(sb.capacity());
		sb.append("Greetings");
		System.out.println(sb.length());
		System.out.println(sb.capacity());
		
		char[] charArr = {'H', 'E', 'L', 'L', 'O'};
		System.out.println(sb.append(charArr, 1, 4));
		sb.delete(4, 8);
		System.out.println(sb);
		sb.deleteCharAt(0);
		System.out.println(sb + "fdsfds");
		
		String myName = "Fred F. Flintstone";
        StringBuffer myInitials = new StringBuffer();
        int length = myName.length();

        for (int i = 0; i < length; i++) {
            if (Character.isUpperCase(myName.charAt(i))) {
                myInitials.append(myName.charAt(i));
            }
        }
        System.out.println("My initials are: " + myInitials);
	}
}
