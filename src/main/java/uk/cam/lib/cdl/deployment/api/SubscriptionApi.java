package uk.cam.lib.cdl.deployment.api;

import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import uk.cam.lib.cdl.deployment.api.model.SubscriptionRequest;

import javax.validation.Valid;

@Api(value = "Subscription", description = "the Subscription API")
public interface SubscriptionApi extends ParentApi {

    @ApiOperation(value = "Subscribe to deployment events", nickname = "instancesSubscribePost", notes = "Subscribe to all events related to the dl instance deployment. Current list of events is [deploymentEvent] ", authorizations = {
        @Authorization(value = "ApiKeyAuth")    }, tags={ "subscription", })
    @ApiResponses(value = {
        @ApiResponse(code = 201, message = "Subscription created."),
        @ApiResponse(code = 401, message = "API key is missing or invalid") })
    @RequestMapping(value = "/instances/subscribe",
        consumes = { "application/json" },
        method = RequestMethod.POST)
    ResponseEntity<Void> instancesSubscribePost(@ApiParam(value = "" ,required=true )  @Valid @RequestBody SubscriptionRequest subscriptionRequest);


    @ApiOperation(value = "Unsubscribe to deployment events", nickname = "instancesUnsubscribePost", notes = "", authorizations = {
        @Authorization(value = "ApiKeyAuth")    }, tags={ "subscription", })
    @ApiResponses(value = {
        @ApiResponse(code = 201, message = "Subscription deleted."),
        @ApiResponse(code = 401, message = "API key is missing or invalid") })
    @RequestMapping(value = "/instances/unsubscribe",
        consumes = { "application/json" },
        method = RequestMethod.POST)
    ResponseEntity<Void> instancesUnsubscribePost(@ApiParam(value = "" ,required=true )  @Valid @RequestBody SubscriptionRequest subscriptionRequest);

}
