package sk.upjs.ics.paz1c.fitnesscentrum.model;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import sk.upjs.ics.paz1c.fitnesscentrum.ObjectFactory;
import sk.upjs.ics.paz1c.fitnesscentrum.entity.Spinning;
import sk.upjs.ics.paz1c.fitnesscentrum.manager.SpinningManager;

public class SpinningTableModel extends AbstractTableModel {

    private final SpinningManager spinnigManager = ObjectFactory.INSTANCE.getSpinningManager();

    private static final String[] NAZVY_STLPCOV = {"Dátum", "Inštruktor", "Počet voľných miest", "Počet miest" };
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
                return spinning.getVolne();
            case 3:
                return spinning.getKapacita();
            case 4:
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
        listSpinningov = spinnigManager.dajVsetkySpinningy();
        fireTableDataChanged();
    }
}
