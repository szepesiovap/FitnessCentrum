package sk.upjs.ics.paz1c.fitnesscentrum.manager.impl;

import java.util.List;
import sk.upjs.ics.paz1c.fitnesscentrum.manager.ZakaznikManager;
import org.springframework.dao.DuplicateKeyException;
import sk.upjs.ics.paz1c.fitnesscentrum.ObjectFactory;
import sk.upjs.ics.paz1c.fitnesscentrum.dao.KlucDao;
import sk.upjs.ics.paz1c.fitnesscentrum.dao.ZakaznikDao;
import sk.upjs.ics.paz1c.fitnesscentrum.entity.Kluc;
import sk.upjs.ics.paz1c.fitnesscentrum.entity.Zakaznik;
import sk.upjs.ics.paz1c.fitnesscentrum.exception.NedostatocnyKreditException;
import sk.upjs.ics.paz1c.fitnesscentrum.exception.NeexistujuciZakaznikException;
import sk.upjs.ics.paz1c.fitnesscentrum.exception.PrazdnyRetazecException;
import sk.upjs.ics.paz1c.fitnesscentrum.exception.PritomnyZakaznikException;

public class DefaultZakaznikManager implements ZakaznikManager {

    private final KlucDao klucDao = ObjectFactory.INSTANCE.getKlucDao();
    private final ZakaznikDao zakaznikDao = ObjectFactory.INSTANCE.getZakaznikDao();

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
    public Zakaznik dajZakaznikaSCislomPermanentky(String cisloPermanentky) throws NeexistujuciZakaznikException {
        return zakaznikDao.dajZakaznikaSCislomPermanentky(cisloPermanentky);
    }

    @Override
    public void pridajZakaznika(Zakaznik zakaznik) throws DuplicateKeyException, PrazdnyRetazecException {
        if ((zakaznik.getCisloPermanentky() != null) && (zakaznik.getCisloPermanentky().equals("")))  {
            throw new PrazdnyRetazecException("Zadaj číslo permanentky!");
        } else if (zakaznik.getMeno().equals("")) {
            throw new PrazdnyRetazecException("Zadaj meno!");
        }
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
        double SUMA = ObjectFactory.INSTANCE.getVstupneManager().dajCeny().getCenaVstupneho();
        if (zakaznik.getKredit() < SUMA) {
            throw new NedostatocnyKreditException();
        } else {
            zakaznikDao.stiahniKreditZakaznikovi(zakaznik, SUMA);
            zakaznikDao.prichod(zakaznik, kluc);
            klucDao.priradZakaznika(kluc, zakaznik);
        }
    }

    @Override
    public List<Zakaznik> dajVsetkychZakaznikov() {
        return zakaznikDao.dajVsetkychZakaznikov();
    }

    @Override
    public List<Zakaznik> dajPritomnychZakaznikov() {
        return zakaznikDao.dajPritomnychZakaznikov();
    }

    @Override
    public List<Zakaznik> dajZakaznikovSoZhodouVMene(String vzorka) {
        return zakaznikDao.dajZakaznikovSoZhodouVMene(vzorka);
    }

}
