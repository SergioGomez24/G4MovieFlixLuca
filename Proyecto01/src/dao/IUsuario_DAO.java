package dao;

import java.sql.SQLException;
import java.util.ArrayList;

import modelo.Pelicula;
import modelo.Usuario;

public interface IUsuario_DAO {

	boolean altaUsuario(Usuario usu) throws SQLException;
	public ArrayList<Usuario> listarUsuario() throws SQLException;

}