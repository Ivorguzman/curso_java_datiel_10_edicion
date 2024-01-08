package practica.M19_DEITEL_recursividad;

import java.util.Scanner;

public class RecursividadEGG {

	// public int factorial(int n) {
	public static int factorial(int n) {
		System.out.println(n);
		int factorial_actual;
		int factorial_anterior;
		if (n == 0 || n == 1){
			factorial_actual = 1;
		}else{
			// Invocacion recursiva
			// factorial_anterior = this.factorial(n - 1);
			factorial_anterior = factorial(n - 1);
			// Valor actual de [n]por el factorial de valor anterior[Factorial_ANTERIOR(factorial(n-1))]
			factorial_actual = n * factorial_anterior;
			System.out.println(factorial_actual);
		}
		return factorial_actual;
	}



	@SuppressWarnings("resource") public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		int n;
		int res;
		System.out.print("Ingrese el numero a calcular el factoria :");
		n = teclado.nextInt();

		/* RecursividadEGG factorial = new RecursividadEGG();
		 * factorial.factorial(5); */

		res = factorial(n);

		System.out.println("El factorial de "+n+" es "+res);
	}

}


