package sk.upjs.ics.paz1c.fitnesscentrum.model;

import java.util.ArrayList;
import java.util.List;
import sk.upjs.ics.paz1c.fitnesscentrum.entity.Zakaznik;
import javax.swing.table.AbstractTableModel;
import sk.upjs.ics.paz1c.fitnesscentrum.ObjectFactory;
import sk.upjs.ics.paz1c.fitnesscentrum.manager.ZakaznikManager;

public class ZakaznikTableModel extends AbstractTableModel {

    private final ZakaznikManager zakaznikManager = ObjectFactory.INSTANCE.getZakaznikManager();
    private static final String[] NAZVY_STLPCOV = {"Meno", "Prítomný", "Posledný príchod", "Kredit", "Číslo permanentky"};
    private static final int POCET_STLPCOV = NAZVY_STLPCOV.length;
    private final String vzorka;
    private List<Zakaznik> listZakaznikovSoVzorkou = new ArrayList<>();

    public ZakaznikTableModel(String vzorka) {
        this.vzorka = vzorka;
        aktualizovat();
    }

    @Override
    public int getRowCount() {
        return listZakaznikovSoVzorkou.size();
    }

    @Override
    public int getColumnCount() {
        return POCET_STLPCOV;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Zakaznik zakaznik = listZakaznikovSoVzorkou.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return zakaznik.getMeno();
            case 1:
                return zakaznik.isPritomny();
            case 2:
                return zakaznik.getPoslednyPrichod().toLocalDate() + " " + zakaznik.getPoslednyPrichod().toLocalTime();
            case 3:
                return zakaznik.getKredit();
            case 4:
                return zakaznik.getCisloPermanentky();
            case 5:
                return zakaznik.getId();
            default:
                return "???";
        }
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        if (columnIndex == 1) {
            return Boolean.class;
        }
        return super.getColumnClass(columnIndex);
    }

    @Override
    public String getColumnName(int columnIndex) {
        return NAZVY_STLPCOV[columnIndex];
    }

    public void aktualizovat() {
        listZakaznikovSoVzorkou = zakaznikManager.dajZakaznikovSoZhodouVMene(vzorka);
        fireTableDataChanged();
    }
}
