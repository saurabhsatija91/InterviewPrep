package First;

public class CharSequenceDemo implements CharSequence{
	private String s;
	
	CharSequenceDemo (String s) {
		this.s = s;
	}
	
	private int fromEnd(int i) {
		return  s.length() - 1 - i;
	}

	public char charAt(int i) {
		if (i < 0 || i > s.length())
			throw new StringIndexOutOfBoundsException(i);
		
		return s.charAt(fromEnd(i));
	}
	
	public int length() {
		return s.length();
	}
	
	public CharSequence subSequence(int start, int end) {
		if (start < 0)
			throw new StringIndexOutOfBoundsException(start);
		if (end > s.length())
			throw new StringIndexOutOfBoundsException(end);
		if (start > end)
			throw new StringIndexOutOfBoundsException(start - end);
		
		StringBuilder sub = new StringBuilder(s.subSequence(fromEnd(end), fromEnd(start)));
		return sub.reverse();
	}
	
	public String toString() {
		StringBuilder s = new StringBuilder(this.s);
		return s.reverse().toString();
	}
	
	private static int random(int max) {
		return (int) Math.random() * (max + 1);
	}
	
	public static void main(String[] args) {
		CharSequenceDemo str = new CharSequenceDemo("What the fuck is this program. Seriously lame.");
		
		System.out.println(str.charAt(5));
		System.out.println(str.subSequence(0, str.length() - 1));
		
	}
}
