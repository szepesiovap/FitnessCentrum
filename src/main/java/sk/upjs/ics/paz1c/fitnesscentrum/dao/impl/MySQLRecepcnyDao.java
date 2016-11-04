
package sk.upjs.ics.paz1c.fitnesscentrum.dao.impl;

import com.mysql.cj.jdbc.MysqlDataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import sk.upjs.ics.paz1c.fitnesscentrum.RecepcnyRowMapper;
import sk.upjs.ics.paz1c.fitnesscentrum.dao.RecepcnyDao;
import sk.upjs.ics.paz1c.fitnesscentrum.dao.ZakaznikDao;
import sk.upjs.ics.paz1c.fitnesscentrum.entity.Recepcny;

public class MySQLRecepcnyDao implements RecepcnyDao {

    private JdbcTemplate jdbcTemplate;
    private MysqlDataSource dataSource;

    public MySQLRecepcnyDao() {
        dataSource = new MysqlDataSource();
        dataSource.setDatabaseName("fitnesscentrum");
        dataSource.setUser("root");
        dataSource.setPassword("root");

        jdbcTemplate = new JdbcTemplate(dataSource);
        
    }

    @Override
    public Recepcny dajRecepcneho(String login, String heslo) {
        Recepcny recepcny= new Recepcny();
        String sql = "SELECT login, heslo FROM recepcny WHERE login = '" +login + "' AND heslo = '"+ heslo + "'";

        try {
        jdbcTemplate.queryForObject(sql, new RecepcnyRowMapper());
        } catch (Exception EmptyResultDataAccessException) {
            return null;
        }            
       return recepcny;
    }
    
}
