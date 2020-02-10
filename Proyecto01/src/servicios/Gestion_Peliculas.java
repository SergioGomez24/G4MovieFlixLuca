
/**
 *Gestion_Peliculas
 * 
 * Contiene la implementación de la gestión de peliculas con el método altaPelicula.
 * 
 * Fecha: 10/02/2020
 * 
 * @author David Heras Montegrifo
 * @version 1.0
 *
 */
package servicios;

import java.sql.SQLException;

import dao.IPelicula_DAO;
import dao.Pelicula_DAO;
import modelo.Pelicula;

public class Gestion_Peliculas implements IGestion_Peliculas {

	private IPelicula_DAO peliDao = new Pelicula_DAO();
	
	public void altaPelicula() {
		Pelicula p = new Pelicula();
		p.crearPelicula();
		this.altaPelicula(p);
	}


	/* (non-Javadoc)
	 * @see servicios.IGestion_Peliculas#altaPelicula(modelo.Pelicula)
	 */
	@Override
	public void altaPelicula(Pelicula peli) {
		try {
			peliDao.altaPelicula(peli);
		}catch(SQLException e) {
			System.out.println("Error 1");
			//TODO añadir logger
		}finally {
			try {
				peliDao.liberarRecursos();
			}catch(SQLException e) {
				System.out.println("Error 2");
				//TODO
			}
		}
	}
}
