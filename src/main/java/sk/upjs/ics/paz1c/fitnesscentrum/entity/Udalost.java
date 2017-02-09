package sk.upjs.ics.paz1c.fitnesscentrum.entity;

import java.time.LocalDateTime;

public class Udalost {
    private Long id;
    private Zakaznik zakaznik;
    private LocalDateTime datum;
    private String typ;
    private String obsah;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Zakaznik getZakaznik() {
        return zakaznik;
    }

    public void setZakaznik(Zakaznik zakaznik_id) {
        this.zakaznik = zakaznik_id;
    }

    public LocalDateTime getDatum() {
        return datum;
    }

    public void setDatum(LocalDateTime datum) {
        this.datum = datum;
    }

    public String getTyp() {
        return typ;
    }

    public void setTyp(String typ) {
        this.typ = typ;
    }

    public String getObsah() {
        return obsah;
    }

    public void setObsah(String obsah) {
        this.obsah = obsah;
    }
    
    
}
