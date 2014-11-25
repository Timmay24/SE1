package edu.haw.se1.sole.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import edu.haw.se1.sole.modulverwaltung.IModul;
import edu.haw.se1.sole.modulverwaltung.Modul;
import edu.haw.util.SQLSB;

public class ModulDaoJDBC extends JDBCDaoBase implements IModulDao {
    

    private final class ModulMapper implements RowMapper<IModul> {
        @Override
        public IModul mapRow(ResultSet rs, int rowNum) throws SQLException {
            return new Modul(rs.getInt("id"), rs.getString("bezeichnung"), rs.getString("studiengang"));
        }
    }

    private static final String MODUL_TABLE = "modul";

    public ModulDaoJDBC(DataSource dataSource) {
        	super(dataSource);
    }

    @Override
    public IModul getModulBy(int modul_id) {
        String sql = sql(SQLSB.select("*").from(MODUL_TABLE).where("modul_id = ?"));
        return this.getJdbcTemplate().queryForObject(sql, new Integer[]{modul_id}, new ModulMapper());
    }
    
    @Override
    public List<IModul> getAllModules() {
        String sql = sql(SQLSB.select("*").from(MODUL_TABLE));
        return this.getJdbcTemplate().query(sql, new ModulMapper());
    }

    @Override
    public IModul saveModul(IModul modul) {
        String[] columnNames = new String[] {"bezeichnung", "studiengang"};
        String sqlModul = sql(SQLSB.insertInto(MODUL_TABLE).values(columnNames));
        this.getJdbcTemplate().update(sqlModul,
                new Object[] {modul.getBezeichnung(), modul.getStudiengang()});
        int modul_id = this.getJdbcTemplate().queryForObject(sql(SQLSB.select("modul_id_sequence.currval").from("dual")), Integer.class);
        return new Modul(modul_id, modul.getBezeichnung(), modul.getStudiengang());
    }
    

}
