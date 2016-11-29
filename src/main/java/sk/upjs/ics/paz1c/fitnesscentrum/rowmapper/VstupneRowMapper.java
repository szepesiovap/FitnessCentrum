package sk.upjs.ics.paz1c.fitnesscentrum.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import sk.upjs.ics.paz1c.fitnesscentrum.entity.Vstupne;

public class VstupneRowMapper implements RowMapper<Vstupne>{

    @Override
    public Vstupne mapRow(ResultSet rs, int i) throws SQLException {
      Vstupne vstupne = new Vstupne();
      vstupne.setId(rs.getLong("id"));
      vstupne.setCenaVstupneho(rs.getDouble("cena_vstupneho"));
      vstupne.setCenaSpinnigu(rs.getDouble("cena_spinningu"));
      
      return vstupne;
    } 
}
