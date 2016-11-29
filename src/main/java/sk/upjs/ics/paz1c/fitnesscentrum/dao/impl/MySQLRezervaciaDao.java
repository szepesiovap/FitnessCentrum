package sk.upjs.ics.paz1c.fitnesscentrum.dao.impl;

import java.sql.Timestamp;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import sk.upjs.ics.paz1c.fitnesscentrum.DaoFactory;
import sk.upjs.ics.paz1c.fitnesscentrum.dao.RezervaciaDao;
import sk.upjs.ics.paz1c.fitnesscentrum.entity.Rezervacia;
import sk.upjs.ics.paz1c.fitnesscentrum.entity.Spinning;
import sk.upjs.ics.paz1c.fitnesscentrum.rowmapper.RezervaciaRowMapper;

public class MySQLRezervaciaDao implements RezervaciaDao {

    private final JdbcTemplate jdbcTemplate;
    private final RezervaciaRowMapper rezervaciaRowMapper;

    public MySQLRezervaciaDao() {
        jdbcTemplate = DaoFactory.INSTANCE.getJdbcTemplate();
        rezervaciaRowMapper = new RezervaciaRowMapper();
    }

    @Override
    public List<Rezervacia> dajVsetkyRezervacie() {
        String sql = "SELECT *  FROM rezervacia";
        return jdbcTemplate.query(sql, rezervaciaRowMapper);
    }

    @Override
    public List<Rezervacia> dajRezervacieSpinningu(Spinning spinning) {
        String sql = "SELECT *  FROM rezervacia WHERE id_spinning = ?";
        return jdbcTemplate.query(sql, rezervaciaRowMapper, spinning.getId());
    }

    @Override
    public Rezervacia dajRezervaciuSId(Long idRezervacie) {
        String sql = "SELECT *  FROM rezervacia WHERE id_rezervacia = ?";
        return jdbcTemplate.queryForObject(sql, rezervaciaRowMapper, idRezervacie);
    }

    @Override
    public void pridajRezervaciu(Rezervacia rezervacia) {
        String sql = "INSERT INTO rezervacia (id_spinning,id_zakaznik,cas_rezervacie) VALUES (?,?,?)";
        jdbcTemplate.update(sql, rezervacia.getSpinning().getId(), rezervacia.getZakaznik().getId(), Timestamp.valueOf(rezervacia.getCasRezervacie()));
    }

}
