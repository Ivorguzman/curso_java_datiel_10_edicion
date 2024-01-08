package genericos.motivacion_Pag763;

public class MetodosSobrecargados {
	// método imprimirArreglo para metodo sobrecargado imprimir arreglo Integer

	public static void imprimirArreglo(int arregloEntrada[])

	{

		// muestra los elementos del arreglo

		for (int elemento : arregloEntrada){
			System.out.printf("%s ", elemento);
		}

		System.out.println();

	} // fin del método imprimirArreglo


	// método imprimirArreglo para metodo sobrecargado imprimir arreglo Double

	public static void imprimirArreglo(double arregloEntrada[])

	{

		// muestra los elementos del arreglo

		for (double elemento : arregloEntrada){
			System.out.printf("%s ", elemento);
		}


		System.out.println();

	} // fin del método imprimirArreglo


	// método imprimirArreglo para metodo sobrecargado imprimir arreglo Character

	public static void imprimirArreglo(char arregloEntrada[])

	{

		// muestra los elementos del arreglo

		for (Character elemento : arregloEntrada){
			System.out.printf("%s ", elemento);
		}


		System.out.println();

	} // fin del método imprimirArreglo


	public static void main(String args[])

	{

		// crea arreglos de objetos Integer, Double y Character

		int[] arregloInteger = {
				1, 2, 3, 4, 5, 6
		};

		double[] arregloDouble = {
				1.1, 2.2, 3.3, 4.4, 5.5, 6.6, 7.7
		};

		char[] arregloCharacter = {
				'H', 'O', 'L', 'A'
		};


		System.out.println("El arreglo arregloInteger contiene:");

		imprimirArreglo(arregloInteger); // pasa un arreglo Integer

		System.out.println("\n El arreglo arregloDouble contiene:");

		imprimirArreglo(arregloDouble); // pasa un arreglo Double

		System.out.println("\n El arreglo arregloCharacter contiene:");

		imprimirArreglo(arregloCharacter); // pasa un arreglo Character

	} // fin de main

}
