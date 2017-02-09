package sk.upjs.ics.paz1c.fitnesscentrum.form;

import javax.swing.JOptionPane;
import sk.upjs.ics.paz1c.fitnesscentrum.ObjectFactory;
import sk.upjs.ics.paz1c.fitnesscentrum.entity.Cvicenie;
import sk.upjs.ics.paz1c.fitnesscentrum.manager.SpinningManager;
import sk.upjs.ics.paz1c.fitnesscentrum.manager.ZakaznikManager;
import sk.upjs.ics.paz1c.fitnesscentrum.entity.Spinning;
import sk.upjs.ics.paz1c.fitnesscentrum.entity.Zakaznik;
import sk.upjs.ics.paz1c.fitnesscentrum.exception.NedostatocnyKreditException;
import sk.upjs.ics.paz1c.fitnesscentrum.exception.NeexistujuciZakaznikException;
import sk.upjs.ics.paz1c.fitnesscentrum.manager.CvicenieManager;

public class RezervaciaPermanentkouForm extends javax.swing.JDialog {

    private final ZakaznikManager zakaznikManager = ObjectFactory.INSTANCE.getZakaznikManager();
    private final CvicenieManager cvicenieManager = ObjectFactory.INSTANCE.getCvicenieManager();
    private Zakaznik zakaznik;
    private final Cvicenie cvicenie;

    /**
     * Creates new form RezervujPermanentkouForm
     *
     * @param parent
     * @param modal
     * @param spinning
     */
    public RezervaciaPermanentkouForm(java.awt.Dialog parent, boolean modal, Cvicenie cvicenie) {
        super(parent, modal);
        this.cvicenie = cvicenie;
        initComponents();
        zobrazSpinningLabel.setText(cvicenie.toString());
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
        cisloPermanentkyTextField = new javax.swing.JTextField();
        menoLabel = new javax.swing.JLabel();
        cisloPermanentkyLabel = new javax.swing.JLabel();
        kreditLabel = new javax.swing.JLabel();
        nacitatButton = new javax.swing.JButton();
        zobrazMenoLabel = new javax.swing.JLabel();
        zobrazCisloPermanentkyLabel = new javax.swing.JLabel();
        zobrazKreditLabel = new javax.swing.JLabel();
        rezervovatButton = new javax.swing.JButton();
        spinningLabel = new javax.swing.JLabel();
        zobrazSpinningLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Rezervácia permanentkou");
        setResizable(false);

        zadajCisloLabel.setText("Číslo permanentky: ");

        menoLabel.setText("Meno: ");

        cisloPermanentkyLabel.setText("Číslo permanentky: ");

        kreditLabel.setText("Kredit: ");

        nacitatButton.setText("Načítať");
        nacitatButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nacitatButtonActionPerformed(evt);
            }
        });

        rezervovatButton.setText("Rezervovať");
        rezervovatButton.setEnabled(false);
        rezervovatButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rezervovatButtonActionPerformed(evt);
            }
        });

        spinningLabel.setText("Cvičenie:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(kreditLabel)
                    .addComponent(cisloPermanentkyLabel)
                    .addComponent(menoLabel)
                    .addComponent(zadajCisloLabel)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(spinningLabel)
                        .addGap(8, 8, 8)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(zobrazMenoLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(zobrazCisloPermanentkyLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(zobrazKreditLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(zobrazSpinningLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cisloPermanentkyTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(nacitatButton, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rezervovatButton, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(spinningLabel)
                    .addComponent(zobrazSpinningLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(zadajCisloLabel))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(cisloPermanentkyTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(menoLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(zobrazMenoLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cisloPermanentkyLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(zobrazCisloPermanentkyLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(kreditLabel)
                    .addComponent(zobrazKreditLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(55, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(nacitatButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(rezervovatButton, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(56, 56, 56))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void nacitatButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nacitatButtonActionPerformed
        try {
            zakaznik = zakaznikManager.dajZakaznikaSCislomPermanentky(cisloPermanentkyTextField.getText());
            odblokovatRezervovanie();
        } catch (NeexistujuciZakaznikException e) {
            zablokovatRezervovanie();
            JOptionPane.showMessageDialog(this, "Neplatné číslo permanentky!");
        }
    }//GEN-LAST:event_nacitatButtonActionPerformed

    private void rezervovatButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rezervovatButtonActionPerformed
        try {
            cvicenieManager.rezervovatCvicenieKartou(cvicenie, zakaznik);
            dispose();
        } catch (NedostatocnyKreditException e) {
            JOptionPane.showMessageDialog(this, "Nedostatočný kredit!");
        }
    }//GEN-LAST:event_rezervovatButtonActionPerformed

    private void odblokovatRezervovanie() {
        rezervovatButton.setEnabled(true);
        zobrazMenoLabel.setText(zakaznik.getMeno());
        zobrazKreditLabel.setText("" + zakaznik.getKredit());
        zobrazCisloPermanentkyLabel.setText(zakaznik.getCisloPermanentky());
    }

    private void zablokovatRezervovanie() {
        rezervovatButton.setEnabled(false);
        zobrazMenoLabel.setText("");
        zobrazKreditLabel.setText("");
        zobrazCisloPermanentkyLabel.setText("");
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel cisloPermanentkyLabel;
    private javax.swing.JTextField cisloPermanentkyTextField;
    private javax.swing.JLabel kreditLabel;
    private javax.swing.JLabel menoLabel;
    private javax.swing.JButton nacitatButton;
    private javax.swing.JButton rezervovatButton;
    private javax.swing.JLabel spinningLabel;
    private javax.swing.JLabel zadajCisloLabel;
    private javax.swing.JLabel zobrazCisloPermanentkyLabel;
    private javax.swing.JLabel zobrazKreditLabel;
    private javax.swing.JLabel zobrazMenoLabel;
    private javax.swing.JLabel zobrazSpinningLabel;
    // End of variables declaration//GEN-END:variables
}
