package genericos.clasesGenericas_Pag771;

// Fig. 18.7: Pila.java

// La clase genérica Pila.


public class Pila<E> {

	private final int tamanio; // número de elementos en la pila

	private int superior; // ubicación del elemento superior

	private E[] elementos; // arreglo que almacena los elementos de la pila


	// el constructor sin argumentos crea una pila del tamaño predeterminado


	public Pila() {

		this(10); // tamaño predeterminado de la pila

	} // fin del constructor de Pila sin argumentos


	// constructor que crea una pila del número especificado de elementos

	public Pila(int s) {

		this.tamanio = s > 0 ? s : 10; // establece el tamaño de la Pila

		this.superior = -1; // al principio, la Pila está vacía


		this.elementos = (E[]) new Object[this.tamanio]; // crea el arreglo

	} // fin del constructor de Pila sin argumentos


	// mete un elemento a la pila; si tiene éxito, devuelve verdadero;

	// en caso contrario, lanza excepción ExcepcionPilaLlena



	public void push(E valorAMeter) {

		if (this.superior == this.tamanio - 1){ // si la pila está llena
			throw new ExcepcionPilaLlena(String.format("La Pila esta llena, no se puede meter %s", valorAMeter));
		}


		this.elementos[++this.superior] = valorAMeter; // coloca valorAMeter en la Pila

	} // fin del método push


	// devuelve el elemento superior si no está vacía; de lo contrario lanza

	public E pop() {

		if (this.superior == -1){ // si la pila está vacía
			throw new ExcepcionPilaVacia("La Pila esta vacia, no se puede sacar");
		}


		return this.elementos[this.superior--]; // elimina y devuelve el elemento superior de la Pila

	} // fin del método pop

} // fin de la clase Pila< E >







