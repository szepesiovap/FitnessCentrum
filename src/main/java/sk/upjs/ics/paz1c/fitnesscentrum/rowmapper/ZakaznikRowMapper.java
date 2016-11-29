package sk.upjs.ics.paz1c.fitnesscentrum.rowmapper;

import sk.upjs.ics.paz1c.fitnesscentrum.entity.Zakaznik;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import org.springframework.jdbc.core.RowMapper;
import sk.upjs.ics.paz1c.fitnesscentrum.entity.Kluc;

public class ZakaznikRowMapper implements RowMapper<Zakaznik> {

    @Override
    public Zakaznik mapRow(ResultSet rs, int i) throws SQLException {
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
        Long idKluca = rs.getLong("kluc_id");
        if (!rs.wasNull()) {
            Kluc kluc = new Kluc();
            kluc.setId(idKluca);
            kluc.setMeno(rs.getString("kluc_meno"));
            zakaznik.setKluc(kluc);
        }

        return zakaznik;
    }

}
