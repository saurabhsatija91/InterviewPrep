package First;

public class HelloWorldAnonymousClass {
	interface HelloWorld {
		public void greet();
		public void greetSomeone(String someone);
	}
	
	public void sayHello() {
		class EnglishGreeting implements HelloWorld {
			public void greet() {
				greetSomeone("world");
			}
			public void greetSomeone(String someone) {
				System.out.println("Hello " + someone);
			}
		}
		
		HelloWorld frenchGreeting = new HelloWorld() {
			public void greet() {
				greetSomeone("tout de monde");
			}
			public void greetSomeone(String someone) {
				System.out.println("Salut " + someone);
			}
		};
		
		HelloWorld spanishGreeting = new HelloWorld() {
			public void greet() {
				greetSomeone("mundo");
			}
			public void greetSomeone(String someone) {
				System.out.println("Hola " + someone);
			}
		};
		
		EnglishGreeting englishGreeting = new EnglishGreeting();
		
		englishGreeting.greet();
		frenchGreeting.greetSomeone("Saurabh");
		spanishGreeting.greetSomeone("Saurabh");
	}
	
	public static void main(String[] args) {
		HelloWorldAnonymousClass myApp = new HelloWorldAnonymousClass();
		myApp.sayHello();
	}
}
