/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.upjs.ics.paz1c.fitnesscentrum.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import org.springframework.jdbc.core.RowMapper;
import sk.upjs.ics.paz1c.fitnesscentrum.entity.Cvicenie;
import sk.upjs.ics.paz1c.fitnesscentrum.entity.Instruktor;
import sk.upjs.ics.paz1c.fitnesscentrum.entity.TypCvicenia;

/**
 *
 * @author ntb
 */
public class CvicenieRowMapper implements RowMapper<Cvicenie> {

    @Override
    public Cvicenie mapRow(ResultSet rs, int i) throws SQLException {
         Cvicenie cvicenie = new Cvicenie();
        cvicenie.setId(rs.getLong("cvicenie_id"));
        Timestamp timestampDatum = rs.getTimestamp("cvicenie_datum");
        if (timestampDatum != null) {
            cvicenie.setDatum(timestampDatum.toLocalDateTime());
        }
        cvicenie.setKapacita(rs.getInt("cvicenie_kapacita"));
        cvicenie.setVolne(rs.getInt("cvicenie_volne"));
        Instruktor instruktor = new Instruktor();
        instruktor.setId(rs.getLong("instruktor_id"));
        instruktor.setMeno(rs.getString("instruktor_meno"));
        cvicenie.setInstruktor(instruktor);
        cvicenie.setTypCvicenia(rs.getLong("id_typ_cvicenia"));
       
        return cvicenie;
    }
    
}
