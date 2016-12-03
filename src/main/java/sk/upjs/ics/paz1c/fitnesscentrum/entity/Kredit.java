package sk.upjs.ics.paz1c.fitnesscentrum.entity;

public class Kredit {

    private Long id;
    private double cena;
    private String nazov;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getCena() {
        return cena;
    }

    public void setCena(double cena) {
        this.cena = cena;
    }

    public String getNazov() {
        return nazov;
    }

    public void setNazov(String nazov) {
        this.nazov = nazov;
    }

    @Override
    public String toString() {
        return cena + " €";
    }
    
}
