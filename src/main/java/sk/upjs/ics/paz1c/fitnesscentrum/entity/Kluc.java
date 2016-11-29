package sk.upjs.ics.paz1c.fitnesscentrum.entity;

public class Kluc {

    private Long id;
    private String meno;
    private Zakaznik zakaznik;

    public String getMeno() {
        return meno;
    }

    public void setMeno(String menoKluca) {
        this.meno = menoKluca;
    }

    public Zakaznik getZakaznik() {
        return zakaznik;
    }

    public void setZakaznik(Zakaznik zakaznik) {
        this.zakaznik = zakaznik;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return meno;
    }

}
