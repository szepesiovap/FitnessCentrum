package sk.upjs.ics.paz1c.fitnesscentrum.entity;

import java.time.LocalDateTime;

public class Rezervacia {

    private Long id;
    private Spinning spinning;
    private Zakaznik zakaznik;
    private LocalDateTime casRezervacie;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Spinning getSpinning() {
        return spinning;
    }

    public void setSpinning(Spinning spinning) {
        this.spinning = spinning;
    }

    public Zakaznik getZakaznik() {
        return zakaznik;
    }

    public void setZakaznik(Zakaznik zakaznik) {
        this.zakaznik = zakaznik;
    }

    public LocalDateTime getCasRezervacie() {
        return casRezervacie;
    }

    public void setCasRezervacie(LocalDateTime casRezervacie) {
        this.casRezervacie = casRezervacie;
    }

}
