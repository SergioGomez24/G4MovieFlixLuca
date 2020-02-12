/**
 * Clase MovieFlix
 * 
 * Contiene la informacion de la parte de control de las peliculas
 * 
 * Fecha: 10/02/2020
 * 
 * @author Sergio Gómez Benítez
 * @version 1.0
 *
 */

package control;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import gui.Menu;
import servicios.Gestion_Peliculas;
import servicios.Gestion_Usuarios;
import servicios.IGestion_Peliculas;
import servicios.IGestion_Usuarios;
import utilidades.LeerTeclado;

public class MovieFlix {
	
	private static Logger logger;
	
	static {
        try {
            logger = LogManager.getLogger(MovieFlix.class);
        } catch (Throwable e) {
            System.out.println("Error en el logger");
        }
    }
	
	private IGestion_Peliculas servicioPeliculas;
	private IGestion_Usuarios servicioUsuarios;
	
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
			servicioUsuarios = new Gestion_Usuarios();
			
			switch(LeerTeclado.leerInt()) {
				case 1:
					servicioPeliculas.altaPelicula();
					break;
				
				case 2:
					servicioPeliculas.mostrarPelicula();
					break;
				
				case 3: 
					servicioUsuarios.altaUsuario();
					break;
					
				case 4:
					servicioUsuarios.mostrarUsuario();
					break;
					
				case 5:
					servicioUsuarios.modificarUsuario();
					break;
				
				case 6:
					servicioUsuarios.eliminarUsuario();
					break;
				
				case 7:
					servicioPeliculas.filtrarPeliculaPorUsuario();
					break;
					
				case 0:
					continuar = salir();
					break;
			}
			
		} catch (Exception e) {
            //System.out.println("error: " + e.toString());
			logger.warn("Error: " + e.getMessage()); 
		}
		
		return continuar;
	}
	
	private boolean salir() throws Exception {
        String sino = LeerTeclado.leerPalabra("   ¿Está seguro?(S/N)");
        return (sino.toUpperCase().charAt(0) != 'S');
    }

}
