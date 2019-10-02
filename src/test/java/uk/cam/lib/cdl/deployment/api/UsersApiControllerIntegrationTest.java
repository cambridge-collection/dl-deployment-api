package uk.cam.lib.cdl.deployment.api;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import uk.cam.lib.cdl.deployment.api.model.Instance;
import uk.cam.lib.cdl.deployment.api.model.Status;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UsersApiControllerIntegrationTest {

    @Autowired
    private UsersApi api;

    @Test
    public  void placeholder() throws Exception {
        return;
    }

/*    @Test
    public void instancesGetTest() throws Exception {
        ResponseEntity<List<Instance>> responseEntity = api.instancesGet();
        //assertEquals(HttpStatus.NOT_IMPLEMENTED, responseEntity.getStatusCode());
    }

    @Test
    public void instancesInstanceidGetTest() throws Exception {
        String instanceid = "instanceid_example";
        ResponseEntity<Instance> responseEntity = api.instancesInstanceidGet(instanceid);
        //assertEquals(HttpStatus.NOT_IMPLEMENTED, responseEntity.getStatusCode());
    }

    @Test
    public void instancesInstanceidStatusGetTest() throws Exception {
        String instanceid = "instanceid_example";
        ResponseEntity<Status> responseEntity = api.instancesInstanceidStatusGet(instanceid);
        //assertEquals(HttpStatus.NOT_IMPLEMENTED, responseEntity.getStatusCode());
    }*/

}
