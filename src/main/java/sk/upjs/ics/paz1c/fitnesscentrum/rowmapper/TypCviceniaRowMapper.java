/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.upjs.ics.paz1c.fitnesscentrum.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import sk.upjs.ics.paz1c.fitnesscentrum.entity.TypCvicenia;

/**
 *
 * @author ntb
 */
public class TypCviceniaRowMapper implements RowMapper<TypCvicenia> {

    @Override
    public TypCvicenia mapRow(ResultSet rs, int i) throws SQLException {
        TypCvicenia typCvicenia = new TypCvicenia();
        typCvicenia.setId(rs.getLong("id"));
        typCvicenia.setNazov(rs.getString("nazov"));
        return typCvicenia;
    }

}
