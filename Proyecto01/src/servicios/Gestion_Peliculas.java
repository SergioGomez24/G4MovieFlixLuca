
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
import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import dao.IPelicula_DAO;
import dao.Pelicula_DAO;
import gui.Vista;
import modelo.Pelicula;

public class Gestion_Peliculas implements IGestion_Peliculas {

	private IPelicula_DAO peliDao = new Pelicula_DAO();
	private static Logger logger;
	
	static {
        try {
            logger = LogManager.getLogger(Gestion_Peliculas.class);
        } catch (Throwable e) {
            System.out.println("Error en el logger");
        }
    }
	
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
			//System.out.println("Error 1");
			logger.error("Error: " + e.getSQLState());
		}finally {
			try {
				peliDao.liberarRecursos();
			}catch(SQLException e) {
				//System.out.println("Error 2");
				logger.error("Error: " + e.getSQLState());
			}
		}
	}
	
	public ArrayList<Pelicula> listarPelicula(){
		ArrayList<Pelicula> lista = null;
		try {
			lista = peliDao.listarPelicula();
			
		} catch (SQLException e) {
			logger.error("Error: " + e.getSQLState());
		} finally {
			try {
				peliDao.liberarRecursos();
			} catch (SQLException e) {
				logger.error("Error: " + e.getSQLState());
			}
		}
		return lista;
	}
	
	public void mostrarPelicula() {
		Vista.imprimirColeccion(listarPelicula());
	}
}
