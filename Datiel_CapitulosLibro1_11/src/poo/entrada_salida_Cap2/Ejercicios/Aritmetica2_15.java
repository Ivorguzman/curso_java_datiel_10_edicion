package poo.entrada_salida_Cap2.Ejercicios;

import java.util.Scanner;

public class Aritmetica2_15 {

	/*
	 * Escriba una aplicación que pida al usuario que escriba dos números, que obtenga los números
	 * del usuario e imprima la suma, producto, diferencia y cociente (división) de los números.
	 */

	@SuppressWarnings("resource")
	public static void main(String[] args) {

		Scanner teclado = new Scanner(System.in);

		System.out.print("Ingrese  Primer Numero :");
		int num1 = teclado.nextInt();
		System.out.print("Ingrese  Segundo Numero :");
		int num2 = teclado.nextInt();
		System.out.println();
		
		System.out.printf("La suma es: %d%n", num1 + num2);
		System.out.printf("El producto es: %d%n", num1 * num2);
		System.out.printf("La diferencia es: %d%n", num1 - num2);
		System.out.printf("La division es: %d%n", num1 / num2);
		System.out.printf("el resto de la division es: %d", num1 % num2);








	}

}
