package sk.upjs.ics.paz1c.fitnesscentrum;

import sk.upjs.ics.paz1c.fitnesscentrum.manager.impl.*;
import com.mysql.cj.jdbc.MysqlDataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import sk.upjs.ics.paz1c.fitnesscentrum.dao.*;
import sk.upjs.ics.paz1c.fitnesscentrum.dao.impl.*;
import sk.upjs.ics.paz1c.fitnesscentrum.manager.*;

public enum ObjectFactory {

    INSTANCE;
    private JdbcTemplate jdbcTemplate;
    private ZakaznikDao zakaznikDao;
    private KlucDao klucDao;
    private RecepcnyDao recepcnyDao;
    private SpinningDao spinningDao;
    private InstruktorDao instruktorDao;
    private RezervaciaDao rezervaciaDao;
    private VstupneDao vstupneDao;
    private KreditDao kreditDao;
    private HesloManager hesloManager;
    private RecepcnyManager recepcnyManager;
    private KreditManager kreditManager;
    private KlucManager klucManager;
    private InstruktorManager instruktorManager;
    private RezervaciaManager rezervaciaManager;
    private SpinningManager spinningManager;
    private ZakaznikManager zakaznikManager;
    private VstupneManager vstupneManager;

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

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public ZakaznikDao getZakaznikDao() {
        if (zakaznikDao == null) {
            zakaznikDao = new MySQLZakaznikDao();
        }
        return zakaznikDao;
    }

    public RecepcnyDao getRecepcnyDao() {
        if (recepcnyDao == null) {
            recepcnyDao = new MySQLRecepcnyDao();
        }
        return recepcnyDao;
    }

    public KlucDao getKlucDao() {
        if (klucDao == null) {
            klucDao = new MySQLKlucDao();
        }
        return klucDao;
    }

    public SpinningDao getSpinningDao() {
        if (spinningDao == null) {
            spinningDao = new MySQLSpinningDao();
        }
        return spinningDao;
    }

    public InstruktorDao getInstruktorDao() {
        if (instruktorDao == null) {
            instruktorDao = new MySQLInstruktorDao();
        }
        return instruktorDao;
    }

    public RezervaciaDao getRezervaciaDao() {
        if (rezervaciaDao == null) {
            rezervaciaDao = new MySQLRezervaciaDao();
        }
        return rezervaciaDao;
    }

    public VstupneDao getVstupneDao() {
        if (vstupneDao == null) {
            vstupneDao = new MySQLVstupneDao();
        }
        return vstupneDao;
    }

    public KreditDao getKreditDao() {
        if (kreditDao == null) {
            kreditDao = new MySQLKreditDao();
        }
        return kreditDao;
    }

    public HesloManager getHesloManager() {
        if (hesloManager == null) {
            hesloManager = new DefaultHesloManager();
        }
        return hesloManager;
    }

    public RecepcnyManager getRecepcnyManager() {
        if (recepcnyManager == null) {
            recepcnyManager = new DefaultRecepcnyManager();
        }
        return recepcnyManager;
    }

    public KreditManager getKreditManager() {
        if (kreditManager == null) {
            kreditManager = new DefaultKreditManager();
        }
        return kreditManager;
    }

    public KlucManager getKlucManager() {
        if (klucManager == null) {
            klucManager = new DefaultKlucManager();
        }
        return klucManager;
    }

    public InstruktorManager getInstruktorManager() {
        if (instruktorManager == null) {
            instruktorManager = new DefaultInstruktorManager();
        }
        return instruktorManager;
    }

    public RezervaciaManager getRezervaciaManager() {
        if (rezervaciaManager == null) {
            rezervaciaManager = new DefaultRezervaciaManager();
        }
        return rezervaciaManager;
    }

    public SpinningManager getSpinningManager() {
        if (spinningManager == null) {
            spinningManager = new DefaultSpinningManager();
        }
        return spinningManager;
    }

    public ZakaznikManager getZakaznikManager() {
        if (zakaznikManager == null) {
            zakaznikManager = new DefaultZakaznikManager();
        }
        return zakaznikManager;
    }

    public VstupneManager getVstupneManager() {
        if (vstupneManager == null) {
            vstupneManager = new DefaultVstupneManager();
        }
        return vstupneManager;
    }
}
