package sk.upjs.ics.paz1c.fitnesscentrum.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import org.springframework.jdbc.core.RowMapper;
import sk.upjs.ics.paz1c.fitnesscentrum.entity.Cvicenie;
import sk.upjs.ics.paz1c.fitnesscentrum.entity.Instruktor;
import sk.upjs.ics.paz1c.fitnesscentrum.entity.Kluc;
import sk.upjs.ics.paz1c.fitnesscentrum.entity.Rezervacia;
import sk.upjs.ics.paz1c.fitnesscentrum.entity.Spinning;
import sk.upjs.ics.paz1c.fitnesscentrum.entity.Zakaznik;

public class RezervaciaRowMapper implements RowMapper<Rezervacia> {
    
    @Override
    public Rezervacia mapRow(ResultSet rs, int i) throws SQLException {
        Rezervacia rezervacia = new Rezervacia();
        rezervacia.setId(rs.getLong("rezervacia_id"));
        Timestamp timestampCasRezervacie = rs.getTimestamp("rezervacia_cas_rezervacie");
        if (timestampCasRezervacie != null) {
            rezervacia.setCasRezervacie(timestampCasRezervacie.toLocalDateTime());
        }
        
        Cvicenie cvicenie = new Cvicenie();
        cvicenie.setId(rs.getLong("cvicenie_id"));
        Timestamp timestampDatum = rs.getTimestamp("cvicenie_datum");
        if (timestampDatum != null) {
            cvicenie.setDatum(timestampDatum.toLocalDateTime());
        }
        cvicenie.setKapacita(rs.getInt("cvicenie_kapacita"));
        cvicenie.setVolne(rs.getInt("cvicenie_volne"));
        Instruktor instruktor = new Instruktor();
        instruktor.setId(rs.getLong("instruktor_id"));
        instruktor.setMeno(rs.getString("instruktor_meno"));
        cvicenie.setInstruktor(instruktor);
        
        Zakaznik zakaznik = new Zakaznik();
        zakaznik.setId(rs.getLong("z_id"));
        zakaznik.setMeno(rs.getString("z_meno"));
        if (rs.getInt("z_pritomny") == 1) {
            zakaznik.setPritomny(true);
        }
        Timestamp timestampPoslednyPrichod = rs.getTimestamp("z_posledny_prichod");
        if (timestampPoslednyPrichod != null) {
            zakaznik.setPoslednyPrichod(timestampPoslednyPrichod.toLocalDateTime());
        }
        zakaznik.setCisloPermanentky(rs.getString("z_cislo_permanentky"));
        zakaznik.setKredit(rs.getDouble("z_kredit"));
        Long idKluca = rs.getLong("kluc_id");
        if (!rs.wasNull()) {
            Kluc kluc = new Kluc();
            kluc.setId(idKluca);
            kluc.setMeno(rs.getString("kluc_meno"));
            zakaznik.setKluc(kluc);
        }
        
        rezervacia.setCvicenie(cvicenie);
        rezervacia.setZakaznik(zakaznik);
        
        return rezervacia;
    }
    
}
