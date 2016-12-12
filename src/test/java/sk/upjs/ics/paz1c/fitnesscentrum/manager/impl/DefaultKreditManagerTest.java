package sk.upjs.ics.paz1c.fitnesscentrum.manager.impl;

import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;
import sk.upjs.ics.paz1c.fitnesscentrum.ObjectFactory;
import sk.upjs.ics.paz1c.fitnesscentrum.dao.impl.PripravaNaTestovanie;
import sk.upjs.ics.paz1c.fitnesscentrum.entity.Kredit;
import sk.upjs.ics.paz1c.fitnesscentrum.entity.Zakaznik;
import sk.upjs.ics.paz1c.fitnesscentrum.manager.KreditManager;

public class DefaultKreditManagerTest extends PripravaNaTestovanie {

    private final KreditManager kreditManager = ObjectFactory.INSTANCE.getKreditManager();

    /**
     * Test of dajKreditSId method, of class DefaultKreditManager.
     */
    @Test
    public void testDajKreditSId() {
        Long idKredit = 1L;
        Kredit result = kreditManager.dajKreditSId(idKredit);
        assertNotNull(result);
    }

    /**
     * Test of vymazKredit method, of class DefaultKreditManager.
     */
    @Test
    public void testVymazKredit() {
        Kredit kredit = new Kredit();
        kredit.setNazov("200");
        kreditManager.ulozitKredit(kredit);
        Long idKredit = kredit.getId();

        kreditManager.vymazKredit(idKredit);
        List<Kredit> listKreditov = kreditManager.dajVsetkyKredity();
        boolean jeOdstraneny = true;
        for (Kredit k : listKreditov) {
            if (k.getNazov().equals(kredit)) {
                jeOdstraneny = false;
                break;
            }
        }
        assertTrue(jeOdstraneny);

    }

    /**
     * Test of ulozitKredit method, of class DefaultKreditManager.
     */
    @Test
    public void testUlozitKredit() {
        Kredit kredit = new Kredit();
        String nazov = "100 eur";
        kredit.setNazov(nazov);
        kredit.setCena(100);
        kreditManager.ulozitKredit(kredit);
        List<Kredit> listKreditov = kreditManager.dajVsetkyKredity();
        boolean jePridany = false;
        for (Kredit k : listKreditov) {
            if (k.getNazov().equals(nazov)) {
                jePridany = true;
            }
        }
        assertTrue(jePridany);
    }

    /**
     * Test of dobitKredit method, of class DefaultKreditManager.
     */
    @Test
    // TODO:
    public void testDobitKredit() {
        Zakaznik zakaznik = new Zakaznik();
        zakaznik.setKredit(10.0);

        double kredit = 50.0;
        kreditManager.dobitKredit(zakaznik, kredit);
        double novyKredit = zakaznik.getKredit();
        System.out.println(novyKredit);
        assertEquals(novyKredit, zakaznik.getKredit(), 0.001);
    }

    /**
     * Test of dajVsetkyKredity method, of class DefaultKreditManager.
     */
    @Test
    public void testDajVsetkyKredity() {
        List<Kredit> result = kreditManager.dajVsetkyKredity();
        assertEquals(3, result.size());
    }

}
