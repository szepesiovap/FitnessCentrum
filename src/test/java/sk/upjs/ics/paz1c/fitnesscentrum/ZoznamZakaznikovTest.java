package sk.upjs.ics.paz1c.fitnesscentrum;

import sk.upjs.ics.paz1c.fitnesscentrum.entity.Zakaznik;
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

}
