package presentacion;

import java.awt.event.ActionListener;



/**
 * clase controlador vista principal
 */
public class Controlador {

    private final Vista vista;

    public Controlador(Vista ventana) {
        vista = ventana;
        
    }
    
    /**
     * metodo para cerrar programa
     */
    public void Cerrar() {
        System.exit(0);
    }    
}
