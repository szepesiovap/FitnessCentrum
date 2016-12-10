package sk.upjs.ics.paz1c.fitnesscentrum.manager;

import org.springframework.dao.DuplicateKeyException;
import sk.upjs.ics.paz1c.fitnesscentrum.entity.Kluc;
import sk.upjs.ics.paz1c.fitnesscentrum.exception.ObsadenyKlucException;
import sk.upjs.ics.paz1c.fitnesscentrum.exception.PrazdnyRetazecException;

public interface KlucManager {

    public Kluc dajKlucSId(Long idKluca);

    public void pridajKluc(String menoKluca) throws PrazdnyRetazecException, DuplicateKeyException;

    public void vymazKluc(Kluc kluc) throws ObsadenyKlucException;

}
