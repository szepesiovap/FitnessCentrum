package sk.upjs.ics.paz1c.fitnesscentrum.dao.impl;

import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;
import sk.upjs.ics.paz1c.fitnesscentrum.ObjectFactory;
import sk.upjs.ics.paz1c.fitnesscentrum.dao.KlucDao;
import sk.upjs.ics.paz1c.fitnesscentrum.entity.Kluc;
import sk.upjs.ics.paz1c.fitnesscentrum.entity.Zakaznik;

public class MySQLKlucDaoTest extends PripravaNaTestovanie {

    private static final KlucDao klucDao = ObjectFactory.INSTANCE.getKlucDao();
    private Kluc kluc;

    /**
     * Test of dajVsetkyKluce method, of class MySQLKlucDao.
     */
    @Test
    public void testDajVsetkyKluce() {
        List<Kluc> result = klucDao.dajVsetkyKluce();
        assertEquals(2, result.size());
    }

    /**
     * Test of dajVolneKluce method, of class MySQLKlucDao.
     */
    @Test
    public void testDajVolneKluce() {
        List<Kluc> result = klucDao.dajVolneKluce();
        assertEquals(2, result.size());
    }

    /**
     * Test of dajKlucSId method, of class MySQLKlucDao.
     */
    @Test
    public void testDajKlucSId() {
        Long idKluca = 1L;
        Kluc result = klucDao.dajKlucSId(idKluca);
        assertNotNull(result);
    }

    /**
     * Test of priradZakaznika method, of class MySQLKlucDao.
     */
    @Test
    public void testPriradZakaznika() {
        kluc = new Kluc();
        kluc.setId(1L);

        Zakaznik zakaznik = new Zakaznik();
        zakaznik.setId(1L);

        klucDao.priradZakaznika(kluc, zakaznik);
        List<Kluc> listKlucov = klucDao.dajVsetkyKluce();
        boolean jePriradeny = false;

        for (Kluc k : listKlucov) {
            if (k.getZakaznik() != null) {
                if (k.getZakaznik().getId().equals(zakaznik.getId())) {
                    jePriradeny = true;
                    break;
                }
            }
        }
        assertTrue(jePriradeny);
    }

    /**
     * Test of odoberZakaznika method, of class MySQLKlucDao.
     */
    @Test
    public void testOdoberZakaznika() {
        long idKluc = 1L;
        kluc = new Kluc();
        kluc.setId(idKluc);

        Zakaznik zakaznik = new Zakaznik();
        zakaznik.setId(idKluc);

        klucDao.priradZakaznika(kluc, zakaznik);
        kluc = klucDao.dajKlucSId(idKluc);
        assertNotNull(kluc.getZakaznik());

        klucDao.odoberZakaznika(kluc);
        kluc = klucDao.dajKlucSId(idKluc);
        assertNull(kluc.getZakaznik());
    }

    /**
     * Test of vymazKluc method, of class MySQLKlucDao.
     */
    @Test
    public void testVymazKluc() {
        Long idKluc = 1L;
        Kluc kluc = klucDao.dajKlucSId(idKluc);
        klucDao.vymazKluc(kluc);
        List<Kluc> listKlucov = klucDao.dajVsetkyKluce();
        boolean jeOdstraneny = true;
        for (Kluc k : listKlucov) {
            if (k.getId().equals(idKluc)) {
                jeOdstraneny = false;
                break;
            }
        }
        assertTrue(jeOdstraneny);
    }

    /**
     * Test of pridajKluc method, of class MySQLKlucDao.
     */
    @Test
    public void testPridajKluc() {
        kluc = new Kluc();
        String meno = "3M";
        kluc.setMeno(meno);
        klucDao.pridajKluc(kluc);
        List<Kluc> listKlucov = klucDao.dajVsetkyKluce();
        boolean jePridany = false;

        for (Kluc k : listKlucov) {
            if (k.getMeno().equals(meno)) {
                jePridany = true;
                break;
            }
        }
        assertTrue(jePridany);
    }
}
