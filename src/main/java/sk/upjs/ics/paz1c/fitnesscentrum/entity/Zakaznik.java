package sk.upjs.ics.paz1c.fitnesscentrum.entity;

import java.time.LocalDateTime;

public class Zakaznik {

    private Long id;
    private String meno;
    private LocalDateTime poslednyPrichod;
    private boolean pritomny;
    private double kredit;
    private String cisloPermanentky;
    private Long idKluca;

    public Long getIdKluca() {
        return idKluca;
    }

    public void setIdKluca(Long idKluca) {
        this.idKluca = idKluca;
    }

    public double getKredit() {
        return kredit;
    }

    public void setKredit(double kredit) {
        this.kredit = kredit;
    }

    public String getCisloPermanentky() {
        return cisloPermanentky;
    }

    public void setCisloPermanentky(String cisloPermanentky) {
        this.cisloPermanentky = cisloPermanentky;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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
