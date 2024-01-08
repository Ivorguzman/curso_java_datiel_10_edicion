package graficar_datos_en_un_arreglo_p251;

public class GraficoBarras {


	public static void main(String[] args) {

		int[] arreglo = { 0,0,0,0,0,0,1,2,4,2,1 };

		System.out.println(" Distribucion de calificaciones:");
		System.out.println("");


		
		for (int i = 0; i < arreglo.length; i++){

			// imprime etiqueta de la barra (“00-09: ”, ..., “90-99: ”, “100: ”)
			if (i != 10){

				System.out.printf(" %02d-%02d :", i * 10, i * 10 + 9);


			}else{
				System.out.printf(" %5d : ", 100);


			}
			// para cada elemento del arreglo, imprime una barra del gráfico
			for (int j = 0; j < arreglo[i]; j++){


				System.out.printf("%s", "°");

			}
			System.out.println();

		}

	}

}
