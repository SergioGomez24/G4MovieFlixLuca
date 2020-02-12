package dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import modelo.Categoria;

public class Categoria_DAO extends DAO {
	public Categoria_DAO() {
		super();
	}

//	public ArrayList<Categoria> recuperarCategorias() throws SQLException {
//		ArrayList<Categoria> lista = new ArrayList<Categoria>();
//		String consulta = rb.getString("listar.categorias");
//		pta = conexion.prepareStatement(consulta);
//		rs = pta.executeQuery();
//		Categoria c;
//		while (rs.next()) {
//			c = new Categoria();
//			c.setCodCategoria(rs.getInt("cod_categoria"));
//			c.setNombreCategoria(rs.getString("nombre_categoria"));
//			lista.add(c);
//		}
//		return lista;
//	}
	
	public HashMap<Integer, Categoria> recuperarCategorias() throws SQLException{
		HashMap<Integer, Categoria> mapaCat = new HashMap<Integer, Categoria>();
		String consulta = rb.getString("listar.categorias");
		pta = conexion.prepareStatement(consulta);
		rs = pta.executeQuery();
		Categoria c;
		while(rs.next()) {
			c = new Categoria();
			c.setCodCategoria(rs.getInt("cod_categoria"));
			c.setNombreCategoria(rs.getString("nombre_categoria"));
			mapaCat.put(c.getCodCategoria(), c);
		}
		
		return mapaCat;
	}
}