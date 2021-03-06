package sk.upjs.ics.paz1c.fitnesscentrum.manager.impl;

import sk.upjs.ics.paz1c.fitnesscentrum.ObjectFactory;
import sk.upjs.ics.paz1c.fitnesscentrum.dao.VstupneDao;
import sk.upjs.ics.paz1c.fitnesscentrum.entity.Vstupne;
import sk.upjs.ics.paz1c.fitnesscentrum.manager.VstupneManager;

public class DefaultVstupneManager implements VstupneManager {

    private final VstupneDao vstupneDao = ObjectFactory.INSTANCE.getVstupneDao();

    @Override
    public void nastavCeny(double cenaVstupneho, double cenaSpinningu) {
        vstupneDao.updateCenaVstupneho(cenaVstupneho);
        vstupneDao.updateCenaSpinningu(cenaSpinningu);
    }

    @Override
    public Vstupne dajCeny() {
        return vstupneDao.dajCeny();
    }
}
