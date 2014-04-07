package name.oleg.scheduler.worker;

import name.oleg.entity.Vacancy;
import name.oleg.util.Mapper;
import name.oleg.parser.VacancyParser;
import name.oleg.parser.VacancyParserFactory;
import name.oleg.parser.VacancyParserType;
import name.oleg.parser.data.VacancyDto;
import name.oleg.parser.data.VacancyResult;
import name.oleg.scheduler.Worker;
import name.oleg.service.VacancyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class VacancyCollectorWorker implements Worker {

    @Autowired
    private VacancyService vacancyService;

    @Autowired
    private VacancyParserFactory vacancyParserFactory;

    @Autowired
    @Qualifier("vacancyMapper")
    private Mapper<VacancyDto, name.oleg.entity.Vacancy> vacancyMapper;

    @Override
    @Async
    public void work() throws Exception {
        VacancyParser vacancyParser = vacancyParserFactory.getVacancyParser(VacancyParserType.TUT_BY);
        VacancyResult vacancyResult = vacancyParser.getVacancyResult();
        List<Vacancy> vacancies = new ArrayList<Vacancy>();
        for (VacancyDto vacancyDto : vacancyResult.getVacancies()) {
            vacancies.add(vacancyMapper.fromDto(vacancyDto));
        }
        vacancyService.add(vacancies);
    }
}
