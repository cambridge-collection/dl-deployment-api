package uk.cam.lib.cdl.deployment.api.dao;

import org.json.JSONObject;
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
        // https://cudl.lib.cam.ac.uk/data/status

        try {
            String username = env.getProperty("status." + instance.getInstanceId() + ".auth.username");
            String password = env.getProperty("status." + instance.getInstanceId() + ".auth.password");

            URL itemUrl = new URL(instance.getUrl() + "data/status");

            String currentVersionJSON = this.requestGET(itemUrl, "application/json; charset=\"utf-8\"", username,
                password);

            JSONObject json = new JSONObject(currentVersionJSON);

            // TODO refactor api to remove separate item and collection status as they should always be the same.
            Status status = new Status();
            status.setInstanceId(instance.getInstanceId());
            status.setCurrentCollectionsVersion(json.getString("tag"));
            status.setCurrentItemsVersion(json.getString("tag"));

            return status;

        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        return null;

    }
}
