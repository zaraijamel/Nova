package name.oleg.parser.rdw;

import name.oleg.parser.VacancyParser;
import name.oleg.parser.VacancyParserType;
import name.oleg.parser.data.VacancyDto;
import name.oleg.parser.data.VacancyResult;
import org.horrabin.horrorss.RssFeed;
import org.horrabin.horrorss.RssItemBean;
import org.horrabin.horrorss.RssParser;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class RdwVacancyParser implements VacancyParser {

    @Override
    public VacancyParserType getVacancyParserType() {
        return VacancyParserType.RDW;
    }

    private String getSearchQuery() {
        return "http://www.rdw.by/vacancies/?view=rss&params[createtime]=3&";
    }

    @Override
    public VacancyResult getVacancyResult() throws IOException {
        RssParser rss = new RssParser();
        try {
            RssFeed feed = rss.load(getSearchQuery());
            return new VacancyResult(parseVacancies(feed));
        } catch (Exception e) {
            throw new IOException(e);
        }
    }

    @SuppressWarnings("unchecked")
    private List<VacancyDto> parseVacancies(RssFeed feed) {
        List<VacancyDto> vacancies = new ArrayList<VacancyDto>();
        for (RssItemBean rssItemBean : feed.getItems()) {
            vacancies.add(buildVacancy(rssItemBean));
        }
        return vacancies;
    }

    @SuppressWarnings("unchecked")
    private VacancyDto buildVacancy(RssItemBean rssItemBean) {
        VacancyDto vacancyDto = new VacancyDto();
        vacancyDto.setTitle(rssItemBean.getTitle());
        vacancyDto.setDescription(rssItemBean.getDescription());
        vacancyDto.setPageContent(rssItemBean.getDescription());
        vacancyDto.setSourceLink(rssItemBean.getLink());
        vacancyDto.setEntranceDate(rssItemBean.getPubDate());
        return vacancyDto;
    }
}
