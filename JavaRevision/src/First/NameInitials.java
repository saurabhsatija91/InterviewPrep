package First;

public class NameInitials {
	String fullname;
	
	public NameInitials (String fullname) {
		this.fullname = fullname;
	}
	
	public void getInitials () {
		String[] names = fullname.split(" ");
		for (int i = 0; i < names.length; i++) {
			System.out.print(names[i].charAt(0) + " ");
		}
	}
	
	public static void main(String[] args) {
		NameInitials myApp = new NameInitials("Saurabh S. Satija");
		
		myApp.getInitials();
	}
}
