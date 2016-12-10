package sk.upjs.ics.paz1c.fitnesscentrum.manager;

public interface HesloManager {

    public String zahesujHeslo(String salt, String heslo);
    
    public boolean overHeslo(String salt, String zadaneHeslo, Long idRecepcny);
    
    public boolean overZhoduHesiel(String zadaneHeslo, String hesloVDb);
}
