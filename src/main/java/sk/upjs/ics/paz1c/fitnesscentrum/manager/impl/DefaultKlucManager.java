package sk.upjs.ics.paz1c.fitnesscentrum.manager.impl;

import java.util.List;
import sk.upjs.ics.paz1c.fitnesscentrum.manager.KlucManager;
import org.springframework.dao.DuplicateKeyException;
import sk.upjs.ics.paz1c.fitnesscentrum.ObjectFactory;
import sk.upjs.ics.paz1c.fitnesscentrum.dao.KlucDao;
import sk.upjs.ics.paz1c.fitnesscentrum.entity.Kluc;
import sk.upjs.ics.paz1c.fitnesscentrum.exception.ObsadenyKlucException;
import sk.upjs.ics.paz1c.fitnesscentrum.exception.PrazdnyRetazecException;

public class DefaultKlucManager implements KlucManager {

    private final KlucDao klucDao = ObjectFactory.INSTANCE.getKlucDao();

    @Override
    public Kluc dajKlucSId(Long idKluca) {
        return klucDao.dajKlucSId(idKluca);
    }

    @Override
    public void pridajKluc(String menoKluca) throws PrazdnyRetazecException, DuplicateKeyException {
        Kluc kluc = new Kluc();
        if (!("").equals(menoKluca)) {
            kluc.setMeno(menoKluca);
        } else {
            throw new PrazdnyRetazecException();
        }
        klucDao.pridajKluc(kluc);
    }

    @Override
    public void vymazKluc(Kluc kluc) throws ObsadenyKlucException {
        if (kluc.getZakaznik() == null) {
            klucDao.vymazKluc(kluc);
        } else {
            throw new ObsadenyKlucException();
        }
    }

    @Override
    public List<Kluc> dajVolneKluce() {
        return klucDao.dajVolneKluce();
    }

    @Override
    public List<Kluc> dajVsetkyKluce() {
        return klucDao.dajVsetkyKluce();
    }
}
