package sk.upjs.ics.paz1c.fitnesscentrum;

import javax.swing.table.AbstractTableModel;
import sk.upjs.ics.paz1c.fitnesscentrum.dao.KreditDao;
import sk.upjs.ics.paz1c.fitnesscentrum.entity.Kredit;

public class KreditTableModel extends AbstractTableModel {

    private final KreditDao kreditDao = DaoFactory.INSTANCE.getKreditDao();
    private static final String[] NAZVY_STLPCOV = {"ID", "Cena", "Názov"};
    private static final int POCET_STLPCOV = NAZVY_STLPCOV.length;

    @Override
    public int getRowCount() {
        return kreditDao.dajVsetkyKredity().size();
    }

    @Override
    public int getColumnCount() {
        return POCET_STLPCOV;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Kredit kredit = kreditDao.dajVsetkyKredity().get(rowIndex);
        switch (columnIndex) {
            case 0:
                return kredit.getId();
            case 1:
                return kredit.getCena();
            case 2:
                return kredit.getNazov();
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
