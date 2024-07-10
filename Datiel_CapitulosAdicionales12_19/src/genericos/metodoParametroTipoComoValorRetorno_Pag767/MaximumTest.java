package genericos.metodoParametroTipoComoValorRetorno_Pag767;

// Fig. 18.5: MaximumTest.java
// Generic method maximum returns the largest of three objects.

public class MaximumTest
{
   // determines the largest of three Comparable objects

	/*
	 * La razón por la que hay dos T en la declaración <T extends Comparable<T>> es porque estás definiendo
	 * un tipo genérico T y también estás especificando una restricción para ese tipo. Aquí te explico cada T:
	 * 
	 * El primer T después de < y antes de maximum es la declaración del tipo genérico.
	 * Estás diciendo que tu métodova a trabajar con un tipo de dato que aún no se ha especificado,
	 * pero que se llamará T. El T después de extends Comparable <T> es parte de la restricción
	 * que estás imponiendo al tipo genérico T<maximum>. Estás diciendo que cualquier tipo T
	 * que se use con este método debe ser una clase que implementa la interfaz Comparable<T>.
	 * En conjunto, <T extends Comparable<T>> significa que T es un tipo genérico
	 * que puede ser cualquier clase que implemente la interfaz Comparable y que puede compararse
	 * con otros objetos del mismo tipo T.
	 * 
	 * 
	 * +++ Codigo mal escrito +++++
	 * public static <E extends Comparable<T>> E maximum(E x, E y, E z) {
	 * 
	 * // ... cuerpo del método
	 * 
	 * }
	 * * el código AENTERIOS no se consideraría bien escrito debido al uso inconsistente de
	 * los identificadores de tipo genérico (<E extends>).(Comparable<T>)
	 * Debes usar el mismo identificador <T> para que el código sea* correcto
	 * ++++++++++++++++++++++++
	 * 
	 * 
	 *
	 * La ---sección de parámetros de ++tipo++ --- es donde declaras los parámetros de tipo genérico
	 * que se usarán en el método. Esta sección está entre corchetes angulares (< >) y se
	 * coloca justo antes del tipo de retorno del método.
	 * 
	 * La ---sección de parámetros de ++método++ --- es donde declaras los parámetros que el método
	 * aceptará cuando sea llamado. Estos parámetros están dentro de los paréntesis (( )) y
	 * siguen al nombre del método.
	 * 
	 * 
	 */
	public static <T extends Comparable<T>> T maximum(T x, T y, T z) {
		T max = x; // Comenzamos asumiendo que x es el mayor

		if (y.compareTo(max) > 0){
			max = y; // Si y es mayor que max, ahora y es el mayor
		}

		if (z.compareTo(max) > 0){
			max = z; // Si z es mayor que max, ahora z es el mayor
		}

		return max; // Devuelve el objeto más grande
	}

