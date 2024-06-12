package genericos.clasesGenericas_Pag771;

// Fig. 18.7: Stack.java
// Generic class Stack.

public class Stack<E> {
	private final int size; // number of elements in the stack
	private int top; // location of the top element
	private E[] elements; // array that stores stack elements

	// no-argument constructor creates a stack of the default size
	public Stack( ) {
		this(10); // default stack size
	} // end no-argument Stack constructor

	// constructor creates a stack of the specified number of elements
	public Stack(int s) {
		this.size = s > 0 ? s : 10; // set size of Stack
		this.top = -1; // Stack initially empty

		this.elements = (E[]) new Object[this.size]; // create array
	} // end one-argument Stack constructor

	// push element onto stack; if successful, return true;
	// otherwise, throw FullStackException
	public void push(E pushValue) {
		if (this.top == this.size - 1){ // if stack is full
	throw new FullStackException( String.format(
	         "Stack is full, cannot push %s", pushValue ) );
}

this.elements[++this.top] = pushValue; // place pushValue on Stack
} // end method push

// return the top element if not empty; else throw EmptyStackException
public E pop() {
	if (this.top == -1){ // if stack is empty
	throw new EmptyStackException( "Stack is empty, cannot pop" );
}

return this.elements[this.top--]; // remove and return top element of Stack
} // end method pop
} // end class Stack< E >