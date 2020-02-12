package dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

import conexion.Conexion;
/**
 * Clase DAO padre
 * 
 * Se encarga de la comunicacion con la base de datos.</br> 
 * Fecha: 10/02/2020
 * 
 * @author Leonardo Flórez Matute
 * @version 1.0
 *
 */
public abstract class DAO {
	protected Connection conexion;
	protected Statement sta;
	protected ResultSet rs;
	protected ResourceBundle rb;
	protected PreparedStatement pta;
	protected CallableStatement cta;
	/**
	 * Constructor, una nueva conexión a la base de datos
	 */
	public DAO() {
		Conexion con = new Conexion();
		con.crearConexion();
		conexion = con.getConexion();
		rb = ResourceBundle.getBundle("jdbc.sql");
	}
	
	/**
	 * Liberamos recursos.
	 * El proceso sera en el orden inverso de creacion.
	 * 
	 * @throws SQLException 
	 */
	public void liberarRecursos() throws SQLException {
		if (rs != null) {
			// CERRAMOS EL RESULTSET
			rs.close();
		}
		if (pta != null) {
			// CERRAMOS EL PREPARESTATEMENT
			pta.close();
		}
		if (sta != null) {
			// CERRAMOS EL STATEMENT
			sta.close();
		}
		if (cta != null) {
			// CERRAMOS EL CALLABLESTATEMENT
			cta.close();
		}
		if (conexion != null) {
			// CERRAMOS LA CONEXION
			conexion.close();
		}
	}
	
	/**
	 * Proceso de inicio de la transaccion.
	 * 
	 * @throws SQLException
	 */
	public void iniciar_Transaccion() throws SQLException {
		if (conexion != null) {
			conexion.setAutoCommit(false);
		}
	}
	
	/**
	 * Proceso de confirmacion de transaccion.
	 * 
	 * @throws SQLException
	 */
	public void confirmar_Transaccion() throws SQLException {
		if (conexion != null) {
			conexion.commit();
		}
	}
	
	/**
	 * Proceso de anulacion de transaccion.
	 * 
	 * @throws SQLException
	 */
	public void anular_Transaccion() throws SQLException {
		if (conexion != null) {
			conexion.rollback();
		}
	}
	
	/**
	 * Proceso para recibir la conexion de otro dao y poder resolver las
	 * transacciones.
	 * 
	 * @param conexion 
	 */
	public void recibir_Conexion(Connection conexion) throws SQLException {
		liberarRecursos();
		this.conexion = conexion;
	}
}

