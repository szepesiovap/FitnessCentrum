package sk.upjs.ics.paz1c.fitnesscentrum.dao.impl;

import java.time.LocalDateTime;
import java.util.List;
import static org.junit.Assert.*;
import org.junit.Test;
import sk.upjs.ics.paz1c.fitnesscentrum.ObjectFactory;
import sk.upjs.ics.paz1c.fitnesscentrum.dao.RezervaciaDao;
import sk.upjs.ics.paz1c.fitnesscentrum.entity.Cvicenie;
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
        long idCvicenia = 1L;
        Cvicenie cvicenie = ObjectFactory.INSTANCE.getCvicenieDao().dajCvicenieSId(idCvicenia);
        int ocakavanaSize = 2;
        List<Rezervacia> list = rezervaciaDao.dajRezervacieCvicenia(cvicenie);
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
        long ocakavaneIdCvicenia = 1L;
        long idZakaznika = rezervacia.getZakaznik().getId();
        long idCvicenia = rezervacia.getCvicenie().getId();
        assertEquals(idZakaznika, ocakavaneIdZakaznika);
        assertEquals(idCvicenia, ocakavaneIdCvicenia);
    }

    /**
     * Test of pridajRezervaciu method, of class MySQLRezervaciaDao.
     */
    @Test
    public void testPridajRezervaciu() {
        long idCvicenia = 1L;
        long idZakaznika = 1L;
        int povodnaSize = rezervaciaDao.dajVsetkyRezervacie().size();
        Rezervacia rezervacia = new Rezervacia();
        Cvicenie cvicenie = ObjectFactory.INSTANCE.getCvicenieDao().dajCvicenieSId(idCvicenia);
        Zakaznik zakaznik = ObjectFactory.INSTANCE.getZakaznikDao().dajZakaznikaSId(idZakaznika);
        rezervacia.setCvicenie(cvicenie);
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
