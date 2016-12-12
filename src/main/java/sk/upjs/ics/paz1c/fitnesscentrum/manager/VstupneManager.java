package sk.upjs.ics.paz1c.fitnesscentrum.manager;

import sk.upjs.ics.paz1c.fitnesscentrum.entity.Vstupne;

public interface VstupneManager {

    public void nastavCeny(double cenaVstupneho, double cenaSpinningu);
    public Vstupne dajCeny();
}
