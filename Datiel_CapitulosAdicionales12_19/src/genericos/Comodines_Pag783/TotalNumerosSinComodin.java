package genericos.Comodines_Pag783; // Declaración del paquete donde se encuentra la clase

import java.util.ArrayList; // Importa la clase ArrayList de la biblioteca de colecciones de Java

// Fig. 18.14: TotalNumeros.java
// Suma de los elementos de un objeto ArrayList.
public class TotalNumerosSinComodin { // Declaración de la clase pública TotalNumerosSinComodin
	public static void main(String[] args) { // Método principal, punto de entrada de la aplicación

		// Inicializa un array de objetos Number que contiene valores Integer y Double
		Number[] numeros = { 1, 2.4, 3, 4.1, 3.6 };

		// Crea una nueva instancia de ArrayList que almacenará objetos Number
		ArrayList<Number> listaNumeros = new ArrayList<>();

		// Recorre cada elemento en el array numeros
		for (Number elemento : numeros){
			// Añade cada elemento del array numeros a la lista listaNumeros
			listaNumeros.add(elemento);

			// Imprime el contenido actual de listaNumeros
			System.out.printf("listaNumeros contiene %s\n", listaNumeros);

			// Calcula y muestra el total de los elementos en listaNumeros
			System.out.printf("Total de los elementos en la listaNumeros: %.1f\n", sumar(listaNumeros));
		}

	}

	// Método privado que suma los elementos de una lista de Number y devuelve el total como double
	private static double sumar(ArrayList<Number> lista) {

		double total = 0; // Inicializa la variable total a 0

		// Recorre cada elemento en la lista
		for (Number elemento : lista){
			/*
			 * doubleValue(). Es un método que se encuentra en las clases envolventes
			 * de los tipos numéricos (Integer, Double, Float, etc.).
			 * Este método devuelve el valor del objeto como un double.
			 * Por ejemplo, si elemento es un objeto Integer, elemento.doubleValue()
			 * convertirá el valor entero en un valor de punto flotante (double).
			 */
			total += elemento.doubleValue(); // Convierte el elemento a double y lo suma al total
		}
		return total; // Devuelve el total de la suma
	}

	/*
	 * Resumen y Flujo de Ejecución
	 * 
	 * Inicialización:
	 * 
	 * Se declara un array de Number que contiene tanto Integer como Double.
	 * 
	 * Se crea un ArrayList<Number> llamado listaNumeros.
	 * 
	 * Población del ArrayList:
	 * 
	 * Se recorre el array numeros usando un bucle for-each.
	 * 
	 * Cada elemento del array se añade a listaNumeros.
	 * 
	 * 
	 * 
	 * Impresión del Contenido y Suma:
	 * 
	 * Después de añadir cada elemento, se imprime el contenido actual de listaNumeros.
	 * 
	 * Se llama al método sumar para calcular la suma de los elementos en listaNumeros y se imprime el total.
	 * 
	 * 
	 * 
	 * Método sumar:
	 * 
	 * Este método toma una ArrayList<Number> como parámetro.
	 * 
	 * Inicializa una variable total a 0.
	 * 
	 * Recorre cada elemento de la lista, convierte cada uno a double usando el método doubleValue(), y los suma al total.
	 * 
	 * Devuelve el valor acumulado de total como double.
	 * 
	 * 
	 * 
	 * Flujo de Ejecución Detallado
	 * 
	 * Inicio del Programa:
	 * 
	 * public static void main(String[] args) es el punto de entrada.
	 * 
	 * Declaración e Inicialización de Variables:
	 * 
	 * Number[] numeros = { 1, 2.4, 3, 4.1, 3.6 }; inicializa un array de Number con valores Integer y Double.
	 * 
	 * ArrayList<Number> listaNumeros = new ArrayList<>(); crea una lista para almacenar estos números.
	 * 
	 * 
	 * 
	 * Iteración y Adición a la Lista:
	 * 
	 * El bucle for (Number elemento : numeros) itera sobre cada número en el array numeros.
	 * 
	 * listaNumeros.add(elemento); añade cada número a la lista.
	 * 
	 * 
	 * 
	 * Impresión del Estado Actual y Suma:
	 * 
	 * System.out.printf("listaNumeros contiene %s\n", listaNumeros); imprime la lista actual.
	 * 
	 * System.out.printf("Total de los elementos en la listaNumeros: %.1f\n", sumar(listaNumeros)); calcula y muestra la suma.
	 * 
	 * 
	 * 
	 * Método sumar:
	 * 
	 * private static double sumar(ArrayList<Number> lista) es llamado.
	 * 
	 * Inicializa double total = 0;.
	 * 
	 * El bucle for (Number elemento : lista) recorre cada número en la lista, convirtiéndolo a double y sumándolo al total.
	 * 
	 * Devuelve el total.
	 * 
	 */



}
