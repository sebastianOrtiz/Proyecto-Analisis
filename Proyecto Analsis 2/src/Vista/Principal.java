/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import App5.Escena;
import Modelo.InsertSort;
import Modelo.MetodosVarios;
import Modelo.QuickSort;
import java.awt.Color;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Andres
 */
public class Principal extends javax.swing.JFrame {

    MetodosVarios metodos = new MetodosVarios();
    Escena e = new Escena();
    QuickSort q = new QuickSort();
    InsertSort insertSort = new InsertSort();
    int[] arreglo = {5, 7, 8, 5, 4, 1, 3, 6, 8, 10, 35};
    Panelprueba p;
    int lineaActual = -1;
    int indexEjecucion = 0;
    DefaultTableModel modelTableExcecution;
    DefaultListModel<String> modelListVariables;
    private int algoritmo = 0;

    /**
     * Creates new form Principal
     */
    public Principal() {
        initComponents();
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        inicializarTableModel();
        inicializarListVariableModel();

    }

    private LinkedList<String> listarVariablesRegistro(HashMap<String, String> variables) {
        LinkedList<String> vars = new LinkedList<>();
        for (String llave : variables.keySet()) {
            vars.add(llave + " = " + variables.get(llave));
        }
        return vars;
    }

    private void inicializarListVariableModel() {
        this.modelListVariables = new DefaultListModel<>();
        this.listVariables.setModel(modelListVariables);
    }

