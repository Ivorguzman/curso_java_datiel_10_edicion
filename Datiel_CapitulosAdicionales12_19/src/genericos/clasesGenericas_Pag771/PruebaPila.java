package genericos.clasesGenericas_Pag771;

// Fig. 18.10: PruebaPila.java
// Programa de prueba de la clase genérica Pila.

/*
 * clase public class PruebaPila(), es la que contiene métodos y propiedades relacionadas
 * con la manipulación de pilas.
 * La clase PruebaPila se utiliza para organizar y agrupar funcionalidades
 * relacionadas con las pilas, mientras que el método pruebaPilas()
 * es una parte específica de esa funcionalidad.
 */
public class PruebaPila {
	// Creamon dos areglos tipo Clase Double y Clase Integer
	// private double[] elementosDouble = { 1.1, 2.2, 3.3, 4.4, 5.5 };
	private double[] elementosDouble = { 1.1, 2.2, 3.3, 4.4, 5.5, 6.6 };
	private int[] elementoInteger = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11 };

	// Se crea un objeto Pila que Almacena objetos de tipo double
	private Pila<Double> pilaDouble;

	// Se crea un objeto Pila que almacena objetos de tipo Integer
	private Pila<Integer> pilaInteger;







	// *************** Metodos para manipulacion de de la pila ************

	/*
	 * método public void pruebaPilas() dentro de la clase PruebaPila.
	 * Este método se encarga de realizar pruebas y manipulaciones
	 * específicas en las pilas.
	 */
	// metodo pruebaPilas() prueba objetos Pila
	public void pruebaPilas() {
		this.pilaDouble = new Pila<Double>(5);// Pila de objetos Double
		this.pilaInteger = new Pila<Integer>(10);// Pila de objetos Integer

		// invocando Metodos que modifican el contenido de la pila
		this.pruebaPushDouble();


	}

	// Este metodo pruebaPushDouble() mete elementos de tipo double en la pila
	public void pruebaPushDouble() {

		try{
			System.out.println("\nMetiendo elementos en la PilaDouble");

			// mete elementos en la Pila
			for (double elemento : this.elementosDouble){

				System.out.printf("%.1f", elemento);

				// mete en pilaDouble
				this.pilaDouble.push(elemento);
			} // fin del for

		} // fin del try
		catch(ExcepcionPilaLlena Ex_PilaLlena){
			System.err.println();
			Ex_PilaLlena.printStackTrace();
		}// find del catch ExcepcionPilaLlena
	}// fin del método pruebaPushDouble

	
	

	// Este metodo pruebaPophDouble() saca elementos de tipo double en la pila
	// public void pruebaPopDouble() { }

	







}



















