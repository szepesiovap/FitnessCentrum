package sk.upjs.ics.paz1c.fitnesscentrum.dao.impl;

import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import sk.upjs.ics.paz1c.fitnesscentrum.DaoFactory;
import sk.upjs.ics.paz1c.fitnesscentrum.dao.KlucDao;
import sk.upjs.ics.paz1c.fitnesscentrum.entity.Kluc;
import sk.upjs.ics.paz1c.fitnesscentrum.entity.Zakaznik;
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
        String sql = "SELECT "
                + "kluc.id_kluca AS kluc_id, "
                + "kluc.meno_kluca AS kluc_meno, "
                + "zakaznik.id AS z_id, "
                + "zakaznik.meno_priezvisko AS z_meno, "
                + "zakaznik.posledny_prichod AS z_posledny_prichod"
                + ", zakaznik.pritomny as z_pritomny, "
                + "zakaznik.kredit as z_kredit, "
                + "zakaznik.cislo_permanentky as z_cislo_permanentky "
                + "FROM kluc LEFT JOIN zakaznik ON zakaznik.id = kluc.id_zakaznika ";
        return jdbcTemplate.query(sql, klucRowMapper);
    }

    @Override
    public List<Kluc> dajVolneKluce() {
        String sql = "SELECT "
                + "kluc.id_kluca AS kluc_id, "
                + "kluc.meno_kluca AS kluc_meno, "
                + "zakaznik.id AS z_id, "
                + "zakaznik.meno_priezvisko AS z_meno, "
                + "zakaznik.posledny_prichod AS z_posledny_prichod"
                + ", zakaznik.pritomny as z_pritomny, "
                + "zakaznik.kredit as z_kredit, "
                + "zakaznik.cislo_permanentky as z_cislo_permanentky "
                + "FROM kluc LEFT JOIN zakaznik ON zakaznik.id = kluc.id_zakaznika WHERE id_zakaznika is null";
        return jdbcTemplate.query(sql, klucRowMapper);
    }

    @Override
    public Kluc dajKlucSId(Long idKluca) {
        String sql = "SELECT "
                + "kluc.id_kluca AS kluc_id, "
                + "kluc.meno_kluca AS kluc_meno, "
                + "zakaznik.id AS z_id, "
                + "zakaznik.meno_priezvisko AS z_meno, "
                + "zakaznik.posledny_prichod AS z_posledny_prichod,"
                + "zakaznik.pritomny as z_pritomny,"
                + "zakaznik.kredit as z_kredit, "
                + "zakaznik.cislo_permanentky as z_cislo_permanentky "
                + "FROM kluc LEFT JOIN zakaznik ON zakaznik.id = kluc.id_zakaznika WHERE kluc.id_kluca = ?";
        return jdbcTemplate.queryForObject(sql, klucRowMapper, idKluca);
    }

    @Override
    public void priradZakaznika(Kluc kluc, Zakaznik zakaznik) {
        String sql = "UPDATE kluc SET id_zakaznika= ? where id_kluca = ?";
        jdbcTemplate.update(sql, zakaznik.getId(), kluc.getId());
    }

    @Override
    public void odoberZakaznika(Kluc kluc) {
        String sql = "UPDATE kluc SET id_zakaznika= NULL where id_kluca = ?";
        jdbcTemplate.update(sql, kluc.getId());
    }

    @Override
    public void vymazKluc(Long idkluca) {
        String sql = "DELETE FROM kluc WHERE id_kluca=?";
        jdbcTemplate.update(sql, idkluca);
    }

}
