/**
 * Clase Pelicula
 * 
 * Contiene información de cada Pelicula
 * 
 * Fecha: 10/02/2020
 * 
 * @author Sergio Gómez Benítez
 * @version 1.0
 *
 */

package modelo;

public class Pelicula {
	
	private int cod_pelicula;
	private String nombre_pelicula;
	private int anio_pelicula;
	private Categoria categoria;
	
	public Pelicula() {
		super();
	}

	public Pelicula(int cod_pelicula, String nombre_pelicula, int anio_pelicula, Categoria categoria) {
		super();
		this.cod_pelicula = cod_pelicula;
		this.nombre_pelicula = nombre_pelicula;
		this.anio_pelicula = anio_pelicula;
		this.categoria = categoria;
	}

	public int getCod_pelicula() {
		return cod_pelicula;
	}

	public void setCod_pelicula(int cod_pelicula) {
		this.cod_pelicula = cod_pelicula;
	}

	public String getNombre_pelicula() {
		return nombre_pelicula;
	}

	public void setNombre_pelicula(String nombre_pelicula) {
		this.nombre_pelicula = nombre_pelicula;
	}

	public int getAnio_pelicula() {
		return anio_pelicula;
	}

	public void setAnio_pelicula(int anio_pelicula) {
		this.anio_pelicula = anio_pelicula;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	@Override
	public String toString() {
		return "Pelicula [cod_pelicula=" + cod_pelicula + ", nombre_pelicula=" + nombre_pelicula + ", anio_pelicula="
				+ anio_pelicula + ", categoria=" + categoria + "]";
	}

}
