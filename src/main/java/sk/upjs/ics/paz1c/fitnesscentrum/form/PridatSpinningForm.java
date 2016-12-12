package sk.upjs.ics.paz1c.fitnesscentrum.form;

import java.time.LocalDateTime;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import sk.upjs.ics.paz1c.fitnesscentrum.ObjectFactory;
import sk.upjs.ics.paz1c.fitnesscentrum.manager.SpinningManager;
import sk.upjs.ics.paz1c.fitnesscentrum.model.InstruktorComboBoxModel;
import sk.upjs.ics.paz1c.fitnesscentrum.entity.Instruktor;
import sk.upjs.ics.paz1c.fitnesscentrum.entity.Spinning;

public class PridatSpinningForm extends javax.swing.JDialog {

    private final SpinningManager spinningManager = ObjectFactory.INSTANCE.getSpinningManager();
    private final String[] DNI = {"01", "02", "03", "04", "05", "06", "07", "08",
        "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20",
        "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"};

    private final String[] MESIACE = {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12"};

    private final String[] MINUTY = {"00", "15", "30", "45"};
    private final String[] HODINY = {"00", "01", "02", "03", "04", "05", "06", "07", "08", "09",
        "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23"};

    /**
     * Creates new form PridajSpinningForm
     *
     * @param parent
     * @param modal
     */
    public PridatSpinningForm(java.awt.Dialog parent, boolean modal) {
        super(parent, modal);
        initComponents();
        inicializovat();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        denComboBox = new javax.swing.JComboBox<>();
        mesiacComboBox = new javax.swing.JComboBox<>();
        rokTextField = new javax.swing.JTextField();
        datumLabel = new javax.swing.JLabel();
        casLabel = new javax.swing.JLabel();
        hodinaComboBox = new javax.swing.JComboBox<>();
        minutaComboBox = new javax.swing.JComboBox<>();
        instruktorLabel = new javax.swing.JLabel();
        instruktorComboBox = new javax.swing.JComboBox<>();
        zrusitButton = new javax.swing.JButton();
        pridatButton = new javax.swing.JButton();
        kapacitaLabel = new javax.swing.JLabel();
        kapacitaTextField = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Nový spinning");
        setResizable(false);

        rokTextField.setText("2016");

        datumLabel.setText("Dátum: ");

        casLabel.setText("Čas: ");

        instruktorLabel.setText("Inštruktor: ");

        instruktorComboBox.setModel(new InstruktorComboBoxModel());

        zrusitButton.setText("Zrušiť");
        zrusitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                zrusitButtonActionPerformed(evt);
            }
        });

        pridatButton.setText("Pridať");
        pridatButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pridatButtonActionPerformed(evt);
            }
        });

        kapacitaLabel.setText("Kapacita: ");

        kapacitaTextField.setText("20");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(casLabel, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(datumLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(hodinaComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(denComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(minutaComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(mesiacComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(rokTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(kapacitaLabel)
                            .addComponent(instruktorLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(instruktorComboBox, 0, 201, Short.MAX_VALUE)
                            .addComponent(kapacitaTextField))))
                .addContainerGap(57, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(pridatButton, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(zrusitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(denComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(mesiacComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rokTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(datumLabel))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(casLabel)
                    .addComponent(hodinaComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(minutaComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(instruktorLabel)
                    .addComponent(instruktorComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(kapacitaLabel)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(kapacitaTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(zrusitButton)
                            .addComponent(pridatButton))
                        .addGap(37, 37, 37))))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void zrusitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_zrusitButtonActionPerformed
        dispose();
    }//GEN-LAST:event_zrusitButtonActionPerformed

    private void pridatButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pridatButtonActionPerformed
        LocalDateTime datum = null;
        try {
            int den = Integer.parseInt((String) denComboBox.getSelectedItem());
            int hodina = Integer.parseInt((String) hodinaComboBox.getSelectedItem());
            int mesiac = Integer.parseInt((String) mesiacComboBox.getSelectedItem());
            int minuta = Integer.parseInt((String) minutaComboBox.getSelectedItem());
            int rok = Integer.parseInt(rokTextField.getText());
            datum = LocalDateTime.of(rok, mesiac, den, hodina, minuta);
            if (datum.isBefore(LocalDateTime.now())) {
                JOptionPane.showMessageDialog(this, "Nemožno naplánovať spinning so starším dátumom!");
            } else {
                Spinning spinning = new Spinning();
                spinning.setDatum(datum);
                spinning.setInstruktor((Instruktor) instruktorComboBox.getSelectedItem());
                spinning.setKapacita(Integer.parseInt((String) kapacitaTextField.getText()));
                spinning.setVolne(Integer.parseInt((String) kapacitaTextField.getText()));
                spinningManager.pridajSpinning(spinning);
                dispose();
            }

        } catch (NullPointerException e) {
            JOptionPane.showMessageDialog(this, "Nebol vybraný inštruktor!");
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Nesprávny formát!");
        }

    }//GEN-LAST:event_pridatButtonActionPerformed

    public void inicializovat() {
        denComboBox.setModel(new DefaultComboBoxModel<>(DNI));
        hodinaComboBox.setModel(new DefaultComboBoxModel<>(HODINY));
        mesiacComboBox.setModel(new DefaultComboBoxModel<>(MESIACE));
        minutaComboBox.setModel(new DefaultComboBoxModel<>(MINUTY));

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel casLabel;
    private javax.swing.JLabel datumLabel;
    private javax.swing.JComboBox<String> denComboBox;
    private javax.swing.JComboBox<String> hodinaComboBox;
    private javax.swing.JComboBox<Instruktor> instruktorComboBox;
    private javax.swing.JLabel instruktorLabel;
    private javax.swing.JLabel kapacitaLabel;
    private javax.swing.JTextField kapacitaTextField;
    private javax.swing.JComboBox<String> mesiacComboBox;
    private javax.swing.JComboBox<String> minutaComboBox;
    private javax.swing.JButton pridatButton;
    private javax.swing.JTextField rokTextField;
    private javax.swing.JButton zrusitButton;
    // End of variables declaration//GEN-END:variables
}
