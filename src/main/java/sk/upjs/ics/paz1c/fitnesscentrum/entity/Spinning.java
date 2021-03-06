package sk.upjs.ics.paz1c.fitnesscentrum.entity;

import java.time.LocalDateTime;

public class Spinning {

    private Long id;
    private LocalDateTime datum;
    private int kapacita;
    private int volne;
    private Instruktor instruktor;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getDatum() {
        return datum;
    }

    public void setDatum(LocalDateTime datum) {
        this.datum = datum;
    }

    public int getKapacita() {
        return kapacita;
    }

    public void setKapacita(int kapacita) {
        this.kapacita = kapacita;
    }

    public int getVolne() {
        return volne;
    }

    public void setVolne(int volne) {
        this.volne = volne;
    }

    public Instruktor getInstruktor() {
        return instruktor;
    }

    public void setInstruktor(Instruktor instruktor) {
        this.instruktor = instruktor;
    }

    @Override
    public String toString() {
        return getDatum().toLocalDate() + " " + getDatum().toLocalTime() + " " + instruktor.getMeno() + " --Voľných " + volne + " miest.";
    }

}
