package sk.upjs.ics.paz1c.fitnesscentrum;

import org.springframework.dao.DuplicateKeyException;
import sk.upjs.ics.paz1c.fitnesscentrum.dao.KreditDao;
import sk.upjs.ics.paz1c.fitnesscentrum.entity.Kredit;
import sk.upjs.ics.paz1c.fitnesscentrum.exception.NevalidnyVstupException;

public class KreditManager {

    private final KreditDao kreditDao = ObjectFactory.INSTANCE.getKreditDao();

    public Kredit dajKreditSId(Long idKredit) {
        return kreditDao.dajKreditSId(idKredit);
    }

    public void vymazKredit(Long idKredit) {
        kreditDao.vymazKredit(idKredit);
    }

    public void pridajKredit(Kredit kredit) {
        
        kreditDao.pridajKredit(kredit);
    }

    public void ulozitKredit(Kredit kredit) throws DuplicateKeyException {
        kreditDao.pridajKredit(kredit);
    }

}
