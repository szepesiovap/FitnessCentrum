package sk.upjs.ics.paz1c.fitnesscentrum.form;

import javax.swing.JOptionPane;
import org.springframework.dao.DuplicateKeyException;
import sk.upjs.ics.paz1c.fitnesscentrum.DaoFactory;
import sk.upjs.ics.paz1c.fitnesscentrum.dao.KreditDao;
import sk.upjs.ics.paz1c.fitnesscentrum.entity.Kredit;

public class PridatKreditForm extends javax.swing.JDialog {

    private Kredit kredit;
    private final KreditDao kreditDao;

    /**
     * Creates new form PridatKreditForm
     */
    public PridatKreditForm(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        kreditDao = DaoFactory.INSTANCE.getKreditDao();
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

        cenaLabel = new javax.swing.JLabel();
        cenaTextField = new javax.swing.JTextField();
        ulozitButton = new javax.swing.JButton();
        zrusitButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Nový kredit");

        cenaLabel.setText("Cena:");

        ulozitButton.setText("Uložiť");
        ulozitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ulozitButtonActionPerformed(evt);
            }
        });

        zrusitButton.setText("Zrušiť");
        zrusitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                zrusitButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(cenaLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cenaTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(ulozitButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(zrusitButton)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cenaLabel)
                    .addComponent(cenaTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ulozitButton)
                    .addComponent(zrusitButton))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ulozitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ulozitButtonActionPerformed

        kredit = new Kredit();

        if (!("").equals(cenaTextField.getText())) {
            kredit.setCena(Double.parseDouble(cenaTextField.getText()));
            kredit.setNazov(cenaTextField.getText() + " eur");
        } else {
            JOptionPane.showMessageDialog(this, "Zadaj cenu");
        }

        try {
            kreditDao.pridajKredit(kredit);
        } catch (DuplicateKeyException e) {
            JOptionPane.showMessageDialog(this, "Zvolený kredit už existuje.");
            return;
        }

        this.dispose();

    }//GEN-LAST:event_ulozitButtonActionPerformed

    private void zrusitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_zrusitButtonActionPerformed
        this.dispose();
    }//GEN-LAST:event_zrusitButtonActionPerformed

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
            java.util.logging.Logger.getLogger(PridatKreditForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PridatKreditForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PridatKreditForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PridatKreditForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                PridatKreditForm dialog = new PridatKreditForm(new javax.swing.JFrame(), true);
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
    private javax.swing.JLabel cenaLabel;
    private javax.swing.JTextField cenaTextField;
    private javax.swing.JButton ulozitButton;
    private javax.swing.JButton zrusitButton;
    // End of variables declaration//GEN-END:variables
}
