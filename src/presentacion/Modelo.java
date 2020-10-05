package presentacion;

import java.awt.Color;
import logica.Sistema;

/**
 * Clase intermedia entre Launcher y Vista, provee a la vista de la logica
 * mediante la clase Sistema
 */
public class Modelo {

    private Vista vista;
    private Sistema sistema;

    /**
     * Metodo para obtener unica instancia de Vista usando Singleton
     * @return Vista
     */
    public Vista getVista() {
        if (vista == null) {
            vista = new Vista(this);
        }
        return vista;
    }

    /**
     * Metodo para obtener unica instancia de Sistema usando Singleton
     * @return Sistema
     */
    public Sistema getSistema() {
        if (sistema == null) {
            sistema = new Sistema();
        }
        return sistema;
    }

    /**
     * Metodo para inicializar y mostrar ventana principal
     */
    public void iniciar() {
        Vista ventana = getVista();
        ventana.setBounds(20, 40, 800, 600);
        ventana.getContentPane().setBackground(Color.LIGHT_GRAY);
        ventana.setVisible(true);
    }
}
