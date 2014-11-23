package edu.haw.se1.sole.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;

import edu.haw.se1.sole.fragenverwaltung.Antwort;
import edu.haw.se1.sole.fragenverwaltung.IFrage;
import edu.haw.se1.sole.fragenverwaltung.frage.FrageMultipleChoice;
import edu.haw.se1.sole.fragenverwaltung.frage.SchwierigkeitsgradTyp;
import edu.haw.se1.sole.fragenverwaltung.frage.musterloesung.MusterloesungMultipleChoice;
import edu.haw.util.Oracle;
import edu.haw.util.SQLStatementBuilder;

public class FrageDaoMultipleChoiceJDBC extends JDBCDaoBase implements IFrageMultipleChoiceDao {

    private static final String FRAGE_TABLE = "mcfrage";
    private static final String ANTWORT_TABLE = "mcantwort";
    private IModulDao modulDao;

    public FrageDaoMultipleChoiceJDBC() {
        super();
        modulDao = new ModulDaoJDBC();
    }

    @Override
    public IFrage getMultipleChoiceFrageBy(int frage_id) {
        String sql = sql(SQLStatementBuilder.select("*").from(FRAGE_TABLE).where("frage_id = ?"));
        IFrage frage = this.getJdbcTemplate().queryForObject(sql, new Integer[]{frage_id}, new FrageMultipleChoiceMapper());
        return frage;
    }

    @Override
    public List<IFrage> getAllMultipleChoiceFragen() {
        // TODO Auto-generated method stub
        return null;
    }

//    @Override
    public IFrage saveFrage(FrageMultipleChoice frage) {
        String sql = "insert into " + FRAGE_TABLE + " (frage_id, fragestellung, schwierigkeit, modul_id) values(frage_id_sequence.nextval, ?, ?, ?)";
        int affectedRows = this.getJdbcTemplate().update(sql,
                new Object[]{frage.getFragestellung(), frage.getSchwierigkeitsgrad(), frage.getModul().getModulId()});
        // TODO: add antworten / musterloesung to db
        
        // TODO: fill in newly created frage_id
        return frage;
        
//        frage_id int PRIMARY KEY,
//        fragestellung varchar(255),
//        schwierigkeit int,
//        modul_id int REFERENCES modul(modul_id)
        
    }
    
    private final class FrageMultipleChoiceMapper implements RowMapper<FrageMultipleChoice> {

        @Override
        public FrageMultipleChoice mapRow(ResultSet rs, int rowNum) throws SQLException {
            return new FrageMultipleChoice(rs.getString("fragestellung"), modulDao.getModulBy(rs.getInt("modul_id")), new SchwierigkeitsgradTyp(rs.getInt("schwierigkeit")), new MusterloesungMultipleChoice(getMCAntwortenById(rs.getInt("frage_id"))));
        }

    }

    private List<Antwort> getMCAntwortenById(int antwort_id) {
        String sql = sql(SQLStatementBuilder.select("*").from(ANTWORT_TABLE).where("antwort_id = ?"));
        return this.getJdbcTemplate().query(sql, new Integer[]{antwort_id}, new RowMapper<Antwort>() {

            @Override
            public Antwort mapRow(ResultSet rs, int rowNum) throws SQLException {
                return new Antwort(rs.getInt("antwort_id"), rs.getInt("frage_id"), rs.getString("antwort"), Oracle.toBoolean(rs.getInt("korrekt")));
            }
        });
    }
}
