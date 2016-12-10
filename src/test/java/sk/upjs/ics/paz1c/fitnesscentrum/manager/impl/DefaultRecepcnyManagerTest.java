package sk.upjs.ics.paz1c.fitnesscentrum.manager.impl;

import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;
import sk.upjs.ics.paz1c.fitnesscentrum.ObjectFactory;
import sk.upjs.ics.paz1c.fitnesscentrum.dao.RecepcnyDao;
import sk.upjs.ics.paz1c.fitnesscentrum.dao.impl.PripravaNaTestovanie;
import sk.upjs.ics.paz1c.fitnesscentrum.entity.Recepcny;
import sk.upjs.ics.paz1c.fitnesscentrum.exception.NevalidnyVstupException;
import sk.upjs.ics.paz1c.fitnesscentrum.manager.RecepcnyManager;

public class DefaultRecepcnyManagerTest extends PripravaNaTestovanie{
    
    private static RecepcnyManager recepcnyManager = ObjectFactory.INSTANCE.getRecepcnyManager();
    private static RecepcnyDao recepcnyDao = ObjectFactory.INSTANCE.getRecepcnyDao();

    /**
     * Test of pridajRecepcneho method, of class DefaultRecepcnyManager.
     * @throws java.lang.Exception
     */
    @Test
    public void testPridajRecepcneho() throws Exception {
        Recepcny recepcny = new Recepcny();
        int povodnaSize = recepcnyDao.dajVsetkychRecepcnych().size();
        recepcnyManager.pridajRecepcneho("Julius", "julo", "0000", "0000");
        int novaSize = recepcnyDao.dajVsetkychRecepcnych().size();
        assertEquals(povodnaSize + 1, novaSize);
    }

    /**
     * Test of zmenHesloRecepcneho method, of class DefaultRecepcnyManager.
     */
    @Test
    public void testZmenHesloRecepcneho() throws Exception {
        String login = "ferko";
        String heslo = "1111";
        String noveHeslo = "0000";
        String noveHesloZnova = "0000";
        String povodneHeslo = recepcnyDao.dajRecepcneho(login).getHeslo();
        recepcnyManager.zmenHesloRecepcneho(login, heslo, noveHeslo, noveHesloZnova);
        String noveHeslovDB = recepcnyDao.dajRecepcneho(login).getHeslo();
        assertNotEquals(noveHeslovDB, povodneHeslo);
    }

    /**
     * Test of dajRecepcneho method, of class DefaultRecepcnyManager.
     */
    @Test
    public void testDajRecepcneho() {
        Long idRecepecneho = 0L;
        Recepcny result = recepcnyManager.dajRecepcneho(idRecepecneho);
        assertNotNull(result);
    }

    /**
     * Test of vymazRecepcneho method, of class DefaultRecepcnyManager.
     */
    @Test
    public void testVymazRecepcneho() throws NevalidnyVstupException {
        Long idRecepcny = 2L;
        Recepcny recepcny = recepcnyDao.dajRecepcneho(idRecepcny);
        recepcnyManager.vymazRecepcneho(recepcny);
        List<Recepcny> listRecepcnych = recepcnyDao.dajVsetkychRecepcnych();

        boolean jeOdstraneny = true;
        for (Recepcny r : listRecepcnych) {
            if (r.getId().equals(idRecepcny)) {
                jeOdstraneny = false;
            }
        }
        assertTrue(jeOdstraneny);
    }
    
}
