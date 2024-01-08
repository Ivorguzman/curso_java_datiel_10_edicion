package suma_elementos_de_un_arreglo_p251;


// Cálculo de la suma de los elementos de un arreglo
public class SumaArreglo {

	public static void main(String [] args) {

		int [] array = {
				87,68,94,100,83,78,85,91,76,87
		};
		int total = 0;

		// suma el valor de cada elemento al total
		for (int contador = 0; contador < array.length; contador++){

			// No imprime la ultima sumatoria en total
			if (contador != array.length - 1){
				System.out.print(" ");
				System.out.println(total += array[contador]);
			}
		}
		// Imprime la ultima sumatoria a total
		total += array[array.length - 1];

		// System.out.printf("% d", total);
		System.out.printf("------> Sumatoria total de los elementos del arreglo = % d%n", total);
		System.out.println("                                                       -----");


	}

}
