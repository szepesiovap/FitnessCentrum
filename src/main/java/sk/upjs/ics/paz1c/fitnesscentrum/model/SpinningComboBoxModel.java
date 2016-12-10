package sk.upjs.ics.paz1c.fitnesscentrum.model;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import sk.upjs.ics.paz1c.fitnesscentrum.ObjectFactory;
import sk.upjs.ics.paz1c.fitnesscentrum.ObjectFactory;
import sk.upjs.ics.paz1c.fitnesscentrum.dao.SpinningDao;
import sk.upjs.ics.paz1c.fitnesscentrum.entity.Spinning;

public class SpinningComboBoxModel extends DefaultComboBoxModel<Spinning> {
    
    private final SpinningDao spinningDao;
    private List<Spinning> spinningy;
    
    public SpinningComboBoxModel() {
        spinningDao = ObjectFactory.INSTANCE.getSpinningDao();
        aktualizovat();
    }
    
    public void aktualizovat() {
        removeAllElements();
        spinningy = spinningDao.dajSpinningyOdDatumu(LocalDateTime.now());
        for (Spinning spinning : spinningy) {
            addElement(spinning);
        }
    }
}
