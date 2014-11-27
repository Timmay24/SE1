package edu.haw.se1.sole.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import edu.haw.se1.sole.fragenverwaltung.Antwort;
import edu.haw.se1.sole.fragenverwaltung.IFrage;
import edu.haw.se1.sole.fragenverwaltung.exception.InvalidFrageException;
import edu.haw.se1.sole.fragenverwaltung.frage.FrageMultipleChoice;
import edu.haw.se1.sole.fragenverwaltung.frage.SchwierigkeitsgradTyp;
import edu.haw.se1.sole.fragenverwaltung.frage.musterloesung.MusterloesungMultipleChoice;
import edu.haw.util.Oracle;
import edu.haw.util.SQLSB;

public class FrageDaoMultipleChoiceJDBC extends JDBCDaoBase implements IFrageMultipleChoiceDao {

    private static final String FRAGE_TABLE = "mcfrage";
    private static final String ANTWORT_TABLE = "mcantwort";
    private IModulDao modulDao;

    public FrageDaoMultipleChoiceJDBC(DataSource dataSource) {
        super(dataSource);
    }

    @Override
    public IFrage getMultipleChoiceFrageBy(int frage_id) {
        String sql = sql(SQLSB.select("*").from(FRAGE_TABLE).where("frage_id = ?"));
        IFrage frage = this.getJdbcTemplate().queryForObject(sql, new Integer[]{frage_id}, new FrageMultipleChoiceMapper());
        return frage;
    }

    @Override
    public List<IFrage> getAllMultipleChoiceFragen() {
        // TODO Auto-generated method stub
        return null;
    }

    /* (non-Javadoc)
     * @see edu.haw.se1.sole.dao.IFrageMultipleChoiceDao#saveFrage(edu.haw.se1.sole.fragenverwaltung.frage.FrageMultipleChoice)
     */
    @Override
    public IFrage saveFrage(FrageMultipleChoice frage) {
    	Assert.notNull(frage);
    	
        String[] columnNames = new String[] {"fragestellung", "schwierigkeit", "modul_id"};
        String sqlFrage = sql(SQLSB.insertInto(FRAGE_TABLE).values(columnNames));
        this.getJdbcTemplate().update(
                sqlFrage,
                new Object[] {frage.getFragestellung(), frage.getSchwierigkeitsgrad().getSchwierigkeit(), frage.getModul().getModulId()});
        int frage_id = this.getJdbcTemplate().queryForObject(sql(SQLSB.select("mcfrage_id_sequence.currval").from("dual")), Integer.class);
        for (Antwort antwort : ((MusterloesungMultipleChoice)frage.getMusterLoesung()).getAntworten()) {
            String sqlAntwort = sql(SQLSB.insertInto(ANTWORT_TABLE).values(new String[] {"frage_id", "antwort", "korrekt"}));
            this.getJdbcTemplate().update(sqlAntwort, new Object[] {frage_id, antwort.getAntwort(), Oracle.toInt(antwort.isKorrekteAntwort())});
        }
        frage.setFrageId(frage_id);
        return frage;
    }
    
    private final class FrageMultipleChoiceMapper implements RowMapper<FrageMultipleChoice> {

        @Override
        public FrageMultipleChoice mapRow(ResultSet rs, int rowNum) throws SQLException {
            try {
                return new FrageMultipleChoice(rs.getInt("id"), rs.getString("fragestellung"), modulDao.getModulBy(rs.getInt("modul_id")), new SchwierigkeitsgradTyp(rs.getInt("schwierigkeit")), new MusterloesungMultipleChoice(getMultipleChoiceAntwortenBy(rs.getInt("id"))));
            } catch (InvalidFrageException e) {
                System.err.println("FrageMultipleChoice pulled from DB didn't fulfill invariant.");
                e.printStackTrace();
            }
            return null;
        }
    }

    private List<Antwort> getMultipleChoiceAntwortenBy(int antwort_id) {
        String sql = sql(SQLSB.select("*").from(ANTWORT_TABLE).where("antwort_id = ?"));
        return this.getJdbcTemplate().query(sql, new Integer[]{antwort_id}, new RowMapper<Antwort>() {

            @Override
            public Antwort mapRow(ResultSet rs, int rowNum) throws SQLException {
                return new Antwort(rs.getInt("id"), rs.getInt("frage_id"), rs.getString("antwort"), Oracle.toBoolean(rs.getInt("korrekt")));
            }
        });
    }
}
