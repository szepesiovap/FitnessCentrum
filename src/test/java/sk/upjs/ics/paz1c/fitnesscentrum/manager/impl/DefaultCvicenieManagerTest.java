package sk.upjs.ics.paz1c.fitnesscentrum.manager.impl;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;
import sk.upjs.ics.paz1c.fitnesscentrum.ObjectFactory;
import sk.upjs.ics.paz1c.fitnesscentrum.dao.InstruktorDao;
import sk.upjs.ics.paz1c.fitnesscentrum.dao.RezervaciaDao;
import sk.upjs.ics.paz1c.fitnesscentrum.dao.ZakaznikDao;
import sk.upjs.ics.paz1c.fitnesscentrum.dao.impl.PripravaNaTestovanie;
import sk.upjs.ics.paz1c.fitnesscentrum.entity.Cvicenie;
import sk.upjs.ics.paz1c.fitnesscentrum.entity.Instruktor;
import sk.upjs.ics.paz1c.fitnesscentrum.entity.Rezervacia;
import sk.upjs.ics.paz1c.fitnesscentrum.entity.Spinning;
import sk.upjs.ics.paz1c.fitnesscentrum.entity.Zakaznik;
import sk.upjs.ics.paz1c.fitnesscentrum.exception.NedostatocnyKreditException;
import sk.upjs.ics.paz1c.fitnesscentrum.manager.CvicenieManager;
import sk.upjs.ics.paz1c.fitnesscentrum.manager.SpinningManager;

public class DefaultCvicenieManagerTest extends PripravaNaTestovanie {

    private final CvicenieManager cvicenieManager = ObjectFactory.INSTANCE.getCvicenieManager();
    private final RezervaciaDao rezervaciaDao = ObjectFactory.INSTANCE.getRezervaciaDao();
    private final ZakaznikDao zakaznikDao = ObjectFactory.INSTANCE.getZakaznikDao();
    private final InstruktorDao instruktorDao = ObjectFactory.INSTANCE.getInstruktorDao();
    
    /**
     * Test of rezervovatSpinning method, of class DefaultSpinningManager.
     */
    @Test

    public void testRezervovatCvicenie() {
        Rezervacia rezervacia = rezervaciaDao.dajRezervaciuSId(1L);
        Long idCvicenia = rezervacia.getCvicenie().getId();
        int predRezervovanim = cvicenieManager.dajCvicenieSId(idCvicenia).getVolne();
        cvicenieManager.rezervovatCvicenie(rezervacia);
        int poRezervovani = cvicenieManager.dajCvicenieSId(idCvicenia).getVolne();
        assertEquals(predRezervovanim - 1, poRezervovani);
    }

    /**
     * Test of rezervovatSpinningKartou method, of class DefaultSpinningManager.
     */
    @Test
    public void testRezervovatCvicenieKartou() throws NedostatocnyKreditException {
        Cvicenie cvicenie = cvicenieManager.dajCvicenieSId(1L);
        Zakaznik zakaznik = zakaznikDao.dajZakaznikaSId(2L);
        int predRezervovanim = cvicenieManager.dajCvicenieSId(cvicenie.getId()).getVolne();
        cvicenieManager.rezervovatCvicenieKartou(cvicenie, zakaznik);
        int poRezervovani = cvicenieManager.dajCvicenieSId(cvicenie.getId()).getVolne();
        assertEquals(predRezervovanim - 1, poRezervovani);
    }

    /**
     * Test of pridajSpinning method, of class DefaultSpinningManager.
     */
    @Test
    public void testPridajCvicenie() {
        Cvicenie cvicenie = new Cvicenie();
        Instruktor instruktor = instruktorDao.dajInstruktoraSId(1L);
        cvicenie.setDatum(LocalDateTime.now());
        cvicenie.setKapacita(10);
        cvicenie.setInstruktor(instruktor);
        int vsetkyCviceniaPred = cvicenieManager.dajVsetkyCvicenia().size();
        cvicenieManager.pridajCvicenie(cvicenie);
        int vsetkyCviceniaPo = cvicenieManager.dajVsetkyCvicenia().size();
        assertEquals(vsetkyCviceniaPred + 1, vsetkyCviceniaPo);
    }

    /**
     * Test of odhlasitZoSpinningu method, of class DefaultSpinningManager.
     */
    @Test
    public void testOdhlasitZCvicenia() {

        Rezervacia rezervacia = rezervaciaDao.dajRezervaciuSId(1L);
        Cvicenie cvicenie = cvicenieManager.dajCvicenieSId(1L);
        int predRezervovanim = cvicenie.getVolne();
        cvicenieManager.odhlasitZCvicenia(rezervacia, cvicenie);
        int poRezervovani = cvicenieManager.dajCvicenieSId(cvicenie.getId()).getVolne();
        assertEquals(predRezervovanim + 1, poRezervovani);
    }

    /**
     * Test of dajSpinningSId method, of class DefaultSpinningManager.
     */
    @Test
    public void testDajCvicenieSId() {
        Cvicenie cvicenie = cvicenieManager.dajCvicenieSId(1L);
        assertNotNull(cvicenie);
    }

    /**
     * Test of vymazSpinning method, of class DefaultSpinningManager.
     */
    @Test
    public void testVymazCvicenie() {
        int cviceniePred = cvicenieManager.dajVsetkyCvicenia().size();
        Cvicenie cvicenie = cvicenieManager.dajCvicenieSId(1L);
        cvicenieManager.vymazCvicenie(cvicenie);
        int cviceniePo = cvicenieManager.dajVsetkyCvicenia().size();
        assertEquals(cviceniePred - 1, cviceniePo);
    }

    /**
     * Test of dajSpinningyOdDatumu method, of class DefaultSpinningManager.
     */
    @Test
    public void testDajCviceniaOdDatumu() {
        LocalDateTime lcd = LocalDateTime.of(2016, Month.DECEMBER, 23, 0, 0);
        List<Cvicenie> listCviceni = cvicenieManager.dajCviceniaOdDatumu(lcd);
        assertEquals(listCviceni.size(), 2);
    }

    /**
     * Test of dajVsetkySpinningy method, of class DefaultSpinningManager.
     */
    @Test
    public void testDajVsetkyCvicenia() {
        int vsetkyCvicenia = cvicenieManager.dajVsetkyCvicenia().size();
        assertEquals(3, vsetkyCvicenia);
    }

}
