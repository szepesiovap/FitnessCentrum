package sk.upjs.ics.paz1c.fitnesscentrum.dao.impl;

import com.mysql.cj.jdbc.MysqlDataSource;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import sk.upjs.ics.paz1c.fitnesscentrum.ZakaznikRowMapper;
import sk.upjs.ics.paz1c.fitnesscentrum.dao.ZakaznikDao;
import sk.upjs.ics.paz1c.fitnesscentrum.entity.Zakaznik;

public class MySQLZakaznikDao implements ZakaznikDao {

    private JdbcTemplate jdbcTemplate;
    private MysqlDataSource dataSource;

    public MySQLZakaznikDao() {
        dataSource = new MysqlDataSource();
        dataSource.setDatabaseName("fitnesscentrum");
        dataSource.setUser("root");
        dataSource.setPassword("root");

        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<Zakaznik> dajVsetkychZakaznikov() {
        String sql = "SELECT *  FROM zakaznik";
        return jdbcTemplate.query(sql, new ZakaznikRowMapper());
    }

}
