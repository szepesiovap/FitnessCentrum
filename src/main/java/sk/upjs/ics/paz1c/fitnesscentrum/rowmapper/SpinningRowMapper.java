package sk.upjs.ics.paz1c.fitnesscentrum.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import org.springframework.jdbc.core.RowMapper;
import sk.upjs.ics.paz1c.fitnesscentrum.entity.Instruktor;
import sk.upjs.ics.paz1c.fitnesscentrum.entity.Spinning;

public class SpinningRowMapper implements RowMapper<Spinning> {

    @Override
    public Spinning mapRow(ResultSet rs, int i) throws SQLException {
        Spinning spinning = new Spinning();
        spinning.setId(rs.getLong("spinning_id"));
        Timestamp timestampDatum = rs.getTimestamp("spinning_datum");
        if (timestampDatum != null) {
            spinning.setDatum(timestampDatum.toLocalDateTime());
        }
        spinning.setKapacita(rs.getInt("spinning_kapacita"));
        spinning.setVolne(rs.getInt("spinning_volne"));
        Instruktor instruktor = new Instruktor();
        instruktor.setId(rs.getLong("instruktor_id"));
        instruktor.setMeno(rs.getString("instruktor_meno"));
        spinning.setInstruktor(instruktor);
        return spinning;
    }

}
