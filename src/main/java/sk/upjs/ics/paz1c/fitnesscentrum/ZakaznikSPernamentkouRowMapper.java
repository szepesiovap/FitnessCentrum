package sk.upjs.ics.paz1c.fitnesscentrum;

import sk.upjs.ics.paz1c.fitnesscentrum.entity.ZakaznikSPernamentkou;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import org.springframework.jdbc.core.RowMapper;
import sk.upjs.ics.paz1c.fitnesscentrum.entity.Pernamentka;
import sk.upjs.ics.paz1c.fitnesscentrum.entity.Typ;
import sk.upjs.ics.paz1c.fitnesscentrum.entity.Zakaznik;

public class ZakaznikSPernamentkouRowMapper implements RowMapper<ZakaznikSPernamentkou> {

    public ZakaznikSPernamentkouRowMapper() {
    }

    @Override
    public ZakaznikSPernamentkou mapRow(ResultSet rs, int i) throws SQLException {
        ZakaznikSPernamentkou zakaznikSPernamentkou = new ZakaznikSPernamentkou();
        Zakaznik zakaznik = new Zakaznik();
        Pernamentka pernamentka = new Pernamentka();

        zakaznik.setId(rs.getInt("id"));
        zakaznik.setMeno(rs.getString("meno_priezvisko"));
        zakaznik.setIdPernamentky(rs.getInt("idPernamentky"));
        if (rs.getInt("pritomny") == 1) {
            zakaznik.setPritomny(true);
        }

        Timestamp timestampPoslednyPrichod = rs.getTimestamp("posledny_prichod");
        if (timestampPoslednyPrichod != null) {
            zakaznik.setPoslednyPrichod(timestampPoslednyPrichod.toLocalDateTime());
        }

        pernamentka.setId(rs.getInt("id"));
        pernamentka.setCislo(rs.getInt("cislo"));
        if ("MESACNA".equalsIgnoreCase(rs.getString("typ"))) {
            pernamentka.setTyp(Typ.MESACNA);
            pernamentka.setPlatnaOd(rs.getDate("platnost_od"));
            pernamentka.setPlatnaDo(rs.getDate("platnost_do"));

        } else {
            pernamentka.setTyp(Typ.KREDITNA);
            pernamentka.setKredit(rs.getDouble("kredit"));
        }

        zakaznikSPernamentkou.setZakaznik(zakaznik);
        zakaznikSPernamentkou.setPernamentka(pernamentka);

        return zakaznikSPernamentkou;
    }

}
