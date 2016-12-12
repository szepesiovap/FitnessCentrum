package sk.upjs.ics.paz1c.fitnesscentrum.manager;

import java.util.List;
import sk.upjs.ics.paz1c.fitnesscentrum.entity.Rezervacia;
import sk.upjs.ics.paz1c.fitnesscentrum.entity.Spinning;

public interface RezervaciaManager {

    public Rezervacia dajRezervaciuSId(Long idRezervacie);

    public List<Rezervacia> dajRezervacieSpinningu(Spinning spinning);

}
