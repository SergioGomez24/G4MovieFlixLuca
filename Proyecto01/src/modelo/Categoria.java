/**
 *Enumeracion Categoria
 * 
 * Contiene la enumeración de las distintas categorías con su código.
 * 
 * Fecha: 10/02/2020
 * 
 * @author David Heras Montegrifo
 * @version 1.0
 *
 */
package modelo;

public enum Categoria {

	POLICIACA(1), ROMANTICA(2), AVENTURAS(3), COMEDIA(4), ANIMACION(5), THRILLER(6);

	private final int codCategoria;

	private Categoria(int codCategoria) {
		this.codCategoria = codCategoria;
	}

	public int getCodCategoria() {
		return codCategoria;
	}

}
