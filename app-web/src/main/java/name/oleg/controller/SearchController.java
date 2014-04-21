package name.oleg.controller;

import name.oleg.controller.util.Pagination;
import name.oleg.entity.Vacancy;
import name.oleg.search.VacancySearchParam;
import name.oleg.service.VacancyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class SearchController {

    @Autowired
    private VacancyService vacancyService;

    @RequestMapping(value = "/search")
    public String search(@ModelAttribute("vacancySearchParam") VacancySearchParam vacancySearchParam, Model model) {
        Page<Vacancy> vacancyPage = vacancyService.find(0, vacancySearchParam);
        model.addAttribute("pagination", new Pagination(vacancyPage.getNumber(), vacancyPage.getTotalPages()));
        model.addAttribute("vacancies", vacancyPage.getContent());
        model.addAttribute("newestVacancies", vacancyService.findNewest());
        return "search";
    }


    @RequestMapping("/completion")
    @ResponseBody
    public String completion(@RequestParam("tagName") String tagName) {
        StringBuilder builder = new StringBuilder();
        List<String> suggestedVacancies = vacancyService.findSuggestedVacancy(tagName);
        if (!suggestedVacancies.isEmpty()) {
            builder.append("<ul id=\"live-search-results\" class=\"clearfix\">");
            for (String suggestedVacancy : suggestedVacancies) {
                builder.append("<li class=\"search-result faq\">");
                builder.append("<a href=\"/search?searchTerm=")
                        .append(suggestedVacancy)
                        .append("\">")
                        .append(suggestedVacancy)
                        .append("</a>");
                builder.append("</li>");
            }
            builder.append("</ul>");
        }
        return builder.toString();
    }
}
