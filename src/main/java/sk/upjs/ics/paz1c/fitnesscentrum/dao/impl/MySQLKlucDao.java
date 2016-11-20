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
    public String[] dajMenaVolnychKlucov() {
        List<Kluc> volneKluce = dajVolneKluce();
        String[] menaVolnychKlucov = new String[volneKluce.size()];
        for (int i = 0; i < volneKluce.size(); i++) {
            menaVolnychKlucov[i] = volneKluce.get(i).getMenoKluca();
        }
        return menaVolnychKlucov;
    }

    @Override
    public int[] dajIdVolnychKlucov() {
        List<Kluc> volneKluce = dajVolneKluce();
        int[] idVolnychKlucov = new int[volneKluce.size()];
        for (int i = 0; i < volneKluce.size(); i++) {
            idVolnychKlucov[i] = volneKluce.get(i).getIdKluca();
        }
        return idVolnychKlucov;
    }

    @Override
    public Kluc dajKlucSId(Integer idKluca) {
        try {
            String sql = "SELECT *  FROM kluc WHERE id_kluca = " + idKluca;
            return jdbcTemplate.query(sql, new KlucRowMapper()).get(0);
        } catch (Exception e) {
            System.err.println("Chyba");
            return null;
        }

    }

    @Override
    public String dajMenoKlucaSId(Integer idKluca) {
        try {
            String sql = "SELECT *  FROM kluc WHERE id_kluca = " + idKluca;
            return jdbcTemplate.query(sql, new KlucRowMapper()).get(0).getMenoKluca();
        } catch (Exception e) {
            System.err.println("Chyba");
            return null;
        }
    }

    @Override
    public void priradZakaznika(int idKluca, int idZakaznika) {
        String sql = "UPDATE kluc SET id_zakaznika= ? where id_kluca = ?";
        jdbcTemplate.update(sql, idZakaznika, idKluca);
    }

    @Override
    public void odoberZakaznika(int idKluca) {
        String sql = "UPDATE kluc SET id_zakaznika= NULL where id_kluca = ?";
        jdbcTemplate.update(sql, idKluca);
    }

}
