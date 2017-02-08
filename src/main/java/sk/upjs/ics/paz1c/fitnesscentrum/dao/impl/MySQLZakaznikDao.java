package sk.upjs.ics.paz1c.fitnesscentrum.dao.impl;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import sk.upjs.ics.paz1c.fitnesscentrum.exception.NeexistujuciZakaznikException;
import sk.upjs.ics.paz1c.fitnesscentrum.ObjectFactory;
import sk.upjs.ics.paz1c.fitnesscentrum.rowmapper.ZakaznikRowMapper;
import sk.upjs.ics.paz1c.fitnesscentrum.dao.ZakaznikDao;
import sk.upjs.ics.paz1c.fitnesscentrum.entity.Kluc;
import sk.upjs.ics.paz1c.fitnesscentrum.entity.Zakaznik;

public class MySQLZakaznikDao implements ZakaznikDao {

    private final JdbcTemplate jdbcTemplate;
    private final ZakaznikRowMapper zakaznikRowMapper;

    public MySQLZakaznikDao() {
        jdbcTemplate = ObjectFactory.INSTANCE.getJdbcTemplate();
        zakaznikRowMapper = new ZakaznikRowMapper();
    }

    @Override
    public List<Zakaznik> dajVsetkychZakaznikov() {
        String sql = "SELECT "
                + "zakaznik.id AS z_id, "
                + "zakaznik.meno_priezvisko AS z_meno, "
                + "zakaznik.posledny_prichod AS z_posledny_prichod"
                + ", zakaznik.pritomny as z_pritomny, "
                + "zakaznik.kredit as z_kredit, "
                + "zakaznik.cislo_permanentky as z_cislo_permanentky, "
                + "zakaznik.id_kluca AS kluc_id, "
                + "kluc.meno_kluca AS kluc_meno "
                + "FROM zakaznik LEFT JOIN kluc ON zakaznik.id_kluca = kluc.id_kluca ";
        return jdbcTemplate.query(sql, zakaznikRowMapper);
    }

    @Override
    public List<Zakaznik> dajPritomnychZakaznikov() {
        String sql = "SELECT "
                + "zakaznik.id AS z_id, "
                + "zakaznik.meno_priezvisko AS z_meno, "
                + "zakaznik.posledny_prichod AS z_posledny_prichod"
                + ", zakaznik.pritomny as z_pritomny, "
                + "zakaznik.kredit as z_kredit, "
                + "zakaznik.cislo_permanentky as z_cislo_permanentky, "
                + "zakaznik.id_kluca AS kluc_id, "
                + "kluc.meno_kluca AS kluc_meno "
                + "FROM zakaznik LEFT JOIN kluc ON zakaznik.id_kluca = kluc.id_kluca WHERE zakaznik.pritomny=1";
        return jdbcTemplate.query(sql, zakaznikRowMapper);
    }

    @Override
    public void pridajZakaznika(Zakaznik zakaznik) throws DuplicateKeyException {
        String sql = "INSERT INTO zakaznik (meno_priezvisko,posledny_prichod,pritomny,cislo_permanentky,kredit) "
                + "VALUES (:meno , :prichod , :pritomny , :cislo , :kredit )";
        GeneratedKeyHolder gkh = new GeneratedKeyHolder();
        
        Map<String, Object> mapa = new HashMap<>();
        mapa.put("meno", zakaznik.getMeno());
        mapa.put("prichod", Timestamp.valueOf(LocalDateTime.now()));
        mapa.put("pritomny", 0);
        mapa.put("cislo", zakaznik.getCisloPermanentky());
        mapa.put("kredit", zakaznik.getKredit());
        
        NamedParameterJdbcTemplate npjt = new NamedParameterJdbcTemplate(jdbcTemplate);
        
        npjt.update(sql, new MapSqlParameterSource(mapa), gkh);
        zakaznik.setId(gkh.getKey().longValue());
    }

    @Override
    public void prichod(Zakaznik zakaznik, Kluc kluc) {
        String sql = "UPDATE zakaznik SET pritomny=1,id_kluca=?, posledny_prichod=timestamp(now()) where id = ?";
        jdbcTemplate.update(sql, kluc.getId(), zakaznik.getId());
    }