    private void inicializarTableModel() {
        modelTableExcecution = new DefaultTableModel();
        modelTableExcecution.addColumn("Lineas ejecutadas");
        modelTableExcecution.addColumn("Identificador ambiente");
        modelTableExcecution.addColumn("Algoritmo");
        this.tableEjecucion.setModel(modelTableExcecution);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btncargar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        listaalgoritmos = new javax.swing.JList();
        btnEjecutarAlg = new javax.swing.JButton();
        scrollTableExcecution = new javax.swing.JScrollPane();
        tableEjecucion = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        listVariables = new javax.swing.JList();
        txtEntradaDAtos = new javax.swing.JTextField();
        btnEntradaDatos = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        panelprueba1 = new Vista.Panelprueba();
        btnQuickSort = new javax.swing.JButton();
        btnInserSort = new javax.swing.JButton();
        btnHeapSort = new javax.swing.JButton();
        btnMultMatrix = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btncargar.setText("Cargar algoritmo");
        btncargar.setEnabled(false);
        btncargar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncargarActionPerformed(evt);
            }
        });

        listaalgoritmos.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        listaalgoritmos.setEnabled(false);
        jScrollPane1.setViewportView(listaalgoritmos);

        btnEjecutarAlg.setText("Siguiente linea");
        btnEjecutarAlg.setEnabled(false);
        btnEjecutarAlg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEjecutarAlgActionPerformed(evt);
            }
        });

        tableEjecucion.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "lineas ejecutadas", "id ambiente", "algoritmo"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableEjecucion.setEnabled(false);
        tableEjecucion.getTableHeader().setReorderingAllowed(false);
        scrollTableExcecution.setViewportView(tableEjecucion);

        listVariables.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        listVariables.setEnabled(false);
        jScrollPane2.setViewportView(listVariables);

        txtEntradaDAtos.setEnabled(false);

        btnEntradaDatos.setText("Procesar entrada de datos");
        btnEntradaDatos.setEnabled(false);
        btnEntradaDatos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEntradaDatosActionPerformed(evt);
            }
        });

        panelprueba1.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout panelprueba1Layout = new javax.swing.GroupLayout(panelprueba1);
        panelprueba1.setLayout(panelprueba1Layout);
        panelprueba1Layout.setHorizontalGroup(
            panelprueba1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1815, Short.MAX_VALUE)
        );
        panelprueba1Layout.setVerticalGroup(
            panelprueba1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 335, Short.MAX_VALUE)
        );

        jScrollPane3.setViewportView(panelprueba1);

        btnQuickSort.setText("QuickSort");
        btnQuickSort.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuickSortActionPerformed(evt);
            }
        });

        btnInserSort.setText("InsertSort");
        btnInserSort.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInserSortActionPerformed(evt);
            }
        });

        btnHeapSort.setText("HeapSort");
        btnHeapSort.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHeapSortActionPerformed(evt);
            }
        });

        btnMultMatrix.setText("Multiplicacion de matrices");
        btnMultMatrix.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMultMatrixActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(btnQuickSort)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnInserSort)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnHeapSort)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnMultMatrix)
                        .addGap(76, 76, 76)
                        .addComponent(txtEntradaDAtos, javax.swing.GroupLayout.PREFERRED_SIZE, 349, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEntradaDatos)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEjecutarAlg)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 99, Short.MAX_VALUE)
                        .addComponent(btncargar))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 528, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(scrollTableExcecution, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 339, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnQuickSort)
                    .addComponent(btnInserSort)
                    .addComponent(btnHeapSort)
                    .addComponent(btnMultMatrix)
                    .addComponent(txtEntradaDAtos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEntradaDatos)
                    .addComponent(btnEjecutarAlg)
                    .addComponent(btncargar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(scrollTableExcecution, javax.swing.GroupLayout.DEFAULT_SIZE, 457, Short.MAX_VALUE)
                    .addComponent(jScrollPane1)
                    .addComponent(jScrollPane2))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btncargarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncargarActionPerformed

        DefaultListModel modelo = new DefaultListModel();
        JFileChooser fc = new JFileChooser();
        int respuesta = fc.showOpenDialog(this);

        if (respuesta == JFileChooser.APPROVE_OPTION) {
            File a = fc.getSelectedFile();
            FileReader fr;
            try {
                fr = new FileReader(a);
                BufferedReader br = new BufferedReader(fr);
                String linea;
                while ((linea = br.readLine()) != null) {
                    modelo.addElement(linea);
                }
                listaalgoritmos.setModel(modelo);
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }//GEN-LAST:event_btncargarActionPerformed

    private void btnEjecutarAlgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEjecutarAlgActionPerformed
        if (this.algoritmo == 1) {
            if (indexEjecucion < q.getRegistroAmbientes().size()) {
                lineaActual = Integer.parseInt(q.getRegistroAmbientes().get(indexEjecucion).get(0).get("lineaSiguiente"));
                modelTableExcecution.insertRow(0, new Object[]{indexEjecucion, q.getRegistroAmbientes().get(indexEjecucion).get(0).get("idMio"), q.getRegistroAmbientes().get(indexEjecucion).get(0).get("nombre")});
                LinkedList<String> variables = this.listarVariablesRegistro(q.getRegistroAmbientes().get(indexEjecucion).get(1));
                panelprueba1.setAmbiente(q.getRegistroAmbientes().get(indexEjecucion).get(0).get("idMio"));
                panelprueba1.repaint();
                modelListVariables.removeAllElements();
                for (String variable : variables) {
                    modelListVariables.addElement(variable);
                }
                this.tableEjecucion.setRowSelectionInterval(0, 0);

                indexEjecucion++;
                this.listaalgoritmos.setSelectedIndex(lineaActual);

            }
        } else if (this.algoritmo == 2) {
            if (indexEjecucion < this.insertSort.getRegistroAmbientes().size()) {
                lineaActual = Integer.parseInt(this.insertSort.getRegistroAmbientes().get(indexEjecucion).get(0).get("lineaSiguiente"));
                modelTableExcecution.insertRow(0, new Object[]{indexEjecucion, this.insertSort.getRegistroAmbientes().get(indexEjecucion).get(0).get("idMio"), this.insertSort.getRegistroAmbientes().get(indexEjecucion).get(0).get("nombre")});
                LinkedList<String> variables = this.listarVariablesRegistro(this.insertSort.getRegistroAmbientes().get(indexEjecucion).get(1));
                panelprueba1.setAmbiente(this.insertSort.getRegistroAmbientes().get(indexEjecucion).get(0).get("idMio"));
                panelprueba1.repaint();
                modelListVariables.removeAllElements();
                for (String variable : variables) {
                    modelListVariables.addElement(variable);
                }
                this.tableEjecucion.setRowSelectionInterval(0, 0);

                indexEjecucion++;
                this.listaalgoritmos.setSelectedIndex(lineaActual);

            }
        }


    }//GEN-LAST:event_btnEjecutarAlgActionPerformed

    private void btnEntradaDatosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEntradaDatosActionPerformed
        if (!txtEntradaDAtos.getText().equalsIgnoreCase("")) {
            if (this.algoritmo == 1) {
                String[] stringArray = this.txtEntradaDAtos.getText().split(",");
                this.arreglo = new int[stringArray.length];
                for (int i = 0; i < stringArray.length; i++) {
                    arreglo[i] = Integer.parseInt(stringArray[i]);
                }
                q.QuickSort(arreglo);

                this.listaalgoritmos.setSelectedIndex(lineaActual);

                panelprueba1.setarbol(e.Escena(metodos.generarNodos(q.getRegistroAmbientes())));
                this.listVariables.setEnabled(true);
                this.btnEjecutarAlg.setEnabled(true);

            } else if (this.algoritmo == 2) {
                String[] stringArray = this.txtEntradaDAtos.getText().split(",");
                this.arreglo = new int[stringArray.length];
                for (int i = 0; i < stringArray.length; i++) {
                    arreglo[i] = Integer.parseInt(stringArray[i]);
                }
                this.insertSort.Sort(arreglo);

                this.listaalgoritmos.setSelectedIndex(lineaActual);

                panelprueba1.setarbol(e.Escena(metodos.generarNodos(this.insertSort.getRegistroAmbientes())));
                this.listVariables.setEnabled(true);
                this.btnEjecutarAlg.setEnabled(true);
            }

        }
    }//GEN-LAST:event_btnEntradaDatosActionPerformed

    private void btnMultMatrixActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMultMatrixActionPerformed
        seleccionarAlgoritmo("Algoritmos/Multiplicaionmatrices");
        this.algoritmo = 4;
    }//GEN-LAST:event_btnMultMatrixActionPerformed

    private void btnQuickSortActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuickSortActionPerformed
        seleccionarAlgoritmo("Algoritmos/QuickSort");
        this.algoritmo = 1;
    }//GEN-LAST:event_btnQuickSortActionPerformed

    private void btnInserSortActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInserSortActionPerformed
        seleccionarAlgoritmo("Algoritmos/InsertSort");
        this.algoritmo = 2;
    }//GEN-LAST:event_btnInserSortActionPerformed

    private void btnHeapSortActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHeapSortActionPerformed
        seleccionarAlgoritmo("Algoritmos/HeapSort");
        this.algoritmo = 3;
    }//GEN-LAST:event_btnHeapSortActionPerformed

    private void seleccionarAlgoritmo(String url) {
        DefaultListModel modelo = new DefaultListModel();
        File a = new File(url);
        FileReader fr;
        try {
            fr = new FileReader(a);
            BufferedReader br = new BufferedReader(fr);
            String linea;
            while ((linea = br.readLine()) != null) {
                modelo.addElement(linea);
            }
            this.listaalgoritmos.setModel(modelo);
            this.listaalgoritmos.setEnabled(true);
            this.txtEntradaDAtos.setEnabled(true);
            this.btnEntradaDatos.setEnabled(true);
            lineaActual = -1;
            indexEjecucion = 0;
            this.borrarTabla();
            this.listVariables.removeAll();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void borrarTabla() {
        int rows = this.modelTableExcecution.getRowCount();
        this.modelTableExcecution.setRowCount(0);
//        for (int i = 0; i < rows; i++) {
//            this.modelTableExcecution.removeRow(i);
//
//        }
//        for (int b : this.modelTableExcecution.setro) {
//            
//        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEjecutarAlg;
    private javax.swing.JButton btnEntradaDatos;
    private javax.swing.JButton btnHeapSort;
    private javax.swing.JButton btnInserSort;
    private javax.swing.JButton btnMultMatrix;
    private javax.swing.JButton btnQuickSort;
    private javax.swing.JButton btncargar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JList listVariables;
    private javax.swing.JList listaalgoritmos;
    private Vista.Panelprueba panelprueba1;
    private javax.swing.JScrollPane scrollTableExcecution;
    private javax.swing.JTable tableEjecucion;
    private javax.swing.JTextField txtEntradaDAtos;
    // End of variables declaration//GEN-END:variables
}
