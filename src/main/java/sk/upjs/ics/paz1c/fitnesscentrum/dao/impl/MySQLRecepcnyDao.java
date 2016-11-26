package sk.upjs.ics.paz1c.fitnesscentrum.dao.impl;

import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import sk.upjs.ics.paz1c.fitnesscentrum.DaoFactory;
import sk.upjs.ics.paz1c.fitnesscentrum.rowmapper.RecepcnyRowMapper;
import sk.upjs.ics.paz1c.fitnesscentrum.dao.RecepcnyDao;
import sk.upjs.ics.paz1c.fitnesscentrum.entity.Recepcny;

public class MySQLRecepcnyDao implements RecepcnyDao {

    private final JdbcTemplate jdbcTemplate;
    private final RecepcnyRowMapper recepcnyRowMapper;

    public MySQLRecepcnyDao() {
        jdbcTemplate = DaoFactory.INSTANCE.getJdbcTemplate();
        recepcnyRowMapper = new RecepcnyRowMapper();
    }

    @Override
    public Recepcny dajRecepcneho(String login) {
        String sql = "SELECT * FROM recepcny WHERE login = ?";

        try {
            return jdbcTemplate.queryForObject(sql, recepcnyRowMapper, login);
        } catch (Exception EmptyResultDataAccessException) {
            return null;
        }
    }

    @Override
    public List<Recepcny> dajVsetkychRecepcnych() {
        String sgl = "SELECT * FROM recepcny";
        return jdbcTemplate.query(sgl, recepcnyRowMapper);
    }

    @Override
    public void pridajRecepcneho(Recepcny recepcny) {
        String sql = "INSERT INTO recepcny (meno_priezvisko, login, heslo, salt) VALUES (?, ?, ?, ?)";
        jdbcTemplate.update(sql, recepcny.getMeno(), recepcny.getLogin(), recepcny.getHeslo(), recepcny.getSalt());
    }

    @Override
    public void vymazRecepcneho(Recepcny recepcny) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Recepcny dajRecepcneho(Long idRecepcneho) {
        String sql = "SELECT * FROM recepcny WHERE id=?";
        return jdbcTemplate.queryForObject(sql, recepcnyRowMapper, idRecepcneho);
    }

    @Override
    public void updateRecepcneho(Recepcny recepcny) {
        String sql = "UPDATE recepcny SET heslo =? WHERE id=?";
        jdbcTemplate.update(sql, recepcny.getHeslo(), recepcny.getId());
    }

}