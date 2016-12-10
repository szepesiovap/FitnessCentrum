package sk.upjs.ics.paz1c.fitnesscentrum.manager.impl;

import org.junit.Test;
import static org.junit.Assert.*;
import sk.upjs.ics.paz1c.fitnesscentrum.ObjectFactory;
import sk.upjs.ics.paz1c.fitnesscentrum.dao.impl.PripravaNaTestovanie;
import sk.upjs.ics.paz1c.fitnesscentrum.entity.Rezervacia;
import sk.upjs.ics.paz1c.fitnesscentrum.manager.RezervaciaManager;

/**
 *
 * @author Marcela
 */
public class DefaultRezervaciaManagerTest extends PripravaNaTestovanie{

    private static RezervaciaManager rezervaciaManager = ObjectFactory.INSTANCE.getRezervaciaManager();

    /**
     * Test of dajRezervaciuSId method, of class DefaultRezervaciaManager.
     */
    @Test
    public void testDajRezervaciuSId() {
        Long idRezervacie = 1L;
        Rezervacia result = rezervaciaManager.dajRezervaciuSId(idRezervacie);
        assertNotNull(result);
    }
    
}
