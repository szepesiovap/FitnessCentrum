package sk.upjs.ics.paz1c.fitnesscentrum.dao.impl;

import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import sk.upjs.ics.paz1c.fitnesscentrum.DaoFactory;
import sk.upjs.ics.paz1c.fitnesscentrum.dao.KlucDao;
import sk.upjs.ics.paz1c.fitnesscentrum.entity.Kluc;
import sk.upjs.ics.paz1c.fitnesscentrum.rowmapper.KlucRowMapper;

public class MySQLKlucDao implements KlucDao {

    private final JdbcTemplate jdbcTemplate;
    private final KlucRowMapper klucRowMapper;

    public MySQLKlucDao() {
        jdbcTemplate = DaoFactory.INSTANCE.getJdbcTemplate();
        klucRowMapper = new KlucRowMapper();
    }

    @Override
    public List<Kluc> dajVsetkyKluce() {
        String sql = "SELECT *  FROM kluc";
        return jdbcTemplate.query(sql, klucRowMapper);
    }

    @Override
    public List<Kluc> dajVolneKluce() {
        String sql = "SELECT *  FROM kluc WHERE id_zakaznika is null";
        return jdbcTemplate.query(sql, klucRowMapper);
    }


    @Override
    public Kluc dajKlucSId(Long idKluca) {
            String sql = "SELECT *  FROM kluc WHERE id_kluca = ?";
            return jdbcTemplate.queryForObject(sql, klucRowMapper, idKluca);
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
