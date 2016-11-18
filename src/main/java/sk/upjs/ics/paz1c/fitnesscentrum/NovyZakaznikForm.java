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

        menoZakaznikaTextField = new javax.swing.JTextField();
        menoZakaznikaLabel = new javax.swing.JLabel();
        priezviskoZakaznikaLabel = new javax.swing.JLabel();
        priezviskoZakaznikaTextField = new javax.swing.JTextField();
        novyZakaznikLabel = new javax.swing.JLabel();
        ulozButton = new javax.swing.JButton();
        zrusitButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        menoZakaznikaTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menoZakaznikaTextFieldActionPerformed(evt);
            }
        });

        menoZakaznikaLabel.setText("Meno: ");

        priezviskoZakaznikaLabel.setText("Priezvisko:");

        novyZakaznikLabel.setText("Nový zákazník");

        ulozButton.setText("Ulož");
        ulozButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ulozButtonActionPerformed(evt);
            }
        });

        zrusitButton.setText("Zrušiť");
        zrusitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                zrusitButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(menoZakaznikaLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(priezviskoZakaznikaLabel))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(menoZakaznikaTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)
                            .addComponent(priezviskoZakaznikaTextField)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(59, 59, 59)
                        .addComponent(ulozButton, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(zrusitButton)))
                .addContainerGap(35, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(98, Short.MAX_VALUE)
                .addComponent(novyZakaznikLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(98, 98, 98))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(novyZakaznikLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(menoZakaznikaTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(menoZakaznikaLabel))
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(priezviskoZakaznikaLabel)
                    .addComponent(priezviskoZakaznikaTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(zrusitButton)
                    .addComponent(ulozButton))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void menoZakaznikaTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menoZakaznikaTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_menoZakaznikaTextFieldActionPerformed

    private void ulozButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ulozButtonActionPerformed
        String menoZakaznika = menoZakaznikaTextField.getText() +" "+ priezviskoZakaznikaTextField.getText();
        
        Zakaznik zakaznik = new Zakaznik();
        zakaznik.setMeno(menoZakaznika);
        
        DaoFactory.INSTANCE.getMySQLZakaznikDao().pridajZakaznika(zakaznik);        
        this.zoznamZakaznikovForm.aktualizovatZoznamZakaznikov();
        this.dispose();
    }//GEN-LAST:event_ulozButtonActionPerformed

    private void zrusitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_zrusitButtonActionPerformed
        this.dispose();
    }//GEN-LAST:event_zrusitButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel menoZakaznikaLabel;
    private javax.swing.JTextField menoZakaznikaTextField;
    private javax.swing.JLabel novyZakaznikLabel;
    private javax.swing.JLabel priezviskoZakaznikaLabel;
    private javax.swing.JTextField priezviskoZakaznikaTextField;
    private javax.swing.JButton ulozButton;
    private javax.swing.JButton zrusitButton;
    // End of variables declaration//GEN-END:variables
}