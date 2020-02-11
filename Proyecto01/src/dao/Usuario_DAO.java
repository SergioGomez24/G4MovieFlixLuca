package dao;

import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

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

	/* (non-Javadoc)
	 * @see dao.IUsuario_DAO#altaUsuario(modelo.Usuario)
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
			logger.info("Modificación correcta");
			return true;
		} else {
			logger.info("Modificación erronea");
			return false;
		}
		
	}
	
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
