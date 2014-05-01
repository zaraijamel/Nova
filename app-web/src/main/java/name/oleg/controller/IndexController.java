package name.oleg.controller;

import name.oleg.entity.MailDelivery;
import name.oleg.service.MailDeliveryService;
import name.oleg.service.VacancyService;
import name.oleg.map.Coordinate;
import name.oleg.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class IndexController {

    @Autowired
    private VacancyService vacancyService;

    @Autowired
    private MailDeliveryService mailDeliveryService;

    @RequestMapping("/")
    public String index(Model model) {
        model.addAttribute("tags", vacancyService.findOftenUsageTags());
        model.addAttribute("newestVacancies", vacancyService.findNewest());
        model.addAttribute("nearestVacancies", vacancyService.findNearest(new Coordinate(1, 1)));
        return "index";
    }

    @RequestMapping(value = "/subscribe", method = RequestMethod.POST)
    public String subscribe(@RequestParam("email") String email, @RequestParam("criteria") String criteria) {
        mailDeliveryService.addSubscriber(new MailDelivery(email, StringUtil.split(criteria)));
        return "redirect:/";
    }
}
