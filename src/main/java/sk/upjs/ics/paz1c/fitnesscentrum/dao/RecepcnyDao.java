package sk.upjs.ics.paz1c.fitnesscentrum.dao;

import java.util.List;
import sk.upjs.ics.paz1c.fitnesscentrum.entity.Recepcny;

public interface RecepcnyDao {
    
    public Recepcny dajRecepcneho(String login, String heslo);
    
    public List<Recepcny> dajVsetkychRecepcnych();
    
    public void pridajRecepcneho(Recepcny recepcny);
    
    public void vymazRecepcneho(Recepcny recepcny);
    
}
