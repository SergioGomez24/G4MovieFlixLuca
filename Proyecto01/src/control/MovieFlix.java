package control;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import gui.Menu;
import servicios.Gestion_Peliculas;
import servicios.IGestion_Peliculas;
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
