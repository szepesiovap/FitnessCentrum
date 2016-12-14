package sk.upjs.ics.paz1c.fitnesscentrum.manager.impl;

import java.util.List;
import java.util.Objects;
import org.junit.Test;
import static org.junit.Assert.*;
import org.springframework.dao.DuplicateKeyException;
import sk.upjs.ics.paz1c.fitnesscentrum.ObjectFactory;
import sk.upjs.ics.paz1c.fitnesscentrum.dao.impl.PripravaNaTestovanie;
import sk.upjs.ics.paz1c.fitnesscentrum.entity.Kluc;
import sk.upjs.ics.paz1c.fitnesscentrum.entity.Zakaznik;
import sk.upjs.ics.paz1c.fitnesscentrum.exception.NedostatocnyKreditException;
import sk.upjs.ics.paz1c.fitnesscentrum.exception.NeexistujuciZakaznikException;
import sk.upjs.ics.paz1c.fitnesscentrum.exception.PrazdnyRetazecException;
import sk.upjs.ics.paz1c.fitnesscentrum.exception.PritomnyZakaznikException;
import sk.upjs.ics.paz1c.fitnesscentrum.manager.KlucManager;
import sk.upjs.ics.paz1c.fitnesscentrum.manager.VstupneManager;
import sk.upjs.ics.paz1c.fitnesscentrum.manager.ZakaznikManager;

public class DefaultZakaznikManagerTest extends PripravaNaTestovanie {

    public DefaultZakaznikManagerTest() {
    }

    private final ZakaznikManager zakaznikManager = ObjectFactory.INSTANCE.getZakaznikManager();
    private final KlucManager klucManager = ObjectFactory.INSTANCE.getKlucManager();
    private final VstupneManager vstupneManager = ObjectFactory.INSTANCE.getVstupneManager();

    /**
     * Test of zmazZakaznika method, of class DefaultZakaznikManager.
     * @throws sk.upjs.ics.paz1c.fitnesscentrum.exception.PritomnyZakaznikException
     */
    @Test
    public void testZmazZakaznika() throws PritomnyZakaznikException {
        Long id = 4L;
        Zakaznik zakaznik = zakaznikManager.dajZakaznikaSId(id);
        zakaznikManager.zmazZakaznika(zakaznik);
        List<Zakaznik> list = zakaznikManager.dajVsetkychZakaznikov();

        boolean jeOdstraneny = true;
        for (Zakaznik z : list) {
            if (Objects.equals(z.getId(), id)) {
                jeOdstraneny = false;
            }
        }
        assertTrue(jeOdstraneny);

        // skusime vymazat pritomneho zakaznika
        Long id2 = 5L;
        Zakaznik zakaznik2 = zakaznikManager.dajZakaznikaSId(id2);
        try {
            zakaznikManager.zmazZakaznika(zakaznik2);
        } catch (PritomnyZakaznikException e) {
            // OK
        }
        List<Zakaznik> list2 = zakaznikManager.dajVsetkychZakaznikov();

        boolean nevymazany = false;
        for (Zakaznik z : list2) {
            if (Objects.equals(z.getId(), id2)) {
                nevymazany = true;
            }
        }
        assertTrue(nevymazany);

    }

    /**
     * Test of odchodZakaznika method, of class DefaultZakaznikManager.
     */
    @Test
    public void testOdchodZakaznika() {
        int povodnyPocetVolnychKlucov = klucManager.dajVolneKluce().size();
        Long idZakaznika = 3L;
        Zakaznik zakaznik = zakaznikManager.dajZakaznikaSId(idZakaznika);
        Kluc kluc = zakaznik.getKluc();
        Long idKluca = kluc.getId();
        zakaznikManager.odchodZakaznika(idZakaznika);
        zakaznik = zakaznikManager.dajZakaznikaSId(idZakaznika);
        int novyPocetVolnychKlucov = klucManager.dajVolneKluce().size();
        kluc = klucManager.dajKlucSId(idKluca);
        // testujeme pritomnost zakaznika
        assertFalse(zakaznik.isPritomny());
        // testujeme, ci sa pri odchode uvolnil zakazikov kluc
        assertTrue(povodnyPocetVolnychKlucov + 1 == novyPocetVolnychKlucov);
        assertNull(zakaznik.getKluc());
        assertNull(kluc.getZakaznik());
    }

