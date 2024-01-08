package uso_de_un_inicializador_de_arreglos_p249;

// Inicialización de los elementos de un arreglo con un inicializador de arreglo

public class InicArreglo {

	public static void main(String[] args) {

		int[] arreglo = {
				32, 27, 64, 18, 95, 14, 90, 70, 60, 37
		};

		System.out.printf("%s%8s%n", "Indice", "Valor"); // encabezados de columna

		// imprime el valor de cada elemento del arreglo		14
		for (int contador = 0; contador < arreglo.length; contador++){
			System.out.printf("%3d%9d%n", contador, arreglo[contador]);
		}

	}

}
