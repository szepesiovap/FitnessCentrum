package sk.upjs.ics.paz1c.fitnesscentrum.form;

import javax.swing.JOptionPane;
import sk.upjs.ics.paz1c.fitnesscentrum.ObjectFactory;
import sk.upjs.ics.paz1c.fitnesscentrum.model.ZakaznikTableModel;
import sk.upjs.ics.paz1c.fitnesscentrum.dao.ZakaznikDao;
import sk.upjs.ics.paz1c.fitnesscentrum.entity.Zakaznik;

public final class ZoznamForm extends javax.swing.JFrame {

    private static HlavneOknoForm hlavneOkno;
    private final ZakaznikDao zakaznikDao = ObjectFactory.INSTANCE.getZakaznikDao();
    private static final int ID_COLUMN = 5;

    /**
     * Creates new form ZoznamForm
     *
     * @param hlavneOkno
     */
    public ZoznamForm(HlavneOknoForm hlavneOkno) {
        ZoznamForm.hlavneOkno = hlavneOkno;
        hlavneOkno.setEnabled(false);
        initComponents();
        aktualizovatZoznamZakaznikov();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        zoznamZakaznikovScrollPane = new javax.swing.JScrollPane();
        zoznamZakaznikovTable = new javax.swing.JTable();
        zmazatButton = new javax.swing.JButton();
        hladatPodlaMenaLabel = new javax.swing.JLabel();
        hladatPodlaMenaTextField = new javax.swing.JTextField();
        hladatButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Zoznam Zákazníkov");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        zoznamZakaznikovTable.setModel(new ZakaznikTableModel(""));
        zoznamZakaznikovScrollPane.setViewportView(zoznamZakaznikovTable);

        zmazatButton.setText("Zmazať");
        zmazatButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                zmazatButtonActionPerformed(evt);
            }
        });

        hladatPodlaMenaLabel.setText("Hľadať podľa mena: ");

        hladatButton.setText("Hľadať");
        hladatButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hladatButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(hladatPodlaMenaLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(hladatPodlaMenaTextField)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(hladatButton, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(zmazatButton, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addComponent(zoznamZakaznikovScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 773, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(hladatPodlaMenaLabel)
                            .addComponent(hladatButton)
                            .addComponent(zmazatButton))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(hladatPodlaMenaTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)))
                .addComponent(zoznamZakaznikovScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 408, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        hlavneOkno.aktualizovatZoznamPritomnych();
        hlavneOkno.setEnabled(true);
    }//GEN-LAST:event_formWindowClosed

    private void zmazatButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_zmazatButtonActionPerformed
        try {
            Long idZakaznika = (Long) zoznamZakaznikovTable.getModel().getValueAt(this.zoznamZakaznikovTable.getSelectedRow(), ID_COLUMN);
            Zakaznik zakaznik = zakaznikDao.dajZakaznikaSId(idZakaznika);
            if (!zakaznik.isPritomny()) {
                new ZmazatZakaznikaForm(this, true, zakaznik).setVisible(true);
                aktualizovatZoznamZakaznikov();
            } else {
                JOptionPane.showMessageDialog(this, "Nemožno vymazať prítomného zákazníka!");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Vyber zákazníka na odchod!");
        }
    }//GEN-LAST:event_zmazatButtonActionPerformed

    private void hladatButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hladatButtonActionPerformed
        zoznamZakaznikovTable.setModel(new ZakaznikTableModel(hladatPodlaMenaTextField.getText()));
        aktualizovatZoznamZakaznikov();
    }//GEN-LAST:event_hladatButtonActionPerformed

    public void aktualizovatZoznamZakaznikov() {
        ZakaznikTableModel model = (ZakaznikTableModel) zoznamZakaznikovTable.getModel();
        model.aktualizovat();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton hladatButton;
    private javax.swing.JLabel hladatPodlaMenaLabel;
    private javax.swing.JTextField hladatPodlaMenaTextField;
    private javax.swing.JButton zmazatButton;
    private javax.swing.JScrollPane zoznamZakaznikovScrollPane;
    private javax.swing.JTable zoznamZakaznikovTable;
    // End of variables declaration//GEN-END:variables
}
