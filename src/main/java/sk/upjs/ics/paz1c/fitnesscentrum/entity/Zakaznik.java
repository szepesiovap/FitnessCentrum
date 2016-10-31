package sk.upjs.ics.paz1c.fitnesscentrum.entity;

import java.time.LocalDateTime;

/**
 *
 * @author patka
 */
public class Zakaznik {

    private int id;
    private String meno;
    private LocalDateTime poslednyPrichod;
    private int idPernamentky;
    private boolean pritomny;
    
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

    public int getIdPernamentky() {
        return idPernamentky;
    }

    public void setIdPernamentky(int idPernamentky) {
        this.idPernamentky = idPernamentky;
    }

    public boolean isPritomny() {
        return pritomny;
    }

    public void setPritomny(boolean pritomny) {
        this.pritomny = pritomny;
    }

    @Override
    public String toString() {
        return "Zakaznik2{" + "id=" + id + ", meno=" + meno + ", poslednyPrichod=" + poslednyPrichod + ", idPernamentky=" + idPernamentky + ", pritomny=" + pritomny + '}';
    }

    
}
