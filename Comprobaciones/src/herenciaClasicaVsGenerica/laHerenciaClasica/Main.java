package herenciaClasicaVsGenerica.laHerenciaClasica;

public class Main {

	public static void main(String[] args) {

		// polimorfismo.
		Alfabeto x = new Letra("A");
		/*
		 * Asignación de Subclase a Superclase:
		 * Estás creando una instancia de Letra (subclase)
		 * y asignándola a una referencia de Alfabeto (superclase).
		 * 
		 * 
		 * Polimorfismo:
		 * En Java, esto se llama polimorfismo.
		 * Significa que un objeto de una subclase (Letra)
		 * puede ser tratado como un objeto de su superclase (Alfabeto).
		 * El objeto x puede usar métodos y atributos definidos en Alfabeto
		 * y los que Letra hereda o sobrescribe de Alfabeto.
		 */
		
		// Gracias al polimorfismo.
		Letra y = new Letra();

		System.out.println(y);
		System.out.printf("¡Soy la letra %s de tipo Alfabeto", x + "!");

		

		y.setLetra("B");
		System.out.println();
		System.out.printf("¡Soy la letra %s de tipo Letra ", y.getLetra() + "!");



		y.setLetra("C");
		System.out.println();
		System.out.printf("¡Soy la letra %s de tipo Letra ", y.getLetra() + "!");


	}

}
