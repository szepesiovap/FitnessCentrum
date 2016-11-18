package sk.upjs.ics.paz1c.fitnesscentrum;

import javax.swing.JOptionPane;
import sk.upjs.ics.paz1c.fitnesscentrum.entity.Recepcny;

public class ZmenaUdajovRecepcnehoForm extends javax.swing.JFrame {

    private final String hesloRecepcneho;
    private final int idRecepcneho;
    
    /**
     * Creates new form ZmenaUdajovRecepcneho
     * @param idRecepcneho
     */
    public ZmenaUdajovRecepcnehoForm(int idRecepcneho) {
        initComponents();
        this.idRecepcneho = idRecepcneho;
        Recepcny recepcny = DaoFactory.INSTANCE.getRecepcnyDao().dajRecepcneho(this.idRecepcneho);
        hesloRecepcneho = recepcny.getHeslo();
        menoTextField.setText(recepcny.getMeno());
        loginTextField.setText(recepcny.getLogin());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        loginjLabel = new javax.swing.JLabel();
        menoLabel = new javax.swing.JLabel();
        stareHesloLabel = new javax.swing.JLabel();
        noveHesloLabel = new javax.swing.JLabel();
        noveHesloZnovaLabel = new javax.swing.JLabel();
        stareHesloPasswordField = new javax.swing.JPasswordField();
        noveHesloPasswordField = new javax.swing.JPasswordField();
        noveHesloZnovaPasswordField = new javax.swing.JPasswordField();
        menoTextField = new javax.swing.JTextField();
        loginTextField = new javax.swing.JTextField();
        ulozZmenyButton = new javax.swing.JButton();
        zrusitButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        loginjLabel.setText("Login:");

        menoLabel.setText("Meno:");

        stareHesloLabel.setText("Staré heslo:");

        noveHesloLabel.setText("Nové heslo:");

        noveHesloZnovaLabel.setText("Nové heslo znova:");

        ulozZmenyButton.setText("Ulož zmeny");
        ulozZmenyButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ulozZmenyButtonActionPerformed(evt);
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
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(noveHesloZnovaLabel)
                            .addComponent(stareHesloLabel)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(loginjLabel)
                                .addComponent(menoLabel))
                            .addComponent(noveHesloLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(noveHesloZnovaPasswordField)
                            .addComponent(noveHesloPasswordField, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(menoTextField, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(loginTextField, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 123, Short.MAX_VALUE)
                            .addComponent(stareHesloPasswordField)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(ulozZmenyButton)
                        .addGap(18, 18, 18)
                        .addComponent(zrusitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(54, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(menoLabel)
                    .addComponent(menoTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(loginjLabel)
                    .addComponent(loginTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(stareHesloLabel)
                    .addComponent(stareHesloPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(noveHesloLabel)
                    .addComponent(noveHesloPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(noveHesloZnovaLabel)
                    .addComponent(noveHesloZnovaPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ulozZmenyButton)
                    .addComponent(zrusitButton))
                .addGap(27, 27, 27))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ulozZmenyButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ulozZmenyButtonActionPerformed
        Recepcny recepcny = new Recepcny();
        recepcny.setMeno(menoTextField.getText());
        recepcny.setLogin(loginTextField.getText());
        if (stareHesloPasswordField.getText().equals(hesloRecepcneho)) {
            if (noveHesloPasswordField.getText().isEmpty() && noveHesloZnovaPasswordField.getText().isEmpty()) {
                recepcny.setHeslo(hesloRecepcneho);
            } else if (!noveHesloPasswordField.getText().isEmpty()
                    && noveHesloPasswordField.getText().equals(noveHesloZnovaPasswordField.getText())) {
                recepcny.setHeslo(noveHesloPasswordField.getText());
            } else {
                JOptionPane.showMessageDialog(null, "Nové heslá sa nezhodujú");
                return;
            }
        } else {
            JOptionPane.showMessageDialog(null, "Zadané staré heslo nie je správne");
            return;
        }

        recepcny.setId(this.idRecepcneho);
        DaoFactory.INSTANCE.getRecepcnyDao().updateRecepcneho(recepcny);
        this.dispose();
    }//GEN-LAST:event_ulozZmenyButtonActionPerformed

    private void zrusitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_zrusitButtonActionPerformed
        this.dispose();
    }//GEN-LAST:event_zrusitButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField loginTextField;
    private javax.swing.JLabel loginjLabel;
    private javax.swing.JLabel menoLabel;
    private javax.swing.JTextField menoTextField;
    private javax.swing.JLabel noveHesloLabel;
    private javax.swing.JPasswordField noveHesloPasswordField;
    private javax.swing.JLabel noveHesloZnovaLabel;
    private javax.swing.JPasswordField noveHesloZnovaPasswordField;
    private javax.swing.JLabel stareHesloLabel;
    private javax.swing.JPasswordField stareHesloPasswordField;
    private javax.swing.JButton ulozZmenyButton;
    private javax.swing.JButton zrusitButton;
    // End of variables declaration//GEN-END:variables
}
