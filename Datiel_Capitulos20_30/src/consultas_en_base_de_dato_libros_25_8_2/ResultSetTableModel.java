package consultas_en_base_de_dato_libros_25_8_2;

// Fig. 24.25: ResultSetTableModel.java
// A TableModel that supplies ResultSet data to a JTable.
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.table.AbstractTableModel;

// ResultSet rows and columns are counted from 1 and JTable
// rows and columns are counted from 0. When processing
// ResultSet rows or columns for use in a JTable, it is
// necessary to add 1 to the row or column number to manipulate
// the appropriate ResultSet column (i.e., JTable column 0 is
// ResultSet column 1 and JTable row 0 is ResultSet row 1).
public class ResultSetTableModel extends AbstractTableModel
{
	private final Connection connection;
	private final Statement statement;
	private ResultSet resultSet;
	private ResultSetMetaData metaData;
	private int numberOfRows;

	// keep track of database connection status
	private boolean connectedToDatabase = false;

	// CONSTRUCTOR: initializes resultSet and obtains its meta data object;
	// determines number of rows
	public ResultSetTableModel(String url, String username, String password, String query) throws SQLException
	{
		// connect to database
		this.connection = DriverManager.getConnection(url, username, password);

		// create Statement to query database
		this.statement = this.connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

		// update database connection status
		this.connectedToDatabase = true;

		// set query and execute it
		this.setQuery(query);
	}

	// get class that represents column type
	@Override public Class getColumnClass(int column) throws IllegalStateException
	{
		// ensure database connection is available
		if (!this.connectedToDatabase)
	{
		throw new IllegalStateException("Not Connected to Database");
	}

	// determine Java class of column
	try
	{
		String className = this.metaData.getColumnClassName(column + 1);

		// return Class object that represents className
		return Class.forName(className);
	} catch(Exception exception)
	{
		exception.printStackTrace();
	}

	return Object.class; // if problems occur above, assume type Object
}

// get number of columns in ResultSet
@Override public int getColumnCount() throws IllegalStateException
{
	// ensure database connection is available
	if (!this.connectedToDatabase)
	{
		throw new IllegalStateException("Not Connected to Database");
	}

	// determine number of columns
	try
	{
		return this.metaData.getColumnCount();
	} catch(SQLException sqlException)
	{
		sqlException.printStackTrace();
	}

	return 0; // if problems occur above, return 0 for number of columns
}

// get name of a particular column in ResultSet
@Override public String getColumnName(int column) throws IllegalStateException
{
	// ensure database connection is available
	if (!this.connectedToDatabase)
	{
		throw new IllegalStateException("Not Connected to Database");
	}

	// determine column name
	try
	{
		return this.metaData.getColumnName(column + 1);
	} catch(SQLException sqlException)
	{
		sqlException.printStackTrace();
	}

	return ""; // if problems, return empty string for column name
}

// return number of rows in ResultSet
@Override public int getRowCount() throws IllegalStateException
{
	// ensure database connection is available
	if (!this.connectedToDatabase)
	{
		throw new IllegalStateException("Not Connected to Database");
	}

	return this.numberOfRows;
}

// obtain value in particular row and column
@Override public Object getValueAt(int row, int column) throws IllegalStateException
{
	// ensure database connection is available
	if (!this.connectedToDatabase)
	{
		throw new IllegalStateException("Not Connected to Database");
	}

	// obtain a value at specified ResultSet row and column
	try
	{
		this.resultSet.absolute(row + 1);
		return this.resultSet.getObject(column + 1);
	} catch(SQLException sqlException)
	{
		sqlException.printStackTrace();
	}

	return ""; // if problems, return empty string object
}

// set new database query string
public void setQuery(String query) throws SQLException, IllegalStateException
{
	// ensure database connection is available
	if (!this.connectedToDatabase)
	{
		throw new IllegalStateException("Not Connected to Database");
	}

	// specify query and execute it
	this.resultSet = this.statement.executeQuery(query);

	// obtain meta data for ResultSet
	this.metaData = this.resultSet.getMetaData();

	// determine number of rows in ResultSet
	this.resultSet.last(); // move to last row
	this.numberOfRows = this.resultSet.getRow(); // get row number

	// notify JTable that model has changed
	this.fireTableStructureChanged();
}

// close Statement and Connection
public void disconnectFromDatabase()
{
	if (this.connectedToDatabase)
	{
		// close Statement and Connection
		try
		{
			this.resultSet.close();
			this.statement.close();
			this.connection.close();
		} catch(SQLException sqlException)
		{
			sqlException.printStackTrace();
		} finally // update database connection status
		{
			this.connectedToDatabase = false;
		}
	}
}
} // end class ResultSetTableModel




