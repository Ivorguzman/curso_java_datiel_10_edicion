 package genericos.motivacion_Pag763;

// Fig. 18.3: GenericMethodTest.java
// Using generic methods to print arrays of different types.

public class GenericMethodTest {

	// generic method printArray
	public static <E> void printArray(E[] inputArray) {
		System.out.println(inputArray[4]);
		// display array elements
		for (E element : inputArray){

			System.out.printf("%s ", element);
		}
		System.out.println();
	} // end method printArray



	public static void main(String args[]) {
		// create arrays of Integer, Double and Character
		Integer[] integerArray = { 1, 2, 3, 4, 5, 6 };
		Double[] doubleArray = { 1.1, 2.2, 3.3, 4.4, 5.5, 6.6, 7.7 };
		Character[] characterArray = { 'H', 'E', 'L', 'L', 'O' };

		System.out.println("Array integerArray 1contains:");
		GenericMethodTest.printArray(integerArray); // pass an Integer array

		System.out.println("\nArray doubleArray contains:");
		printArray(doubleArray); // pass a Double array OjO Sin utilizar la invocación de la clase(GenericMethodTest.printArray)

		System.out.println("\nArray characterArray contains:");
		GenericMethodTest.printArray(characterArray); // pass a Character array
	} // end main
} // end class GenericMethodTest
