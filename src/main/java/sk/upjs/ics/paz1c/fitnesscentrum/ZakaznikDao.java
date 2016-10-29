package sk.upjs.ics.paz1c.fitnesscentrum;

import java.util.List;

public interface ZakaznikDao {

    List<Zakaznik> dajVsetkychZakaznikov();
    
    public void novaPermanentka(Zakaznik zakaznik);

    public void novyJednorazovyVstup(Zakaznik zakaznik);

    public void novyStudent(Zakaznik zakaznik);

}
