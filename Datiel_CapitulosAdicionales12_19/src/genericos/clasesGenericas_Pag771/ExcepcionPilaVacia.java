package genericos.clasesGenericas_Pag771;


// Fig. 18.9: ExcepcionPilaVacia.java
// Indica que una pila está vacia.
/*
 * Cuando se crea una instancia de ExcepcionPilaVacia sin argumentos,
 * se utilizará el constructor sin argumentos, que a su vez llama al constructor con un
 * argumento, pasando el mensaje predeterminado “La pila esta vacia”. Este mensaje se pasa
 * luego al constructor de la clase base RuntimeException a través de super(exepcion)
 * 
 * En resumen, this se utiliza aquí para reutilizar el constructor con un argumento
 * desde el constructor sin argumentos, asegurando que ambos constructores inicialicen la
 * excepción con un mensaje adecuado.
 * 
 * 
 * 
 * La necesidad de estructurar los constructores de esta manera
 * en la clase ExcepcionPilaVacia tiene varias ventajas:
 * 
 * Reutilización de Código: Al llamar al constructor con un argumento
 * desde el constructor sin argumentos, se evita duplicar el código.
 * Esto hace que el mantenimiento sea más fácil y reduce la posibilidad de errores.
 * 
 * Consistencia: Garantiza que todas las instancias de ExcepcionPilaVacia
 * se inicialicen de manera consistente con un mensaje adecuado,
 * ya sea que se utilice el constructor con o sin argumentos.
 * 
 * Flexibilidad: Permite ofrecer una opción predeterminada (sin argumentos)
 * y una opción personalizada (con un argumento). Esto es útil cuando se quiere proporcionar un
 * mensaje de error específico en algunos casos, pero también tener un mensaje predeterminado para otros
 */

public class ExcepcionPilaVacia extends RuntimeException {
	/*
	 * El this("La pila esta vacia") llama al otro constructor de la misma clase
	 * que acepta un argumento String. En este caso, está pasando el mensaje predeterminado
	 * “La pila esta vacia” al constructor con un argumento:
	 */
	// constructor sin argumentos
	public ExcepcionPilaVacia( ) {
		this("La pila esta vacia");  // Llama al constructor con argumento (String exepcion) de esta clase pasando el mensaje ("La pila esta vacia")
	} // fin del constructor de ExcepcionPilaVacia sin argumentos


	// constructor con un argumento
	public ExcepcionPilaVacia(String exepcion) {
		super(exepcion); // Llama al constructor de la clase base (Exception) con el mensaje predeterminado
	} // fin del constructor de ExcepcionPilaVacia sin argumentos
}// fin de la clase ExcepcionPilaVacia








