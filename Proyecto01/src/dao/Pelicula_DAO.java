package dao;

import java.sql.SQLException;

import modelo.Pelicula;

public class Pelicula_DAO extends DAO {

	public Pelicula_DAO() {
		super();
	}

	public boolean altaPelicula(Pelicula p) throws SQLException {
		String sql = rb.getString("insertar.pelicula");
		pta = conexion.prepareStatement(sql);
		pta.setString(1, p.getNombre_pelicula());
		pta.setInt(2, p.getAnio_pelicula());
		pta.setString(3, p.getCategoriaPelicula().toString());
		int num = pta.executeUpdate();
		if (num == 1)
			return true;
		else
			return false;// el insert ha fallado
	}
}
