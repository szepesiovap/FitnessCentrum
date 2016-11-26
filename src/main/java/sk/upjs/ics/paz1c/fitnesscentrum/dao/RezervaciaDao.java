package sk.upjs.ics.paz1c.fitnesscentrum.dao;

import java.util.List;
import sk.upjs.ics.paz1c.fitnesscentrum.entity.Rezervacia;

public interface RezervaciaDao {
    public List<Rezervacia> dajVsetkyRezervacie();
    public List<Rezervacia> dajRezervacieSpinningu(Long idSpinningu);
    public Rezervacia dajRezervaciuSId(Long idRezervacie);
    public void pridajRezervaciu(Rezervacia rezervacia);
}
