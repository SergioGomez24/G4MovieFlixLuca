/**
 * Clase Pelicula_DAO
 * 
 * Contiene la informacion de la gestion de datos de las peliculas
 * 
 * Fecha: 11/02/2020
 * 
 * @author Leonardo Flórez Matute
 * @version 1.0
 *
 */
package dao;

import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import modelo.Categoria;
import modelo.Pelicula;

public class Pelicula_DAO extends DAO implements IPelicula_DAO {
	private static Logger logger;
	static {
        try {
            logger = LogManager.getLogger(Pelicula_DAO.class);
        } catch (Throwable e) {
            System.out.println("Error en el logger");
        }
    }
	public Pelicula_DAO() {
		super();
	}

	public boolean altaPelicula(Pelicula p) throws SQLException {
		String sql = rb.getString("insertar.pelicula");
		pta = conexion.prepareStatement(sql);
		pta.setString(1, p.getNombre_pelicula());
		pta.setInt(2, p.getAnio_pelicula());
		pta.setInt(3, p.getCategoria_pelicula().getCodCategoria());
		int num = pta.executeUpdate();
		if (num == 1) {
			System.out.println("Pelicula insertada correctamente");
			return true;
		}else {
			logger.warn("Error al insertar Pelicula");
			//System.out.println("Error al insertar Pelicula");
			return false;// el insert ha fallado
		}
	}

	@Override
	public ArrayList<Pelicula> listarPelicula() throws SQLException {
		ArrayList<Pelicula> lista = new ArrayList<Pelicula>();
		String consulta = rb.getString("listar.peliculas");
		pta = conexion.prepareStatement(consulta);
		rs = pta.executeQuery();
		
		while(rs.next()) {
			Pelicula p = new Pelicula();
			p.setNombre_pelicula(rs.getString("nombre_pelicula"));
			p.setAnio_pelicula(rs.getInt("anio_pelicula"));
			p.setCategoria_pelicula(Categoria.dimeCategoria(rs.getInt("categoria_pelicula")));
			
			lista.add(p);
		}
		return lista;
	}
}
