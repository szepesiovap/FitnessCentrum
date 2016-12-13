package sk.upjs.ics.paz1c.fitnesscentrum.model;

import java.util.ArrayList;
import java.util.List;
import sk.upjs.ics.paz1c.fitnesscentrum.entity.Zakaznik;
import javax.swing.table.AbstractTableModel;
import sk.upjs.ics.paz1c.fitnesscentrum.ObjectFactory;
import sk.upjs.ics.paz1c.fitnesscentrum.manager.ZakaznikManager;

public class PritomniZakazniciTableModel extends AbstractTableModel {

    private final ZakaznikManager zakaznikManager = ObjectFactory.INSTANCE.getZakaznikManager();
    private static final String[] NAZVY_STLPCOV = {"Meno", "Kľúč", "Čas príchodu", "Číslo permanentky"};
    private static final int POCET_STLPCOV = NAZVY_STLPCOV.length;
    private List<Zakaznik> listPritomnychZakaznikov = new ArrayList<>();

    public PritomniZakazniciTableModel() {
        aktualizovat();
    }
    
    @Override
    public int getRowCount() {
        return listPritomnychZakaznikov.size();
    }

    @Override
    public int getColumnCount() {
        return POCET_STLPCOV;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Zakaznik zakaznik = listPritomnychZakaznikov.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return zakaznik.getMeno();
            case 1:
                return zakaznik.getKluc();
            case 2:
                return zakaznik.getPoslednyPrichod().toLocalDate() + " " + zakaznik.getPoslednyPrichod().toLocalTime();
            case 3:
                return zakaznik.getCisloPermanentky();
            case 4:
                return zakaznik.getId();
            default:
                return "???";
        }
    }

    @Override
    public String getColumnName(int columnIndex) {
        return NAZVY_STLPCOV[columnIndex];
    }

    public void aktualizovat() {
        listPritomnychZakaznikov = zakaznikManager.dajPritomnychZakaznikov();
        fireTableDataChanged();
    }
}
