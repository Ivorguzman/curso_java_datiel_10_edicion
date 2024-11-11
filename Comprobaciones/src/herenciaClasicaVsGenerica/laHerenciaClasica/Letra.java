package herenciaClasicaVsGenerica.laHerenciaClasica;

public class Letra extends Alfabeto {

	String letra;

	// Contructores
	public Letra( ) {
		this("¿ Que letra eres ?");
	}

	/**
	 * @param letra
	 */
	public Letra(String letra) {
		super(); // public class Alfabeto{..}
		this.letra = letra;
	}






	// getters Y setters
	public String getLetra() {
		return this.letra;
	}

	public void setLetra(String letra) {
		this.letra = letra;
	}

	@Override
	public String toString() {
		return this.letra;
	}


}
