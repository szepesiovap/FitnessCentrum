package sk.upjs.ics.paz1c.fitnesscentrum.dao;

import sk.upjs.ics.paz1c.fitnesscentrum.entity.Zakaznik;
import java.util.List;
import sk.upjs.ics.paz1c.fitnesscentrum.entity.ZakaznikSPernamentkou;

public interface ZakaznikDao {

    List<Zakaznik> dajVsetkychZakaznikov();
    List<ZakaznikSPernamentkou> dajVsetkychZakaznikovSPernamentkou();
    List<Zakaznik> dajPritomnychZakaznikov();
     
}
