package sk.upjs.ics.paz1c.fitnesscentrum.manager.impl;

import java.util.List;
import sk.upjs.ics.paz1c.fitnesscentrum.ObjectFactory;
import sk.upjs.ics.paz1c.fitnesscentrum.manager.InstruktorManager;
import sk.upjs.ics.paz1c.fitnesscentrum.dao.InstruktorDao;
import sk.upjs.ics.paz1c.fitnesscentrum.entity.Instruktor;
import sk.upjs.ics.paz1c.fitnesscentrum.exception.PrazdnyRetazecException;

public class DefaultInstruktorManager implements InstruktorManager {

    private final InstruktorDao instruktorDao = ObjectFactory.INSTANCE.getInstruktorDao();

    @Override
    public void pridajInstruktora(Instruktor instruktor) throws PrazdnyRetazecException{
        if (instruktor.getMeno().equals("")) {
            throw new PrazdnyRetazecException();
        }
        instruktorDao.pridajInstruktora(instruktor);
    }

    @Override
    public List<Instruktor> dajVsetychInstruktorov() {
        return instruktorDao.dajVsetychInstruktorov();
    }

}
