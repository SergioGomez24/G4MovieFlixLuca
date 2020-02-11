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
	
	public void crearPelicula() {
		
		System.out.println("CREAR PELICULA:");
		
		try {
			this.nombre_pelicula = LeerTeclado.leerPalabra("Introduce el nombre de la pelicula");
			this.anio_pelicula = LeerTeclado.leerInt("Introduce el año de la pelicula");
			System.out.println("Introduce el codigo de la categoria");
			Categoria.mostrarCategorias();
			this.categoria_pelicula = Categoria.dimeCategoria(LeerTeclado.leerInt());
		} catch (Exception e) {
            e.getStackTrace();
		}
		
	}
	
	//Metodo tostring
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Pelicula: "+nombre_pelicula+" | año lanzamiento: "+anio_pelicula+" | categoria: "+categoria_pelicula+",");
		return sb.toString();
		
	}

}
