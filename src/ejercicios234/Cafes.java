package ejercicios234;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import ejercicios1.TablaCafes;

/**
 * @descrition
 * @author carlosfernandez
 * @date Feb 3, 2018
 * @version 1.0
 * @license GPLv3
 */

public class Cafes extends Conexion implements InterfazCafes {

	// Consultas a realizar en BD
	private static final String SELECT_CAFES_QUERY = "select " + TablaCafes.COLUMN_CAF_NOMBRE + ", "+TablaCafes.COLUMN_FOREIGN_PROV_ID+" ,"
			+ TablaCafes.COLUMN_TOTAL + ", " + TablaCafes.COLUMN_PRECIO + ", " + TablaCafes.COLUMN_VENTAS + ", "
			+ TablaCafes.COLUMN_TOTAL + " from " + TablaCafes.TABLE_NAME;

	Cafes() {
		createTable(TablaCafes.CREATE_TABLE);
		createTable(TablaProveedor.CREATE_TABLE);

	}
	
	/**
	 * Metodo que muestra por pantalla los datos de la tabla cafes
	 * 
	 * @param con
	 * @throws SQLException
	 */
	public void verTabla() {
		try (Statement stmt = getConexion().createStatement()) {

			try (ResultSet rs = stmt.executeQuery(SELECT_CAFES_QUERY)) {

				// Recuperacion de los datos del ResultSet
				while (rs.next()) {
					String coffeeName = rs.getString(TablaCafes.COLUMN_CAF_NOMBRE);
					int supplierID = rs.getInt(TablaCafes.COLUMN_FOREIGN_PROV_ID);
					float PRECIO = rs.getFloat(TablaCafes.COLUMN_PRECIO);
					int VENTAS = rs.getInt(TablaCafes.COLUMN_VENTAS);
					int total = rs.getInt(TablaCafes.COLUMN_TOTAL);
					System.out.println("\t"+coffeeName + ", " + supplierID + ", " + PRECIO + ", " + VENTAS + ", " + total);
				}
			}
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}

	}

	/**
	 * Metodo que busca un cafe por nombre y muestra sus datos
	 *
	 * @param nombre
	 */
	public void buscar(String nombre) {


	}

	/**
	 * Metodo para insertar una fila
	 * 
	 * @param nombre
	 * @param provid
	 * @param precio
	 * @param ventas
	 * @param total
	 * @return
	 */
	public void insertar(String nombre, int provid, float precio, int ventas, int total) {


	}

	/**
	 * Metodo para borrar una fila dado un nombre de cafe
	 * 
	 * @param nombre
	 * @return
	 */
	public void borrar(String nombre) {


	}

	/**
	 * Metodo que busca un cafe por nombre y muestra sus datos
	 *
	 * @param nombre
	 */
	public void cafesPorProveedor(int provid)  {

		
	}
	
	private void createTable(String sql) {
		try (Statement sentencia = getConexion().createStatement()){
			sentencia.executeUpdate(sql);
		} catch (SQLException e) {
			System.err.println(e.getMessage());

		}
	}
	
	

}
