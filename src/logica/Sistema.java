package logica;

import java.io.File;
import persistencia.DatosDTO;

/**
 * Clase principal logica para creacion de dibujos, guardar y abrir archivos
 */
public class Sistema {

    private DatosDTO datos;
    private final LecturaArchivo lecturaArchivo;

    public Sistema() {
        this.lecturaArchivo = new LecturaArchivo();
    }
    
     public LecturaArchivo getLecturaArchivo() {
        return lecturaArchivo;
    }
    
    public DatosDTO getDatos() {
        return datos;
    }

    public void setDatos(DatosDTO datos) {
        this.datos = datos;
    }

}
