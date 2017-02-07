/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.upjs.ics.paz1c.fitnesscentrum.dao;

import java.time.LocalDateTime;
import java.util.List;
import sk.upjs.ics.paz1c.fitnesscentrum.entity.Cvicenie;


/**
 *
 * @author ntb
 */
public interface CvicenieDao {
    public List<Cvicenie> dajVsetkyCvicenia();

    public List<Cvicenie> dajCviceniaOdDatumu(LocalDateTime datum);

    public Cvicenie dajCvicenieSId(Long idCvicenia);

    public void pridajCvicenie(Cvicenie cvicenie);

    public void rezervujCvicenie(Cvicenie cvicenie);

    public void odrezervujCvicenie(Cvicenie cvicenie);

    public void vymazCvicenie(Cvicenie cvicenie);
    
}
