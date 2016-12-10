package sk.upjs.ics.paz1c.fitnesscentrum.model;

import java.util.List;
import javax.swing.DefaultComboBoxModel;
import sk.upjs.ics.paz1c.fitnesscentrum.ObjectFactory;
import sk.upjs.ics.paz1c.fitnesscentrum.dao.KlucDao;
import sk.upjs.ics.paz1c.fitnesscentrum.entity.Kluc;

public class KlucComboBoxModel extends DefaultComboBoxModel<Kluc> {

    private final KlucDao klucDao;
    private List<Kluc> volneKluce;

    public KlucComboBoxModel() {
        klucDao = ObjectFactory.INSTANCE.getKlucDao();
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