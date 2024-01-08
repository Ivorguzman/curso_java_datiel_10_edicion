package genericos.clasesGenericas_Pag771;

public class ExcepcionPilaVacia extends RuntimeException {

	// constructor sin argumentos

	public ExcepcionPilaVacia() {

		this("La Pila esta vacia");

	} // fin del constructor de ExcepcionPilaVacia sin argumentos


	// constructor con un argumento

	public ExcepcionPilaVacia(String excepcion) {

		super(excepcion);

	} // fin del constructor de ExcepcionPilaVacia con un argumento

} // fin de la clase ExcepcionPilaVacia
