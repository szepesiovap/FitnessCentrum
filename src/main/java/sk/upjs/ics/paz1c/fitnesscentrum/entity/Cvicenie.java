/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.upjs.ics.paz1c.fitnesscentrum.entity;
import java.time.LocalDateTime;
import sk.upjs.ics.paz1c.fitnesscentrum.ObjectFactory;
import sk.upjs.ics.paz1c.fitnesscentrum.dao.TypCviceniaDao;

/**
 *
 * @author ntb
 */
public class Cvicenie {
     private Long id;
    private LocalDateTime datum;
    private int kapacita;
    private int volne;
    private Instruktor instruktor;
    private Long idTypCvicenia;
    private TypCviceniaDao dao =  ObjectFactory.INSTANCE.getTypCviceniaDao();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getDatum() {
        return datum;
    }

    public void setDatum(LocalDateTime datum) {
        this.datum = datum;
    }

    public int getKapacita() {
        return kapacita;
    }

    public void setKapacita(int kapacita) {
        this.kapacita = kapacita;
    }

    public int getVolne() {
        return volne;
    }

    public void setVolne(int volne) {
        this.volne = volne;
    }

    public Instruktor getInstruktor() {
        return instruktor;
    }

    public void setInstruktor(Instruktor instruktor) {
        this.instruktor = instruktor;
    }

    public Long getTypCvicenia() {
        return idTypCvicenia;
    }

    public void setTypCvicenia(Long idTypCvicenia) {
        this.idTypCvicenia = idTypCvicenia;
    }

    
    @Override
    public String toString() {
        return getDatum().toLocalDate() + "  [ " + dao.dajTypPodlaId(this.getTypCvicenia()).toString()+" ]  " + instruktor.getMeno() + " --Voľných " + volne + " miest.";
    }

}
    

