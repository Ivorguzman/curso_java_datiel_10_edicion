package herenciaClasicaVsGenerica.laHerenciaClasica.Ejemplo_B_Array;

public class MainVocales {

	public static void main(String[] args) {

		LetraVocal cartillaVocales = new LetraVocal();
		System.out.println(cartillaVocales);
		String[] letras = { "a", "e", "i", "o", "u" };
	
		LetraVocal cartillaVocales2 = new LetraVocal(letras);
		System.out.println(cartillaVocales2);


	}

}
