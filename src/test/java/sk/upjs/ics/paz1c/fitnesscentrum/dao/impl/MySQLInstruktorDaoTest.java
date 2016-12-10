package sk.upjs.ics.paz1c.fitnesscentrum.dao.impl;

import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;
import sk.upjs.ics.paz1c.fitnesscentrum.ObjectFactory;
import sk.upjs.ics.paz1c.fitnesscentrum.dao.InstruktorDao;
import sk.upjs.ics.paz1c.fitnesscentrum.entity.Instruktor;

public class MySQLInstruktorDaoTest extends PripravaNaTestovanie {
    
    private final InstruktorDao instruktorDao = ObjectFactory.INSTANCE.getInstruktorDao();
    
    /**
     * Test of dajVsetychInstruktorov method, of class MySQLInstruktorDao.
     */
    @Test
    public void testDajVsetychInstruktorov() {
        List<Instruktor> result = instruktorDao.dajVsetychInstruktorov();
        assertEquals(1, result.size());
    }

    /**
     * Test of dajInstruktoraSId method, of class MySQLInstruktorDao.
     */
    @Test
    public void testDajInstruktoraSId() {        
        Long idInstruktora = 1L;
        Instruktor result = instruktorDao.dajInstruktoraSId(idInstruktora);
        assertNotNull(result);
    }

    /**
     * Test of pridajInstruktora method, of class MySQLInstruktorDao.
     */
    @Test
    public void testPridajInstruktora() {
        Instruktor instruktor = new Instruktor();
        String meno = "Ruzenka Sipova";
        instruktor.setMeno(meno);
        instruktorDao.pridajInstruktora(instruktor);
        List<Instruktor> listInstruktorov = instruktorDao.dajVsetychInstruktorov();
        boolean jePridany = false;
        for (Instruktor i : listInstruktorov){
            if (i.getMeno().equals(meno)) {
                jePridany = true;
                break;
            }
        }
        assertTrue(jePridany);
    }
    
}
