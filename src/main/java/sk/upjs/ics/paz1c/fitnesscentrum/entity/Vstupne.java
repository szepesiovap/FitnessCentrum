package sk.upjs.ics.paz1c.fitnesscentrum.entity;

public class Vstupne {
    
    private Long id;
    private double cenaVstupneho;
    private double cenaCvicenia;
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getCenaVstupneho() {
        return cenaVstupneho;
    }

    public void setCenaVstupneho(double cenaVstupneho) {
        this.cenaVstupneho = cenaVstupneho;
    }

    public double getCenaCvicenia() {
        return cenaCvicenia;
    }

    public void setCenaCvicenia(double cenaCvicenia) {
        this.cenaCvicenia = cenaCvicenia;
    }
    
}