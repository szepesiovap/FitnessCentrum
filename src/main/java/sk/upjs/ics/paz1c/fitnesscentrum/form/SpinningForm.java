package sk.upjs.ics.paz1c.fitnesscentrum.form;

import sk.upjs.ics.paz1c.fitnesscentrum.RezervaciaTableModel;
import sk.upjs.ics.paz1c.fitnesscentrum.entity.Spinning;

public class SpinningForm extends javax.swing.JDialog {

    /**
     * Creates new form SpinningForm
     */
    public SpinningForm(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
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

        rezervacieScrollPane = new javax.swing.JScrollPane();
        rezervacieTable = new javax.swing.JTable();
        spinningComboBox = new javax.swing.JComboBox<>();
        zobrazButton = new javax.swing.JButton();
        spinningLabel = new javax.swing.JLabel();
        spinningMenuBar = new javax.swing.JMenuBar();
        rezervujMenu = new javax.swing.JMenu();
        jednorazovyMenuItem = new javax.swing.JMenuItem();
        kartouMenuItem = new javax.swing.JMenuItem();
        pridajSpinningMenu = new javax.swing.JMenu();
        pridajInstruktoraMenu = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Rezervácie na spinning");

        rezervacieTable.setModel(new RezervaciaTableModel(null));
        rezervacieScrollPane.setViewportView(rezervacieTable);

        zobrazButton.setText("Zobraz");
        zobrazButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                zobrazButtonActionPerformed(evt);
            }
        });

        spinningLabel.setText("Spinning : ");

        rezervujMenu.setText("Rezervuj");

        jednorazovyMenuItem.setText("Jednorázový");
        rezervujMenu.add(jednorazovyMenuItem);

        kartouMenuItem.setText("Kartou");
        rezervujMenu.add(kartouMenuItem);

        spinningMenuBar.add(rezervujMenu);

        pridajSpinningMenu.setText("Pridaj spinning");
        pridajSpinningMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                pridajSpinningMenuMousePressed(evt);
            }
        });
        spinningMenuBar.add(pridajSpinningMenu);

        pridajInstruktoraMenu.setText("Pridaj inštruktora");
        pridajInstruktoraMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                pridajInstruktoraMenuMousePressed(evt);
            }
        });
        spinningMenuBar.add(pridajInstruktoraMenu);

        setJMenuBar(spinningMenuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(rezervacieScrollPane)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(spinningLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(spinningComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 412, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(zobrazButton, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(spinningComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(spinningLabel)
                    .addComponent(zobrazButton, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rezervacieScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 319, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void zobrazButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_zobrazButtonActionPerformed
        Spinning spinning = null;
        rezervacieTable.setModel(new RezervaciaTableModel(spinning));
    }//GEN-LAST:event_zobrazButtonActionPerformed

    private void pridajSpinningMenuMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pridajSpinningMenuMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_pridajSpinningMenuMousePressed

    private void pridajInstruktoraMenuMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pridajInstruktoraMenuMousePressed
        new PridajInstruktoraForm(this, true).setVisible(true);
    }//GEN-LAST:event_pridajInstruktoraMenuMousePressed

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
            java.util.logging.Logger.getLogger(SpinningForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SpinningForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SpinningForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SpinningForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                SpinningForm dialog = new SpinningForm(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem jednorazovyMenuItem;
    private javax.swing.JMenuItem kartouMenuItem;
    private javax.swing.JMenu pridajInstruktoraMenu;
    private javax.swing.JMenu pridajSpinningMenu;
    private javax.swing.JScrollPane rezervacieScrollPane;
    private javax.swing.JTable rezervacieTable;
    private javax.swing.JMenu rezervujMenu;
    private javax.swing.JComboBox<Spinning> spinningComboBox;
    private javax.swing.JLabel spinningLabel;
    private javax.swing.JMenuBar spinningMenuBar;
    private javax.swing.JButton zobrazButton;
    // End of variables declaration//GEN-END:variables
}
