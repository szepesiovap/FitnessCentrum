package sk.upjs.ics.paz1c.fitnesscentrum;

import java.time.LocalDateTime;
import java.time.Month;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author patka
 */
public class ZoznamZakaznikovTest {

    public ZoznamZakaznikovTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of dajVsetkychZakaznikov method, of class ZoznamZakaznikov.
     */
    @Test
    public void testDajVsetkychZakaznikov() {
        ZoznamZakaznikov zoznam = new ZoznamZakaznikov();
        assertEquals(2, zoznam.dajVsetkychZakaznikov().size());

    }

    /**
     * Test of novaPermanentka method, of class ZoznamZakaznikov.
     */
    @Test
    public void testNovaPermanentka() {
        ZoznamZakaznikov zoznam = new ZoznamZakaznikov();
        Zakaznik zakaznik = new Zakaznik();
        zakaznik.setMeno("Darth Vader");
        zakaznik.setPoslednyPrichod(LocalDateTime.of(2016, Month.MARCH, 1, 23, 59));
        zakaznik.setCisloPermanentky(new Long(123456789));
        zakaznik.setKredit(150.0);
        zoznam.novaPermanentka(zakaznik);
        assertEquals(3, zoznam.dajVsetkychZakaznikov().size());
    }

    /**
     * Test of novyJednorazovyVstup method, of class ZoznamZakaznikov.
     */
    @Test
    public void testNovyJednorazovyVstup() {
        ZoznamZakaznikov zoznam = new ZoznamZakaznikov();
        Zakaznik zakaznik = new Zakaznik();
        zakaznik.setMeno("Princess Leia");
        zakaznik.setPoslednyPrichod(LocalDateTime.of(2016, Month.FEBRUARY, 28, 14, 00));
        zoznam.novyJednorazovyVstup(zakaznik);
        assertEquals(3, zoznam.dajVsetkychZakaznikov().size());
    }

    /**
     * Test of novyStudent method, of class ZoznamZakaznikov.
     */
    @Test
    public void testNovyStudent() {
        ZoznamZakaznikov zoznam = new ZoznamZakaznikov();
        Zakaznik zakaznik = new Zakaznik();
        zakaznik.setMeno("R2-D2");
        zakaznik.setPoslednyPrichod(LocalDateTime.of(2015, Month.DECEMBER, 24, 04, 30));
        zakaznik.setPlatnostPermanentky(LocalDateTime.of(2016, Month.JANUARY, 23, 23, 59));
        zoznam.novyStudent(zakaznik);
        assertEquals(3, zoznam.dajVsetkychZakaznikov().size());
    }

}
