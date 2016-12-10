package sk.upjs.ics.paz1c.fitnesscentrum.dao;

import java.util.List;
import sk.upjs.ics.paz1c.fitnesscentrum.exception.NevalidnyVstupException;
import sk.upjs.ics.paz1c.fitnesscentrum.entity.Recepcny;

public interface RecepcnyDao {

    public Recepcny dajRecepcneho(String login);

    public Recepcny dajRecepcneho(Long idRecepcneho);

    public List<Recepcny> dajVsetkychRecepcnych();

    public void pridajRecepcneho(Recepcny recepcny) throws NevalidnyVstupException;

    public void zmenaHeslaRecepcneho(Recepcny recepcny);

    public void vymazRecepcneho(Recepcny recepcny);
}
