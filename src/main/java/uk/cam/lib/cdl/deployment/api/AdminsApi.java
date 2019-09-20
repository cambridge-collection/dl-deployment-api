package uk.cam.lib.cdl.deployment.api;

import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import uk.cam.lib.cdl.deployment.api.exceptions.BadRequestException;
import uk.cam.lib.cdl.deployment.api.exceptions.NotFoundException;
import uk.cam.lib.cdl.deployment.api.model.Instance;

import javax.validation.Valid;

@Api(value = "Admins", description = "the Admins API")
public interface AdminsApi extends ParentApi {

/*    @ApiOperation(value = "Deletes the specified dl instance", nickname = "instancesInstanceidDelete", notes =
        "Deletes the specified digital library instance. ", authorizations = {
        @Authorization(value = "ApiKeyAuth")}, tags = {"admins",})
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Deleted the instance."),
        @ApiResponse(code = 400, message = "bad input parameter (not a valid instance name)"),
        @ApiResponse(code = 401, message = "API key is missing or invalid"),
        @ApiResponse(code = 404, message = "unknown instanceid")})
    @RequestMapping(value = "/instances/{instanceid}",
        method = RequestMethod.DELETE)
    ResponseEntity<Void> instancesInstanceidDelete(@ApiParam(value = "Name of the dl server instance", required = true)
                                                   @PathVariable("instanceid") String instanceid);*/


/*    @ApiOperation(value = "Updates details for the specified dl instance", nickname = "instancesInstanceidPost",
        notes = "Updates details for the specified digital library instance including data version tag deployed. ",
        authorizations = {
            @Authorization(value = "ApiKeyAuth")}, tags = {"admins",})
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Created / updated the instance."),
        @ApiResponse(code = 400, message = "bad input parameter (not a valid instance name)"),
        @ApiResponse(code = 401, message = "API key is missing or invalid"),
        @ApiResponse(code = 404, message = "unknown instanceid")})
    @RequestMapping(value = "/instances/{instanceid}",
        consumes = {"application/json"},
        method = RequestMethod.POST)
    ResponseEntity<Void> instancesInstanceidPost(@ApiParam(value = "", required = true) @Valid @RequestBody
                                                     Instance body, @ApiParam(value = "Name of the dl server instance",
        required = true) @PathVariable("instanceid") String instanceid) throws BadRequestException;*/

    @ApiOperation(value = "Updates details for the specified dl instance", nickname = "instancesInstanceidPost",
        notes = "Updates details for the specified digital library instance including data version tag deployed. ",
        authorizations = {
            @Authorization(value = "ApiKeyAuth")}, tags = {"admins",})
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Updated the instance."),
        @ApiResponse(code = 400, message = "bad input parameter (not a valid instance name)"),
        @ApiResponse(code = 401, message = "API key is missing or invalid"),
        @ApiResponse(code = 404, message = "unknown instanceid")})
    @RequestMapping(value = "/instances/{instanceid}",
        consumes = {"application/json"},
        method = RequestMethod.POST)
    ResponseEntity<Void> instancesInstanceidPost(@ApiParam(value = "", required = true) @Valid @RequestBody
                                                     Instance body, @ApiParam(value = "Name of the dl server instance",
        required = true) @PathVariable("instanceid") String instanceid) throws BadRequestException, NotFoundException;
}
