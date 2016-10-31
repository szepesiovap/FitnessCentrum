package sk.upjs.ics.paz1c.fitnesscentrum.entity;

import java.util.Date;

public class Pernamentka {
    private int id;
    private int cislo;
    private Typ typ;
    private Date platnaOd;
    private Date platnaDo;
    private double kredit;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCislo() {
        return cislo;
    }

    public void setCislo(int cislo) {
        this.cislo = cislo;
    }

    public Typ getTyp() {
        return typ;
    }

    public void setTyp(Typ typ) {
        this.typ = typ;
    }

    public Date getPlatnaOd() {
        return platnaOd;
    }

    public void setPlatnaOd(Date platnaOd) {
        this.platnaOd = platnaOd;
    }

    public Date getPlatnaDo() {
        return platnaDo;
    }

    public void setPlatnaDo(Date platnaDo) {
        this.platnaDo = platnaDo;
    }

    public double getKredit() {
        return kredit;
    }

    public void setKredit(double kredit) {
        this.kredit = kredit;
    }

    @Override
    public String toString() {
        return "Pernamentka{" + "id=" + id + ", cislo=" + cislo + ", typ=" + typ + ", platnaOd=" + platnaOd + ", platnaDo=" + platnaDo + ", kredit=" + kredit + '}';
    }
    
}
