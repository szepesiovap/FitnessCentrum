package sk.upjs.ics.paz1c.fitnesscentrum.model;

import java.time.LocalDateTime;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import sk.upjs.ics.paz1c.fitnesscentrum.ObjectFactory;
import sk.upjs.ics.paz1c.fitnesscentrum.entity.Spinning;
import sk.upjs.ics.paz1c.fitnesscentrum.manager.SpinningManager;

public class SpinningComboBoxModel extends DefaultComboBoxModel<Spinning> {

    private final SpinningManager spinningManager = ObjectFactory.INSTANCE.getSpinningManager();
    private List<Spinning> spinningy;

    public SpinningComboBoxModel() {
        aktualizovat();
    }

    public void aktualizovat() {
        removeAllElements();
        spinningy = spinningManager.dajSpinningyOdDatumu(LocalDateTime.now());
        for (Spinning spinning : spinningy) {
            addElement(spinning);
        }
    }
}
