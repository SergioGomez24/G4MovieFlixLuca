package dao;

import java.sql.SQLException;
import java.util.ArrayList;

import modelo.Pelicula;

public interface IPelicula_DAO {
	
	public void liberarRecursos() throws SQLException;
	public boolean altaPelicula(Pelicula p) throws SQLException;
	public ArrayList<Pelicula> listarPelicula() throws SQLException;

}
