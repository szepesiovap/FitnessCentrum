package sk.upjs.ics.paz1c.fitnesscentrum.manager.impl;

import sk.upjs.ics.paz1c.fitnesscentrum.Hashovanie;
import sk.upjs.ics.paz1c.fitnesscentrum.ObjectFactory;
import sk.upjs.ics.paz1c.fitnesscentrum.manager.HesloManager;
import sk.upjs.ics.paz1c.fitnesscentrum.entity.Recepcny;

public class DefaultHesloManager implements HesloManager {

    private static HesloManager hesloManager = ObjectFactory.INSTANCE.getHesloManager();

    @Override
    public boolean overZhoduHesiel(String zadaneHeslo, String hesloVDb) {
        return zadaneHeslo.equals(hesloVDb);
    }

    @Override
    public String zahesujHeslo(String salt, String heslo) {
        String hashHeslo = Hashovanie.zahesuj(salt, heslo);
        return hashHeslo;
    }

    @Override
    public boolean overHeslo(String salt, String zadaneHeslo, Long idRecepcny) {
        Recepcny recepcny = ObjectFactory.INSTANCE.getRecepcnyDao().dajRecepcneho(idRecepcny);
        String hashHeslo = hesloManager.zahesujHeslo(salt, zadaneHeslo);

        return hesloManager.overZhoduHesiel(hashHeslo, recepcny.getHeslo());
    }

}
