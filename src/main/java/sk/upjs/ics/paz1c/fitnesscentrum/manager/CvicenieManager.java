/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.upjs.ics.paz1c.fitnesscentrum.manager;

import java.time.LocalDateTime;
import java.util.List;
import sk.upjs.ics.paz1c.fitnesscentrum.entity.Cvicenie;
import sk.upjs.ics.paz1c.fitnesscentrum.entity.Rezervacia;
import sk.upjs.ics.paz1c.fitnesscentrum.entity.Spinning;
import sk.upjs.ics.paz1c.fitnesscentrum.entity.Zakaznik;
import sk.upjs.ics.paz1c.fitnesscentrum.exception.NedostatocnyKreditException;

/**
 *
 * @author ntb
 */
public interface CvicenieManager {
    public void rezervovatCvicenie(Rezervacia rezervacia);

    public void rezervovatCvicenieKartou(Cvicenie cvicenie, Zakaznik zakaznik) throws NedostatocnyKreditException;

    public void pridajCvicenie(Cvicenie cvicenie);

    public void odhlasitZCvicenia(Rezervacia rezervacia, Cvicenie cvicenie);

    public Cvicenie dajCvicenieSId(Long idCvicenia);

    public void vymazCvicenie(Cvicenie cvicenie);

    public List<Cvicenie> dajCviceniaOdDatumu(LocalDateTime now);

    public List<Cvicenie> dajVsetkyCvicenia();

}
