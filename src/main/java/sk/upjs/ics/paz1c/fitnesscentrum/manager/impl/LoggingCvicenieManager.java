package sk.upjs.ics.paz1c.fitnesscentrum.manager.impl;

import sk.upjs.ics.paz1c.fitnesscentrum.ObjectFactory;
import sk.upjs.ics.paz1c.fitnesscentrum.dao.TypCviceniaDao;
import sk.upjs.ics.paz1c.fitnesscentrum.dao.UdalostDao;
import sk.upjs.ics.paz1c.fitnesscentrum.entity.Cvicenie;
import sk.upjs.ics.paz1c.fitnesscentrum.entity.Rezervacia;
import sk.upjs.ics.paz1c.fitnesscentrum.entity.Zakaznik;
import sk.upjs.ics.paz1c.fitnesscentrum.exception.NedostatocnyKreditException;

public class LoggingCvicenieManager extends DefaultCvicenieManager {
    private final UdalostDao udalostDao = ObjectFactory.INSTANCE.getUdalostDao();
    private final TypCviceniaDao typCviceniaDao = ObjectFactory.INSTANCE.getTypCviceniaDao();
    
    @Override
    public void rezervovatCvicenie(Rezervacia rezervacia) {
        String nazov = typCviceniaDao.dajTypPodlaId(rezervacia.getCvicenie().getTypCvicenia()).getNazov();
        udalostDao.pridajUdalost(rezervacia.getZakaznik(), "cvicenie", nazov);
        super.rezervovatCvicenie(rezervacia);
    }

    @Override
    public void rezervovatCvicenieKartou(Cvicenie cvicenie, Zakaznik zakaznik) throws NedostatocnyKreditException {
        double cenaCvicenia = ObjectFactory.INSTANCE.getVstupneDao().dajCeny().getCenaCvicenia();
        udalostDao.pridajUdalost(zakaznik, "kredit-", cenaCvicenia + "");
        String nazov = typCviceniaDao.dajTypPodlaId(cvicenie.getTypCvicenia()).getNazov();
        udalostDao.pridajUdalost(zakaznik, "cvicenie", nazov);
        super.rezervovatCvicenieKartou(cvicenie, zakaznik);
    }
}
