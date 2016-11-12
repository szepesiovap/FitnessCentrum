package sk.upjs.ics.paz1c.fitnesscentrum.dao;

import sk.upjs.ics.paz1c.fitnesscentrum.entity.Zakaznik;
import java.util.List;
import sk.upjs.ics.paz1c.fitnesscentrum.entity.Kluc;

public interface ZakaznikDao {

    public List<Zakaznik> dajVsetkychZakaznikov();

    public List<Zakaznik> dajPritomnychZakaznikov();

    public void pridajZakaznika(Zakaznik zakaznik);

    public void prichod(int idZakaznika, int idKluca);

    public void odchod(int idZakaznika);

}
