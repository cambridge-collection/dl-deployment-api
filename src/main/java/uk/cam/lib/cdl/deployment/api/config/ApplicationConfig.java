package uk.cam.lib.cdl.deployment.api.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import uk.cam.lib.cdl.deployment.api.dao.StatusAPI;
import uk.cam.lib.cdl.deployment.api.puppet.RemotePuppetAgent;
import uk.cam.lib.cdl.deployment.api.puppet.RemotePuppetAgentKick;

@Configuration
public class ApplicationConfig {

    @Bean
    public StatusAPI statusAPI() {
        StatusAPI statusAPI = new StatusAPI();
        return statusAPI;
    }

    @Bean
    public RemotePuppetAgent remotePuppetAgent() {
        RemotePuppetAgent agent = new RemotePuppetAgentKick();
        return agent;
    }
}
