package sk.upjs.ics.paz1c.fitnesscentrum.dao.impl;

import org.springframework.jdbc.core.JdbcTemplate;
import sk.upjs.ics.paz1c.fitnesscentrum.ObjectFactory;
import sk.upjs.ics.paz1c.fitnesscentrum.dao.VstupneDao;
import sk.upjs.ics.paz1c.fitnesscentrum.entity.Vstupne;
import sk.upjs.ics.paz1c.fitnesscentrum.rowmapper.VstupneRowMapper;

public class MySQLVstupneDao implements VstupneDao {

    private final JdbcTemplate jdbcTemplate;
    private final VstupneRowMapper vstupneRowMapper;
    private static final int ID = 1;

    public MySQLVstupneDao() {
        jdbcTemplate = ObjectFactory.INSTANCE.getJdbcTemplate();
        vstupneRowMapper = new VstupneRowMapper();
    }

    @Override
    public void updateCenaVstupneho(double cena) {
        String sql = "UPDATE vstupne SET cena_vstupneho=? WHERE id=?";
        jdbcTemplate.update(sql, cena, ID);
    }

    @Override
    public void updateCenaCvicenia(double cena) {
        String sql = "UPDATE vstupne SET cena_cvicenia=? WHERE id=?";
        jdbcTemplate.update(sql, cena, ID);
    }

    @Override
    public Vstupne dajCeny() {
        String sql = "SELECT * FROM vstupne";
        return jdbcTemplate.query(sql, vstupneRowMapper).get(0);
    }
}
