package sk.upjs.ics.paz1c.fitnesscentrum.entity;

public class Kluc {

    public String getMenoKluca() {
        return menoKluca;
    }

    public void setMenoKluca(String menoKluca) {
        this.menoKluca = menoKluca;
    }

    public Long getIdZakaznika() {
        return idZakaznika;
    }

    public void setIdZakaznika(Long idZakaznika) {
        this.idZakaznika = idZakaznika;
    }

    public Long getIdKluca() {
        return idKluca;
    }

    public void setIdKluca(Long idKluca) {
        this.idKluca = idKluca;
    }
    
    private Long idKluca;
    private String menoKluca;
    private Long idZakaznika;
}
