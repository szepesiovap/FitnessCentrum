package sk.upjs.ics.paz1c.fitnesscentrum;

public enum ZakaznikDaoFactory {

    INSTANCE;
    
    public ZakaznikDao getZakaznikDao() {
        return new ZoznamZakaznikov();
    }
}

