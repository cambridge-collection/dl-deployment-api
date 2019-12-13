package uk.cam.lib.cdl.deployment.api.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import uk.cam.lib.cdl.deployment.api.dao.DatabaseDao;

import javax.sql.DataSource;

@Configuration
public class DatasourceConfig {

    @Value("${deployment.db.driver}")
    private String driver;

    @Value("${deployment.db.url}")
    private String url;

    @Value("${deployment.db.username}")
    private String username;

    @Value("${deployment.db.password}")
    private String password;

    @Bean
    public DataSource dbDataSource() {

        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(driver);
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);

        return dataSource;
    }

    @Bean
    @Autowired
    public DatabaseDao databaseDao(DataSource datasource) {
        DatabaseDao dao = new DatabaseDao(datasource);
        return dao;
    }
}
