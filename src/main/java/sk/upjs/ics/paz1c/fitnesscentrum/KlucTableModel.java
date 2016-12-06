package sk.upjs.ics.paz1c.fitnesscentrum;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import sk.upjs.ics.paz1c.fitnesscentrum.dao.KlucDao;
import sk.upjs.ics.paz1c.fitnesscentrum.entity.Kluc;

public class KlucTableModel extends AbstractTableModel {

    private final KlucDao klucDao = ObjectFactory.INSTANCE.getKlucDao();
    private static final String[] NAZVY_STLPCOV = {"ID", "Meno kľúča"};
    private static final int POCET_STLPCOV = NAZVY_STLPCOV.length;
    private List<Kluc> listKlucov = new ArrayList<>();

    public KlucTableModel() {
        aktualizovat();
    }

    @Override
    public int getRowCount() {
        return listKlucov.size();
    }

    @Override
    public int getColumnCount() {
        return POCET_STLPCOV;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Kluc kluc = listKlucov.get(rowIndex);
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
        listKlucov = klucDao.dajVsetkyKluce();
        fireTableDataChanged();
    }

}
