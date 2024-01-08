package poo.ClasesObjetosAnalisis_Cap8_compisicion.pag332;

public class PruebaEmpleado {
	// Composición
	public static void main(String[] args) {
		
		Fecha nacimiento = new Fecha(04, 01, 1966);
		Fecha contratacion = new Fecha(04, 01, 2024);
		Empleado empleado = new Empleado("Guzmán", " Ivor", nacimiento, contratacion);

		System.out.println(empleado);
	}
	// fin de la clase PruebaEmpleado
		// TODO Auto-generated method stub

	}


