package presentacion;

import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import logica.Respuesta;
import ucar.ma2.Array;
import ucar.nc2.Variable;

/**
 * clase controlador vista principal
 */
public class Controlador {

    private final Vista vista;

    private List<Variable> variables;

    public Controlador(Vista ventana) {
        vista = ventana;

    }

    /**
     * metodo para cerrar programa
     */
    public void Cerrar() {
        System.exit(0);
    }

    public void leerArchivo(String filename) {
        Respuesta<List<Variable>> respuesta = vista.getModelo().leerArchivo(filename);
        if (respuesta.isError()) {
            vista.getjLabelFichero().setText(respuesta.getMensaje());
        }
        variables = respuesta.getDatos();

        DefaultTableModel model = (DefaultTableModel) vista.getTblDatos().getModel();
        variables.forEach(var -> {
            model.addRow(new Object[]{var.getFullName(), var.getDataType(), var.getDescription(), var.getDimensions(),
                "", var.getFullName(), Arrays.toString(var.getShape()), var.getUnitsString()});
        });
    }
}
