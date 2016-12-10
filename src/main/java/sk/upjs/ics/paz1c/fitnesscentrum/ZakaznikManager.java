package sk.upjs.ics.paz1c.fitnesscentrum;

import javax.swing.JOptionPane;
import sk.upjs.ics.paz1c.fitnesscentrum.dao.ZakaznikDao;
import sk.upjs.ics.paz1c.fitnesscentrum.entity.Zakaznik;
import sk.upjs.ics.paz1c.fitnesscentrum.form.PotvrditPrichodZakaznikaForm;

public class ZakaznikManager {

    private final ZakaznikDao zakaznikDao = ObjectFactory.INSTANCE.getZakaznikDao();

    public void prichodZakaznika() {
    }
}
