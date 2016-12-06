package sk.upjs.ics.paz1c.fitnesscentrum.form;

import javax.swing.JOptionPane;
import org.springframework.dao.DuplicateKeyException;
import sk.upjs.ics.paz1c.fitnesscentrum.ObjectFactory;
import sk.upjs.ics.paz1c.fitnesscentrum.HesloManager;

import sk.upjs.ics.paz1c.fitnesscentrum.dao.RecepcnyDao;
import sk.upjs.ics.paz1c.fitnesscentrum.entity.Recepcny;

public class NovyRecepcnyForm extends javax.swing.JDialog {

    private Recepcny recepcny;
    private final RecepcnyDao recepcnyDao = ObjectFactory.INSTANCE.getRecepcnyDao();
    private final HesloManager hesloManager = ObjectFactory.INSTANCE.getHesloManager();

    /**
     * Creates new form NovyRecepcnyForm
     *
     * @param parent
     * @param modal
     */
    public NovyRecepcnyForm(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    public NovyRecepcnyForm() {
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

        menoLabel = new javax.swing.JLabel();
        loginLabel = new javax.swing.JLabel();
        hesloLabel = new javax.swing.JLabel();
        zrusitButton = new javax.swing.JButton();
        ulozitButton = new javax.swing.JButton();
        menoTextField = new javax.swing.JTextField();
        loginTextField = new javax.swing.JTextField();
        hesloPasswordField = new javax.swing.JPasswordField();
        hesloZnovaPasswordField = new javax.swing.JPasswordField();
        hesloZnovaLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Nový recepčný");
        setResizable(false);

        menoLabel.setText("Meno:");

        loginLabel.setText("Login:");

        hesloLabel.setText("Heslo:");

        zrusitButton.setText("Zrušiť");
        zrusitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                zrusitButtonActionPerformed(evt);
            }
        });

        ulozitButton.setText("Uložiť");
        ulozitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ulozitButtonActionPerformed(evt);
            }
        });

        hesloZnovaLabel.setText("Heslo znova:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(ulozitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(46, 46, 46)
                        .addComponent(zrusitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(hesloLabel)
                            .addComponent(hesloZnovaLabel)
                            .addComponent(loginLabel)
                            .addComponent(menoLabel))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(hesloPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(hesloZnovaPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(loginTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(menoTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(menoLabel)
                            .addComponent(menoTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(40, 40, 40))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(loginTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(loginLabel)))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(hesloPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(hesloLabel))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(hesloZnovaPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(hesloZnovaLabel))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(zrusitButton)
                    .addComponent(ulozitButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void zrusitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_zrusitButtonActionPerformed
        this.dispose();
    }//GEN-LAST:event_zrusitButtonActionPerformed

    private void ulozitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ulozitButtonActionPerformed
        String meno = menoTextField.getText();
        String login = loginTextField.getText();

        String noveHeslo = hesloPasswordField.getText();
        String noveHesloZnova = hesloZnovaPasswordField.getText();
        recepcny = new Recepcny();

        if (!("").equals(meno)) {
            recepcny.setMeno(meno);
            if (!("").equals(login)) {
                recepcny.setLogin(login);
            } else {
                JOptionPane.showMessageDialog(this, "Zadajte login");
                return;
            }
        } else {
            JOptionPane.showMessageDialog(this, "Zadajte meno");
            return;
        }

        if (!("").equals(noveHeslo)) {
            if (hesloManager.overZhoduHesiel(noveHesloZnova, noveHeslo)) {
                String salt = hesloManager.vygenerujSalt();
                recepcny.setSalt(salt);

                String hashHeslo = hesloManager.zahesujHeslo(salt, noveHeslo);
                recepcny.setHeslo(hashHeslo);
            } else {
                JOptionPane.showMessageDialog(this, "Heslo sa nezhoduje");
                return;
            }
        } else {
            JOptionPane.showMessageDialog(this, "Heslo nemôže byť prázdne.");
            return;
        }

        try {
            recepcnyDao.pridajRecepcneho(recepcny);
        } catch (DuplicateKeyException e) {
            JOptionPane.showMessageDialog(this, "Zvolený login je už použitý");
            return;
        }
        dispose();

    }//GEN-LAST:event_ulozitButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel hesloLabel;
    private javax.swing.JPasswordField hesloPasswordField;
    private javax.swing.JLabel hesloZnovaLabel;
    private javax.swing.JPasswordField hesloZnovaPasswordField;
    private javax.swing.JLabel loginLabel;
    private javax.swing.JTextField loginTextField;
    private javax.swing.JLabel menoLabel;
    private javax.swing.JTextField menoTextField;
    private javax.swing.JButton ulozitButton;
    private javax.swing.JButton zrusitButton;
    // End of variables declaration//GEN-END:variables
}
