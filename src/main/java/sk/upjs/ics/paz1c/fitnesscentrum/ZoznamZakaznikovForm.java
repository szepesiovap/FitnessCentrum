/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.upjs.ics.paz1c.fitnesscentrum;

import sk.upjs.ics.paz1c.fitnesscentrum.dao.impl.MySQLZakaznikDao;

/**
 *
 * @author patka
 */
public class ZoznamZakaznikovForm extends javax.swing.JFrame {

     private ZakaznikTableModel zakaznikTableModel;
    /**
     * Creates new form ZoznamZakaznikovForm
     */
    public ZoznamZakaznikovForm() {
        zakaznikTableModel = new ZakaznikTableModel();
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tabbedPane = new javax.swing.JTabbedPane();
        pritomniScrollPane = new javax.swing.JScrollPane();
        pritomniTable = new javax.swing.JTable();
        zoznamZakaznikovScrollPane = new javax.swing.JScrollPane();
        zoznamZakaznikovTable = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pritomniTable.setModel(new PritomniZakazniciTableModel()
        );
        pritomniScrollPane.setViewportView(pritomniTable);

        tabbedPane.addTab("Pritomni", pritomniScrollPane);

        zoznamZakaznikovTable.setModel(new ZakaznikSPernamentkouTableModel());
        zoznamZakaznikovScrollPane.setViewportView(zoznamZakaznikovTable);

        tabbedPane.addTab("Zoznam", zoznamZakaznikovScrollPane);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tabbedPane, javax.swing.GroupLayout.DEFAULT_SIZE, 720, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tabbedPane, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 410, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(ZoznamZakaznikovForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ZoznamZakaznikovForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ZoznamZakaznikovForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ZoznamZakaznikovForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        MySQLZakaznikDao sql = new MySQLZakaznikDao();
        System.out.println(sql.dajVsetkychZakaznikovSPernamentkou());
              
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ZoznamZakaznikovForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane pritomniScrollPane;
    private javax.swing.JTable pritomniTable;
    private javax.swing.JTabbedPane tabbedPane;
    private javax.swing.JScrollPane zoznamZakaznikovScrollPane;
    private javax.swing.JTable zoznamZakaznikovTable;
    // End of variables declaration//GEN-END:variables
}
