package genericos.clasesGenericas_Pag771;

//Fig. 18.7: Pila.java
// La clase genérica Pila.

// se especifica un "Límite Superior" , por lo que se utiliza el límite superior predeterminado,(extends Object).
// Aqui lo coloque pero por lo general no se coloca.
public class Pila<E> extends Object {

	private final int tamanio; // Esta variable almacenará el número máximo de elementos que la pila puede contener.

	private int PosicionSuperior; // La variable superior representa la ubicación del elemento superior en la pila.
	// En una pila, el elemento superior es el último elemento que se agregó.

	private E[] elementos; // arreglo que almacena los elementos de la pila
	// El tipo E[] indica que es un arreglo genérico que puede contener elementos de cualquier tipo.




	// el constructor_1 Sin argumentos crea una pila del tamaño predeterminado
	public Pila( ) {
		this(10);
	}
	// fin del constructor_1 de Pila sin argumentos


	// constructor_2 Crea una pila del número especificado de elementos e indicando que esta vacia y creando al array (contenedor de la pila)
	public Pila(int s) { // Comprovación del argumento (int s)
		this.tamanio = s > 0 ? s : 10; // establece uno de los dos valore segun ausencia del parametro o no el tamaño de la Pila


		// Esta variable (PosicionSuperior) representala posición del último elemento añadido a la pila
		this.PosicionSuperior = -1; // se utiliza para indicar que la pila está vacía al momento de su creación (el valor 1 negativo indica que la pila esta vacia )



		/*
		 * En Java, no se pueden crear directamente arreglos de un tipo genérico (E[])
		 * porque el tipo E no está disponible cuando el programa se está ejecutando.
		 * Esto se debe a que los genéricos en Java son solo una característica
		 * del compilador y no existen en tiempo de ejecución.
		 * 
		 * Solución con Arreglos de Object:
		 * Para solucionar esto, se crea un arreglo de tipo Object y luego
		 * se convierte (o “castea”) a un arreglo del tipo E[].
		 * Esto se hace en el constructor de la clase Pila en la línea : this.elementos = (E[]) new Object[this.tamanio];
		 * 
		 * Comprobación de Tipos:
		 * Aunque el arreglo es técnicamente de tipo Object, el compilador de Java se
		 * asegura de que solo se puedan almacenar elementos del tipo E en este arreglo.
		 * Esto significa que si E es Integer, solo se pueden almacenar números enteros en el arregloo del.
		 * 
		 * Cuando se define el tipo genérico E en la clase, el arreglo "elementos" solo
		 * podrá almacenar elementos del tipo que especifiques para E.
		 * 
		 * Aquí algunos ejemplos:
		 * 
		 * Si E es Integer, el arreglo solo podrá contener números enteros.
		 * Si E es Double, el arreglo solo podrá contener números decimales.
		 * Si E es String, el arreglo solo podrá contener cadenas de texto.
		 * Esto es gracias a la comprobación de tipos que realiza el compilador de Java,
		 * asegurando que solo se puedan almacenar elementos del tipo declarado en el arreglo.
		 * 
		 * Resumen:
		 * Creación del Arreglo: Se crea un arreglo de Object y se convierte a E[].
		 * Comprobación de Tipos: El compilador intenta asegurar que solo se almacenen elementos del tipo E.
		 * Advertencia: El compilador emite una advertencia cuando ejecutas esta linea <javac -Xlint:unchecked Pila.java>
		 * porque no puede garantizar al 100% la seguridad de tipos en tiempo de ejecución.
		 */
		this.elementos = (E[]) new Object[this.tamanio]; // crea el arreglo de tipo Object[] casteado a tipo (E[])
	}
	// fin del constructor_2 de Pila con un argumentos


	// mete un elemento de tipo generico a la pila; si tiene éxito, devuelve verdadero en caso contrario, lanza excepción ExcepcionPilaLlena;
	public void push(E valorAMeter) throws ExcepcionPilaLlena {
		

		/*
		 * explicación de la Línea de Código : if (this.PosicionSuperior == this.tamanio - 1)
		 * 
		 * Explicación Paso a Paso
		 * 1. this.PosicionSuperior:
		 * Qué es: Es una variable que indica la posición actual en la pila donde se encuentra el último elemento.
		 * Por qué es importante: Nos ayuda a saber cuántos elementos hay en la pila en cualquier momento.
		 * 
		 * 2. this.tamanio:
		 * Qué es: Es una variable que representa el tamaño máximo de la pila, es decir,
		 * cuántos elementos puede contener en total.
		 * Por qué es importante: Nos dice cuántos elementos podemos añadir a la pila antes de que se llene.
		 * 
		 * 3. this.tamanio - 1:
		 * Qué es: Es el índice de la última posición disponible en la pila.
		 * Por qué es importante: En programación, los índices suelen empezar en 0,
		 * así que si una pila puede contener 10 elementos, el índice de la última posición será 9 (10 - 1).
		 * 
		 * 
		 * 4. ==:
		 * Qué es: Es un operador de comparación.
		 * Por qué es importante: Se usa para verificar si dos valores son iguales.
		 * 
		 * ¿Qué hace esta línea?
		 * La línea de código:
		 * if (this.PosicionSuperior == this.tamanio - 1)
		 * verifica si la posición actual (this.PosicionSuperior) es igual al índice de la última
		 * posición disponible en la pila (this.tamanio - 1).
		 * 
		 * 
		 * ¿Por qué es importante?
		 * Propósito: Esta verificación se hace para saber si la pila está llena.
		 * Resultado: Si this.PosicionSuperior es igual a this.tamanio - 1,
		 * significa que la pila está llena y no se pueden añadir más elementos.
		 * En ese caso, se lanza una excepción (ExcepcionPilaLlena).
		 * 
		 * Ejemplo
		 * Imagina que tienes una pila que puede contener hasta 5 elementos (tamanio = 5).
		 * Los índices van de 0 a 4 (tamanio - 1 = 4).
		 * Si PosicionSuperior es 4, significa que ya hay 5 elementos en la pila y no puedes añadir más.
		 * 
		 */
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
		if (this.PosicionSuperior == -1){
			throw new ExcepcionPilaVacia("La pila esta vacia no hay nada que sacar");
		}
		return this.elementos[this.PosicionSuperior - 1];

	}

}

























