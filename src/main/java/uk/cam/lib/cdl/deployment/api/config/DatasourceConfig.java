package uk.cam.lib.cdl.deployment.api.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import uk.cam.lib.cdl.deployment.api.dao.DatabaseDao;

import javax.sql.DataSource;

@Configuration
public class DatasourceConfig {

    @Bean
    public DataSource dbDataSource() {

        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setUrl("jdbc:postgresql://divdb01.its.manchester.ac.uk:5432/dldeployment?autoReconnect=true");
        dataSource.setUsername("dldeployment");
        dataSource.setPassword("dq8N7XCgqDeNNwSmUoJx");

        return dataSource;
    }

    @Bean
    @Autowired
    public DatabaseDao databaseDao(DataSource datasource) {
        DatabaseDao dao = new DatabaseDao(datasource);
        return dao;
    }
}
