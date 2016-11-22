package sk.upjs.ics.paz1c.fitnesscentrum.dao;

import sk.upjs.ics.paz1c.fitnesscentrum.entity.Zakaznik;
import java.util.List;

public interface ZakaznikDao {

    public List<Zakaznik> dajVsetkychZakaznikov();
    public List<Zakaznik> dajPritomnychZakaznikov();
    public List<Zakaznik> dajZakaznikovSoZhodouVMene(String vzorka);
    public void pridajZakaznika(Zakaznik zakaznik);
    public void vymazZakaznika(Long idZakaznika);
    public void prichod(Long idZakaznika, Long idKluca);
    public void odchod(Long idZakaznika);
    public Zakaznik dajZakaznikaSId(Long idZakaznika);
    public Zakaznik dajZakaznikaSCislomPermanentky(String cisloPermanentky);
    
}
