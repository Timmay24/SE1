package edu.haw.se1.sole;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;
import org.springframework.transaction.PlatformTransactionManager;

@PropertySource("config.properties")
@Configuration
public class DBConfig {
    @Autowired
    Environment env;
    @Bean
    public DataSource dataSource(){
    SingleConnectionDataSource dataSource = new SingleConnectionDataSource();
    dataSource.setUrl(env.getProperty("URL"));
    dataSource.setUsername(env.getProperty("USER"));
    dataSource.setPassword(env.getProperty("PASSWORD"));
    return dataSource;
    }
    @Bean
    public PlatformTransactionManager transactionManager(){
    return new DataSourceTransactionManager(dataSource());
    }
    @Bean 
    public JdbcTemplate jdbcTemplate(){
        return new JdbcTemplate(dataSource());
    }
}
