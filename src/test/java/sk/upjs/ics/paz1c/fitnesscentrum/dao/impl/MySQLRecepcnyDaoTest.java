package sk.upjs.ics.paz1c.fitnesscentrum.dao.impl;

import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;
import sk.upjs.ics.paz1c.fitnesscentrum.exception.NevalidnyVstupException;
import sk.upjs.ics.paz1c.fitnesscentrum.ObjectFactory;
import sk.upjs.ics.paz1c.fitnesscentrum.dao.RecepcnyDao;
import sk.upjs.ics.paz1c.fitnesscentrum.entity.Recepcny;
import sk.upjs.ics.paz1c.fitnesscentrum.exception.DuplikovanyLoginException;

public class MySQLRecepcnyDaoTest extends PripravaNaTestovanie {

    private final RecepcnyDao recepcnyDao = ObjectFactory.INSTANCE.getRecepcnyDao();

    /**
     * Test of dajRecepcneho method, of class MySQLRecepcnyDao.
     */
    @Test
    public void testDajRecepcneho_String() {
        String login = "ferko";
        Recepcny result = recepcnyDao.dajRecepcneho(login);
        assertNotNull(result);
    }

    /**
     * Test of dajVsetkychRecepcnych method, of class MySQLRecepcnyDao.
     */
    @Test
    public void testDajVsetkychRecepcnych() {
        List<Recepcny> result = recepcnyDao.dajVsetkychRecepcnych();
        assertEquals(1, result.size());
    }

    /**
     * Test of pridajRecepcneho method, of class MySQLRecepcnyDao.
     *
     * @throws
     * sk.upjs.ics.paz1c.fitnesscentrum.exception.NevalidnyVstupException
     */
    @Test
    public void testPridajRecepcneho() throws NevalidnyVstupException, DuplikovanyLoginException {
        Recepcny recepcny = new Recepcny();
        String meno = "Jozko Mrkvicka";
        String login = "jozko";
        String heslo = "0000";

        recepcny.setMeno(meno);
        recepcny.setLogin(login);
        recepcny.setHeslo(heslo);

        recepcnyDao.pridajRecepcneho(recepcny);

        List<Recepcny> listRecepcnych = recepcnyDao.dajVsetkychRecepcnych();
        boolean jePridany = false;
        for (Recepcny r : listRecepcnych) {
            if (r.getLogin().equals(login)) {
                jePridany = true;
            }
        }
        assertTrue(jePridany);
    }

    /**
     * Test unikatneho loginu pre pridajRecepcneho method, of class
     * MySQLRecepcnyDao.
     *
     * @throws
     * sk.upjs.ics.paz1c.fitnesscentrum.exception.NevalidnyVstupException
     */
    @Test
    public void testPridajRovnakehoRecepcneho() throws NevalidnyVstupException, DuplikovanyLoginException {

        Recepcny recepcny = new Recepcny();
        String meno = "Jozko Mrkvicka";
        String login = "jozko";
        String heslo = "0000";

        recepcny.setMeno(meno);
        recepcny.setLogin(login);
        recepcny.setHeslo(heslo);

        recepcnyDao.pridajRecepcneho(recepcny);
        int povodnyPocetRecepcnych = recepcnyDao.dajVsetkychRecepcnych().size();

        try {
            recepcnyDao.pridajRecepcneho(recepcny);
        } catch (Exception e) {
            // Vsetko v poriadku, login recepneho musi byt unikatny
        }

        int novyPocetRecepcnych = recepcnyDao.dajVsetkychRecepcnych().size();
        //testuje sa, ci sa naozaj nepridal recepcny s rovnakym loginom
        assertEquals(povodnyPocetRecepcnych, novyPocetRecepcnych);
    }

    /**
     * Test of vymazRecepcneho method, of class MySQLRecepcnyDao.
     */
    @Test
    public void testVymazRecepcneho() {
        Long idRecepcny = 2L;
        Recepcny recepcny = recepcnyDao.dajRecepcneho(idRecepcny);
        recepcnyDao.vymazRecepcneho(recepcny);
        List<Recepcny> listRecepcnych = recepcnyDao.dajVsetkychRecepcnych();

        boolean jeOdstraneny = true;
        for (Recepcny r : listRecepcnych) {
            if (r.getId().equals(idRecepcny)) {
                jeOdstraneny = false;
            }
        }
        assertTrue(jeOdstraneny);
    }

    /**
     * Test of dajRecepcneho method, of class MySQLRecepcnyDao.
     */
    @Test
    public void testDajRecepcneho_Long() {
        Long idRecepcny = 2L;
        Recepcny result = recepcnyDao.dajRecepcneho(idRecepcny);
        assertNotNull(result);
    }

    /**
     * Test of updateRecepcneho method, of class MySQLRecepcnyDao.
     */
    @Test
    public void testUpdateRecepcneho() {
        String noveHeslo = "noveHeslo";
        Recepcny recepcny = recepcnyDao.dajRecepcneho(2L);
        recepcny.setHeslo(noveHeslo);
        recepcnyDao.zmenaHeslaRecepcneho(recepcny);
        recepcny = recepcnyDao.dajRecepcneho(2L);
        assertEquals(recepcny.getHeslo(), noveHeslo);

    }

}
