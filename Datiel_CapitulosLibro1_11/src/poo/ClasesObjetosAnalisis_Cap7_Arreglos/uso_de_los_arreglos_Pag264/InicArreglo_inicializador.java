package poo.ClasesObjetosAnalisis_Cap7_Arreglos.uso_de_los_arreglos_Pag264;


public class InicArreglo_inicializador {

	public static void main(String args[])

	{

		int arreglo[] = {
				0, 10, 20, 30, 40, 50, 60, 70, 80, 90, 100,
		};




		System.out.printf("Tamaño del arreglo[].length = %d", arreglo.length);// encabezado Informativo
		System.out.println();
		System.out.printf("%s %8s \n", "Indice", "Valor"); // encabezados de columnas


		// imprime el valor de cada elemento del arreglo
		for (int contador = 0; contador < arreglo.length; contador++){

			System.out.printf("%5d %8d \n", contador, arreglo[contador]);
		}

	} // fin de main

} // fin de la clase InicArreglo

