package sk.upjs.ics.paz1c.fitnesscentrum.manager.impl;

import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;
import sk.upjs.ics.paz1c.fitnesscentrum.ObjectFactory;
import sk.upjs.ics.paz1c.fitnesscentrum.dao.KlucDao;
import sk.upjs.ics.paz1c.fitnesscentrum.dao.impl.PripravaNaTestovanie;
import sk.upjs.ics.paz1c.fitnesscentrum.entity.Kluc;
import sk.upjs.ics.paz1c.fitnesscentrum.manager.KlucManager;

/**
 *
 * @author Marcela
 */
public class DefaultKlucManagerTest extends PripravaNaTestovanie{
   
    private static KlucManager klucManager = ObjectFactory.INSTANCE.getKlucManager();
    private static KlucDao klucDao = ObjectFactory.INSTANCE.getKlucDao();
    
    /**
     * Test of dajKlucSId method, of class DefaultKlucManager.
     */
    @Test
    public void testDajKlucSId() {
        Long idKluca = 1L;
        Kluc result = klucManager.dajKlucSId(idKluca);
        assertNotNull(result);
    }

    /**
     * Test of pridajKluc method, of class DefaultKlucManager.
     * @throws java.lang.Exception
     */
    @Test
    public void testPridajKluc() throws Exception {
        Kluc kluc = new Kluc();
        String menoKluca = "test";
        int povodnaSize = klucDao.dajVsetkyKluce().size();
        klucManager.pridajKluc(menoKluca);
        int novaSize = klucDao.dajVsetkyKluce().size();
        assertEquals(povodnaSize + 1, novaSize);
    }

    /**
     * Test of vymazKluc method, of class DefaultKlucManager.
     * @throws java.lang.Exception
     */
    @Test
    public void testVymazKluc() throws Exception {
        Kluc kluc = new Kluc();
        kluc.setMeno("test");
        klucDao.pridajKluc(kluc);
        
        klucManager.vymazKluc(kluc);
        List<Kluc> listKlucov = klucDao.dajVsetkyKluce();
        boolean jeOdstraneny = true;
        for (Kluc k : listKlucov) {
            if (k.getMeno().equals(kluc)) {
                jeOdstraneny = false;
                break;
            }
        }
        assertTrue(jeOdstraneny);
    }
}
