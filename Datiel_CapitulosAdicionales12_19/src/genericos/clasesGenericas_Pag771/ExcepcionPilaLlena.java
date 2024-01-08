package genericos.clasesGenericas_Pag771;

public class ExcepcionPilaLlena extends RuntimeException {

	// constructor sin argumentos

	public ExcepcionPilaLlena() {

		this("La Pila esta llena");

	} // fin del constructor de ExcepcionPilaLlena sin argumentos


	// constructor con un argumento

	public ExcepcionPilaLlena(String excepcion) {

		super(excepcion);

	} // fin del constructor de ExcepcionPilaLlena sin argumentos

} // fin de la clase ExcepcionPilaLlena
