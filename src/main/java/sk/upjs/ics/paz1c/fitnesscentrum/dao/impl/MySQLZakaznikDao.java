package sk.upjs.ics.paz1c.fitnesscentrum.dao.impl;

import com.mysql.cj.jdbc.MysqlDataSource;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import sk.upjs.ics.paz1c.fitnesscentrum.ZakaznikRowMapper;
import sk.upjs.ics.paz1c.fitnesscentrum.ZakaznikSPernamentkouRowMapper;
import sk.upjs.ics.paz1c.fitnesscentrum.dao.ZakaznikDao;
import sk.upjs.ics.paz1c.fitnesscentrum.entity.Zakaznik;
import sk.upjs.ics.paz1c.fitnesscentrum.entity.ZakaznikSPernamentkou;

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
    
    public List<ZakaznikSPernamentkou> dajVsetkychZakaznikovSPernamentkou() {
        String sql = "SELECT *  FROM zakaznik AS z, pernamentka AS p WHERE z.idPernamentky = p.id";
        return jdbcTemplate.query(sql, new ZakaznikSPernamentkouRowMapper());
    }
    
    public List<Zakaznik> dajPritomnychZakaznikov() {
        String sql = "SELECT *  FROM zakaznik WHERE pritomny=1";
        return jdbcTemplate.query(sql, new ZakaznikRowMapper());
    }

}
