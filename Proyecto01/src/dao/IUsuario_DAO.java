package dao;

import java.sql.SQLException;

import modelo.Usuario;

public interface IUsuario_DAO {

	boolean altaUsuario(Usuario usu) throws SQLException;

}