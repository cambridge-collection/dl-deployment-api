package uk.cam.lib.cdl.deployment.api.exceptions;

public class BadRequestException extends Exception {

    public BadRequestException(Exception ex) {
        super ("bad input parameter (not a valid instance name)", ex);
    }

}
