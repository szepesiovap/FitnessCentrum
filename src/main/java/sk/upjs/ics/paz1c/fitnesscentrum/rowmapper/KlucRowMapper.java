package sk.upjs.ics.paz1c.fitnesscentrum.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import org.springframework.jdbc.core.RowMapper;
import sk.upjs.ics.paz1c.fitnesscentrum.entity.Kluc;
import sk.upjs.ics.paz1c.fitnesscentrum.entity.Zakaznik;

public class KlucRowMapper implements RowMapper<Kluc> {

    @Override
    public Kluc mapRow(ResultSet rs, int i) throws SQLException {

        Kluc kluc = new Kluc();
        kluc.setId(rs.getLong("kluc_id"));
        kluc.setMeno(rs.getString("kluc_meno"));
        Long idZakaznika = rs.getLong("z_id");
        if (!rs.wasNull()) {
            Zakaznik zakaznik = new Zakaznik();
            zakaznik.setId(idZakaznika);
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
            kluc.setZakaznik(zakaznik);
        }
        return kluc;
    }
}
