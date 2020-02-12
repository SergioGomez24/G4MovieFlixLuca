
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
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import dao.IPelicula_DAO;
import dao.IUsuario_DAO;
import dao.Pelicula_DAO;
import dao.Usuario_DAO;
import gui.Vista;
import modelo.Pelicula;
import modelo.Usuario;

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
		Vista.imprimirColeccion(mostrarCategorias());
		p.setCategoria_pelicula(p.pedirCategoria());
		this.altaPelicula(p);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see servicios.IGestion_Peliculas#altaPelicula(modelo.Pelicula)
	 */
	@Override
	public void altaPelicula(Pelicula peli) {
		try {
			peliDao.altaPelicula(peli);
		} catch (SQLException e) {
			logger.info(e.getErrorCode());
			logger.info(e.getMessage());
			logger.error("Error: " + e.getSQLState());
		} finally {
			try {
				peliDao.liberarRecursos();
			} catch (SQLException e) {
				// System.out.println("Error 2");
				logger.error("Error: " + e.getSQLState());
			}
		}
	}

	public ArrayList<Pelicula> listarPelicula() {
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

	public Map<Integer, String> mostrarCategorias() {
		Map<Integer, String> mapa = null;

		try {
			mapa = peliDao.mostrarCategoria();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mapa;

	}
	
	public void filtrarPeliculaPorUsuario() {
		Vista.imprimirColeccion(filtrarPeliculaPorUsuario(Usuario.pedirNick()));
	}

	public ArrayList<Pelicula> filtrarPeliculaPorUsuario(String nick) {
		ArrayList<Pelicula> lista = null;

		try {
			IUsuario_DAO usuarioDao = new Usuario_DAO();
			Usuario u = null;
			u = usuarioDao.buscarPorNick(nick);
			if(u != null) {
				lista = peliDao.listarPeliculasPorUsuarios(nick);
			} else {
				throw new Exception("El usuario no existe");
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		catch(Exception e) {
			logger.info("Error "+ e.getMessage());
		}
		finally {
			try {
				peliDao.liberarRecursos();
			} catch (SQLException e) {
				logger.error("Error: " + e.getSQLState());
			}
		}
		return lista;
	}
	
	public void filtrarPeliculaPorCategoria() {
		Vista.imprimirColeccion(mostrarCategorias());
		Vista.imprimirColeccion(filtrarPeliculaPorCategoria(Pelicula.pedirCategoria()));
	}

	
	
	public ArrayList<Pelicula> filtrarPeliculaPorCategoria(int cat) {
		ArrayList<Pelicula> lista = null;

		try {
			lista = peliDao.listarPeliculasPorCategoria(cat);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				peliDao.liberarRecursos();
			} catch (SQLException e) {
				logger.error("Error: " + e.getSQLState());
			}
		}
		return lista;
	} 
}
