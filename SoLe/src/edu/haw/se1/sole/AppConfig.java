package edu.haw.se1.sole;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
@ComponentScan("edu.haw.se1.sole")
@Import(DBConfig.class)
@Configuration
public class AppConfig {
    

}
