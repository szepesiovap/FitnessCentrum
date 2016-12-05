package sk.upjs.ics.paz1c.fitnesscentrum.dao;

import java.util.List;
import sk.upjs.ics.paz1c.fitnesscentrum.entity.Instruktor;

public interface InstruktorDao {

    public List<Instruktor> dajVsetychInstruktorov();

    public Instruktor dajInstruktoraSId(Long idInstruktora);

    public void pridajInstruktora(Instruktor instruktor);

}
