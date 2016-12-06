package sk.upjs.ics.paz1c.fitnesscentrum;

import org.springframework.dao.DuplicateKeyException;
import sk.upjs.ics.paz1c.fitnesscentrum.entity.Recepcny;

public class RecepcnyManager {

    private Recepcny recepcny;
    private final HesloManager hesloManager = ObjectFactory.INSTANCE.getHesloManager();

    public void pridajRecepcneho(String meno, String login, String noveHeslo, String noveHesloZnova) {
        recepcny = new Recepcny();

        if (!("").equals(meno)) {
            recepcny.setMeno(meno);
            if (!("").equals(login)) {
                recepcny.setLogin(login);
            } else {
                System.out.println("Zadajte login");
                return;
            }
        } else {
            System.out.println("Zadajte meno");
            return;
        }

        if (!("").equals(noveHeslo)) {
            if (hesloManager.overZhoduHesiel(noveHesloZnova, noveHeslo)) {
                String salt = hesloManager.vygenerujSalt();
                recepcny.setSalt(salt);

                String hashHeslo = hesloManager.zahesujHeslo(salt, noveHeslo);
                recepcny.setHeslo(hashHeslo);
            } else {
                System.out.println("Heslo sa nezhoduje");
                return;
            }

        } else {
            System.out.println("Heslo nemôže byť prázdne.");
            return;
        }

        try {
            ObjectFactory.INSTANCE.getRecepcnyDao().pridajRecepcneho(recepcny);
        } catch (DuplicateKeyException e) {
            System.out.println("Zvolený login je už použitý");
            return;
        }
    }

}
