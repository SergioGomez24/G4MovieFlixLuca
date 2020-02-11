package dao;

import java.sql.SQLException;

import modelo.Usuario;

public interface IUsuario_DAO {

	public void liberarRecursos() throws SQLException;
	boolean altaUsuario(Usuario usu) throws SQLException;

}