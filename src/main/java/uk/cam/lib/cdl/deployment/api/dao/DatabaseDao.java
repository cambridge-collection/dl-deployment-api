package uk.cam.lib.cdl.deployment.api.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import uk.cam.lib.cdl.deployment.api.model.Instance;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class DatabaseDao {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public DatabaseDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public List<Instance> getInstances() {
        String query = "SELECT * FROM currentversions";
        List<Instance> instances = jdbcTemplate.query(
            query, new Object[] {}, new InstanceRowMapper());
        return instances;
    }

    public Instance getInstanceFromId(String id) throws EmptyResultDataAccessException {
        String query = "SELECT * FROM currentversions WHERE instanceid=?";
        Instance instance = jdbcTemplate.queryForObject(
            query, new Object[]{id}, new InstanceRowMapper());
        return instance;
    }

    public void updateInstance(Instance newInstance) throws EmptyResultDataAccessException {
        // Do a select query to find out if the instance already exists
        String query = "SELECT * FROM currentversions WHERE instanceid=?";

        Instance instance = jdbcTemplate.queryForObject(
            query, new Object[]{newInstance.getInstanceId()}, new InstanceRowMapper());

        if (instance!=null) {
            jdbcTemplate.update("UPDATE currentversions SET version=? , url=? WHERE " +
                    "instanceid=? ",
                newInstance.getVersion(), newInstance.getUrl(), newInstance.getInstanceId());
        }

    }

    public class InstanceRowMapper implements RowMapper<Instance> {
        @Override
        public Instance mapRow(ResultSet rs, int rowNum) throws SQLException {
            Instance instance = new Instance();

            instance.setInstanceId(rs.getString("instanceid"));
            instance.setVersion(rs.getString("version"));
            instance.setUrl(rs.getString("url"));

            return instance;
        }
    }
}

