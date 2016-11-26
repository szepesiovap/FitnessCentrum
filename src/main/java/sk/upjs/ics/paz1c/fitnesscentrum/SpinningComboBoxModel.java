package sk.upjs.ics.paz1c.fitnesscentrum;

import java.util.List;
import javax.swing.DefaultComboBoxModel;
import sk.upjs.ics.paz1c.fitnesscentrum.dao.SpinningDao;
import sk.upjs.ics.paz1c.fitnesscentrum.entity.Spinning;

public class SpinningComboBoxModel extends DefaultComboBoxModel<Spinning> {

    private final SpinningDao spinningDao;
    private List<Spinning> spinningy;

    public SpinningComboBoxModel() {
        spinningDao = DaoFactory.INSTANCE.getSpinningDao();
        aktualizuj();
    }

    public void aktualizuj() {
        removeAllElements();
        spinningy = spinningDao.dajVsetkySpinningy();
        for (Spinning spinning : spinningy) {
            addElement(spinning);
        }
    }
}
