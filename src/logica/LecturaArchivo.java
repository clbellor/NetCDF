package logica;

import java.io.IOException;
import java.util.List;
import ucar.nc2.NetcdfFile;
import ucar.nc2.Variable;

/**
 * Clase lectura archivo netCDF mediante libreria externa
 */
public class LecturaArchivo {

    private List<Variable> variables;
       
    /**
     * Metodo que lee el archivo mediante NetcdfFile.open
     * @param filename nombre del archivo a leer
     * @return Respuesta
     */
    public Respuesta leerArchivo(String filename) {
        NetcdfFile ncfile;
        Respuesta<List<Variable>> respuesta = new Respuesta();
        try {
            ncfile = NetcdfFile.open(filename);
            System.out.println("leyendo archivo...");
            variables = ncfile.getVariables();
            respuesta.setDatos(variables);
        } catch (IOException ex) {
            respuesta.setError(true);
            respuesta.setMensaje("error al leer el archivo");
        } 
        return respuesta;
    }

    /**
     * retorna lista de variables del archivo leido
     * @return lista Variables
     */
    public List<Variable> getVariables() {
        return variables;
    }
}
