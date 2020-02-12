/**
 * Interfaz Gestion_Usuario
 * 
 * Creacion de la interfaz relativa al Usuario
 * Fecha: 11/02/2020
 * 
 * @author Alejandro Martín Martín
 * @version 1.0
 *
 */

package servicios;

import java.util.ArrayList;

import modelo.Usuario;

public interface IGestion_Usuarios {
	/**
	 * Contiene el metodo que da de alta al usuario
	 */
	public void altaUsuario();
	/**
	 * Contiene el metodo que da de alta al usuario pidiendo usuario como argumento
	 */
	public void altaUsuario(Usuario usu);
	/**
	 * Contiene el metodo que sirve para listar a los usuarios.
	 */
	public ArrayList<Usuario> listarUsuario();
	/**
	 * Contiene el metodo que sirve para mostrar usuario
	 */
	public void mostrarUsuario();
	/**
	 * Contiene el metodo que sirve para modificar un usuario pidiendo el usuario.
	 */
	public void modificarUsuario(Usuario usu);
	/**
	 * Contiene el metodo que sirve para modificar un usuario, es usado en control.
	 */
	public void modificarUsuario();
	/**
	 * Contiene el metodo que sirve para eliminiar un usuario, es usado en control.
	 */
	public void eliminarUsuario();
	

}
