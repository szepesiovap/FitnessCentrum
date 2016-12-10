package sk.upjs.ics.paz1c.fitnesscentrum.dao;

import java.util.List;
import sk.upjs.ics.paz1c.fitnesscentrum.entity.Kluc;
import sk.upjs.ics.paz1c.fitnesscentrum.entity.Zakaznik;

public interface KlucDao {

    public List<Kluc> dajVsetkyKluce();

    public List<Kluc> dajVolneKluce();

    public void priradZakaznika(Kluc kluc, Zakaznik zakaznik);

    public void odoberZakaznika(Kluc kluc);

    public Kluc dajKlucSId(Long idKluca);
    
    public void pridajKluc(Kluc kluc);
    
    public void vymazKluc(Kluc kluc);

}
