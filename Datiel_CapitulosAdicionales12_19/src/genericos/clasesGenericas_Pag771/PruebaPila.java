package genericos.clasesGenericas_Pag771;

// Fig. 18.10: PruebaPila.java

// Programa de prueba de la clase genérica Pila.


public class PruebaPila {

	private double[] elementosDouble = {
			1.1, 2.2, 3.3, 4.4, 5.5, 6.6
	};

	private int[] elementosInteger = {
			1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11
	};


	private Pila<Double> pilaDouble; // pila que almacena objetos Double
	private Pila<Integer> pilaInteger; // pila que almacena objetos Integer
	// prueba objetos Pila

	public void probraPilas() {
		this.pilaDouble = new Pila<Double>(5); // Pila de objetos Double

		this.pilaInteger = new Pila<Integer>(10); // Pila de objetos Integer

		this.pruebaPushDouble(); // mete valor double en pilaDouble

		this.pruebaPopDouble(); // saca de pilaDouble

		this.pruebaPushInteger(); // mete valor int en pilaInteger

		this.pruebaPopInteger(); // saca de pilaInteger

	} // fin del método probarPilas
		 // prueba el método push con la pila de valores double


	public void pruebaPushDouble() {

		// mete elementos en la pila

		try{

			System.out.println("\nMetiendo elementos en pilaDouble");


			// mete elementos en la Pila

			for (double elemento : this.elementosDouble){

				System.out.printf("%.1f ", elemento);

				this.pilaDouble.push(elemento); // mete en pilaDouble

			} // fin de for

		} // fin de try

		catch(ExcepcionPilaLlena excepcionPilaLlena){

			System.err.println();

			excepcionPilaLlena.printStackTrace();

		} // find de catch ExcepcionPilaLlena

	} // fin del método pruebaPushDouble






	// prueba el método pop con una pila de valores double

	public void pruebaPopDouble() {

		// saca elementos de la pila

		try{

			System.out.println("\nSacando elementos de pilaDouble");

			double valorASacar; // almacena el elemento que se eliminó de la pila


			// elimina todos los elementos de la Pila

			while (true){

				valorASacar = this.pilaDouble.pop(); // saca de pilaDouble

				System.out.printf("%.1f ", valorASacar);

			} // fin de while

		} // fin de try

		catch(ExcepcionPilaVacia excepcionPilaVacia){

			System.err.println();

			excepcionPilaVacia.printStackTrace();

		} // fin de catch ExcepcionPilaVacia

	} // fin del método pruebaPopDouble





	// prueba el método push con pila de valores enteros

	public void pruebaPushInteger() {

		// mete elementos a la pila

		try{

			System.out.println("\nMetiendo elementos a pilaInteger");


			// mete elementos a la Pila

			for (int elemento : this.elementosInteger){

				System.out.printf("%d ", elemento);

				this.pilaInteger.push(elemento); // mete a pilaInteger

			} // fin de for

		} // fin de try

		catch(ExcepcionPilaLlena excepcionPilaLlena){

			System.err.println();

			excepcionPilaLlena.printStackTrace();

		} // fin de catch ExcepcionPilaLlena

	} // fin del método pruebaPushInteger






	// prueba el método pop con una pila de enteros

	public void pruebaPopInteger() {

		// saca elementos de la pila

		try{

			System.out.println("\nSacando elementos de pilaInteger");

			int valorASacar; // almacena el elemento que se eliminó de la pila


			// elimina todos los elementos de la Pila

			while (true){

				valorASacar = this.pilaInteger.pop(); // saca de pilaInteger
				System.out.printf("%d ", valorASacar);

			} // fin de while

		} // fin de try

		catch(ExcepcionPilaVacia excepcionPilaVacia){

			System.err.println();

			excepcionPilaVacia.printStackTrace();

		} // fin de catch ExcepcionPilaVacia

	} // fin del método pruebaPopInteger






} // fin de la clase PruebaPila
