package sk.upjs.ics.paz1c.fitnesscentrum;

import java.time.LocalDateTime;
import org.springframework.dao.DuplicateKeyException;
import sk.upjs.ics.paz1c.fitnesscentrum.dao.InstruktorDao;
import sk.upjs.ics.paz1c.fitnesscentrum.dao.KlucDao;
import sk.upjs.ics.paz1c.fitnesscentrum.dao.RezervaciaDao;
import sk.upjs.ics.paz1c.fitnesscentrum.dao.SpinningDao;
import sk.upjs.ics.paz1c.fitnesscentrum.dao.ZakaznikDao;
import sk.upjs.ics.paz1c.fitnesscentrum.entity.Instruktor;
import sk.upjs.ics.paz1c.fitnesscentrum.entity.Kluc;
import sk.upjs.ics.paz1c.fitnesscentrum.entity.Rezervacia;
import sk.upjs.ics.paz1c.fitnesscentrum.entity.Spinning;
import sk.upjs.ics.paz1c.fitnesscentrum.entity.Zakaznik;
import sk.upjs.ics.paz1c.fitnesscentrum.exception.NedostatocnyKreditException;
import sk.upjs.ics.paz1c.fitnesscentrum.exception.NeexistujuciZakaznikException;
import sk.upjs.ics.paz1c.fitnesscentrum.exception.PritomnyZakaznikException;

public interface FitnessManager {

    public void zmazZakaznika(Zakaznik zakaznik) throws PritomnyZakaznikException;

    public void odchodZakaznika(Long idZakaznika);

    public void dobitKredit(Zakaznik zakaznik, double kredit);

    public Zakaznik dajZakaznikaSCislomPermanentky(String cisloPermanentky) throws NeexistujuciZakaznikException;

    public void pridajZakaznika(Zakaznik zakaznik) throws DuplicateKeyException;

    public Zakaznik dajZakaznikaSId(Long idZakaznika);

    public void prichodZakaznika(Zakaznik zakaznik, Kluc kluc);

    public void prichodKartouZakaznika(Zakaznik zakaznik, Kluc kluc) throws NedostatocnyKreditException;

    public void rezervovatSpinning(Rezervacia rezervacia);

    public void rezervovatSpinningKartou(Spinning spinning, Zakaznik zakaznik) throws NedostatocnyKreditException;

    public void pridajSpinning(Spinning spinning);

    public void pridajInstruktora(Instruktor instruktor);

    public Rezervacia dajRezervaciuSId(Long idRezervacie);

    public void odhlasitZoSpinningu(Rezervacia rezervacia, Spinning spinning);

    public Spinning dajSpinningSId(Long idSpinningu);

    public void vymazSpinning(Spinning spinning);

}
