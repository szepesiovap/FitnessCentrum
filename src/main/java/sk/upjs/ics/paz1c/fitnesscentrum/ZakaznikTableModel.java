package sk.upjs.ics.paz1c.fitnesscentrum;

import javax.swing.table.AbstractTableModel;

/**
 *
 * @author patka
 */
public class ZakaznikTableModel extends AbstractTableModel {

    private ZakaznikDao zakaznikDao = ZakaznikDaoFactory.INSTANCE.getZakaznikDao();

    private static final String[] NAZVY_STLPCOV = {"Meno"};

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
        Zakaznik zakaznik = zakaznikDao.dajVsetkychZakaznikov().get(rowIndex);
        switch (columnIndex) {
            case 0:
                return zakaznik.getMeno();
            default:
                return "???";
        }    }

}
