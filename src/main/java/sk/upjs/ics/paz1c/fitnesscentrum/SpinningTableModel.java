package sk.upjs.ics.paz1c.fitnesscentrum;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import sk.upjs.ics.paz1c.fitnesscentrum.dao.SpinningDao;
import sk.upjs.ics.paz1c.fitnesscentrum.entity.Spinning;

public class SpinningTableModel extends AbstractTableModel {

    private final SpinningDao spinnigDao = DaoFactory.INSTANCE.getSpinningDao();

    private static final String[] NAZVY_STLPCOV = {"Dátum", "Inštruktor"};
    private static final int POCET_STLPCOV = NAZVY_STLPCOV.length;
    private List<Spinning> listSpinningov = new ArrayList<>();

    public SpinningTableModel() {
        aktualizovat();
    }

    @Override
    public int getRowCount() {
        return listSpinningov.size();
    }

    @Override
    public int getColumnCount() {
        return POCET_STLPCOV;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Spinning spinning = listSpinningov.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return spinning.getDatum().toLocalDate() + " " + spinning.getDatum().toLocalTime();
            case 1:
                return spinning.getInstruktor();
            case 2:
                return spinning.getId();
            default:
                return "???";
        }
    }

    @Override
    public String getColumnName(int columnIndex) {
        return NAZVY_STLPCOV[columnIndex];
    }

    public void aktualizovat() {
        listSpinningov = spinnigDao.dajVsetkySpinningy();
        fireTableDataChanged();
    }
}
