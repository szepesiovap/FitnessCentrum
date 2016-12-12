package sk.upjs.ics.paz1c.fitnesscentrum.manager.impl;

import sk.upjs.ics.paz1c.fitnesscentrum.manager.SpinningManager;
import java.time.LocalDateTime;
import java.util.List;
import sk.upjs.ics.paz1c.fitnesscentrum.ObjectFactory;
import sk.upjs.ics.paz1c.fitnesscentrum.dao.RezervaciaDao;
import sk.upjs.ics.paz1c.fitnesscentrum.dao.SpinningDao;
import sk.upjs.ics.paz1c.fitnesscentrum.dao.ZakaznikDao;
import sk.upjs.ics.paz1c.fitnesscentrum.entity.Rezervacia;
import sk.upjs.ics.paz1c.fitnesscentrum.entity.Spinning;
import sk.upjs.ics.paz1c.fitnesscentrum.entity.Zakaznik;
import sk.upjs.ics.paz1c.fitnesscentrum.exception.NedostatocnyKreditException;

public class DefaultSpinningManager implements SpinningManager {

    private final ZakaznikDao zakaznikDao = ObjectFactory.INSTANCE.getZakaznikDao();
    private final SpinningDao spinningDao = ObjectFactory.INSTANCE.getSpinningDao();
    private final RezervaciaDao rezervaciaDao = ObjectFactory.INSTANCE.getRezervaciaDao();

    @Override
    public void rezervovatSpinning(Rezervacia rezervacia) {
        rezervaciaDao.pridajRezervaciu(rezervacia);
        spinningDao.rezervujSpinning(rezervacia.getSpinning());
    }

    @Override
    public void rezervovatSpinningKartou(Spinning spinning, Zakaznik zakaznik) throws NedostatocnyKreditException {
        double SUMA = ObjectFactory.INSTANCE.getVstupneDao().dajCeny().getCenaSpinnigu();
        if (zakaznik.getKredit() <= SUMA) {
            throw new NedostatocnyKreditException();
        } else {
            Rezervacia rezervacia = new Rezervacia();
            rezervacia.setSpinning(spinning);
            rezervacia.setZakaznik(zakaznik);
            rezervacia.setCasRezervacie(LocalDateTime.now());
            spinningDao.rezervujSpinning(spinning);
            zakaznikDao.stiahniKreditZakaznikovi(zakaznik, SUMA);
            rezervaciaDao.pridajRezervaciu(rezervacia);
        }
    }

    @Override
    public void pridajSpinning(Spinning spinning) {
        spinningDao.pridajSpinning(spinning);
    }

    @Override
    public void odhlasitZoSpinningu(Rezervacia rezervacia, Spinning spinning) {
        rezervaciaDao.odstranRezervacia(rezervacia);
        spinningDao.odrezervujSpinning(spinning);
    }

    @Override
    public Spinning dajSpinningSId(Long idSpinningu) {
        return spinningDao.dajSpinningSId(idSpinningu);
    }

    @Override
    public void vymazSpinning(Spinning spinning) {
        spinningDao.vymazSpinning(spinning);
    }

    @Override
    public List<Spinning> dajSpinningyOdDatumu(LocalDateTime datum) {
        return spinningDao.dajSpinningyOdDatumu(datum);
    }

    @Override
    public List<Spinning> dajVsetkySpinningy() {
        return spinningDao.dajVsetkySpinningy();
    }

}
