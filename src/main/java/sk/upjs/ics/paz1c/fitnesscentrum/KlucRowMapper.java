package sk.upjs.ics.paz1c.fitnesscentrum;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import sk.upjs.ics.paz1c.fitnesscentrum.entity.Kluc;

public class KlucRowMapper implements RowMapper<Kluc> {

    @Override
    public Kluc mapRow(ResultSet rs, int i) throws SQLException {
        Kluc kluc = new Kluc();
        kluc.setIdKluca(rs.getLong("id_kluca"));
        kluc.setMenoKluca(rs.getString("meno_kluca"));
        kluc.setIdZakaznika(rs.getLong("id_zakaznika"));
        return kluc;
    }
}
