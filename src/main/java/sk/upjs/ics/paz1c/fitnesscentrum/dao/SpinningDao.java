package sk.upjs.ics.paz1c.fitnesscentrum.dao;

import java.time.LocalDateTime;
import java.util.List;
import sk.upjs.ics.paz1c.fitnesscentrum.entity.Spinning;

public interface SpinningDao {

    public List<Spinning> dajVsetkySpinningy();

    public List<Spinning> dajSpinningyOdDatumu(LocalDateTime datum);

    public Spinning dajSpinningSId(Long idSpinningu);

    public void pridajSpinning(Spinning spinning);

    public void rezervujSpinning(Spinning spinning);

    public void odrezervujSpinning(Spinning spinning);

    public void vymazSpinning(Spinning spinning);
}
