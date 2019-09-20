package uk.cam.lib.cdl.deployment.api.exceptions;

public class NotFoundException extends Exception {

    public NotFoundException (Exception ex) {
        super ("unknown instanceid", ex);
    }

}
