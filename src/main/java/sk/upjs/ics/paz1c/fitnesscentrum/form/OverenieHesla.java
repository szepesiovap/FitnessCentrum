package sk.upjs.ics.paz1c.fitnesscentrum.form;

import javax.swing.JOptionPane;
import sk.upjs.ics.paz1c.fitnesscentrum.DaoFactory;
import sk.upjs.ics.paz1c.fitnesscentrum.Hashovanie;
import sk.upjs.ics.paz1c.fitnesscentrum.entity.Recepcny;

public class OverenieHesla extends javax.swing.JFrame {

    /**
     * Creates new form OverenieHesla
     */
    public OverenieHesla() {
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

        hesloPasswordField = new javax.swing.JPasswordField();
        potvrdButton = new javax.swing.JButton();
        zrusitButton = new javax.swing.JButton();
        zadajteHesloLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        potvrdButton.setText("Potvrď");
        potvrdButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                potvrdButtonActionPerformed(evt);
            }
        });

        zrusitButton.setText("Zrušiť");
        zrusitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                zrusitButtonActionPerformed(evt);
            }
        });

        zadajteHesloLabel.setText("Zadajte heslo admina prosím!");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(zadajteHesloLabel)
                .addContainerGap(37, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(hesloPasswordField)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(potvrdButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(zrusitButton)))
                .addGap(24, 24, 24))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(zadajteHesloLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(hesloPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(potvrdButton)
                    .addComponent(zrusitButton))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void potvrdButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_potvrdButtonActionPerformed
        Recepcny recepcny = DaoFactory.INSTANCE.getRecepcnyDao().dajRecepcneho(0);
        String salt = recepcny.getSalt();
        String heslo = hesloPasswordField.getText();
        String hashHeslo = Hashovanie.zahesuj(salt, heslo);

        if (hashHeslo.equals(recepcny.getHeslo())) {
            new NovyRecepcnyForm().setVisible(true);
            this.dispose();
        } else {
            JOptionPane.showMessageDialog(null, "Zadané heslo nie je správne");
        }
    }//GEN-LAST:event_potvrdButtonActionPerformed

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
            java.util.logging.Logger.getLogger(OverenieHesla.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(OverenieHesla.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(OverenieHesla.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(OverenieHesla.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new OverenieHesla().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPasswordField hesloPasswordField;
    private javax.swing.JButton potvrdButton;
    private javax.swing.JLabel zadajteHesloLabel;
    private javax.swing.JButton zrusitButton;
    // End of variables declaration//GEN-END:variables
}