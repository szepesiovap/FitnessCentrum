package sk.upjs.ics.paz1c.fitnesscentrum;

import org.springframework.dao.DuplicateKeyException;
import sk.upjs.ics.paz1c.fitnesscentrum.dao.KlucDao;
import sk.upjs.ics.paz1c.fitnesscentrum.entity.Kluc;
import sk.upjs.ics.paz1c.fitnesscentrum.exception.ObsadenyKlucException;
import sk.upjs.ics.paz1c.fitnesscentrum.exception.PrazdnyRetazecException;

public class KlucManager {

    private final KlucDao klucDao = ObjectFactory.INSTANCE.getKlucDao();

    public Kluc dajKlucSId(Long idKluca) {
        return klucDao.dajKlucSId(idKluca);
    }

    public void pridajKluc(String menoKluca) throws PrazdnyRetazecException, DuplicateKeyException {
        Kluc kluc = new Kluc();
        if (!("").equals(menoKluca)) {
            kluc.setMeno(menoKluca);
            kluc.setZakaznik(null);
        } else {
            throw new PrazdnyRetazecException();
        }
        klucDao.pridajKluc(kluc);
    }

    public void vymazKluc(Kluc kluc) throws ObsadenyKlucException {
        if (kluc.getZakaznik() == null) {
            klucDao.vymazKluc(kluc);
        } else {
            throw new ObsadenyKlucException();
        }
    }
}
