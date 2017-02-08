package sk.upjs.ics.paz1c.fitnesscentrum.manager.impl;

import sk.upjs.ics.paz1c.fitnesscentrum.ObjectFactory;
import sk.upjs.ics.paz1c.fitnesscentrum.dao.UdalostDao;
import sk.upjs.ics.paz1c.fitnesscentrum.entity.Cvicenie;
import sk.upjs.ics.paz1c.fitnesscentrum.entity.Rezervacia;
import sk.upjs.ics.paz1c.fitnesscentrum.entity.Zakaznik;
import sk.upjs.ics.paz1c.fitnesscentrum.exception.NedostatocnyKreditException;

public class LoggingCvicenieManager extends DefaultCvicenieManager {
    private final UdalostDao udalostDao = ObjectFactory.INSTANCE.getUdalostDao();
    
    @Override
    public void rezervovatCvicenie(Rezervacia rezervacia) {
        // @todo: fix nazov typu cvicenia --> *dik* veronika [-_-]
        udalostDao.pridajUdalost(rezervacia.getZakaznik(), "cvicenie", rezervacia.getCvicenie().getTypCvicenia().toString());
        super.rezervovatCvicenie(rezervacia);
    }

    @Override
    public void rezervovatCvicenieKartou(Cvicenie cvicenie, Zakaznik zakaznik) throws NedostatocnyKreditException {
        double cenaCvicenia = ObjectFactory.INSTANCE.getVstupneDao().dajCeny().getCenaCvicenia();
        udalostDao.pridajUdalost(zakaznik, "kredit-", cenaCvicenia + "");
        udalostDao.pridajUdalost(zakaznik, "cvicenie", cvicenie.getTypCvicenia().toString());
        super.rezervovatCvicenieKartou(cvicenie, zakaznik);
    }
}
