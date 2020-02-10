package conexion;
/**
 * Implementación Conexión
 * 
 * Implementación de la interfaz conexión con la información para la conexión con la BBDD
 * 
 * Fecha: 10/02/2020
 * 
 * @author Leonardo Flórez Matute
 * @version 1.0
 *
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class Conexion implements IConexion {
	//Conexion a la BBDD
	private Connection conexion;
	//lectura de properties
	private ResourceBundle rb;
	
	public Conexion() {
		rb = ResourceBundle.getBundle("conexion.conexion");
	}
	
	/* (non-Javadoc)
	 * @see conexion.IConexion#crearConexion()
	 */
	@Override
	public void crearConexion() {
		establecerConexion();
	}
	
	private void establecerConexion() {
		String url = rb.getString("conexion.url");
		String usuario = rb.getString("conexion.user");
		String clave = rb.getString("conexion.con");
		String driver = rb.getString("conexion.driver");
		boolean valido = true;
		try {
			Class.forName(driver);
		}catch (Exception e) {
			valido = false;
		}
		if(valido) {
			try {
				conexion = DriverManager.getConnection(url, usuario, clave);
			} catch (SQLException e) {
			}
		}
	}
	
	public Connection getConexion() {
		return conexion;
	}

	public void setConexion(Connection conexion) {
		this.conexion = conexion;
	}
	
	
}
