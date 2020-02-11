/**
 * Clase MovieFlix
 * 
 * Contiene la informacion de la parte de control de las peliculas
 * 
 * Fecha: 10/02/2020
 * 
 * @author Sergio G�mez Ben�tez
 * @version 1.0
 *
 */

package control;

import gui.Menu;
import servicios.Gestion_Peliculas;
import servicios.IGestion_Peliculas;
import utilidades.LeerTeclado;

public class MovieFlix {
	
	private IGestion_Peliculas servicioPeliculas;
	
	public void abrirMovieFlix() {
		boolean seguir = true;
		
		do {
			Menu.mostrarMenu();
			seguir = this.mostrarOpciones();
		} while(seguir);
	}
	
	public boolean mostrarOpciones() {
		
		boolean continuar = true;
		
		try {
			servicioPeliculas  = new Gestion_Peliculas();
			switch(LeerTeclado.leerInt()) {
				case 1:
					servicioPeliculas.altaPelicula();
					break;
					
				case 0:
					continuar = salir();
					break;
			}
			
		} catch (Exception e) {
            System.out.println("error: " + e.toString());
		}
		
		return continuar;
	}
	
	private boolean salir() throws Exception {
        String sino = LeerTeclado.leerPalabra("   �Est� seguro?(S/N)");
        return (sino.toUpperCase().charAt(0) != 'S');
    }

}
