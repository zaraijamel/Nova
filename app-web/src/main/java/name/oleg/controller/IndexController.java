package name.oleg.controller;

import name.oleg.entity.Vacancy;
import name.oleg.service.VacancyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class IndexController {

    @Autowired
    private VacancyService vacancyService;

    @RequestMapping("/")
    public String index() {
        List<Vacancy> all = vacancyService.findAll();
        System.err.println(all.size());
        return "index";
    }
}
