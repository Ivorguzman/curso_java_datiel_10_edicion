package genericos.motivacion_Pag763;

// Uso de métodos genéricos para imprimir arreglos de distintos tipos.


public class PruebaMetodoGenerico

{


	// (utilización del borrado)
	public static void imprimirArreglo(Object arregloEntrada[], Object arregloEntrada2[], Object arregloEntrada3[])

	{

		// muestra los elementos del arreglo
		System.out.println(" El arreglo arregloInteger contiene:");
		for (Object elemento : arregloEntrada){
			System.out.printf("%s ", elemento);
		}
		System.out.println();


		// muestra los elementos del arreglo
		System.out.println("\n El arreglo arregloDouble contiene:");
		for (Object elemento2 : arregloEntrada2){
			System.out.printf("%s ", elemento2);
		}
		System.out.println();


		// muestra los elementos del arreglo
		System.out.println("\n El arreglo arregloCharacter contiene:");
		for (Object elemento3 : arregloEntrada3){
			System.out.printf("%s ", elemento3);
		}
		System.out.println();


	}	// fin del método imprimirArreglo




	/*
	 * // Uso de Genericos
	 * public static <T> void imprimirArreglo(T arregloEntrada[], T arregloEntrada2[], T arregloEntrada3[])
	 * 
	 * {
	 * 
	 * // muestra los elemGentos del arreglo
	 * System.out.println(" El arreglo arregloInteger contiene:");
	 * 
	 * for (T elemento : arregloEntrada){
	 * System.out.printf("%s ", elemento);
	 * }
	 * System.out.println();
	 * 
	 * 
	 * // muestra los elementos del arreglo
	 * System.out.println("\n El arreglo arregloDouble contiene:");
	 * for (T elemento2 : arregloEntrada2){
	 * System.out.printf("%s ", elemento2);
	 * }
	 * System.out.println();
	 * 
	 * 
	 * // muestra los elementos del arreglo
	 * System.out.println("\n El arreglo arregloCharacter contiene:");
	 * for (T elemento3 : arregloEntrada3){
	 * System.out.printf("%s ", elemento3);
	 * }
	 * System.out.println();
	 * 
	 * } // fin del método imprimirArreglo
	 * 
	 */


	public static void main(String args[])

	{
		// crea arreglos de objetos Integer, Double y Character
		Integer arregloInteger[] = {
				1, 2, 3, 4, 5, 6
		};

		Double arregloDouble[] = {
				1.1, 2.2, 3.3, 4.4, 5.5, 6.6, 7.7
		};

		Character arregloCharacter[] = {
				'H', 'O', 'L', 'A'
		};

		imprimirArreglo(arregloInteger, arregloDouble, arregloCharacter); // pasa los arreglos Integer, Double, Character

	} // fin de main

} // fin de la clase PruebaMetodoGeneri
