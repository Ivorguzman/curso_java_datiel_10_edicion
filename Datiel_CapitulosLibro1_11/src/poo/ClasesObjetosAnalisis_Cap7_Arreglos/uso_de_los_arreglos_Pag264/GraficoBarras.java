package poo.ClasesObjetosAnalisis_Cap7_Arreglos.uso_de_los_arreglos_Pag264;

/*A los profesores les gusta examinar a menudo la distribución de las califi caciones en un examen. Un profesor
podría graficar el número de calificaciones en cada una de varias categorías, para visualizar la distribución de
las califi caciones. Suponga que las calificaciones en un examen fueron 87, 68, 94, 100, 83, 78, 85, 91, 76 y 87.
Observe que hubo una calificación de 100, dos califcaciones en el rango de 90 a 99, cuatro calificaciones en el
rango de 80 a 89, dos en el rango de 70 a 79, una en el rango de 60 a 69 y ninguna por debajo de 60. Nuestra
siguiente aplicación (fi gura 7.6) almacena estos datos de distribución de las califi caciones en un arreglo de 11 ele-
mentos, cada uno de los cuales corresponde a una categoría de calificaciones. Por ejemplo, arreglo[ 0 ] indica
el número de califi caciones en el rango de 0 a 9, arreglo[ 7 ] indica el número de califi caciones en el rango de
70 a 79 y arreglo[ 10 ] indica el número de califi caciones de 100. Las dos versiones de la clase LibroCali-
ficaciones que veremos más adelante en este capítulo (fi guras 7.14 y 7.18) contienen código para calcular estas
frecuencias de califi caciones, con base en un conjunto de califi caciones. Por ahora crearemos el arreglo en forma
manual, mediante un análisis del conjunto de califi caciones.*/

//Programa para imprimir gráficos de barras.

public class GraficoBarras

{

	public static void main(String args[])

	{
		int alumnos[] = {
				1, 0, 0, 5, 7, 8, 1, 2, 4, 2, 1
		};



		System.out.println("Distribucion de calificaciones:");
		System.out.println();
		System.out.println("                    __________________________________________________________");
		System.out.println("                   |                                                          |");
		System.out.println("                   |   * ==> Cantidad de Alumnos en el rango de esas notas    |");
		System.out.println("                   |__________________________________________________________|");
		System.out.println();


		// imprime el total de alumnos
		int totalAlumnos = 0;
		int alumno = 0;
		int totalReprobados = 0;
		int totalAprobados = 0;
		int totalConlaude = 0;
		int totalSumaConLaude = 0;


		for (int contador = 0; contador < alumnos.length; contador++)
		{
			totalAlumnos += alumnos[contador];


			// para cada elemento del arreglo, imprime una barra del gráfico
			// imprime etiqueta de la barra ( "00-09: ", ..., "90-99: ", "100: " )
			if (contador != 10){

				System.out.printf(" %02d-%02d ", contador * 10, contador * 10 + 9);
			} else{
				System.out.printf("%5d  ", 100);

			}

			// imprime barra de asteriscos
			if (contador == 10){

				System.out.print("(ASC) ");

			} else if (contador == 0 || contador <= 4){

				System.out.print("(R) ");

			} else if (contador == 9){
				System.out.print("(ACL) ");

			} else{

				System.out.print("(A) ");
			}
			for (int estrellas = 0; estrellas < alumnos[contador]; estrellas++){

				if (contador <= 4){

					totalReprobados++;

				} else if (contador >= 5){

					totalAprobados++;

				} if (contador == 9){

					totalConlaude++;

				}
				if (contador == 10){

					totalSumaConLaude++;
				}
				System.out.print("* ");
			}

			System.out.println(); // inicia una nueva línea de salida

		} // fin de for externo


		int reprobados = totalReprobados * 100 / totalAlumnos;
		int aprobados = totalAprobados * 100 / totalAlumnos;
		System.out.println();
		System.out.println("Total de alumnos: " + totalAlumnos); // inicia una nueva línea de salida
		System.out.println("Total de alumnos Reprobados: " + totalReprobados + " ==> " + reprobados + " %"); // inicia una nueva línea de salida
		System.out.println("Total de alumnos Aprobados: " + totalAprobados + " ==> " + aprobados + " %"); // inicia una nueva línea de salida
		// System.out.printf(" Total de alumnos Reprobados: %.2f \n", totalReprobados);


		System.out.println("_______________________________________________________________________________________");
		System.out.println();
		System.out.println("*************       Total de alumnos Conlaude: " + totalConlaude + "        *************"); // inicia una nueva línea de salida
		System.out.println("*************       Total de alumnos Sumacomlaude: " + totalSumaConLaude
				+ "    *************"); // inicia una nueva línea de salida
		System.out.println("_______________________________________________________________________________________");
		System.out.println();







	} // fin de main

} // fin de la clase GraficoBarras












