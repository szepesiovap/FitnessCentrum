package sk.upjs.ics.paz1c.fitnesscentrum.manager.impl;

import java.util.List;
import sk.upjs.ics.paz1c.fitnesscentrum.manager.KreditManager;
import org.springframework.dao.DuplicateKeyException;
import sk.upjs.ics.paz1c.fitnesscentrum.ObjectFactory;
import sk.upjs.ics.paz1c.fitnesscentrum.dao.KreditDao;
import sk.upjs.ics.paz1c.fitnesscentrum.dao.ZakaznikDao;
import sk.upjs.ics.paz1c.fitnesscentrum.entity.Kredit;
import sk.upjs.ics.paz1c.fitnesscentrum.entity.Zakaznik;

public class DefaultKreditManager implements KreditManager {

    private final KreditDao kreditDao = ObjectFactory.INSTANCE.getKreditDao();
    private final ZakaznikDao zakaznikDao = ObjectFactory.INSTANCE.getZakaznikDao();

    @Override
    public Kredit dajKreditSId(Long idKredit) {
        return kreditDao.dajKreditSId(idKredit);
    }

    @Override
    public void vymazKredit(Long idKredit) {
        kreditDao.vymazKredit(idKredit);
    }

    @Override
    public void ulozitKredit(Kredit kredit) throws DuplicateKeyException {
        kreditDao.pridajKredit(kredit);
    }

    @Override
    public void dobitKredit(Zakaznik zakaznik, double kredit) {
        zakaznikDao.dobiKreditZakaznikovi(zakaznik, kredit);
    }

    @Override
    public List<Kredit> dajVsetkyKredity() {
        return kreditDao.dajVsetkyKredity();
    }

}
