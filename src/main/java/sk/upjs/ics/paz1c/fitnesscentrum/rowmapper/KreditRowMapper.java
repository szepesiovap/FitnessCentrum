package sk.upjs.ics.paz1c.fitnesscentrum.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import sk.upjs.ics.paz1c.fitnesscentrum.entity.Kredit;

public class KreditRowMapper implements RowMapper<Kredit> {

    @Override
    public Kredit mapRow(ResultSet rs, int i) throws SQLException {
        Kredit kredit = new Kredit();
        kredit.setId(rs.getLong("id"));
        kredit.setCena(rs.getDouble("cena"));
        kredit.setNazov(rs.getString("nazov"));

        return kredit;
    }

}
