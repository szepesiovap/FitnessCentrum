package sk.upjs.ics.paz1c.fitnesscentrum.entity;

import java.time.LocalDateTime;
import java.util.Date;

public class Zakaznik {

    private int id;
    private String meno;
    private LocalDateTime poslednyPrichod;
    private boolean pritomny;
    private double kredit;
    private int cisloPernamentky;
    private Date platnaOd;
    private Date platnaDo;

    public double getKredit() {
        return kredit;
    }

    public void setKredit(double kredit) {
        this.kredit = kredit;
    }

    public double getCisloPernamentky() {
        return cisloPernamentky;
    }

    public void setCisloPernamentky(int cisloPernamentky) {
        this.cisloPernamentky = cisloPernamentky;
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
     
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMeno() {
        return meno;
    }

    public void setMeno(String meno) {
        this.meno = meno;
    }

    public LocalDateTime getPoslednyPrichod() {
        return poslednyPrichod;
    }

    public void setPoslednyPrichod(LocalDateTime poslednyPrichod) {
        this.poslednyPrichod = poslednyPrichod;
    }

    public boolean isPritomny() {
        return pritomny;
    }

    public void setPritomny(boolean pritomny) {
        this.pritomny = pritomny;
    }

    @Override
    public String toString() {
        return "Zakaznik{" + "id=" + id + ", meno=" + meno + ", poslednyPrichod=" + poslednyPrichod + ", pritomny=" + pritomny + ", kredit=" + kredit + ", cisloPernamentky=" + cisloPernamentky + ", platnaOd=" + platnaOd + ", platnaDo=" + platnaDo + '}';
    }

    
}
