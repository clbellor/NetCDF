package logica;

import persistencia.DatosDTO;

/**
 * Clase principal logica, centraliza funciones para tratamiento de archivo
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
