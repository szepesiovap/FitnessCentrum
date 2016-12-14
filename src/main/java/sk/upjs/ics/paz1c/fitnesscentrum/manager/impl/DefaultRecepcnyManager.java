package sk.upjs.ics.paz1c.fitnesscentrum.manager.impl;

import java.util.List;
import sk.upjs.ics.paz1c.fitnesscentrum.manager.RecepcnyManager;
import sk.upjs.ics.paz1c.fitnesscentrum.exception.NevalidnyVstupException;
import sk.upjs.ics.paz1c.fitnesscentrum.exception.NeexistujuciRecepcnyException;
import java.util.UUID;
import sk.upjs.ics.paz1c.fitnesscentrum.ObjectFactory;
import sk.upjs.ics.paz1c.fitnesscentrum.dao.RecepcnyDao;
import sk.upjs.ics.paz1c.fitnesscentrum.entity.Recepcny;
import sk.upjs.ics.paz1c.fitnesscentrum.exception.DuplikovanyLoginException;
import sk.upjs.ics.paz1c.fitnesscentrum.exception.PrazdneHesloException;
import sk.upjs.ics.paz1c.fitnesscentrum.exception.PrazdneMenoException;
import sk.upjs.ics.paz1c.fitnesscentrum.exception.PrazdnyRetazecException;
import sk.upjs.ics.paz1c.fitnesscentrum.manager.HesloManager;

public class DefaultRecepcnyManager implements RecepcnyManager {

    private Recepcny recepcny;
    private final HesloManager hesloManager = ObjectFactory.INSTANCE.getHesloManager();
    private final RecepcnyDao recepcnyDao = ObjectFactory.INSTANCE.getRecepcnyDao();

    @Override
    public void pridajRecepcneho(Recepcny recepcny) throws DuplikovanyLoginException,PrazdnyRetazecException, PrazdneMenoException, PrazdneHesloException {

        if (recepcny.getMeno().equals("")) {
            throw new PrazdneMenoException();
        }
        if (recepcny.getLogin().equals("")) {
            throw new PrazdnyRetazecException();
        }

        if (recepcny.getHeslo().equals("")) {
            throw new PrazdneHesloException();
        }

        String salt = UUID.randomUUID().toString();
        recepcny.setSalt(salt);

        String hashHeslo = hesloManager.zahesujHeslo(salt, recepcny.getHeslo());
        recepcny.setHeslo(hashHeslo);
        recepcnyDao.pridajRecepcneho(recepcny);

    }

    @Override
    public void zmenHesloRecepcneho(String login, String heslo, String noveHeslo, String noveHesloZnova) throws NevalidnyVstupException, NeexistujuciRecepcnyException {
        recepcny = recepcnyDao.dajRecepcneho(login);

        if (recepcny == null) {
            throw new NeexistujuciRecepcnyException("Recepčný so zadaným loginom neexistuje!");
        } else {
            String salt = recepcny.getSalt();
            String hashovaneHeslo = hesloManager.zahesujHeslo(salt, heslo);
            if (hesloManager.overZhoduHesiel(hashovaneHeslo, recepcny.getHeslo())) {
                if (!("").equals(noveHeslo)) {
                    if (hesloManager.overZhoduHesiel(noveHeslo, noveHesloZnova)) {
                        String noveHashovaneHeslo = hesloManager.zahesujHeslo(salt, noveHeslo);
                        recepcny.setHeslo(noveHashovaneHeslo);
                        ObjectFactory.INSTANCE.getRecepcnyDao().zmenaHeslaRecepcneho(recepcny);
                    } else {
                        throw new NevalidnyVstupException("Nové heslo sa nezhoduje!");
                    }
                } else {
                    throw new NevalidnyVstupException("Nové heslo nemôže byť prázdne!");
                }
            } else {
                throw new NevalidnyVstupException("Nesprávne heslo!");
            }
        }
    }

    @Override
    public Recepcny dajRecepcneho(Long idRecepecneho) {
        return recepcnyDao.dajRecepcneho(idRecepecneho);
    }

    @Override
    public void vymazRecepcneho(Recepcny recepcny) {
        recepcnyDao.vymazRecepcneho(recepcny);
    }

    @Override
    public List<Recepcny> dajVsetkychRecepcnych() {
        return recepcnyDao.dajVsetkychRecepcnych();
    }
}
