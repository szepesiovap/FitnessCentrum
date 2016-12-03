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
        String sql = "SELECT DISTINCT\n"
                + "	rezervacia.id_rezervacia AS rezervacia_id,\n"
                + "     rezervacia.cas_rezervacie AS rezervacia_cas_rezervacie,\n"
                + "    spinning.id AS spinning_id,\n"
                + "    spinning.datum AS spinning_datum,\n"
                + "    spinning.kapacita AS spinning_kapacita,\n"
                + "    spinning.volne AS spinning_volne,\n"
                + "    spinning.id_instruktora AS instruktor_id,\n"
                + "	instruktor.meno_priezvisko AS instruktor_meno,\n"
                + "	zakaznik.id AS z_id,\n"
                + "    zakaznik.meno_priezvisko AS z_meno,\n"
                + "    zakaznik.posledny_prichod AS z_posledny_prichod,\n"
                + "    zakaznik.pritomny AS z_pritomny,\n"
                + "    zakaznik.kredit AS z_kredit,\n"
                + "    zakaznik.cislo_permanentky AS z_cislo_permanentky,\n"
                + "	zakaznik.id_kluca AS kluc_id, \n"
                + "	kluc.meno_kluca AS kluc_meno \n"
                + "    FROM rezervacia LEFT JOIN (spinning,zakaznik,instruktor)\n"
                + "    ON rezervacia.id_spinning = spinning.id AND rezervacia.id_zakaznik=zakaznik.id AND spinning.id_instruktora=instruktor.id LEFT JOIN kluc ON zakaznik.id_kluca = kluc.id_kluca\n";
        return jdbcTemplate.query(sql, rezervaciaRowMapper);
    }

    @Override
    public List<Rezervacia> dajRezervacieSpinningu(Spinning spinning) {
        String sql = "SELECT DISTINCT\n"
                + "	rezervacia.id_rezervacia AS rezervacia_id,\n"
                + "     rezervacia.cas_rezervacie AS rezervacia_cas_rezervacie,\n"
                + "    spinning.id AS spinning_id,\n"
                + "    spinning.datum AS spinning_datum,\n"
                + "    spinning.kapacita AS spinning_kapacita,\n"
                + "    spinning.volne AS spinning_volne,\n"
                + "    spinning.id_instruktora AS instruktor_id,\n"
                + "	instruktor.meno_priezvisko AS instruktor_meno,\n"
                + "	zakaznik.id AS z_id,\n"
                + "    zakaznik.meno_priezvisko AS z_meno,\n"
                + "    zakaznik.posledny_prichod AS z_posledny_prichod,\n"
                + "    zakaznik.pritomny AS z_pritomny,\n"
                + "    zakaznik.kredit AS z_kredit,\n"
                + "    zakaznik.cislo_permanentky AS z_cislo_permanentky,\n"
                + "	zakaznik.id_kluca AS kluc_id, \n"
                + "	kluc.meno_kluca AS kluc_meno \n"
                + "    FROM rezervacia LEFT JOIN (spinning,zakaznik,instruktor)\n"
                + "    ON rezervacia.id_spinning = spinning.id "
                + "AND rezervacia.id_zakaznik=zakaznik.id "
                + "AND spinning.id_instruktora=instruktor.id "
                + "LEFT JOIN kluc ON zakaznik.id_kluca = kluc.id_kluca WHERE rezervacia.id_spinning = ?";
        return jdbcTemplate.query(sql, rezervaciaRowMapper, spinning.getId());
    }

    @Override
    public Rezervacia dajRezervaciuSId(Long idRezervacie) {
        String sql = "SELECT DISTINCT\n"
                + "	rezervacia.id_rezervacia AS rezervacia_id,\n"
                + "     rezervacia.cas_rezervacie AS rezervacia_cas_rezervacie,\n"
                + "    spinning.id AS spinning_id,\n"
                + "    spinning.datum AS spinning_datum,\n"
                + "    spinning.kapacita AS spinning_kapacita,\n"
                + "    spinning.volne AS spinning_volne,\n"
                + "    spinning.id_instruktora AS instruktor_id,\n"
                + "	instruktor.meno_priezvisko AS instruktor_meno,\n"
                + "	zakaznik.id AS z_id,\n"
                + "    zakaznik.meno_priezvisko AS z_meno,\n"
                + "    zakaznik.posledny_prichod AS z_posledny_prichod,\n"
                + "    zakaznik.pritomny AS z_pritomny,\n"
                + "    zakaznik.kredit AS z_kredit,\n"
                + "    zakaznik.cislo_permanentky AS z_cislo_permanentky,\n"
                + "	zakaznik.id_kluca AS kluc_id, \n"
                + "	kluc.meno_kluca AS kluc_meno \n"
                + "    FROM rezervacia LEFT JOIN (spinning,zakaznik,instruktor)\n"
                + "    ON rezervacia.id_spinning = spinning.id "
                + "AND rezervacia.id_zakaznik=zakaznik.id "
                + "AND spinning.id_instruktora=instruktor.id "
                + "LEFT JOIN kluc ON zakaznik.id_kluca = kluc.id_kluca WHERE rezervacia.id_rezervacia = ?";
        return jdbcTemplate.queryForObject(sql, rezervaciaRowMapper, idRezervacie);
    }

    @Override
    public void pridajRezervaciu(Rezervacia rezervacia) {
        String sql = "INSERT INTO rezervacia (id_spinning,id_zakaznik,cas_rezervacie) VALUES (?,?,?)";
        jdbcTemplate.update(sql, rezervacia.getSpinning().getId(), rezervacia.getZakaznik().getId(), Timestamp.valueOf(rezervacia.getCasRezervacie()));
    }

}
