package sk.upjs.ics.paz1c.fitnesscentrum.entity;

import java.time.LocalDateTime;
import java.util.Date;

public class Zakaznik {

    private Integer id;
    private String meno;
    private LocalDateTime poslednyPrichod;
    private boolean pritomny;
    private double kredit;
    private Integer cisloPermanentky;
    private Integer idKluca;

    public Integer getIdKluca() {
        return idKluca;
    }

    public void setIdKluca(Integer idKluca) {
        this.idKluca = idKluca;
    }

    public double getKredit() {
        return kredit;
    }

    public void setKredit(double kredit) {
        this.kredit = kredit;
    }

    public Integer getCisloPermanentky() {
        return cisloPermanentky;
    }

    public void setCisloPermanentky(int cisloPermanentky) {
        this.cisloPermanentky = cisloPermanentky;
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
        return "Zakaznik{" + "id=" + id + ", meno=" + meno + ", poslednyPrichod=" + poslednyPrichod + ", pritomny=" + pritomny + ", kredit=" + kredit + ", cisloPernamentky=" + cisloPermanentky + '}';
    }

}
