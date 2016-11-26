package sk.upjs.ics.paz1c.fitnesscentrum;

import javax.swing.table.AbstractTableModel;
import sk.upjs.ics.paz1c.fitnesscentrum.dao.RezervaciaDao;
import sk.upjs.ics.paz1c.fitnesscentrum.dao.ZakaznikDao;
import sk.upjs.ics.paz1c.fitnesscentrum.entity.Rezervacia;
import sk.upjs.ics.paz1c.fitnesscentrum.entity.Spinning;

public class RezervaciaTableModel extends AbstractTableModel {

    private final RezervaciaDao rezervaciaDao;
    private final ZakaznikDao zakaznikDao;

    private static final String[] NAZVY_STLPCOV = {"Meno zákazníka", "Dátum rezervácie"};
    private static final int POCET_STLPCOV = NAZVY_STLPCOV.length;
    private Spinning spinning;

    public RezervaciaTableModel(Spinning spinning) {
        rezervaciaDao = DaoFactory.INSTANCE.getRezervaciaDao();
        zakaznikDao = DaoFactory.INSTANCE.getMySQLZakaznikDao();
        this.spinning = spinning;
    }

    @Override
    public int getRowCount() {
        if (spinning == null) {
            return 0;
        }
        return rezervaciaDao.dajRezervacieSpinningu(spinning.getId()).size();
    }

    @Override
    public int getColumnCount() {
        return POCET_STLPCOV;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Rezervacia rezervacia = rezervaciaDao.dajRezervacieSpinningu(spinning.getId()).get(rowIndex);
        switch (columnIndex) {
            case 0:
                return zakaznikDao.dajZakaznikaSId(rezervacia.getIdZakaznika()).getMeno();
            case 1:
                return rezervacia.getCasRezervacie();
            default:
                return "???";
        }
    }

}
