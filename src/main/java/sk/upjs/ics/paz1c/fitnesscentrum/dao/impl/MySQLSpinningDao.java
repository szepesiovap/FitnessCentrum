package sk.upjs.ics.paz1c.fitnesscentrum.dao.impl;

import java.sql.Timestamp;
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
        String sql = "SELECT "
                + "spinning.id AS spinning_id, "
                + "spinning.datum AS spinning_datum, "
                + "spinning.kapacita AS spinning_kapacita, "
                + "spinning.volne AS spinning_volne, "
                + "spinning.id_instruktora AS instruktor_id, "
                + "instruktor.meno_priezvisko AS instruktor_meno "
                + "FROM spinning LEFT JOIN instruktor ON spinning.id_instruktora = instruktor.id";
        return jdbcTemplate.query(sql, spinningRowMapper);
    }

    @Override
    public Spinning dajSpinningSId(Long idSpinningu) {
        String sql = "SELECT "
                + "spinning.id AS spinning_id, "
                + "spinning.datum AS spinning_datum, "
                + "spinning.kapacita AS spinning_kapacita, "
                + "spinning.volne AS spinning_volne, "
                + "spinning.id_instruktora AS instruktor_id, "
                + "instruktor.meno_priezvisko AS instruktor_meno "
                + "FROM spinning LEFT JOIN instruktor ON spinning.id_instruktora = instruktor.id WHERE spinning.id = ?";
        return jdbcTemplate.queryForObject(sql, spinningRowMapper, idSpinningu);
    }

    @Override
    public void pridajSpinning(Spinning spinning) {
        String sql = "INSERT INTO spinning (datum,kapacita,volne,id_instruktora) VALUES (?,?,?,?)";
        jdbcTemplate.update(sql, Timestamp.valueOf(spinning.getDatum()), spinning.getKapacita(), spinning.getVolne(), spinning.getInstruktor().getId());
    }

}
