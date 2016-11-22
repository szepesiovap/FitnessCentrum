package sk.upjs.ics.paz1c.fitnesscentrum.entity;

import java.util.Date;


public class Spinning {
    private Long id;
    private Date datum;
    private Date cas;
    private int kapacita;
    private int volne;
    private Long idSpinera;
    
    //TODO : dorobit zoznam prihlasenych

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }

    public Date getCas() {
        return cas;
    }

    public void setCas(Date cas) {
        this.cas = cas;
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

    public Long getIdSpinera() {
        return idSpinera;
    }

    public void setIdSpinera(Long idSpinera) {
        this.idSpinera = idSpinera;
    }
}
