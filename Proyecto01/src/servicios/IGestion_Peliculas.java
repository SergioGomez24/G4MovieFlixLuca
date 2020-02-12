/**
 * Interfaz Gestion_Peliculas
 * 
 * Contiene las interfaces de los m�todos de la Gesti�n Peliculas
 * 
 * Fecha: 11/02/2020
 * 
 * @author Leonardo Fl�rez Matute
 * @version 1.0
 *
 */
package servicios;

import java.util.ArrayList;

import modelo.Pelicula;

public interface IGestion_Peliculas {
	/**
	 * Contiene el metodo para dar de alta a las peliculas, es llamado por MovieFlix en control.
	 */
	public void altaPelicula(); 
	/**
	 * Contiene el metodo altaPelicula con  un argumento pelicula.
	 */
	public void altaPelicula(Pelicula peli);
	/**
	 * Contiene el metodo  para listar las peliculas disponibles,  es llamado por MovieFlix en control.
	 */
	public ArrayList<Pelicula> listarPelicula();
	/**
	 * Contiene el metodo que muestras las peliculas.
	 */
	public void mostrarPelicula();
	/**
	 * Contiene el metodo filtrarPeliculaPorUsuario sin argumento, es llamado por MovieFlix en control.
	 */
	public void filtrarPeliculaPorUsuario();
	/**
	 * Contiene el metodo que filtra peliculas por usuario a trav�s un un argumento String nick.
	 */
	public ArrayList<Pelicula> filtrarPeliculaPorUsuario(String nick);
	/**
	 * Contiene el metodo que filtra peliculas por categor�a, es llamado por MovieFlix en control. .
	 */
	public void filtrarPeliculaPorCategoria();
	/**
	 * Contiene el metodo que filtra peliculas por categor�a  a trav�s un un argumento int cat.
	 */
	public ArrayList<Pelicula> filtrarPeliculaPorCategoria(int cat);

}