package sk.upjs.ics.paz1c.fitnesscentrum;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author patka
 */
public class ZoznamZakaznikov implements ZakaznikDao {

    private List<Zakaznik> zoznamZakaznikov = new ArrayList<>();

    public ZoznamZakaznikov() {
        Zakaznik zakaznik1 = new Zakaznik();
        zakaznik1.setMeno("Patka");
        zakaznik1.setPoslednyPrichod(LocalDateTime.now());
        zakaznik1.setPritomny(true);

        zoznamZakaznikov.add(zakaznik1);

        Zakaznik zakaznik2 = new Zakaznik();
        zakaznik2.setMeno("Lucka");
        zakaznik2.setPoslednyPrichod(LocalDateTime.now());
        zakaznik2.setPritomny(true);

        zoznamZakaznikov.add(zakaznik2);

    }

    @Override
    public List<Zakaznik> dajVsetkychZakaznikov() {
        return zoznamZakaznikov;
    }

    @Override
    public void novaPermanentka(Zakaznik zakaznik) {
        zoznamZakaznikov.add(zakaznik);
    }

    @Override
    public void novyJednorazovyVstup(Zakaznik zakaznik) {
        zoznamZakaznikov.add(zakaznik);
    }

    @Override
    public void novyStudent(Zakaznik zakaznik) {
        zoznamZakaznikov.add(zakaznik);
    }
}
