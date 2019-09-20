package uk.cam.lib.cdl.deployment.api;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import springfox.documentation.annotations.ApiIgnore;

/**
 * Home redirection to swagger api documentation
 */
@Controller
@ApiIgnore
public class HomeController {
    @RequestMapping(method = RequestMethod.GET, value = "/")
    public String index() {
        return "redirect:swagger-ui.html";
    }
}
