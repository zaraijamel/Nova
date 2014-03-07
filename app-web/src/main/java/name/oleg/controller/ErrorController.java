package name.oleg.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ErrorController {

    @RequestMapping("/WEB-INF/jsp/error/404.jsp")
    public String handle404() {
        return "404";
    }
}
