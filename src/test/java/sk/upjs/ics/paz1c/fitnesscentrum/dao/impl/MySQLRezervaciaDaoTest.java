package sk.upjs.ics.paz1c.fitnesscentrum.dao.impl;

import java.time.LocalDateTime;
import java.util.List;
import static org.junit.Assert.*;
import org.junit.Test;
import sk.upjs.ics.paz1c.fitnesscentrum.ObjectFactory;
import sk.upjs.ics.paz1c.fitnesscentrum.dao.RezervaciaDao;
import sk.upjs.ics.paz1c.fitnesscentrum.entity.Rezervacia;
import sk.upjs.ics.paz1c.fitnesscentrum.entity.Spinning;
import sk.upjs.ics.paz1c.fitnesscentrum.entity.Zakaznik;

public class MySQLRezervaciaDaoTest extends PripravaNaTestovanie {

    private final RezervaciaDao rezervaciaDao = ObjectFactory.INSTANCE.getRezervaciaDao();

    /**
     * Test of dajVsetkyRezervacie method, of class MySQLRezervaciaDao.
     */
    @Test
    public void testDajVsetkyRezervacie() {
        List<Rezervacia> list = rezervaciaDao.dajVsetkyRezervacie();
        int size = list.size();
        assertTrue(size > 0);
    }

    /**
     * Test of dajRezervacieSpinningu method, of class MySQLRezervaciaDao.
     */
    @Test
    public void testDajRezervacieSpinningu() {
        long idSpinningu = 1L;
        Spinning spinning = ObjectFactory.INSTANCE.getSpinningDao().dajSpinningSId(idSpinningu);
        int ocakavanaSize = 2;
        List<Rezervacia> list = rezervaciaDao.dajRezervacieSpinningu(spinning);
        int size = list.size();
        assertEquals(size, ocakavanaSize);
    }

    /**
     * Test of dajRezervaciuSId method, of class MySQLRezervaciaDao.
     */
    @Test
    public void testDajRezervaciuSId() {
        long idRezervacie = 1L;
        Rezervacia rezervacia = rezervaciaDao.dajRezervaciuSId(idRezervacie);
        long ocakavaneIdZakaznika = 2L;
        long ocakavaneIdSpinningu = 1L;
        long idZakaznika = rezervacia.getZakaznik().getId();
        long idSpinningu = rezervacia.getSpinning().getId();
        assertEquals(idZakaznika, ocakavaneIdZakaznika);
        assertEquals(idSpinningu, ocakavaneIdSpinningu);
    }

    /**
     * Test of pridajRezervaciu method, of class MySQLRezervaciaDao.
     */
    @Test
    public void testPridajRezervaciu() {
        long idSpinningu = 1L;
        long idZakaznika = 1L;
        int povodnaSize = rezervaciaDao.dajVsetkyRezervacie().size();
        Rezervacia rezervacia = new Rezervacia();
        Spinning spinning = ObjectFactory.INSTANCE.getSpinningDao().dajSpinningSId(idSpinningu);
        Zakaznik zakaznik = ObjectFactory.INSTANCE.getZakaznikDao().dajZakaznikaSId(idZakaznika);
        rezervacia.setSpinning(spinning);
        rezervacia.setZakaznik(zakaznik);
        rezervacia.setCasRezervacie(LocalDateTime.now());
        rezervaciaDao.pridajRezervaciu(rezervacia);
        int novaSize = rezervaciaDao.dajVsetkyRezervacie().size();
        assertEquals(novaSize, povodnaSize + 1);
    }

    /**
     * Test of odstranRezervacia method, of class MySQLRezervaciaDao.
     */
    @Test
    public void testOdstranRezervacia() {
        long idRezervacie = 3L;
        Rezervacia rezervacia = rezervaciaDao.dajRezervaciuSId(idRezervacie);
        int povodnaSize = rezervaciaDao.dajVsetkyRezervacie().size();
        rezervaciaDao.odstranRezervacia(rezervacia);
        int novaSize = rezervaciaDao.dajVsetkyRezervacie().size();
        assertEquals(novaSize, povodnaSize - 1);
    }

}
