package sk.upjs.ics.paz1c.fitnesscentrum.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import sk.upjs.ics.paz1c.fitnesscentrum.entity.Recepcny;

public class RecepcnyRowMapper implements RowMapper<Recepcny> {

    public RecepcnyRowMapper() {
    }

    @Override
    public Recepcny mapRow(ResultSet rs, int i) throws SQLException {
        Recepcny recepcny = new Recepcny();
        recepcny.setId(rs.getLong("id"));
        recepcny.setMeno(rs.getString("meno_priezvisko"));
        recepcny.setLogin(rs.getString("login"));
        recepcny.setHeslo(rs.getString("heslo"));
        recepcny.setSalt(rs.getString("salt"));

        return recepcny;
    }
}