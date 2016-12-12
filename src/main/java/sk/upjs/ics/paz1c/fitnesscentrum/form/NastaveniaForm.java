package sk.upjs.ics.paz1c.fitnesscentrum.form;

import javax.swing.JOptionPane;
import org.springframework.dao.DuplicateKeyException;
import sk.upjs.ics.paz1c.fitnesscentrum.ObjectFactory;
import sk.upjs.ics.paz1c.fitnesscentrum.model.KlucTableModel;
import sk.upjs.ics.paz1c.fitnesscentrum.model.KreditTableModel;
import sk.upjs.ics.paz1c.fitnesscentrum.model.ZoznamRecepcnychTableModel;
import sk.upjs.ics.paz1c.fitnesscentrum.dao.VstupneDao;
import sk.upjs.ics.paz1c.fitnesscentrum.entity.Kluc;
import sk.upjs.ics.paz1c.fitnesscentrum.entity.Kredit;
import sk.upjs.ics.paz1c.fitnesscentrum.entity.Recepcny;
import sk.upjs.ics.paz1c.fitnesscentrum.exception.ObsadenyKlucException;
import sk.upjs.ics.paz1c.fitnesscentrum.exception.PrazdnyRetazecException;
import sk.upjs.ics.paz1c.fitnesscentrum.manager.KlucManager;
import sk.upjs.ics.paz1c.fitnesscentrum.manager.KreditManager;
import sk.upjs.ics.paz1c.fitnesscentrum.manager.RecepcnyManager;
import sk.upjs.ics.paz1c.fitnesscentrum.manager.VstupneManager;

public class NastaveniaForm extends javax.swing.JDialog {

    private final KlucManager klucManager = ObjectFactory.INSTANCE.getKlucManager();
    private final VstupneDao vstupneDao = ObjectFactory.INSTANCE.getVstupneDao();
    private final KreditManager kreditManager = ObjectFactory.INSTANCE.getKreditManager();
    private final RecepcnyManager recepcnyManager = ObjectFactory.INSTANCE.getRecepcnyManager();

    private final VstupneManager vstupneManager = ObjectFactory.INSTANCE.getVstupneManager();
    
    private static final int ID_COLUMN_KREDIT = 2;
    private static final int ID_COLUMN_RECEPCNY = 2;
    private static final int ID_COLUMN_KLUC = 0;
    private Recepcny recepcny;

    /**
     * Creates new form NastaveniaForm
     *
     * @param parent
     * @param modal
     */
    public NastaveniaForm(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        aktualizovatVstupneTabbedPane();
    }

