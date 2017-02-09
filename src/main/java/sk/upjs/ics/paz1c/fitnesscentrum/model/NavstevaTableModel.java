package sk.upjs.ics.paz1c.fitnesscentrum.model;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import sk.upjs.ics.paz1c.fitnesscentrum.ObjectFactory;
import sk.upjs.ics.paz1c.fitnesscentrum.entity.Navsteva;
import sk.upjs.ics.paz1c.fitnesscentrum.entity.Zakaznik;
import sk.upjs.ics.paz1c.fitnesscentrum.manager.impl.LoggingZakaznikManager;

public class NavstevaTableModel extends AbstractTableModel {

    private static final String[] NAZVY_STLPCOV = {"Čas", "Príchod", "Odchod", "Kľúč"};
    private static final int POCET_STLPCOV = NAZVY_STLPCOV.length;
    private List<Navsteva> zoznamNavstev = new ArrayList<>();
    LoggingZakaznikManager lzm = (LoggingZakaznikManager) ObjectFactory.INSTANCE.getZakaznikManager();
    private final Zakaznik zakaznik;
    
    public NavstevaTableModel(Zakaznik zakaznik) {
        this.zakaznik = zakaznik;
        aktualizovat();
    }
    
    @Override
    public int getRowCount() {
        return zoznamNavstev.size();
    }

    @Override
    public int getColumnCount() {
        return POCET_STLPCOV;
    }

    @Override
    public Object getValueAt(int i, int i1) {
        Navsteva n = zoznamNavstev.get(i);
        switch (i1) {
            case 0:
                LocalDateTime koniec = n.getOdchod();
                if (koniec == null) {koniec = LocalDateTime.now();}
                Long rozdiel = ChronoUnit.MINUTES.between(n.getPrichod(), koniec);
                String cas = rozdiel.toString();
                Long minuty = rozdiel;
                if (minuty <= 0) {
                    return "0";
                }
                if (minuty < 60) {
                    cas += " min.";
                } else {
                    int hours = (int)(minuty / 60);
                    int rem = (int) (minuty % 60);
                    cas = hours + " hod.";
                    cas += (rem != 0) ? " a " + rem +  " min." : "";
                }
                return cas;
            case 1:
                return n.getPrichod();
            case 2:
                return n.getOdchod();
            case 3:
                return n.getKluc().getMeno();
            default:
                return "???";
        }
    }
    
    private String preloz(long value, boolean hodiny) {
        if (hodiny) {
            if (value == 1) return "hodina";
            if (value < 5) return "hodiny";
            return "hodín";
        } else {
            if (value == 1) return "minúta";
            if (value < 5) return "minúty";
        }
        return "minút";
    }
    
    @Override
    public String getColumnName(int columnIndex) {
        return NAZVY_STLPCOV[columnIndex];
    }

    private void aktualizovat() {
        zoznamNavstev = lzm.dajNavstevyZakaznika(zakaznik);
    }
    
}
