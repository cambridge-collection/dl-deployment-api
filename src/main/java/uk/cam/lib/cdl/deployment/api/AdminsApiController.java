package uk.cam.lib.cdl.deployment.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import uk.cam.lib.cdl.deployment.api.dao.DatabaseDao;
import uk.cam.lib.cdl.deployment.api.exceptions.BadRequestException;
import uk.cam.lib.cdl.deployment.api.exceptions.NotFoundException;
import uk.cam.lib.cdl.deployment.api.model.Instance;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Controller
@Api(tags = {"admins"})
public class AdminsApiController implements AdminsApi {

    private static final Logger log = LoggerFactory.getLogger(AdminsApiController.class);

    private final ObjectMapper objectMapper;
    private final HttpServletRequest request;
    private final DatabaseDao databaseDAO;

    @Autowired
    public AdminsApiController(ObjectMapper objectMapper, HttpServletRequest request, DatabaseDao databaseDAO) {
        this.objectMapper = objectMapper;
        this.request = request;
        this.databaseDAO = databaseDAO;
    }

    // TODO Implement add and delete?
/*    public ResponseEntity<Void> instancesInstanceidDelete(@ApiParam(value = "Name of the dl server instance",
        required=true) @PathVariable("instanceid") String instanceid) {
        String accept = request.getHeader("Accept");

        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }*/

    /**
     * Function updates a server instance into the database.
     *
     * @param body
     * @param instanceid
     * @return
     * @throws BadRequestException
     */
    public ResponseEntity<Void> instancesInstanceidPost(@ApiParam(value = "" ,required=true )
                                                        @Valid @RequestBody Instance body,
                                                        @ApiParam(value = "Name of the dl server instance",
                                                            required=true) @PathVariable("instanceid")
                                                            String instanceid) throws BadRequestException,
                                                        NotFoundException {

        if (body.getInstanceId()!=null && body.getInstanceId().equals(instanceid)) {

            try {
                databaseDAO.updateInstance(body);
                return new ResponseEntity<>(HttpStatus.OK);
            } catch (EmptyResultDataAccessException ex) {
                throw new NotFoundException(new Exception());
            }
        }

        throw new BadRequestException(new Exception());
    }

}
