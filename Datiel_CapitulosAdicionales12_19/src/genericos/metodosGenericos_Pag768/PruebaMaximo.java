package genericos.metodosGenericos_Pag768;

// El método genérico maximo devuelve el mayor de tres objetos.


public class PruebaMaximo {


	/*
	 * 
	 * // *********** utilización del borrado ***********
	 * 
	 * 
	 * public static Comparable maximo(Comparable x, Comparable y, Comparable z) {
	 * 
	 * Comparable max = x;
	 * 
	 * // suponga que al principio x es el más grande
	 * System.out.println("(max) ==> " + max);
	 * System.out.println("y.compareTo(max) ==> " + y.compareTo(max));
	 * if (y.compareTo(max) > 0){
	 * max = y; // y es el mayor hasta ahora
	 * }
	 * 
	 * System.out.println("z.compareTo(max) ==> " + z.compareTo(max));
	 * if (z.compareTo(max) > 0){
	 * max = z; // z es el mayor 0
	 * }
	 * 
	 * return max; // devuelve el objeto más grande
	 * } // fin del método maximo
	 * 
	 * 
	 * public static void main(String args[]) {
	 * 
	 * System.out.printf("Maximo de %d, %d y %d es %d\n\n", 3, 3, 5, (Integer) maximo(3, 3, 5));
	 * 
	 * System.out.printf("Maximo de %.1f, %.1f y %.1f es %.1f\n\n", 6.6, 8.8, 7.7, (Double) maximo(6.6, 8.8, 7.7));
	 * 
	 * System.out.printf("Maximo de %s, %s y %s es %s\n", "pera", "manzana", "naranja", (String) maximo("pera", "manzana", "pera"));
	 * 
	 * } // fin de main
	 * 
	 * } // fin de la clase PruebaMaximo
	 * 
	 * 
	 * 
	 */


	/*
	 * Nota: Las declaraciones de los parámetros de tipo que delimitan el parámetro(<T extends Comparable<T>>) siempre utilizan la
	 * palabra clave extends, sin importar que el parámetro de tipo extienda a una clase o implemente a una interfaz.
	 */
	// determina el mayor de tres objetos Comparable
	public static <T extends Comparable<T>> T maximo(T x, T y, T z)

	{

		T max = x; // asume que x es el mayor, en un principio


		if (y.compareTo(max) > 0){
			max = y; // y es el mayor hasta ahora
		}


		if (z.compareTo(max) > 0){
			max = z; // z es el mayor
		}


		return max; // devuelve el objeto más grande

	} // fin del método maximo




	public static void main(String args[])

	{

		System.out.printf("Maximo de %d, %d y %d es %d\n\n", 3, 3, 5, maximo(3, 3, 5));

		System.out.printf("Maximo de %.1f, %.1f y %.1f es %.1f\n\n", 6.6, 8.8, 7.7, maximo(6.6, 8.8, 7.7));

		System.out.printf("Maximo de %s, %s y %s es %s\n", "pera", "manzana", "naranja", maximo("pera", "manzana", "pera"));


	} // fin de main

} // fin de la clase PruebaMaximo
 
