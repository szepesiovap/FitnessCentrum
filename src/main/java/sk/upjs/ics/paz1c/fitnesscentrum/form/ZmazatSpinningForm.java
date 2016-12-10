package sk.upjs.ics.paz1c.fitnesscentrum.form;

import javax.swing.JOptionPane;
import sk.upjs.ics.paz1c.fitnesscentrum.ObjectFactory;
import sk.upjs.ics.paz1c.fitnesscentrum.FitnessManager;
import sk.upjs.ics.paz1c.fitnesscentrum.model.SpinningTableModel;
import sk.upjs.ics.paz1c.fitnesscentrum.entity.Spinning;

public class ZmazatSpinningForm extends javax.swing.JDialog {

    private static final int ID_COLUMN = 4;
    private final FitnessManager fitnessManager = ObjectFactory.INSTANCE.getFitnessManager();
    private Spinning spinning;

    /**
     * Creates new form ZrusSpinningForm
     *
     * @param parent
     * @param modal
     */
    public ZmazatSpinningForm(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    public ZmazatSpinningForm() {
        super(new javax.swing.JFrame(), true);
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

        zoznamSpinningovScrollPane = new javax.swing.JScrollPane();
        zoznamSpinningovTable = new javax.swing.JTable();
        zrusitSpinningButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Zrušiť spinning");

        zoznamSpinningovTable.setModel(new SpinningTableModel());
        zoznamSpinningovScrollPane.setViewportView(zoznamSpinningovTable);

        zrusitSpinningButton.setText("Zrušiť spinning");
        zrusitSpinningButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                zrusitSpinningButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(277, Short.MAX_VALUE)
                .addComponent(zrusitSpinningButton)
                .addContainerGap())
            .addComponent(zoznamSpinningovScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(zoznamSpinningovScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(zrusitSpinningButton)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void zrusitSpinningButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_zrusitSpinningButtonActionPerformed
        try {
            Long idSpinningu = (Long) zoznamSpinningovTable.getModel().getValueAt(this.zoznamSpinningovTable.getSelectedRow(), ID_COLUMN);
            spinning = fitnessManager.dajSpinningSId(idSpinningu);
        if (spinning.getKapacita() == spinning.getVolne()) {
            Object[] options = {"Zmazať", "Zrušiť"};
            if (JOptionPane.showOptionDialog(this, "Naozaj chcete zmazať spinning s instruktorom "
                    + spinning.getInstruktor() + ", ktorý sa má uskutočniť dňa "
                    + spinning.getDatum().toLocalDate() + " o "
                    + spinning.getDatum().toLocalTime() + "?",
                    "Zmazať spinning", JOptionPane.DEFAULT_OPTION,
                    JOptionPane.PLAIN_MESSAGE, null, options, options[0]) == JOptionPane.YES_OPTION) {

                fitnessManager.vymazSpinning(spinning);
                JOptionPane.showMessageDialog(this, "Spinning s instruktorom "
                        + spinning.getInstruktor() + " z dňa " + spinning.getDatum() + " bol zrušený!");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Nemožno vymazať spinning, na ktorý sú rezervácie! "
                    + "Najprv musíte zrušiť rezervácie!");
        }        } catch (ArrayIndexOutOfBoundsException e) {
            JOptionPane.showMessageDialog(this, "Nie je vybraný žiaden spinning!");
        }
        aktualizovatZoznamSpinningovTable();
    }//GEN-LAST:event_zrusitSpinningButtonActionPerformed

    private void aktualizovatZoznamSpinningovTable() {
        SpinningTableModel model = (SpinningTableModel) zoznamSpinningovTable.getModel();
        model.aktualizovat();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane zoznamSpinningovScrollPane;
    private javax.swing.JTable zoznamSpinningovTable;
    private javax.swing.JButton zrusitSpinningButton;
    // End of variables declaration//GEN-END:variables
}
