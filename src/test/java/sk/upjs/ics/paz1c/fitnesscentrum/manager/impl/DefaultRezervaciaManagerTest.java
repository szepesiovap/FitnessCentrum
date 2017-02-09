package sk.upjs.ics.paz1c.fitnesscentrum.manager.impl;

import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;
import sk.upjs.ics.paz1c.fitnesscentrum.ObjectFactory;
import sk.upjs.ics.paz1c.fitnesscentrum.dao.impl.PripravaNaTestovanie;
import sk.upjs.ics.paz1c.fitnesscentrum.entity.Cvicenie;
import sk.upjs.ics.paz1c.fitnesscentrum.entity.Rezervacia;
import sk.upjs.ics.paz1c.fitnesscentrum.entity.Spinning;
import sk.upjs.ics.paz1c.fitnesscentrum.manager.RezervaciaManager;

public class DefaultRezervaciaManagerTest extends PripravaNaTestovanie {

    private final RezervaciaManager rezervaciaManager = ObjectFactory.INSTANCE.getRezervaciaManager();

    /**
     * Test of dajRezervaciuSId method, of class DefaultRezervaciaManager.
     */
    @Test
    public void testDajRezervaciuSId() {
        Long idRezervacie = 1L;
        Rezervacia result = rezervaciaManager.dajRezervaciuSId(idRezervacie);
        assertNotNull(result);
    }

    /**
     * Test of dajRezervacieSpinningu method, of class DefaultRezervaciaManager.
     */
    @Test
    public void testDajRezervacieCvicenia() {
        long idCvicenia = 1L;
        Cvicenie cvicenie = ObjectFactory.INSTANCE.getCvicenieDao().dajCvicenieSId(idCvicenia);
        int ocakavanaSize = 2;
        List<Rezervacia> list = rezervaciaManager.dajRezervacieCvicenia(cvicenie);
        int size = list.size();
        assertEquals(size, ocakavanaSize);
    }

}
