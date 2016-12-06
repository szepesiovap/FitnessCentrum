package sk.upjs.ics.paz1c.fitnesscentrum;

import java.util.List;
import javax.swing.DefaultComboBoxModel;
import sk.upjs.ics.paz1c.fitnesscentrum.dao.InstruktorDao;
import sk.upjs.ics.paz1c.fitnesscentrum.entity.Instruktor;

public class InstruktorComboBoxModel extends DefaultComboBoxModel<Instruktor> {

    private final InstruktorDao instruktorDao;
    private List<Instruktor> instruktori;

    public InstruktorComboBoxModel() {
        instruktorDao = ObjectFactory.INSTANCE.getInstruktorDao();
        aktualizuj();
    }

    public void aktualizuj() {
        removeAllElements();
        instruktori = instruktorDao.dajVsetychInstruktorov();
        for (Instruktor instruktor : instruktori) {
            addElement(instruktor);
        }
    }
}
