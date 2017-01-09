package First;

import java.util.function.Consumer;

public class LambdaScopTest {
	public int x = 0;
	
	class FirstLevel {
		public int x = 1;
		
		void methodInFirstLevel(int x) {
			Consumer<Integer> myConsumer = (y) -> {
				System.out.println("x = " + x);
				System.out.println("y = " + y);
				System.out.println("this.x = " + this.x);
				System.out.println("LambdaScopeTest.this.x = " + LambdaScopTest.this.x);
			};
			
			myConsumer.accept(x);
		}
		
	}
	
	public static void main(String[] args) {
		LambdaScopTest st = new LambdaScopTest();
		LambdaScopTest.FirstLevel fl = st.new FirstLevel();
		
		fl.methodInFirstLevel(23);
	}
}
