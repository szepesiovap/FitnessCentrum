package sk.upjs.ics.paz1c.fitnesscentrum;

import java.util.Date;

public class Zakaznik2 {
    
    private int id;
    private String meno;
    private Date poslednyPrichod;

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

    public Date getPoslednyPrichod() {
        return poslednyPrichod;
    }

    public void setPoslednyPrichod(Date poslednyPrichod) {
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
    private int idPernamentky;
    private boolean pritomny;
    
    
}
