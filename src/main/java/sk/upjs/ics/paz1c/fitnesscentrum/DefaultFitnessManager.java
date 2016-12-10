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

public class DefaultFitnessManager implements FitnessManager {

    private final KlucDao klucDao = ObjectFactory.INSTANCE.getKlucDao();
    private final ZakaznikDao zakaznikDao = ObjectFactory.INSTANCE.getZakaznikDao();
    private final SpinningDao spinningDao = ObjectFactory.INSTANCE.getSpinningDao();
    private final RezervaciaDao rezervaciaDao = ObjectFactory.INSTANCE.getRezervaciaDao();
    private final InstruktorDao instruktorDao = ObjectFactory.INSTANCE.getInstruktorDao();

    @Override
    public void zmazZakaznika(Zakaznik zakaznik) throws PritomnyZakaznikException {
        if (!zakaznik.isPritomny()) {
            zakaznikDao.vymazZakaznika(zakaznik);
        } else {
            throw new PritomnyZakaznikException();
        }
    }

    @Override
    public void odchodZakaznika(Long idZakaznika) {
        Zakaznik zakaznik = dajZakaznikaSId(idZakaznika);
        Kluc kluc = klucDao.dajKlucSId(zakaznik.getKluc().getId());
        klucDao.odoberZakaznika(kluc);
        zakaznikDao.odchod(zakaznik);
    }

    @Override
    public void dobitKredit(Zakaznik zakaznik, double kredit) {
        zakaznikDao.dobiKreditZakaznikovi(zakaznik, kredit);
    }

    @Override
    public Zakaznik dajZakaznikaSCislomPermanentky(String cisloPermanentky) throws NeexistujuciZakaznikException {
        return zakaznikDao.dajZakaznikaSCislomPermanentky(cisloPermanentky);
    }

    @Override
    public void pridajZakaznika(Zakaznik zakaznik) throws DuplicateKeyException {
        zakaznikDao.pridajZakaznika(zakaznik);
    }

    @Override
    public Zakaznik dajZakaznikaSId(Long idZakaznika) {
        return zakaznikDao.dajZakaznikaSId(idZakaznika);
    }

    @Override
    public void prichodZakaznika(Zakaznik zakaznik, Kluc kluc) {
        zakaznikDao.prichod(zakaznik, kluc);
        klucDao.priradZakaznika(kluc, zakaznik);
    }

    @Override
    public void prichodKartouZakaznika(Zakaznik zakaznik, Kluc kluc) throws NedostatocnyKreditException {
        double SUMA = ObjectFactory.INSTANCE.getVstupneDao().dajCeny().getCenaVstupneho();
        if (zakaznik.getKredit() <= SUMA) {
            throw new NedostatocnyKreditException();
        } else {
            zakaznikDao.stiahniKreditZakaznikovi(zakaznik, SUMA);
            zakaznikDao.prichod(zakaznik, kluc);
            klucDao.priradZakaznika(kluc, zakaznik);
        }
    }

    @Override
    public void rezervovatSpinning(Rezervacia rezervacia) {
        rezervaciaDao.pridajRezervaciu(rezervacia);
        spinningDao.rezervujSpinning(rezervacia.getSpinning());
    }

    @Override
    public void rezervovatSpinningKartou(Spinning spinning, Zakaznik zakaznik) throws NedostatocnyKreditException {
        double SUMA = ObjectFactory.INSTANCE.getVstupneDao().dajCeny().getCenaSpinnigu();
        if (zakaznik.getKredit() <= SUMA) {
            throw new NedostatocnyKreditException();
        } else {
            Rezervacia rezervacia = new Rezervacia();
            rezervacia.setSpinning(spinning);
            rezervacia.setZakaznik(zakaznik);
            rezervacia.setCasRezervacie(LocalDateTime.now());
            spinningDao.rezervujSpinning(spinning);
            zakaznikDao.stiahniKreditZakaznikovi(zakaznik, SUMA);
            rezervaciaDao.pridajRezervaciu(rezervacia);
        }
    }

    @Override
    public void pridajSpinning(Spinning spinning) {
        spinningDao.pridajSpinning(spinning);
    }

    @Override
    public void pridajInstruktora(Instruktor instruktor) {
        instruktorDao.pridajInstruktora(instruktor);
    }

    @Override
    public Rezervacia dajRezervaciuSId(Long idRezervacie) {
        return rezervaciaDao.dajRezervaciuSId(idRezervacie);
    }

    @Override
    public void odhlasitZoSpinningu(Rezervacia rezervacia, Spinning spinning) {
        rezervaciaDao.odstranRezervacia(rezervacia);
        spinningDao.odrezervujSpinning(spinning);
    }

    @Override
    public Spinning dajSpinningSId(Long idSpinningu) {
        return spinningDao.dajSpinningSId(idSpinningu);
    }

    @Override
    public void vymazSpinning(Spinning spinning) {
        spinningDao.vymazSpinning(spinning);
    }

}
