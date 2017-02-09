/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.upjs.ics.paz1c.fitnesscentrum.dao;

import java.util.List;
import sk.upjs.ics.paz1c.fitnesscentrum.entity.Cvicenie;
import sk.upjs.ics.paz1c.fitnesscentrum.entity.TypCvicenia;

/**
 *
 * @author ntb
 */
public interface TypCviceniaDao {
    public List<TypCvicenia> dajVsetkyTypy();
    public TypCvicenia dajTypPodlaId(Long id);
    public void uloz(TypCvicenia typCvicenia);
    
}
