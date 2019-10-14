package battleship;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.Random;
import java.util.Scanner;

@Configuration
@ComponentScan ("battleship")
public class SpringConfiguration {


//    @Bean
//    public Random getRandom() {
//        return new Random();
//    }

    @Bean
   // @Component
    public Scanner getScanner() {
        return new Scanner(System.in);
    }

//    @Bean
//    public DataSource createDataSource() {
//        DriverManagerDataSource dataSource = new DriverManagerDataSource();
//        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
//        //  http://google.com/this/path?key=value
//        dataSource.setUrl("jdbc:mysql://localhost:3306/tag?serverTimezone=UTC");
//        //mysql credentials
//        dataSource.setUsername("retsullivan");
//        dataSource.setPassword("JAVA2SQLPASSWORD");
//        return dataSource;
//    }


    //CREATE USER 'retsullivan'@'localhost'
    //	IDENTIFIED BY 'JAVA2SQLPASSWORD';
    //GRANT ALL PRIVILEGES ON * . * TO 'retsullivan'@'localhost';

//    @Bean
//    @Autowired
//    public JdbcTemplate jdbcTemplate (DataSource dataSource){
//        return new JdbcTemplate(dataSource);
//    }

}