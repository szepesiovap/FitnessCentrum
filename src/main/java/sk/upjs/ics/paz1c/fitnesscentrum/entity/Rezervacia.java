package sk.upjs.ics.paz1c.fitnesscentrum.entity;

import java.time.LocalDateTime;

public class Rezervacia {

    private Long idRezervacie;
    private Long idSpinningu;
    private Long idZakaznika;
    private LocalDateTime casRezervacie;

    public Long getIdRezervacie() {
        return idRezervacie;
    }

    public void setIdRezervacie(Long idRezervacie) {
        this.idRezervacie = idRezervacie;
    }

    public Long getIdSpinningu() {
        return idSpinningu;
    }

    public void setIdSpinningu(Long idSpinningu) {
        this.idSpinningu = idSpinningu;
    }

    public Long getIdZakaznika() {
        return idZakaznika;
    }

    public void setIdZakaznika(Long idZakaznika) {
        this.idZakaznika = idZakaznika;
    }

    public LocalDateTime getCasRezervacie() {
        return casRezervacie;
    }

    public void setCasRezervacie(LocalDateTime casRezervacie) {
        this.casRezervacie = casRezervacie;
    }

}
