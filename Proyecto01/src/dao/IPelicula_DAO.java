package dao;

import java.sql.SQLException;

import modelo.Pelicula;

public interface IPelicula_DAO {
	
	public void liberarRecursos() throws SQLException;
	public boolean altaPelicula(Pelicula p) throws SQLException;

}
