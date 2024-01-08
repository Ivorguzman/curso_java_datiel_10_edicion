package colecciones.claseArrays_Pag795;

public class MainUsoArrays {

	public static void main(String[] args) {

		UsoArrays usoArreglos = new UsoArrays();


		usoArreglos.imprimirArreglos();

		usoArreglos.imprimirIgualdad();


		int ubicacion = usoArreglos.buscarUnInt(5);

		if (ubicacion >= 0){
			System.out.printf(

					"Se encontro el 5 en el elemento %d de arregloInt\n", ubicacion);
		} else{
			System.out.println("No se encontro el 5 en arregloInt");
		}


		ubicacion = usoArreglos.buscarUnInt(8763);

		if (ubicacion >= 0){
			System.out.printf(

					"Se encontro el 8763 en el elemento %d en arregloInt\n", ubicacion);
		} else{
			System.out.println("No se encontro el 8763 en arregloInt");
		}

		// fin de main
	}

}

