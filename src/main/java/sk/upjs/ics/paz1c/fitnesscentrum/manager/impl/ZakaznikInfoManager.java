package sk.upjs.ics.paz1c.fitnesscentrum.manager.impl;

import java.util.Comparator;
import java.util.Map.Entry;
import java.util.stream.Collectors;
import sk.upjs.ics.paz1c.fitnesscentrum.ObjectFactory;
import sk.upjs.ics.paz1c.fitnesscentrum.dao.NavstevaDao;
import sk.upjs.ics.paz1c.fitnesscentrum.dao.UdalostDao;
import sk.upjs.ics.paz1c.fitnesscentrum.entity.Zakaznik;

public class ZakaznikInfoManager {

    private final UdalostDao udalostDao =  ObjectFactory.INSTANCE.getUdalostDao();
    private final NavstevaDao navstevaDao =  ObjectFactory.INSTANCE.getNavstevaDao();
    
    public String getOblubeneCvicenie(Zakaznik zakaznik) {
        return udalostDao.dajVsetkyUdalostiTypuOdZakaznika(zakaznik, "cvicenie")
                .stream()
                .collect(Collectors.groupingBy(
                    t -> t.getObsah(),
                    Collectors.counting()
                ))
                .entrySet()
                .stream()
                .max(Comparator.comparing(Entry::getValue))
                .get().getKey();
    }

    public Integer getPocetCviceni(Zakaznik zakaznik) {
        return udalostDao.dajVsetkyUdalostiTypuOdZakaznika(zakaznik, "cvicenie").size();
    }

    public Double getKreditCelkom(Zakaznik zakaznik) {
        return udalostDao.dajVsetkyUdalostiTypuOdZakaznika(zakaznik, "kredit+")
                .stream().mapToDouble((t) -> {return Double.parseDouble(t.getObsah());}).reduce(0, Double::sum);
    }

    public Integer getCelkovyCas(Zakaznik zakaznik) {
        return navstevaDao.dajCasZakaznika(zakaznik);
    }
    
}
