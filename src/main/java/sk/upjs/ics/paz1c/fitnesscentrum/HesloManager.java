package sk.upjs.ics.paz1c.fitnesscentrum;

import java.util.UUID;

public class HesloManager {

    public static boolean overZhoduHesiel(String zadaneHeslo, String heslo) {
        return zadaneHeslo.equals(heslo);
    }

    public void zmenHeslo(String login, String noveHeslo) {

    }

    public static String zahesujHeslo(String salt, String heslo) {
        String hashHeslo = Hashovanie.zahesuj(salt, heslo);
        return hashHeslo;
    }

    public static String vygenerujSalt() {
        String salt = UUID.randomUUID().toString();
        return salt;
    }
}
