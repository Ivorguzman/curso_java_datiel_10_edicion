package genericos.metodoParametroTipo_Pag767;

// Fig. 18.5: MaximumTest.java
// Generic method maximum returns the largest of three objects.

public class MaximumTest
{
   // determines the largest of three Comparable objects

	/*
	 * La razón por la que hay dos T en la declaración <T extends Comparable<T>> es porque estás definiendo
	 * un tipo genérico T y también estás especificando una restricción para ese tipo. Aquí te explico cada T:
	 * 
	 * El primer T después de < es la declaración del tipo genérico. Estás diciendo que tu método
	 * va a trabajar con un tipo de dato que aún no se ha especificado, pero que se llamará T.
	 * El T después de extends Comparable< es parte de la restricción que estás imponiendo al tipo genérico T.
	 * Estás diciendo que cualquier tipo T que se use con este método
	 * debe ser una clase que implementa la interfaz Comparable<T>.
	 * En conjunto, <T extends Comparable<T>> significa que T es un tipo genérico
	 * que puede ser cualquier clase que implemente la interfaz Comparable y que puede compararse
	 * con otros objetos del mismo tipo T.
	 * 
	 * public static <E extends Comparable<T>> E maximum(E x, E y, E z) {
	 * // ... cuerpo del método
	 * }
	 * 
	 * 
	 * el código no se consideraría bien escrito debido al uso inconsistente de
	 * los identificadores de tipo genérico.(Comparable<T>)
	 * Debes usar el mismo identificador para que el código sea* correcto
	 */
   public static < T extends Comparable< T > > T maximum( T x, T y, T z )
   {
      T max = x; // assume x is initially the largest

      if ( y.compareTo( max ) > 0 )
	 {
		max = y; // y is the largest so far
	}

      if ( z.compareTo( max ) > 0 )
	 {
		max = z; // z is the largest
	}

      return max; // returns the largest object
   } // end method maximum

   public static void main( String args[] )
   {
      System.out.printf( "Maximum of %d, %d and %d is %d\n\n", 3, 4, 5,
         maximum( 3, 4, 5 ) );
      System.out.printf( "Maximum of %.1f, %.1f and %.1f is %.1f\n\n",
         6.6, 8.8, 7.7, maximum( 6.6, 8.8, 7.7 ) );
      System.out.printf( "Maximum of %s, %s and %s is %s\n", "pear",
         "apple", "orange", maximum( "pear", "apple", "orange" ) );
   } // end main
} // end class MaximumTest

