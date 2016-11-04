
package sk.upjs.ics.paz1c.fitnesscentrum.dao;

import sk.upjs.ics.paz1c.fitnesscentrum.entity.Recepcny;

public interface RecepcnyDao {
    
    public Recepcny dajRecepcneho(String login, String heslo);
    
}
