package sk.upjs.ics.paz1c.fitnesscentrum.form;

import javax.swing.JOptionPane;
import org.springframework.dao.DuplicateKeyException;
import sk.upjs.ics.paz1c.fitnesscentrum.ObjectFactory;
import sk.upjs.ics.paz1c.fitnesscentrum.manager.ZakaznikManager;
import sk.upjs.ics.paz1c.fitnesscentrum.model.KreditComboBoxModel;
import sk.upjs.ics.paz1c.fitnesscentrum.entity.Kredit;
import sk.upjs.ics.paz1c.fitnesscentrum.entity.Zakaznik;

public class NovyZakaznikForm3 extends javax.swing.JFrame {

    private final ZakaznikManager zakaznikManager = ObjectFactory.INSTANCE.getZakaznikManager();
    private static HlavneOknoForm hlavneOkno;

    /**
     * Creates new form NovyZakaznikForm
     *
     * @param hlavneOkno
     */
    public NovyZakaznikForm3(HlavneOknoForm hlavneOkno) {
        NovyZakaznikForm3.hlavneOkno = hlavneOkno;
        hlavneOkno.setEnabled(false);
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

        menoZakaznikaTextField = new javax.swing.JTextField();
        menoZakaznikaLabel = new javax.swing.JLabel();
        ulozitButton = new javax.swing.JButton();
        zrusitButton = new javax.swing.JButton();
        cisloKartyLabel = new javax.swing.JLabel();
        cisloKartyTextField = new javax.swing.JTextField();
        kreditLabel = new javax.swing.JLabel();
        kreditComboBox = new javax.swing.JComboBox<>();
        permanentkaCheckBox = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Nový zákazník");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        menoZakaznikaLabel.setText("Meno: ");

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

        cisloKartyLabel.setText("Číslo karty: ");

        cisloKartyTextField.setEnabled(false);

        kreditLabel.setText("Kredit: ");

        kreditComboBox.setModel(new KreditComboBoxModel());
        kreditComboBox.setEnabled(false);

        permanentkaCheckBox.setText("Permanentka");
        permanentkaCheckBox.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                permanentkaCheckBoxMousePressed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(ulozitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 128, Short.MAX_VALUE)
                        .addComponent(zrusitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(kreditLabel, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(cisloKartyLabel, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(menoZakaznikaLabel, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(34, 34, 34)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(kreditComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(menoZakaznikaTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE)
                            .addComponent(cisloKartyTextField))))
                .addGap(24, 24, 24))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(permanentkaCheckBox)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(menoZakaznikaLabel)
                    .addComponent(menoZakaznikaTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(permanentkaCheckBox)
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cisloKartyLabel)
                    .addComponent(cisloKartyTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(kreditLabel)
                    .addComponent(kreditComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(zrusitButton)
                    .addComponent(ulozitButton))
                .addGap(27, 27, 27))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void ulozitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ulozitButtonActionPerformed
        Zakaznik zakaznik = new Zakaznik();

        if (permanentkaCheckBox.isSelected()) {
            zakaznik.setCisloPermanentky(cisloKartyTextField.getText());
            zakaznik.setKredit(((Kredit) kreditComboBox.getSelectedItem()).getCena());
        }
        try {
            if ("".equals(menoZakaznikaTextField.getText())) {
                JOptionPane.showMessageDialog(this, "Zadajte meno zákazníka!");
            } else {
                zakaznik.setMeno(menoZakaznikaTextField.getText());
                zakaznikManager.pridajZakaznika(zakaznik);
                JOptionPane.showMessageDialog(this, "Zákazník" + zakaznik.getMeno() + " bol uložený!");
                this.dispose();
                return;
            }
            hlavneOkno.aktualizovatZoznamPritomnych();
            this.dispose();
            hlavneOkno.setVisible(true);

        } catch (DuplicateKeyException e) {
            JOptionPane.showMessageDialog(this, "Číslo karty už je priradené inému zákazníkovi!");
            return;
        }


    }//GEN-LAST:event_ulozitButtonActionPerformed

    private void zrusitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_zrusitButtonActionPerformed
        this.dispose();
    }//GEN-LAST:event_zrusitButtonActionPerformed

    private void permanentkaCheckBoxMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_permanentkaCheckBoxMousePressed
        if (permanentkaCheckBox.isSelected()) {
            cisloKartyTextField.setEnabled(false);
            kreditComboBox.setEnabled(false);
        } else {
            cisloKartyTextField.setEnabled(true);
            kreditComboBox.setEnabled(true);
        }
    }//GEN-LAST:event_permanentkaCheckBoxMousePressed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        hlavneOkno.setEnabled(true);
    }//GEN-LAST:event_formWindowClosed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel cisloKartyLabel;
    private javax.swing.JTextField cisloKartyTextField;
    private javax.swing.JComboBox<Kredit> kreditComboBox;
    private javax.swing.JLabel kreditLabel;
    private javax.swing.JLabel menoZakaznikaLabel;
    private javax.swing.JTextField menoZakaznikaTextField;
    private javax.swing.JCheckBox permanentkaCheckBox;
    private javax.swing.JButton ulozitButton;
    private javax.swing.JButton zrusitButton;
    // End of variables declaration//GEN-END:variables
}
