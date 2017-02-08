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
    private CvicenieDao cvicenieDao;
    private TypCviceniaDao typCviceniaDao;
    private HesloManager hesloManager;
    private RecepcnyManager recepcnyManager;
    private KreditManager kreditManager;
    private KlucManager klucManager;
    private InstruktorManager instruktorManager;
    private RezervaciaManager rezervaciaManager;
    private SpinningManager spinningManager;
    private CvicenieManager cvicenieManager;
    private ZakaznikManager zakaznikManager;
    private ZakaznikInfoManager zakaznikInfoManager;
    private VstupneManager vstupneManager;
    private NavstevaDao navstevaDao;
    private UdalostDao udalostDao;
    
    public final boolean STATISTIKA = true;

    public JdbcTemplate getJdbcTemplate() {
        if (jdbcTemplate == null) {
            MysqlDataSource dataSource;
            dataSource = new MysqlDataSource();
            dataSource.setUrl("jdbc:mysql://localhost/fitnesscentrum?serverTimezone=UTC");
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
    
    public CvicenieDao getCvicenieDao() {
        if (cvicenieDao == null) {
            cvicenieDao = new MySQLCvicenieDao();
        }
        return cvicenieDao;
    }
    
    public TypCviceniaDao getTypCviceniaDao() {
        if (typCviceniaDao == null) {
            typCviceniaDao = new MySQLTypCviceniaDao();
        }
        return typCviceniaDao;
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
    
    public NavstevaDao getNavstevaDao() {
        if (navstevaDao == null) {
            navstevaDao = new MySQLNavstevaDao();
        }
        return navstevaDao;
    }
    
    public UdalostDao getUdalostDao() {
        if (udalostDao == null) {
            udalostDao = new MySQLUdalostDao();
        }
        return udalostDao;
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
            if (this.STATISTIKA) {
                kreditManager = new LoggingKreditManager();
            } else {
                kreditManager = new DefaultKreditManager();
            }
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

    public CvicenieManager getCvicenieManager() {
        if (cvicenieManager== null) {
            if (this.STATISTIKA) {
                cvicenieManager = new LoggingCvicenieManager();
            } else{
                cvicenieManager= new DefaultCvicenieManager();
            }
        }
        return cvicenieManager;
    }

    public ZakaznikManager getZakaznikManager() {
        if (zakaznikManager == null) {
            if (this.STATISTIKA) {
                zakaznikManager = new LoggingZakaznikManager();
            } else {
                zakaznikManager = new DefaultZakaznikManager();
            }
        }
        return zakaznikManager;
    }
    
    public ZakaznikInfoManager getZakaznikInfoManager() {
        if (zakaznikInfoManager == null) {
            zakaznikInfoManager = new ZakaznikInfoManager();
        }
        return zakaznikInfoManager;
    }

    public VstupneManager getVstupneManager() {
        if (vstupneManager == null) {
            vstupneManager = new DefaultVstupneManager();
        }
        return vstupneManager;
    }
}
