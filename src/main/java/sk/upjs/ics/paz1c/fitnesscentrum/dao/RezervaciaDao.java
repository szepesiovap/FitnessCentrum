package sk.upjs.ics.paz1c.fitnesscentrum.dao;

import java.util.List;
import sk.upjs.ics.paz1c.fitnesscentrum.entity.Rezervacia;
import sk.upjs.ics.paz1c.fitnesscentrum.entity.Spinning;

public interface RezervaciaDao {

    public List<Rezervacia> dajVsetkyRezervacie();

    public List<Rezervacia> dajRezervacieSpinningu(Spinning spinning);

    public Rezervacia dajRezervaciuSId(Long idRezervacie);

    public void pridajRezervaciu(Rezervacia rezervacia);

    public void odstranRezervacia(Long idRezervacie);
}
