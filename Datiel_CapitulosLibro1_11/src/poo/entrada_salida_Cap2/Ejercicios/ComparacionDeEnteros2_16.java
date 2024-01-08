package poo.entrada_salida_Cap2.Ejercicios;

import java.util.Scanner;

public class ComparacionDeEnteros2_16 {

	@SuppressWarnings("resource")
	public static void main(String[] args) {

		/*
		 * Escriba una aplicación que pida al usuario que escriba dos enteros, que obtenga
		 * los números del usuario y muestre el número más grande, seguido de las palabras “es más grande”. Si los números son
		 * iguales, imprima el mensaje “Estos números son iguales”.
		 */


		int num1;
		int num2;

		Scanner teclado = new Scanner(System.in);

		System.out.print("Introdusca numero 1: ");
		num1 = teclado.nextInt();

		System.out.println();

		System.out.print("Introdusca numero 2: ");
		num2 = teclado.nextInt();
		
		System.out.println();
		
		if (num1 > num2){
			System.out.printf("%d es mayor  a %d%n", num1, num2);
		}

		if (num1 < num2){
			System.out.printf("%d es menor  a %d%n", num1, num2);
		}
		if (num1 == num2){
			System.out.printf("%d es igual  a %d%n", num1, num2);
		}

		if (num1 != num2){
			System.out.printf("%d es diferente a %d%n", num1, num2);
		}


		
		
		




	}

}
