package sk.upjs.ics.paz1c.fitnesscentrum.dao;

import sk.upjs.ics.paz1c.fitnesscentrum.entity.Zakaznik;
import java.util.List;
import sk.upjs.ics.paz1c.fitnesscentrum.entity.Kluc;
import sk.upjs.ics.paz1c.fitnesscentrum.exception.NeexistujuciZakaznikException;

public interface ZakaznikDao {

    public List<Zakaznik> dajVsetkychZakaznikov();

    public List<Zakaznik> dajPritomnychZakaznikov();

    public List<Zakaznik> dajZakaznikovSoZhodouVMene(String vzorka);

    public void pridajZakaznika(Zakaznik zakaznik);

    public void vymazZakaznika(Zakaznik zakaznik);

    public void prichod(Zakaznik zakaznik, Kluc kluc);

    public void odchod(Zakaznik zakaznik);

    public Zakaznik dajZakaznikaSId(Long idZakaznika) ;

    public Zakaznik dajZakaznikaSCislomPermanentky(String cisloPermanentky) throws NeexistujuciZakaznikException;

    public void stiahniKreditZakaznikovi(Zakaznik zakaznik, double suma);

    public void dobiKreditZakaznikovi(Zakaznik zakaznik, double suma);

}
