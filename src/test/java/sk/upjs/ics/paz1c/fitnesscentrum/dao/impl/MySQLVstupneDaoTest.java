package sk.upjs.ics.paz1c.fitnesscentrum.dao.impl;

import org.junit.Test;
import static org.junit.Assert.*;
import sk.upjs.ics.paz1c.fitnesscentrum.ObjectFactory;
import sk.upjs.ics.paz1c.fitnesscentrum.dao.VstupneDao;
import sk.upjs.ics.paz1c.fitnesscentrum.entity.Vstupne;

public class MySQLVstupneDaoTest extends PripravaNaTestovanie {

    private final VstupneDao vstupneDao = ObjectFactory.INSTANCE.getVstupneDao();

    /**
     * Test of updateCenaVstupneho method, of class MySQLVstupneDao.
     */
    @Test
    public void testUpdateCenaVstupneho() {
        double cenaVstupneho = 2.0;
        vstupneDao.updateCenaVstupneho(cenaVstupneho);
        double novaCenaVstupneho = vstupneDao.dajCeny().getCenaVstupneho();
        assertEquals(cenaVstupneho, novaCenaVstupneho, 0.0001);
    }

    /**
     * Test of updateCenaSpinningu method, of class MySQLVstupneDao.
     */
    @Test
    public void testUpdateCenaSpinningu() {
        double cenaSpinnigu = 4.0;
        vstupneDao.updateCenaSpinningu(cenaSpinnigu);
        double novaCenaSpinningu = vstupneDao.dajCeny().getCenaSpinnigu();
        assertEquals(cenaSpinnigu, novaCenaSpinningu, 0.0001);
    }

    /**
     * Test of dajCeny method, of class MySQLVstupneDao.
     */
    @Test
    public void testDajCeny() {
        Vstupne result = vstupneDao.dajCeny();
        assertTrue(result.getCenaSpinnigu() > 0);
        assertTrue(result.getCenaVstupneho() > 0);
    }

}
