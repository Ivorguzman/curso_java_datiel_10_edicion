package poo.ClasesObjetosAnalisis_Cap7_Arreglos.uso_de_los_arreglos_Pag264;

public class SumaMultRestaDeArreglos

{

	public static void main(String args[])

	{

		int arreglo[] = {
				87, 68, 94, 100, 83, 78, 85, 91, 76, 89
		};

		int valorDelCalculo = 0;
		int total_1 = 0;
		int total_2 = 0;
		double total_3 = 0;

		System.out.print("Valores que se sumam : ");
		// suma el valor de cada elemento al total
		for (int contador = 0; contador < arreglo.length; contador++){
			valorDelCalculo = arreglo[contador];
			total_1 += valorDelCalculo;
			System.out.print(" + " + valorDelCalculo);
		}
		System.out.printf(" =  %d\n", total_1);
		System.out.println(" ");



		System.out.print("Valores que se multiplican : ");
		for (int contador = 0; contador < arreglo.length; contador++){
			valorDelCalculo = arreglo[contador];
			total_2 = valorDelCalculo + 1;
			total_2 *= valorDelCalculo;
			System.out.print(" * " + valorDelCalculo);
		}
		System.out.printf(" =  %d\n", total_2);
		System.out.println(" ");



		System.out.print("Valores que se dividen : ");
		for (int contador = 0; contador < arreglo.length; contador++){
			valorDelCalculo = arreglo[contador];
			total_3 = valorDelCalculo + 1;
			total_3 /= valorDelCalculo;
			System.out.print(" / " + valorDelCalculo);
		}
		System.out.printf(" =  %.5f\n", total_3);

	} // fin de main

} // fin de la clase SumaArreglo

