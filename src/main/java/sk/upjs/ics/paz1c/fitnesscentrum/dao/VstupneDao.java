package sk.upjs.ics.paz1c.fitnesscentrum.dao;

import sk.upjs.ics.paz1c.fitnesscentrum.entity.Vstupne;

public interface VstupneDao {

    public void updateCenaVstupneho(double cena);

    public void updateCenaSpinningu(double cena);

    public Vstupne dajCeny();
}
