package servicios;

import java.sql.SQLException;

import dao.Pelicula_DAO;
import modelo.Pelicula;

public class Gestion_Peliculas implements IGestion_Peliculas {

	private Pelicula_DAO peliDao;
	
	
	public Gestion_Peliculas() {
		peliDao = new Pelicula_DAO();
	}


	/* (non-Javadoc)
	 * @see servicios.IGestion_Peliculas#altaPelicula(modelo.Pelicula)
	 */
	@Override
	public void altaPelicula(Pelicula peli) {
		try {
			peliDao.altaPelicula(peli);
		}catch(SQLException e) {
			//TODO añadir logger
		}finally {
			try {
				peliDao.liberarRecursos();
			}catch(SQLException e) {
				//TODO
			}
		}
	}
}
