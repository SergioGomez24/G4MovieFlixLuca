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
	private int categoria_pelicula;
	
	//Contructor superclase
	public Pelicula() {
		super();
	}
	
	//Constructor con atributos
	public Pelicula(String nombre_pelicula, int anio_pelicula, int categoria_pelicula) {
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

	public int getCategoria_pelicula() {
		return categoria_pelicula;
	}

	public void setCategoria_pelicula(int categoria_pelicula) {
		this.categoria_pelicula = categoria_pelicula;
	}
	
	public void crearPelicula() {
		
		System.out.println("CREAR PELICULA:");
		
		try {
			this.nombre_pelicula = LeerTeclado.leerLinea("Introduce el nombre de la pelicula");
			this.anio_pelicula = LeerTeclado.leerInt("Introduce el año de la pelicula");
		} catch (Exception e) {
            e.getStackTrace();
		}
	}
	
	public int pedirCategoria() {
		int num = LeerTeclado.leerInt("Introduce una categoria");
		
		return num;
	}
	
	//Metodo tostring
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Pelicula: "+nombre_pelicula+" | año lanzamiento: "+anio_pelicula+" | categoria: "+categoria_pelicula+",");
		return sb.toString();
		
	}

}
