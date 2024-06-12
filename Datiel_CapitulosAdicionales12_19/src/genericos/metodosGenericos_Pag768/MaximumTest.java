package genericos.metodosGenericos_Pag768;

// El método genérico maximo devuelve el mayor de tres objetos.

/*
 * Este fragmento de código es una implementación de un método llamado maximo. Analicemos cada
 * parte:
 * 
 * Declaración del método:
 * El método maximo toma tres argumentos de tipo Comparable: x, y y z.
 * El objetivo del método es encontrar el objeto más grande entre los tres.
 * 
 * Inicialización de la variable max:
 * Se crea una variable max y se le asigna el valor de x.
 * Inicialmente, asumimos que x es el objeto más grande.
 * 
 * Comparación con y:
 * Se imprime el valor de max.
 * Luego, se compara y con max utilizando y.compareTo(max).
 * Si y es mayor que max, actualizamos max con el valor de y.
 * 
 * Comparación con z:
 * Se imprime el resultado de z.compareTo(max).
 * Si z es mayor que max, actualizamos max con el valor de z.
 * 
 * Retorno del objeto más grande:
 * Finalmente, el método devuelve el objeto max, que representa el objeto más grande entre los tres.
 * En resumen, este código implementa una función que compara tres objetos Comparable y devuelve el
 * objeto más grande. La comparación se basa en el método compareTo definido en la interfaz
 */




/*
 * // utilización del borrado Del complilador
 * 
 * public static Comparable maximo(Comparable x, Comparable y, Comparable z) {
 * 
 * }
 * Comparable max = x;
 * 
 * 
 * // suponga que al principio x es el más grande
 * System.out.println("(max) ==> " + max);
 * System.out.println("y.compareTo(max) ==> " + y.compareTo(max));
 * 
 * 
 * if (y.compareTo(max) > 0){
 * max = y; // y es el mayor hasta ahora
 * }
 * 
 * 
 * 
 * System.out.println("z.compareTo(max) ==> " + z.compareTo(max));
 * if (z.compareTo(max) > 0){
 * max = z; // z es el mayor 0
 * }
 * 
 * 
 * return max; // devuelve el objeto más grande
 * } // fin del método maximo
 * 
 *
 * 
 * 
 * public static void main(String args[]) {
 * 
 * System.out.printf("Maximo de %d, %d y %d es %d\n\n", 3, 3, 5, maximo(3, 3, 5));
 * 
 * System.out.printf("Maximo de %.1f, %.1f y %.1f es %.1f\n\n", 6.6, 8.8, 7.7, maximo(6.6, 8.8,
 * 7.7));
 * 
 * System.out.printf("Maximo de %s, %s y %s es %s\n", "pera", "manzana", "naranja", maximo("pera",
 * "manzana", "pera"));
 * 
 * }
 * // fin de main
 */




/*
 * Este código es una implementación del método maximo que encuentra el objeto más grande entre tres
 * objetos comparables. Analicemos cada parte:
 * 
 * Declaración del método:
 * El método maximo está definido como genérico <T extends Comparable<T>>.
 * Toma tres argumentos de tipo T (que deben ser comparables): x, y y z.
 * 
 * 
 * Inicialización de la variable max:
 * Se crea una variable max y se le asigna el valor de x.
 * Inicialmente, asumimos que x es el objeto más grande.
 * 
 * 
 * Comparación con y:
 * Si y es mayor que max (según el resultado de y.compareTo(max)), actualizamos max con el valor de
 * y.
 * Comparación con z:
 * Si z es mayor que max (según el resultado de z.compareTo(max)), actualizamos max con el valor de
 * z.
 * 
 * 
 * Retorno del objeto más grande:
 * Finalmente, el método devuelve el objeto max, que representa el objeto más grande entre los tres.
 * En resumen, este método utiliza la interfaz Comparable para comparar los objetos y determinar
 * cuál es el más grande. Es una implementación elegante y reutilizable para encontrar el máximo
 * entre tres elementos comparables.
 * 
 * 
 * Nota: Las declaraciones de los parámetros de tipo que delimitan el parámetro(<T extends
 * Comparable<T>>) siempre utilizan la palabra clave extends,
 * sin importar que el parámetro de tipo extienda a una clase o implemente a una interfaz.
 */


// Fig. 18.5: MaximumTest.java
// Generic method maximum returns the largest of three objects.

public class MaximumTest {
	// determines the largest of three Comparable objects
	public static <T extends Comparable<T>> T maximum(T x, T y, T z) {

		T max = x; // assume x is initially the largest

		if (y.compareTo(max) > 0){
			max = y;
		} // y is the largest so far


		if (z.compareTo(max) > 0){
			max = z;
		} // z is the largest


		return max; // returns the largest object
	} // end method maximum




	public static void main(String args[]) {
		System.out.printf("Maximum of %d, %d and %d is %d\n\n", 3, 4, 5, maximum(3, 4, 5));

		System.out.printf("Maximum of %.1f, %.1f and %.1f is %.1f\n\n", 6.6, 8.8, 7.7, maximum(6.6, 8.8, 7.7));

		System.out.printf("Maximum of %s, %s and %s is %s\n", "pear", "apple", "orange", maximum("pear", "apple", "orange"));
	} // end main
}
// end class MaximumTest
