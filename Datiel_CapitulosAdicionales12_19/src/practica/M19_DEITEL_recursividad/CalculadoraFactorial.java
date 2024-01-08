package practica.M19_DEITEL_recursividad;

import java.util.Scanner;

// Fig. 18.3: FactorialCalculator.java
// Método factorial recursivo.

public class CalculadoraFactorial {
	// método factorial recursivo (asume que su parámetro es >= 0)

	public static long factorial(long numeroContador)
	{
		System.out.println("numeroContador = " + numeroContador);
		// System.out.println(numero);

		if (numeroContador <= 1)
		{// evalúa el caso base
			return 1; // casos base: 0! = 1 y 1! = 1
		}

		long Factorial_ACTUAL;
		long Factorial_ANTERIOR = factorial(numeroContador - 1);// paso recursivo
		Factorial_ACTUAL = numeroContador * Factorial_ANTERIOR;

		return Factorial_ACTUAL;

	}

	// imprime factoriales para los valores del 0 al 21
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		int valorTeclado;
		Scanner teclado = new Scanner(System.in);
		System.out.print("Ingrese el numero a calcular el factoria :");
		valorTeclado = teclado.nextInt();

		// calcula los factoriales del 0 al 21
		for (int contador = 0; contador <= valorTeclado; contador++)
		{
			System.out.printf("                 contador: %d! =  %d%n", contador, factorial(contador));

		}
	}
} // fin de la clase CalculadoraFactorial
