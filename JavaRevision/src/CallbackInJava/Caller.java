package CallbackInJava;

interface CallBack {
	void methodToCallback();
}

class CallbackImpl implements CallBack {
	public void methodToCallback() {
		System.out.println("I have been called back");
	}
}

public class Caller {
	public void register (CallBack callback) {
		callback.methodToCallback();
	}
	
	public static void main(String[] args) {
		Caller caller = new Caller();
		CallBack callback = new CallbackImpl();
		caller.register(callback);
	}
}
