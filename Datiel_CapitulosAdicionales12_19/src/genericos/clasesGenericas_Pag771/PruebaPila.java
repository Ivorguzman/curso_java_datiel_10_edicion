package genericos.clasesGenericas_Pag771;

import java.util.Arrays;

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

	// *** Creaciòn de las Propirdades (VAriables) **********
	// areglos tipo Clase Double y Clase Integer
	private double[] elementosDouble = { 1.1, 2.2, 3.3, 4.4, 5.5, 6.6 };


	private int[] elementosInteger = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11 };


	// Variable o prooiedad de tipo Double
	private Pila<Double> pilaDouble;


	// Variable o prooiedad de tipo Integer
	private Pila<Integer> pilaInteger;






	// *************** Metodos para manipulacion de de la pila ************
	/*
	 * método public void pruebaPilas() dentro de la clase PruebaPila.
	 * Este método se encarga de realizar pruebas y manipulaciones
	 * específicas en las pilas.
	 */
	// metodo pruebaPilas() prueba objetos Pila
	public void probarPila() {

		// Creando y almaceando en las propiedades(variables) la creacion de los nuevos objetos pilaDouble y pilaInteger
		this.pilaDouble = new Pila<Double>(5);// Pila de objetos Double
		this.pilaInteger = new Pila<Integer>(10);// Pila de objetos Integer

		// invocando Metodos que modifican el contenido de la pila

		this.pruebaPushDouble(); // mete valor double en pilaDouble
		this.pruebaPushInteger(); // mete valor int en pilaInteger


		this.pruebaPopDouble(); // saca de pilaDouble
		this.pruebaPopInteger(); // saca de pilaInteger
	}// fin del método pruebaPilas()




	@Override
	public String toString() {
		return "PruebaPila [elementosDouble=" + Arrays.toString(this.elementosDouble) + ", elementoInteger=" + Arrays.toString(this.elementosInteger) + ", pilaDouble="
				+ this.pilaDouble + ", pilaInteger=" + this.pilaInteger + "]";
	}// fin del método toString()






	// Este metodo pruebaPushDouble()
	// mete elementos de tipo double en la pila
	public void pruebaPushDouble() {

		try{
			System.out.println("********** Metiendo elementos en la pilaDouble **********");

			// Imprime el elementos que metera a al pila
			for (double elemento : this.elementosDouble){
				System.out.printf("\nValor  a introducir en la pilaDouble : %,.2f ", elemento);

				// mete el elemento en la pilaDouble
				this.pilaDouble.push(elemento);
				System.out.printf("\n    Valor introducido en la pilaDouble : -> %,.2f ", elemento);
			} // fin del for
		} // fin del try
		catch(ExcepcionPilaLlena excepcionPilaLlena){
			System.err.println();
			excepcionPilaLlena.printStackTrace();
		}// find del catch ExcepcionPilaLlena
	}// fin del método pruebaPushDouble



	// Este metodo pruebaPushInteger()
	// mete elementos de tipo double en la pila
	public void pruebaPushInteger() {
		System.out.println();
		try{
			System.out.println("********* Metiendo elementos a pilaInteger **********");
			// mete elementos a la Pila
			for (int elemento : this.elementosInteger){
				System.out.printf("\nValor  a introducir en la pilaInteger : %d ", elemento);
				this.pilaInteger.push(elemento); // mete a pilaInteger
				System.out.printf("\n    Valor introducido en la pilaInteger : -> %d ", elemento);
			} // fin de for
		} // fin de try
		catch(ExcepcionPilaLlena excepcionPilaLlena){
			System.err.println();
			excepcionPilaLlena.printStackTrace();
		} // fin de catch ExcepcionPilaLlena
	} // fin del método pruebaPushInteger




	/*
	 * Explicación: El método pruebaPopDouble invoca al método pop de Pila en un ciclo while infi nito para
	 * eliminar todos los valores de la pila. Observe en los resultados que los valores se sacan sin duda en el orden último
	 * en entrar, primero en salir (desde luego que ésta es la característica que defi ne a las pilas). El ciclo while continúa hasta que la pila está vacía (es decir, hasta
	 * que ocurre una ExcepcionPilaVacia), lo cual hace que el programa continúe con el bloque catch y maneje la excepción, para que pueda continuar
	 * su ejecución. Cuando el programa de prueba trata de sacar un sexto valor, la pilaDouble está vacía, por lo que
	 * el método pop lanza una ExcepcionPilaVacia. La conversión autoboxing ocurre en la línea (valorASacar = pilaDouble.pop();), en donde el
	 * programa asigna el objeto Double que se sacó de la pila a una variable primitiva double.
	 * 
	 * el compilador inserta operaciones de conversión para asegurar que se devuelvan los tipos apropiados de los
	 * métodos genéricos.
	 * Después del borrado, el método pop de Pila devuelve el tipo Object. Sin embargo, el código
	 * cliente en el método pruebaPopDouble espera recibir un valor double cuando regresa el método pop. Así, el
	 * compilador inserta una conversión a Double, Así, el compilador inserta una conversión a Double, como en
	 * valorASacar = ( Double ) pilaDouble.pop();
	 * para asegurar que se devuelva una referencia del tipo apropiado, que se realice la conversión autounboxing y se
	 * asigne a valorASacar.
	 * 
	 */
	// Este metodo pruebaPophDouble()
	// Saca elementos de tipo double en la pila
	public void pruebaPopDouble() {
		try{
			System.out.println("********* Sacando elementos de la pilaDouble **********");
			double valorASacar; // almacena el elemento que se eliminó de la pila

			// Extracción Continua: El bucle while (true) garantiza que todos los elementos
			// se extraigan uno por uno hasta que la pila esté vacía.
			// El bucle while (true) se ejecutará indefinidamente
			// hasta que ocurra una excepción.
			while (true){
				valorASacar = this.pilaDouble.pop(); // saca de pilaDouble
				System.out.printf("\n    Valor extraido en  la pilaDouble : <- %.2f", valorASacar);
			}// fin de while
		} // fin de try
		catch(ExcepcionPilaVacia excepcionPilaVacia){
			System.err.println();
			excepcionPilaVacia.printStackTrace();
		}// fin de catch ExcepcionPilaVacia
		// El método pruebaPopDouble es una implementación robusta para vaciar una pila
		// y manejar adecuadamente las excepciones que puedan ocurrir durante el proceso.
	}// fin del método pruebaPopDouble





	// Este metodo pruebaPopInteger()
	public void pruebaPopInteger() {
		// saca elementos de la pila
		try{
			System.out.println("********** Sacando elementos de pilaInteger *********");
			int valorASacar; // almacena el elemento que se eliminó de la pila
			// elimina todos los elementos de la Pila
			while (true){
				valorASacar = this.pilaInteger.pop(); // saca de pilaInteger
				System.out.printf("\n    Valor extraido en  la pilaInteger : <- %d", valorASacar);
			} // fin de while
		} // fin de try
		catch(ExcepcionPilaVacia excepcionPilaVacia){
			System.err.println();
			excepcionPilaVacia.printStackTrace();
		} // fin de catch ExcepcionPilaVacia
	} // fin del método pruebaPopInteger
}



















