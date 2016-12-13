package sk.upjs.ics.paz1c.fitnesscentrum.form;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import sk.upjs.ics.paz1c.fitnesscentrum.ObjectFactory;
import sk.upjs.ics.paz1c.fitnesscentrum.manager.ZakaznikManager;
import sk.upjs.ics.paz1c.fitnesscentrum.model.PritomniZakazniciTableModel;
import sk.upjs.ics.paz1c.fitnesscentrum.entity.Recepcny;

public final class HlavneOknoForm extends javax.swing.JFrame {

    private final Recepcny recepcny;
    private final ZakaznikManager zakaznikManager = ObjectFactory.INSTANCE.getZakaznikManager();
    private static final int ID_COLUMN = 4;

    /**
     * Creates new form ZoznamZakaznikovForm
     *
     * @param recepcny
     */
    public HlavneOknoForm(Recepcny recepcny) {
        this.recepcny = recepcny;
        initComponents();
        menoPrihlasenehoRecepcnehoLabel.setText(recepcny.getLogin());
        aktualizovatZoznamPritomnych();
    }

    public void aktualizovatZoznamPritomnych() {
        PritomniZakazniciTableModel model = (PritomniZakazniciTableModel) pritomniTable.getModel();
        model.aktualizovat();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        pritomniScrollPane = new javax.swing.JScrollPane();
        pritomniTable = new javax.swing.JTable();
        menoPrihlasenehoRecepcnehoLabel = new javax.swing.JLabel();
        prihlasenyRecepcnyLabel = new javax.swing.JLabel();
        hlavneOknoMenuBar = new javax.swing.JMenuBar();
        prichodMenu = new javax.swing.JMenu();
        jednorazovyPrichodMenuItem = new javax.swing.JMenuItem();
        prichodKartouMenuItem = new javax.swing.JMenuItem();
        odchodMenu = new javax.swing.JMenu();
        zoznamMenu = new javax.swing.JMenu();
        novyMenu = new javax.swing.JMenu();
        dobiMenu = new javax.swing.JMenu();
        spinningMenu = new javax.swing.JMenu();
        zmenaHeslaMenu = new javax.swing.JMenu();
        odhlasitMenu = new javax.swing.JMenu();

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Fitnesscentrum");
        setName("zoznamZakaznikovFrame"); // NOI18N

        pritomniTable.setModel(new PritomniZakazniciTableModel()
        );
        pritomniScrollPane.setViewportView(pritomniTable);

        prihlasenyRecepcnyLabel.setText("Prihlásený recepčný:");

        prichodMenu.setText("Príchod");

        jednorazovyPrichodMenuItem.setText("Jednorázový");
        jednorazovyPrichodMenuItem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jednorazovyPrichodMenuItemMousePressed(evt);
            }
        });
        prichodMenu.add(jednorazovyPrichodMenuItem);

        prichodKartouMenuItem.setText("Kartou");
        prichodKartouMenuItem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                prichodKartouMenuItemMousePressed(evt);
            }
        });
        prichodMenu.add(prichodKartouMenuItem);

        hlavneOknoMenuBar.add(prichodMenu);

        odchodMenu.setText("Odchod ");
        odchodMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                odchodMenuMousePressed(evt);
            }
        });
        hlavneOknoMenuBar.add(odchodMenu);

        zoznamMenu.setText("Zoznam ");
        zoznamMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                zoznamMenuMousePressed(evt);
            }
        });
        hlavneOknoMenuBar.add(zoznamMenu);

        novyMenu.setText("Nový zákazník ");
        novyMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                novyMenuMousePressed(evt);
            }
        });
        hlavneOknoMenuBar.add(novyMenu);

        dobiMenu.setText("Dobiť kredit ");
        dobiMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                dobiMenuMousePressed(evt);
            }
        });
        hlavneOknoMenuBar.add(dobiMenu);

        spinningMenu.setText("Spinning");
        spinningMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                spinningMenuMousePressed(evt);
            }
        });
        hlavneOknoMenuBar.add(spinningMenu);

        zmenaHeslaMenu.setText("Zmena hesla");
        zmenaHeslaMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                zmenaHeslaMenuMousePressed(evt);
            }
        });
        hlavneOknoMenuBar.add(zmenaHeslaMenu);

        odhlasitMenu.setText("Odhlásiť");
        odhlasitMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                odhlasitMenuMousePressed(evt);
            }
        });
        hlavneOknoMenuBar.add(odhlasitMenu);

        setJMenuBar(hlavneOknoMenuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(prihlasenyRecepcnyLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(menoPrihlasenehoRecepcnehoLabel)
                .addGap(0, 891, Short.MAX_VALUE))
            .addComponent(pritomniScrollPane, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pritomniScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 612, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(prihlasenyRecepcnyLabel)
                    .addComponent(menoPrihlasenehoRecepcnehoLabel)))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void odhlasitMenuMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_odhlasitMenuMousePressed
        Object[] options = {"Odhlásiť", "Zrušiť"};
        if (JOptionPane.showOptionDialog(this, "Chcete odhlásiť používateľa "
                + recepcny.getMeno() + "?", "Odhlásiť",
                JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null,
                options, options[0]) == JOptionPane.YES_OPTION) {
            dispose();
            new PrihlasovanieForm().setVisible(true);
        }
    }//GEN-LAST:event_odhlasitMenuMousePressed

    private void odchodMenuMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_odchodMenuMousePressed
        try {
            Long idZakaznika = (Long) pritomniTable.getModel().getValueAt(pritomniTable.getSelectedRow(), ID_COLUMN);
            zakaznikManager.odchodZakaznika(idZakaznika);
            aktualizovatZoznamPritomnych();
        } catch (ArrayIndexOutOfBoundsException e) {
            JOptionPane.showMessageDialog(this, "Nie je vybraný žiaden zákazník!");
        }
    }//GEN-LAST:event_odchodMenuMousePressed

    private void novyMenuMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_novyMenuMousePressed
        new NovyZakaznikForm(this, true).setVisible(true);
    }//GEN-LAST:event_novyMenuMousePressed

    private void dobiMenuMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dobiMenuMousePressed
        new DobitKreditForm(this, true).setVisible(true);
    }//GEN-LAST:event_dobiMenuMousePressed

    private void spinningMenuMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_spinningMenuMousePressed
        new SpinningForm(this, true).setVisible(true);
    }//GEN-LAST:event_spinningMenuMousePressed

    private void jednorazovyPrichodMenuItemMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jednorazovyPrichodMenuItemMousePressed
        new PrichodJednorazovyForm(this, true).setVisible(true);
        aktualizovatZoznamPritomnych();
    }//GEN-LAST:event_jednorazovyPrichodMenuItemMousePressed

    private void prichodKartouMenuItemMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_prichodKartouMenuItemMousePressed
        new PrichodKartouForm(this, true).setVisible(true);
        aktualizovatZoznamPritomnych();
    }//GEN-LAST:event_prichodKartouMenuItemMousePressed

    private void zoznamMenuMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_zoznamMenuMousePressed
        new ZoznamZakaznikovForm(this, true).setVisible(true);
    }//GEN-LAST:event_zoznamMenuMousePressed

    private void zmenaHeslaMenuMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_zmenaHeslaMenuMousePressed
        new ZmenaHeslaRecepcnehoForm(this, true, recepcny).setVisible(true);
    }//GEN-LAST:event_zmenaHeslaMenuMousePressed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu dobiMenu;
    private javax.swing.JMenuBar hlavneOknoMenuBar;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jednorazovyPrichodMenuItem;
    private javax.swing.JLabel menoPrihlasenehoRecepcnehoLabel;
    private javax.swing.JMenu novyMenu;
    private javax.swing.JMenu odchodMenu;
    private javax.swing.JMenu odhlasitMenu;
    private javax.swing.JMenuItem prichodKartouMenuItem;
    private javax.swing.JMenu prichodMenu;
    private javax.swing.JLabel prihlasenyRecepcnyLabel;
    private javax.swing.JScrollPane pritomniScrollPane;
    private javax.swing.JTable pritomniTable;
    private javax.swing.JMenu spinningMenu;
    private javax.swing.JMenu zmenaHeslaMenu;
    private javax.swing.JMenu zoznamMenu;
    // End of variables declaration//GEN-END:variables

}
