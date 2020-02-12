package dao;

import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
/**
 * Clase Pelicula_DAO
 * 
 *Se encarga de gestionar la conexion entre la clase Usuario y la tabla usuario de la base de datos
 * 
 * Fecha: 11/02/2020
 * 
 * @author Leonardo Flórez Matute
 * @see Pelicula
 * @version 1.0
 *
 */
import modelo.Usuario;

public class Usuario_DAO extends DAO implements IUsuario_DAO {
	private static Logger logger;
	static {
		try {
			logger = LogManager.getLogger(Usuario_DAO.class);
		} catch (Throwable e) {
			System.out.println("Error en el logger");
		}
	}

	public Usuario_DAO() {
		super();
	}

	/**
	 * Crea un nuevo registro en la tabla Usuario con un usuario generado
	 * @param usu Usuario lista para ser enviada
	 * @throws SQLException
	 * @return <ul><li><code>true</code>: el registro usuario se ha registrado correctamente en la base de datos</li>
	 * <li><code>false</code>: ha ocurrido un error creando el registro</li></ul>
	 */
	@Override
	public boolean altaUsuario(Usuario usu) throws SQLException {
		String sql = rb.getString("insertar.usuario");
		pta = conexion.prepareStatement(sql);
		pta.setString(1, usu.getNombre_Usuario());
		pta.setDate(2, usu.getFechaNac_Usuario());
		pta.setString(3, usu.getResidencia_Usuario());
		pta.setString(4, usu.getNick_Usuario());
		int num = pta.executeUpdate();
		if (num == 1) {
			System.out.println("Usuario insertado correctamente");
			return true;
		} else {
			logger.warn("Error al insertar usuario");
			return false;// el insert ha fallado
		}
	}
	/**
	 * Devuelve todos los registros de la tabla Usuario en forma de ArrayList.
	 * @return un ArrayList con Objetos de tipo Usuario.
	 */
	@Override
	public ArrayList<Usuario> listarUsuario() throws SQLException {
		ArrayList<Usuario> lista = new ArrayList<Usuario>();
		String consulta = rb.getString("listar.usuarios");
		pta = conexion.prepareStatement(consulta);
		rs = pta.executeQuery();
		
		while(rs.next()) {
			Usuario u = new Usuario();
			u.setNombre_Usuario(rs.getString("nombre_Usuario"));
			u.setFechaNac_Usuario(rs.getDate("fechaNac_Usuario"));
			u.setResidencia_Usuario(rs.getString("residencia_Usuario"));
			u.setNick_Usuario(rs.getString("nick_Usuario"));
			
			lista.add(u);
		}
		return lista;
	}
	/**
	 * Modifica un usuario existente en la tabla Usuario de la base de datos.
	 * @param usu Usuario a modificar, los datos de la base de datos son reemplazados por los del objeto.
	 * @return <ul><li><code>true</code>: el objeto usuario se ha modificado correctamente en la base de datos</li>
	 * <li><code>false</code>: ha ocurrido un error modificando el registro</li></ul>
	 */
	@Override
	public boolean modificarUsuario(Usuario usu) throws SQLException {
		String update = rb.getString("modificar.usuario");
		pta = conexion.prepareStatement(update);
		pta.setString(1, usu.getNombre_Usuario());
		pta.setDate(2, usu.getFechaNac_Usuario());
		pta.setString(3, usu.getResidencia_Usuario());
		pta.setString(4, usu.getNick_Usuario());
		int num = pta.executeUpdate();
		if (num == 1) {
			System.out.println("Usuario modificado correctamente");
			return true;
		} else {
			logger.info("Modificación erronea");
			return false;
		}
		
	}
	/**
	 * Busca un usuario por Nick en la tabla Usuario.
	 * @param nick Nick (único) del usuario a buscar.
	 * @return Usuario un objeto de tipo Usuario con los datos obtenidos de la base de datos.
	 */
	public Usuario buscarPorNick(String nick) throws SQLException {
		String buscar = rb.getString("buscar.usuario.nick");
		pta = conexion.prepareStatement(buscar);
		pta.setString(1, nick);
		rs = pta.executeQuery();
		
		Usuario u = null;
		if(rs.next()) {
			u = new Usuario();
			u.setNombre_Usuario(rs.getString("nombre_Usuario"));
			u.setFechaNac_Usuario(rs.getDate("fechaNac_Usuario"));
			u.setResidencia_Usuario(rs.getString("residencia_Usuario"));
			u.setNick_Usuario(rs.getString("nick_Usuario"));
		}
		return u;
	}
	/**
	 * Elimina un usuario existente de la tabla usuario.
	 * @param nick Nick (único) del usuario a eliminar.
	 * @return <ul><li><code>true</code>: el objeto usuario se ha eliminado correctamente en la base de datos</li>
	 * <li><code>false</code>: ha ocurrido un error eliminado el registro</li></ul>
	 */
	public boolean eliminarUsuario(String nick) throws SQLException {
		String borrar = rb.getString("eliminar.usuario");
		pta = conexion.prepareStatement(borrar);
		pta.setString(1, nick);
		int num = pta.executeUpdate();
		if (num == 1) {
			logger.info("Eliminado correctamente");
			return true;
		} else {
			logger.info("Eliminación erronea");
			return false;
		}
	}


}
