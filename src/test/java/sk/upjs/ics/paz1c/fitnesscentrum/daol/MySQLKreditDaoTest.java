package sk.upjs.ics.paz1c.fitnesscentrum.daol;

import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;
import sk.upjs.ics.paz1c.fitnesscentrum.DaoFactory;
import sk.upjs.ics.paz1c.fitnesscentrum.dao.KreditDao;
import sk.upjs.ics.paz1c.fitnesscentrum.entity.Kredit;

public class MySQLKreditDaoTest extends PripravaNaTestovanie {

    private static final KreditDao kreditDao = DaoFactory.INSTANCE.getKreditDao();

    /**
     * Test of dajVsetkyKredity method, of class MySQLKreditDao.
     */
    @Test
    public void testDajVsetkyKredity() {
        List<Kredit> result = kreditDao.dajVsetkyKredity();
        assertEquals(3, result.size());
    }

    /**
     * Test of pridajKredit method, of class MySQLKreditDao.
     */
    @Test
    public void testPridajKredit() {
        Kredit kredit = new Kredit();
        String nazov = "100 eur";
        kredit.setNazov(nazov);
        kredit.setCena(100);
        kreditDao.pridajKredit(kredit);
        List<Kredit> listKreditov = kreditDao.dajVsetkyKredity();
        boolean jePridany = false;
        for (Kredit k : listKreditov) {
            if (k.getNazov().equals(nazov)) {
                jePridany = true;
            }
        }
        assertTrue(jePridany);
    }

    /**
     * Test of vymazKredit method, of class MySQLKreditDao.
     */
    @Test
    public void testVymazKredit() {
        Long idKredit = 1L;
        kreditDao.vymazKredit(idKredit);
        List <Kredit> listKreditov = kreditDao.dajVsetkyKredity();
        boolean jeOdstraneny = true;
        for(Kredit k : listKreditov){
            if(k.getId().equals(idKredit)){
            jeOdstraneny = false;
            }
        }
        assertTrue(jeOdstraneny);
    }

    /**
     * Test of dajKreditSId method, of class MySQLKreditDao.
     */
    @Test
    public void testDajKreditSId() {
        Long idKluca = 1L;
        Kredit result = kreditDao.dajKreditSId(idKluca);
        assertNotNull(result);
    }

}
