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
import persistencia.VariableDTO;
import ucar.ma2.Array;
import ucar.nc2.Dimension;
import ucar.nc2.Variable;

/**
 * clase controlador vista principal
 */
public class Controlador implements ListSelectionListener {

    private final Vista vista;

    private List<VariableDTO> variables;
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
            Respuesta<List<VariableDTO>> respuesta = vista.getModelo().leerArchivo(filename);
            if (respuesta.isError()) {
                vista.getjLabelFichero().setText(respuesta.getMensaje());
            }
            variables = respuesta.getDatos();
            vista.getjLabelTotalVariables().setText(String.valueOf(variables.size()));
            DefaultTableModel model = (DefaultTableModel) vista.getTblDatos().getModel();
            variables.forEach(var -> {
                model.addRow(new Object[]{var.getNombre(), var.getTipoDato(), var.getDescripcion(), var.getDimensiones(),
                    var.getGrupo(), var.getForma(), var.getUnidades()});
            });
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    /**
     * Muestra los valores de las variables del archivo
     */
    public void mostrarValores() {
        try {
            if (this.fila != null) {
                vista.getTxtAreaVal().setText(this.variables.get(this.fila).getValores());
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
                vista.getTxtAreaAtr().setText(this.variables.get(this.fila).getAtributos());
            } else {
                vista.getTxtAreaAtr().setText("Seleccione una fila");
            }
        } catch (Exception ex) {
            vista.getTxtAreaAtr().setText("error: " + ex.getMessage());
        }
    }
    
    public Integer getFila() {
        return fila;
    }

    public void setFila(Integer fila) {
        this.fila = fila;
    }
}
