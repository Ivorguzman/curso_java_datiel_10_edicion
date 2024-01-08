package colecciones.claseArrays_Pag795;

import java.util.Arrays;

/*
 * Arrays: clase pública extienden el objeto.
 * Esta clase contiene varios métodos para manipular matrices (como ordenar y buscar).
 * Esta clase también contiene una fábrica estática que permite ver las matrices como listas.
 */

public class UsoArrays {

	// Propiedades de la clase
	private int arregloInt[] = { 1, 2, 3, 4, 5, 6 };

	private double arregloDouble[] = { 8.4, 9.3, 0.2, 7.9, 3.4 };

	private int arregloIntLleno[];
	private int copiaArregloInt[];



	// el constructor inicializa los arreglos
	public UsoArrays() {

		// inicializa arreglo int con 10 elementos
		this.arregloIntLleno = new int[10];

		// inicializa arreglo int con longitud de copiaArregloInt
		this.copiaArregloInt = new int[this.arregloInt.length];

		/*
		 * Asigna el valor int especificado a cada elemento de la matriz de ints especificada.
		 * public static void fill(int[] a, int val)
		 * Parámetros:
		 * a- la matriz a llenar
		 * val- el valor que se almacenará en todos los elementos de la
		 */
		Arrays.fill(this.arregloIntLleno, 7);// llena con int 7

		/*
		 * Ordena la matriz especificada en orden numérico ascendente.
		 * public static void sort(double[] a)
		 * Parámetros:
		 * a- la matriz a ordenar
		 */
		Arrays.sort(this.arregloDouble);
		System.out.println(Arrays.hashCode(this.arregloInt));

		/*
		 * Copia una matriz de la matriz de origen,
		 * comenzando en la posición especificada,
		 * a la posición especificada de la matriz de destino
		 * 
		 * public static void arraycopy(Object src, int srcPos, Object dest, int destPos, int length);
		 * 
		 * Parámetros:
		 * src- la matriz de origen.
		 * srcPos- posición inicial en la matriz de origen.
		 * dest- la matriz de destino.
		 * destPos- posición inicial en los datos de destino.
		 * length- el número de elementos de la matriz que se copiarán.
		 */

		// copia el arreglo arregloInt en el arreglo copiaArregloInt
		System.arraycopy(this.arregloInt, 0, this.copiaArregloInt, 0, this.arregloInt.length);
	}
	// fin del constructor de UsoArrays





	// imprime los valores en cada arreglo
	public void imprimirArreglos() {

		System.out.print("arregloDouble: ");
		for (double valorDouble : this.arregloDouble){
			System.out.printf("%.1f ", valorDouble);
		}


		System.out.print("\n arregloInt: ");
		for (int valorInt : this.arregloInt){
			System.out.printf("%.1f ", valorInt);
		}


		System.out.print("\n arregloIntLleno: ");
		for (int valorIntLleno : this.arregloIntLleno){
			System.out.printf("%.1f ", valorIntLleno);
		}


		System.out.print("\n copiaArregloInt: ");
		for (int valorCopiaIntLleno : this.copiaArregloInt){
			System.out.printf("%.1f ", valorCopiaIntLleno);
			System.out.println("\n");
		} // fin del método imprimirArreglos


	}





	// busca un valor en el arreglo arregloInt
	public int buscarUnInt(int valor) {
		/*
		 * Busca en la matriz de enteros especificada el valor especificado
		 * utilizando el algoritmo de búsqueda binaria.
		 * La matriz debe ordenarse (según el sort(int[])método) antes de realizar esta llamada. Si no está ordenado, los resultados no están definidos. Si la matriz contiene
		 * varios elementos con el valor especificado, no hay garantía de cuál se encontrará
		 *
		 * Parámetros:
		 * a- la matriz a buscar
		 * key- el valor a buscar
		 */
		return Arrays.binarySearch(this.arregloInt, valor);

	} // fin del método buscarUnInt





	// compara el contenido del arreglo
	public void imprimirIgualdad() {


		/*
		 * public static boolean equals(int[] a, int[] a2);
		 * Devuelve truesi las dos matrices de enteros especificadas son iguales entre sí.
		 * Dos matrices se consideran iguales si ambas contienen la misma cantidad de elementos
		 * y todos los pares de elementos correspondientes en las dos matrices son iguales.
		 * En otras palabras, dos matrices son iguales si contienen los mismos elementos en el mismo orden.
		 * Además, dos referencias de matriz se consideran iguales si ambas son null.
		 * Parámetros:
		 * a- una matriz para ser probada para determinar la igualdad
		 * a2- la otra matriz cuya igualdad se probará
		 * 
		 * 
		 * 
		 */
		boolean valorB = Arrays.equals(this.arregloInt, this.copiaArregloInt);

		System.out.printf("arregloInt %s copiaArregloInt\n",

				valorB ? "==" : "!=");


		valorB = Arrays.equals(this.arregloInt, this.arregloIntLleno);

		System.out.printf("arregloInt %s arregloIntLleno\n",

				valorB ? "==" : "!=");

	} // fin del método imprimirIgualdad




}
















