package sk.upjs.ics.paz1c.fitnesscentrum.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import org.springframework.jdbc.core.RowMapper;
import sk.upjs.ics.paz1c.fitnesscentrum.entity.Kluc;
import sk.upjs.ics.paz1c.fitnesscentrum.entity.Navsteva;
import sk.upjs.ics.paz1c.fitnesscentrum.entity.Zakaznik;

public class NavstevaRowMapper implements RowMapper<Navsteva>{

    @Override
    public Navsteva mapRow(ResultSet rs, int i) throws SQLException {
        Navsteva navsteva = new Navsteva();
        navsteva.setId(rs.getLong("n_id"));
        Timestamp prichodTimestamp = rs.getTimestamp("n_prichod");
        Timestamp odchodTimestamp = rs.getTimestamp("n_odchod");
        if (prichodTimestamp != null) {
            navsteva.setPrichod(prichodTimestamp.toLocalDateTime());
        }
        
        if (odchodTimestamp != null) {
            navsteva.setOdchod(odchodTimestamp.toLocalDateTime());
        }
        
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
        
        Long idKluca = rs.getLong("k_id");
        if (!rs.wasNull()) {
            Kluc kluc = new Kluc();
            kluc.setId(idKluca);
            kluc.setMeno(rs.getString("k_meno"));
            navsteva.setKluc(kluc);
            zakaznik.setKluc(kluc);
        }
        
        navsteva.setZakaznik(zakaznik);
        
        return navsteva;

    }    
}
