package servicios;

import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import dao.IPelicula_DAO;
import dao.IUsuario_DAO;
import dao.Pelicula_DAO;
import dao.Usuario_DAO;
import modelo.Usuario;

public class Gestion_Usuarios implements IGestion_Usuarios{
	
	private IUsuario_DAO usuarioDao = new Usuario_DAO();
	private static Logger logger;
	
	static {
        try {
            logger = LogManager.getLogger(Gestion_Usuarios.class);
        } catch (Throwable e) {
            System.out.println("Error en el logger");
        }
    }
	
	public void altaUsuario() {
		Usuario u = new Usuario();
		u.crearUsuario();
		this.altaUsuario(u);
	}
	
	public void altaUsuario(Usuario usu) {
		
		try {
			usuarioDao.altaUsuario(usu);
		}catch(SQLException e) {
			logger.error("Error: " + e.getSQLState());
		}finally {
			try {
				usuarioDao.liberarRecursos();
			}catch(SQLException e) {
				logger.error("Error: " + e.getSQLState());
			}
		}
		
	}

}
