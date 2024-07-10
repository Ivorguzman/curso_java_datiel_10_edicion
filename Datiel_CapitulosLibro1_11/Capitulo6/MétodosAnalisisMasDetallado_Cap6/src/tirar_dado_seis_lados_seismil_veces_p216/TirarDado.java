package tirar_dado_seis_lados_seismil_veces_p216;

import java.util.Random;

public class TirarDado {

	@SuppressWarnings("unused")
	public static void main(String[] args) {

		// el objeto numerosAleatorios producirá números aleatorios seguros
		Random numerosAleatorios = new Random();

		int frecuenciaCara1 = 0; // cuenta las veces que se tiró 1
		int frecuenciaCara2 = 0; // cuenta las veces que se tiró 1
		int frecuenciaCara3 = 0; // cuenta las veces que se tiró 1
		int frecuenciaCara4 = 0; // cuenta las veces que se tiró 1
		int frecuenciaCara5 = 0; // cuenta las veces que se tiró 1
		int frecuenciaCara6 = 0; // cuenta las veces que se tiró 1


		for (int i = 0; i < 100; i++){

			
			/*
			 * int nextInt(int XXXXX)
			 * Devuelve un intvalor elegido pseudoaleatoriamente entre cero (inclusive) y el límite especificado (exclusivo).
			 * Requisitos de implementación:
			 * La implementación predeterminada comprueba que boundsea positivo int. Luego invoca nextInt(), limitando el resultado a ser mayor o igual a cero y menor que
			 * bound. Si bound es una potencia de dos, entonces limitar es una simple operación de enmascaramiento. De lo contrario, el resultado se vuelve a calcular
			 * invocando nextInt()hasta que el resultado sea mayor o igual a cero y menor que bound.
			 * Parámetros:
			 * bound- el límite superior (exclusivo) del valor devuelto. Debe ser positivo.
			 * Devoluciones:
			 * un intvalor elegido pseudoaleatoriamente entre cero (inclusive) y el límite (exclusivo)
			 * 
			 * int numero = valorDesplazamiento + numerosAleatorios.nextInt(factorEscala(x));
			 */
			int cara = 1 + numerosAleatorios.nextInt(6);


			switch (cara) {
				case 1:{
					++frecuenciaCara1;
					break;
				}
				case 2:{
					++frecuenciaCara2;
					break;

				}
				case 3:{

					++frecuenciaCara3;
					break;
				}
				case 4:{
					++frecuenciaCara4;
					break;

				}
				case 5:{
					++frecuenciaCara5;
					break;

				}
				case 6:{
					++frecuenciaCara6;
					break;

				}
				default:
					throw new IllegalArgumentException("Valor Iinespareado " + cara);
			}

		}
		System.out.println("Cara\tFrecuencia");
		System.out.printf("1\t%d%n2\t%d%n3\t%d%n4\t%d%n5\t%d%n6\t%d", frecuenciaCara1, frecuenciaCara2, frecuenciaCara3,
				frecuenciaCara4, frecuenciaCara4, frecuenciaCara6);


	}

}















