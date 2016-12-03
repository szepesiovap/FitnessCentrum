package sk.upjs.ics.paz1c.fitnesscentrum.form;

import java.time.LocalDateTime;
import javax.swing.JOptionPane;
import org.springframework.dao.EmptyResultDataAccessException;
import sk.upjs.ics.paz1c.fitnesscentrum.DaoFactory;
import sk.upjs.ics.paz1c.fitnesscentrum.dao.RezervaciaDao;
import sk.upjs.ics.paz1c.fitnesscentrum.dao.SpinningDao;
import sk.upjs.ics.paz1c.fitnesscentrum.dao.ZakaznikDao;
import sk.upjs.ics.paz1c.fitnesscentrum.entity.Rezervacia;
import sk.upjs.ics.paz1c.fitnesscentrum.entity.Spinning;
import sk.upjs.ics.paz1c.fitnesscentrum.entity.Zakaznik;

public class RezervaciaKartouForm extends javax.swing.JDialog {

    private static final double SUMA = 3.2;
    private static Spinning spinning;
    private final RezervaciaDao rezervaciaDao;
    private final ZakaznikDao zakaznikDao;
    private final SpinningDao spinningDao;
    private Zakaznik zakaznik;

    /**
     * Creates new form RezervujKartouForm
     */
    public RezervaciaKartouForm(java.awt.Dialog parent, boolean modal, Spinning spinning) {
        super(parent, modal);
        this.spinning = spinning;
        spinningDao = DaoFactory.INSTANCE.getSpinningDao();
        zakaznikDao = DaoFactory.INSTANCE.getZakaznikDao();
        rezervaciaDao = DaoFactory.INSTANCE.getRezervaciaDao();
        initComponents();
        zobrazSpinningLabel.setText(spinning.toString());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        zadajCisloLabel = new javax.swing.JLabel();
        cisloKartyTextField = new javax.swing.JTextField();
        menoLabel = new javax.swing.JLabel();
        cisloKartyLabel = new javax.swing.JLabel();
        kreditLabel = new javax.swing.JLabel();
        nacitajButton = new javax.swing.JButton();
        zobrazMenoLabel = new javax.swing.JLabel();
        zobrazCisloKartyLabel = new javax.swing.JLabel();
        zobrazKreditLabel = new javax.swing.JLabel();
        rezervujButton = new javax.swing.JButton();
        spinningLabel = new javax.swing.JLabel();
        zobrazSpinningLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        zadajCisloLabel.setText("Zadaj číslo: ");

        menoLabel.setText("Meno: ");

        cisloKartyLabel.setText("Číslo karty: ");

        kreditLabel.setText("Kredit: ");

        nacitajButton.setText("Načítaj");
        nacitajButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nacitajButtonActionPerformed(evt);
            }
        });

        rezervujButton.setText("Rezervuj");
        rezervujButton.setEnabled(false);
        rezervujButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rezervujButtonActionPerformed(evt);
            }
        });

        spinningLabel.setText("Spinning: ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(rezervujButton, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(kreditLabel)
                            .addComponent(cisloKartyLabel)
                            .addComponent(menoLabel)
                            .addComponent(zadajCisloLabel)
                            .addComponent(spinningLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cisloKartyTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 185, Short.MAX_VALUE)
                            .addComponent(zobrazMenoLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(zobrazCisloKartyLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(zobrazKreditLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(nacitajButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(zobrazSpinningLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(spinningLabel)
                            .addComponent(zobrazSpinningLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(zadajCisloLabel))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(cisloKartyTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nacitajButton)
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(menoLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(zobrazMenoLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cisloKartyLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(zobrazCisloKartyLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(kreditLabel)
                    .addComponent(zobrazKreditLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rezervujButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void nacitajButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nacitajButtonActionPerformed
        try {
            zakaznik = zakaznikDao.dajZakaznikaSCislomPermanentky(cisloKartyTextField.getText());
        } catch (EmptyResultDataAccessException e) {
            zakaznik = null;
        }
        if (zakaznik == null) {
            rezervujButton.setEnabled(false);
            zobrazMenoLabel.setText("");
            zobrazKreditLabel.setText("");
            zobrazCisloKartyLabel.setText("");
            JOptionPane.showMessageDialog(null, "Neplatné číslo permanentky!");
        } else {
            rezervujButton.setEnabled(true);
            zobrazMenoLabel.setText(zakaznik.getMeno());
            zobrazKreditLabel.setText("" + zakaznik.getKredit());
            zobrazCisloKartyLabel.setText(zakaznik.getCisloPermanentky());
        }
    }//GEN-LAST:event_nacitajButtonActionPerformed

    private void rezervujButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rezervujButtonActionPerformed
        if (zakaznik.getKredit() <= SUMA) {
            JOptionPane.showMessageDialog(this, "Nedostatočný kredit!");
        } else {
            Rezervacia rezervacia = new Rezervacia();
            rezervacia.setSpinning(spinning);
            rezervacia.setZakaznik(zakaznik);
            rezervacia.setCasRezervacie(LocalDateTime.now());
            spinningDao.rezervujSpinning(spinning);
            zakaznikDao.stiahniKreditZakaznikovi(zakaznik, SUMA);
            rezervaciaDao.pridajRezervaciu(rezervacia);
            dispose();
        }
    }//GEN-LAST:event_rezervujButtonActionPerformed

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
            java.util.logging.Logger.getLogger(RezervaciaKartouForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RezervaciaKartouForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RezervaciaKartouForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RezervaciaKartouForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                RezervaciaKartouForm dialog = new RezervaciaKartouForm(new javax.swing.JDialog(), true, spinning);
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
    private javax.swing.JLabel kreditLabel;
    private javax.swing.JLabel menoLabel;
    private javax.swing.JButton nacitajButton;
    private javax.swing.JButton rezervujButton;
    private javax.swing.JLabel spinningLabel;
    private javax.swing.JLabel zadajCisloLabel;
    private javax.swing.JLabel zobrazCisloKartyLabel;
    private javax.swing.JLabel zobrazKreditLabel;
    private javax.swing.JLabel zobrazMenoLabel;
    private javax.swing.JLabel zobrazSpinningLabel;
    // End of variables declaration//GEN-END:variables
}
