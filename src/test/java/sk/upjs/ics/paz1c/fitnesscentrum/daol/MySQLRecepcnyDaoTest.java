package sk.upjs.ics.paz1c.fitnesscentrum.daol;

import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;
import org.springframework.dao.DuplicateKeyException;
import sk.upjs.ics.paz1c.fitnesscentrum.ObjectFactory;
import sk.upjs.ics.paz1c.fitnesscentrum.dao.RecepcnyDao;
import sk.upjs.ics.paz1c.fitnesscentrum.entity.Recepcny;

public class MySQLRecepcnyDaoTest extends PripravaNaTestovanie {

    private static final RecepcnyDao recepcnyDao = ObjectFactory.INSTANCE.getRecepcnyDao();

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
     */
    @Test
    public void testPridajRecepcneho() {
        Recepcny recepcny = new Recepcny();
        String meno = "Jozko Mrkvicka";
        String login = "jozko";

        recepcny.setMeno(meno);
        recepcny.setLogin(login);
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
     * Test unikatneho loginu pre pridajRecepcneho method, of class MySQLRecepcnyDao.
     */
    @Test
    public void testPridajRovnakehoRecepcneho() {
        Recepcny recepcny = new Recepcny();
        String meno = "Jozko Mrkvicka";
        String login = "jozko";

        recepcny.setMeno(meno);
        recepcny.setLogin(login);
        recepcnyDao.pridajRecepcneho(recepcny);
        try{
        recepcnyDao.pridajRecepcneho(recepcny);
        fail("Login musi byt unikatny.");
        } catch (DuplicateKeyException e){
            // Vsetko v poriadku, login recepneho musi byt unikatny
        }
    }

    /**
     * Test of vymazRecepcneho method, of class MySQLRecepcnyDao.
     */
    @Test
    public void testVymazRecepcneho() {
        Long idRecepcny = 2L;
        recepcnyDao.vymazRecepcneho(idRecepcny);
        List<Recepcny> listRecepcnych = recepcnyDao.dajVsetkychRecepcnych();
        
        boolean jeOdstraneny = true;
        for(Recepcny r : listRecepcnych){
            if(r.getId().equals(idRecepcny)){
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
        recepcnyDao.updateRecepcneho(recepcny);
        recepcny = recepcnyDao.dajRecepcneho(2L);
        assertEquals(recepcny.getHeslo(), noveHeslo);
        
    }

}
