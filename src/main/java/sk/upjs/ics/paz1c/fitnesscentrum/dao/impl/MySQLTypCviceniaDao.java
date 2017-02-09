/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.upjs.ics.paz1c.fitnesscentrum.dao.impl;

import java.util.List;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import sk.upjs.ics.paz1c.fitnesscentrum.ObjectFactory;
import sk.upjs.ics.paz1c.fitnesscentrum.dao.TypCviceniaDao;
import sk.upjs.ics.paz1c.fitnesscentrum.entity.Cvicenie;
import sk.upjs.ics.paz1c.fitnesscentrum.entity.TypCvicenia;
import sk.upjs.ics.paz1c.fitnesscentrum.rowmapper.CvicenieRowMapper;
import sk.upjs.ics.paz1c.fitnesscentrum.rowmapper.TypCviceniaRowMapper;

/**
 *
 * @author ntb
 */
public class MySQLTypCviceniaDao implements TypCviceniaDao {

    private final JdbcTemplate jdbcTemplate;

    public MySQLTypCviceniaDao() {
        jdbcTemplate = ObjectFactory.INSTANCE.getJdbcTemplate();

    }

    @Override
    public List<TypCvicenia> dajVsetkyTypy() {
        String sql = "SELECT *  FROM typ_cvicenia";
        return jdbcTemplate.query(sql, new TypCviceniaRowMapper());
    }

    @Override
    public TypCvicenia dajTypPodlaId(Long id) {
        String sql = "SELECT *  FROM typ_cvicenia WHERE id = ?";
        try {
            return jdbcTemplate.queryForObject(sql, new TypCviceniaRowMapper(), id);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    @Override
    public void uloz(TypCvicenia typCvicenia) {
         String sql = "INSERT INTO typ_cvicenia (nazov) VALUES (?)";
        jdbcTemplate.update(sql, typCvicenia.getNazov());
    }

}
