package sk.upjs.ics.paz1c.fitnesscentrum.dao.impl;

import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import sk.upjs.ics.paz1c.fitnesscentrum.DaoFactory;
import sk.upjs.ics.paz1c.fitnesscentrum.dao.KreditDao;
import sk.upjs.ics.paz1c.fitnesscentrum.entity.Kredit;
import sk.upjs.ics.paz1c.fitnesscentrum.rowmapper.KreditRowMapper;

public class MySQLKreditDao implements KreditDao {

    private final JdbcTemplate jdbcTemplate;
    private final KreditRowMapper kreditRowMapper;

    public MySQLKreditDao() {
        jdbcTemplate = DaoFactory.INSTANCE.getJdbcTemplate();
        kreditRowMapper = new KreditRowMapper();
    }

    @Override
    public List<Kredit> dajVsetkyKredity() {
        String sql = "SELECT * FROM kredit";
        return jdbcTemplate.query(sql, kreditRowMapper);
    }

    @Override
    public void pridajKredit(Kredit kredit) {
        String sql = "INSERT INTO kredit (cena, nazov) VALUES (?, ?)";
        jdbcTemplate.update(sql, kredit.getCena(), kredit.getNazov());
    }

    @Override
    public void vymazKredit(Long idKredit) {
        String sql = "DELETE FROM kredit WHERE id = ?";
        jdbcTemplate.update(sql, idKredit);
    }

    @Override
    public Kredit dajKreditSId(Long idKredit) {
        String sql = "SELECT * FROM kredit WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, kreditRowMapper, idKredit);
    }

}
