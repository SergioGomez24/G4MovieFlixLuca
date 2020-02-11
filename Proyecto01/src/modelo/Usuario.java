package modelo;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Month;

import utilidades.LeerTeclado;

public class Usuario {

	private String nombre_Usuario;
	private Date fechaNac_Usuario;
	private String residencia_Usuario;
	private String nick_Usuario;

	public Usuario() {
	}

	public String getNombre_Usuario() {
		return nombre_Usuario;
	}

	public void setNombre_Usuario(String nombre_Usuario) {
		this.nombre_Usuario = nombre_Usuario;
	}

	public Date getFechaNac_Usuario() {
		return fechaNac_Usuario;
	}

	public void setFechaNac_Usuario(Date fechaNac_Usuario) {
		this.fechaNac_Usuario = fechaNac_Usuario;
	}

	public String getResidencia_Usuario() {
		return residencia_Usuario;
	}

	public void setResidencia_Usuario(String residencia_Usuario) {
		this.residencia_Usuario = residencia_Usuario;
	}

	public String getNick_Usuario() {
		return nick_Usuario;
	}

	public void setNick_Usuario(String nick_Usuario) {
		this.nick_Usuario = nick_Usuario;
	}

	@Override
	public String toString() {
		return "Usuario [nombre_Usuario=" + nombre_Usuario + ", fechaNac_Usuario=" + fechaNac_Usuario
				+ ", residencia_Usuario=" + residencia_Usuario + ", nick_Usuario=" + nick_Usuario + "]";
	}

	public void crearUsuario() {

		try {
			this.nick_Usuario = LeerTeclado.leerPalabra("Introduce el nick del usuario");
			this.nombre_Usuario = LeerTeclado.leerLinea("Introduce el nombre del usuario");
			this.residencia_Usuario = LeerTeclado.leerLinea("Introduce la ciudad de residencia");

			String entrada = LeerTeclado.leerPalabra("Introduce la fecha de nacimiento con este formato MM/dd/yyyy");
			DateFormat format = new SimpleDateFormat("MM/dd/yyyy"); // Creamos un formato de fecha
			java.util.Date fecha = format.parse(entrada);
			Date fechaSql = new Date( fecha.getTime());
			this.fechaNac_Usuario = fechaSql;

		} catch (Exception e) {
			e.getStackTrace();
		}

	}

}
