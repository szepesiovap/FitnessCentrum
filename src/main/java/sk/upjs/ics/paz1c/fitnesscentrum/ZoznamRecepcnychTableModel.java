package sk.upjs.ics.paz1c.fitnesscentrum;

import javax.swing.table.AbstractTableModel;
import sk.upjs.ics.paz1c.fitnesscentrum.dao.RecepcnyDao;
import sk.upjs.ics.paz1c.fitnesscentrum.entity.Recepcny;

public class ZoznamRecepcnychTableModel extends AbstractTableModel {

    private final RecepcnyDao recepcnyDao = DaoFactory.INSTANCE.getRecepcnyDao();
    private static final String[] NAZVY_STLPCOV = {"ID", "Meno a priezvisko", "Login"};
    private static final int POCET_STLPCOV = NAZVY_STLPCOV.length;

    @Override
    public int getRowCount() {
        return recepcnyDao.dajVsetkychRecepcnych().size();
    }

    @Override
    public int getColumnCount() {
        return POCET_STLPCOV;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Recepcny recepcny = recepcnyDao.dajVsetkychRecepcnych().get(rowIndex);
        switch (columnIndex) {
            case 0:
                return recepcny.getId();
            case 1:
                return recepcny.getMeno();
            case 2:
                return recepcny.getLogin();
            default:
                return "???";
        }
    }

    @Override
    public String getColumnName(int columnIndex) {
        return NAZVY_STLPCOV[columnIndex];
    }

    public void aktualizovat() {
        fireTableDataChanged();
    }
}
