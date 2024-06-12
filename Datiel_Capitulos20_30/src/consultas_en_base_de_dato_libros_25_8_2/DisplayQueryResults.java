package consultas_en_base_de_dato_libros_25_8_2;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import java.util.regex.PatternSyntaxException;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

//Fig. 24.28: DisplayQueryResults.java
//Display the results of various queries.

public class DisplayQueryResults extends JFrame
{
	// URL de la base de datos, nombre de usuario y contraseña para JDBC
	private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/libros";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "";


	// la consulta predeterminada obtiene todos los datos de la tabla autores
	private static final String DEFAULT_QUERY = "SELECT * FROM autores";


	// CONTRUCTOR : crea objeto ResultSetTableModel y GUI
	private static ResultSetTableModel tableModel;

	public static void main(String args[])
	{
		// crea objeto ResultSetTableModel y muestra la tabla de la base de datos
		try
		{
			// crea objeto TableModel para los resultados de la consulta SELECT * FROM autores
			tableModel = new ResultSetTableModel(DATABASE_URL, USERNAME, PASSWORD, DEFAULT_QUERY);

			// establece objeto JTextArea en el que el usuario escribe las consultas
			final JTextArea queryArea = new JTextArea(DEFAULT_QUERY, 3, 100);
			queryArea.setWrapStyleWord(true);
			queryArea.setLineWrap(true);

			JScrollPane scrollPane = new JScrollPane(queryArea, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
					ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

			// establece objeto JButton para enviar las consultas
			JButton submitButton = new JButton("Submit Query");

			// create Box to manage placement of queryArea and
			// submitButton in GUI
			Box boxNorth = Box.createHorizontalBox();
			boxNorth.add(scrollPane);
			boxNorth.add(submitButton);

			// create JTable based on the tableModel
			JTable resultTable = new JTable(tableModel);

			JLabel filterLabel = new JLabel("Filter:");
			final JTextField filterText = new JTextField();
			JButton filterButton = new JButton("Apply Filter");
			Box boxSouth = Box.createHorizontalBox();

			boxSouth.add(filterLabel);
			boxSouth.add(filterText);
			boxSouth.add(filterButton);

			// place GUI components on JFrame's content pane
			JFrame window = new JFrame("Displaying Query Results");
			window.add(boxNorth, BorderLayout.NORTH);
			window.add(new JScrollPane(resultTable), BorderLayout.CENTER);
			window.add(boxSouth, BorderLayout.SOUTH);

			// create event listener for submitButton
			submitButton.addActionListener(new ActionListener()
			{
				@Override public void actionPerformed(ActionEvent event)
				{
					// perform a new query
					try
					{
						tableModel.setQuery(queryArea.getText());
					} catch(SQLException sqlException)
					{
						JOptionPane.showMessageDialog(null, sqlException.getMessage(), "Database error",
								JOptionPane.ERROR_MESSAGE);

						// try to recover from invalid user query
						// by executing default query
						try
						{
							tableModel.setQuery(DEFAULT_QUERY);
							queryArea.setText(DEFAULT_QUERY);
						} catch(SQLException sqlException2)
						{
							JOptionPane.showMessageDialog(null, sqlException2.getMessage(), "Database error",
									JOptionPane.ERROR_MESSAGE);

							// ensure database connection is closed
							tableModel.disconnectFromDatabase();

							System.exit(1); // terminate application
						}
					}
				}
			}); // end call to addActionListener

			final TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(tableModel);
			resultTable.setRowSorter(sorter);

			// create listener for filterButton
			filterButton.addActionListener(new ActionListener()
			{
				// pass filter text to listener
				@Override public void actionPerformed(ActionEvent e)
				{
					String text = filterText.getText();

					if (text.length() == 0)
					{
						sorter.setRowFilter(null);
					} else
					{
						try
						{
							sorter.setRowFilter(RowFilter.regexFilter(text));
						} catch(PatternSyntaxException pse)
						{
							JOptionPane.showMessageDialog(null, "Bad regex pattern", "Bad regex pattern",
									JOptionPane.ERROR_MESSAGE);
						}
					}
				}
			}); // end call to addActionLister

			// dispose of window when user quits application (this overrides
			// the default of HIDE_ON_CLOSE)
			window.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
			window.setSize(500, 250);
			window.setVisible(true);

			// ensure database is closed when user quits application
			window.addWindowListener(new WindowAdapter()
			{
				@Override public void windowClosed(WindowEvent event)
				{
					tableModel.disconnectFromDatabase();
					System.exit(0);
				}
			});
		} catch(SQLException sqlException)
		{
			JOptionPane.showMessageDialog(null, sqlException.getMessage(), "Database error", JOptionPane.ERROR_MESSAGE);
			tableModel.disconnectFromDatabase();
			System.exit(1); // terminate application
		}
	}
} // end class DisplayQueryResults






/// **************************************************************************
/// *****************************************************************************

/*
 * //Fig. 24.25: ResultSetTableModel.java
 * //A TableModel that supplies ResultSet data to a JTable.
 * import java.sql.Connection;
 * import java.sql.Statement;
 * import java.sql.DriverManager;
 * import java.sql.ResultSet;
 * import java.sql.ResultSetMetaData;
 * import java.sql.SQLException;
 * import javax.swing.table.AbstractTableModel;
 * //ResultSet rows and columns are counted from 1 and JTable
 * //rows and columns are counted from 0. When processing
 * //ResultSet rows or columns for use in a JTable, it is
 * //necessary to add 1 to the row or column number to manipulate
 * //the appropriate ResultSet column (i.e., JTable column 0 is
 * //ResultSet column 1 and JTable row 0 is ResultSet row 1).
 * public class ResultSetTableModel extends AbstractTableModel
 * {
 * private final Connection connection;
 * private final Statement statement;
 * private ResultSet resultSet;
 * private ResultSetMetaData metaData;
 * private int numberOfRows;
 * // keep track of database connection status
 * private boolean connectedToDatabase = false;
 * // CONSTRUCTOR: initializes resultSet and obtains its meta data object;
 * // determines number of rows
 * public ResultSetTableModel(String url, String username, String password, String query) throws SQLException
 * {
 * // connect to database
 * this.connection = DriverManager.getConnection(url, username, password);
 * // create Statement to query database
 * this.statement = this.connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
 * // update database connection status
 * this.connectedToDatabase = true;
 * // set query and execute it
 * this.setQuery(query);
 * }
 * // get class that represents column type
 * @Override public Class getColumnClass(int column) throws IllegalStateException
 * {
 * // ensure database connection is available
 * if (!this.connectedToDatabase)
 * {
 * throw new IllegalStateException("Not Connected to Database");
 * }
 * // determine Java class of column
 * try
 * {
 * String className = this.metaData.getColumnClassName(column + 1);
 * // return Class object that represents className
 * return Class.forName(className);
 * } catch(Exception exception)
 * {
 * exception.printStackTrace();
 * }
 * return Object.class; // if problems occur above, assume type Object
 * }
 * //get number of columns in ResultSet
 * @Override public int getColumnCount() throws IllegalStateException
 * {
 * // ensure database connection is available
 * if (!this.connectedToDatabase)
 * {
 * throw new IllegalStateException("Not Connected to Database");
 * }
 * // determine number of columns
 * try
 * {
 * return this.metaData.getColumnCount();
 * } catch(SQLException sqlException)
 * {
 * sqlException.printStackTrace();
 * }
 * return 0; // if problems occur above, return 0 for number of columns
 * }
 * //get name of a particular column in ResultSet
 * @Override public String getColumnName(int column) throws IllegalStateException
 * {
 * // ensure database connection is available
 * if (!this.connectedToDatabase)
 * {
 * throw new IllegalStateException("Not Connected to Database");
 * }
 * // determine column name
 * try
 * {
 * return this.metaData.getColumnName(column + 1);
 * } catch(SQLException sqlException)
 * {
 * sqlException.printStackTrace();
 * }
 * return ""; // if problems, return empty string for column name
 * }
 * //return number of rows in ResultSet
 * @Override public int getRowCount() throws IllegalStateException
 * {
 * // ensure database connection is available
 * if (!this.connectedToDatabase)
 * {
 * throw new IllegalStateException("Not Connected to Database");
 * }
 * return this.numberOfRows;
 * }
 * //obtain value in particular row and column
 * @Override public Object getValueAt(int row, int column) throws IllegalStateException
 * {
 * // ensure database connection is available
 * if (!this.connectedToDatabase)
 * {
 * throw new IllegalStateException("Not Connected to Database");
 * }
 * // obtain a value at specified ResultSet row and column
 * try
 * {
 * this.resultSet.absolute(row + 1);
 * return this.resultSet.getObject(column + 1);
 * } catch(SQLException sqlException)
 * {
 * sqlException.printStackTrace();
 * }
 * return ""; // if problems, return empty string object
 * }
 * //set new database query string
 * public void setQuery(String query) throws SQLException, IllegalStateException
 * {
 * // ensure database connection is available
 * if (!this.connectedToDatabase)
 * {
 * throw new IllegalStateException("Not Connected to Database");
 * }
 * // specify query and execute it
 * this.resultSet = this.statement.executeQuery(query);
 * // obtain meta data for ResultSet
 * this.metaData = this.resultSet.getMetaData();
 * // determine number of rows in ResultSet
 * this.resultSet.last(); // move to last row
 * this.numberOfRows = this.resultSet.getRow(); // get row number
 * // notify JTable that model has changed
 * this.fireTableStructureChanged();
 * }
 * //close Statement and Connection
 * public void disconnectFromDatabase()
 * {
 * if (this.connectedToDatabase)
 * {
 * // close Statement and Connection
 * try
 * {
 * this.resultSet.close();
 * this.statement.close();
 * this.connection.close();
 * } catch(SQLException sqlException)
 * {
 * sqlException.printStackTrace();
 * } finally // update database connection status
 * {
 * this.connectedToDatabase = false;
 * }
 * }
 * }
 * } // end class ResultSetTableModel
 */



