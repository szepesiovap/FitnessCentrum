package sk.upjs.ics.paz1c.fitnesscentrum.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import org.springframework.jdbc.core.RowMapper;
import sk.upjs.ics.paz1c.fitnesscentrum.entity.Rezervacia;

public class RezervaciaRowMapper implements RowMapper<Rezervacia> {

    @Override
    public Rezervacia mapRow(ResultSet rs, int i) throws SQLException {
        Rezervacia rezervacia = new Rezervacia();
        rezervacia.setIdRezervacie(rs.getLong("id_rezervacia"));
        rezervacia.setIdSpinningu(rs.getLong("id_spinning"));
        rezervacia.setIdZakaznika(rs.getLong("id_zakaznik"));
        Timestamp timestampCasRezervacie = rs.getTimestamp("cas_rezervacie");
        if (timestampCasRezervacie != null) {
            rezervacia.setCasRezervacie(timestampCasRezervacie.toLocalDateTime());
        }
        return rezervacia;
    }

}
