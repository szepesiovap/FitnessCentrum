package sk.upjs.ics.paz1c.fitnesscentrum;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import sk.upjs.ics.paz1c.fitnesscentrum.dao.KreditDao;
import sk.upjs.ics.paz1c.fitnesscentrum.entity.Kredit;

public class KreditTableModel extends AbstractTableModel {

    private final KreditDao kreditDao = ObjectFactory.INSTANCE.getKreditDao();
    private static final String[] NAZVY_STLPCOV = {"Cena", "Názov"};
    private static final int POCET_STLPCOV = NAZVY_STLPCOV.length;
    private List<Kredit> listKreditov = new ArrayList<>();

    public KreditTableModel() {
        aktualizovat();
    }

    @Override
    public int getRowCount() {
        return listKreditov.size();
    }

    @Override
    public int getColumnCount() {
        return POCET_STLPCOV;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Kredit kredit = listKreditov.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return kredit.getCena();
            case 1:
                return kredit.getNazov();
            case 2:
                return kredit.getId();
            default:
                return "???";
        }
    }

    @Override
    public String getColumnName(int columnIndex) {
        return NAZVY_STLPCOV[columnIndex];
    }

    public void aktualizovat() {
        listKreditov = kreditDao.dajVsetkyKredity();
        fireTableDataChanged();
    }

}
