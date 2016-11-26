package sk.upjs.ics.paz1c.fitnesscentrum.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import org.springframework.jdbc.core.RowMapper;
import sk.upjs.ics.paz1c.fitnesscentrum.entity.Spinning;

public class SpinningRowMapper implements RowMapper<Spinning> {

    @Override
    public Spinning mapRow(ResultSet rs, int i) throws SQLException {
        Spinning spinning = new Spinning();
        spinning.setId(rs.getLong("id"));
        Timestamp timestampDatum = rs.getTimestamp("datum");
        if (timestampDatum != null) {
            spinning.setDatum(timestampDatum.toLocalDateTime());
        }
        spinning.setKapacita(rs.getInt("kapacita"));
        spinning.setVolne(rs.getInt("volne"));
        spinning.setIdInstruktora(rs.getLong("id_instruktora"));
        return spinning;
    }

}
