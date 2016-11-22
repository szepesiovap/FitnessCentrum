package sk.upjs.ics.paz1c.fitnesscentrum;

import com.mysql.cj.jdbc.MysqlDataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import sk.upjs.ics.paz1c.fitnesscentrum.dao.KlucDao;
import sk.upjs.ics.paz1c.fitnesscentrum.dao.RecepcnyDao;
import sk.upjs.ics.paz1c.fitnesscentrum.dao.ZakaznikDao;
import sk.upjs.ics.paz1c.fitnesscentrum.dao.impl.MySQLKlucDao;
import sk.upjs.ics.paz1c.fitnesscentrum.dao.impl.MySQLRecepcnyDao;
import sk.upjs.ics.paz1c.fitnesscentrum.dao.impl.MySQLZakaznikDao;

public enum DaoFactory {

    INSTANCE;
    JdbcTemplate jdbcTemplate;
    ZakaznikDao zakaznikDao;
    KlucDao klucDao;
    RecepcnyDao recepcnyDao;

    public JdbcTemplate getJdbcTemplate() {
        if (jdbcTemplate == null) {
            MysqlDataSource dataSource;
            dataSource = new MysqlDataSource();
            dataSource.setDatabaseName("fitnesscentrum");
            dataSource.setUser("fitnesscentrum");
            dataSource.setPassword("fitnesscentrum");
            jdbcTemplate = new JdbcTemplate(dataSource);
        }
        return jdbcTemplate;
    }

    public ZakaznikDao getMySQLZakaznikDao() {
        if (zakaznikDao== null){
            zakaznikDao = new MySQLZakaznikDao();
        }
        return zakaznikDao;
    }

    public RecepcnyDao getRecepcnyDao() {
       if (recepcnyDao== null){
            recepcnyDao = new MySQLRecepcnyDao();
        }
        return recepcnyDao;
    }

    public KlucDao getKlucDao() {
        if (klucDao== null){
            klucDao = new MySQLKlucDao();
        }
        return klucDao;
    }
}
