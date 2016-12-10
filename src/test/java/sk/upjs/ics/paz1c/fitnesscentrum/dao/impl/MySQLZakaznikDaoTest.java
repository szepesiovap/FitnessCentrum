package sk.upjs.ics.paz1c.fitnesscentrum.dao.impl;

import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;
import sk.upjs.ics.paz1c.fitnesscentrum.ObjectFactory;
import sk.upjs.ics.paz1c.fitnesscentrum.dao.ZakaznikDao;
import sk.upjs.ics.paz1c.fitnesscentrum.entity.Kluc;
import sk.upjs.ics.paz1c.fitnesscentrum.entity.Zakaznik;

public class MySQLZakaznikDaoTest extends PripravaNaTestovanie {

    private final ZakaznikDao zakaznikDao = ObjectFactory.INSTANCE.getZakaznikDao();

    /**
     * Test of dajVsetkychZakaznikov method, of class MySQLZakaznikDao.
     */
    @Test
    public void testDajVsetkychZakaznikov() {
        List<Zakaznik> list = zakaznikDao.dajVsetkychZakaznikov();
        assertTrue(list.size() > 0);
    }

    /**
     * Test of dajPritomnychZakaznikov method, of class MySQLZakaznikDao.
     */
    @Test
    public void testDajPritomnychZakaznikov() {
        boolean vsetciPritomni = true;
        List<Zakaznik> list = zakaznikDao.dajPritomnychZakaznikov();
        for (Zakaznik zakaznik : list) {
            if (!zakaznik.isPritomny()) {
                vsetciPritomni = false;
            }
        }
        assertTrue(list.size() > 0);
        assertTrue(vsetciPritomni);
    }

    /**
     * Test of pridajZakaznika method, of class MySQLZakaznikDao.
     */
    @Test
    public void testPridajZakaznika() {
        int povodnaSize = zakaznikDao.dajVsetkychZakaznikov().size();
        Zakaznik zakaznik = new Zakaznik();
        zakaznik.setMeno("Adam");
        zakaznikDao.pridajZakaznika(zakaznik);
        int novaSize = zakaznikDao.dajVsetkychZakaznikov().size();
        assertEquals(povodnaSize + 1, novaSize);
    }

    /**
     * Test of prichod method, of class MySQLZakaznikDao.
     */
    @Test
    public void testPrichod() {
        Zakaznik zakaznik = zakaznikDao.dajZakaznikaSId(2L);
        Kluc kluc = ObjectFactory.INSTANCE.getKlucDao().dajKlucSId(1L);
        zakaznikDao.prichod(zakaznik, kluc);
        zakaznik = zakaznikDao.dajZakaznikaSId(2L);
        assertTrue(zakaznik.isPritomny());
    }

    /**
     * Test of odchod method, of class MySQLZakaznikDao.
     */
    @Test
    public void testOdchod() {
        Zakaznik zakaznik = zakaznikDao.dajZakaznikaSId(3L);
        zakaznikDao.odchod(zakaznik);
        zakaznik = zakaznikDao.dajZakaznikaSId(3L);
        assertFalse(zakaznik.isPritomny());
    }

    /**
     * Test of dajZakaznikaSId method, of class MySQLZakaznikDao.
     */
    @Test
    public void testDajZakaznikaSId() {
        Long id = 2L;
        Zakaznik zakaznik = zakaznikDao.dajZakaznikaSId(id);
        assertEquals(zakaznik.getMeno(), "Jane Doe");
    }

    /**
     * Test of dajZakaznikaSCislomPermanentky method, of class MySQLZakaznikDao.
     */
    @Test
    public void testDajZakaznikaSCislomPermanentky() {
        String cisloPermanentky = "111";
        Zakaznik zakaznik = zakaznikDao.dajZakaznikaSCislomPermanentky(cisloPermanentky);
        assertTrue(zakaznik.getId() == 2L);
    }

    /**
     * Test of dajZakaznikovSoZhodouVMene method, of class MySQLZakaznikDao.
     */
    @Test
    public void testDajZakaznikovSoZhodouVMene() {
        String vzorka = "Doe";
        List<Zakaznik> list = zakaznikDao.dajZakaznikovSoZhodouVMene(vzorka);
        boolean nezhodujeSa = false;
        for (Zakaznik zakaznik : list) {
            if (!zakaznik.getMeno().contains(vzorka)) {
                nezhodujeSa = true;
            }
        }
        assertFalse(nezhodujeSa);
        assertEquals(list.size(), 2);
    }

    /**
     * Test of stiahniKreditZakaznikovi method, of class MySQLZakaznikDao.
     */
    @Test
    public void testStiahniKreditZakaznikovi() {
        long idZakaznika = 2L;
        Zakaznik zakaznik = zakaznikDao.dajZakaznikaSId(idZakaznika);
        double staryKredit = zakaznik.getKredit();
        double suma = 13.5;
        zakaznikDao.stiahniKreditZakaznikovi(zakaznik, suma);
        zakaznik = zakaznikDao.dajZakaznikaSId(idZakaznika);
        assertTrue(zakaznik.getKredit() == staryKredit - suma);
    }

    /**
     * Test of dobiKreditZakaznikovi method, of class MySQLZakaznikDao.
     */
    @Test
    public void testDobiKreditZakaznikovi() {
        long idZakaznika = 3L;
        Zakaznik zakaznik = zakaznikDao.dajZakaznikaSId(idZakaznika);
        double staryKredit = zakaznik.getKredit();
        double suma = 15.0;
        zakaznikDao.dobiKreditZakaznikovi(zakaznik, suma);
        zakaznik = zakaznikDao.dajZakaznikaSId(idZakaznika);
        assertTrue(zakaznik.getKredit() == staryKredit + suma);
    }

    /**
     * Test of vymazZakaznika method, of class MySQLZakaznikDao.
     */
    @Test
    public void testVymazZakaznika() {
        Long id = 4L;
        Zakaznik zakaznik = zakaznikDao.dajZakaznikaSId(id);
        zakaznikDao.vymazZakaznika(zakaznik);
        List<Zakaznik> list = zakaznikDao.dajVsetkychZakaznikov();

        boolean jeOdstraneny = true;
        for (Zakaznik z : list) {
            if (z.getId().equals(id)) {
                jeOdstraneny = false;
            }
        }
        assertTrue(jeOdstraneny);
    }

}
