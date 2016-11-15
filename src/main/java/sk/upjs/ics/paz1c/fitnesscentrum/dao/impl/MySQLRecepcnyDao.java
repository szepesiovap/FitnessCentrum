package sk.upjs.ics.paz1c.fitnesscentrum.dao.impl;

import com.mysql.cj.jdbc.MysqlDataSource;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import sk.upjs.ics.paz1c.fitnesscentrum.DaoFactory;
import sk.upjs.ics.paz1c.fitnesscentrum.RecepcnyRowMapper;
import sk.upjs.ics.paz1c.fitnesscentrum.dao.RecepcnyDao;
import sk.upjs.ics.paz1c.fitnesscentrum.dao.ZakaznikDao;
import sk.upjs.ics.paz1c.fitnesscentrum.entity.Recepcny;

public class MySQLRecepcnyDao implements RecepcnyDao {

    private JdbcTemplate jdbcTemplate;
    
    
    public MySQLRecepcnyDao() {
        jdbcTemplate = DaoFactory.INSTANCE.getJdbcTemplate();
    }

    @Override
    public Recepcny dajRecepcneho(String login, String heslo) {
        Recepcny recepcny = new Recepcny();
        String sql = "SELECT login, heslo FROM recepcny WHERE login = ? AND heslo = ?";

        try {
            jdbcTemplate.queryForObject(sql, new RecepcnyRowMapper(), login, heslo);
        } catch (Exception EmptyResultDataAccessException) {
            return null;
        }
        return recepcny;
    }

    @Override
    public List<Recepcny> dajVsetkychRecepcnych() {
        String sgl = "SELECT * FROM recepcny";
        return jdbcTemplate.query(sgl, new RecepcnyRowMapper());        
    }

    @Override
    public void pridajRecepcneho(Recepcny recepcny) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void vymazRecepcneho(Recepcny recepcny) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}