package First;

public class LocalClassExample {
	static String regularExpression = "[^0-9]";
	
	public static void validatePhoneNumber(String phoneNumber1, String phoneNumber2) {
		int numberLength = 10;
		
		class PhoneNumber {
			String formatedPhoneNumber = null;
			
			PhoneNumber (String phoneNumber) {
				String currentPhoneNumber = phoneNumber.replaceAll(regularExpression, "");
				if (currentPhoneNumber.length() == numberLength)
					formatedPhoneNumber = currentPhoneNumber;
				else
					formatedPhoneNumber = null;
			}
			
			public String getPhoneNumber() {
				return formatedPhoneNumber;
			}
			
			public void printOriginalNumbers() {
				System.out.println("Original numbers are:" + phoneNumber1 + " and " + phoneNumber2);
			}
		}
		
		PhoneNumber myPhone1 = new PhoneNumber(phoneNumber1);
		PhoneNumber myPhone2 = new PhoneNumber(phoneNumber2);
		
		if (myPhone1.getPhoneNumber() == null)
			System.out.println("First number is invalid");
		else
			System.out.println("First number is: " + myPhone1.getPhoneNumber());
		
		if (myPhone2.getPhoneNumber() == null)
			System.out.println("Second number is invalid");
		else
			System.out.println("Second number is: " + myPhone2.getPhoneNumber());
		
		myPhone1.printOriginalNumbers();
	}
	
	public static void main(String[] args) {
		validatePhoneNumber("480-A34-7110", "480333");
	}
}
