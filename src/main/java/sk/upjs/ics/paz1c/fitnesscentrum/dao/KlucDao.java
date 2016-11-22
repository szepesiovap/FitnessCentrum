package sk.upjs.ics.paz1c.fitnesscentrum.dao;

import java.util.List;
import sk.upjs.ics.paz1c.fitnesscentrum.entity.Kluc;

public interface KlucDao {

    public List<Kluc> dajVsetkyKluce();

    public List<Kluc> dajVolneKluce();

    public void priradZakaznika(Long idKluca, Long idZakaznika);

    public void odoberZakaznika(Long idKluca);

    public Kluc dajKlucSId(Long idKluca);

}
