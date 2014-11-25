package edu.haw.se1.sole.dao;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import edu.haw.util.fluid.FluidHelper;
public class JDBCDaoBase {

	private JdbcTemplate jdbcTemplate;

    public JDBCDaoBase(DataSource dataSource) {
        super();
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

	public void setDataSource(DataSource dataSource) {
	    jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	protected JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}
	
	protected String sql(FluidHelper helper) {
		return helper.toString();
	}
}
