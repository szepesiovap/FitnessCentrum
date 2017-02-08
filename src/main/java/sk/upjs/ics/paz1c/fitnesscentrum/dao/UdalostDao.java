package sk.upjs.ics.paz1c.fitnesscentrum.dao;

import java.time.LocalDateTime;
import java.util.List;
import sk.upjs.ics.paz1c.fitnesscentrum.entity.Udalost;
import sk.upjs.ics.paz1c.fitnesscentrum.entity.Zakaznik;

public interface UdalostDao {
    public List<Udalost> dajVsetkyUdalostiOdZakaznika(Zakaznik zakaznik);

    public List<Udalost> dajVsetkyUdalostiTypu(String typ);

    public List<Udalost> dajVsetkyUdalostiTypuOdZakaznika(Zakaznik zakaznik, String typ);

    public List<Udalost> dajVsetkyUdalostiZoDna(LocalDateTime datum);
    
    public void pridajUdalost(Zakaznik zakaznik, String typ, String obsah);
}
