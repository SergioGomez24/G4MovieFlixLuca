/**
 * Clase Categoria
 * 
 * Contiene información de la Categoria
 * 
 * Fecha: 12/02/2020
 * 
 * @author Sergio Gómez Benítez
 * @version 1.0
 *
 */

package modelo;

public class Categoria {
	
	//Atributo
	private int codCategoria;
	private String nombreCategoria;
	
    public Categoria() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Categoria(int codCategoria, String nombreCategoria) {
		super();
		this.codCategoria = codCategoria;
		this.nombreCategoria = nombreCategoria;
	}

	public int getCodCategoria() {
		return codCategoria;
	}

	public void setCodCategoria(int codCategoria) {
		this.codCategoria = codCategoria;
	}

	public String getNombreCategoria() {
		return nombreCategoria;
	}

	public void setNombreCategoria(String nombreCategoria) {
		this.nombreCategoria = nombreCategoria;
	}

	@Override
	public String toString() {
		return "Categoria [codCategoria=" + codCategoria + ", nombreCategoria=" + nombreCategoria + "]";
	}


	/*private static Categoria[] values = null;
    
  //Metodo para elegir la categoria de una Pelicula
    public static Categoria dimeCategoria(int val) {
        if (Categoria.values == null) {
            Categoria.values = Categoria.values();
        }
        
        return Categoria.values[val-1];
    }
	
	public static void mostrarCategorias() {
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
    }*/

}
