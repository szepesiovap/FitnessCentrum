package sk.upjs.ics.paz1c.fitnesscentrum;

import sk.upjs.ics.paz1c.fitnesscentrum.dao.ZakaznikDao;
import sk.upjs.ics.paz1c.fitnesscentrum.entity.Zakaznik;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

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
    public List<Zakaznik> dajPritomnychZakaznikov() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void pridajZakaznika(Zakaznik zakaznik) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Zakaznik dajZakaznikaSCislomPermanentky(String cisloPermanentky) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Zakaznik> dajZakaznikovSoZhodouVMene(String vzorka) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void vymazZakaznika(Long idZakaznika) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void prichod(Long idZakaznika, Long idKluca) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void odchod(Long idZakaznika) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Zakaznik dajZakaznikaSId(Long idZakaznika) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void stiahniKreditZakaznikovi(Long idZakaznika, double suma) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void dobiKreditZakaznikovi(Long idZakaznika, double suma) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
