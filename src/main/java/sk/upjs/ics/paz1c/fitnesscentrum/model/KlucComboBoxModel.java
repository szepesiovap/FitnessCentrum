package sk.upjs.ics.paz1c.fitnesscentrum.model;

import java.util.List;
import javax.swing.DefaultComboBoxModel;
import sk.upjs.ics.paz1c.fitnesscentrum.ObjectFactory;
import sk.upjs.ics.paz1c.fitnesscentrum.entity.Kluc;
import sk.upjs.ics.paz1c.fitnesscentrum.manager.KlucManager;

public class KlucComboBoxModel extends DefaultComboBoxModel<Kluc> {

    private final KlucManager klucManager = ObjectFactory.INSTANCE.getKlucManager();
    private List<Kluc> volneKluce;

    public KlucComboBoxModel() {
        aktualizuj();
    }

    public void aktualizuj() {
        removeAllElements();
        volneKluce = klucManager.dajVolneKluce();
        for (Kluc kluc : volneKluce) {
            addElement(kluc);
        }
    }

}
