package sk.upjs.ics.paz1c.fitnesscentrum;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.bind.DatatypeConverter;

public class Hashovanie {
    
    public static String zahesuj(String salt, String heslo){
        String hashString = null;
        String stringForHash = heslo + salt;
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(stringForHash.getBytes());
            byte[] data = md.digest();
            hashString = DatatypeConverter.printHexBinary(data);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(Hashovanie.class.getName()).log(Level.SEVERE, null, ex);
        }
        return hashString;
    }
    
}
