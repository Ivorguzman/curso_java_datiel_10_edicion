package herenciaClasicaVsGenerica.laHerenciaClasica.Ejemplo_B_Array;

import java.util.Arrays;

public class LetraVocal {
	
	private String[] vocales;
	
	public LetraVocal( ) {
		this(new String[] { "Estos son el conjunto de las vocales" });

	}


	public LetraVocal(String[] vocales) {

		this.vocales = vocales;

		for (int i = 0; i < vocales.length; i++){
			String laLetra = vocales[i];

		}

	}


	@Override
	public String toString() {
		return Arrays.toString(this.vocales);
	}

}











