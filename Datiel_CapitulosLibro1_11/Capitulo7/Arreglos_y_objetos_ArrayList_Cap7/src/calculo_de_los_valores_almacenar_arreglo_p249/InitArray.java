package calculo_de_los_valores_almacenar_arreglo_p249;

// Cálculo de los valores a colocar en los elementos de un arreglo.
public class InitArray {

	public static void main(String [] args) {
		
		int incremento = 2; // Valor de incremento
		int impar = 1; // Listar numeros impares
		int par = 2; // Listar numeros pares
		final int LONGITUD_ARREGLO = 15; // declara la constante tamaño del arreglo



		int [] arreglo = new int [LONGITUD_ARREGLO]; // crea el arreglo

		// calcula el valor para cada elemento del arreglo
	      for (int contador = 0; contador < arreglo.length; contador++){
				arreglo[contador] = impar + incremento * contador;
		}


		// imprime encabezados de columnas
		System.out.printf("%s%8s%n", "Index", "Value");


		// imprime el valor de cada elemento del arreglo
	      for (int contador = 0; contador < arreglo.length; contador++){
				System.out.printf("%3d%7d%n", contador, arreglo[contador]);
		}
	   }

	}


