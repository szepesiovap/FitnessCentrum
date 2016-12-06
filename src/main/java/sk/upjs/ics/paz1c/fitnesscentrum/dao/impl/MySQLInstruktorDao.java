package sk.upjs.ics.paz1c.fitnesscentrum.dao.impl;

import java.util.List;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import sk.upjs.ics.paz1c.fitnesscentrum.ObjectFactory;
import sk.upjs.ics.paz1c.fitnesscentrum.dao.InstruktorDao;
import sk.upjs.ics.paz1c.fitnesscentrum.entity.Instruktor;
import sk.upjs.ics.paz1c.fitnesscentrum.rowmapper.InstruktorRowMapper;

public class MySQLInstruktorDao implements InstruktorDao {

    private final JdbcTemplate jdbcTemplate;
    private final InstruktorRowMapper instruktorRowMapper;

    public MySQLInstruktorDao() {
        jdbcTemplate = ObjectFactory.INSTANCE.getJdbcTemplate();
        instruktorRowMapper = new InstruktorRowMapper();
    }

    @Override
    public List<Instruktor> dajVsetychInstruktorov() {
        String sql = "SELECT *  FROM instruktor";
        return jdbcTemplate.query(sql, instruktorRowMapper);
    }

    @Override
    public Instruktor dajInstruktoraSId(Long idInstruktora) {
        String sql = "SELECT *  FROM instruktor WHERE id = ?";
        try {
            return jdbcTemplate.queryForObject(sql, instruktorRowMapper, idInstruktora);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    @Override
    public void pridajInstruktora(Instruktor instruktor) {
        String sql = "INSERT INTO instruktor (meno_priezvisko) VALUES (?)";
        jdbcTemplate.update(sql, instruktor.getMeno());
    }

}