    @Override
    public void odchod(Zakaznik zakaznik) {
        String sql = "UPDATE zakaznik set pritomny=0,id_kluca=NULL,posledny_prichod=timestamp(now()) where id = ?";
        jdbcTemplate.update(sql, zakaznik.getId());
    }

    @Override
    public void vymazZakaznika(Zakaznik zakaznik) {
        String sql = "DELETE FROM zakaznik WHERE id = ?";
        jdbcTemplate.update(sql, zakaznik.getId());
    }

    @Override
    public Zakaznik dajZakaznikaSId(Long idZakaznika) {
        String sql = "SELECT "
                + "zakaznik.id AS z_id, "
                + "zakaznik.meno_priezvisko AS z_meno, "
                + "zakaznik.posledny_prichod AS z_posledny_prichod"
                + ", zakaznik.pritomny as z_pritomny, "
                + "zakaznik.kredit as z_kredit, "
                + "zakaznik.cislo_permanentky as z_cislo_permanentky, "
                + "zakaznik.id_kluca AS kluc_id, "
                + "kluc.meno_kluca AS kluc_meno "
                + "FROM zakaznik LEFT JOIN kluc ON zakaznik.id_kluca = kluc.id_kluca WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, zakaznikRowMapper, idZakaznika);
    }

    @Override
    public Zakaznik dajZakaznikaSCislomPermanentky(String cisloPermanentky) throws NeexistujuciZakaznikException {
        try {
            String sql = "SELECT "
                    + "zakaznik.id AS z_id, "
                    + "zakaznik.meno_priezvisko AS z_meno, "
                    + "zakaznik.posledny_prichod AS z_posledny_prichod"
                    + ", zakaznik.pritomny as z_pritomny, "
                    + "zakaznik.kredit as z_kredit, "
                    + "zakaznik.cislo_permanentky as z_cislo_permanentky, "
                    + "zakaznik.id_kluca AS kluc_id, "
                    + "kluc.meno_kluca AS kluc_meno "
                    + "FROM zakaznik LEFT JOIN kluc ON zakaznik.id_kluca = kluc.id_kluca WHERE cislo_permanentky = ?";
            return jdbcTemplate.queryForObject(sql, zakaznikRowMapper, cisloPermanentky);
        } catch (EmptyResultDataAccessException e) {
            throw new NeexistujuciZakaznikException("Zákazník s daným číslom permanentky neexistuje.");
        }
    }

    @Override
    public List<Zakaznik> dajZakaznikovSoZhodouVMene(String vzorka) {
        if (vzorka.equals("")) {
            return dajVsetkychZakaznikov();
        }
        String sql = "SELECT "
                + "zakaznik.id AS z_id, "
                + "zakaznik.meno_priezvisko AS z_meno, "
                + "zakaznik.posledny_prichod AS z_posledny_prichod"
                + ", zakaznik.pritomny as z_pritomny, "
                + "zakaznik.kredit as z_kredit, "
                + "zakaznik.cislo_permanentky as z_cislo_permanentky, "
                + "zakaznik.id_kluca AS kluc_id, "
                + "kluc.meno_kluca AS kluc_meno "
                + "FROM zakaznik LEFT JOIN kluc ON zakaznik.id_kluca = kluc.id_kluca WHERE zakaznik.meno_priezvisko LIKE ? ";
        return jdbcTemplate.query(sql, zakaznikRowMapper, "%" + vzorka + "%");
    }

    @Override
    public void stiahniKreditZakaznikovi(Zakaznik zakaznik, double suma) {
        double aktualnyKredit = zakaznik.getKredit();
        aktualnyKredit -= suma;
        String sql = "UPDATE zakaznik SET kredit=? where id = ?";
        jdbcTemplate.update(sql, aktualnyKredit, zakaznik.getId());
    }

    @Override
    public void dobiKreditZakaznikovi(Zakaznik zakaznik, double suma) {
        double aktualnyKredit = zakaznik.getKredit();
        aktualnyKredit += suma;
        String sql = "UPDATE zakaznik SET kredit=? where id = ?";
        jdbcTemplate.update(sql, aktualnyKredit, zakaznik.getId());
    }
}
