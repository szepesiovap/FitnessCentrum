package sk.upjs.ics.paz1c.fitnesscentrum;

import sk.upjs.ics.paz1c.fitnesscentrum.dao.ZakaznikDao;
import sk.upjs.ics.paz1c.fitnesscentrum.dao.impl.MySQLZakaznikDao;

public enum DaoFactory {

    INSTANCE;
    
    public ZakaznikDao getZakaznikDao() {
        return new ZoznamZakaznikov();
    }
    
    public MySQLZakaznikDao getMySQLZakaznikDao(){
    return new MySQLZakaznikDao();
    }
}

