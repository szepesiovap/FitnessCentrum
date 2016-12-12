package sk.upjs.ics.paz1c.fitnesscentrum.manager;

import java.util.List;
import sk.upjs.ics.paz1c.fitnesscentrum.entity.Recepcny;
import sk.upjs.ics.paz1c.fitnesscentrum.exception.NeexistujuciRecepcnyException;
import sk.upjs.ics.paz1c.fitnesscentrum.exception.NevalidnyVstupException;

public interface RecepcnyManager {
    
    public void pridajRecepcneho(String meno, String login, String noveHeslo, String noveHesloZnova) throws NevalidnyVstupException;
    
    public void zmenHesloRecepcneho(String login, String heslo, String noveHeslo, String noveHesloZnova) throws NevalidnyVstupException, NeexistujuciRecepcnyException;
    
    public Recepcny dajRecepcneho(Long idRecepecneho);
    
    public void vymazRecepcneho(Recepcny recepcny);

    public List<Recepcny> dajVsetkychRecepcnych();
}
