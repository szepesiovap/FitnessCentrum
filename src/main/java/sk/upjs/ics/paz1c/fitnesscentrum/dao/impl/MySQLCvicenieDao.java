/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.upjs.ics.paz1c.fitnesscentrum.dao.impl;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import sk.upjs.ics.paz1c.fitnesscentrum.ObjectFactory;
import sk.upjs.ics.paz1c.fitnesscentrum.dao.CvicenieDao;
import sk.upjs.ics.paz1c.fitnesscentrum.entity.Cvicenie;
import sk.upjs.ics.paz1c.fitnesscentrum.rowmapper.CvicenieRowMapper;
import sk.upjs.ics.paz1c.fitnesscentrum.rowmapper.SpinningRowMapper;

/**
 *
 * @author ntb
 */
public class MySQLCvicenieDao implements CvicenieDao {

    private final JdbcTemplate jdbcTemplate;
    private final CvicenieRowMapper cvicenieRowMapper;

    public MySQLCvicenieDao() {
        jdbcTemplate = ObjectFactory.INSTANCE.getJdbcTemplate();
        cvicenieRowMapper = new CvicenieRowMapper();
    }

    @Override
    public List<Cvicenie> dajVsetkyCvicenia() {
        String sql = "SELECT "
                + "    cvicenie.id AS cvicenie_id,\n"
                + "    cvicenie.datum AS cvicenie_datum,\n"
                + "   cvicenie.kapacita AS cvicenie_kapacita,\n"
                + "    cvicenie.volne AS cvicenie_volne,\n"
                + "    cvicenie.id_instruktora AS instruktor_id,\n"
                + "     cvicenie.id_typ_cvicenia AS id_typ_cvicenia,\n "
                + "instruktor.meno_priezvisko AS instruktor_meno \n "
                + "FROM cvicenie LEFT JOIN instruktor ON cvicenie.id_instruktora = instruktor.id";
        return jdbcTemplate.query(sql, cvicenieRowMapper);
    }

    @Override
    public List<Cvicenie> dajCviceniaOdDatumu(LocalDateTime datum) {
        String sql = "SELECT "
                + "    cvicenie.id AS cvicenie_id,\n"
                + "    cvicenie.datum AS cvicenie_datum,\n"
                + "   cvicenie.kapacita AS cvicenie_kapacita,\n"
                + "    cvicenie.volne AS cvicenie_volne,\n"
                + "    cvicenie.id_instruktora AS instruktor_id,\n"
                + "     cvicenie.id_typ_cvicenia AS id_typ_cvicenia,\n "
                + "instruktor.meno_priezvisko AS instruktor_meno \n"
                + "FROM cvicenie LEFT JOIN instruktor ON cvicenie.id_instruktora = instruktor.id "
                + "WHERE cvicenie.datum> ?";
        return jdbcTemplate.query(sql, cvicenieRowMapper, Timestamp.valueOf(datum));
    }

    @Override
    public Cvicenie dajCvicenieSId(Long idCvicenia) {
        String sql = "SELECT "
                + "    cvicenie.id AS cvicenie_id,\n"
                + "    cvicenie.datum AS cvicenie_datum,\n"
                + "   cvicenie.kapacita AS cvicenie_kapacita,\n"
                + "    cvicenie.volne AS cvicenie_volne,\n"
                + "    cvicenie.id_instruktora AS instruktor_id,\n"
                + "     cvicenie.id_typ_cvicenia AS id_typ_cvicenia,\n "
                + "instruktor.meno_priezvisko AS instruktor_meno "
                + "FROM cvicenie LEFT JOIN instruktor ON cvicenie.id_instruktora = instruktor.id WHERE cvicenie.id = ?";
        return jdbcTemplate.queryForObject(sql, cvicenieRowMapper, idCvicenia);
    }

    @Override
    public void pridajCvicenie(Cvicenie cvicenie) {
        String sql = "INSERT INTO cvicenie (datum,kapacita,volne,id_instruktora, id_typ_cvicenia) VALUES (?,?,?,?,?)";
        jdbcTemplate.update(sql, Timestamp.valueOf(cvicenie.getDatum()), cvicenie.getKapacita(), cvicenie.getVolne(), cvicenie.getInstruktor().getId(), cvicenie.getTypCvicenia());
    }

    @Override
    public void rezervujCvicenie(Cvicenie cvicenie) {
         int volne = cvicenie.getVolne();
        volne--;
        String sql = "UPDATE cvicenie SET volne =? WHERE id=?";
        jdbcTemplate.update(sql, volne, cvicenie.getId());
    }

    @Override
    public void odrezervujCvicenie(Cvicenie cvicenie) {
        int volne = cvicenie.getVolne();
        volne++;
        String sql = "UPDATE cvicenie SET volne =? WHERE id=?";
        jdbcTemplate.update(sql, volne, cvicenie.getId());
    }

    @Override
    public void vymazCvicenie(Cvicenie cvicenie) {
        String sql = "DELETE FROM cvicenie WHERE id = ?";
        jdbcTemplate.update(sql, cvicenie.getId());
    }

}
