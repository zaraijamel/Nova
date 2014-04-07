package name.oleg.parser.yandex;

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

public class YandexVacancyParser implements VacancyParser {
    private static final int PAGES_COUNT = 20;
    private static final int BELARUS_AREA_ID = 149;
    private static final int SEARCH_DAYS_PERIOD = 3;

    @Override
    public VacancyParserType getVacancyParserType() {
        return VacancyParserType.YANDEX_JOB;
    }

    @Override
    public VacancyResult getVacancyResult() throws IOException {
        RssParser rss = new RssParser();
        try {
            List<VacancyDto> vacancies = new ArrayList<VacancyDto>();
            for (int i = 0; i < PAGES_COUNT; i++) {
                RssFeed feed = rss.load(getSearchQuery(i));
                vacancies.addAll(parseVacancies(feed));
            }
            return new VacancyResult(vacancies);
        } catch (Exception e) {
            throw new IOException(e);
        }
    }

    private String getSearchQuery(int page) {
        StringBuilder urlBuilder = new StringBuilder("http://rabota.yandex.by/rss.xml");
        urlBuilder.append("?rid=").append(BELARUS_AREA_ID)
                .append("&page_num=").append(page)
                .append("&top_days=").append(SEARCH_DAYS_PERIOD);
        return urlBuilder.toString();
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
