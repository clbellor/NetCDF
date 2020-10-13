package presentacion;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Arrays;
import java.util.List;
import javax.swing.JFileChooser;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import logica.Respuesta;
import ucar.ma2.Array;
import ucar.nc2.Variable;

/**
 * clase controlador vista principal
 */
public class Controlador implements ActionListener, ListSelectionListener {

    private final Vista vista;

    private List<Variable> variables;
    File fichero = null;
    Integer fila = null;

    public Controlador(Vista ventana) {
        vista = ventana;
        iniciarEventos();
    }

    public void iniciarEventos() {
        vista.getBtnAttr().addActionListener(this);
        vista.getBtnValue().addActionListener(this);
        vista.getTblDatos().getSelectionModel().addListSelectionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "Mostar Atributos":
                mostrarAtributos();
                break;
            case "Mostar Valores":
                mostrarValores();
                break;
            default:
                throw new AssertionError();
        }
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
                model.addRow(new Object[]{var.getFullName(), var.getDataType(), var.getDescription(), var.getDimensions(),
                    var.getFullName(), Arrays.toString(var.getShape()), var.getUnitsString()});
            });
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

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

    public void mostrarAtributos() {
        try {
            if (this.fila != null) {
                this.variables.get(this.fila).attributes().forEach(attr -> {
                    vista.getTxtAreaAtr().append("  Nombre atributo: " + attr.getFullName() + "\n" + "   Tipo: " + attr.getDataType().name() + "\n" + "   Valor numerico :" + attr.getNumericValue() + "\n" + "   Valor cadena :" + attr.getStringValue() + "\n");
                });
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