	/*
	 * El código es un método genérico en Java que encuentra el máximo
	 * de tres objetos que pueden ser comparados entre sí.
	 * 
	 * Ahora, ¿qué significa ___ <T extends Comparable<T>>_____ Esto es una restricción que le pones al tipo T.
	 * Estás diciendo que T no puede ser cualquier clase; tiene que ser una clase que implemente la interfaz
	 * Comparable. Esto es necesario porque el método compareTo que usas para comparar los objetos
	 * solo existe en clases que implementan Comparable.
	 * 
	 * Cuando el compilador de Java trabaja con este código, usa algo llamado ----“borrado de tipos”------
	 * convertir los tipos --genéricos-- a tipos --concretos--. En muchos casos, como
	 * no se especifica un límite superior, se usa la clase --Object-- porque en Java,
	 * Object es la clase de la que todas las demás clases heredan. Pero en mi método, el límite superior
	 * es --Comparable--, lo que significa que el compilador reemplazará (T con Comparable )cuando traduzca
	 * mi código a bytecode, que es el código que la máquina virtual de Java puede entender y ejecutar.
	 * 
	 * En resumen, este método maximum te permite comparar tres objetos
	 * que son comparables (como números o cadenas) y encontrar el mayor de los tres. Es una forma de
	 * asegurarte de que los objetos que pasas al método pueden ser comparados entre sí,
	 * evitando errores en tiempo de ejecución
	 * 
	 * 
	 * En el contexto de la programación, especialmente en Java, cuando ves <T extends Comparable<T>>,
	 * esto se refiere a una --restricción de tipo--. No es una “restricción” en el sentido de limitar
	 * la funcionalidad, sino más bien una forma de especificar
	 * qué tipos de objetos puede aceptar un método o una clase genérica.
	 * La palabra clave extends en este caso se usa para definir un --límite superior-- del tipo genérico T.
	 * Esto significa que T puede ser --cualquier-- clase
	 * que implemente la interfaz Comparable<T>--.
	 * La interfaz Comparable<T> es un tipo especial en Java que permite comparar objetos
	 * de la misma clase para ver cuál es mayor o menor.
	 * Entonces, <T extends Comparable<T>> asegura que los objetos que pasas
	 * al método maximum puedan ser comparados entre sí, porque todos deben implementar el método
	 * compareTo que se define en la interfaz Comparable.
	 * 
	 * En resumen, no es tanto una restricción es mejor decir que es una especificación que
	 * los objetos deben tener ciertas capacidades (en este caso, ser comparables) para ser utilizados
	 * con ese método. Es una forma de decirle al compilador y a otros programadores
	 * qué tipo de objetos se espera que sean pasados a ese método.
	 * 
	 * !Ahora!. En Java, el término límite superior se refiere a la CLASE más ALTA en la jerarquía
	 * que un tipo genérico puede aceptar. Es como poner un techo o un límite a lo que puede ser.
	 * 
	 * Imagina que tienes una caja y solo quieres que se llenen con cierto tipo de pelotas,
	 * por ejemplo, pelotas de tenis. El límite superior sería como decir: “Esta caja solo
	 * puede contener pelotas de tenis o cualquier pelota que sea una versión especial de
	 * una pelota de tenis, pero no cualquier otro tipo de pelota”.
	 * 
	 * En términos de programación, si tienes un método genérico que trabaja
	 * con objetos de tipo T, y dices --que T extends ClaseX--, estás diciendo que T puede ser ClaseX o
	 * cualquier subclase de ClaseX, pero no una clase completamente diferente.
	 * 
	 * Es una forma de asegurarte de que los tipos de datos que uses sean
	 * compatibles con las operaciones que vas a realizar en tu código.
	 * Así evitas errores y haces que tu código sea más seguro y predecible.
	 * 
	 * 
	 * Sección de Parámetros de Tipo: <T extends Comparable<T>>
	 * 
	 * Tipo de Retorno: T
	 * 
	 * Nombre del Método: maximum
	 * 
	 * Sección de Parámetros del Método: (T x, T y, T z)
	 * 
	 * Cuerpo del Método: Todo lo que está dentro de las llaves { ... }
	 * 
	 */





   public static void main( String args[] )
   {
      System.out.printf( "Maximum of %d, %d and %d is %d\n\n", 3, 4, 5,
				maximum(3, 4, 5)); // --.... ,(Integer) maximum(3, 4, 5)-- esto lo hace tras banbalinas el complilador

      System.out.printf( "Maximum of %.1f, %.1f and %.1f is %.1f\n\n",
         6.6, 8.8, 7.7, maximum( 6.6, 8.8, 7.7 ) );

      System.out.printf( "Maximum of %s, %s and %s is %s\n", "pear",
         "apple", "orange", maximum( "pear", "apple", "orange" ) );

		/*
		 * Basado en la comparación lexicográfica, que es similar a cómo se ordenan
		 * las palabras en un diccionario, “pear” sería considerado el mayor entre
		 * “pear”, “apple” y “orange”.
		 * Esto se debe a que “pear” viene después de “apple” y “orange” en orden alfabético
		 */
	} // FIN main


} // FIN class MaximumTest

