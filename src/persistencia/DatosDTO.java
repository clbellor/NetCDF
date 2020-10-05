package persistencia;

import java.io.File;
import java.util.Vector;

/**
 * Clase para persistencia 
 */
public abstract class DatosDTO {
    
    protected static File archivo;
    
    public abstract Vector abrirArchivo() throws Exception;
    public abstract void guardarArchivo(Vector vPuntos) throws Exception;

    public static File getArchivo() {
        return archivo;
    }

    public static void setArchivo(File archivo){
        DatosDTO.archivo = archivo;
    }
    
    
}
