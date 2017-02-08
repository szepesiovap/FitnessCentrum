package sk.upjs.ics.paz1c.fitnesscentrum.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import org.springframework.jdbc.core.RowMapper;
import sk.upjs.ics.paz1c.fitnesscentrum.ObjectFactory;
import sk.upjs.ics.paz1c.fitnesscentrum.entity.Udalost;
import sk.upjs.ics.paz1c.fitnesscentrum.entity.Zakaznik;

public class UdalostRowMapper implements RowMapper<Udalost> {

    @Override
    public Udalost mapRow(ResultSet rs, int i) throws SQLException {
        Udalost udalost = new Udalost();
        udalost.setId(rs.getLong("id"));
        
        Zakaznik zakaznik = ObjectFactory.INSTANCE.getZakaznikDao().dajZakaznikaSId(rs.getLong("zakaznik_id"));
        udalost.setZakaznik(zakaznik);
        udalost.setDatum(LocalDateTime.parse(rs.getString("datum"), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        udalost.setTyp(rs.getString("typ"));
        udalost.setObsah(rs.getString("obsah"));
        
        return udalost;
    }
    
}
