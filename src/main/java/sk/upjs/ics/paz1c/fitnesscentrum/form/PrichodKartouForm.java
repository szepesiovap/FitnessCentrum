package sk.upjs.ics.paz1c.fitnesscentrum.form;

import javax.swing.JOptionPane;
import org.springframework.dao.EmptyResultDataAccessException;
import sk.upjs.ics.paz1c.fitnesscentrum.DaoFactory;
import sk.upjs.ics.paz1c.fitnesscentrum.KlucComboBoxModel;
import sk.upjs.ics.paz1c.fitnesscentrum.dao.KlucDao;
import sk.upjs.ics.paz1c.fitnesscentrum.dao.ZakaznikDao;
import sk.upjs.ics.paz1c.fitnesscentrum.entity.Kluc;
import sk.upjs.ics.paz1c.fitnesscentrum.entity.Zakaznik;

public class PrichodKartouForm extends javax.swing.JDialog {

    //TODO spravit nacitavanie cien 
    private static final double SUMA = 2;
    private final KlucDao klucDao;
    private final ZakaznikDao zakaznikDao;
    private Zakaznik zakaznik;

    /**
     * Creates new form PrichodKartouForm
     */
    public PrichodKartouForm(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        zakaznikDao = DaoFactory.INSTANCE.getZakaznikDao();
        klucDao = DaoFactory.INSTANCE.getKlucDao();
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
        zobrazMenoLabel = new javax.swing.JLabel();
        klucLabel = new javax.swing.JLabel();
        klucComboBox = new javax.swing.JComboBox<>();
        prichodButton = new javax.swing.JButton();
        kreditLabel = new javax.swing.JLabel();
        cisloKartyLabel = new javax.swing.JLabel();
        zobrazCisloKartyLabel = new javax.swing.JLabel();
        zobrazKreditLabel = new javax.swing.JLabel();
        cisloKartyTextField = new javax.swing.JTextField();
        zadajCisloLabel = new javax.swing.JLabel();
        nacitajButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        menoLabel.setText("Meno: ");

        klucLabel.setText("Kľúč: ");

        klucComboBox.setModel(new KlucComboBoxModel());
        klucComboBox.setEnabled(false);

        prichodButton.setText("Príchod");
        prichodButton.setEnabled(false);
        prichodButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                prichodButtonActionPerformed(evt);
            }
        });

        kreditLabel.setText("Kredit: ");

        cisloKartyLabel.setText("Číslo karty: ");

        zadajCisloLabel.setText("Zadaj číslo: ");

        nacitajButton.setText("Načítaj");
        nacitajButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nacitajButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(nacitajButton, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(klucLabel)
                            .addComponent(kreditLabel)
                            .addComponent(menoLabel)
                            .addComponent(cisloKartyLabel)
                            .addComponent(zadajCisloLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(zobrazMenoLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(klucComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(prichodButton, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(zobrazCisloKartyLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(zobrazKreditLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cisloKartyTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE))))
                .addContainerGap(28, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cisloKartyTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(zadajCisloLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nacitajButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(menoLabel, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(zobrazMenoLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(zobrazCisloKartyLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cisloKartyLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(kreditLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(zobrazKreditLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(klucLabel)
                    .addComponent(klucComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(prichodButton))
                .addGap(28, 28, 28))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void prichodButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_prichodButtonActionPerformed
        if (zakaznik.isPritomny()) {
            JOptionPane.showMessageDialog(this, "Zákazník je už prítomný!");
        } else if (zakaznik.getKredit() <= SUMA) {
            JOptionPane.showMessageDialog(this, "Nedostatočný kredit!");
        } else {
            Kluc kluc = (Kluc) klucComboBox.getSelectedItem();
            zakaznikDao.stiahniKreditZakaznikovi(zakaznik, SUMA);
            zakaznikDao.prichod(zakaznik, kluc);
            klucDao.priradZakaznika(kluc, zakaznik);
            dispose();
        }

    }//GEN-LAST:event_prichodButtonActionPerformed

    private void nacitajButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nacitajButtonActionPerformed
        try {
            zakaznik = zakaznikDao.dajZakaznikaSCislomPermanentky(cisloKartyTextField.getText());
        } catch (EmptyResultDataAccessException e) {
            zakaznik = null;
        }
        if (zakaznik == null) {
            klucComboBox.setEnabled(false);
            prichodButton.setEnabled(false);
            zobrazMenoLabel.setText("");
            zobrazKreditLabel.setText("");
            zobrazCisloKartyLabel.setText("");
            JOptionPane.showMessageDialog(null, "Neplatné číslo permanentky!");
        } else {
            klucComboBox.setEnabled(true);
            prichodButton.setEnabled(true);
            zobrazMenoLabel.setText(zakaznik.getMeno());
            zobrazKreditLabel.setText("" + zakaznik.getKredit());
            zobrazCisloKartyLabel.setText(zakaznik.getCisloPermanentky());
        }
    }//GEN-LAST:event_nacitajButtonActionPerformed

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
            java.util.logging.Logger.getLogger(PrichodKartouForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PrichodKartouForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PrichodKartouForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PrichodKartouForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                PrichodKartouForm dialog = new PrichodKartouForm(new javax.swing.JFrame(), true);
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
    private javax.swing.JLabel cisloKartyLabel;
    private javax.swing.JTextField cisloKartyTextField;
    private javax.swing.JComboBox<Kluc> klucComboBox;
    private javax.swing.JLabel klucLabel;
    private javax.swing.JLabel kreditLabel;
    private javax.swing.JLabel menoLabel;
    private javax.swing.JButton nacitajButton;
    private javax.swing.JButton prichodButton;
    private javax.swing.JLabel zadajCisloLabel;
    private javax.swing.JLabel zobrazCisloKartyLabel;
    private javax.swing.JLabel zobrazKreditLabel;
    private javax.swing.JLabel zobrazMenoLabel;
    // End of variables declaration//GEN-END:variables
}
