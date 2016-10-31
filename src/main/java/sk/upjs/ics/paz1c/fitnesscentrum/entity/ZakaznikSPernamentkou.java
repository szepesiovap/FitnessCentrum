package sk.upjs.ics.paz1c.fitnesscentrum.entity;

public class ZakaznikSPernamentkou {

    private Zakaznik zakaznik;
    private Pernamentka pernamentka;

    public Zakaznik getZakaznik() {
        return zakaznik;
    }

    public void setZakaznik(Zakaznik zakaznik) {
        this.zakaznik = zakaznik;
    }

    public Pernamentka getPernamentka() {
        return pernamentka;
    }

    public void setPernamentka(Pernamentka pernamentka) {
        this.pernamentka = pernamentka;
    }

    @Override
    public String toString() {
        return "ZakaznikSPernamentkou{" + "zakaznik=" + zakaznik + ", pernamentka=" + pernamentka + '}';
    }

}