    public NastaveniaForm() {
        super(new javax.swing.JFrame(), true);
        initComponents();
        aktualizovatVstupneTabbedPane();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        vstupneTabbedPane = new javax.swing.JTabbedPane();
        vstupnePanel = new javax.swing.JPanel();
        cenaVstupnehoLabel = new javax.swing.JLabel();
        cenaSpinninguLabel = new javax.swing.JLabel();
        cenaVstupnehoTexttField = new javax.swing.JTextField();
        cenaSpinninguTextField = new javax.swing.JTextField();
        ulozitVstupneButton = new javax.swing.JButton();
        euroLabel = new javax.swing.JLabel();
        eurLabel = new javax.swing.JLabel();
        recepcnyPanel = new javax.swing.JPanel();
        zoznamRecepcnychScrollPane = new javax.swing.JScrollPane();
        zoznamRecepcnychTable = new javax.swing.JTable();
        zmazatRecepcnehoButton = new javax.swing.JButton();
        novyRecepcnyjButton = new javax.swing.JButton();
        klucPanel = new javax.swing.JPanel();
        zoznamKlucovScrollPane = new javax.swing.JScrollPane();
        zoznamKlucovTable = new javax.swing.JTable();
        zmazatKlucButton = new javax.swing.JButton();
        novyKlucLabel = new javax.swing.JLabel();
        novyKlucTextField = new javax.swing.JTextField();
        ulozitKlucButton = new javax.swing.JButton();
        kreditPanel = new javax.swing.JPanel();
        zoznamKreditovScrollPane = new javax.swing.JScrollPane();
        zoznamKreditovTable = new javax.swing.JTable();
        zmazatKreditButton = new javax.swing.JButton();
        novyKreditLabel = new javax.swing.JLabel();
        novyKreditTextField = new javax.swing.JTextField();
        ulozitKreditButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Nastavenia");

        cenaVstupnehoLabel.setText("Cena jednorazového vstupu:");

        cenaSpinninguLabel.setText("Cena spinningu:");

        ulozitVstupneButton.setText("Uložiť zmeny");
        ulozitVstupneButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ulozitVstupneButtonActionPerformed(evt);
            }
        });

        euroLabel.setText("€");

        eurLabel.setText("€");

        javax.swing.GroupLayout vstupnePanelLayout = new javax.swing.GroupLayout(vstupnePanel);
        vstupnePanel.setLayout(vstupnePanelLayout);
        vstupnePanelLayout.setHorizontalGroup(
            vstupnePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(vstupnePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(vstupnePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cenaVstupnehoLabel)
                    .addComponent(cenaSpinninguLabel))
                .addGap(18, 18, 18)
                .addGroup(vstupnePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(vstupnePanelLayout.createSequentialGroup()
                        .addComponent(cenaSpinninguTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(eurLabel))
                    .addGroup(vstupnePanelLayout.createSequentialGroup()
                        .addComponent(cenaVstupnehoTexttField, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(euroLabel)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, vstupnePanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(ulozitVstupneButton)
                .addGap(26, 26, 26))
        );
        vstupnePanelLayout.setVerticalGroup(
            vstupnePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(vstupnePanelLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(vstupnePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cenaVstupnehoTexttField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cenaVstupnehoLabel)
                    .addComponent(euroLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(vstupnePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cenaSpinninguLabel)
                    .addComponent(cenaSpinninguTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(eurLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 284, Short.MAX_VALUE)
                .addComponent(ulozitVstupneButton)
                .addGap(24, 24, 24))
        );

        vstupneTabbedPane.addTab("Vstupné", vstupnePanel);

        zoznamRecepcnychTable.setModel(new ZoznamRecepcnychTableModel()
        );
        zoznamRecepcnychScrollPane.setViewportView(zoznamRecepcnychTable);

        zmazatRecepcnehoButton.setText("Zmazať");
        zmazatRecepcnehoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                zmazatRecepcnehoButtonActionPerformed(evt);
            }
        });

        novyRecepcnyjButton.setText("Nový ...");
        novyRecepcnyjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                novyRecepcnyjButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout recepcnyPanelLayout = new javax.swing.GroupLayout(recepcnyPanel);
        recepcnyPanel.setLayout(recepcnyPanelLayout);
        recepcnyPanelLayout.setHorizontalGroup(
            recepcnyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(recepcnyPanelLayout.createSequentialGroup()
                .addContainerGap(304, Short.MAX_VALUE)
                .addComponent(novyRecepcnyjButton, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(zmazatRecepcnehoButton, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addComponent(zoznamRecepcnychScrollPane, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        recepcnyPanelLayout.setVerticalGroup(
            recepcnyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(recepcnyPanelLayout.createSequentialGroup()
                .addGroup(recepcnyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(novyRecepcnyjButton)
                    .addComponent(zmazatRecepcnehoButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(zoznamRecepcnychScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 378, Short.MAX_VALUE))
        );

        vstupneTabbedPane.addTab("Recepčný", recepcnyPanel);

        zoznamKlucovTable.setModel(new KlucTableModel());
        zoznamKlucovScrollPane.setViewportView(zoznamKlucovTable);

        zmazatKlucButton.setText("Zmazať");
        zmazatKlucButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                zmazatKlucButtonActionPerformed(evt);
            }
        });

        novyKlucLabel.setText("Nový kľúč:");

        ulozitKlucButton.setText("Uložiť kľúč");
        ulozitKlucButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ulozitKlucButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout klucPanelLayout = new javax.swing.GroupLayout(klucPanel);
        klucPanel.setLayout(klucPanelLayout);
        klucPanelLayout.setHorizontalGroup(
            klucPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(klucPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(novyKlucLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(novyKlucTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(ulozitKlucButton, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(zmazatKlucButton, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addComponent(zoznamKlucovScrollPane, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 576, Short.MAX_VALUE)
        );
        klucPanelLayout.setVerticalGroup(
            klucPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(klucPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(klucPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(zmazatKlucButton)
                    .addComponent(ulozitKlucButton)
                    .addComponent(novyKlucTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(novyKlucLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(zoznamKlucovScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 360, Short.MAX_VALUE))
        );

        vstupneTabbedPane.addTab("Kľúče", klucPanel);

        zoznamKreditovTable.setModel(new KreditTableModel());
        zoznamKreditovScrollPane.setViewportView(zoznamKreditovTable);

        zmazatKreditButton.setText("Zmazať");
        zmazatKreditButton.setPreferredSize(new java.awt.Dimension(105, 25));
        zmazatKreditButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                zmazatKreditButtonActionPerformed(evt);
            }
        });

        novyKreditLabel.setText("Nový kredit :");

        ulozitKreditButton.setText("Uložiť kredit");
        ulozitKreditButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ulozitKreditButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout kreditPanelLayout = new javax.swing.GroupLayout(kreditPanel);
        kreditPanel.setLayout(kreditPanelLayout);
        kreditPanelLayout.setHorizontalGroup(
            kreditPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kreditPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(novyKreditLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(novyKreditTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(ulozitKreditButton, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(zmazatKreditButton, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addComponent(zoznamKreditovScrollPane)
        );
        kreditPanelLayout.setVerticalGroup(
            kreditPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kreditPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(kreditPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(kreditPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE, false)
                        .addComponent(ulozitKreditButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(zmazatKreditButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(novyKreditLabel))
                    .addComponent(novyKreditTextField))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(zoznamKreditovScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 360, Short.MAX_VALUE))
        );

        vstupneTabbedPane.addTab("Kredity", kreditPanel);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(vstupneTabbedPane)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(vstupneTabbedPane)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void ulozitVstupneButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ulozitVstupneButtonActionPerformed
        try {
            double novaCenaVstupneho = Double.parseDouble(cenaVstupnehoTexttField.getText());
            double novaCenaSpinningu = Double.parseDouble(cenaSpinninguTextField.getText());
            vstupneManager.nastavCeny(novaCenaVstupneho,novaCenaSpinningu);
            
            JOptionPane.showMessageDialog(this, "Cena bola zmenená!");
            aktualizovatVstupneTabbedPane();
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Zlý format ceny!");
        }

    }//GEN-LAST:event_ulozitVstupneButtonActionPerformed

    private void zmazatKreditButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_zmazatKreditButtonActionPerformed
        try {
            Long idKredit = (Long) zoznamKreditovTable.getModel().getValueAt(this.zoznamKreditovTable.getSelectedRow(), ID_COLUMN_KREDIT);
            Kredit kredit = kreditManager.dajKreditSId(idKredit);
            if (kredit != null) {
                Object[] options = {"Zmazať", "Zrušiť"};
                if (JOptionPane.showOptionDialog(this, "Naozaj chcete zmazať kredit " + kredit.getNazov() + "?",
                        "Zmazať kredit",
                        JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null,
                        options, options[0]) == JOptionPane.YES_OPTION) {
                    kreditManager.vymazKredit(idKredit);
                    JOptionPane.showMessageDialog(this, "Kredit " + kredit.getNazov() + " bol zmazaný!");
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Nie je vybraný žiaden kredit!");
        }
        aktualizovatKreditTable();
    }//GEN-LAST:event_zmazatKreditButtonActionPerformed

    private void zmazatRecepcnehoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_zmazatRecepcnehoButtonActionPerformed
        try {
            Long idRecepcny = (Long) zoznamRecepcnychTable.getModel().
                    getValueAt(this.zoznamRecepcnychTable.getSelectedRow(), ID_COLUMN_RECEPCNY);
            recepcny = recepcnyManager.dajRecepcneho(idRecepcny);

            Object[] options = {"Zmazať", "Zrušiť"};
            if (JOptionPane.showOptionDialog(this, "Naozaj chcete zmazať recepčného "
                    + recepcny.getMeno() + " s loginom " + recepcny.getLogin() + "?",
                    "Zmazať recepčného",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null,
                    options, options[0]) == JOptionPane.YES_OPTION) {
                recepcnyManager.vymazRecepcneho(recepcny);
                JOptionPane.showMessageDialog(this, "Recepčný " + recepcny.getMeno() + " s loginom "
                        + recepcny.getLogin() + " bol zmazaný!");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Nie je vybraný žiaden recepčný!");
        }

        aktualizovatZoznamRecepcnychTable();
    }//GEN-LAST:event_zmazatRecepcnehoButtonActionPerformed

    private void novyRecepcnyjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_novyRecepcnyjButtonActionPerformed
        new NovyRecepcnyForm(new javax.swing.JFrame(), true).setVisible(true);
        aktualizovatZoznamRecepcnychTable();
    }//GEN-LAST:event_novyRecepcnyjButtonActionPerformed

    private void zmazatKlucButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_zmazatKlucButtonActionPerformed
        try {
            Long idKluca = (Long) zoznamKlucovTable.getModel().
                    getValueAt(this.zoznamKlucovTable.getSelectedRow(), ID_COLUMN_KLUC);
            Kluc kluc = klucManager.dajKlucSId(idKluca);
            Object[] options = {"Zmazať", "Zrušiť"};

            if (JOptionPane.showOptionDialog(this, "Naozaj chcete zmazať kľúč " + kluc.getMeno() + "?",
                    "Zmazať kľúč",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null,
                    options, options[0]) == JOptionPane.YES_OPTION) {
                klucManager.vymazKluc(kluc);
                JOptionPane.showMessageDialog(this, "Klúč " + kluc.getMeno() + "bol zmazaný!");
            }
        } catch (ObsadenyKlucException e) {
            JOptionPane.showMessageDialog(this, "Vybraný kľúč je priradený zákazníkovi, "
                    + "nemožno zmazať priradený kľúč!");
        } catch (ArrayIndexOutOfBoundsException e) {
            JOptionPane.showMessageDialog(this, "Nie je vybraný žiaden kľúč!");
        }
        aktualizovatKlucTable();
    }//GEN-LAST:event_zmazatKlucButtonActionPerformed

    private void ulozitKreditButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ulozitKreditButtonActionPerformed
        Kredit kredit = new Kredit();
        try {
            kredit.setCena(Double.parseDouble(novyKreditTextField.getText()));
            kredit.setNazov(novyKreditTextField.getText() + " eur");
            kreditManager.ulozitKredit(kredit);
            aktualizovatKreditTable();
            JOptionPane.showMessageDialog(this, "Kredit " + kredit.getNazov() + " bol pridaný!");
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Nesprávne zadaný kredit!");
        } catch (DuplicateKeyException e) {
            JOptionPane.showMessageDialog(this, "Kredit už existuje!");
        }

    }//GEN-LAST:event_ulozitKreditButtonActionPerformed

    private void ulozitKlucButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ulozitKlucButtonActionPerformed
        try {
            klucManager.pridajKluc(novyKlucTextField.getText());
            aktualizovatKlucTable();
            JOptionPane.showMessageDialog(this, "Kľúč " + novyKlucTextField.getText() + " bol pridaný!");
        } catch (PrazdnyRetazecException e) {
            JOptionPane.showMessageDialog(this, "Zadaj meno kľúča!");
        } catch (DuplicateKeyException e) {
            JOptionPane.showMessageDialog(this, "Kľúč už existuje!");
        }

    }//GEN-LAST:event_ulozitKlucButtonActionPerformed

    private void aktualizovatVstupneTabbedPane() {
        double vstup = vstupneDao.dajCeny().getCenaVstupneho();
        double spinning = vstupneDao.dajCeny().getCenaSpinnigu();
        cenaVstupnehoTexttField.setText("" + vstup);
        cenaSpinninguTextField.setText("" + spinning);
    }

    private void aktualizovatKreditTable() {
        KreditTableModel model = (KreditTableModel) zoznamKreditovTable.getModel();
        model.aktualizovat();
        novyKreditTextField.setText("");
    }

    private void aktualizovatZoznamRecepcnychTable() {
        ZoznamRecepcnychTableModel model = (ZoznamRecepcnychTableModel) zoznamRecepcnychTable.getModel();
        model.aktualizovat();
    }

    private void aktualizovatKlucTable() {
        KlucTableModel model = (KlucTableModel) zoznamKlucovTable.getModel();
        model.aktualizovat();
        novyKlucTextField.setText("");
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel cenaSpinninguLabel;
    private javax.swing.JTextField cenaSpinninguTextField;
    private javax.swing.JLabel cenaVstupnehoLabel;
    private javax.swing.JTextField cenaVstupnehoTexttField;
    private javax.swing.JLabel eurLabel;
    private javax.swing.JLabel euroLabel;
    private javax.swing.JPanel klucPanel;
    private javax.swing.JPanel kreditPanel;
    private javax.swing.JLabel novyKlucLabel;
    private javax.swing.JTextField novyKlucTextField;
    private javax.swing.JLabel novyKreditLabel;
    private javax.swing.JTextField novyKreditTextField;
    private javax.swing.JButton novyRecepcnyjButton;
    private javax.swing.JPanel recepcnyPanel;
    private javax.swing.JButton ulozitKlucButton;
    private javax.swing.JButton ulozitKreditButton;
    private javax.swing.JButton ulozitVstupneButton;
    private javax.swing.JPanel vstupnePanel;
    private javax.swing.JTabbedPane vstupneTabbedPane;
    private javax.swing.JButton zmazatKlucButton;
    private javax.swing.JButton zmazatKreditButton;
    private javax.swing.JButton zmazatRecepcnehoButton;
    private javax.swing.JScrollPane zoznamKlucovScrollPane;
    private javax.swing.JTable zoznamKlucovTable;
    private javax.swing.JScrollPane zoznamKreditovScrollPane;
    private javax.swing.JTable zoznamKreditovTable;
    private javax.swing.JScrollPane zoznamRecepcnychScrollPane;
    private javax.swing.JTable zoznamRecepcnychTable;
    // End of variables declaration//GEN-END:variables
}
