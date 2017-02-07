package sk.upjs.ics.paz1c.fitnesscentrum.manager.impl;

import sk.upjs.ics.paz1c.fitnesscentrum.manager.SpinningManager;
import java.time.LocalDateTime;
import java.util.List;
import sk.upjs.ics.paz1c.fitnesscentrum.ObjectFactory;
import sk.upjs.ics.paz1c.fitnesscentrum.dao.CvicenieDao;
import sk.upjs.ics.paz1c.fitnesscentrum.dao.RezervaciaDao;
import sk.upjs.ics.paz1c.fitnesscentrum.dao.SpinningDao;
import sk.upjs.ics.paz1c.fitnesscentrum.dao.VstupneDao;
import sk.upjs.ics.paz1c.fitnesscentrum.dao.ZakaznikDao;
import sk.upjs.ics.paz1c.fitnesscentrum.entity.Cvicenie;
import sk.upjs.ics.paz1c.fitnesscentrum.entity.Rezervacia;
import sk.upjs.ics.paz1c.fitnesscentrum.entity.Spinning;
import sk.upjs.ics.paz1c.fitnesscentrum.entity.Zakaznik;
import sk.upjs.ics.paz1c.fitnesscentrum.exception.NedostatocnyKreditException;
import sk.upjs.ics.paz1c.fitnesscentrum.manager.CvicenieManager;

public class DefaultCvicenieManager implements CvicenieManager {

    private final ZakaznikDao zakaznikDao = ObjectFactory.INSTANCE.getZakaznikDao();
    private final CvicenieDao cvicenieDao = ObjectFactory.INSTANCE.getCvicenieDao();
    private final RezervaciaDao rezervaciaDao = ObjectFactory.INSTANCE.getRezervaciaDao();
    private final VstupneDao vstupneDao = ObjectFactory.INSTANCE.getVstupneDao();
    
    @Override
    public void rezervovatCvicenie(Rezervacia rezervacia) {
        rezervaciaDao.pridajRezervaciu(rezervacia);
        cvicenieDao.rezervujCvicenie(rezervacia.getCvicenie());
    }

    @Override
    public void rezervovatCvicenieKartou(Cvicenie cvicenie, Zakaznik zakaznik) throws NedostatocnyKreditException {
        double SUMA = ObjectFactory.INSTANCE.getVstupneDao().dajCeny().getCenaCvicenia();
        if (zakaznik.getKredit() < SUMA) {
            throw new NedostatocnyKreditException();
        } else {
            Rezervacia rezervacia = new Rezervacia();
            rezervacia.setCvicenie(cvicenie);
            rezervacia.setZakaznik(zakaznik);
            rezervacia.setCasRezervacie(LocalDateTime.now());
            cvicenieDao.rezervujCvicenie(cvicenie);
            zakaznikDao.stiahniKreditZakaznikovi(zakaznik, SUMA);
            rezervaciaDao.pridajRezervaciu(rezervacia);
        }
    }

    @Override
    public void pridajCvicenie(Cvicenie cvicenie) {
        cvicenieDao.pridajCvicenie(cvicenie);
    }

    @Override
    public void odhlasitZCvicenia(Rezervacia rezervacia, Cvicenie cvicenie) {
        double SUMA = vstupneDao.dajCeny().getCenaCvicenia();
        zakaznikDao.dobiKreditZakaznikovi(rezervacia.getZakaznik(), SUMA);
        rezervaciaDao.odstranRezervacia(rezervacia);
        cvicenieDao.odrezervujCvicenie(cvicenie);
    }

    @Override
    public Cvicenie dajCvicenieSId(Long idCvicenia) {
        return cvicenieDao.dajCvicenieSId(idCvicenia);
    }

    @Override
    public void vymazCvicenie(Cvicenie cvicenie) {
        cvicenieDao.vymazCvicenie(cvicenie);
    }

    @Override
    public List<Cvicenie> dajCviceniaOdDatumu(LocalDateTime datum) {
        return cvicenieDao.dajCviceniaOdDatumu(datum);
    }

    @Override
    public List<Cvicenie> dajVsetkyCvicenia() {
        return cvicenieDao.dajVsetkyCvicenia();
    }

}
