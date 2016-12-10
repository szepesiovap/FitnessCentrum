package sk.upjs.ics.paz1c.fitnesscentrum.manager.impl;

import sk.upjs.ics.paz1c.fitnesscentrum.ObjectFactory;
import sk.upjs.ics.paz1c.fitnesscentrum.manager.InstruktorManager;
import sk.upjs.ics.paz1c.fitnesscentrum.dao.InstruktorDao;
import sk.upjs.ics.paz1c.fitnesscentrum.dao.KlucDao;
import sk.upjs.ics.paz1c.fitnesscentrum.dao.RezervaciaDao;
import sk.upjs.ics.paz1c.fitnesscentrum.dao.SpinningDao;
import sk.upjs.ics.paz1c.fitnesscentrum.dao.ZakaznikDao;
import sk.upjs.ics.paz1c.fitnesscentrum.entity.Instruktor;

public class DefaultInstruktorManager implements InstruktorManager {

    private final KlucDao klucDao = ObjectFactory.INSTANCE.getKlucDao();
    private final ZakaznikDao zakaznikDao = ObjectFactory.INSTANCE.getZakaznikDao();
    private final SpinningDao spinningDao = ObjectFactory.INSTANCE.getSpinningDao();
    private final RezervaciaDao rezervaciaDao = ObjectFactory.INSTANCE.getRezervaciaDao();
    private final InstruktorDao instruktorDao = ObjectFactory.INSTANCE.getInstruktorDao();

    @Override
    public void pridajInstruktora(Instruktor instruktor) {
        instruktorDao.pridajInstruktora(instruktor);
    }

}
