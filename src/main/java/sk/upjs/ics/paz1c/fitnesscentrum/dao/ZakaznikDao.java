package sk.upjs.ics.paz1c.fitnesscentrum.dao;

import sk.upjs.ics.paz1c.fitnesscentrum.entity.Zakaznik;
import java.util.List;

public interface ZakaznikDao {

    public List<Zakaznik> dajVsetkychZakaznikov();

    public List<Zakaznik> dajPritomnychZakaznikov();

    public void pridajZakaznika(Zakaznik zakaznik);

    public void vymazZakaznika(int idZakaznika);
    // public void updateZakaznika(Zakaznik zakaznik);

    public void prichod(int idZakaznika, int idKluca);

    public void odchod(int idZakaznika);
}
