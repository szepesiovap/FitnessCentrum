package sk.upjs.ics.paz1c.fitnesscentrum;

import sk.upjs.ics.paz1c.fitnesscentrum.entity.Zakaznik;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import org.springframework.jdbc.core.RowMapper;

public class ZakaznikRowMapper implements RowMapper<Zakaznik> {
    
    @Override
    public Zakaznik mapRow(ResultSet rs, int i) throws SQLException {
        Zakaznik zakaznik = new Zakaznik();
        zakaznik.setId(rs.getInt("id"));
        zakaznik.setMeno(rs.getString("meno_priezvisko"));
        if (rs.getInt("pritomny") == 1) {
            zakaznik.setPritomny(true);
        }
        
        Timestamp timestampPoslednyPrichod = rs.getTimestamp("posledny_prichod");
        if (timestampPoslednyPrichod != null) {
            zakaznik.setPoslednyPrichod(timestampPoslednyPrichod.toLocalDateTime());
        }
        zakaznik.setCisloPermanentky(rs.getString("cislo_permanentky"));
        zakaznik.setKredit(rs.getDouble("kredit"));
        zakaznik.setIdKluca(rs.getInt("id_kluca"));
        return zakaznik;
    }
    
}
