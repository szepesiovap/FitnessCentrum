package sk.upjs.ics.paz1c.fitnesscentrum;

import sk.upjs.ics.paz1c.fitnesscentrum.entity.Recepcny;

public class HesloManager {
    
    private static HesloManager hesloManager = ObjectFactory.INSTANCE.getHesloManager();

    public boolean overZhoduHesiel(String zadaneHeslo, String heslo) {
        return zadaneHeslo.equals(heslo);
    }

    public String zahesujHeslo(String salt, String heslo) {
        String hashHeslo = Hashovanie.zahesuj(salt, heslo);
        return hashHeslo;
    }
    
    public boolean overHeslo(String salt, String heslo, Long idRecepcny) {
        Recepcny recepcny = ObjectFactory.INSTANCE.getRecepcnyDao().dajRecepcneho(idRecepcny);
        String hashHeslo = hesloManager.zahesujHeslo(salt, heslo);

        return hesloManager.overZhoduHesiel(hashHeslo, recepcny.getHeslo());
    }
}
