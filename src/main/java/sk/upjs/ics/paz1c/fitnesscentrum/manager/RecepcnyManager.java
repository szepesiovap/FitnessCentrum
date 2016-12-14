package sk.upjs.ics.paz1c.fitnesscentrum.manager;

import java.util.List;
import sk.upjs.ics.paz1c.fitnesscentrum.entity.Recepcny;
import sk.upjs.ics.paz1c.fitnesscentrum.exception.DuplikovanyLoginException;
import sk.upjs.ics.paz1c.fitnesscentrum.exception.NeexistujuciRecepcnyException;
import sk.upjs.ics.paz1c.fitnesscentrum.exception.NevalidnyVstupException;
import sk.upjs.ics.paz1c.fitnesscentrum.exception.PrazdneHesloException;
import sk.upjs.ics.paz1c.fitnesscentrum.exception.PrazdneMenoException;
import sk.upjs.ics.paz1c.fitnesscentrum.exception.PrazdnyRetazecException;

public interface RecepcnyManager {

    public void pridajRecepcneho(Recepcny recepcny) throws DuplikovanyLoginException,PrazdnyRetazecException,
            PrazdneHesloException, PrazdneMenoException;

    public void zmenHesloRecepcneho(String login, String heslo, String noveHeslo, String noveHesloZnova) throws NevalidnyVstupException, NeexistujuciRecepcnyException;

    public Recepcny dajRecepcneho(Long idRecepecneho);

    public void vymazRecepcneho(Recepcny recepcny);

    public List<Recepcny> dajVsetkychRecepcnych();
}
