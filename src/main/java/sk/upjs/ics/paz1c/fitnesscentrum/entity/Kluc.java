package sk.upjs.ics.paz1c.fitnesscentrum.entity;

public class Kluc {

    private Integer idKluca;
    private String menoKluca;
    private Integer idZakaznika;

    public String getMenoKluca() {
        return menoKluca;
    }

    public void setMenoKluca(String menoKluca) {
        this.menoKluca = menoKluca;
    }

    public Integer getIdZakaznika() {
        return idZakaznika;
    }

    public void setIdZakaznika(Integer idZakaznika) {
        this.idZakaznika = idZakaznika;
    }

    public Integer getIdKluca() {
        return idKluca;
    }

    public void setIdKluca(Integer idKluca) {
        this.idKluca = idKluca;
    }

    @Override
    public String toString() {
        return menoKluca;
    }
    
    

}
