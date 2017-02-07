package sk.upjs.ics.paz1c.fitnesscentrum.manager.impl;

import static org.junit.Assert.*;
import org.junit.Test;
import sk.upjs.ics.paz1c.fitnesscentrum.ObjectFactory;
import sk.upjs.ics.paz1c.fitnesscentrum.dao.impl.PripravaNaTestovanie;
import sk.upjs.ics.paz1c.fitnesscentrum.entity.Vstupne;
import sk.upjs.ics.paz1c.fitnesscentrum.manager.VstupneManager;

public class DefaultVstupneManagerTest extends PripravaNaTestovanie {

    private final VstupneManager vstupneManager = ObjectFactory.INSTANCE.getVstupneManager();

    public DefaultVstupneManagerTest() {
    }

    /**
     * Test of nastavCeny method, of class DefaultVstupneManager.
     */
    @Test
    public void testNastavCeny() {
        double cenaVstupneho = 2.75;
        double cenaCvicenia = 3.2;
        vstupneManager.nastavCeny(cenaVstupneho, cenaCvicenia);
        assertTrue(vstupneManager.dajCeny().getCenaVstupneho() == cenaVstupneho);
        assertTrue(vstupneManager.dajCeny().getCenaCvicenia() == cenaCvicenia);
        //nastavujeme na povodne kvoli dalsim metodam
        cenaVstupneho = 3.0;
        cenaCvicenia = 5.0;
        vstupneManager.nastavCeny(cenaVstupneho, cenaCvicenia);
        assertTrue(vstupneManager.dajCeny().getCenaVstupneho() == cenaVstupneho);
        assertTrue(vstupneManager.dajCeny().getCenaCvicenia() == cenaCvicenia);
    }

    /**
     * Test of dajCeny method, of class DefaultVstupneManager.
     */
    @Test
    public void testDajCeny() {
        double ocakavanaCenaVstupneho = 3;
        double ocakavanaCenaCvicenia = 5;
        Vstupne vstupne = vstupneManager.dajCeny();
        double vratenaCenaVstupneho = vstupne.getCenaVstupneho();
        double vratenaCenaCvicenia = vstupne.getCenaCvicenia();
        assertTrue(ocakavanaCenaVstupneho == vratenaCenaVstupneho);
        assertTrue(ocakavanaCenaCvicenia == vratenaCenaCvicenia);
    }

}
