package sk.upjs.ics.paz1c.fitnesscentrum.dao.impl;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import sk.upjs.ics.paz1c.fitnesscentrum.ObjectFactory;
import sk.upjs.ics.paz1c.fitnesscentrum.dao.NavstevaDao;
import sk.upjs.ics.paz1c.fitnesscentrum.entity.Kluc;
import sk.upjs.ics.paz1c.fitnesscentrum.entity.Navsteva;
import sk.upjs.ics.paz1c.fitnesscentrum.entity.Zakaznik;
import sk.upjs.ics.paz1c.fitnesscentrum.rowmapper.NavstevaRowMapper;

public class MySQLNavstevaDao implements NavstevaDao {

    private final JdbcTemplate jdbcTemplate;
    private final NavstevaRowMapper navstevaRowMapper;
    
    public MySQLNavstevaDao() {
        this.jdbcTemplate = ObjectFactory.INSTANCE.getJdbcTemplate();
        navstevaRowMapper = new NavstevaRowMapper();
    }

    @Override
    public List<Navsteva> dajVsetkyNavstevyZakaznika(Zakaznik zakaznik) {
        String sql = "SELECT DISTINCT\n" +
                "    navsteva.id AS n_id,\n" +
                "    navsteva.prichod AS n_prichod,\n" +
                "    navsteva.odchod AS n_odchod,\n" +
                "    zakaznik.id AS z_id,\n" +
                "    zakaznik.meno_priezvisko AS z_meno,\n" +
                "    zakaznik.posledny_prichod AS z_posledny_prichod,\n" +
                "    zakaznik.pritomny AS z_pritomny,\n" +
                "    zakaznik.kredit AS z_kredit,\n" +
                "    zakaznik.cislo_permanentky AS z_cislo_permanentky,\n" +
                "    navsteva.id_kluca AS k_id,\n" +
                "    kluc.meno_kluca AS k_meno\n" +
                "    FROM navsteva\n" +
                "    LEFT JOIN zakaznik\n" +
                "        ON navsteva.zakaznik_id = zakaznik.id\n" +
                "    LEFT JOIN kluc ON navsteva.id_kluca = kluc.id_kluca" +
                "    WHERE zakaznik_id = ?;";
        return jdbcTemplate.query(sql, navstevaRowMapper, zakaznik.getId());
    }

    @Override
    public List<Navsteva> dajVsetkyNavstevyVRozmedzi(LocalDateTime datumOd, LocalDateTime datumDo) {
        String sql = "SELECT DISTINCT\n" +
                "    navsteva.id AS n_id,\n" +
                "    navsteva.prichod AS n_prichod,\n" +
                "    navsteva.odchod AS n_odchod,\n" +
                "    zakaznik.id AS z_id,\n" +
                "    zakaznik.meno_priezvisko AS z_meno,\n" +
                "    zakaznik.posledny_prichod AS z_posledny_prichod,\n" +
                "    zakaznik.pritomny AS z_pritomny,\n" +
                "    zakaznik.kredit AS z_kredit,\n" +
                "    zakaznik.cislo_permanentky AS z_cislo_permanentky,\n" +
                "    zakaznik.id_kluca AS k_id,\n" +
                "    kluc.meno_kluca AS k_meno\n" +
                "    FROM navsteva\n" +
                "    LEFT JOIN zakaznik\n" +
                "        ON navsteva.zakaznik_id = zakaznik.id\n" +
                "    LEFT JOIN kluc ON zakaznik.id_kluca = kluc.id_kluca"
                + "  WHERE (prichod >= ? AND prichod < ?) OR"
                + "        (odchod >= ? AND odchod < ?);";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String datumOdF = datumOd.format(formatter);
        String datumDoF = datumDo.format(formatter);
        return jdbcTemplate.query(sql, navstevaRowMapper,
                datumOdF, datumDoF, datumOdF, datumDoF);
    }

    @Override
    public List<Navsteva> dajNavstevySKlucom(Kluc kluc) {
        
        String sql = "SELECT DISTINCT\n" +
                    "navsteva.id AS n_id,\n" +
                    "navsteva.prichod AS n_prichod,\n" +
                    "navsteva.odchod AS n_odchod,\n" +
                    "zakaznik.id AS z_id,\n" +
                    "zakaznik.meno_priezvisko AS z_meno,\n" +
                    "zakaznik.posledny_prichod AS z_posledny_prichod,\n" +
                    "zakaznik.pritomny AS z_pritomny,\n" +
                    "zakaznik.kredit AS z_kredit,\n" +
                    "zakaznik.cislo_permanentky AS z_cislo_permanentky,\n" +
                    "zakaznik.id_kluca AS k_id,\n" +
                    "kluc.meno_kluca AS k_meno\n" +
                    "FROM navsteva\n" +
                    "LEFT JOIN zakaznik\n" +
                    "ON navsteva.zakaznik_id = zakaznik.id\n" +
                    "LEFT JOIN kluc ON zakaznik.id_kluca = kluc.id_kluca\n" +
                    "WHERE navsteva.id_kluca = ?;";
        //@todo: fix key id
        return jdbcTemplate.query(sql, navstevaRowMapper, kluc.getId());
    }

    @Override
    public Navsteva dajNavstevuSId(Long id) {
        String sql = "SELECT DISTINCT\n" +
                "    navsteva.id AS n_id,\n" +
                "    navsteva.prichod AS n_prichod,\n" +
                "    navsteva.odchod AS n_odchod,\n" +
                "    zakaznik.id AS z_id,\n" +
                "    zakaznik.meno_priezvisko AS z_meno,\n" +
                "    zakaznik.posledny_prichod AS z_posledny_prichod,\n" +
                "    zakaznik.pritomny AS z_pritomny,\n" +
                "    zakaznik.kredit AS z_kredit,\n" +
                "    zakaznik.cislo_permanentky AS z_cislo_permanentky,\n" +
                "    zakaznik.id_kluca AS k_id,\n" +
                "    kluc.meno_kluca AS k_meno\n" +
                "    FROM navsteva\n" +
                "    LEFT JOIN zakaznik\n" +
                "        ON navsteva.zakaznik_id = zakaznik.id\n" +
                "    LEFT JOIN kluc ON zakaznik.id_kluca = kluc.id_kluca" +
                "    WHERE navsteva.id = ?;";
        return jdbcTemplate.queryForObject(sql, navstevaRowMapper, id);
    }

    @Override
    public void registrujPrichod(Zakaznik zakaznik, Kluc kluc) {
        String sql = "INSERT INTO navsteva (zakaznik_id, id_kluca) VALUES (?, ?);";
        jdbcTemplate.update(sql, zakaznik.getId(), kluc.getId());
    }

    @Override
    public void registrujOdchod(Long idZakaznika) {
        String sql = "UPDATE navsteva SET odchod = CURRENT_TIMESTAMP() WHERE zakaznik_id = ? AND odchod IS NULL;";
        jdbcTemplate.update(sql, idZakaznika);
    }

    @Override
    public void registrujOdchod(Navsteva navsteva) {
        String sql = "UPDATE navsteva SET odchod = CURRENT_TIMESTAMP() WHERE id = ?;";
        jdbcTemplate.update(sql, navsteva.getId());
    }

    @Override
    public Integer dajCasZakaznika(Zakaznik zakaznik) {
        String sql = "SELECT SUM(TIMESTAMPDIFF(MINUTE, prichod, odchod)) as sum FROM navsteva WHERE zakaznik_id = ?;";
        return jdbcTemplate.query(sql, (rs, i) -> {return rs.getInt("sum");} , zakaznik.getId()).get(0);
    }
}
