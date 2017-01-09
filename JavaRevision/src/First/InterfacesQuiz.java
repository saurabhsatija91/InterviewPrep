package First;

public class InterfacesQuiz implements CharSequence{
	private String str;
	public InterfacesQuiz (String str) {
		this.str = str;
	}
	
	private int fromEnd (int ind) {
		return str.length() - ind - 1;
	}
	
	public char charAt(int index) {
		if (index < 0 || index >= str.length()) {
			throw new StringIndexOutOfBoundsException(index);
		}
		return this.str.charAt(fromEnd(index));
	}
	public int length() {
		return str.length();
	}
	public CharSequence subSequence(int start, int end) {
		if (start < 0) {
			throw new StringIndexOutOfBoundsException(start);
		}
		if (end > str.length())
			throw new StringIndexOutOfBoundsException(end);
		if (start > end)
			throw new StringIndexOutOfBoundsException(start - end);
		
		StringBuilder sb = new StringBuilder(str.substring(fromEnd(end), fromEnd(start)));
		return sb.reverse();
	}
	public String toString() {
		StringBuilder sb = new StringBuilder(str);
		return sb.reverse().toString();
	}
	
	public static void main(String[] args) {
		InterfacesQuiz mySol = new InterfacesQuiz("Saurabh Satija");
		System.out.println(mySol.charAt(2));
		System.out.println(mySol.length());
		System.out.println(mySol.subSequence(1, 6));
		System.out.println(mySol);
	}
}
