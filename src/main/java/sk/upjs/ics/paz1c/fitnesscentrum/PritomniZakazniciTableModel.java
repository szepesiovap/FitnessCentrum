package sk.upjs.ics.paz1c.fitnesscentrum;

import sk.upjs.ics.paz1c.fitnesscentrum.entity.Zakaznik;
import javax.swing.table.AbstractTableModel;
import sk.upjs.ics.paz1c.fitnesscentrum.dao.ZakaznikDao;

/**
 *
 * @author patka
 */
public class PritomniZakazniciTableModel extends AbstractTableModel {

    private ZakaznikDao zakaznikDao = DaoFactory.INSTANCE.getMySQLZakaznikDao();

    private static final String[] NAZVY_STLPCOV = {"Kluc", "Meno", "Cas prichodu", "Typ platby"};

    private static final int POCET_STLPCOV = NAZVY_STLPCOV.length;

    @Override
    public int getRowCount() {
        return zakaznikDao.dajPritomnychZakaznikov().size();
    }

    @Override
    public int getColumnCount() {
        return POCET_STLPCOV;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Zakaznik zakaznik = zakaznikDao.dajPritomnychZakaznikov().get(rowIndex);
        switch (columnIndex) {
            case 0:
                return "18M";
            case 1:
                return zakaznik.getMeno();
            case 2:
                return zakaznik.getPoslednyPrichod();
            case 3:
                return "CASH";
            default:
                return "???";
        }
    }

    @Override
    public String getColumnName(int columnIndex) {
        return NAZVY_STLPCOV[columnIndex];
    }

}
