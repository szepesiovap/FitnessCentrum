package sk.upjs.ics.paz1c.fitnesscentrum.manager.impl;

import sk.upjs.ics.paz1c.fitnesscentrum.ObjectFactory;
import sk.upjs.ics.paz1c.fitnesscentrum.dao.VstupneDao;
import sk.upjs.ics.paz1c.fitnesscentrum.manager.VstupneManager;

public class DefaultVstupneManager implements VstupneManager {

    private final VstupneDao vstupneDao = ObjectFactory.INSTANCE.getVstupneDao();

    @Override
    public void updateCenaVstupneho(Double cena) {
       vstupneDao.updateCenaVstupneho(cena);
    }

    @Override
    public void updateCenaSpinningu(Double cena) {
        vstupneDao.updateCenaSpinningu(cena);
    }


}
