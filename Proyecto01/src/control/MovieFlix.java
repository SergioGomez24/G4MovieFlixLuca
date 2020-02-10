package control;

import gui.Menu;
import utilidades.LeerTeclado;

public class MovieFlix {
	
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
			switch(LeerTeclado.leerInt()) {
				case 1:
					//services.altaPelicula();
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
        String sino = LeerTeclado.leerPalabra("   ¿Está seguro?(S/N)");
        return (sino.toUpperCase().charAt(0) != 'S');
    }

}
