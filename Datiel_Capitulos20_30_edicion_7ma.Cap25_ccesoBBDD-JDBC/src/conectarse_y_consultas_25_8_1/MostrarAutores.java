package conectarse_y_consultas_25_8_1;


import java.sql.Statement;
import java.util.Iterator;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

@SuppressWarnings("unused")
public class MostrarAutores {

	// nombre del controlador de JDBC y URL de la base de datos
	static final String CONTROLADOR = "com.mysql.cj.jdbc.ConnectionImpl";
	static final String URL_BASEDATOS = "jdbc:mysql://localhost:3306/libros";
	static String usuario = "root";
	static String clave = "";

	public static void main(String[] args) {
		Connection conexion = null; // maneja la conexión a bbdd (permiten crear las instrucciones SQL)
		Statement instruccion = null;// instrucción de consulta sql
		ResultSet conjuntoResultados = null;// maneja los resultados de la consulta sql

		// se conecta a la base de datos libros y realiza una consulta
		try{

			// carga la clase controlador
			Class.forName(CONTROLADOR);// CODIGO ANTIGUO NO SE UTILIZA


			// establece la conexión a la base de datos
			conexion = DriverManager.getConnection(URL_BASEDATOS, usuario, clave);
			System.out.println("CONECCION ESTABLECIDA");

			// crea objeto Statement para consultar la base de datos
			instruccion = conexion.createStatement(); // SIN ARGUMENTOS

			// creando la consulta SqL

			String conslutaSqL = "SELECT IDAutor, nombrePila, apellidoPaterno FROM autores";

			// consulta la base de datos
			conjuntoResultados = instruccion.executeQuery(conslutaSqL);


			// procesando los resultados de la consulta
			ResultSetMetaData metaDatos = conjuntoResultados.getMetaData();
			int numeroDeColumnas = metaDatos.getColumnCount();
			System.out.println("Tablas de autores  de la base de datos Libros: \n");
			for (int i = 1; i <= numeroDeColumnas; i++){
				System.out.printf("%-3s%-5s", " ", metaDatos.getColumnName(i));
			} // fin de for
			System.out.printf("%n%-3s%s", "", "______________________________________ ");
			System.out.println();
			while (conjuntoResultados.next()){

				for (int i = 1; i <= numeroDeColumnas; i++){
					System.out.printf("%-3s%-10s", " ", conjuntoResultados.getObject(i));
					// System.out.printf("\t%-5s\t", conjuntoResultados.getObject(i));
				}// fin de for
				System.out.println();
			}// fin de while
		} // fin del try
		catch(SQLException excepcionSql){
			excepcionSql.printStackTrace();
			System.out.println("PROBLEMAS CON LA CONECCION");
		}// fin de catch
		catch(ClassNotFoundException noEncontroClase){
			noEncontroClase.printStackTrace();
		} // fin de catch
		finally{ // asegura que conjuntoResultados, instruccion y conexion estén cerrados
			try{
				conjuntoResultados.close();
				instruccion.close();
				conexion.close();
			} // fin del try
			catch(Exception excepcion){
				excepcion.printStackTrace();
			} // fin de catch
		} // fin de finally
	}// fin del main
}// fin de la clase MostrarAutores















