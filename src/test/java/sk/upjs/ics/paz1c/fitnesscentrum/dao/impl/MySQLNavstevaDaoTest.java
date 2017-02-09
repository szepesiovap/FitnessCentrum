package sk.upjs.ics.paz1c.fitnesscentrum.dao.impl;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import static org.junit.Assert.*;
import java.util.List;
import org.junit.Test;
import sk.upjs.ics.paz1c.fitnesscentrum.ObjectFactory;
import sk.upjs.ics.paz1c.fitnesscentrum.dao.NavstevaDao;
import sk.upjs.ics.paz1c.fitnesscentrum.dao.ZakaznikDao;
import sk.upjs.ics.paz1c.fitnesscentrum.entity.Kluc;
import sk.upjs.ics.paz1c.fitnesscentrum.entity.Navsteva;
import sk.upjs.ics.paz1c.fitnesscentrum.entity.Zakaznik;

public class MySQLNavstevaDaoTest extends PripravaNaTestovanie {
    private final NavstevaDao navstevaDao = ObjectFactory.INSTANCE.getNavstevaDao();
    private final ZakaznikDao zakaznikDao = ObjectFactory.INSTANCE.getZakaznikDao();
    
    
    @Test
    public void testDajVsetkyNavstevyZakaznika() {
        Zakaznik zakaznik = zakaznikDao.dajZakaznikaSId(1L);
        List<Navsteva> navstevy = navstevaDao.dajVsetkyNavstevyZakaznika(zakaznik);
        assertTrue(navstevy.size() > 0);
    }
    
    @Test
    public void testDajVsetkyNavstevyVRozmedzi() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        List<Navsteva> navstevy = navstevaDao.dajVsetkyNavstevyVRozmedzi(
                LocalDateTime.parse("2016-12-01 00:00:00", dtf),
                LocalDateTime.parse("2016-12-31 00:00:00", dtf)
        );
        assertTrue(navstevy.size() > 0);
        assertEquals(
                navstevy.get(0).getPrichod(),
                LocalDateTime.parse("2016-12-03 11:00:00", dtf)
        );
    }

    @Test
    public void testDajNavstevySKlucom() {
        Kluc kluc = ObjectFactory.INSTANCE.getKlucDao().dajKlucSId(1L);
        List<Navsteva> navstevy = navstevaDao.dajNavstevySKlucom(kluc);
        assertEquals(2, navstevy.size());
    }

    @Test
    public void testDajNavstevuSId() {
        Navsteva n = navstevaDao.dajNavstevuSId(1L);
        assertNotNull(n);
        assertEquals(1L, (long) n.getId());
    }

    @Test
    public void testRegistrujPrichod() {
        Zakaznik zakaznik = zakaznikDao.dajZakaznikaSId(1L);
        Kluc kluc = ObjectFactory.INSTANCE.getKlucDao().dajKlucSId(1L);
        navstevaDao.registrujPrichod(zakaznik, kluc);
        List<Navsteva> n = navstevaDao.dajVsetkyNavstevyZakaznika(zakaznik);
        
        assertNotNull(n.get(n.size() - 1));
        assertNotNull(n.get(n.size() - 1).getPrichod());
        assertNull(n.get(n.size() - 1).getOdchod());
        assertEquals(kluc.getMeno(), n.get(n.size() - 1).getKluc().getMeno());
    }

    @Test
    public void testRegistrujOdchod() {
        Zakaznik zakaznik = zakaznikDao.dajZakaznikaSId(1L);
        Kluc kluc = ObjectFactory.INSTANCE.getKlucDao().dajKlucSId(1L);
        navstevaDao.registrujOdchod(zakaznik.getId());
        List<Navsteva> n = navstevaDao.dajVsetkyNavstevyZakaznika(zakaznik);
        
        assertNotNull(n.get(n.size() - 1).getOdchod());
        assertEquals(
                false,
                n.stream()
                 .map((t) -> {return t.getKluc();})
                 .anyMatch((k) -> {return k.equals(kluc);})
        );
    }

    @Test
    public void  testDajCasZakaznika() {
        Zakaznik zakaznik = zakaznikDao.dajZakaznikaSId(1L);
        int cas = navstevaDao.dajCasZakaznika(zakaznik);
        assertEquals(180, cas);
    }

}
