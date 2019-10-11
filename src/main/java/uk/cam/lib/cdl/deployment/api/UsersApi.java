package uk.cam.lib.cdl.deployment.api;

import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import uk.cam.lib.cdl.deployment.api.exceptions.BadRequestException;
import uk.cam.lib.cdl.deployment.api.exceptions.NotFoundException;
import uk.cam.lib.cdl.deployment.api.model.Instance;
import uk.cam.lib.cdl.deployment.api.model.Status;

import java.util.List;

public interface UsersApi extends ParentApi {

    @ApiOperation(value = "Returns details for all dl instances", nickname = "instancesGet",
        notes = "Returns details for all the dl instances. ", response = Instance.class, responseContainer = "List",
        authorizations = {
            @Authorization(value = "ApiKeyAuth")}, tags = {"users",})
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Details for all dl instances", response = Instance.class,
            responseContainer = "List"),
        @ApiResponse(code = 401, message = "API key is missing or invalid")})
    @RequestMapping(value = "/instances",
        produces = {"application/json"},
        method = RequestMethod.GET)
    ResponseEntity<List<Instance>> instancesGet() throws BadRequestException;


    @ApiOperation(value = "Returns details for the specified dl instance", nickname = "instancesInstanceidGet",
        notes = "Reads details for the specified digital library instance including data version tag deployed. ",
        response = Instance.class, authorizations = {
        @Authorization(value = "ApiKeyAuth")}, tags = {"users",})
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Details for specified instance", response = Instance.class),
        @ApiResponse(code = 400, message = "bad input parameter (not a valid instance name)"),
        @ApiResponse(code = 401, message = "API key is missing or invalid"),
        @ApiResponse(code = 404, message = "unknown instanceid")})
    @RequestMapping(value = "/instances/{instanceid}",
        produces = {"application/json"},
        method = RequestMethod.GET)
    ResponseEntity<Instance> instancesInstanceidGet(@ApiParam(value = "Name of the dl server instance", required = true)
                                                    @PathVariable("instanceid") String instanceid)
        throws NotFoundException, BadRequestException;


    @ApiOperation(value = "Returns deployment status for the specified dl instance",
        nickname = "instancesInstanceidStatusGet", notes = "", response = Status.class, authorizations = {
        @Authorization(value = "ApiKeyAuth")}, tags = {"users",})
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Status for specified instance", response = Status.class),
        @ApiResponse(code = 400, message = "bad input parameter (not a valid instance name)"),
        @ApiResponse(code = 401, message = "API key is missing or invalid"),
        @ApiResponse(code = 404, message = "unknown instanceid")})
    @RequestMapping(value = "/instances/{instanceid}/status",
        produces = {"application/json"},
        method = RequestMethod.GET)
    ResponseEntity<Status> instancesInstanceidStatusGet(@ApiParam(value = "Name of the dl server instance",
        required = true) @PathVariable("instanceid") String instanceid) throws BadRequestException;

}
