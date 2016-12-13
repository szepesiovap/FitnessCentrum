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
import sk.upjs.ics.paz1c.fitnesscentrum.entity.Instruktor;
import sk.upjs.ics.paz1c.fitnesscentrum.entity.Rezervacia;
import sk.upjs.ics.paz1c.fitnesscentrum.entity.Spinning;
import sk.upjs.ics.paz1c.fitnesscentrum.entity.Zakaznik;
import sk.upjs.ics.paz1c.fitnesscentrum.exception.NedostatocnyKreditException;
import sk.upjs.ics.paz1c.fitnesscentrum.manager.SpinningManager;

public class DefaultSpinningManagerTest extends PripravaNaTestovanie {

    private final SpinningManager spinningManager = ObjectFactory.INSTANCE.getSpinningManager();
    private final RezervaciaDao rezervaciaDao = ObjectFactory.INSTANCE.getRezervaciaDao();
    private final ZakaznikDao zakaznikDao = ObjectFactory.INSTANCE.getZakaznikDao();
    private final InstruktorDao instruktorDao = ObjectFactory.INSTANCE.getInstruktorDao();
    
    /**
     * Test of rezervovatSpinning method, of class DefaultSpinningManager.
     */
    @Test

    public void testRezervovatSpinning() {
        Rezervacia rezervacia = rezervaciaDao.dajRezervaciuSId(1L);
        Long idSpinningu = rezervacia.getSpinning().getId();
        int predRezervovanim = spinningManager.dajSpinningSId(idSpinningu).getVolne();
        spinningManager.rezervovatSpinning(rezervacia);
        int poRezervovani = spinningManager.dajSpinningSId(idSpinningu).getVolne();
        assertEquals(predRezervovanim - 1, poRezervovani);
    }

    /**
     * Test of rezervovatSpinningKartou method, of class DefaultSpinningManager.
     */
    @Test
    public void testRezervovatSpinningKartou() throws NedostatocnyKreditException {
        Spinning spinning = spinningManager.dajSpinningSId(1L);
        Zakaznik zakaznik = zakaznikDao.dajZakaznikaSId(2L);
        int predRezervovanim = spinningManager.dajSpinningSId(spinning.getId()).getVolne();
        spinningManager.rezervovatSpinningKartou(spinning, zakaznik);
        int poRezervovani = spinningManager.dajSpinningSId(spinning.getId()).getVolne();
        assertEquals(predRezervovanim - 1, poRezervovani);
    }

    /**
     * Test of pridajSpinning method, of class DefaultSpinningManager.
     */
    @Test
    public void testPridajSpinning() {
        Spinning spinning = new Spinning();
        Instruktor instruktor = instruktorDao.dajInstruktoraSId(1L);
        spinning.setDatum(LocalDateTime.now());
        spinning.setKapacita(10);
        spinning.setInstruktor(instruktor);
        int vsetkySpinningyPred = spinningManager.dajVsetkySpinningy().size();
        spinningManager.pridajSpinning(spinning);
        int vsetkySpinningyPo = spinningManager.dajVsetkySpinningy().size();
        assertEquals(vsetkySpinningyPred + 1, vsetkySpinningyPo);
    }

    /**
     * Test of odhlasitZoSpinningu method, of class DefaultSpinningManager.
     */
    @Test
    public void testOdhlasitZoSpinningu() {

        System.out.println("odhlasitZoSpinningu");
        Rezervacia rezervacia = rezervaciaDao.dajRezervaciuSId(1L);
        Spinning spinning = spinningManager.dajSpinningSId(1L);
        int predRezervovanim = spinning.getVolne();
        spinningManager.odhlasitZoSpinningu(rezervacia, spinning);
        int poRezervovani = spinningManager.dajSpinningSId(spinning.getId()).getVolne();
        assertEquals(predRezervovanim + 1, poRezervovani);
    }

    /**
     * Test of dajSpinningSId method, of class DefaultSpinningManager.
     */
    @Test
    public void testDajSpinningSId() {
        Spinning spinning = spinningManager.dajSpinningSId(1L);
        assertNotNull(spinning);
    }

    /**
     * Test of vymazSpinning method, of class DefaultSpinningManager.
     */
    @Test
    public void testVymazSpinning() {
        int spinningPred = spinningManager.dajVsetkySpinningy().size();
        Spinning spinning = spinningManager.dajSpinningSId(1L);
        spinningManager.vymazSpinning(spinning);
        int spinningPo = spinningManager.dajVsetkySpinningy().size();
        assertEquals(spinningPred - 1, spinningPo);
    }

    /**
     * Test of dajSpinningyOdDatumu method, of class DefaultSpinningManager.
     */
    @Test
    public void testDajSpinningyOdDatumu() {
        LocalDateTime lcd = LocalDateTime.of(2016, Month.DECEMBER, 23, 0, 0);
        List<Spinning> listSpinnigov = spinningManager.dajSpinningyOdDatumu(lcd);
        assertEquals(listSpinnigov.size(), 2);
    }

    /**
     * Test of dajVsetkySpinningy method, of class DefaultSpinningManager.
     */
    @Test
    public void testDajVsetkySpinningy() {
        int vsetkySpinnigy = spinningManager.dajVsetkySpinningy().size();
        assertEquals(3, vsetkySpinnigy);
    }

}
