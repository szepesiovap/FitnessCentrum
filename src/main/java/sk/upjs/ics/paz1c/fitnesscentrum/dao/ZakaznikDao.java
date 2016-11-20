package sk.upjs.ics.paz1c.fitnesscentrum.dao;

import sk.upjs.ics.paz1c.fitnesscentrum.entity.Zakaznik;
import java.util.List;

public interface ZakaznikDao {

    public List<Zakaznik> dajVsetkychZakaznikov();
    public List<Zakaznik> dajPritomnychZakaznikov();
    public List<Zakaznik> dajZakaznikovSoZhodouVMene(String vzorka);
    public void pridajZakaznika(Zakaznik zakaznik);
    public void vymazZakaznika(int idZakaznika);
    public void prichod(int idZakaznika, Integer idKluca);
    public void odchod(int idZakaznika);
    public Zakaznik dajZakaznikaSId(int idZakaznika);
    public Zakaznik dajZakaznikaSCislomPermanentky(String cisloPermanentky);
    
}
