package sk.upjs.ics.paz1c.fitnesscentrum.dao.impl;

import sk.upjs.ics.paz1c.fitnesscentrum.entity.Zakaznik;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import sk.upjs.ics.paz1c.fitnesscentrum.DaoFactory;
import sk.upjs.ics.paz1c.fitnesscentrum.dao.KlucDao;
import sk.upjs.ics.paz1c.fitnesscentrum.entity.Kluc;
import sk.upjs.ics.paz1c.fitnesscentrum.KlucRowMapper;

public class MySQLKlucDao implements KlucDao {

    private JdbcTemplate jdbcTemplate;

    public MySQLKlucDao() {
        jdbcTemplate = DaoFactory.INSTANCE.getJdbcTemplate();
    }

    @Override
    public List<Kluc> dajVsetkyKluce() {
        String sql = "SELECT *  FROM kluc";
        return jdbcTemplate.query(sql, new KlucRowMapper());
    }

    @Override
    public List<Kluc> dajVolneKluce() {
        String sql = "SELECT *  FROM kluc WHERE id_zakaznika is null";
        return jdbcTemplate.query(sql, new KlucRowMapper());
    }

    @Override
    public void priradZakaznika(Zakaznik zakaznik) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void odoberZakaznika(Zakaznik zakaznik) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
