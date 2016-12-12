package sk.upjs.ics.paz1c.fitnesscentrum.model;

import java.util.List;
import javax.swing.DefaultComboBoxModel;
import sk.upjs.ics.paz1c.fitnesscentrum.ObjectFactory;
import sk.upjs.ics.paz1c.fitnesscentrum.entity.Kredit;
import sk.upjs.ics.paz1c.fitnesscentrum.manager.KreditManager;

public class KreditComboBoxModel extends DefaultComboBoxModel<Kredit> {

    private final KreditManager kreditManager = ObjectFactory.INSTANCE.getKreditManager();
    private List<Kredit> mozneKredity;

    public KreditComboBoxModel() {
        aktualizuj();
    }

    private void aktualizuj() {
        removeAllElements();
        mozneKredity = kreditManager.dajVsetkyKredity();
        for (Kredit kredit : mozneKredity) {
            addElement(kredit);
        }
    }
}
