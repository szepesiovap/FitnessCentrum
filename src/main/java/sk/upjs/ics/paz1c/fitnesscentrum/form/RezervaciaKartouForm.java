package sk.upjs.ics.paz1c.fitnesscentrum.form;

import javax.swing.JOptionPane;
import sk.upjs.ics.paz1c.fitnesscentrum.ObjectFactory;
import sk.upjs.ics.paz1c.fitnesscentrum.manager.SpinningManager;
import sk.upjs.ics.paz1c.fitnesscentrum.manager.ZakaznikManager;
import sk.upjs.ics.paz1c.fitnesscentrum.entity.Spinning;
import sk.upjs.ics.paz1c.fitnesscentrum.entity.Zakaznik;
import sk.upjs.ics.paz1c.fitnesscentrum.exception.NedostatocnyKreditException;
import sk.upjs.ics.paz1c.fitnesscentrum.exception.NeexistujuciZakaznikException;

public class RezervaciaKartouForm extends javax.swing.JDialog {

    private final ZakaznikManager zakaznikManager = ObjectFactory.INSTANCE.getZakaznikManager();
    private final SpinningManager spinningManager = ObjectFactory.INSTANCE.getSpinningManager();
    private Zakaznik zakaznik;
    private final Spinning spinning;

    /**
     * Creates new form RezervujKartouForm
     *
     * @param parent
     * @param modal
     * @param spinning
     */
    public RezervaciaKartouForm(java.awt.Dialog parent, boolean modal, Spinning spinning) {
        super(parent, modal);
        this.spinning = spinning;
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
        nacitatButton = new javax.swing.JButton();
        zobrazMenoLabel = new javax.swing.JLabel();
        zobrazCisloKartyLabel = new javax.swing.JLabel();
        zobrazKreditLabel = new javax.swing.JLabel();
        rezervovatButton = new javax.swing.JButton();
        spinningLabel = new javax.swing.JLabel();
        zobrazSpinningLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Rezervácia kartou");

        zadajCisloLabel.setText("Číslo karty: ");

        menoLabel.setText("Meno: ");

        cisloKartyLabel.setText("Číslo karty: ");

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

        spinningLabel.setText("Spinning: ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(rezervovatButton, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(kreditLabel)
                            .addComponent(cisloKartyLabel)
                            .addComponent(menoLabel)
                            .addComponent(zadajCisloLabel)
                            .addComponent(spinningLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(zobrazMenoLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 247, Short.MAX_VALUE)
                                .addComponent(zobrazCisloKartyLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(zobrazKreditLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(zobrazSpinningLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(cisloKartyTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(nacitatButton, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(23, Short.MAX_VALUE))
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
                .addComponent(nacitatButton)
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
                .addComponent(rezervovatButton)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void nacitatButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nacitatButtonActionPerformed
        try {
            zakaznik = zakaznikManager.dajZakaznikaSCislomPermanentky(cisloKartyTextField.getText());
            odblokovatRezervovanie();
        } catch (NeexistujuciZakaznikException e) {
            zablokovatRezervovanie();
            JOptionPane.showMessageDialog(this, "Neplatné číslo permanentky!");
        }
    }//GEN-LAST:event_nacitatButtonActionPerformed

    private void rezervovatButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rezervovatButtonActionPerformed
        try {
            spinningManager.rezervovatSpinningKartou(spinning, zakaznik);
            dispose();
        } catch (NedostatocnyKreditException e) {
            JOptionPane.showMessageDialog(this, "Nedostatočný kredit!");
        }
    }//GEN-LAST:event_rezervovatButtonActionPerformed

    private void odblokovatRezervovanie() {
        rezervovatButton.setEnabled(true);
        zobrazMenoLabel.setText(zakaznik.getMeno());
        zobrazKreditLabel.setText("" + zakaznik.getKredit());
        zobrazCisloKartyLabel.setText(zakaznik.getCisloPermanentky());
    }

    private void zablokovatRezervovanie() {
        rezervovatButton.setEnabled(false);
        zobrazMenoLabel.setText("");
        zobrazKreditLabel.setText("");
        zobrazCisloKartyLabel.setText("");
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel cisloKartyLabel;
    private javax.swing.JTextField cisloKartyTextField;
    private javax.swing.JLabel kreditLabel;
    private javax.swing.JLabel menoLabel;
    private javax.swing.JButton nacitatButton;
    private javax.swing.JButton rezervovatButton;
    private javax.swing.JLabel spinningLabel;
    private javax.swing.JLabel zadajCisloLabel;
    private javax.swing.JLabel zobrazCisloKartyLabel;
    private javax.swing.JLabel zobrazKreditLabel;
    private javax.swing.JLabel zobrazMenoLabel;
    private javax.swing.JLabel zobrazSpinningLabel;
    // End of variables declaration//GEN-END:variables
}
