package sk.upjs.ics.paz1c.fitnesscentrum.form;

import javax.swing.JOptionPane;
import sk.upjs.ics.paz1c.fitnesscentrum.DaoFactory;
import sk.upjs.ics.paz1c.fitnesscentrum.entity.Recepcny;

public class PrihlasovanieForm extends javax.swing.JFrame {

    /**
     * Creates new form PrihlasovanieForm
     */
    public PrihlasovanieForm() {
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

        jFrame1 = new javax.swing.JFrame();
        loginTextField = new javax.swing.JTextField();
        loginLabel = new javax.swing.JLabel();
        hesloLabel = new javax.swing.JLabel();
        prihlasitButton = new javax.swing.JButton();
        hesloPasswordField = new javax.swing.JPasswordField();
        prihlasovanieMenuBar = new javax.swing.JMenuBar();
        novyRecepcny = new javax.swing.JMenu();
        zmenaUdajovRecepcny = new javax.swing.JMenu();

        javax.swing.GroupLayout jFrame1Layout = new javax.swing.GroupLayout(jFrame1.getContentPane());
        jFrame1.getContentPane().setLayout(jFrame1Layout);
        jFrame1Layout.setHorizontalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jFrame1Layout.setVerticalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("User Login");
        setName("prihlasenieFrame"); // NOI18N

        loginTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginTextFieldActionPerformed(evt);
            }
        });

        loginLabel.setText("login:");

        hesloLabel.setText("heslo:");

        prihlasitButton.setText("Prihlásiť");
        prihlasitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                prihlasitButtonActionPerformed(evt);
            }
        });

        hesloPasswordField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hesloPasswordFieldActionPerformed(evt);
            }
        });

        novyRecepcny.setText("Nový");
        novyRecepcny.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                novyRecepcnyMousePressed(evt);
            }
        });
        novyRecepcny.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                novyRecepcnyActionPerformed(evt);
            }
        });
        prihlasovanieMenuBar.add(novyRecepcny);

        zmenaUdajovRecepcny.setText("Zmena hesla");
        zmenaUdajovRecepcny.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                zmenaUdajovRecepcnyMousePressed(evt);
            }
        });
        prihlasovanieMenuBar.add(zmenaUdajovRecepcny);

        setJMenuBar(prihlasovanieMenuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(loginLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(hesloLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(loginTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
                    .addComponent(hesloPasswordField))
                .addGap(18, 18, 18)
                .addComponent(prihlasitButton)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(loginLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(loginTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(hesloLabel)
                    .addComponent(hesloPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(prihlasitButton))
                .addContainerGap(32, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void loginTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_loginTextFieldActionPerformed

    private void prihlasitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_prihlasitButtonActionPerformed
        String heslo = hesloPasswordField.getText();
        String login = loginTextField.getText();

        Recepcny recepcny = DaoFactory.INSTANCE.getRecepcnyDao().dajRecepcneho(login);
        // funkcne prihlasovanie s databazou
        /*if (recepcny != null && login.equals(recepcny.getLogin())) {
            String hashovaneHeslo = Hashovanie.zahesuj(recepcny.getSalt(), hesloPasswordField.getText());
            if (hashovaneHeslo.equals(recepcny.getHeslo())) {
                new HlavneOknoForm().setVisible(true);
                this.dispose();
                return;
            } else {
                JOptionPane.showMessageDialog(this, "Nesprávne heslo");
            }
        }else{
            JOptionPane.showMessageDialog(this, "Recepčný s daným loginom neexistuje");
        }*/
        
        //docasne!!!!!!!
        if ((recepcny != null) || (1 == 1)) {
            new HlavneOknoForm().setVisible(true);
            this.dispose();
        } else {
            JOptionPane.showMessageDialog(this, "Nespravne prihlasovacie udaje");
        }
    }//GEN-LAST:event_prihlasitButtonActionPerformed

    private void hesloPasswordFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hesloPasswordFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_hesloPasswordFieldActionPerformed

    private void novyRecepcnyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_novyRecepcnyActionPerformed
        new NovyRecepcnyForm(this, true).setVisible(true);
    }//GEN-LAST:event_novyRecepcnyActionPerformed

    private void novyRecepcnyMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_novyRecepcnyMousePressed
        new OverenieHeslaForm(this, true).setVisible(true);
    }//GEN-LAST:event_novyRecepcnyMousePressed

    private void zmenaUdajovRecepcnyMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_zmenaUdajovRecepcnyMousePressed
        new ZmenaHeslaRecepcnehoForm(this, true).setVisible(true);
    }//GEN-LAST:event_zmenaUdajovRecepcnyMousePressed

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
            java.util.logging.Logger.getLogger(PrihlasovanieForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PrihlasovanieForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PrihlasovanieForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PrihlasovanieForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PrihlasovanieForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel hesloLabel;
    private javax.swing.JPasswordField hesloPasswordField;
    private javax.swing.JFrame jFrame1;
    private javax.swing.JLabel loginLabel;
    private javax.swing.JTextField loginTextField;
    private javax.swing.JMenu novyRecepcny;
    private javax.swing.JButton prihlasitButton;
    private javax.swing.JMenuBar prihlasovanieMenuBar;
    private javax.swing.JMenu zmenaUdajovRecepcny;
    // End of variables declaration//GEN-END:variables
}
