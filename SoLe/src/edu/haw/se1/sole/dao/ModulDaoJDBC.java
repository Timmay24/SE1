package edu.haw.se1.sole.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import edu.haw.se1.sole.modulverwaltung.IModul;
import edu.haw.se1.sole.modulverwaltung.Modul;
import edu.haw.util.SQLStatementBuilder;

public class ModulDaoJDBC extends JDBCDaoBase implements IModulDao {

    public ModulDaoJDBC() {
        super();
        // TODO Auto-generated constructor stub
    }

    @Override
    public IModul getModulBy(int modul_id) {
        String sql = sql(SQLStatementBuilder.select("*").from("mcfrage").where("modul_id = ?"));
        return this.getJdbcTemplate().queryForObject(sql, new Integer[]{modul_id}, new RowMapper<IModul>() {

            @Override
            public IModul mapRow(ResultSet rs, int rowNum) throws SQLException {
                return new Modul(rs.getInt("modul_id"), rs.getString("bezeichnung"), rs.getString("studiengang"));
            }
        });
    }

}
