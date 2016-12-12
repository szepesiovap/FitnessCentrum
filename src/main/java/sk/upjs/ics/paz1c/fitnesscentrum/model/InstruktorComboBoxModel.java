package sk.upjs.ics.paz1c.fitnesscentrum.model;

import java.util.List;
import javax.swing.DefaultComboBoxModel;
import sk.upjs.ics.paz1c.fitnesscentrum.ObjectFactory;
import sk.upjs.ics.paz1c.fitnesscentrum.entity.Instruktor;
import sk.upjs.ics.paz1c.fitnesscentrum.manager.InstruktorManager;

public class InstruktorComboBoxModel extends DefaultComboBoxModel<Instruktor> {

    private final InstruktorManager instruktorManager;
    private List<Instruktor> instruktori;

    public InstruktorComboBoxModel() {
        instruktorManager = ObjectFactory.INSTANCE.getInstruktorManager();
        aktualizuj();
    }

    public void aktualizuj() {
        removeAllElements();
        instruktori = instruktorManager.dajVsetychInstruktorov();
        for (Instruktor instruktor : instruktori) {
            addElement(instruktor);
        }
    }
}
