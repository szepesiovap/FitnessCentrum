package sk.upjs.ics.paz1c.fitnesscentrum.form;

import java.util.UUID;
import javax.swing.JOptionPane;
import org.springframework.dao.DuplicateKeyException;
import sk.upjs.ics.paz1c.fitnesscentrum.DaoFactory;
import sk.upjs.ics.paz1c.fitnesscentrum.Hashovanie;
import sk.upjs.ics.paz1c.fitnesscentrum.entity.Recepcny;

public class NovyRecepcnyForm extends javax.swing.JFrame {

    /**
     * Creates new form NovyRecepcnyForm
     */
    public NovyRecepcnyForm() {
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

        menoLabel = new javax.swing.JLabel();
        loginLabel = new javax.swing.JLabel();
        hesloLabel = new javax.swing.JLabel();
        zrusitButton = new javax.swing.JButton();
        ulozButton = new javax.swing.JButton();
        menoTextField = new javax.swing.JTextField();
        loginTextField = new javax.swing.JTextField();
        hesloPasswordField = new javax.swing.JPasswordField();
        hesloZnovaPasswordField = new javax.swing.JPasswordField();
        hesloZnovaLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Nový recepčný");
        setResizable(false);

        menoLabel.setText("Meno:");

        loginLabel.setText("Login:");

        hesloLabel.setText("Heslo:");

        zrusitButton.setText("Zrušiť");
        zrusitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                zrusitButtonActionPerformed(evt);
            }
        });

        ulozButton.setText("Ulož");
        ulozButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ulozButtonActionPerformed(evt);
            }
        });

        menoTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menoTextFieldActionPerformed(evt);
            }
        });

        hesloZnovaLabel.setText("Heslo znova:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addComponent(ulozButton, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(zrusitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(58, 58, 58))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(hesloLabel)
                    .addComponent(hesloZnovaLabel)
                    .addComponent(loginLabel)
                    .addComponent(menoLabel))
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(menoTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(loginTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(hesloPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(hesloZnovaPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(27, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(menoTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(menoLabel))
                        .addGap(20, 20, 20)
                        .addComponent(loginLabel))
                    .addComponent(loginTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(hesloLabel)
                    .addComponent(hesloPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(hesloZnovaPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(hesloZnovaLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ulozButton)
                    .addComponent(zrusitButton))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void menoTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menoTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_menoTextFieldActionPerformed

    private void ulozButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ulozButtonActionPerformed
        
        Recepcny recepcny = new Recepcny();
        
        recepcny.setMeno(menoTextField.getText());
        recepcny.setLogin(loginTextField.getText());
        if (hesloPasswordField.getText().equals(hesloZnovaPasswordField.getText())) {
            String salt = UUID.randomUUID().toString();
            recepcny.setSalt(salt);
            recepcny.setHeslo(Hashovanie.zahesuj(salt, hesloPasswordField.getText()));
        } else {
            JOptionPane.showMessageDialog(this, "Heslo sa nezhoduje");
            return;
        }

        try {
            DaoFactory.INSTANCE.getRecepcnyDao().pridajRecepcneho(recepcny);
        } catch (DuplicateKeyException e) {
            JOptionPane.showMessageDialog(this, "Zvolený login je už použitý");
            return;
        }
        
        this.dispose();
    }//GEN-LAST:event_ulozButtonActionPerformed

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
            java.util.logging.Logger.getLogger(NovyRecepcnyForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NovyRecepcnyForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NovyRecepcnyForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NovyRecepcnyForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NovyRecepcnyForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel hesloLabel;
    private javax.swing.JPasswordField hesloPasswordField;
    private javax.swing.JLabel hesloZnovaLabel;
    private javax.swing.JPasswordField hesloZnovaPasswordField;
    private javax.swing.JLabel loginLabel;
    private javax.swing.JTextField loginTextField;
    private javax.swing.JLabel menoLabel;
    private javax.swing.JTextField menoTextField;
    private javax.swing.JButton ulozButton;
    private javax.swing.JButton zrusitButton;
    // End of variables declaration//GEN-END:variables
}