    /**
     * Test of dajZakaznikaSCislomPermanentky method, of class
     * DefaultZakaznikManager.
     * @throws sk.upjs.ics.paz1c.fitnesscentrum.exception.NeexistujuciZakaznikException
     */
    @Test
    public void testDajZakaznikaSCislomPermanentky() throws NeexistujuciZakaznikException {
        String cisloPermanentky = "111";
        Zakaznik zakaznik = zakaznikManager.dajZakaznikaSCislomPermanentky(cisloPermanentky);
        assertTrue(zakaznik.getId() == 2L);
    }

    /**
     * Test of pridajZakaznika method, of class DefaultZakaznikManager.
     * @throws sk.upjs.ics.paz1c.fitnesscentrum.exception.PrazdnyRetazecException
     */
    @Test
    public void testPridajZakaznika() throws DuplicateKeyException, PrazdnyRetazecException {
        int povodnaSize = zakaznikManager.dajVsetkychZakaznikov().size();
        Zakaznik zakaznik = new Zakaznik();
        zakaznik.setMeno("Adam");
        zakaznik.setCisloPermanentky("12345");
        zakaznikManager.pridajZakaznika(zakaznik);
        int novaSize = zakaznikManager.dajVsetkychZakaznikov().size();
        assertEquals(povodnaSize + 1, novaSize);

        //skuska pridania zakaznika s rovnakym cislom perm.
        int povodnaSize2 = zakaznikManager.dajVsetkychZakaznikov().size();
        Zakaznik zakaznik2 = new Zakaznik();
        zakaznik2.setMeno("Eva");
        zakaznik2.setCisloPermanentky("12345");
        try {
            zakaznikManager.pridajZakaznika(zakaznik2);
        } catch (DuplicateKeyException e) {
            //Ok
        }
        int novaSize2 = zakaznikManager.dajVsetkychZakaznikov().size();
        // testuje, ze zakaznik sa naozaj NEPRIDAL
        assertEquals(povodnaSize2, novaSize2);
        
         //skuska pridania zakaznika bez mena.
        int povodnaSize3 = zakaznikManager.dajVsetkychZakaznikov().size();
        Zakaznik zakaznik3 = new Zakaznik();
        zakaznik3.setMeno("");
        zakaznik3.setCisloPermanentky("1");
        try {
            zakaznikManager.pridajZakaznika(zakaznik3);
        } catch (PrazdnyRetazecException e) {
            //Ok
        }
        int novaSize3 = zakaznikManager.dajVsetkychZakaznikov().size();
        // testuje, ze zakaznik sa naozaj NEPRIDAL
        assertEquals(povodnaSize3, novaSize3);
        
        //skuska pridania zakaznika s pernamentkou bez cisla.
        int povodnaSize4 = zakaznikManager.dajVsetkychZakaznikov().size();
        Zakaznik zakaznik4 = new Zakaznik();
        zakaznik4.setMeno("aaa");
        zakaznik4.setCisloPermanentky("");
        try {
            zakaznikManager.pridajZakaznika(zakaznik4);
        } catch (PrazdnyRetazecException e) {
            //Ok
        }
        int novaSize4 = zakaznikManager.dajVsetkychZakaznikov().size();
        // testuje, ze zakaznik sa naozaj NEPRIDAL
        assertEquals(povodnaSize4, novaSize4);

    }

    /**
     * Test of dajZakaznikaSId method, of class DefaultZakaznikManager.
     */
    @Test
    public void testDajZakaznikaSId() {
        Long id = 2L;
        Zakaznik zakaznik = zakaznikManager.dajZakaznikaSId(id);
        assertEquals(zakaznik.getMeno(), "Jane Doe");
    }

    /**
     * Test of prichodZakaznika method, of class DefaultZakaznikManager.
     */
    @Test
    public void testPrichodZakaznika() {
        int povodnyPocetVolnychKlucov = klucManager.dajVolneKluce().size();
        Long idZakaznika = 2L;
        Long idKluca = 1L;
        Zakaznik zakaznik = zakaznikManager.dajZakaznikaSId(idZakaznika);
        Kluc kluc = klucManager.dajKlucSId(idKluca);
        zakaznikManager.prichodZakaznika(zakaznik, kluc);
        zakaznik = zakaznikManager.dajZakaznikaSId(idZakaznika);
        kluc = klucManager.dajKlucSId(idKluca);
        int novyPocetVolnychKlucov = klucManager.dajVolneKluce().size();
        // testujeme pritomnost zakaznika
        assertTrue(zakaznik.isPritomny());
        // testujeme, ci sa pri pri prichode priradil kluc zakaznikovi, zakaznik klucu
        assertTrue(povodnyPocetVolnychKlucov - 1 == novyPocetVolnychKlucov);
        assertEquals(zakaznik.getKluc().getId(), kluc.getId());
        assertEquals(kluc.getZakaznik().getId(), zakaznik.getId());
    }

