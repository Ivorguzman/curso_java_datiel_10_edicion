package genericos.TiposCrudos_Pag779;

import java.util.Arrays;

public class PruebaTipoCrudo {
	private Double[] elementosDouble = { 1.1, 2.2, 3.3, 4.4, 5.5, 6.6, 7.7 };
	private Integer[] elementosInteger = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11 };

	public void probarPilas() {
		//
		Pila pilaTipoCrudo1 = new Pila(2);// Pila de tipos crudos asignada a una variable Pila de tipos crudos
		Pila pilaTipoCrudo2 = new Pila<Double>(4);// Pila< Double > asignada a una variable Pila de tipos crudos
		Pila<Integer> pilaInteger = new Pila(10);// Pila de tipos crudos asignada a una variable Pila< Integer >

		
		
		  this.probarPush( "pilaTipoCrudo1", pilaTipoCrudo1, this.elementosDouble );
		  this.probarPop( "pilaTipoCrudo1", pilaTipoCrudo1 );

			this.probarPush("pilaTipoCrudo2", pilaTipoCrudo2, this.elementosDouble);
		  this.probarPop( "pilaTipoCrudo2", pilaTipoCrudo2 );

		  this.probarPush( "pilaInteger", pilaInteger, this.elementosInteger );
		  this.probarPop( "pilaInteger", pilaInteger );
		 


	}


	// método genérico que mete elementos a la pila
	// En el método probarPush, manejas tanto pilas de tipos crudos como pilas genéricas:
	// Pila se ha declarado sin un tipo genérico, por lo que es una pila de tipo crudo.
	public <T> void probarPush(String nombre, Pila<T> pila, T[] elementos) {
		// mete elementos a la pila
		try{
			System.out.printf("\nMetiendo elementos a %s\n", nombre);
			// mete elementos a la Pila
			for (T elemento : elementos){
				System.out.printf("\nValor  a introducir en la pilaInteger :  %s\n", elemento);
				pila.push(elemento); // mete elemento a la pila
				System.out.printf("\nValor introducido en la pilaInteger : -> %s\n", elemento);
			} // fin de for
		} // fin de try
		catch(ExcepcionPilaLlena excepcionPilaLlena){
			System.out.println();
			excepcionPilaLlena.printStackTrace();
		} // fin de catch ExcepcionPilaLlena
	} // fin del método probarPush




	// método genérico probarPop para sacar elementos de la pila
	public <T> void probarPop(String nombre, Pila<T> pila) {
		// saca elementos de la pila
		try{
			System.out.printf("\nSacando elementos de %s\n", nombre);
			T valorASacar; // almacena el elemento eliminado de la pila
			// elimina elementos de la Pila
			while (true){
				valorASacar = pila.pop(); // saca de la pila
				System.out.printf("Valor extraido  en la pila %s <-\n", valorASacar);
			} // fin de while
		} // fin de try
		catch(ExcepcionPilaVacia excepcionPilaVacia){
			System.out.println();
			excepcionPilaVacia.printStackTrace();
		} // fin de catch ExcepcionPilaVacia
	} // fin del método probarPop


	@Override
	public String toString() {
		return "PruebaTipoCrudo [elementosDouble=" + Arrays.toString(this.elementosDouble) + ", elementosInteger=" + Arrays.toString(this.elementosInteger) + "]";
	}


}
