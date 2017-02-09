package sk.upjs.ics.paz1c.fitnesscentrum.model;

import java.time.LocalDateTime;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import sk.upjs.ics.paz1c.fitnesscentrum.ObjectFactory;
import sk.upjs.ics.paz1c.fitnesscentrum.entity.Cvicenie;
import sk.upjs.ics.paz1c.fitnesscentrum.entity.Spinning;
import sk.upjs.ics.paz1c.fitnesscentrum.entity.TypCvicenia;
import sk.upjs.ics.paz1c.fitnesscentrum.manager.CvicenieManager;
import sk.upjs.ics.paz1c.fitnesscentrum.manager.SpinningManager;

public class CvicenieComboBoxModel extends DefaultComboBoxModel<Cvicenie> {

    private final CvicenieManager cvicenieManager = ObjectFactory.INSTANCE.getCvicenieManager();
    private List<Cvicenie> cvicenia;

    public CvicenieComboBoxModel() {
        aktualizovat();
    }

    public void aktualizovat() {
        removeAllElements();
        cvicenia = cvicenieManager.dajCviceniaOdDatumu(LocalDateTime.now());
        for (Cvicenie cvicenie : cvicenia) {
            addElement(cvicenie);
        }
    }

    public void aktualizovat(TypCvicenia typ) {
        removeAllElements();
        cvicenia = cvicenieManager.dajCviceniaOdDatumu(LocalDateTime.now());
        for (Cvicenie cvicenie : cvicenia) {
            if (cvicenie.getTypCvicenia().equals(typ.getId())) {
                addElement(cvicenie);
            }
        }
    }
}
