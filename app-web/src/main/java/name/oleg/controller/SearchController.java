package name.oleg.controller;

import name.oleg.controller.util.Pagination;
import name.oleg.entity.Vacancy;
import name.oleg.service.SearchCompensation;
import name.oleg.service.VacancySearchParam;
import name.oleg.service.VacancyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class SearchController {

    @Autowired
    private VacancyService vacancyService;

    @RequestMapping(value = "/search")
    public String search(@RequestParam(value = "searchTerm", required = false) String searchTerm,
                         @RequestParam(value = "tag", required = false) String tag,
                         @RequestParam(value = "page", required = false, defaultValue = "1") int page,
                         Model model) {

        VacancySearchParam vacancySearchParam = VacancySearchParam.create()
                .setSearchTerm(searchTerm)
                .setTag(tag)
                .setPage(page - 1);

        Page<Vacancy> vacancyPage = vacancyService.find(vacancySearchParam);
        model.addAttribute("pagination", new Pagination(vacancyPage.getNumber(), vacancyPage.getTotalPages()));
        model.addAttribute("vacancies", vacancyPage.getContent());
        model.addAttribute("searchTerm", searchTerm);
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
