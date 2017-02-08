package sk.upjs.ics.paz1c.fitnesscentrum.dao.impl;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import sk.upjs.ics.paz1c.fitnesscentrum.ObjectFactory;
import sk.upjs.ics.paz1c.fitnesscentrum.dao.UdalostDao;
import sk.upjs.ics.paz1c.fitnesscentrum.entity.Udalost;
import sk.upjs.ics.paz1c.fitnesscentrum.entity.Zakaznik;
import sk.upjs.ics.paz1c.fitnesscentrum.rowmapper.UdalostRowMapper;

public class MySQLUdalostDao implements UdalostDao {

    private final JdbcTemplate jdbcTemplate;
    private final UdalostRowMapper udalostRowMapper;
    
    public MySQLUdalostDao() {
        this.jdbcTemplate = ObjectFactory.INSTANCE.getJdbcTemplate();
        this.udalostRowMapper = new UdalostRowMapper();
    }

    @Override
    public List<Udalost> dajVsetkyUdalostiOdZakaznika(Zakaznik zakaznik) {
        String sql = "SELECT * FROM udalost WHERE zakaznik_id = ?;";
        return jdbcTemplate.query(sql, udalostRowMapper, zakaznik.getId());
    }

    @Override
    public List<Udalost> dajVsetkyUdalostiTypu(String typ) {
        String sql = "SELECT * FROM udalost WHERE typ = ?;";
        return jdbcTemplate.query(sql, udalostRowMapper, typ);
    }

    @Override
    public List<Udalost> dajVsetkyUdalostiTypuOdZakaznika(Zakaznik zakaznik, String typ) {
        String sql = "SELECT * FROM udalost WHERE zakaznik_id = ? AND typ = ?;";
        return jdbcTemplate.query(sql, udalostRowMapper, zakaznik.getId(), typ);
    }

    @Override
    public List<Udalost> dajVsetkyUdalostiZoDna(LocalDateTime datum) {
        String sql = "SELECT * FROM udalost WHERE datum = ?;";
        return jdbcTemplate.query(sql, udalostRowMapper, datum.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
    }

    @Override
    public void pridajUdalost(Zakaznik zakaznik, String typ, String obsah) {
        String sql = "INSERT INTO udalost (zakaznik_id, typ, obsah) VALUES (?, ?, ?);";
        jdbcTemplate.update(sql, zakaznik.getId(), typ, obsah);
    }
}
