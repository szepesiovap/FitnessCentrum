package sk.upjs.ics.paz1c.fitnesscentrum;

import java.util.UUID;
import sk.upjs.ics.paz1c.fitnesscentrum.entity.Recepcny;

public class HesloManager {

    public boolean overZhoduHesiel(String zadaneHeslo, String heslo) {
        return zadaneHeslo.equals(heslo);
    }
    
    public void zmenHeslo(String login, String noveHeslo) {

    }

    public String zahesujHeslo(String salt, String heslo) {
        String hashHeslo = Hashovanie.zahesuj(salt, heslo);
        return hashHeslo;
    }

    public String vygenerujSalt() {
        String salt = UUID.randomUUID().toString();
        return salt;
    }
    
    public boolean overHeslo(String salt, String heslo, Long idRecepcny) {
        Recepcny recepcny = ObjectFactory.INSTANCE.getRecepcnyDao().dajRecepcneho(idRecepcny);
        String hashHeslo = ObjectFactory.INSTANCE.getHesloManager().zahesujHeslo(salt, heslo);

        if (ObjectFactory.INSTANCE.getHesloManager().overZhoduHesiel(hashHeslo, recepcny.getHeslo())) {
            return true;
        }
        return false;
    }
}
