package sk.upjs.ics.paz1c.fitnesscentrum;

import sk.upjs.ics.paz1c.fitnesscentrum.entity.Zakaznik;
import javax.swing.table.AbstractTableModel;
import sk.upjs.ics.paz1c.fitnesscentrum.dao.ZakaznikDao;
import sk.upjs.ics.paz1c.fitnesscentrum.entity.ZakaznikSPernamentkou;

public class ZakaznikSPernamentkouTableModel extends AbstractTableModel {

    private ZakaznikDao zakaznikDao = DaoFactory.INSTANCE.getMySQLZakaznikDao();

    private static final String[] NAZVY_STLPCOV = {"Meno", "Posledny prichod", "Pritomny", "Cislo pernamentky", "Typ"};

    private static final int POCET_STLPCOV = NAZVY_STLPCOV.length;

    @Override
    public int getRowCount() {
        return zakaznikDao.dajVsetkychZakaznikov().size();
    }

    @Override
    public int getColumnCount() {
        return POCET_STLPCOV;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        ZakaznikSPernamentkou zakaznik = zakaznikDao.dajVsetkychZakaznikovSPernamentkou().get(rowIndex);
        switch (columnIndex) {
            case 0:
                return zakaznik.getZakaznik().getMeno();
            case 1:
                return zakaznik.getZakaznik().getPoslednyPrichod();
            case 2:
                return zakaznik.getZakaznik().isPritomny();
            case 3:
                return zakaznik.getPernamentka().getCislo();
            case 4:
                return zakaznik.getPernamentka().getTyp();
            default:
                return "???";
        }
    }

    @Override
    public String getColumnName(int columnIndex) {
        return NAZVY_STLPCOV[columnIndex];
    }

}
