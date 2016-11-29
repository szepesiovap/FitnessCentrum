package sk.upjs.ics.paz1c.fitnesscentrum.dao;

import java.util.List;
import sk.upjs.ics.paz1c.fitnesscentrum.entity.Kredit;

public interface KreditDao {
    
    public List<Kredit> dajVsetkyKredity();
    
    public void pridajKredit(Kredit kredit);
    
    public void vymazKredit(Long idKredit);
    
    public Kredit dajKreditSId(Long idKredit);
}
