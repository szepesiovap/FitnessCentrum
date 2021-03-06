package sk.upjs.ics.paz1c.fitnesscentrum.model;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import sk.upjs.ics.paz1c.fitnesscentrum.ObjectFactory;
import sk.upjs.ics.paz1c.fitnesscentrum.entity.Recepcny;
import sk.upjs.ics.paz1c.fitnesscentrum.manager.RecepcnyManager;

public class ZoznamRecepcnychTableModel extends AbstractTableModel {

    private final RecepcnyManager recepcnyManager = ObjectFactory.INSTANCE.getRecepcnyManager();
    private static final String[] NAZVY_STLPCOV = {"Meno a priezvisko", "Login"};
    private static final int POCET_STLPCOV = NAZVY_STLPCOV.length;
    private List<Recepcny> listRecepcnych = new ArrayList<>();

    public ZoznamRecepcnychTableModel() {
        aktualizovat();
    }

    
    @Override
    public int getRowCount() {
        return listRecepcnych.size();
    }

    @Override
    public int getColumnCount() {
        return POCET_STLPCOV;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Recepcny recepcny = listRecepcnych.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return recepcny.getMeno();
            case 1:
                return recepcny.getLogin();
            case 2:
                return recepcny.getId();
            default:
                return "???";
        }
    }

    @Override
    public String getColumnName(int columnIndex) {
        return NAZVY_STLPCOV[columnIndex];
    }

    public void aktualizovat() {
        listRecepcnych = recepcnyManager.dajVsetkychRecepcnych();
        fireTableDataChanged();
    }
}
