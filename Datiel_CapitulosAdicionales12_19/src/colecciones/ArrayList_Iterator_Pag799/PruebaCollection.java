package colecciones.ArrayList_Iterator_Pag799;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

// Fig. 19.3: PruebaCollection.java

// Uso de la interfaz Collection.

import java.util.List;


public class PruebaCollection {


	private static final String[] coloresIniciales = { "MAGENTA", "ROJO", "BLANCO", "AZUL", "CYAN" };

	private static final String[] eliminarColores = { "ROJO", "BLANCO", "AZUL" };


	// crea objeto ArrayList, le agrega los colores y lo manipula
	public PruebaCollection() {

		List<String> listaInicial = new ArrayList<String>();
		List<String> listaFinal = new ArrayList<String>();

		/*
		 * ArrayList<String> lista = new ArrayList<String>();
		 * ArrayList<String> eliminarLista = new ArrayList<String>();
		 */
		// agrega los elementos en el arreglo colores a la lista
		for (String color : coloresIniciales){
			listaInicial.add(color);
		}



		System.out.print("ArrayList Ante de elininar elementos de la lista : ");
		// System.out.println();


		// imprime en pantalla el contenido de la lista


		for (int cuenta = 0; cuenta < listaInicial.size(); cuenta++){
			System.out.printf("%s ", listaInicial.get(cuenta));
		}





		// agrega los elementos en eliminarColores a eliminarLista
		System.out.println();
		System.out.println();
		int contador = 0;
		for (String color : eliminarColores){
			listaFinal.add(color);
			System.out.println(" Color liminado  de la lista: " + listaFinal.get(contador));
			contador++;
			System.out.println();

		}




		// elimina los colores contenidos en eliminarLista
		this.eliminarColores(listaInicial, listaFinal);


		System.out.println("\n\nArrayList despues de llamar a eliminarColores: ");


		// imprime en pantalla el contenido de la lista

		for (String color : listaInicial){
			System.out.printf("%s ", color);
		}

	} // fin del constructor de PruebaCollection


	// elimina de coleccion1 los colores especificados en coleccion2

	@Override public String toString() {
		return "PruebaCollection [toString()=" + super.toString() + "]";
	}


	private void eliminarColores(Collection<String> coleccion1, Collection<String> coleccion2) {

		// obtiene el iterador

		Iterator<String> iterador = coleccion1.iterator();


		// itera mientras la colección tenga elementos

		while (iterador.hasNext()){
			if (coleccion2.contains(iterador.next())){
				iterador.remove();
			}
		} // elimina el color actual

	} // fin del método eliminarColores



} // fin de la clase PruebaCollection


