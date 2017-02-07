package sk.upjs.ics.paz1c.fitnesscentrum.manager.impl;

import java.util.List;
import sk.upjs.ics.paz1c.fitnesscentrum.ObjectFactory;
import sk.upjs.ics.paz1c.fitnesscentrum.manager.RezervaciaManager;
import sk.upjs.ics.paz1c.fitnesscentrum.dao.RezervaciaDao;
import sk.upjs.ics.paz1c.fitnesscentrum.entity.Cvicenie;
import sk.upjs.ics.paz1c.fitnesscentrum.entity.Rezervacia;
import sk.upjs.ics.paz1c.fitnesscentrum.entity.Spinning;

public class DefaultRezervaciaManager implements RezervaciaManager {

    private final RezervaciaDao rezervaciaDao = ObjectFactory.INSTANCE.getRezervaciaDao();

    @Override
    public Rezervacia dajRezervaciuSId(Long idRezervacie) {
        return rezervaciaDao.dajRezervaciuSId(idRezervacie);
    }

    @Override
    public List<Rezervacia> dajRezervacieCvicenia(Cvicenie cvicenie) {
        return rezervaciaDao.dajRezervacieCvicenia(cvicenie);
    }

   
   

}
