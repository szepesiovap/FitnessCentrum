package sk.upjs.ics.paz1c.fitnesscentrum;

import com.mysql.cj.jdbc.MysqlDataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import sk.upjs.ics.paz1c.fitnesscentrum.dao.RecepcnyDao;
import sk.upjs.ics.paz1c.fitnesscentrum.dao.ZakaznikDao;
import sk.upjs.ics.paz1c.fitnesscentrum.dao.impl.MySQLRecepcnyDao;
import sk.upjs.ics.paz1c.fitnesscentrum.dao.impl.MySQLZakaznikDao;

public enum DaoFactory {

    INSTANCE;

    public JdbcTemplate getJdbcTemplate() {
        MysqlDataSource dataSource;
        dataSource = new MysqlDataSource();
        dataSource.setDatabaseName("fitnesscentrum");
        dataSource.setUser("fitnesscentrum");
        dataSource.setPassword("fitnesscentrum");
        return new JdbcTemplate(dataSource);
    }

    public ZakaznikDao getZakaznikDao() {
        return new ZoznamZakaznikov();
    }

    public MySQLZakaznikDao getMySQLZakaznikDao() {
        return new MySQLZakaznikDao();
    }

    public RecepcnyDao getRecepcnyDao() {
        return new MySQLRecepcnyDao();
    }

}
