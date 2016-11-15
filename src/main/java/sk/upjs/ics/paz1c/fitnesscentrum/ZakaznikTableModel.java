package sk.upjs.ics.paz1c.fitnesscentrum;

import sk.upjs.ics.paz1c.fitnesscentrum.entity.Zakaznik;
import javax.swing.table.AbstractTableModel;
import sk.upjs.ics.paz1c.fitnesscentrum.dao.ZakaznikDao;

/**
 *
 * @author patka
 */
public class ZakaznikTableModel extends AbstractTableModel {

    private ZakaznikDao zakaznikDao = DaoFactory.INSTANCE.getMySQLZakaznikDao();

    private static final String[] NAZVY_STLPCOV = {"Meno", "Pritomny", "Posledny prichod", "Kredit", "Cislo permanentky", "Platna od", "Platna do"};

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
            case 1:
                return zakaznik.isPritomny();
            case 2:
                return zakaznik.getPoslednyPrichod();
            case 3:
                return zakaznik.getKredit();
            case 4:
                return zakaznik.getCisloPermanentky();
            case 5:
                return zakaznik.getPlatnaOd();
            case 6:
                return zakaznik.getPlatnaDo();
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
