package sk.upjs.ics.paz1c.fitnesscentrum.dao.impl;

import java.sql.Timestamp;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import sk.upjs.ics.paz1c.fitnesscentrum.ObjectFactory;
import sk.upjs.ics.paz1c.fitnesscentrum.dao.RezervaciaDao;
import sk.upjs.ics.paz1c.fitnesscentrum.entity.Cvicenie;
import sk.upjs.ics.paz1c.fitnesscentrum.entity.Rezervacia;
import sk.upjs.ics.paz1c.fitnesscentrum.entity.Spinning;
import sk.upjs.ics.paz1c.fitnesscentrum.rowmapper.RezervaciaRowMapper;

public class MySQLRezervaciaDao implements RezervaciaDao {

    private final JdbcTemplate jdbcTemplate;
    private final RezervaciaRowMapper rezervaciaRowMapper;

    public MySQLRezervaciaDao() {
        jdbcTemplate = ObjectFactory.INSTANCE.getJdbcTemplate();
        rezervaciaRowMapper = new RezervaciaRowMapper();
    }

    @Override
    public List<Rezervacia> dajVsetkyRezervacie() {
        String sql = "SELECT DISTINCT\n"
                + "	rezervacia.id_rezervacia AS rezervacia_id,\n"
                + "     rezervacia.cas_rezervacie AS rezervacia_cas_rezervacie,\n"
                + "    cvicenie.id AS cvicenie_id,\n"
                + "    cvicenie.datum AS cvicenie_datum,\n"
                + "   cvicenie.kapacita AS cvicenie_kapacita,\n"
                + "    cvicenie.volne AS cvicenie_volne,\n"
                + "    cvicenie.id_instruktora AS instruktor_id,\n"
                + "     cvicenie.id_typ_cvicenia AS id_typ_cvicenia,\n "
                + "	instruktor.meno_priezvisko AS instruktor_meno,\n"
                + "	zakaznik.id AS z_id,\n"
                + "    zakaznik.meno_priezvisko AS z_meno,\n"
                + "    zakaznik.posledny_prichod AS z_posledny_prichod,\n"
                + "    zakaznik.pritomny AS z_pritomny,\n"
                + "    zakaznik.kredit AS z_kredit,\n"
                + "    zakaznik.cislo_permanentky AS z_cislo_permanentky,\n"
                + "	zakaznik.id_kluca AS kluc_id, \n"
                + "	kluc.meno_kluca AS kluc_meno \n"
                + "    FROM rezervacia LEFT JOIN (cvicenie,zakaznik,instruktor)\n"
                + "    ON rezervacia.id_cvicenie = cvicenie.id AND rezervacia.id_zakaznik=zakaznik.id AND cvicenie.id_instruktora=instruktor.id LEFT JOIN kluc ON zakaznik.id_kluca = kluc.id_kluca\n";
        return jdbcTemplate.query(sql, rezervaciaRowMapper);
    }

    @Override
    public List<Rezervacia> dajRezervacieCvicenia(Cvicenie cvicenie) {
        String sql = "SELECT DISTINCT\n"
                + "	rezervacia.id_rezervacia AS rezervacia_id,\n"
                + "     rezervacia.cas_rezervacie AS rezervacia_cas_rezervacie,\n"
               + "    cvicenie.id AS cvicenie_id,\n"
                + "    cvicenie.datum AS cvicenie_datum,\n"
                + "   cvicenie.kapacita AS cvicenie_kapacita,\n"
                + "    cvicenie.volne AS cvicenie_volne,\n"
                + "    cvicenie.id_instruktora AS instruktor_id,\n"
                + "     cvicenie.id_typ_cvicenia AS id_typ_cvicenia,\n "
                + "	instruktor.meno_priezvisko AS instruktor_meno,\n"
                + "	zakaznik.id AS z_id,\n"
                + "    zakaznik.meno_priezvisko AS z_meno,\n"
                + "    zakaznik.posledny_prichod AS z_posledny_prichod,\n"
                + "    zakaznik.pritomny AS z_pritomny,\n"
                + "    zakaznik.kredit AS z_kredit,\n"
                + "    zakaznik.cislo_permanentky AS z_cislo_permanentky,\n"
                + "	zakaznik.id_kluca AS kluc_id, \n"
                + "	kluc.meno_kluca AS kluc_meno \n"
                + "    FROM rezervacia LEFT JOIN (cvicenie,zakaznik,instruktor)\n"
                + "    ON rezervacia.id_cvicenie = cvicenie.id "
                + "AND rezervacia.id_zakaznik=zakaznik.id "
                + "AND cvicenie.id_instruktora=instruktor.id "
                + "LEFT JOIN kluc ON zakaznik.id_kluca = kluc.id_kluca WHERE rezervacia.id_cvicenie = ?";
        return jdbcTemplate.query(sql, rezervaciaRowMapper, cvicenie.getId());
    }

    @Override
    public Rezervacia dajRezervaciuSId(Long idRezervacie) {
        String sql = "SELECT DISTINCT\n"
                + "	rezervacia.id_rezervacia AS rezervacia_id,\n"
                + "     rezervacia.cas_rezervacie AS rezervacia_cas_rezervacie,\n"
                + "    cvicenie.id AS cvicenie_id,\n"
                + "    cvicenie.datum AS cvicenie_datum,\n"
                + "   cvicenie.kapacita AS cvicenie_kapacita,\n"
                + "    cvicenie.volne AS cvicenie_volne,\n"
                + "    cvicenie.id_instruktora AS instruktor_id,\n"
                + "     cvicenie.id_typ_cvicenia AS id_typ_cvicenia,\n "
                + "	instruktor.meno_priezvisko AS instruktor_meno,\n"
                + "	zakaznik.id AS z_id,\n"
                + "    zakaznik.meno_priezvisko AS z_meno,\n"
                + "    zakaznik.posledny_prichod AS z_posledny_prichod,\n"
                + "    zakaznik.pritomny AS z_pritomny,\n"
                + "    zakaznik.kredit AS z_kredit,\n"
                + "    zakaznik.cislo_permanentky AS z_cislo_permanentky,\n"
                + "	zakaznik.id_kluca AS kluc_id, \n"
                + "     kluc.meno_kluca AS kluc_meno \n"
                + "    FROM rezervacia LEFT JOIN (cvicenie,zakaznik,instruktor)\n"
                + "    ON rezervacia.id_cvicenie = cvicenie.id "
                + "AND rezervacia.id_zakaznik=zakaznik.id "
                + "AND cvicenie.id_instruktora=instruktor.id "
                + "LEFT JOIN kluc ON zakaznik.id_kluca = kluc.id_kluca WHERE rezervacia.id_rezervacia = ?";
        return jdbcTemplate.queryForObject(sql, rezervaciaRowMapper, idRezervacie);
    }

    @Override
    public void pridajRezervaciu(Rezervacia rezervacia) {
        String sql = "INSERT INTO rezervacia (id_cvicenie,id_zakaznik,cas_rezervacie) VALUES (?,?,?)";
        jdbcTemplate.update(sql, rezervacia.getCvicenie().getId(), rezervacia.getZakaznik().getId(), Timestamp.valueOf(rezervacia.getCasRezervacie()));
    }

    @Override
    public void odstranRezervacia(Rezervacia rezervacia) {
        String sql = "DELETE FROM rezervacia WHERE id_rezervacia = ?";
        jdbcTemplate.update(sql, rezervacia.getId());
    }

}
