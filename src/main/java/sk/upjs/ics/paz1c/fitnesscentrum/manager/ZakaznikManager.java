package sk.upjs.ics.paz1c.fitnesscentrum.manager;

import java.util.List;
import org.springframework.dao.DuplicateKeyException;
import sk.upjs.ics.paz1c.fitnesscentrum.entity.Kluc;
import sk.upjs.ics.paz1c.fitnesscentrum.entity.Zakaznik;
import sk.upjs.ics.paz1c.fitnesscentrum.exception.NedostatocnyKreditException;
import sk.upjs.ics.paz1c.fitnesscentrum.exception.NeexistujuciZakaznikException;
import sk.upjs.ics.paz1c.fitnesscentrum.exception.PrazdneCisloPermanentkyException;
import sk.upjs.ics.paz1c.fitnesscentrum.exception.PrazdnyRetazecException;
import sk.upjs.ics.paz1c.fitnesscentrum.exception.PritomnyZakaznikException;

public interface ZakaznikManager {

    public void zmazZakaznika(Zakaznik zakaznik) throws PritomnyZakaznikException;

    public void odchodZakaznika(Long idZakaznika);

    public Zakaznik dajZakaznikaSCislomPermanentky(String cisloPermanentky) throws NeexistujuciZakaznikException;

    public void pridajZakaznika(Zakaznik zakaznik) throws DuplicateKeyException,PrazdnyRetazecException,PrazdneCisloPermanentkyException;

    public Zakaznik dajZakaznikaSId(Long idZakaznika);

    public void prichodZakaznika(Zakaznik zakaznik, Kluc kluc);

    public void prichodKartouZakaznika(Zakaznik zakaznik, Kluc kluc) throws NedostatocnyKreditException;

    public List<Zakaznik> dajVsetkychZakaznikov();

    public List<Zakaznik> dajPritomnychZakaznikov();

    public List<Zakaznik> dajZakaznikovSoZhodouVMene(String vzorka);

}
