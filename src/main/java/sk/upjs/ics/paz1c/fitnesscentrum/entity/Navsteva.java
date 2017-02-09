package sk.upjs.ics.paz1c.fitnesscentrum.entity;

import java.time.LocalDateTime;

public class Navsteva {
    private Long id;
    private Zakaznik zakaznik;
    private LocalDateTime prichod;
    private LocalDateTime odchod;
    private Kluc kluc;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Zakaznik getZakaznik() {
        return zakaznik;
    }

    public void setZakaznik(Zakaznik zakaznik) {
        this.zakaznik = zakaznik;
    }

    public LocalDateTime getPrichod() {
        return prichod;
    }

    public void setPrichod(LocalDateTime prichod) {
        this.prichod = prichod;
    }

    public LocalDateTime getOdchod() {
        return odchod;
    }

    public void setOdchod(LocalDateTime odchod) {
        this.odchod = odchod;
    }

    public Kluc getKluc() {
        return kluc;
    }

    public void setKluc(Kluc kluc) {
        this.kluc = kluc;
    }
}
