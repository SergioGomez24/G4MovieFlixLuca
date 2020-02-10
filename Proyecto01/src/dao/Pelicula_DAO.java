package dao;

import java.sql.SQLException;

import modelo.Pelicula;

public class Pelicula_DAO extends DAO{
	
	public Pelicula_DAO() {
		super();
	}

	public boolean altaPelicula(Pelicula p) throws SQLException {
		String sql = rb.getString("insertar.pelicula");
		pta = conexion.prepareStatement(sql);
		pta.setInt(1, p.getCod_pelicula());
		pta.setString(2, p.getNombre_pelicula());
		pta.setInt(3, p.getAnio_pelicula());
		pta.setString(4, p.getCategoria().toString());
		int num = pta.executeUpdate();
		if(num == 1)
			return true;
		else
			return false;//el insert ha fallado
	}
}
