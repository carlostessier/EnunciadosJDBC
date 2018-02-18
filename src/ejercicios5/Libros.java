package ejercicios5;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



/**
 * @descrition
 * @author carlosfernandez
 * @date Feb 3, 2018
 * @version 1.0
 * @license GPLv3
 */

public class Libros extends Conexion implements InterfazLibros{

	// Consultas a realizar en BD
	private static final String SELECT_LIBROS_QUERY = "select * from "+TablaLibros.TABLE_NAME+" ORDER BY "+TablaLibros.COLUMN_TITULO+" ASC";
	private static final String INSERT_LIBRO_QUERY = "insert into "+TablaLibros.TABLE_NAME+" values (?,?,?,?,?,?)";
	private static final String DELETE_LIBRO_QUERY = "delete from "+TablaLibros.TABLE_NAME+" WHERE "+TablaLibros.COLUMN_ISBN+" = ?";

	public Libros()  {
		createTable(TablaLibros.CREATE_TABLE);

	}

	/**
	 * Metodo que muestra por pantalla los datos de la tabla cafes
	 * 
	 */
	public void verCatalogo() {

		try (Statement stmt = getConexion().createStatement()) {
			try (ResultSet rs = stmt.executeQuery(SELECT_LIBROS_QUERY)) {

				// Recuperacion de los datos del ResultSet
				while (rs.next()) {
					int isbn = rs.getInt(TablaLibros.COLUMN_ISBN);
					String titulo = rs.getString(TablaLibros.COLUMN_TITULO);
					String autor = rs.getString(TablaLibros.COLUMN_AUTOR);
					String editorial = rs.getString(TablaLibros.COLUMN_EDITORIAL);
					int paginas = rs.getInt(TablaLibros.COLUMN_PAGINAS);
					int copias = rs.getInt(TablaLibros.COLUMN_COPIAS);
					System.out.println(
							titulo + ", " + isbn + ", " + autor + ", " + editorial + ", " + paginas + "," + copias);
				}
			}
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}

	}

	/**
	 * Actualiza el numero de copias para un libro
	 * 
	 * @param isbn
	 * @param copias
	 */
	public void actualizarCopias(int isbn, int copias) {
		
	}

	/**
	 * Añade un nuevo libro a la BD
	 * 
	 * @param isbn
	 * @param titulo
	 * @param autor
	 * @param editorial
	 * @param paginas
	 * @param copias
	 */
	public void anadirLibro(int isbn, String titulo, String autor, String editorial, int paginas, int copias) {

		/* Sentencia sql */
		try (PreparedStatement pstmt = getConexion().prepareStatement(INSERT_LIBRO_QUERY)) {
			pstmt.setInt(1, isbn);
			pstmt.setString(2, titulo);
			pstmt.setString(3, autor);
			pstmt.setString(4, editorial);
			pstmt.setInt(5, paginas);
			pstmt.setInt(6, copias);
			pstmt.executeUpdate();

		} catch (SQLException sqle) {
			System.err.println(sqle.getMessage());
		}

	}

	/**
	 * Borra un libro por ISBN
	 * 
	 * @param isbn
	 */
	public void borrar(int isbn) {

		/* Sentencia sql */
		try (PreparedStatement pstmt = getConexion().prepareStatement(DELETE_LIBRO_QUERY)) {

			pstmt.setInt(1, isbn);
			// Ejecucion del borrado
			pstmt.executeUpdate();

		} catch (SQLException sqle) {
			System.err.println(sqle.getMessage());
		}

	}

	

	private void createTable(String sql) {
		try (Statement sentencia = getConexion().createStatement()){
			sentencia.executeUpdate(sql);
		} catch (SQLException e) {
			System.err.println(e.getMessage());

		}
	}

	@Override
	public String[] getCamposLibro() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void verCatalogoInverso() {
		// TODO Auto-generated method stub
		
	}
}
