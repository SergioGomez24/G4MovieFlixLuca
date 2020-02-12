package servicios;

import java.util.ArrayList;

import modelo.Pelicula;

public interface IGestion_Peliculas {
	
	public void altaPelicula();
	public void altaPelicula(Pelicula peli);
	public ArrayList<Pelicula> listarPelicula();
	public void mostrarPelicula();
	public void filtrarPeliculaPorUsuario();
	public ArrayList<Pelicula> filtrarPeliculaPorUsuario(String nick);

}