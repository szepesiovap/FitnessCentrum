package sk.upjs.ics.paz1c.fitnesscentrum.dao.impl;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import sk.upjs.ics.paz1c.fitnesscentrum.DaoFactory;
import sk.upjs.ics.paz1c.fitnesscentrum.dao.SpinningDao;
import sk.upjs.ics.paz1c.fitnesscentrum.entity.Spinning;
import sk.upjs.ics.paz1c.fitnesscentrum.rowmapper.SpinningRowMapper;

public class MySQLSpinningDao implements SpinningDao {

    private final JdbcTemplate jdbcTemplate;
    private final SpinningRowMapper spinningRowMapper;

    public MySQLSpinningDao() {
        jdbcTemplate = DaoFactory.INSTANCE.getJdbcTemplate();
        spinningRowMapper = new SpinningRowMapper();
    }

    @Override
    public List<Spinning> dajVsetkySpinningy() {
        String sql = "SELECT *  FROM spinning";
        return jdbcTemplate.query(sql, spinningRowMapper);
    }

    @Override
    public Spinning dajSpinningSId(Long idSpinningu) {
        String sql = "SELECT *  FROM spinning WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, spinningRowMapper, idSpinningu);
    }

    @Override
    public void pridajSpinning(Spinning spinning) {
        String sql = "INSERT INTO spinning (datum,kapacita,volne,id_instruktora) VALUES (?,?,?,?)";
        jdbcTemplate.update(sql, Timestamp.valueOf(spinning.getDatum()), spinning.getKapacita(), spinning.getVolne(), spinning.getIdInstruktora());
    }

}
