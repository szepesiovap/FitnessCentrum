package sk.upjs.ics.paz1c.fitnesscentrum;

import java.util.UUID;
import sk.upjs.ics.paz1c.fitnesscentrum.dao.RecepcnyDao;
import sk.upjs.ics.paz1c.fitnesscentrum.entity.Recepcny;

public class RecepcnyManager {

    private Recepcny recepcny;
    private final HesloManager hesloManager = ObjectFactory.INSTANCE.getHesloManager();
    private final RecepcnyDao recepcnyDao = ObjectFactory.INSTANCE.getRecepcnyDao();

    public void pridajRecepcneho(String meno, String login, String noveHeslo, String noveHesloZnova) throws NevalidnyVstupException {
        recepcny = new Recepcny();

        if (!("").equals(meno)) {
            recepcny.setMeno(meno);
            if (!("").equals(login)) {
                recepcny.setLogin(login);
            } else {
                throw new NevalidnyVstupException("Zadajte login!");
            }
        } else {
            throw new NevalidnyVstupException("Zadajte meno!");
        }

        if (!("").equals(noveHeslo)) {
            if (hesloManager.overZhoduHesiel(noveHesloZnova, noveHeslo)) {
                String salt = UUID.randomUUID().toString();
                recepcny.setSalt(salt);

                String hashHeslo = hesloManager.zahesujHeslo(salt, noveHeslo);
                recepcny.setHeslo(hashHeslo);
            } else {
                throw new NevalidnyVstupException("Heslo sa nezhoduje!");
            }

        } else {
            throw new NevalidnyVstupException("Nové heslo nemôže byť prázdne!");
        }

        ObjectFactory.INSTANCE.getRecepcnyDao()
                .pridajRecepcneho(recepcny);
    }

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
}
