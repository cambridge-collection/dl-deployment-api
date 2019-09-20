package uk.cam.lib.cdl.deployment.api;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import uk.cam.lib.cdl.deployment.api.model.SubscriptionRequest;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SubscriptionApiControllerIntegrationTest {

    @Autowired
    private SubscriptionApi api;

    @Test
    public void instancesSubscribePostTest() throws Exception {
        SubscriptionRequest subscriptionRequest = new SubscriptionRequest();
        ResponseEntity<Void> responseEntity = api.instancesSubscribePost(subscriptionRequest);
        assertEquals(HttpStatus.NOT_IMPLEMENTED, responseEntity.getStatusCode());
    }

    @Test
    public void instancesUnsubscribePostTest() throws Exception {
        SubscriptionRequest subscriptionRequest = new SubscriptionRequest();
        ResponseEntity<Void> responseEntity = api.instancesUnsubscribePost(subscriptionRequest);
        assertEquals(HttpStatus.NOT_IMPLEMENTED, responseEntity.getStatusCode());
    }

}
