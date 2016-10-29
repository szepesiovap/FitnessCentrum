package sk.upjs.ics.paz1c.fitnesscentrum;

import java.time.LocalDateTime;

/**
 *
 * @author patka
 */
public class Zakaznik {

    private Integer id;
    private String meno;
    private LocalDateTime poslednyPrichod;
    private LocalDateTime platnostPermanentky;
    private Long cisloPermanentky;
    private Double kredit;
    private boolean pritomny;

    public boolean isPritomny() {
        return pritomny;
    }

    public void setPritomny(boolean pritomny) {
        this.pritomny = pritomny;
    }

    public Long getCisloPermanentky() {
        return cisloPermanentky;
    }

    public Integer getId() {
        return id;
    }

    public Double getKredit() {
        return kredit;
    }

    public String getMeno() {
        return meno;
    }

    public LocalDateTime getPlatnostPermanentky() {
        return platnostPermanentky;
    }

    public LocalDateTime getPoslednyPrichod() {
        return poslednyPrichod;
    }

    public void setCisloPermanentky(Long cislo_permanentky) {
        this.cisloPermanentky = cislo_permanentky;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setKredit(Double kredit) {
        this.kredit = kredit;
    }

    public void setMeno(String meno) {
        this.meno = meno;
    }

    public void setPlatnostPermanentky(LocalDateTime platnost_permanentky) {
        this.platnostPermanentky = platnost_permanentky;
    }

    public void setPoslednyPrichod(LocalDateTime posledny_prichod) {
        this.poslednyPrichod = posledny_prichod;
    }
    
        public Zakaznik() {
    }

}
