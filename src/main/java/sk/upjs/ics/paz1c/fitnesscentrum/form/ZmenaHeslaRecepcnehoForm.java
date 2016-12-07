package sk.upjs.ics.paz1c.fitnesscentrum.form;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import sk.upjs.ics.paz1c.fitnesscentrum.ObjectFactory;
import sk.upjs.ics.paz1c.fitnesscentrum.NeexistujuciRecepcnyException;
import sk.upjs.ics.paz1c.fitnesscentrum.NevalidnyVstupException;
import sk.upjs.ics.paz1c.fitnesscentrum.RecepcnyManager;

public class ZmenaHeslaRecepcnehoForm extends javax.swing.JDialog {

    private final RecepcnyManager recepcnyManager = ObjectFactory.INSTANCE.getRecepcnyManager();

    /**
     * Creates new form ZmenaHeslaRecepcnehoJDialog
     *
     * @param parent
     * @param modal
     */
    public ZmenaHeslaRecepcnehoForm(java.awt.Frame parent, boolean modal) {
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

        noveHesloZnovaLabel = new javax.swing.JLabel();
        stareHesloPasswordField = new javax.swing.JPasswordField();
        noveHesloPasswordField = new javax.swing.JPasswordField();
        noveHesloZnovaPasswordField = new javax.swing.JPasswordField();
        loginTextField = new javax.swing.JTextField();
        ulozitZmenyButton = new javax.swing.JButton();
        zrusitButton = new javax.swing.JButton();
        loginjLabel = new javax.swing.JLabel();
        stareHesloLabel = new javax.swing.JLabel();
        noveHesloLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Zmena hesla recepčného");

        noveHesloZnovaLabel.setText("Nové heslo znova:");

        ulozitZmenyButton.setText("Uložiť zmeny");
        ulozitZmenyButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ulozitZmenyButtonActionPerformed(evt);
            }
        });

        zrusitButton.setText("Zrušiť");
        zrusitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                zrusitButtonActionPerformed(evt);
            }
        });

        loginjLabel.setText("Login:");

        stareHesloLabel.setText("Staré heslo:");

        noveHesloLabel.setText("Nové heslo:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(stareHesloLabel)
                            .addComponent(noveHesloLabel))
                        .addGap(49, 49, 49)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(loginTextField)
                            .addComponent(stareHesloPasswordField)
                            .addComponent(noveHesloPasswordField)
                            .addComponent(noveHesloZnovaPasswordField)))
                    .addComponent(loginjLabel)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(noveHesloZnovaLabel)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addComponent(ulozitZmenyButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(33, 33, 33)
                        .addComponent(zrusitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(20, 20, 20))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(loginjLabel)
                    .addComponent(loginTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(stareHesloLabel)
                    .addComponent(stareHesloPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(noveHesloLabel)
                    .addComponent(noveHesloPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(noveHesloZnovaPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(noveHesloZnovaLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ulozitZmenyButton)
                    .addComponent(zrusitButton))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void ulozitZmenyButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ulozitZmenyButtonActionPerformed
        try {
            String login = loginTextField.getText();
            String heslo = stareHesloPasswordField.getText();
            String noveHeslo = noveHesloPasswordField.getText();
            String noveHesloZnova = noveHesloZnovaPasswordField.getText();

            recepcnyManager.zmenHesloRecepcneho(login, heslo, noveHeslo, noveHesloZnova);
            JOptionPane.showMessageDialog(this, "Heslo recepčného s loginom " + login + " bolo zmenené!");
            this.dispose();
        } catch (NevalidnyVstupException | NeexistujuciRecepcnyException e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_ulozitZmenyButtonActionPerformed

    private void zrusitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_zrusitButtonActionPerformed
        this.dispose();
    }//GEN-LAST:event_zrusitButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField loginTextField;
    private javax.swing.JLabel loginjLabel;
    private javax.swing.JLabel noveHesloLabel;
    private javax.swing.JPasswordField noveHesloPasswordField;
    private javax.swing.JLabel noveHesloZnovaLabel;
    private javax.swing.JPasswordField noveHesloZnovaPasswordField;
    private javax.swing.JLabel stareHesloLabel;
    private javax.swing.JPasswordField stareHesloPasswordField;
    private javax.swing.JButton ulozitZmenyButton;
    private javax.swing.JButton zrusitButton;
    // End of variables declaration//GEN-END:variables
}
