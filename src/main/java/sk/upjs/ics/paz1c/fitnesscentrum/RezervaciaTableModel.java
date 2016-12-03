package sk.upjs.ics.paz1c.fitnesscentrum;

import java.util.Collections;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import sk.upjs.ics.paz1c.fitnesscentrum.dao.RezervaciaDao;
import sk.upjs.ics.paz1c.fitnesscentrum.dao.ZakaznikDao;
import sk.upjs.ics.paz1c.fitnesscentrum.entity.Rezervacia;
import sk.upjs.ics.paz1c.fitnesscentrum.entity.Spinning;

public class RezervaciaTableModel extends AbstractTableModel {

    private final RezervaciaDao rezervaciaDao = DaoFactory.INSTANCE.getRezervaciaDao();

    private static final String[] NAZVY_STLPCOV = {"Meno zákazníka", "Dátum rezervácie"};
    private static final int POCET_STLPCOV = NAZVY_STLPCOV.length;
    private Spinning spinning;
    private List<Rezervacia> listRezervacii;

    public RezervaciaTableModel(Spinning spinning) {
        this.spinning = spinning;
        aktualizovat();
    }

    @Override
    public int getRowCount() {
        if (spinning == null) {
            return 0;
        }
        return listRezervacii.size();
    }

    @Override
    public int getColumnCount() {
        return POCET_STLPCOV;
    }

    @Override
    public String getColumnName(int columnIndex) {
        return NAZVY_STLPCOV[columnIndex];
    }

    public void aktualizovat() {
        if (spinning == null) {
            listRezervacii = Collections.emptyList();
        } else {
            listRezervacii = rezervaciaDao.dajRezervacieSpinningu(spinning);
        }
        fireTableDataChanged();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Rezervacia rezervacia = listRezervacii.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return rezervacia.getZakaznik().getMeno();
            case 1:
                return rezervacia.getCasRezervacie().toLocalDate() + " " + rezervacia.getCasRezervacie().toLocalTime();
            case 2:
                return rezervacia.getId();
            default:
                return "???";
        }
    }

}
