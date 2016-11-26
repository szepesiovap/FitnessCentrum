package sk.upjs.ics.paz1c.fitnesscentrum.dao;

import java.util.List;
import sk.upjs.ics.paz1c.fitnesscentrum.entity.Spinning;

public interface SpinningDao {

    public List<Spinning> dajVsetkySpinningy();

    public Spinning dajSpinningSId(Long idSpinningu);

    public void pridajSpinning(Spinning spinning);
}
