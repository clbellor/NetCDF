package logica;

import persistencia.VariableDTO;

/**
 * Clase principal logica, centraliza funciones para tratamiento de archivo
 */
public class Sistema {

    private VariableDTO datos;
    private final LecturaArchivo lecturaArchivo;

    public Sistema() {
        this.lecturaArchivo = new LecturaArchivo();
    }
    
     public LecturaArchivo getLecturaArchivo() {
        return lecturaArchivo;
    }
    
    public VariableDTO getDatos() {
        return datos;
    }

    public void setDatos(VariableDTO datos) {
        this.datos = datos;
    }

}
