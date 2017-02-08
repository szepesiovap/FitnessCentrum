package sk.upjs.ics.paz1c.fitnesscentrum.manager.impl;

import sk.upjs.ics.paz1c.fitnesscentrum.ObjectFactory;
import sk.upjs.ics.paz1c.fitnesscentrum.dao.UdalostDao;
import sk.upjs.ics.paz1c.fitnesscentrum.entity.Zakaznik;

public class LoggingKreditManager extends DefaultKreditManager {
    
    private final UdalostDao udalostDao = ObjectFactory.INSTANCE.getUdalostDao();
    
    @Override
    public void dobitKredit(Zakaznik zakaznik, double kredit) {
        udalostDao.pridajUdalost(zakaznik, "kredit+", kredit + "");
        super.dobitKredit(zakaznik, kredit);
    }
    
}
