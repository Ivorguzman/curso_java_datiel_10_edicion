package genericos.clasesGenericas_Pag771;

//Fig. 18.7: Pila.java
// La clase genérica Pila.

// se especifica un "Límite Superior" , por lo que se utiliza el límite superior predeterminado,(extends Object).
// Aqui lo coloque pero por lo general no se coloca.
public class Pila<E> extends Object {

	private final int tamanio; // Esta variable almacenará el número máximo de elementos que la pila puede contener.

	private int superior = 0; // La variable superior representa la ubicación del elemento superior en la pila( último elemento que se agregó)

	private E[] elementos; // arreglo que almacena los elementos de la pila
	// El tipo E[] indica que es un arreglo genérico que puede contener elementos de cualquier tipo.


	// el constructor_1 Sin argumentos crea una pila del tamaño predeterminado
	public Pila( ) {
		this(10);
	}
	// fin del constructor_1 de Pila sin argumentos

	/*
	 * Eplicación: en Java, no se pueden crear directamente arreglos de un tipo genérico (E[])
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
	 * Esto significa que si E es Integer, solo se pueden almacenar números enteros en el arreglo.
	 * si E Double solo se pueden almacenar números enteros condecimales, si E de tipo String solo se pueden almacenar
	 * Caracteres si es de tipo Persona,Auto, etc, solo pueda guardar data del tipo al cual se acoto.
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
	// constructor_2 Crea una pila del número especificado de elementos e indicando que esta vacia y creando al array (contenedor de la pila)
	public Pila(int s) {
		// Esta variable (superior) representala posición del último elemento añadido a la pila
		this.superior = -1; // se utiliza para indicar que la pila está vacía al momento de su creación (el valor 1 negativo indica que la pila esta vacia )
		this.tamanio = s > 0 ? s : 10; // establece uno de los dos valore segun ausencia del parametro o no el tamaño de la Pila
		this.elementos = (E[]) new Object[this.tamanio]; // crea el arreglo de tipo Object[] casteado a tipo (E[])

	}
	// fin del constructor_2 de Pila con un argumentos



	// El metodo de instancia generico public void push(E valorAMeter) throws ExcepcionPilaLlena {...}
	// mete un elemento a la pila; si tiene éxito, devuelve verdadero;
	// en caso contrario, lanza excepción ExcepcionPilaLlena
	public void push(E valorAMeter) throws ExcepcionPilaLlena {
		// Indica que la pila esta llena por tener la cantidad de
		// elementos completos(en este caso) en la pila [(this.tamanio - 1) == 5-1 = 4]
		if (this.superior == this.tamanio - 1){
			throw new ExcepcionPilaLlena(String.format("Esta pila esta llena no se puede añadir el  elemento %s", valorAMeter));
		}
		// Inserta el elemento al principio de la pila (++this.superior -1+1= 0)
		this.elementos[++this.superior] = valorAMeter;
	}// fin del método push


	// El metodo de instancia generico public E pop() throws ExcepcionPilaVacia {...} devuelve el elemento de tipo generico superior si no está vacía; de lo contrario lanza
	// saca un elemento a la pila; si tiene éxito, devuelve verdadero;
	// ExcepcionPilaVacia
	public E pop() throws ExcepcionPilaVacia {
		// Indica que la pila esta vacia
		if (this.superior == -1){

			throw new ExcepcionPilaVacia("La pila esta vacia no hay nada que sacar");
		}
		System.out.printf("\nValor a extraer de la pila %s\n", this.elementos[this.superior]);


		return this.elementos[this.superior--];// elimina y devuelve el elemento superior de la Pila
	}// fin del método pop
}// fin de la clase Pila< E >

/*
 * Resumen Detallado del Flujo de Ejecución de la Clase Pila<E>
 * 
 * Declaración de la Clase y Variables:
 * 
 * La clase Pila<E> se declara como una clase genérica que puede almacenar elementos de cualquier tipo.
 * 
 * Se definen tres variables:
 * 
 * private final int tamanio: Almacena el número máximo de elementos que la pila puede contener.
 * 
 * private int superior = -1: Representa la ubicación del último elemento añadido a la pila. Inicialmente, se establece en -1 para indicar que la pila está vacía.
 * 
 * private E[] elementos: Un array genérico que almacena los elementos de la pila.
 * 
 * Constructor sin Argumentos:
 * 
 * Se define un constructor sin argumentos que crea una pila con un tamaño predeterminado de 10 elementos.
 * 
 * Este constructor llama internamente al constructor con un argumento, pasando el valor 10.
 * 
 * java
 * public Pila() {
 * this(10);
 * }
 * 
 * 
 * Constructor con Argumentos:
 * 
 * Se define un constructor que recibe un argumento s, el cual especifica el tamaño de la pila.
 * 
 * La variable superior se establece en -1 para indicar que la pila está vacía.
 * 
 * La variable tamanio se asigna con el valor de s si es mayor que 0; de lo contrario, se asigna el valor predeterminado de 10.
 * 
 * El array elementos se inicializa como un nuevo array de tipo Object y se castea a E[].
 * 
 * java
 * public Pila(int s) {
 * this.superior = -1;
 * this.tamanio = s > 0 ? s : 10;
 * this.elementos = (E[]) new Object[this.tamanio];
 * }
 * 
 * Método push(E valorAMeter):
 * 
 * Este método añade un elemento a la pila.
 * 
 * Primero, verifica si la pila está llena comparando superior con tamanio - 1. Si la pila está llena,
 * lanza una excepción ExcepcionPilaLlena.
 * 
 * Si hay espacio disponible, incrementa superior y añade el elemento al array elementos en la posición superior.
 * 
 * public void push(E valorAMeter) throws ExcepcionPilaLlena {
 * if (this.superior == this.tamanio - 1) {
 * throw new ExcepcionPilaLlena(String.format("Esta pila esta llena no se puede añadir el elemento %s", valorAMeter));
 * }
 * this.elementos[++this.superior] = valorAMeter;
 * }
 * 
 * 
 * 
 * 
 * Método pop():
 * 
 * Este método elimina y devuelve el elemento superior de la pila.
 * 
 * Primero, verifica si la pila está vacía comparando superior con -1. Si la pila está vacía, lanza una excepción ExcepcionPilaVacia.
 * 
 * Si la pila no está vacía, imprime el valor del elemento que se va a extraer.
 * 
 * Luego, devuelve el elemento en la posición superior y decrementa superior para actualizar la posición del último elemento.
 * 
 * 
 * 
 * public E pop() throws ExcepcionPilaVacia {
 * if (this.superior == -1) {
 * throw new ExcepcionPilaVacia("La pila esta vacia no hay nada que sacar");
 * }
 * System.out.printf("\nValor a extraer de la pila %s\n", this.elementos[this.superior]);
 * return this.elementos[this.superior--];
 * }
 * 
 * 
 * Detalles Adicionales:
 * 
 * Iniciación y Uso de la Pila:
 * 
 * Cuando se crea una instancia de Pila<E>, se puede usar el constructor sin argumentos para una pila de tamaño 10
 * o el constructor con un argumento para especificar el tamaño deseado.
 * 
 * El método push se utiliza para añadir elementos a la pila.
 * 
 * El método pop se utiliza para eliminar y devolver el elemento superior de la pila.
 * 
 * NOTA: (Recordartoria)
 * 
 * 
 * Métodos Estáticos:
 * No requieren una instancia de la clase.
 * No pueden acceder a miembros de instancia.
 * Útiles para operaciones independientes del estado de la instancia.
 * 
 * 
 * Métodos de Instancia:
 * Requieren una instancia de la clase.
 * Pueden acceder a todos los miembros de la clase (tanto estáticos como de instancia).
 * Útiles para operaciones que dependen del estado de la instancia.
 */

























