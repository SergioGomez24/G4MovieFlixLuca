/**
 * Clase Pelicula
 * 
 * Contiene informaci�n de cada Pelicula
 * 
 * Fecha: 10/02/2020
 * 
 * @author Sergio G�mez Ben�tez
 * @version 1.0
 *
 */

package modelo;

import utilidades.LeerTeclado;

public class Pelicula {
	
	//Atributos
	private String nombre_pelicula;
	private int anio_pelicula;
	private Categoria categoria_pelicula;
	
	//Contructor superclase
	public Pelicula() {
		super();
	}
	
	//Constructor con atributos
	public Pelicula(String nombre_pelicula, int anio_pelicula, Categoria categoria_pelicula) {
		super();
		this.nombre_pelicula = nombre_pelicula;
		this.anio_pelicula = anio_pelicula;
		this.categoria_pelicula = categoria_pelicula;
	}
	
	//Metodos setters y getters
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

	public Categoria getCategoria_pelicula() {
		return categoria_pelicula;
	}

	public void setCategoria_pelicula(Categoria categoria_pelicula) {
		this.categoria_pelicula = categoria_pelicula;
	}
	
	public Pelicula crearPelicula() {
		Pelicula p = null;
		try {
			p = new Pelicula();
			p.setNombre_pelicula(LeerTeclado.leerPalabra("Introduce el nombre de la pelicula"));
			p.setAnio_pelicula(LeerTeclado.leerInt("Introduce el a�o de la pelicula")); 
			System.out.println("Introduce el codigo de la categoria");
			Categoria.mostrarCategorias();
			p.setCategoria_pelicula(Categoria.dimeCategoria(LeerTeclado.leerInt()));
			
		} catch (Exception e) {
            e.getStackTrace();
		}
		return p;
	}
	
	//Metodo tostring
	@Override
	public String toString() {
		return "Pelicula [nombre_pelicula=" + nombre_pelicula + ", anio_pelicula="
				+ anio_pelicula + ", categoria=" + categoria_pelicula + "]";
	}

}
