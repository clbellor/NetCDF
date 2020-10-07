
package presentacion;

import java.awt.Color;
import java.awt.Component;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import ucar.ma2.DataType;
import ucar.nc2.Attribute;
import ucar.nc2.Group;
import ucar.nc2.NetcdfFile;
import ucar.nc2.Variable;


public class Vista extends javax.swing.JFrame {

    private Controlador controlador;
    private final Modelo modelo;
    File fichero= null;

    public Vista(Modelo modelo) { 
        this.modelo = modelo;
        initComponents();
        jLabelFichero.setOpaque(true);
        //titulo e icono aplicacion
        ImageIcon img = new ImageIcon(this.getClass().getResource("/imagenes/logo.png"));
        this.setIconImage(img.getImage());     
        this.setTitle("NetCDF / Informatica 1 / Taller 2");
    }
    
    public Controlador getControl() {
        if(controlador == null){
            controlador = new Controlador(this);
        }
        return controlador;
    }
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jLabelFichero = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabelTotalVariables = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItemAbrir = new javax.swing.JMenuItem();
        jMenuItemGuardar = new javax.swing.JMenuItem();
        jMenuItemCerrar = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jTable1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Name", "Data Type ", "Descripction", "Dimenions", "Group", "Shape", "Units"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Mostar Atributos");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabelFichero.setText("C://");

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("ATRIBUTOS GENERALES DEL ARCHIVO NETCDF ");

        jLabel2.setText("Ubicacion : ");

        jLabel3.setText("Total Variables : ");

        jLabelTotalVariables.setText("-");

        jButton2.setBackground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Mostar Imagen");

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane2.setViewportView(jTextArea1);

        jMenu1.setText("Archivo");

        jMenuItemAbrir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/abrir.jpg"))); // NOI18N
        jMenuItemAbrir.setText("Abrir");
        jMenuItemAbrir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemAbrirActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItemAbrir);

        jMenuItemGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/guardar.png"))); // NOI18N
        jMenuItemGuardar.setText("Guardar");
        jMenuItemGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemGuardarActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItemGuardar);

        jMenuItemCerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/cerrar.png"))); // NOI18N
        jMenuItemCerrar.setText("Cerrar");
        jMenuItemCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemCerrarActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItemCerrar);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 583, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelFichero, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelTotalVariables, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jScrollPane2)
                    .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelFichero)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabelTotalVariables))
                .addGap(8, 8, 8)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2)
                .addContainerGap(55, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItemCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemCerrarActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jMenuItemCerrarActionPerformed

    private void jMenuItemAbrirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemAbrirActionPerformed
        // TODO add your handling code here:
        JFileChooser fileChooser = new JFileChooser();
        Component areaTexto = null;
        
        int seleccion = fileChooser.showOpenDialog(areaTexto);
        if (seleccion == JFileChooser.APPROVE_OPTION)
        {
            fichero = fileChooser.getSelectedFile();
            jLabelFichero.setBackground(Color.LIGHT_GRAY);
            jLabelFichero.setText(""+fichero);   

            // Aquí debemos abrir y leer el fichero.
            NetcdfFile ncdf = null;
            
            try {
                ncdf = NetcdfFile.open(fichero.toString());
            } catch (IOException ex){
                jLabelFichero.setBackground(Color.red);
                jLabelFichero.setText("DOCUMENTO NO VALIDO");
            }
          
            List<Variable> vars = ncdf.getVariables();
            System.out.println("Ubicacion archivo :"+ncdf.getLocation());
            System.out.println("Total de variables "+vars.size());
            jLabelTotalVariables.setText(""+vars.size());
            int j=0;
            for(Variable var: vars){
                jTable1.setValueAt(var.getFullName(), j, 0);
                jTable1.setValueAt(var.getDataType().name(), j, 1);
                jTable1.setValueAt(var.getDescription(), j, 2);
                jTable1.setValueAt(var.getDimensionsString(), j, 3);
                List<Group> groups=ncdf.getRootGroup().getGroups();
                for(Group group : groups){
                jTable1.setValueAt(group.getNameAndAttributes(), j, 4);
                }
                int [] size = var.getShape();
                    for(int i=0; i<size.length;++i){
                        if (i<=0) {
                           jTable1.setValueAt(""+size[i], j, 5); 
                        }
                        if (i>0) {
                           jTable1.setValueAt(""+size[i-1]+","+size[i], j, 5); 
                        }
                    }
                jTable1.setValueAt(var.getUnitsString(), j, 6);
                j++;
                
                //para mostarr en consola 
                System.out.print("Nombre Variable: " + var.getFullName() + 
                             " , Tipo Dato: " + var.getDataType().name() + 
                             ", Dimensiones: " + var.getDimensionsString() + 
                             ", Tamaño:");
                int [] size1 = var.getShape();
                    for(int i=0; i<size1.length;++i){
                    System.out.print(" " +size[i]);
                }
            System.out.print(",Descripcion: "+var.getDescription());
            System.out.print(", Unidades : "+var.getUnitsString());
            System.out.println(")");
        }
        }
    }//GEN-LAST:event_jMenuItemAbrirActionPerformed

    private void jMenuItemGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemGuardarActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jMenuItemGuardarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // Aquí debemos abrir y leer el fichero.
        NetcdfFile ncdf = null;
        String fichero1 = jLabelFichero.getText();
        
        if(fichero1=="C://"||fichero1=="DOCUMENTO NO VALIDO"){
                jTextArea1.setText("...");
        }else{
            try {
                ncdf = NetcdfFile.open(fichero1);
                jTextArea1.setText("Ubicacion: "+fichero1+"\n");
            } catch (IOException ex) {
                    Logger.getLogger(Vista.class.getName()).log(Level.SEVERE, null, ex);
                }
        List<Variable> vars = ncdf.getVariables();
        for( Variable var: vars){          
            List<Attribute> attrs = var.getAttributes();
            jTextArea1.append("Nombre Variable: " + var.getFullName()+"\n");
            jTextArea1.append("Total de atributos :"+attrs.size()+"\n");
            for (Attribute attr: attrs){
                jTextArea1.append("  Nombre atributo: " + attr.getFullName()+"\n"+"   Tipo: " + attr.getDataType().name()+"\n"+"   Valor numerico :"+attr.getNumericValue()+"\n"+"   Valor cadena :"+attr.getStringValue()+"\n");
            }                                        
        }
    }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
            System.out.println("Columna: "+jTable1.getSelectedColumn());
            System.out.println("Fila : "+jTable1.getSelectedRow());
    }//GEN-LAST:event_jTable1MouseClicked
      

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton jButton1;
    public javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    public javax.swing.JLabel jLabelFichero;
    public javax.swing.JLabel jLabelTotalVariables;
    public javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    public javax.swing.JMenuItem jMenuItemAbrir;
    public javax.swing.JMenuItem jMenuItemCerrar;
    public javax.swing.JMenuItem jMenuItemGuardar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    public javax.swing.JTable jTable1;
    public javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables

    public Modelo getModelo() {
        return modelo;
    }
}
