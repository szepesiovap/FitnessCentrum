package sk.upjs.ics.paz1c.fitnesscentrum.manager.impl;

import org.junit.Test;
import static org.junit.Assert.*;
import sk.upjs.ics.paz1c.fitnesscentrum.Hashovanie;
import sk.upjs.ics.paz1c.fitnesscentrum.ObjectFactory;
import sk.upjs.ics.paz1c.fitnesscentrum.dao.impl.PripravaNaTestovanie;
import sk.upjs.ics.paz1c.fitnesscentrum.entity.Recepcny;
import sk.upjs.ics.paz1c.fitnesscentrum.manager.HesloManager;

public class DefaultHesloManagerTest extends PripravaNaTestovanie{

    private final HesloManager hesloManager = ObjectFactory.INSTANCE.getHesloManager();

    /**
     * Test of overZhoduHesiel method, of class DefaultHesloManager.
     */
    @Test
    public void testOverZhoduHesiel() {
        String zadaneHeslo = "heslo";
        String hesloVDb = "heslo";
        boolean result = hesloManager.overZhoduHesiel(zadaneHeslo, hesloVDb);
        assertTrue(result);
    }

    /**
     * Test of zahesujHeslo method, of class DefaultHesloManager.
     */
    @Test
    public void testZahesujHeslo() {
        String salt = "158a9dd4-ff01-4835-a2ce-a317e47183bc";
        String heslo = "1111";
        String expResult = Hashovanie.zahesuj(salt, heslo);
        String result = hesloManager.zahesujHeslo(salt, heslo);
        assertEquals(expResult, result);
    }

    /**
     * Test of overHeslo method, of class DefaultHesloManager.
     */
    @Test
    public void testOverHeslo() {
        Long idRecepcny = 2L;
        Recepcny recepcny = ObjectFactory.INSTANCE.getRecepcnyDao().dajRecepcneho(idRecepcny);
        String salt = recepcny.getSalt();
        String zadaneHeslo = "1111";

        boolean result = hesloManager.overHeslo(salt, zadaneHeslo, idRecepcny);
        assertTrue(result);
    }
    
}
