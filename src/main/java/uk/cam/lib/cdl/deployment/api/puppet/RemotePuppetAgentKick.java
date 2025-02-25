package uk.cam.lib.cdl.deployment.api.puppet;

import uk.cam.lib.cdl.deployment.api.model.Instance;

import java.io.IOException;

public class RemotePuppetAgentKick implements RemotePuppetAgent {

    @Override
    public boolean triggerAgent(Instance instance, boolean waitForReturn) {

        String command = "sudo puppet kick " + instance.getInstanceId();

        if (waitForReturn) {
            command += " --forground ";
        }

        try {
            Process p = Runtime.getRuntime().exec(command);
            p.waitFor();
            int value = p.exitValue();
            p.destroy();
            return (value == 0);

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        return false;
    }


}

