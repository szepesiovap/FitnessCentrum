package sk.upjs.ics.paz1c.fitnesscentrum.dao;

import java.time.LocalDateTime;
import java.util.List;
import sk.upjs.ics.paz1c.fitnesscentrum.entity.Kluc;
import sk.upjs.ics.paz1c.fitnesscentrum.entity.Navsteva;
import sk.upjs.ics.paz1c.fitnesscentrum.entity.Zakaznik;

public interface NavstevaDao {

    public List<Navsteva> dajVsetkyNavstevyZakaznika(Zakaznik zakaznik);
    
    public List<Navsteva> dajVsetkyNavstevyVRozmedzi(LocalDateTime datumOd, LocalDateTime datumDo);

    public List<Navsteva> dajNavstevySKlucom(Kluc kluc);

    public Navsteva dajNavstevuSId(Long id);

    public void registrujPrichod(Zakaznik zakaznik, Kluc kluc);

    public void registrujOdchod(Navsteva navsteva);

    public void registrujOdchod(Long idZakaznika);

    public Integer dajCasZakaznika(Zakaznik zakaznik);
}
