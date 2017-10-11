/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package herramientas;

import javax.swing.table.DefaultTableModel;

/**
 *
 * @author varga
 */
public class MatrizVisual extends javax.swing.JFrame {
    
    private double[][] matriz;
    //private double eficaciaGeneral;
    /**
     * Creates new form MatrizVisual
     */
    public MatrizVisual(double[][] matriz) {
        initComponents();
        this.matriz=matriz;
        //this.eficaciaGeneral= eficaciaGeneral;
       
    }
    
    public void mostrarMatriz()
    {
        DefaultTableModel modelo=(DefaultTableModel) TablaMatriz.getModel(); 
        
        modelo.setRowCount(this.matriz.length);//filas 
        modelo.setColumnCount(this.matriz[0].length);//columnas
        
        String vector[] = new String[this.matriz[0].length];
        
        for (int i = 0; i < this.matriz[0].length-1; i++) {
            vector[i] = ""+i;
        }
        vector[this.matriz.length]="porcentaje";
        modelo.setColumnIdentifiers(vector);
        for (int i = 0; i < this.matriz.length ; i++) {
            for (int j = 0; j < this.matriz[i].length; j++) {
                TablaMatriz.setValueAt(this.matriz[i][j], i, j);
            }
        }
        
        setVisible(true);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        TablaMatriz = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        TablaMatriz.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(TablaMatriz);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 112, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TablaMatriz;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
