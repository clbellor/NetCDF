package logica;

import java.io.File;
import persistencia.DatosDTO;

/**
 * Clase principal logica para creacion de dibujos, guardar y abrir archivos
 */
public class Sistema {

    private DatosDTO datos;

    public Sistema() {

    }

    /**
     * Metodo para abrir dibujo de un archivo guardado
     * @param nombreArchivo
     * @throws Exception 
     */
    public void abrirArchivo(File nombreArchivo) throws Exception {
        //pendiente de implementar 
    }

    /**
     * Metodo para guardar dibujo en un archivo
     * @param nombreArchivo
     * @throws Exception 
     */
    public void guardarArchivo(File nombreArchivo) throws Exception {
        //pendiente de implementar 
    }
    
    public DatosDTO getDatos() {
        return datos;
    }

    public void setDatos(DatosDTO datos) {
        this.datos = datos;
    }

}
