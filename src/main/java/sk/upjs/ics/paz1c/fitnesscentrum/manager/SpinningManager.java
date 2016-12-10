package sk.upjs.ics.paz1c.fitnesscentrum.manager;

import sk.upjs.ics.paz1c.fitnesscentrum.entity.Rezervacia;
import sk.upjs.ics.paz1c.fitnesscentrum.entity.Spinning;
import sk.upjs.ics.paz1c.fitnesscentrum.entity.Zakaznik;
import sk.upjs.ics.paz1c.fitnesscentrum.exception.NedostatocnyKreditException;

public interface SpinningManager {

    public void rezervovatSpinning(Rezervacia rezervacia);

    public void rezervovatSpinningKartou(Spinning spinning, Zakaznik zakaznik) throws NedostatocnyKreditException;

    public void pridajSpinning(Spinning spinning);

    public void odhlasitZoSpinningu(Rezervacia rezervacia, Spinning spinning);

    public Spinning dajSpinningSId(Long idSpinningu);

    public void vymazSpinning(Spinning spinning);

}
