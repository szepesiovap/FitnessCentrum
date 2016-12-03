package sk.upjs.ics.paz1c.fitnesscentrum;

import java.util.List;
import javax.swing.DefaultComboBoxModel;
import sk.upjs.ics.paz1c.fitnesscentrum.dao.KreditDao;
import sk.upjs.ics.paz1c.fitnesscentrum.entity.Kredit;

public class KreditComboBoxModel extends DefaultComboBoxModel<Kredit> {

    private final KreditDao kreditDao;
    private List<Kredit> mozneKredity;

    public KreditComboBoxModel() {
        kreditDao = DaoFactory.INSTANCE.getKreditDao();
        aktualizuj();
    }

    private void aktualizuj() {
        removeAllElements();
        mozneKredity = kreditDao.dajVsetkyKredity();
        for (Kredit kredit : mozneKredity) {
            addElement(kredit);
        }
    }
}
