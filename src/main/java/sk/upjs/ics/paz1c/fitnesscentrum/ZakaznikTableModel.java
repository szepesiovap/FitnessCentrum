package sk.upjs.ics.paz1c.fitnesscentrum;

import sk.upjs.ics.paz1c.fitnesscentrum.entity.Zakaznik;
import javax.swing.table.AbstractTableModel;
import sk.upjs.ics.paz1c.fitnesscentrum.dao.ZakaznikDao;

public class ZakaznikTableModel extends AbstractTableModel {
    private ZakaznikDao zakaznikDao = DaoFactory.INSTANCE.getMySQLZakaznikDao();
    private static final String[] NAZVY_STLPCOV = {"ID", "Meno", "Pritomny", "Posledny prichod", "Kredit", "Cislo permanentky"};
    private static final int POCET_STLPCOV = NAZVY_STLPCOV.length;
    private String vzorka;
    
    public ZakaznikTableModel(String vzorka) {
      this.vzorka = vzorka;  
    }
    
    @Override
    public int getRowCount() {
        return zakaznikDao.dajZakaznikovSoZhodouVMene(vzorka).size();
    }

    @Override
    public int getColumnCount() {
        return POCET_STLPCOV;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Zakaznik zakaznik = zakaznikDao.dajZakaznikovSoZhodouVMene(vzorka).get(rowIndex);
        switch (columnIndex) {
            case 0:
                return zakaznik.getId();
            case 1:
                return zakaznik.getMeno();
            case 2:
                return zakaznik.isPritomny();
            case 3:
                return zakaznik.getPoslednyPrichod();
            case 4:
                return zakaznik.getKredit();
            case 5:
                return zakaznik.getCisloPermanentky();
            default:
                return "???";
        }
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        if (columnIndex == 2) {
            return Boolean.class;
        }
        return super.getColumnClass(columnIndex);
    }

    @Override
    public String getColumnName(int columnIndex) {
        return NAZVY_STLPCOV[columnIndex];
    }

    public void aktualizovat() {
        fireTableDataChanged();
    }
}
