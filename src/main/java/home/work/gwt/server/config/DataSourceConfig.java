package home.work.gwt.server.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
public class DataSourceConfig {

    @Bean
    public DataSource dataSource() {
//        return new SingleConnectionDataSource("jdbc:postgresql://localhost/z1",
//                "postgres",
//                "admin",
//                true);

        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setUrl("jdbc:postgresql://localhost:5432/z1");
        dataSource.setUsername("postgres");
        dataSource.setPassword("admin");

        return dataSource;
    }
}
