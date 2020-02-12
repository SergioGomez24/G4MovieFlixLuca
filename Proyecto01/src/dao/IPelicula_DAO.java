package dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import modelo.Pelicula;

public interface IPelicula_DAO {
	
	public void liberarRecursos() throws SQLException;
	public boolean altaPelicula(Pelicula p) throws SQLException;
	public ArrayList<Pelicula> listarPelicula() throws SQLException;
	public HashMap<Integer, String> mostrarCategoria() throws SQLException;
	public ArrayList<Pelicula> listarPeliculasPorUsuarios(String nick) throws SQLException;
	public ArrayList<Pelicula> listarPeliculasPorCategoria(int cat) throws SQLException;

}
