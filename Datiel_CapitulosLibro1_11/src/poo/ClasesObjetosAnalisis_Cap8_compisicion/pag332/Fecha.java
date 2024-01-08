package poo.ClasesObjetosAnalisis_Cap8_compisicion.pag332;


// Composición
public class Fecha
{
	private int mes; // 1-12
	private int dia; // 1-31 con base en el mes
	private int anio; // cualquier año


	private static final int[] diasPorMes =
			{
					0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31
			};

	// constructor: confirma el valor apropiado para el mes y el día, dado el año;
	public Fecha(int mes, int dia, int anio) {

		// revisa si el mes está en el rango
		if (mes <= 0 || mes > 12){
			throw new IllegalArgumentException("mes (" + mes + ") debe ser 1-12");
		}

		// revisa si el dia está en el rango
		if (dia <= 0 || dia > Fecha.diasPorMes[mes] && !(mes == 2 && dia == 29)){
			throw new IllegalArgumentException("dia (" + dia + ") debe ser 1-31");
		}

		// revisa si es año bisiesto cuando mes es 2 y dia es 29
		if (mes == 2 && dia == 29 && !(anio % 400 == 0 || anio % 4 == 0 && anio % 100 != 0)){
			throw new IllegalArgumentException("dia (" + dia + ") fuera de rango para el mes y anio especificados");
		}

		this.mes = mes;
		this.dia = dia;
		this.anio = anio;

		System.out.println("This ==> " + this);
		System.out.printf("Constructor de objeto Fecha para la fecha %s%s%n", this, " <== This");
		System.out.println();

		// devuelve un objeto String de la forma mes/dia/anio


	}

	// devuelve un objeto String de la forma mes/dia/anio
	@Override public String toString() {
		// String.format Returns a formatted string using the specified format string andarguments.
		return String.format("%d/%d/%d", this.mes, this.dia, this.anio);
	}

}// fin de la clase Fecha
