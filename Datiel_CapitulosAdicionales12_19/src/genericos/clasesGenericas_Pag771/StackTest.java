package genericos.clasesGenericas_Pag771;

// Fig. 18.10: StackTest.java
// Stack generic class test program.

public class StackTest {
	private double[] doubleElements = { 1.1, 2.2, 3.3, 4.4, 5.5, 6.6 };
	private int[] integerElements = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11 };

	private Stack<Double> doubleStack; // stack stores Double objects
	private Stack<Integer> integerStack; // stack stores Integer objects



	// test Stack objects
	public void testStacks() {
		this.doubleStack = new Stack<Double>(5); // Stack of Doubles
		this.integerStack = new Stack<Integer>(10); // Stack of Integers

		this.testPushDouble(); // push double onto doubleStack
		this.testPopDouble(); // pop from doubleStack
		this.testPushInteger(); // push int onto intStack
		this.testPopInteger(); // pop from intStack
	} // end method testStacks




	// test push method with double stack
	public void testPushDouble() {
		// push elements onto stack
		try{
			System.out.println("\nPushing elements onto doubleStack");

			// push elements to Stack
			for (double element : this.doubleElements){
				System.out.printf("%.1f ", element);
				this.doubleStack.push(element); // push onto doubleStack
			} // end for
		} // end try
		catch(FullStackException fullStackException){
			System.err.println();
			fullStackException.printStackTrace();
		} // end catch FullStackException
	} // end method testPushDouble




	// test pop method with double stack
	public void testPopDouble() {
		// pop elements from stack
		try{
			System.out.println("\nPopping elements from doubleStack");
			double popValue; // store element removed from stack

			// remove all elements from Stack
			while (true){
				popValue = this.doubleStack.pop(); // pop from doubleStack
				System.out.printf("%.1f ", popValue);
			} // end while
		} // end try
		catch(EmptyStackException emptyStackException){
			System.err.println();
			emptyStackException.printStackTrace();
		} // end catch EmptyStackException
	} // end method testPopDouble




	// test push method with integer stack
	public void testPushInteger() {
		// push elements to stack
		try{
			System.out.println("\nPushing elements onto integerStack");

			// push elements to Stack
			for (int element : this.integerElements){
				System.out.printf("%d ", element);
				this.integerStack.push(element); // push onto integerStack
			} // end for
		} // end try
		catch(FullStackException fullStackException){
			System.err.println();
			fullStackException.printStackTrace();
		} // end catch FullStackException
	} // end method testPushInteger




	// test pop method with integer stack
	public void testPopInteger() {
		// pop elements from stack
		try{
			System.out.println("\nPopping elements from integerStack");
			int popValue; // store element removed from stack

			// remove all elements from Stack
			while (true){
				popValue = this.integerStack.pop(); // pop from intStack
				System.out.printf("%d ", popValue);
			} // end while
		} // end try
		catch(EmptyStackException emptyStackException){
			System.err.println();
			emptyStackException.printStackTrace();
		} // end catch EmptyStackException
	} // end method testPopInteger



	public static void main(String args[]) {
		StackTest application = new StackTest();
		application.testStacks();
	} // end main
} // end class StackTest
