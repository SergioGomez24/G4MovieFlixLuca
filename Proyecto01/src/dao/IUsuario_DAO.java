package dao;

import java.sql.SQLException;
import java.util.ArrayList;
import modelo.Usuario;

public interface IUsuario_DAO {
	
	public void liberarRecursos() throws SQLException;

	boolean altaUsuario(Usuario usu) throws SQLException;

	public ArrayList<Usuario> listarUsuario() throws SQLException;

	public boolean modificarUsuario(Usuario usu) throws SQLException;

	public boolean eliminarUsuario(String nick) throws SQLException;
}