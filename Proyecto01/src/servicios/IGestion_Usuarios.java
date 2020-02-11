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
	
	public void altaUsuario();
	public void altaUsuario(Usuario usu);
	public ArrayList<Usuario> listarUsuario();
	public void mostrarUsuario();
	public void modificarUsuario(Usuario usu);
	public void modificarUsuario();

}
