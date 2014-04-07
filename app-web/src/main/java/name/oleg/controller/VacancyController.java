package name.oleg.controller;

import name.oleg.service.VacancyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class VacancyController {

    @Autowired
    private VacancyService vacancyService;

    @RequestMapping(value = "/vacancy/{id}", method = RequestMethod.GET)
    public String vacancy(@PathVariable("id") Long id, Model model) {
        model.addAttribute("vacancy", vacancyService.findById(id));
        return "vacancy";
    }
}
