package sk.upjs.ics.paz1c.fitnesscentrum.manager.impl;

import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;
import sk.upjs.ics.paz1c.fitnesscentrum.ObjectFactory;
import sk.upjs.ics.paz1c.fitnesscentrum.dao.InstruktorDao;
import sk.upjs.ics.paz1c.fitnesscentrum.dao.impl.PripravaNaTestovanie;
import sk.upjs.ics.paz1c.fitnesscentrum.entity.Instruktor;
import sk.upjs.ics.paz1c.fitnesscentrum.manager.InstruktorManager;

public class DefaultInstruktorManagerTest extends PripravaNaTestovanie {

    private static InstruktorManager instruktorManager = ObjectFactory.INSTANCE.getInstruktorManager();
    private static InstruktorDao instruktorDao = ObjectFactory.INSTANCE.getInstruktorDao();

    /**
     * Test of pridajInstruktora method, of class DefaultInstruktorManager.
     */
    @Test
    public void testPridajInstruktora() {
        int povodnaSize = instruktorDao.dajVsetychInstruktorov().size();
        Instruktor instruktor = new Instruktor();
        instruktor.setMeno("Maros");
        instruktorManager.pridajInstruktora(instruktor);
        int novaSize = instruktorDao.dajVsetychInstruktorov().size();
        assertEquals(povodnaSize + 1, novaSize);
    }
}
