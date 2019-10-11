package uk.cam.lib.cdl.deployment.api.puppet;

import uk.cam.lib.cdl.deployment.api.model.Instance;

public interface RemotePuppetAgent {

    boolean triggerAgent(Instance instance, boolean waitForReturn);
}
