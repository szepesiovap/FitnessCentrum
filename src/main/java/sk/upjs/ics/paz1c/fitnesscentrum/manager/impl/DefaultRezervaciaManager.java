package sk.upjs.ics.paz1c.fitnesscentrum.manager.impl;

import sk.upjs.ics.paz1c.fitnesscentrum.ObjectFactory;
import sk.upjs.ics.paz1c.fitnesscentrum.manager.RezervaciaManager;
import sk.upjs.ics.paz1c.fitnesscentrum.dao.RezervaciaDao;
import sk.upjs.ics.paz1c.fitnesscentrum.entity.Rezervacia;

public class DefaultRezervaciaManager implements RezervaciaManager {

    private final RezervaciaDao rezervaciaDao = ObjectFactory.INSTANCE.getRezervaciaDao();

    @Override
    public Rezervacia dajRezervaciuSId(Long idRezervacie) {
        return rezervaciaDao.dajRezervaciuSId(idRezervacie);
    }

}
