package sk.upjs.ics.paz1c.fitnesscentrum.entity;

public class Vstupne {
    
    private Long id;
    private double cenaVstupneho;
    private double cenaSpinnigu;
    
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

    public double getCenaSpinnigu() {
        return cenaSpinnigu;
    }

    public void setCenaSpinnigu(double cenaSpinnigu) {
        this.cenaSpinnigu = cenaSpinnigu;
    }
    
}