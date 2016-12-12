package sk.upjs.ics.paz1c.fitnesscentrum.manager;

import java.util.List;
import org.springframework.dao.DuplicateKeyException;
import sk.upjs.ics.paz1c.fitnesscentrum.entity.Kredit;
import sk.upjs.ics.paz1c.fitnesscentrum.entity.Zakaznik;

public interface KreditManager {

    public Kredit dajKreditSId(Long idKredit);

    public void vymazKredit(Long idKredit);

    public void ulozitKredit(Kredit kredit) throws DuplicateKeyException;
    
    public void dobitKredit(Zakaznik zakaznik, double kredit);

    public List<Kredit> dajVsetkyKredity();
}
