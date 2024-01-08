package poo.ClasesObjetosAnalisis_Cap7_Arreglos.uso_de_los_arreglos_Pag264;

public class InicArreglo {

	public static void main(String args[])

	{
	
		int arreglo[]; // declara un arreglo con el mismo nombre
	

		arreglo = new int[11]; // crea el espacio para el arreglo
		
		System.out.printf("Tamaño del arreglo[].length = %d", arreglo.length);// encabezado Informativo
		System.out.println();
		System.out.printf("%s %8s \n", "Indice", "Valor"); // encabezados de columnas

		// Ingreso no automatico de datos
		arreglo[0] = 10;
		arreglo[1] = 20;
		arreglo[2] = 30;
		arreglo[3] = 40;
		arreglo[4] = 50;
		arreglo[5] = 60;
		arreglo[6] = 70;
		arreglo[7] = 70;
		arreglo[8] = 80;
		arreglo[9] = 90;
		arreglo[10] = 100;


		// introduce imprime el valor de cada elemento del arreglo
		for (int contador = 0; contador < arreglo.length; contador++){

			// Ingreso automatico de datos
			// arreglo[contador] = contador * 10;

			System.out.printf("%5d %8d \n", contador, arreglo[contador]);
		}

	} // fin de main

} // fin de la clase InicArreglo
