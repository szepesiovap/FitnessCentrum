package sk.upjs.ics.paz1c.fitnesscentrum.dao.impl;

import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import sk.upjs.ics.paz1c.fitnesscentrum.DaoFactory;
import sk.upjs.ics.paz1c.fitnesscentrum.ZakaznikRowMapper;
import sk.upjs.ics.paz1c.fitnesscentrum.dao.ZakaznikDao;
import sk.upjs.ics.paz1c.fitnesscentrum.entity.Zakaznik;

public class MySQLZakaznikDao implements ZakaznikDao {

    private JdbcTemplate jdbcTemplate;
    
    private ZakaznikRowMapper zakaznikRowMapper = new ZakaznikRowMapper();

    public MySQLZakaznikDao() {
        jdbcTemplate = DaoFactory.INSTANCE.getJdbcTemplate();

        //prichod(2, 5);
    }

    @Override
    public List<Zakaznik> dajVsetkychZakaznikov() {
        String sql = "SELECT *  FROM zakaznik";
        return jdbcTemplate.query(sql, zakaznikRowMapper);
    }

    @Override
    public List<Zakaznik> dajPritomnychZakaznikov() {
        String sql = "SELECT *  FROM zakaznik WHERE pritomny=1";
        return jdbcTemplate.query(sql, zakaznikRowMapper);
    }
        
    //zatial som napisala takuto verziu
    @Override
    public void pridajZakaznika(Zakaznik zakaznik) {
        String sql = "INSERT INTO zakaznik (meno_priezvisko) VALUES (?)";
        jdbcTemplate.update(sql, zakaznik.getMeno());
    }

   /* @Override
    public void pridajZakaznika(Zakaznik zakaznik) {
        String sql = "INSERT INTO zakaznik (meno_priezvisko,posledny_prichod,pritomny) VALUES (?,?,?)";
        jdbcTemplate.update(sql, zakaznik.getMeno(), Timestamp.valueOf(LocalDateTime.now()), 1);
    }*/

    @Override
    public void prichod(int idZakaznika, int idKluca) {
        String sql = "UPDATE zakaznik SET pritomny=1,id_kluca=?, posledny_prichod=timestamp(now()) where id = ?";
        jdbcTemplate.update(sql, idKluca, idZakaznika);
    }

    @Override
    public void odchod(int idZakaznika) {
        String sql = "UPDATE zakaznik set pritomny=0,id_kluca=NULL,posledny_prichod=timestamp(now()) where id = ?";
        jdbcTemplate.update(sql, idZakaznika);
    }

    @Override
    public void vymazZakaznika(int idZakaznika) {
       String sql = "DELETE FROM zakaznik WHERE id = ?";
       jdbcTemplate.update(sql, idZakaznika);
    }
}