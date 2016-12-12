
package sk.upjs.ics.paz1c.fitnesscentrum.manager;

import java.util.List;
import sk.upjs.ics.paz1c.fitnesscentrum.entity.Instruktor;

public interface InstruktorManager {
    
    public void pridajInstruktora(Instruktor instruktor);

    public List<Instruktor> dajVsetychInstruktorov();
    
}
