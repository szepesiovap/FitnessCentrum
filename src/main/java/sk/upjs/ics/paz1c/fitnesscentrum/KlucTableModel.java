package sk.upjs.ics.paz1c.fitnesscentrum;

import javax.swing.table.AbstractTableModel;
import sk.upjs.ics.paz1c.fitnesscentrum.dao.KlucDao;
import sk.upjs.ics.paz1c.fitnesscentrum.entity.Kluc;

public class KlucTableModel extends AbstractTableModel {

    private KlucDao klucDao = DaoFactory.INSTANCE.getKlucDao();
    private static final String[] NAZVY_STLPCOV = {"ID", "Meno kľúča"};
    private static final int POCET_STLPCOV = NAZVY_STLPCOV.length;

    @Override
    public int getRowCount() {
        return klucDao.dajVsetkyKluce().size();
    }

    @Override
    public int getColumnCount() {
        return POCET_STLPCOV;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Kluc kluc = klucDao.dajVsetkyKluce().get(rowIndex);
        switch (columnIndex) {
            case 0:
                return kluc.getId();
            case 1:
                return kluc.getMeno();
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
