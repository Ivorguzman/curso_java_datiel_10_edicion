package genericos.TiposCrudos_Pag779;


public class Pila<E> extends Object {

	private final int tamanio;
	private int superior = 0;
	private E[] elementos;
	
	
	
	public Pila( ) {
		this(10);
	}
	
	
	public Pila(int s) {
		this.superior = -1;
		this.tamanio = s > 0 ? s : 10;
		this.elementos = (E[]) new Object[this.tamanio];
	}

	
	


	public void push(E valorAMeter) throws ExcepcionPilaLlena {
		if (this.superior == this.tamanio - 1){
			throw new ExcepcionPilaLlena(String.format("Esta pila esta llena no se puede añadir el  elemento %s", valorAMeter));
		}
		this.elementos[++this.superior] = valorAMeter;
	}


	
	public E pop() throws ExcepcionPilaVacia {
		if (this.superior == -1){

			throw new ExcepcionPilaVacia("La pila esta vacia no hay nada que sacar");
		}
		System.out.printf("\nValor a extraer de la pila %s\n", this.elementos[this.superior]);


		return this.elementos[this.superior--];
	}// fin del método pop
}// fin de la clase Pila< E >

























