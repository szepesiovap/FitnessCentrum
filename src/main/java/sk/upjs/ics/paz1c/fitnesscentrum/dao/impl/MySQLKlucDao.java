package sk.upjs.ics.paz1c.fitnesscentrum.dao.impl;

import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import sk.upjs.ics.paz1c.fitnesscentrum.DaoFactory;
import sk.upjs.ics.paz1c.fitnesscentrum.dao.KlucDao;
import sk.upjs.ics.paz1c.fitnesscentrum.entity.Kluc;
import sk.upjs.ics.paz1c.fitnesscentrum.KlucRowMapper;

public class MySQLKlucDao implements KlucDao {

    private JdbcTemplate jdbcTemplate;

    public MySQLKlucDao() {
        jdbcTemplate = DaoFactory.INSTANCE.getJdbcTemplate();
    }

    @Override
    public List<Kluc> dajVsetkyKluce() {
        String sql = "SELECT *  FROM kluc";
        return jdbcTemplate.query(sql, new KlucRowMapper());
    }

    @Override
    public List<Kluc> dajVolneKluce() {
        String sql = "SELECT *  FROM kluc WHERE id_zakaznika is null";
        return jdbcTemplate.query(sql, new KlucRowMapper());
    }


    @Override
    public Kluc dajKlucSId(Long idKluca) {
        try {
            String sql = "SELECT *  FROM kluc WHERE id_kluca = " + idKluca;
            return jdbcTemplate.query(sql, new KlucRowMapper()).get(0);
        } catch (Exception e) {
            System.err.println("Chyba");
            return null;
        }
    }


    @Override
    public void priradZakaznika(Long idKluca, Long idZakaznika) {
        String sql = "UPDATE kluc SET id_zakaznika= ? where id_kluca = ?";
        jdbcTemplate.update(sql, idZakaznika, idKluca);
    }

    @Override
    public void odoberZakaznika(Long idKluca) {
        String sql = "UPDATE kluc SET id_zakaznika= NULL where id_kluca = ?";
        jdbcTemplate.update(sql, idKluca);
    }

}
