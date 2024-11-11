package genericos.clasesGenericas_Pag771;

// Fig. 18.11: PruebaPila2.java
// Programa de prueba de la clase genérica Pila.


public class PruebaPila2 {

	// *** Creaciòn de las Propirdades (VAriables) **********


	// areglos tipo Clase Double
	// boxing de: double y Double
	private Double[] elementosDouble2 = { 1.1, 2.2, 3.3, 4.4, 5.5, 6.6 };



	// areglos tipo Clase Integer
	// boxing de: int a Integer
	private Integer[] elementosInteger2 = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11 };



	// Variable o propiedad de tipo Double
	private Pila<Double> pilaDouble2; // Variable pila que almacena objetos Double



	// Variable o propiedad de tipo Integer
	private Pila<Integer> pilaInteger2;// Variable pila que almacena objetos Integer



	// *************** Metodos para manipulacion de de la pila2 ************

	// Metodo probarPilas(), prueba los objetos Pila ;
	// creando una instancia normal de la clase Pila con el tipo genérico Double
	// y asignándola a la variable pilaDouble2
	public void probarPilas2() {

		// Creando y almaceando en las propiedades(variables) la creacion de los nuevos objetos pilaDouble2 y pilaInteger2
		this.pilaDouble2 = new Pila<Double>(5); // Pila de objetos Double
		this.pilaInteger2 = new Pila<Integer>(10); // Pila de objetos Integer



		this.probarPush2("pilaDouble :", this.pilaDouble2, this.elementosDouble2);
		this.probarPush2("pilaInteger", this.pilaInteger2, this.elementosInteger2);



		this.probarPop2("pilaDouble :", this.pilaDouble2);
		this.probarPop2("pilaInteger :", this.pilaInteger2);
	}


	// el método (genérico) probarPush --mete todo tipo de elementos en una Pila--
	public <T> void probarPush2(String nombre2, Pila<T> pila2, T[] elementos2) {
		try{
			System.out.println("********** Metiendo elementos Genericos en la pila **********");

			System.out.printf("\nMetiendo elementos a %s\n", nombre2);

			// metiendo elementos a ala pila
			for (T elemento : elementos2){
				System.out.printf("Valor  a introducir en la pila : %s\n", elemento);
				pila2.push(elemento);
			}
		} catch(Exception excepcionPilaLlena){
			System.out.println();
			excepcionPilaLlena.printStackTrace();
		}// fin de catch ExcepcionPilaLlena
	}; // fin del método probarPush



	// el método genérico probarPop saca elementos de una Pila
	public <T> void probarPop2(String nombre2, Pila<T> pila2) {
		try{
			System.out.printf("\nSacando elemento  a %s", nombre2);
			T valorASacar; // almacena el elemento eliminado de la pila
			while (true){
				valorASacar = pila2.pop();
				System.out.printf("Valor extraido  en la pila %s\n", valorASacar);
			}
		} catch(Exception ExcepcionPilaVacia){
			System.out.println();
			ExcepcionPilaVacia.printStackTrace();
		}// fin de catch ExcepcionPilaVacia
	}; // fin del metodoprobarPop









}
