    /**
     * Test of prichodKartouZakaznika method, of class DefaultZakaznikManager.
     */
    @Test
    public void testPrichodKartouZakaznika() throws Exception {
        int povodnyPocetVolnychKlucov = klucManager.dajVolneKluce().size();
        Long idZakaznika = 6L;
        Long idKluca = 3L;
        double cenaVstupneho = vstupneManager.dajCeny().getCenaVstupneho();
        Zakaznik zakaznik = zakaznikManager.dajZakaznikaSId(idZakaznika);
        Kluc kluc = klucManager.dajKlucSId(idKluca);
        double povodnyKredit = zakaznik.getKredit();
        zakaznikManager.prichodKartouZakaznika(zakaznik, kluc);
        zakaznik = zakaznikManager.dajZakaznikaSId(idZakaznika);
        kluc = klucManager.dajKlucSId(idKluca);
        int novyPocetVolnychKlucov = klucManager.dajVolneKluce().size();
        double novyKredit = zakaznik.getKredit();
        // testujeme pritomnost zakaznika
        assertTrue(zakaznik.isPritomny());
        // testujeme, ci sa pri pri prichode priradil kluc zakaznikovi, zakaznik klucu
        assertTrue(povodnyPocetVolnychKlucov - 1 == novyPocetVolnychKlucov);
        assertEquals(zakaznik.getKluc().getId(), kluc.getId());
        assertEquals(kluc.getZakaznik().getId(), zakaznik.getId());
        //testujeme, ci bol spravne stiahnuty kredit
        assertTrue(povodnyKredit-cenaVstupneho==novyKredit);
        
        // testujeme pripad s nedostatocnym kreditom
        int povodnyPocetVolnychKlucov2 = klucManager.dajVolneKluce().size();
        Long idZakaznika2 = 7L;
        Long idKluca2 = 4L;
        Zakaznik zakaznik2 = zakaznikManager.dajZakaznikaSId(idZakaznika2);
        Kluc kluc2 = klucManager.dajKlucSId(idKluca2);
        double povodnyKredit2 = zakaznik2.getKredit();
        try {
        zakaznikManager.prichodKartouZakaznika(zakaznik2, kluc2);
        }catch (NedostatocnyKreditException e) {
            //ok
        }
        zakaznik2 = zakaznikManager.dajZakaznikaSId(idZakaznika2);
        kluc2 = klucManager.dajKlucSId(idKluca2);
        int novyPocetVolnychKlucov2 = klucManager.dajVolneKluce().size();
        double novyKredit2 = zakaznik2.getKredit();
        // testujeme pritomnost zakaznika 
        assertFalse(zakaznik2.isPritomny());
        // testujeme, ci ostal povodny pocet volnych klucov
        assertTrue(povodnyPocetVolnychKlucov2 == novyPocetVolnychKlucov2);
        assertNull(zakaznik2.getKluc());
        assertNull(kluc2.getZakaznik());
        //testujeme, ci ostal povodny kredit
        assertTrue(povodnyKredit2==novyKredit2);
    }

    /**
     * Test of dajVsetkychZakaznikov method, of class DefaultZakaznikManager.
     */
    @Test
    public void testDajVsetkychZakaznikov() {
        List<Zakaznik> list = zakaznikManager.dajVsetkychZakaznikov();
        assertTrue(list.size() > 0);
    }

    /**
     * Test of dajPritomnychZakaznikov method, of class DefaultZakaznikManager.
     */
    @Test
    public void testDajPritomnychZakaznikov() {
        boolean vsetciPritomni = true;
        List<Zakaznik> list = zakaznikManager.dajPritomnychZakaznikov();
        for (Zakaznik zakaznik : list) {
            if (!zakaznik.isPritomny()) {
                vsetciPritomni = false;
            }
        }
        assertTrue(list.size() > 0);
        assertTrue(vsetciPritomni);
    }

    /**
     * Test of dajZakaznikovSoZhodouVMene method, of class
     * DefaultZakaznikManager.
     */
    @Test
    public void testDajZakaznikovSoZhodouVMene() {
        String vzorka = "Doe";
        List<Zakaznik> list = zakaznikManager.dajZakaznikovSoZhodouVMene(vzorka);
        boolean nezhodujeSa = false;
        for (Zakaznik zakaznik : list) {
            if (!zakaznik.getMeno().contains(vzorka)) {
                nezhodujeSa = true;
            }
        }
        assertFalse(nezhodujeSa);
        assertEquals(list.size(), 2);
    }

}
