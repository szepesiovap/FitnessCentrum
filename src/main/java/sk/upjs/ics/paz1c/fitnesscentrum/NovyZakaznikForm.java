package sk.upjs.ics.paz1c.fitnesscentrum;

import sk.upjs.ics.paz1c.fitnesscentrum.entity.Zakaznik;

public class NovyZakaznikForm extends javax.swing.JFrame {

    private ZoznamZakaznikovForm zoznamZakaznikovForm;
    /**
     * Creates new form NovyZakaznikForm
     * @param zoznamZakaznikovForm
     */
    public NovyZakaznikForm(ZoznamZakaznikovForm zoznamZakaznikovForm) {
        this.zoznamZakaznikovForm = zoznamZakaznikovForm;
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

        MenoZakaznikaTextField = new javax.swing.JTextField();
        MenoZakaznikaLabel = new javax.swing.JLabel();
        PriezviskoZakaznikaLabel = new javax.swing.JLabel();
        PriezviskoZakaznikaTextField = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        UlozButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        MenoZakaznikaTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenoZakaznikaTextFieldActionPerformed(evt);
            }
        });

        MenoZakaznikaLabel.setText("Meno: ");

        PriezviskoZakaznikaLabel.setText("Priezvisko:");

        jLabel1.setText("Nový zákazník");

        UlozButton.setText("Ulož");
        UlozButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UlozButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(MenoZakaznikaLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PriezviskoZakaznikaLabel))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(MenoZakaznikaTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)
                    .addComponent(PriezviskoZakaznikaTextField))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(UlozButton)
                .addGap(20, 20, 20))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(116, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(73, 73, 73))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(11, 11, 11)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(MenoZakaznikaTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(MenoZakaznikaLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(PriezviskoZakaznikaLabel)
                            .addComponent(PriezviskoZakaznikaTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addComponent(UlozButton)))
                .addContainerGap(67, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void MenoZakaznikaTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenoZakaznikaTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_MenoZakaznikaTextFieldActionPerformed

    private void UlozButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UlozButtonActionPerformed
        String menoZakaznika = MenoZakaznikaTextField.getText() +" "+ PriezviskoZakaznikaTextField.getText();
        
        Zakaznik zakaznik = new Zakaznik();
        zakaznik.setMeno(menoZakaznika);
        
        DaoFactory.INSTANCE.getMySQLZakaznikDao().pridajZakaznika(zakaznik);        
        this.setVisible(false);
        this.zoznamZakaznikovForm.aktualizovatZoznamUloh();
    }//GEN-LAST:event_UlozButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel MenoZakaznikaLabel;
    private javax.swing.JTextField MenoZakaznikaTextField;
    private javax.swing.JLabel PriezviskoZakaznikaLabel;
    private javax.swing.JTextField PriezviskoZakaznikaTextField;
    private javax.swing.JButton UlozButton;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
