package sk.upjs.ics.paz1c.fitnesscentrum.dao.impl;

import sk.upjs.ics.paz1c.fitnesscentrum.exception.NevalidnyVstupException;
import java.util.List;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import sk.upjs.ics.paz1c.fitnesscentrum.ObjectFactory;
import sk.upjs.ics.paz1c.fitnesscentrum.rowmapper.RecepcnyRowMapper;
import sk.upjs.ics.paz1c.fitnesscentrum.dao.RecepcnyDao;
import sk.upjs.ics.paz1c.fitnesscentrum.entity.Recepcny;

public class MySQLRecepcnyDao implements RecepcnyDao {

    private final JdbcTemplate jdbcTemplate;
    private final RecepcnyRowMapper recepcnyRowMapper;
    private final static int ID_ADMINA = 0;

    public MySQLRecepcnyDao() {
        jdbcTemplate = ObjectFactory.INSTANCE.getJdbcTemplate();
        recepcnyRowMapper = new RecepcnyRowMapper();
    }

    @Override
    public Recepcny dajRecepcneho(String login) {
        String sql = "SELECT * FROM recepcny WHERE login = ?";

        try {
            return jdbcTemplate.queryForObject(sql, recepcnyRowMapper, login);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    @Override
    public List<Recepcny> dajVsetkychRecepcnych() {
        String sgl = "SELECT * FROM recepcny WHERE id > ?";
        return jdbcTemplate.query(sgl, recepcnyRowMapper, ID_ADMINA);
    }

    @Override
    public void vymazRecepcneho(Recepcny recepcny) {
        String sql = "DELETE FROM recepcny WHERE id=?";
        jdbcTemplate.update(sql, recepcny.getId());
    }

    @Override
    public Recepcny dajRecepcneho(Long idRecepcneho) {
        String sql = "SELECT * FROM recepcny WHERE id=?";
        try {
            return jdbcTemplate.queryForObject(sql, recepcnyRowMapper, idRecepcneho);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    @Override
    public void zmenaHeslaRecepcneho(Recepcny recepcny) {
        String sql = "UPDATE recepcny SET heslo =? WHERE id=?";
        jdbcTemplate.update(sql, recepcny.getHeslo(), recepcny.getId());
    }

    @Override
    public void pridajRecepcneho(Recepcny recepcny) throws NevalidnyVstupException {
        String sql = "INSERT INTO recepcny (meno_priezvisko, login, heslo, salt) VALUES (?, ?, ?, ?)";
        try {
            jdbcTemplate.update(sql, recepcny.getMeno(), recepcny.getLogin(), recepcny.getHeslo(), recepcny.getSalt());
        } catch (DuplicateKeyException e) {
            throw new NevalidnyVstupException("Zvolený login je už použitý!");
        }
    }
}
