package conexion;

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
		String diver = rb.getString("conexion.driver");
		boolean valido = true;
		try {
			Class.forName(diver);
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
