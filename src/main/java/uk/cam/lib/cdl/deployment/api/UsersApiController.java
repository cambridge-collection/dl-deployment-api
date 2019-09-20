package uk.cam.lib.cdl.deployment.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import uk.cam.lib.cdl.deployment.api.dao.DatabaseDao;
import uk.cam.lib.cdl.deployment.api.exceptions.BadRequestException;
import uk.cam.lib.cdl.deployment.api.exceptions.NotFoundException;
import uk.cam.lib.cdl.deployment.api.model.Instance;
import uk.cam.lib.cdl.deployment.api.model.Status;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

@Controller
@Api(tags = {"users"})
public class UsersApiController implements UsersApi {

    private static final Logger log = LoggerFactory.getLogger(UsersApiController.class);
    private final ObjectMapper objectMapper;
    private final HttpServletRequest request;
    private final DatabaseDao databaseDAO;

    @Autowired
    public UsersApiController(ObjectMapper objectMapper, HttpServletRequest request, DatabaseDao databaseDAO) {
        this.objectMapper = objectMapper;
        this.request = request;
        this.databaseDAO = databaseDAO;
    }

    /**
     * Get a full list of deployed server instances.
     * @return
     * @throws BadRequestException
     */
    public ResponseEntity<List<Instance>> instancesGet() throws BadRequestException {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            List<Instance> instances = databaseDAO.getInstances();
            return new ResponseEntity<>(instances, HttpStatus.OK);
        }

        throw new BadRequestException(new Exception());
    }

    /**
     * Gets the instanceid and version for a specific server instance
     * @param instanceid
     * @return
     * @throws NotFoundException
     * @throws BadRequestException
     */
    public ResponseEntity<Instance> instancesInstanceidGet(@ApiParam(value = "Name of the dl server instance",
        required = true) @PathVariable("instanceid") String instanceid) throws NotFoundException, BadRequestException {

        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {

                Instance instance = databaseDAO.getInstanceFromId(instanceid);
                return new ResponseEntity<>(instance, HttpStatus.OK);

            } catch (EmptyResultDataAccessException e) {
                throw new NotFoundException(e);
            }
        }
        throw new BadRequestException(new Exception());
    }

    public ResponseEntity<Status> instancesInstanceidStatusGet(@ApiParam(value = "Name of the dl server instance",
        required = true) @PathVariable("instanceid") String instanceid) {

        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {

                // TODO Implement this.
                return new ResponseEntity<Status>(objectMapper.readValue("{\n  \"currentItemsVersion\" : \"dl-version-123\",\n  \"instanceId\" : \"dev\",\n  \"currentCollectionsVersion\" : \"dl-version-123\"\n}", Status.class), HttpStatus.NOT_IMPLEMENTED);

            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<Status>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<Status>(HttpStatus.NOT_IMPLEMENTED);
    }

}
