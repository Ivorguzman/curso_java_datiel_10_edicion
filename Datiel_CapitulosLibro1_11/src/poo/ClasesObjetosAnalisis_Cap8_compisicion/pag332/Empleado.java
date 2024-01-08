package poo.ClasesObjetosAnalisis_Cap8_compisicion.pag332;

//Composición
public class Empleado {
	// Clase Empleado con referencias a otros objetos.
	private String nombre;// Objeto de tipo String
	private String apellido;// Objeto de tipo String
	private Fecha fechaNacimiento; // Objeto de tipo Fecha
	private Fecha fechaContratacion; // Objeto de tipo Fecha


	// constructor para inicializar nombre, fecha de nacimiento y fecha de contratación
	public Empleado(String nombre, String apellido, Fecha fechaNacimiento, Fecha fechaContratacion) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.fechaNacimiento = fechaNacimiento;
		this.fechaContratacion = fechaContratacion;
	}

	// convierte Empleado a formato String
	@Override public String toString() {
		return String.format("Nombre: %s%nApellido: %s%nContratado: %s%nCumpleañios: %s", this.apellido, this.nombre,
				this.fechaContratacion, this.fechaNacimiento);
	}

}// fin de la clase Empleado
