package sk.upjs.ics.paz1c.fitnesscentrum.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import sk.upjs.ics.paz1c.fitnesscentrum.entity.Instruktor;

public class InstruktorRowMapper implements RowMapper<Instruktor> {

    @Override
    public Instruktor mapRow(ResultSet rs, int i) throws SQLException {
        Instruktor instruktor = new Instruktor();
        instruktor.setId(rs.getLong("id"));
        instruktor.setMeno(rs.getString("meno_priezvisko"));
        return instruktor;
    }

}
