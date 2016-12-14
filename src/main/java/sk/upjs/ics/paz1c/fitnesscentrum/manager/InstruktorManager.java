
package sk.upjs.ics.paz1c.fitnesscentrum.manager;

import java.util.List;
import sk.upjs.ics.paz1c.fitnesscentrum.entity.Instruktor;
import sk.upjs.ics.paz1c.fitnesscentrum.exception.PrazdnyRetazecException;

public interface InstruktorManager {
    
    public void pridajInstruktora(Instruktor instruktor)throws PrazdnyRetazecException;

    public List<Instruktor> dajVsetychInstruktorov();
    
}
