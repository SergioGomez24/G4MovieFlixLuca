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

	//Atributo
	private final int codCategoria;
	private static final int size = Categoria.values().length;

	//Constructor
	private Categoria(int codCategoria) {
		this.codCategoria = codCategoria;
	}

	//Metodo getter
	public int getCodCategoria() {
		return codCategoria;
	}
	
	public static int getSize() {
        return size;
    }
	
	//Metodo para elegir la categoria de una Pelicula
    private static Categoria[] values = null;

    public static Categoria dimeCategoria(int val) {
        if (Categoria.values == null) {
            Categoria.values = Categoria.values();
        }
        
        return Categoria.values[val];
    }
	
	public static void Informe2() {
        StringBuilder sb;
        for (Categoria cat : Categoria.values()) {
            sb = new StringBuilder();
            sb.append("(").
                    append(cat.codCategoria).
                    append(")").
                    append(cat).
                    append("|");
            System.out.println(sb);
        }
    }

}
