package sk.upjs.ics.paz1c.fitnesscentrum.manager.impl;

import java.util.List;
import org.springframework.dao.DuplicateKeyException;
import sk.upjs.ics.paz1c.fitnesscentrum.ObjectFactory;
import sk.upjs.ics.paz1c.fitnesscentrum.dao.NavstevaDao;
import sk.upjs.ics.paz1c.fitnesscentrum.dao.UdalostDao;
import sk.upjs.ics.paz1c.fitnesscentrum.entity.Kluc;
import sk.upjs.ics.paz1c.fitnesscentrum.entity.Navsteva;
import sk.upjs.ics.paz1c.fitnesscentrum.entity.Zakaznik;
import sk.upjs.ics.paz1c.fitnesscentrum.exception.NedostatocnyKreditException;
import sk.upjs.ics.paz1c.fitnesscentrum.exception.PrazdnyRetazecException;

public class LoggingZakaznikManager extends DefaultZakaznikManager {

    private final NavstevaDao navstevaDao = ObjectFactory.INSTANCE.getNavstevaDao();
    private final UdalostDao udalostDao = ObjectFactory.INSTANCE.getUdalostDao();
    
    @Override
    public void prichodZakaznika(Zakaznik zakaznik, Kluc kluc) {
        navstevaDao.registrujPrichod(zakaznik, kluc);
        super.prichodZakaznika(zakaznik, kluc);
    }

    @Override
    public void prichodKartouZakaznika(Zakaznik zakaznik, Kluc kluc) throws NedostatocnyKreditException {
        navstevaDao.registrujPrichod(zakaznik, kluc);
        super.prichodKartouZakaznika(zakaznik, kluc);
    }

    @Override
    public void odchodZakaznika(Long idZakaznika) {
        navstevaDao.registrujOdchod(idZakaznika);
        super.odchodZakaznika(idZakaznika);
    }

    @Override
    public void pridajZakaznika(Zakaznik zakaznik) throws DuplicateKeyException, PrazdnyRetazecException {
        super.pridajZakaznika(zakaznik);
        if ((zakaznik.getCisloPermanentky() != null) && (!zakaznik.getCisloPermanentky().equals("")))  {
            udalostDao.pridajUdalost(zakaznik, "kredit+", zakaznik.getKredit() + "");
        }
    }
    
    public List<Navsteva> dajNavstevyZakaznika(Zakaznik zakaznik) {
        return navstevaDao.dajVsetkyNavstevyZakaznika(zakaznik);
    }
    
    
}
