package sk.upjs.ics.paz1c.fitnesscentrum.form;

import sk.upjs.ics.paz1c.fitnesscentrum.ObjectFactory;
import sk.upjs.ics.paz1c.fitnesscentrum.manager.ZakaznikManager;
import sk.upjs.ics.paz1c.fitnesscentrum.model.KlucComboBoxModel;
import sk.upjs.ics.paz1c.fitnesscentrum.entity.Kluc;
import sk.upjs.ics.paz1c.fitnesscentrum.entity.Zakaznik;

public class PotvrditPrichodZakaznikaForm extends javax.swing.JDialog {
    
    private final Zakaznik zakaznik;
    private final ZakaznikManager zakaznikManager = ObjectFactory.INSTANCE.getZakaznikManager();

    /**
     * Creates new form PrichodZakaznikaForm
     *
     * @param parent
     * @param modal
     * @param zakaznik
     */
    public PotvrditPrichodZakaznikaForm(java.awt.Dialog parent, boolean modal, Zakaznik zakaznik) {
        super(parent, modal);
        this.zakaznik = zakaznik;
        initComponents();
        zobrazMenoLabel.setText(zakaznik.getMeno());
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

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Príchod zákazníka");
        setResizable(false);

        menoLabel.setText("Meno: ");

        klucLabel.setText("Kľúč: ");

        klucComboBox.setModel(new KlucComboBoxModel());

        prichodButton.setText("Príchod");
        prichodButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                prichodButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(klucLabel)
                    .addComponent(menoLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(zobrazMenoLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(klucComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(prichodButton)
                        .addGap(0, 21, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(menoLabel)
                    .addComponent(zobrazMenoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(klucLabel)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(klucComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(prichodButton)))
                .addContainerGap(29, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void prichodButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_prichodButtonActionPerformed
        Kluc kluc = ((Kluc) klucComboBox.getSelectedItem());
        zakaznikManager.prichodZakaznika(zakaznik, kluc);
        dispose();
    }//GEN-LAST:event_prichodButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<Kluc> klucComboBox;
    private javax.swing.JLabel klucLabel;
    private javax.swing.JLabel menoLabel;
    private javax.swing.JButton prichodButton;
    private javax.swing.JLabel zobrazMenoLabel;
    // End of variables declaration//GEN-END:variables
}
