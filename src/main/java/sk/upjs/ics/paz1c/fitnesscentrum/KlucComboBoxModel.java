package sk.upjs.ics.paz1c.fitnesscentrum;

import java.util.List;
import javax.swing.DefaultComboBoxModel;
import sk.upjs.ics.paz1c.fitnesscentrum.dao.KlucDao;
import sk.upjs.ics.paz1c.fitnesscentrum.entity.Kluc;

public class KlucComboBoxModel extends DefaultComboBoxModel<Kluc> {

    private KlucDao klucDao = DaoFactory.INSTANCE.getKlucDao();
    private List<Kluc> volneKluce;

    public KlucComboBoxModel() {
        aktualizuj();
    }

    public void aktualizuj() {
        removeAllElements();
        volneKluce = klucDao.dajVolneKluce();
        for (Kluc kluc : volneKluce) {
            addElement(kluc);
        }
    }

}
