package poo.herencias_Cap9_RelacionSuperclasesSubclases.pag366;

// La clase EmpleadoPorComision representa a un empleado que recibe como sueldo un porcentaje de las ventas brutas
public class EmpleadoPorComision extends Object
{
	private final String primerNombre;
	private final String apellidoPaterno;
	private final String numeroSeguroSocial;
	private double ventasBrutas;
	private double tarifaComision;


	// constructor con cinco argumentos
	public EmpleadoPorComision(String primerNombre, String apellidoPaterno, String numeroSeguroSocial,
			double ventasBrutas,
			double tarifaComision)
	
	{
		// si ventasBrutas no es válida, lanza excepción
		if (ventasBrutas <= 0.0)
		{
			throw new IllegalArgumentException("Las ventas brutas deben ser >= 0.0");

		}
		
		// si tarifaComision no es válida, lanza excepción
		if (tarifaComision <= 0.0)
		{
			throw new IllegalArgumentException("La tarifa de comisión debe ser > 0.0 y < 1.0");

		}
				
		this.primerNombre = primerNombre;
		this.apellidoPaterno = apellidoPaterno;
		this.numeroSeguroSocial = numeroSeguroSocial;
		this.ventasBrutas = ventasBrutas;
		this.tarifaComision = tarifaComision;
	}
	// fin del constructo


	public String obtenerPrimerNombre()
	{
		return this.primerNombre;
	}


	public String obtenerApellidoPaterno()
	{
		return this.apellidoPaterno;
	}

	// devuelve el número de seguro social
	public String obtenernumeroSeguroSocial()
	{
		return this.numeroSeguroSocial;
	}


	// establece el monto de ventas brutas
	public void establecerVentasBrutas(double ventasBrutas)
	{
		if (ventasBrutas <= 0.0)
		{
			throw new IllegalArgumentException("Las ventas brutas deben ser >= 0.0");

		}

		this.ventasBrutas = ventasBrutas;
	}


	// devuelve el monto de ventas brutas
	public double obtenerVentasBrutas()
	{
		return this.ventasBrutas;
	}


	// establece la tarifa de comisión
	public void establecertarifaComision(double tarifaComision)
	{
		// si tarifaComision no es válida, lanza excepción
		if (tarifaComision <= 0.0)
		{
			throw new IllegalArgumentException("La tarifa de comisión debe ser > 0.0 y < 1.0");

		}

		this.tarifaComision = tarifaComision;
	}


	// devuelve la tarifa de comisión
	public double obtenertarifaComision()
	{
		return this.tarifaComision;
	}

	// calcula los ingresos
	public double ingresos()
	{
		return this.tarifaComision * this.ventasBrutas;

	}


	@Override public String toString()
	{
		/*
		 * return "EmpleadoPorComision [primerNombre=" + this.primerNombre + ", apellidoPaterno=" + this.apellidoPaterno
		 * + ", numeroSeguroSocial=" + this.numeroSeguroSocial + ", ventasBrutas=" + this.ventasBrutas
		 * + ", tarifaComision="
		 * + this.tarifaComision + "]";
		 */
		
		return String.format("%s: %s %s%n%s: %s%n%s: %.2f%n%s: %.2f", "empleado por comision", this.primerNombre,
				this.apellidoPaterno, "numero de seguro social", this.numeroSeguroSocial, "ventas brutas",
				this.ventasBrutas, "tarifa de comision", this.tarifaComision);
				
	}



}// fin de la clase EmpleadoPorComision