/*
 * //Muestra el contenido de la tabla Autores en la base de datos libros.
 * import java.awt.BorderLayout;
 * import java.awt.event.ActionListener;
 * import java.awt.event.ActionEvent;
 * import java.awt.event.WindowAdapter;
 * import java.awt.event.WindowEvent;
 * import java.sql.SQLException;
 * import java.util.regex.PatternSyntaxException;
 * import javax.swing.JFrame;
 * import javax.swing.JTextArea;
 * import javax.swing.JScrollPane;
 * import javax.swing.ScrollPaneConstants;
 * import javax.swing.JTable;
 * import javax.swing.JOptionPane;
 * import javax.swing.JButton;
 * import javax.swing.Box;
 * import javax.swing.JLabel;
 * import javax.swing.JTextField;
 * import javax.swing.RowFilter;
 * import javax.swing.table.TableRowSorter;
 * import javax.swing.table.TableModel;
 * public class MostrarResultadosConsulta extends JFrame
 * {
 * // URL de la base de datos, nombre de usuario y contraseña para JDBC
 * static String CONTROLADOR = "com.mysql.cj.jdbc.ConnectionImpl";
 * static String URL_BASEDATOS = "jdbc:mysql://localhost:3306/libros";
 * static String NOMBREUSUARIO = "root";
 * static String CONTRASENIA = "";
 * // la consulta predeterminada obtiene todos los datos de la tabla autores
 * static final String CONSULTA_PREDETERMINADA = "SELECT * FROM autores";
 * private ResultSetTableModel modeloTabla;
 * private JTextArea areaConsulta;
 * // CONTRUCTOR : crea objeto ResultSetTableModel y GUI
 * public MostrarResultadosConsulta()
 * {
 * super("Visualizacion de los resultados de la consulta");
 * // crea objeto ResultSetTableModel y muestra la tabla de la base de datos
 * try
 * {
 * // crea objeto TableModel para los resultados de la consulta SELECT * FROM autores
 * this.modeloTabla = new ResultSetTableModel(URL_BASEDATOS, NOMBREUSUARIO, CONTRASENIA,
 * ,CONSULTA_PREDETERMINADA);
 * // establece objeto JTextArea en el que el usuario escribe las consultas
 * this.areaConsulta = new JTextArea(CONSULTA_PREDETERMINADA, 3, 100);
 * this.areaConsulta.setWrapStyleWord(true);
 * this.areaConsulta.setLineWrap(true);
 * JScrollPane scrollPane = new JScrollPane(this.areaConsulta,
 * ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
 * // establece objeto JButton para enviar las consultas
 * JButton botonEnviar = new JButton("Enviar consulta");
 * // crea objeto Box para manejar la colocación de areaConsulta y
 * // botonEnviar en la GUI
 * Box boxNorte = Box.createHorizontalBox();
 * boxNorte.add(scrollPane);
 * boxNorte.add(botonEnviar);
 * // crea delegado de JTable para modeloTabla
 * JTable tablaResultados = new JTable();
 * JLabel etiquetaFiltro = new JLabel("Filtro:");
 * final JTextField textoFiltro = new JTextField();
 * JButton botonFiltro = new JButton("Aplicar filtro");
 * Box boxSur = Box.createHorizontalBox();
 * boxSur.add(etiquetaFiltro);
 * boxSur.add(textoFiltro);
 * boxSur.add(botonFiltro);
 * // coloca los componentes de la GUI en el panel de contenido
 * this.add(boxNorte, BorderLayout.NORTH);
 * this.add(new JScrollPane(tablaResultados), BorderLayout.CENTER);
 * this.add(boxSur, BorderLayout.SOUTH);
 * // crea componente de escucha de eventos para botonEnviar
 * botonEnviar.addActionListener(new ActionListener()
 * {
 * // pasa la consulta al modelo de la tabla
 * @Override
 * public void actionPerformed(ActionEvent evento)
 * {
 * // realiza una nueva consulta
 * try
 * {
 * MostrarResultadosConsulta.this.modeloTabla.establecerConsulta(
 * MostrarResultadosConsulta.this.areaConsulta.getText());
 * } // fin de try
 * catch(SQLException excepcionSql)
 * {
 * JOptionPane.showMessageDialog(null, excepcionSql.getMessage(), "Error en base de datos",
 * JOptionPane.ERROR_MESSAGE);
 * // trata de recuperarse de una consulta inválida del usuari
 * // ejecutando la consulta predeterminada
 * try
 * {
 * MostrarResultadosConsulta.this.modeloTabla.establecerConsulta(CONSULTA_PREDETERMINADA);
 * MostrarResultadosConsulta.this.areaConsulta.setText(CONSULTA_PREDETERMINADA);
 * } // fin de try
 * catch(SQLException excepcionSql2)
 * {
 * JOptionPane.showMessageDialog(null, excepcionSql2.getMessage(), "Error en base de datos",
 * JOptionPane.ERROR_MESSAGE);
 * // verifica que esté cerrada la conexión a la base de datos
 * MostrarResultadosConsulta.this.modeloTabla.desconectarDeBaseDatos();
 * System.exit(1); // termina la aplicación
 * } // fin de catch interior
 * } // fin de catch exterior
 * }// fin de actionPerformed
 * }// fin de la clase interna ActionListener
 * );// fin de la llamada a addActionListener
 * final TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(this.modeloTabla);
 * tablaResultados.setRowSorter(sorter);
 * this.setSize(500, 250); // establece el tamaño de la ventana
 * this.setVisible(true); // muestra la ventana
 * botonFiltro.addActionListener(new ActionListener()
 * {
 * // pasa el texto del filtro al componente de escucha
 * @Override public void actionPerformed(ActionEvent e)
 * {
 * String texto = textoFiltro.getText();
 * if (texto.length() == 0)
 * {
 * sorter.setRowFilter(null);
 * } else
 * {
 * try
 * {
 * sorter.setRowFilter(RowFilter.regexFilter(texto));
 * } // fin de try
 * catch(PatternSyntaxException pse)
 * {
 * JOptionPane.showMessageDialog(null, "Patron de exp reg incorrecto",
 * "Patron de exp reg incorrecto", JOptionPane.ERROR_MESSAGE);
 * } // fin de catch
 * } // fin de else
 * }// fin del método actionPerfomed
 * }// fin de la clase interna anónima
 * );// fin de la llamada a addActionLister
 * } // fin de try
 * catch(ClassNotFoundException noEncontroClase)
 * {
 * JOptionPane.showMessageDialog(null, "No se encontro controlador de base de datos",
 * "No se encontro elcontrolador", JOptionPane.ERROR_MESSAGE);
 * System.exit(1); // termina la aplicación
 * } // fin de catch
 * catch(SQLException excepcionSql)
 * {
 * JOptionPane.showMessageDialog(null, excepcionSql.getMessage(), "Error en base de datos",
 * JOptionPane.ERROR_MESSAGE);
 * // verifica que esté cerrada la conexión a la base de datos
 * this.modeloTabla.desconectarDeBaseDatos();
 * System.exit(1); // termina la aplicación
 * } // fin de catch
 * // cierra la ventana cuando el usuario sale de la aplicación (se sobrescribe
 * // el valor predeterminado de HIDE_ON_CLOSE)
 * this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
 * // verifica que esté cerrada la conexión a la base de datos cuando el usuario sale de la aplicación
 * this.addWindowListener(new WindowAdapter()
 * {
 * // se desconecta de la base de datos y sale cuando se ha cerrado la ventana
 * @Override public void windowClosed(WindowEvent evento)
 * {
 * MostrarResultadosConsulta.this.modeloTabla.desconectarDeBaseDatos();
 * System.exit(0);
 * } // fin del método windowClosed
 * } // fin de la clase interna WindowAdapter
 * ); // fin de la llamada a addWindowListener
 * }// fin del constructor de MostrarResultadosConsulta
 * // ejecuta la aplicación
 * public static void main(String args[])
 * {
 * new MostrarResultadosConsulta();
 * }// fin de main
 * }// fin de la clase MostrarResultadosConsulta
 */















