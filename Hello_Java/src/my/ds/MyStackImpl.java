package my.ds;

public class MyStackImpl {
	private int stackSize = 0;
	private int[] stackArr;
	private int top;
	
	MyStackImpl (int size) {
		this.stackSize = size;
		this.stackArr = new int[this.stackSize];
		this.top = -1;
	}
	
	/* This adds element to the top
	 * of the stack.
	 * @param elem
	 * @throws Exception 
	 */
	public void push (int elem) throws Exception {
		if(this.isStackFull()) {
			throw new Exception("Stack is full.");
		}
		System.out.println("Adding: " + elem);
		this.stackArr[++top] = elem;
	}
	
	/* This removes elem from the
	 * top of the stack.
	 * @throws Exception
	 */
	public int pop() throws Exception{
		if(this.isStackEmpty())
			throw new Exception("Stack is empty");
		int a = this.stackArr[top--];
		System.out.println("Removed elem: " + a);
		return a;
	}
	
	public int peek() {
		return this.stackArr[top];
	}
	
	public boolean isStackFull() {
		return (top == this.stackSize - 1);
	}
	
	public boolean isStackEmpty() {
		return (top == -1);
	}
	
	public static void main(String[] args) {
        MyStackImpl stack = new MyStackImpl(5);
        try {
            stack.push(4);
            stack.push(8);
            stack.push(3);
            stack.push(89);
            stack.pop();
            stack.push(34);
            stack.push(45);
            stack.push(78);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        try {
            stack.pop();
            stack.pop();
            stack.pop();
            stack.pop();
            stack.pop();
            stack.pop();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
