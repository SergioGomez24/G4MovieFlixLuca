package modelo;



import java.sql.Date;

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
	
	

	
}
