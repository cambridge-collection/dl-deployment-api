package uk.cam.lib.cdl.deployment.api.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import uk.cam.lib.cdl.deployment.api.model.Instance;
import uk.cam.lib.cdl.deployment.api.model.Status;

import java.net.MalformedURLException;
import java.net.URL;

public class StatusAPI extends WebAPI {

    @Autowired
    private Environment env;

    public Status getStatus(Instance instance) {

        // Status files are available at e.g.:
        // https://www.dev.digitalviewer.manchester.ac.uk/deploy/status/current_version_items
        // https://www.dev.digitalviewer.manchester.ac.uk/deploy/status/previous_version_items
        // https://www.dev.digitalviewer.manchester.ac.uk/deploy/status/current_version_database
        // https://www.dev.digitalviewer.manchester.ac.uk/deploy/status/previous_version_database

        try {
            String username = env.getProperty("status." + instance.getInstanceId() + ".auth.username");
            String password = env.getProperty("status." + instance.getInstanceId() + ".auth.password");

            URL itemUrl = new URL(instance.getUrl() + "deploy/status/current_version_items");
            String currentItemsVersion = this.requestGET(itemUrl, "text/plain; charset=\"utf-8\"", username,
                password);

            URL dbUrl = new URL(instance.getUrl() + "deploy/status/current_version_database");
            String currentCollectionsVersion = this.requestGET(dbUrl, "text/plain; charset=\"utf-8\"", username,
                password);

            Status status = new Status();
            status.setInstanceId(instance.getInstanceId());
            status.setCurrentCollectionsVersion(currentCollectionsVersion);
            status.setCurrentItemsVersion(currentItemsVersion);

            return status;

        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        return null;

    }
}
