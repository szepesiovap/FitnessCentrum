package sk.upjs.ics.paz1c.fitnesscentrum.dao;

import java.util.List;
import sk.upjs.ics.paz1c.fitnesscentrum.entity.Kluc;

public interface KlucDao {

    public List<Kluc> dajVsetkyKluce();

    public List<Kluc> dajVolneKluce();

    public void priradZakaznika(int idKluca, int idZakaznika);

    public void odoberZakaznika(int idKluca);

    public Kluc dajKlucSId(Integer idKluca);

}
