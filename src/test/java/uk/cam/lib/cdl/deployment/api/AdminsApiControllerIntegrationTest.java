package uk.cam.lib.cdl.deployment.api;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import uk.cam.lib.cdl.deployment.api.model.Instance;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AdminsApiControllerIntegrationTest {

    @Autowired
    private AdminsApi api;

/*    @Test
    public void instancesInstanceidDeleteTest() throws Exception {
        String instanceid = "instanceid_example";
        ResponseEntity<Void> responseEntity = api.instancesInstanceidDelete(instanceid);
        assertEquals(HttpStatus.NOT_IMPLEMENTED, responseEntity.getStatusCode());
    }*/

    @Test
    public void instancesInstanceidPostTest() throws Exception {
        Instance body = new Instance();
        String instanceid = "instanceid_example";
        ResponseEntity<Void> responseEntity = api.instancesInstanceidPost(body, instanceid);
        assertEquals(HttpStatus.NOT_IMPLEMENTED, responseEntity.getStatusCode());
    }

}
