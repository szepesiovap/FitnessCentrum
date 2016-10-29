package sk.upjs.ics.paz1c.fitnesscentrum;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import org.springframework.jdbc.core.RowMapper;

class ZakaznikRowMapper implements RowMapper<Zakaznik> {
    
    public ZakaznikRowMapper() {
    }
    
    @Override
    public Zakaznik mapRow(ResultSet rs, int i) throws SQLException {
        Zakaznik zakaznik = new Zakaznik();
        zakaznik.setId(rs.getInt("id"));
        zakaznik.setMeno(rs.getString("meno"));
        Timestamp timestampPoslednyPrichod = rs.getTimestamp("posledny_prichod");
        if (timestampPoslednyPrichod != null) {
            zakaznik.setPoslednyPrichod(timestampPoslednyPrichod.toLocalDateTime());
        }
        Timestamp timestampPlatnostPermanentky = rs.getTimestamp("platnost_permanentky");
        if (timestampPlatnostPermanentky != null) {
            zakaznik.setPlatnostPermanentky(timestampPlatnostPermanentky.toLocalDateTime());
        }
        zakaznik.setCisloPermanentky(rs.getLong("cislo_permanentky"));
        zakaznik.setKredit(rs.getDouble("kredit"));
        return zakaznik;
    }


}
