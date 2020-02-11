package dao;

import java.sql.SQLException;
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
			System.out.println("Usuario insertada correctamente");
			return true;
		} else {
			logger.warn("Error al insertar usuario");
			return false;// el insert ha fallado
		}
	}
}
