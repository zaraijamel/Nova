package name.oleg.parser.tutby;

import name.oleg.parser.VacancyParser;
import name.oleg.parser.VacancyParserType;
import name.oleg.parser.data.*;
import org.horrabin.horrorss.RssFeed;
import org.horrabin.horrorss.RssItemBean;
import org.horrabin.horrorss.RssParser;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TutByVacancyParser implements VacancyParser {
    private static final int VACANCY_RECORD_COUNT = 2000;
    private static final int BELARUS_AREA_ID = 16;
    private static final int SEARCH_DAYS_PERIOD = 3;

    @Override
    public VacancyParserType getVacancyParserType() {
        return VacancyParserType.TUT_BY;
    }

    @Override
    public VacancyResult getVacancyResult() throws IOException {
        RssParser rss = new RssParser();
        rss.addRssModuleParser("additional", new TutByRssModuleParser());
        try {
            RssFeed feed = rss.load(getSearchQuery());
            return buildVacancyResult(feed);
        } catch (Exception e) {
            throw new IOException(e);
        }
    }

    private String getSearchQuery() {
        StringBuilder urlBuilder = new StringBuilder("http://jobs.tut.by/rss/searchvacancy.xml");
        urlBuilder.append("?orderBy=0&itemsOnPage=").append(VACANCY_RECORD_COUNT)
                .append("&areaId=").append(BELARUS_AREA_ID)
                .append("&text=&source=&noMagic=true&searchPeriod=").append(SEARCH_DAYS_PERIOD);
        return urlBuilder.toString();
    }

    @SuppressWarnings("unchecked")
    private VacancyResult buildVacancyResult(RssFeed feed) {
        List<VacancyDto> vacancies = new ArrayList<VacancyDto>();
        for (RssItemBean rssItemBean : feed.getItems()) {
            vacancies.add(buildVacancy(rssItemBean));
        }
        return new VacancyResult(vacancies);
    }

    @SuppressWarnings("unchecked")
    private VacancyDto buildVacancy(RssItemBean rssItemBean) {
        VacancyDto vacancyDto = new VacancyDto();
        vacancyDto.setTitle(rssItemBean.getTitle());
        vacancyDto.setPageContent(rssItemBean.getDescription());
        vacancyDto.setSourceLink(rssItemBean.getLink());

        TutByVacancyAdditional additional = (TutByVacancyAdditional) rssItemBean.getAdditionalInfo("additional");
        vacancyDto.setIdentifier(additional.getVacancyId());
        vacancyDto.setDescription(additional.getDescription());
        vacancyDto.setArea(additional.getAreaName());
        vacancyDto.setEntranceDate(additional.getCreationDate());

        WorkExperience workExperience = new WorkExperience();
        workExperience.setFromYears(additional.getWorkExperienceFrom());
        workExperience.setToYears(additional.getWorkExperienceTo());
        vacancyDto.setWorkExperience(workExperience);

        Employer employer = new Employer();
        employer.setIdentifier(additional.getEmployerId());
        employer.setTitle(additional.getEmployerName());
        employer.setEmail(additional.getEmployerEmail());
        employer.setLogo(additional.getEmployerLogo());
        vacancyDto.setEmployer(employer);

        Compensation compensation = new Compensation();
        compensation.setFrom(additional.getCompensationFrom());
        compensation.setTo(additional.getCompensationTo());
        compensation.setCurrency(additional.getCompensationCurrency());
        vacancyDto.setCompensation(compensation);

        ProfessionalArea professionalArea = new ProfessionalArea();
        professionalArea.setTitle(additional.getProfArea());
        vacancyDto.setProfessionalArea(professionalArea);

        return vacancyDto;
    }
}
