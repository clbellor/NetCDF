package logica;

import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import ucar.ma2.Array;
import ucar.nc2.NetcdfFile;
import ucar.nc2.Variable;

public class LecturaArchivo {

    private List<Variable> variables;
            
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

    public List<Variable> getVariables() {
        return variables;
    }
}
