package sk.upjs.ics.paz1c.fitnesscentrum.entity;

import java.time.LocalDateTime;

public class Rezervacia {

    private Long id;
    private Cvicenie cvicenie;
    private Zakaznik zakaznik;
    private LocalDateTime casRezervacie;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Cvicenie getCvicenie() {
        return cvicenie;
    }

    public void setCvicenie(Cvicenie cvicenie) {
        this.cvicenie = cvicenie;
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
