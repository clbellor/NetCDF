package presentacion;

import java.awt.Color;
import java.awt.Component;
import java.io.File;
import java.util.List;
import javax.swing.JFileChooser;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import logica.Respuesta;
import ucar.ma2.Array;
import ucar.nc2.Dimension;
import ucar.nc2.Variable;

/**
 * clase controlador vista principal
 */
public class Controlador implements ListSelectionListener {

    private final Vista vista;

    private List<Variable> variables;
    File fichero = null;
    Integer fila = null;

    public Controlador(Vista ventana) {
        vista = ventana;
        iniciarEventos();
    }

    /**
     * metodo para iniciar eventos de botones
     */
    public void iniciarEventos() {
        vista.getTblDatos().getSelectionModel().addListSelectionListener(this);
    }

    @Override
    public void valueChanged(ListSelectionEvent lse) {
        if (!lse.getValueIsAdjusting()) {
            this.fila = vista.getTblDatos().getSelectedRow();
            mostrarAtributos();
            mostrarValores();
        }
    }

    /**
     * metodo para cerrar programa
     */
    public void cerrar() {
        System.exit(0);
    }

    /**
     * metodo abrir fichero usando los metodos de sistema de clase logica
     * @return File
     */
    public File abrirFichero() {
        JFileChooser fileChooser = new JFileChooser();
        Component areaTexto = null;
        int seleccion = fileChooser.showOpenDialog(areaTexto);
        if (seleccion == JFileChooser.APPROVE_OPTION) {
            fichero = fileChooser.getSelectedFile();
            vista.getjLabelFichero().setBackground(Color.LIGHT_GRAY);
            vista.getjLabelFichero().setText(fichero.toString());
        }
        return fichero;
    }

    /**
     * Metodo para leer los datos del archivo despues de llamar abrirFichero()
     * @param filename 
     */
    public void leerArchivo(String filename) {
        try {
            Respuesta<List<Variable>> respuesta = vista.getModelo().leerArchivo(filename);
            if (respuesta.isError()) {
                vista.getjLabelFichero().setText(respuesta.getMensaje());
            }
            variables = respuesta.getDatos();
            vista.getjLabelTotalVariables().setText(String.valueOf(variables.size()));
            DefaultTableModel model = (DefaultTableModel) vista.getTblDatos().getModel();
            variables.forEach(var -> {
                model.addRow(new Object[]{var.getFullName(), var.getDataType(), var.getDescription(), obtenerDimensiones(var.getDimensions()),
                    "", obtenerForma(var.getShape()), var.getUnitsString()});
            });
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    /**
     * Muestra los valores de las variables del archivo
     */
    public void mostrarValores() {
        Array data;
        try {
            if (this.fila != null) {
                data = this.variables.get(this.fila).read();
                vista.getTxtAreaVal().setText(data.toString());
            } else {
                vista.getTxtAreaVal().setText("Seleccione una fila");
            }
        } catch (Exception ex) {
            vista.getTxtAreaVal().setText("error: " + ex.getMessage());
        }
    }

    /**
     * Muestra los atributos de las variables del archivo
     */
    public void mostrarAtributos() {
        try {
            if (this.fila != null) {               
                vista.getTxtAreaAtr().setText(this.variables.get(this.fila).toString());
            } else {
                vista.getTxtAreaAtr().setText("Seleccione una fila");
            }
        } catch (Exception ex) {
            vista.getTxtAreaAtr().setText("error: " + ex.getMessage());
        }
    }

    /**
     * metodo para obtener dimensiones
     * @param d lista de dimensiones
     * @return String
     */
    public String obtenerDimensiones(List<Dimension> d) {
        String cadena = "";
        if (!d.isEmpty()) {
            for (Dimension dim : d) {
                if (cadena.isEmpty()) {
                    cadena += dim.getFullName();
                } else {
                    cadena += "," + dim.getFullName();
                }
            }
        }
        return cadena;
    }

    /**
     * Metodo para obtener formas
     * @param f formas
     * @return String
     */
    public String obtenerForma(int[] f) {
        String cadena = "";
        if (f.length > 0) {
            for (int i : f) {
                if (cadena.isEmpty()) {
                    cadena += i;
                } else {
                    cadena += "," + i;
                }
            }
        }
        return cadena;
    }

    public Integer getFila() {
        return fila;
    }

    public void setFila(Integer fila) {
        this.fila = fila;
    }
}
