package sk.upjs.ics.paz1c.fitnesscentrum.manager.impl;

import org.junit.Test;
import static org.junit.Assert.*;
import sk.upjs.ics.paz1c.fitnesscentrum.ObjectFactory;
import sk.upjs.ics.paz1c.fitnesscentrum.dao.InstruktorDao;
import sk.upjs.ics.paz1c.fitnesscentrum.dao.impl.PripravaNaTestovanie;
import sk.upjs.ics.paz1c.fitnesscentrum.entity.Instruktor;
import sk.upjs.ics.paz1c.fitnesscentrum.exception.PrazdnyRetazecException;
import sk.upjs.ics.paz1c.fitnesscentrum.manager.InstruktorManager;

public class DefaultInstruktorManagerTest extends PripravaNaTestovanie {

    private final InstruktorManager instruktorManager = ObjectFactory.INSTANCE.getInstruktorManager();
    private final InstruktorDao instruktorDao = ObjectFactory.INSTANCE.getInstruktorDao();

    /**
     * Test of pridajInstruktora method, of class DefaultInstruktorManager.
     */
    @Test
    public void testPridajInstruktora() throws PrazdnyRetazecException{
        int povodnaSize = instruktorDao.dajVsetychInstruktorov().size();
        Instruktor instruktor = new Instruktor();
        instruktor.setMeno("Maros");
        instruktorManager.pridajInstruktora(instruktor);
        int novaSize = instruktorDao.dajVsetychInstruktorov().size();
        assertEquals(povodnaSize + 1, novaSize);
    }
}
