package dao;

import java.sql.SQLException;
import java.util.HashMap;

import modelo.Categoria;

public interface ICategoria_DAO {
	
	public HashMap<Integer, Categoria> recuperarCategorias() throws SQLException;

}
