package sk.upjs.ics.paz1c.fitnesscentrum.dao.impl;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.List;
import static org.junit.Assert.*;
import org.junit.Test;
import sk.upjs.ics.paz1c.fitnesscentrum.ObjectFactory;
import sk.upjs.ics.paz1c.fitnesscentrum.dao.SpinningDao;
import sk.upjs.ics.paz1c.fitnesscentrum.entity.Instruktor;
import sk.upjs.ics.paz1c.fitnesscentrum.entity.Spinning;

public class MySQLSpinningDaoTest extends PripravaNaTestovanie {

    private final SpinningDao spinningDao = ObjectFactory.INSTANCE.getSpinningDao();

    /**
     * Test of dajVsetkySpinningy method, of class MySQLSpinningDao.
     */
    @Test
    public void testDajVsetkySpinningy() {
        List<Spinning> list = spinningDao.dajVsetkySpinningy();
        assertTrue(list.size() > 0);
    }

    /**
     * Test of dajSpinningSId method, of class MySQLSpinningDao.
     */
    @Test
    public void testDajSpinningSId() {
        Long idSpinningu = 1L;
        Spinning spinning = spinningDao.dajSpinningSId(idSpinningu);
        LocalDateTime ldt = LocalDateTime.of(2016, Month.DECEMBER, 24, 15, 0, 0);
        assertEquals(ldt, spinning.getDatum());
    }

    /**
     * Test of pridajSpinning method, of class MySQLSpinningDao.
     */
    @Test
    public void testPridajSpinning() {
        int povodnaSize = spinningDao.dajVsetkySpinningy().size();
        Spinning spinning = new Spinning();
        spinning.setDatum(LocalDateTime.of(2015, Month.MARCH, 15, 0, 0));
        Instruktor instruktor = ObjectFactory.INSTANCE.getInstruktorDao().dajInstruktoraSId(1L);
        spinning.setInstruktor(instruktor);
        spinning.setKapacita(5);
        spinning.setVolne(5);
        spinningDao.pridajSpinning(spinning);
        int novaSize = spinningDao.dajVsetkySpinningy().size();
        assertEquals(povodnaSize + 1, novaSize);
    }

    /**
     * Test of dajSpinningyOdDatumu method, of class MySQLSpinningDao.
     */
    @Test
    public void testDajSpinningyOdDatumu() {
        LocalDateTime lcd = LocalDateTime.of(2016, Month.DECEMBER, 23, 0, 0);
        List<Spinning> list = spinningDao.dajSpinningyOdDatumu(lcd);
        assertEquals(list.size(), 2);
    }

    /**
     * Test of rezervujSpinning method, of class MySQLSpinningDao.
     */
    @Test
    public void testRezervujSpinning() {
        Long idSpinningu = 1L;
        Spinning spinning = spinningDao.dajSpinningSId(idSpinningu);
        int povodneVolne = spinning.getVolne();
        spinningDao.rezervujSpinning(spinning);
        spinning = spinningDao.dajSpinningSId(idSpinningu);
        int noveVolne = spinning.getVolne();
        assertEquals(noveVolne, povodneVolne - 1);
    }

    /**
     * Test of odrezervujSpinning method, of class MySQLSpinningDao.
     */
    @Test
    public void testOdrezervujSpinning() {
        Long idSpinningu = 2L;
        Spinning spinning = spinningDao.dajSpinningSId(idSpinningu);
        int povodneVolne = spinning.getVolne();
        spinningDao.odrezervujSpinning(spinning);
        spinning = spinningDao.dajSpinningSId(idSpinningu);
        int noveVolne = spinning.getVolne();
        assertEquals(noveVolne, povodneVolne + 1);
    }

    /**
     * Test of vymazSpinning method, of class MySQLSpinningDao.
     */
    @Test
    public void testVymazSpinning() {
        long idSpinningu = 3L;
        int povodnaSize = spinningDao.dajVsetkySpinningy().size();
        Spinning spinning = spinningDao.dajSpinningSId(idSpinningu);
        spinningDao.vymazSpinning(spinning);
        int novaSize = spinningDao.dajVsetkySpinningy().size();
        assertEquals(povodnaSize - 1, novaSize);
    }

}
