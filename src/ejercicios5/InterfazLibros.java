package ejercicios5;


/**
 * @descrition
 * @author carlosfernandez
 * @date Feb 3, 2018
 * @version 1.0
 * @license GPLv3
 */

public interface InterfazLibros {
	
	
	
	/**
	 * Metodo que muestra por pantalla los datos los libros en orden alfabético
	 * 
	 */
	public void verCatalogoInverso();
	
	/**
	 * Metodo que muestra por pantalla los datos los libros en orden inverso alfabético
	 * 
	 * @param con
	 */
	public void verCatalogo();
	
	/**
	 * Actualiza el numero de copias para un libro
	 * 
	 * @param isbn
	 * @param copias
	 */
	
	public void actualizarCopias(int isbn, int copias);
	
	/**
	 * añade un nuevo libro a la BD
	 * 
	 * @param isbn
	 * @param titulo
	 * @param autor
	 * @param editorial
	 * @param paginas
	 * @param copias
	 * @throws AccesoDatosException
	 */
	public void anadirLibro(int isbn, String titulo, String autor, String editorial, int paginas, int copias);



	/**
	 * Borra un libro por ISBN
	 * 
	 * @param isbn
	 */
	public void borrar(int isbn) ;
	
	/**
	 * Devulve los nombres de los campos de BD
	 * 
	 * @return
	 */
	public String[] getCamposLibro() ;
}
