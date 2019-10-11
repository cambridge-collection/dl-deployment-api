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
import uk.cam.lib.cdl.deployment.api.dao.StatusAPI;
import uk.cam.lib.cdl.deployment.api.exceptions.BadRequestException;
import uk.cam.lib.cdl.deployment.api.exceptions.NotFoundException;
import uk.cam.lib.cdl.deployment.api.model.Instance;
import uk.cam.lib.cdl.deployment.api.model.Status;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@Api(tags = {"users"})
public class UsersApiController implements UsersApi {

    private static final Logger log = LoggerFactory.getLogger(UsersApiController.class);
    private final ObjectMapper objectMapper;
    private final HttpServletRequest request;
    private final DatabaseDao databaseDAO;
    private final StatusAPI statusAPI;

    @Autowired
    public UsersApiController(ObjectMapper objectMapper, HttpServletRequest request, DatabaseDao databaseDAO,
                              StatusAPI statusAPI) {
        this.objectMapper = objectMapper;
        this.request = request;
        this.databaseDAO = databaseDAO;
        this.statusAPI = statusAPI;
    }

    /**
     * Get a full list of deployed server instances.
     *
     * @return
     * @throws BadRequestException
     */
    public ResponseEntity<List<Instance>> instancesGet() throws BadRequestException {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            List<Instance> instances = databaseDAO.getInstances();
            if (instances == null) {
                return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
            }
            return new ResponseEntity<>(instances, HttpStatus.OK);
        }

        throw new BadRequestException(new Exception());
    }

    /**
     * Gets the instanceid and version for a specific server instance
     *
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
                if (instance == null) {
                    return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
                }
                return new ResponseEntity<>(instance, HttpStatus.OK);

            } catch (EmptyResultDataAccessException e) {
                throw new NotFoundException(e);
            }
        }
        throw new BadRequestException(new Exception());
    }

    public ResponseEntity<Status> instancesInstanceidStatusGet(@ApiParam(value = "Name of the dl server instance",
        required = true) @PathVariable("instanceid") String instanceid) throws BadRequestException {

        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {

            Instance instance = databaseDAO.getInstanceFromId(instanceid);
            Status status = statusAPI.getStatus(instance);
            if (status == null) {
                return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
            }

            return new ResponseEntity<>(status, HttpStatus.OK);

        }
        throw new BadRequestException(new Exception());

    }

}
