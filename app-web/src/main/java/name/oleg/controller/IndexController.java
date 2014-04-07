package name.oleg.controller;

import name.oleg.service.SearchPeriod;
import name.oleg.service.VacancyService;
import name.oleg.util.Coordinate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class IndexController {

    @Autowired
    private VacancyService vacancyService;

    @RequestMapping("/")
    public String index(Model model) {
        model.addAttribute("tags", vacancyService.findOftenUsageTags());
        model.addAttribute("newestVacancies", vacancyService.findNewest());
        model.addAttribute("nearestVacancies", vacancyService.findNearest(new Coordinate(1, 1)));
        model.addAttribute("searchPeriod", SearchPeriod.values());
        return "index";
    }
}
