package genericos.clasesGenericas_Pag771;

//Fig. 18.7: Pila.java
// La clase genérica Pila.

// se especifica un límite superior, por lo que se utiliza el límite superior predeterminado, Object.
public class Pila<E> extends Object {
	private final int tamanio; // Esta variable almacenará el número máximo de elementos que la pila puede contener.

	private int PosicionSuperior; // La variable superior representa la ubicación del elemento superior en la pila.
	// En una pila, el elemento superior es el último elemento que se agregó.

	private E[] elementos; // arreglo que almacena los elementos de la pila
	// El tipo T[] indica que es un arreglo genérico que puede contener elementos de cualquier tipo.


	private int pilaVacia = -1;// Qualquier valor negativo indica que la pila esta vacia (LIFO-UEPS)


	// el constructor_1 Sin argumentos crea una pila del tamaño predeterminado

	public Pila( ) {

		this(10);

	}// fin del constructor de Pila sin argumentos


	// constructor_2 Crea una pila del número especificado de elementos
	public Pila(int s) {

		// Comprovación del argumento (int s)
		this.tamanio = s > 0 ? s : 10;// establece uno de los dos valore segun ausencia del parametro o no el tamaño de la Pila
		this.PosicionSuperior = this.pilaVacia;// Indica que la pila esta vacia
		this.elementos = (E[]) new Object[this.tamanio];// crea el arreglo de tipo Object[] casteado a tipo (E[])
	}



	// mete un elemento de tipo generico a la pila; si tiene éxito, devuelve verdadero;
	// en caso contrario, lanza excepción ExcepcionPilaLlena
	public void push(E valorAMeter) throws ExcepcionPilaLlena {
		
		// Indica que la pila esta llena
		if (this.PosicionSuperior == this.tamanio - 1){
			throw new ExcepcionPilaLlena(String.format("Esta pila esta llena no se puede añadir el  elemento %s", valorAMeter));
		}
		// Inserta el elemento al principio de la pila
		this.elementos[++this.PosicionSuperior] = valorAMeter;

	}



	// devuelve el elemento de tipo generico superior si no está vacía; de lo contrario lanza ExcepcionPilaVacia
	public E pop() throws ExcepcionPilaVacia {

		// Indica que la pila esta vacia
		if (this.PosicionSuperior <= this.pilaVacia){
			throw new ExcepcionPilaVacia("La pila esta vacia no hay nada que sacar");
		}
		return this.elementos[this.PosicionSuperior++];

	}

}

























